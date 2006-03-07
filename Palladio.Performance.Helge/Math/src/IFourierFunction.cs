using System;
using MathNet.Numerics;

namespace Palladio.Performance.Math
{
	/// <summary>
	/// Fourier transformed function. The data array must be big enough to hold all calculated values, because
	/// a redimensioning of the array in frequency space leads to wrong results.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: IFourierFunction.cs,v $
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
	public interface IFourierFunction : ICloneable
	{
		/// <summary>
		/// Values defining the function.
		/// </summary>
		Complex[] Data {get;}

		/// <summary>
		/// Distance between two values.
		/// </summary>
		long SamplingRate {get;}

		/// <summary>
		/// Minimum value on the x-axis.
		/// </summary>
		long xMin {get;}

		/// <summary>
		/// Multiplication of each pair of elements. Both functions must have the same length.
		/// </summary>
		/// <param name="ff">IFourierFunction to be multiplied with this.</param>
		/// <returns>New IFourierFunction holding the result of the multiplication.</returns>
		IFourierFunction Multiply (IFourierFunction ff);

		/// <summary>
		/// Addition of each pair of elements. Both functions must have the same length.
		/// </summary>
		/// <param name="ff">IFourierFunction to be added with this.</param>
		/// <returns>New IFourierFunction holding the result of the addition.</returns>
		IFourierFunction Add (IFourierFunction ff);

		/// <summary>
		/// Returns a copy of the function sclaed by <c>factor</c>
		/// </summary>
		/// <param name="factor">Scaling factor.</param>
		/// <returns>New scaled IFourierFunction.</returns>
		IFourierFunction GetScaled (double factor);

		/// <summary>
		/// Computes the execution time of a loop. This is an approximation which depends on the size 
		/// of the data array.
		/// </summary>
		/// <param name="p">Probability of re-iterating through the loop.</param>
		/// <returns>The fourier function of the loop limit.</returns>
		IFourierFunction ComputeLoopLimit(double p);

	}
}