using System;
using System.Xml;

namespace Palladio.Performance.XmlSeffParser
{
	/// <summary>
	/// Class for reading the configuration of the XmlSeffParser.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: ConfigReader.cs,v $
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
	public class ConfigReader
	{
		string pathToConfigFile;
		XmlDocument doc = new XmlDocument();

		/// <summary>
		/// Constructor.
		/// </summary>
		/// <param name="path">Path to the configuration file.</param>
		public ConfigReader(string path)
		{
			pathToConfigFile=path;
		}


		/// <summary>
		/// Reads the configuration file and returns the configuration.
		/// </summary>
		/// <returns>Configuration of the XmlSeffParser.</returns>
		public Config ReadConfig()
		{
			doc.Load(pathToConfigFile+"XmlSeffParserConfig.xml");
			string inputFile = doc.GetElementsByTagName("InputFile").Item(0).InnerText;
			string qmlOutputFile = doc.GetElementsByTagName("QmlOutputFile").Item(0).InnerText;
			string pdfOutputFile = doc.GetElementsByTagName("PdfOutputFile").Item(0).InnerText;
			double epsilon = GetEpsilon();
			bool frequencyDomain=Convert.ToBoolean(doc.GetElementsByTagName("FrequencyDomain").Item(0).InnerText);
			int numberOfFunctionValues = GetNumberOfFunctionValues();
			return new Config(inputFile, qmlOutputFile,pdfOutputFile, epsilon, frequencyDomain, numberOfFunctionValues);
		}

		private int GetNumberOfFunctionValues()
		{
			try
			{
				int numberOfFunctionValues = 
					Convert.ToInt32(doc.GetElementsByTagName("NumberOfFunctionValues").Item(0).InnerText);
				if (numberOfFunctionValues<0)
					throw new ApplicationException("numberOfFunctionValues must be positive.");
				return numberOfFunctionValues;
			}
			catch (FormatException e)
			{
				Console.WriteLine("numberOfFunctionValues is not an integer. " +e);
				throw;
			}
		}

		private double GetEpsilon()
		{
			try
			{
				double epsilon = 
					Convert.ToDouble(ConvertToDoubleString(doc.GetElementsByTagName("Epsilon").Item(0).InnerText));
				if(epsilon<=0 || epsilon >=1)
					throw new ApplicationException("Epsilon must be a value in ]0,1[.");
				return epsilon;
			}
			catch (FormatException e)
			{
				Console.WriteLine("The value for epsilon is not a double. " +e);
				throw;
			}
		}

		/// <summary>
		/// Replaces the "." with a ","
		/// </summary>
		/// <param name="s"></param>
		/// <returns></returns>
		private string ConvertToDoubleString(string s)
		{
			return s.Replace(".", ",");
		}

	}
}
