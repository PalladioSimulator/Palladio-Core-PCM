using System;
using System.Xml;

namespace Palladio.Performance.WebserverAnalyser
{
	/// <summary>
	/// Class for reading the configuration.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: ConfigReader.cs,v $
	/// Revision 1.2  2005/10/11 22:05:14  helgeh
	/// - Added NUnit project and NDoc documentation.
	/// - fixed a bug in AdjustSamplingRate
	///
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
	internal class ConfigReader
	{
		string configFile;
		XmlDocument doc = new XmlDocument();

		internal ConfigReader(string configFile)
		{
			this.configFile=configFile;
		}

		/// <summary>
		/// Reads the configuration file and returns the configuration.
		/// </summary>
		/// <returns>Configuration of the XmlSeffParser.</returns>
		internal Config ReadConfig()
		{
			doc.Load(configFile);
			string filepath = GetValueOfTag("FilePath");
			string measureFile = GetValueOfTag("MeasureFile");
			string serviceName = GetValueOfTag("ServiceName");
			string seffName = GetValueOfTag("Seff");
			string seffOutputFile = GetValueOfTag("SeffOutputFile");
			string storeFile = GetValueOfTag("StoreFile");
			double epsilon = Convert.ToDouble(GetValueOfTag("Epsilon"));
			bool frequencyDomain = Convert.ToBoolean(GetValueOfTag("FrequencyDomain"));
			int samplingrate = Convert.ToInt32(GetValueOfTag("Samplingrate"));
			int numberOfFunctionValues = Convert.ToInt32(GetValueOfTag("NumberOfFunctionValues"));

			return new Config(filepath,measureFile,serviceName, seffName, seffOutputFile,storeFile,epsilon,
				frequencyDomain, samplingrate, numberOfFunctionValues);
		}

		/// <summary>
		/// Returns the value of the specified tag.
		/// </summary>
		/// <param name="tag">Tag for which the value is requested.</param>
		/// <returns>Value of the tag.</returns>
		private string GetValueOfTag(string tag)
		{
			return doc.GetElementsByTagName(tag).Item(0).InnerText;
		}
	}
}
