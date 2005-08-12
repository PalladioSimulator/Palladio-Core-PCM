using System;
using System.IO;

namespace Palladio.Performance.Math
{
	/// <summary>
	/// A Class for discrete value function. The discrete values are hold in an arrayand are
	/// equidistant with the  distance between two values in the array is given
	/// by the sampling rate. So the x-value for index data[i] is xmin + i*samplingrate.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/08/12 07:59:19  helgeh
	/// Initial impot after refactoring.
	///
	/// Math:
	/// - Added DiscretePDFunction.
	/// - Added Fast Fourier Transformation and FourierFunction.
	/// - Changed operations of DiscreteFunction. The operations are independent of the sampling rate. For a probability density  function the sum of function values is a value in [0,1].
	/// - Added to interface IDiscreteFunction: Sum,ExpandDomainPo2, Crop, NumberOfNullValues, AdjustSamplingRate,  FunctionWithNValues, ToFile, ValueAt, DismissValuesSmalerThanN, ValueOf, MaximumDataValue
	/// - Altered MEthods: ExpandDomain, Scale, GetScaled, Convolution, Add
	///
	/// FSMTransformer:
	/// - Method SEFFValidity added.
	/// - The Method FSMWithIntermediateState now returns a FSM, where all time consumption is contained by the input symbols of the  transitions.
	///
	/// WebserverSeffFactory:
	/// - All service effect automaton are now IFiniteStateMachines. No use of the PAlladio.ComponentModel.
	///
	/// WebserverAnalyser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// RegExASTVisitor:
	/// - There are now two visitors. One for the calculation in time domain and one for the calculation in frequency domain.
	///
	/// RegularExpressions:
	/// - No changes.
	///
	/// XmlSeffParser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// PerformanceCalculator:
	/// - Added interface IPerformanceCalculator. Added CalculatorFactory.
	///
	/// Unit Tests added.
	/// Updated documentation.
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IDiscreteFunction : ICloneable
	{
		/// <summary>
		/// Values defining the function.
		/// </summary>
		double[] Data {get;}

		/// <summary>
		/// Number of discrete function values.
		/// </summary>
		int Count { get; }

		/// <summary>
		/// Precision of the  disctrete function x[n]. Distance between
		/// two discrete values on the x-axis.
		/// </summary>
		long SamplingRate {get; set;}

		/// <summary>
		/// First x value for which this function is defined.
		/// </summary>
		long XMin {get;}

		/// <summary>
		/// Last x value for which this function is defined.
		/// </summary>
		long XMax {get;}

		/// <summary>
		/// Returns the sum of all function values.
		/// </summary>
		/// <returns>Sum of all function values.</returns>
		double Sum();


		/// <summary>
		/// Expands the domain of the function to the new value of xMax. If xMax is not a multiple of the
		/// samplingrate, it is set to the next multiple.
		/// All new values are set to zero.
		/// </summary>
		/// <param name="xMax">New maximum x-value. If the value is smaller than the old xMax 
		/// a ApplicationException is thrown.</param>
		void ExpandDomain(long xMax);

		/// <summary>
		/// Expands the domain of the function to the new value of xMax and xMin. If xMax or xMin are not a multiple
		/// of the samplingrate, they are set to the next multiple. 
		/// All new values are set to zero.
		/// </summary>
		/// <param name="xMax">New maximum x-value. If the value is smaller than the old xMax 
		/// an ApplicationException is thrown.</param>
		/// <param name="xMin">New minimum x-value. If the value is bigger than the old xMin
		///  anApplicationException is thrown.</param>
		void ExpandDomain(long xMin ,long xMax);

		/// <summary>
		/// Expands the domain of the function to the new value of xMax and xMin. If xMax or xMin are not a multiple
		/// of the samplingrate, they are set to the next multiple. 
		/// Furthermore additional values are added, so the size of the function becomes a power of 2.
		/// All new values are set to zero.
		/// </summary>
		/// <param name="xMax">New maximum x-value. If the value is smaller than the old xMax 
		/// an ApplicationException is thrown.</param>
		/// <param name="xMin">New minimum x-value. If the value is bigger than the old xMin
		///  anApplicationException is thrown.</param>
		void ExpandDomainPo2(long xMin ,long xMax);

		/// <summary>
		/// Removes 0-Values at beginning and end.
		/// </summary>
		void Crop();

		/// <summary>
		/// Return the number of values which probability is 0.
		/// </summary>
		/// <returns>Number of values.</returns>
		int NumberOfNullValues ();

		/// <summary>
		/// Adjust the function to a new SamplingRate. 
		/// The new Sampling rate must be a multiple or a divisor of the old one. The size of the data
		/// array is adjusted hold the values.
		/// </summary>
		/// <param name="newSR">The new sampling rate.</param>
		void AdjustSamplingRate(long newSR);

		/// <summary>
		/// Create a Function with n values. The sampling rate will be adjusted
		/// </summary>
		/// <param name="numberOfValues">Number of values for the new function.</param>
		IDiscreteFunction FunctionWithNValues(int numberOfValues);

		/// <summary>
		/// Writes the function to a file.
		/// </summary>
		/// <param name="sw"></param>
		void ToFile(StreamWriter sw);

		/// <summary>
		/// Returns the time value (value on the x-axis) of the specified index.
		/// </summary>
		/// <param name="index">Index of the data array.</param>
		/// <returns>Time for which the data array contains the probability or -1 if index is out of range.</returns>
		long ValueAt(int index) ;
		
		/// <summary>
		/// Eleminates values at beginning and end of the data array whose probability is smaller than n.
		/// </summary>
		/// <param name="n">Threashhold probability. Smaller values shall be eleminated.</param>
		void DismissValuesSmalerThanN(double n);

		/// <summary>
		/// Scales this function by a.
		/// </summary>
		/// <param name="a">Scaling parameter.</param>
		void Scale(double a);

		/// <summary>
		/// Returns a copy of the function scaled by the given factor.
		/// </summary>
		/// <param name="factor">Factor with which the data is scaled.</param>
		/// <returns>Copy of the function scaled by factor.</returns>
		IDiscreteFunction GetScaled(double factor);


		/// <summary>
		/// Convolution for discrete Functions. The two functions must have the same SamplingRate. 
		/// </summary>
		/// <param name="dg">IDiscreteFunction dg for the convolution with the object.</param>
		/// <returns>A new Function containing the result of the operation.</returns>
		IDiscreteFunction Convolution(IDiscreteFunction dg);

		/// <summary>
		/// Adds a function to this.
		/// </summary>
		/// <param name="dg">Function to be added.</param>
		/// <returns>A new Function containing the result of the operation.</returns>
		IDiscreteFunction Add(IDiscreteFunction dg);

		/// <summary>
		/// Adds a function g scaled by a to the existing function.
		/// </summary>
		/// <param name="a">Sclaing factor.</param>
		/// <param name="g">Function to add.</param>
		/// <returns>A new Function containing the result of the operation.</returns>
		IDiscreteFunction AddScaled(double a, IDiscreteFunction g);


		/// <summary>
		/// Multiplies this function with another function.
		/// </summary>
		/// <param name="dg">Function to be multiplied with this.</param>
		/// <returns>A new Function containing the result of the operation.</returns>
		IDiscreteFunction Multiply(IDiscreteFunction dg);

		/// <summary>
		/// Returns the function value of x, that is f(x). 
		/// </summary>
		/// <param name="x">Value on the x-axis.</param>
		/// <returns>f(x) if x is a multiple of the samplingrate. Otherwise an ApplicationException
		///  is thown.</returns>
		double ValueOf(long x);

		/// <summary>
		/// Returns the maximum value of the function.
		/// </summary>
		/// <returns>The maximum value of the function.</returns>
		double MaximunDataValue();

	}
}
