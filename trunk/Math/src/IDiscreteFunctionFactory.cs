using MathNet.Numerics;
using System;

namespace Palladio.Performance.Math
{
	/// <summary>
	/// Abstract Factory pattern.
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
	public interface IDiscreteFunctionFactory : ICloneable
	{

		/// <summary>
		/// Returns the exponential distribution with a rate.
		/// This is: f(x) = (1 / rate) * exp(- x (1 / rate)).
		/// </summary>
		/// <param name="rate">Rate of the exponential distribution.</param>
		/// <returns>Exponential distribution with the specified rate and properties of the 
		/// FunctionFactory.</returns>
		IDiscreteFunction ExponentialDistribution(double rate);

		/// <summary>
		/// Returns the constant  function.
		/// This is: f(x) = c.
		/// </summary>
		/// <param name="c">Constant value for the function.</param>
		/// <returns>Function with a constant value.</returns>
		IDiscreteFunction ConstantFunction(double c);

		/// <summary>
		/// Returns the dirac function which is the neutral element
		/// of the convolution. This is:
		/// f(0) = infty and f(x) = 0 for x != 0.
		/// </summary>
		/// <returns>Dirac function of length one. Function value is 1.</returns>
		IDiscreteFunction DiracDeltaFunction();

		/// <summary>
		/// Creates a copy of a IDiscreteFunction with the parameters given by the factory.
		/// </summary>
		/// <param name="df">IDiscreteFunction wich shall be copied.</param>
		/// <returns>Copied IDiscreteFunction.</returns>
		IDiscreteFunction Copy(IDiscreteFunction df);

		/// <summary>
		/// Precision for the created functions.
		/// </summary>
		int SamplingRate { get; set; }

		/// <summary>
		/// Default maximum for the greatest x value that has an associated function value.
		/// </summary>
		int XMax { get; set; }

		/// <summary>
		/// Default minimum for the smallest x value that has an associated function value.
		/// </summary>
		int XMin { get; set; }

		/// <summary>
		/// Creates a new function using a set of values. The sampling rate
		/// for those values must correspond to the sampling rate of the factory.
		/// Also the start value must be a multiple of the sampling rate.
		/// </summary>
		/// <param name="xStart">Position on the x axis for the first value in the value array.</param>
		/// <param name="values">Ordered set of values describing the function.</param>
		/// <param name="samplingrate">Distance of two values.</param>
		/// <returns></returns>
		IDiscreteFunction DiscreteValueFunction(long xStart, long samplingrate, double[] values);

		/// <summary>
		/// Creates a new probability density function using a set of values. 
		/// </summary>
		/// <param name="xStart">Position on the x axis for the first value in the value array.</param>
		/// <param name="samplingrate">Distance of two values.</param>
		/// <param name="values">Ordered set of values describing the function.</param>
		/// <returns></returns>
		IDiscretePDFunction DiscreteValuePDFunction(long xStart, long samplingrate, double[] values);

		/// <summary>
		/// Creates a new probability density function. The fourier function is transformed back to the
		/// time domain.
		/// </summary>
		/// <param name="ff">Function in frequency domain.</param>
		/// <returns>Function in time domain.</returns>
		IDiscretePDFunction DiscreteValuePDFunction(IFourierFunction ff);
		
		/// <summary>
		/// Creates a new probability density function using a set of values. 
		/// </summary>
		/// <param name="df">Function which contains the probability density function.</param>
		/// <returns></returns>
		IDiscretePDFunction DiscreteValuePDFunction(IDiscreteFunction df);


		/// <summary>
		/// Creates a new fourier function. It is assumed, that the complex values are the fourier 
		/// transformed values.
		/// </summary>
		/// <param name="values">Already fourier transformed values</param>
		/// <param name="samplingrate">Sampling rate of the function.</param>
		/// <returns>Function in frequency domain.</returns>
		IFourierFunction DiscreteFourierFunction(Complex[] values, long samplingrate);

		/// <summary>
		/// Creates a new fourier function. 
		/// </summary>
		/// <param name="dg">Function in time domain.</param>
		/// <returns>Function in frequency domain.</returns>
		IFourierFunction DiscreteFourierFunction(IDiscreteFunction dg);
	}


}
