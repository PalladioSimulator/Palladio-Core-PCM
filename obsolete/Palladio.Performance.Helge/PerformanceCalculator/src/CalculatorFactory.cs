using Palladio.Performance.PerformanceCalculator;

namespace Palladio.Performance.Calculator
{
	/// <summary>
	/// Zusammenfassung für CalculatorFactory.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: CalculatorFactory.cs,v $
	/// Revision 1.1  2005/08/12 07:59:20  helgeh
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
	public class CalculatorFactory
	{
		/// <summary>
		/// Returns a new <c>IPerformanceCalculator</c> for the time domain.
		/// </summary>
		/// <param name="epsilon">Precision of the loop calculation.</param>
		/// <returns><c>IPerformanceCalculator</c> for the time domain.</returns>
		public static IPerformanceCalculator CalculatorTimeDomain(double epsilon)
		{
			IPerformanceCalculator calculator = new Calculator(epsilon,false);
			return calculator;
		}

		/// <summary>
		/// Returns a new <c>IPerformanceCalculator</c> for the frequency domain.
		/// </summary>
		/// <param name="epsilon">Precision of the loop calculation.</param>
		/// <returns><c>IPerformanceCalculator</c> for the frequency domain.</returns>
		public static IPerformanceCalculator CalculatorFrequencyDomain(double epsilon)
		{
			IPerformanceCalculator calculator = new Calculator(epsilon ,true);
			return calculator;
		}
	}
}
