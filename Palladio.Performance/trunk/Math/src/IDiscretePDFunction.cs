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
	public interface IDiscretePDFunction : IDiscreteFunction 
	{
		/// <summary>
		/// Sum of all probabilities.
		/// </summary>
		double TotalProb{get;}

		/// <summary>
		/// Median og the function.
		/// </summary>
		double Median {get;}

		/// <summary>
		/// Returns the time value of the upper quartil(75%).
		/// </summary>
		double UpperQuartil {get;}

		/// <summary>
		/// Expectancy of the function.
		/// </summary>
		double Expectancy {get;}

		/// <summary>
		/// Variance of the function. This is s^2=(1/n) * sum_1_n[(x_i - expectancy)^2]
		/// </summary>
		double Variance{get;}

		/// <summary>
		/// Deviation of a function. This is SQRT(Variance)
		/// </summary>
		double Deviation{get;}

		/// <summary>
		/// Stores the probability density function as file.
		/// </summary>
		/// <param name="file">Name of the file.</param>
		void SaveAsXml(string file);

		/// <summary>
		/// Create a Function with n values. The sampling rate will be adjusted
		/// </summary>
		/// <param name="numberOfValues">Number of values for the new function.</param>
		new IDiscretePDFunction FunctionWithNValues(int numberOfValues);
	}
}
