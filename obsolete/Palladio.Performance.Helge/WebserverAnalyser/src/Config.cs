namespace Palladio.Performance.WebserverAnalyser
{
	/// <summary>
	/// Class containing the configuration data for the WebserverAnalyser.
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
	internal class Config
	{
		#region Data
		/// <summary>
		/// Samplingrate of the generated <c>RandomVariable</c>s.
		/// </summary>
		private int samplingrate;

		/// <summary>
		/// Path to all files.
		/// </summary>
		private string filepath;

		/// <summary>
		/// Name of the service to analyse.
		/// </summary>
		private string serviceName;

		/// <summary>
		/// Name of the service effect automaton.
		/// </summary>
		private string seffName;

		/// <summary>
		/// File for saving the generated service effect automaton.
		/// </summary>
		private string seffOutputFile;

		/// <summary>
		/// Precision of the loop calculation.
		/// </summary>
		private double epsilon;

		/// <summary>
		/// File containing the measured data.
		/// </summary>
		private string measureFile;

		/// <summary>
		/// File for saving the the time consumption of all states and transitions and result
		/// of the calculation.
		/// </summary>
		private string storeFile;

		/// <summary>
		/// Boolean for determine domain of the calculation. True means a calculation in frequency domain.
		/// False means a calculation in time domain.
		/// </summary>
		private bool frequencyDomain;

		/// <summary>
		/// Number of function values for the resultinf function.
		/// </summary>
		private int numberOfFunctionValues;

		#endregion Data

		#region Properties
		/// <summary>
		/// Samplingrate of the generated <c>RandomVariable</c>s.
		/// </summary>
		public int Samplingrate
		{
			get { return samplingrate; }
		}

		/// <summary>
		/// Path to all files.
		/// </summary>
		public string Filepath
		{
			get { return filepath; }
		}

		/// <summary>
		/// File for saving the generated service effect automaton.
		/// </summary>
		public string SeffOutputFile
		{
			get { return seffOutputFile; }
		}

		/// <summary>
		/// Precision of the loop calculation.
		/// </summary>
		public double Epsilon
		{
			get { return epsilon; }
		}

		/// <summary>
		/// File containing the measured data.
		/// </summary>
		public string MeasureFile
		{
			get { return measureFile; }
		}

		/// <summary>
		/// File for saving the the time consumption of all states and transitions and result
		/// of the calculation.
		/// </summary>
		public string StoreFile
		{
			get { return storeFile; }
		}

		/// <summary>
		/// Boolean for determine domain of the calculation. True means a calculation in frequency domain.
		/// False means a calculation in time domain.
		/// </summary>
		public bool FrequencyDomain
		{
			get { return frequencyDomain; }
		}

		/// <summary>
		/// Name of the service to analyse.
		/// </summary>
		public string ServiceName
		{
			get { return serviceName; }
		}

		/// <summary>
		/// Name of the service effect automaton.
		/// </summary>
		public string SeffName
		{
			get { return seffName; }
		}

		/// <summary>
		/// Number of function values for the resultinf function.
		/// </summary>
		public int NumberOfFunctionValues
		{
			get { return numberOfFunctionValues; }
		}

		#endregion Properties

		#region Constructor

		public Config(string filePath, string measureFile, string serviceName, string seffName,
			string seffOutputFile,string storeFile, double epsilon, bool frequencyDomain, int samplingrate,
			int numberOfFunctionValues)
		{
			this.filepath=filePath;
			this.measureFile=filePath + measureFile;
			this.serviceName=serviceName;
			this.seffName=seffName;
			this.seffOutputFile=filePath + seffOutputFile;
			this.storeFile=filePath + storeFile;
			this.epsilon=epsilon;
			this.frequencyDomain=frequencyDomain;
			this.samplingrate=samplingrate;
			this.numberOfFunctionValues=numberOfFunctionValues;
		}

		#endregion Constructor
	}
}
