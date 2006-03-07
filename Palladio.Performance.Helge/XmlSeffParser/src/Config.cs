namespace Palladio.Performance.XmlSeffParser
{
	/// <summary>
	/// Configuration of the XmlSeffParser.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: Config.cs,v $
	/// Revision 1.1  2005/08/12 07:59:25  helgeh
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
	public class Config
	{
		private string inputFile, qmlOutputFile;
		private string pdfOutputFile;
		private double epsilon;
		private bool frequencyDomain;
		private int numberOfFunctionValues;

		/// <summary>
		/// Number of function values for the resultinf function.
		/// </summary>
		public int NumberOfFunctionValues
		{
			get
			{
				return numberOfFunctionValues;
			}
		}

		/// <summary>
		/// File of the service effect automaton.
		/// </summary>
		public string InputFile
		{
			get
			{
				return inputFile;
			}
		}
		/// <summary>
		/// File to store the result as qml ascpects.
		/// </summary>
		public string QmlOutputFile
		{
			get
			{
				return qmlOutputFile;
			}
		}

		/// <summary>
		/// Stop criterion for calculation of the loop.
		/// </summary>
		public double Epsilon
		{
			get
			{
				return epsilon;
			}
		}

		/// <summary>
		/// The domain for the calculation. If Domain==true, then the calculation is executed in frequency 
		/// domain. If the value is false, the calculation is executed in time domain.
		/// </summary>
		public bool FrequencyDomain
		{
			get
			{
				return frequencyDomain;
			}
		}

		/// <summary>
		/// File to store the result as probability density function.
		/// </summary>
		public string PdfOutputFile
		{
			get { return pdfOutputFile; }
		}

		/// <summary>
		/// Constructor.
		/// </summary>
		/// <param name="inputFile">File of the service effect automaton.</param>
		/// <param name="qmlOutputFile">File to store the result as Qml aspects.</param>
		/// <param name="pdfOutputFile">File to store the result as probability density function.</param>
		/// <param name="epsilon">Stop criterion for the calculation of the loop.</param>
		/// <param name="domain">True=frequency domain, false= time domain</param>
		/// <param name="numberOfFunctionValues">Number of function values of the result.</param>
		public Config(string inputFile, string qmlOutputFile, string pdfOutputFile, double epsilon, bool domain, int numberOfFunctionValues)
		{
			this.inputFile=inputFile;
			this.qmlOutputFile=qmlOutputFile;
			this.pdfOutputFile=pdfOutputFile;
			this.epsilon=epsilon;
			this.frequencyDomain=domain;
			this.numberOfFunctionValues=numberOfFunctionValues;
		}
	}
}
