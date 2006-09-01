using System;
using MathNet.Numerics;


namespace Palladio.Performance.Math
{
	/// <summary>
	/// 
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
	public interface IFunction : IRealFunction, ICloneable
	{
		/// <summary>
		/// Scales this function by a.
		/// </summary>
		/// <param name="a"></param>
		void Scale(double a);

		/// <summary>
		/// Returns this function scaled by a.
		/// </summary>
		/// <param name="a"></param>
		/// <returns></returns>
		IFunction GetScaled(double a);

		/// <summary>
		/// Creates the convolution of this function with
		/// a Function.
		/// </summary>
		IDiscreteFunction Convolution(IRealFunction g);

		/// <summary>
		/// Adds aFunction to this function.
		/// </summary>
		void Add(IRealFunction g);

		/// <summary>
		/// Adds a * g(x) to this function.
		/// </summary>
		void AddScaled(double a, IRealFunction g);

		/// <summary>
		/// Returns the multiplication of this function by g.
		/// </summary>
		void Multiply(IRealFunction g);

		/// <summary>
		/// Returns the probability of the specified 
		/// </summary>
		/// <param name="time">The time for which the probability is returned.</param>
		/// <returns>Probability of the specified time. If no entry exists for the time, t0 is returned.</returns>
		double ValueOf(long time);
	}
}
