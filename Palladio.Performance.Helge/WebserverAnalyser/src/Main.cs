using System;
using System.Reflection;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;
using Palladio.Performance.Calculator;
using Palladio.Performance.Math;
using Palladio.Performance.PerformanceCalculator;
using Palladio.Performance.WebserverSeff;
using Measure = Palladio.Performance.Measurement.Measure;

namespace Palladio.Performance.WebserverAnalyser
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: Main.cs,v $
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
	class MainClass
	{
		/// <summary>
		/// Der Haupteinstiegspunkt für die Anwendung.
		/// </summary>
		[STAThread]
		static void Main()
		{
			//AnalyseWebserver("../../../config/WebserverAnalyserConfig1.xml");
//			AnalyseWebserver("../../../config/WebserverAnalyserConfig2.xml");
//			AnalyseWebserver("../../../config/WebserverAnalyserConfig3.xml");
//			AnalyseWebserver("../../../config/WebserverAnalyserConfig4.xml");
			AnalyseWebserver("../../../config/WebserverAnalyserConfig.xml");
		}

		private static void AnalyseWebserver(string configFile)
		{
			ConfigReader reader = new ConfigReader(configFile);
			Config configuration = reader.ReadConfig();
	
			IFiniteStateMachine fsm = CreateSeffWithAttributes(configuration);
	
			//XmlFileCreator.SavesSeffAsXml(configuration.SeffOutputFile, fsm);
	
			ComputeAndWriteFile(fsm, configuration);
		}


		/// <summary>
		/// Creates the seff with attributes.
		/// </summary>
		/// <param name="configuration">Configuration of the WebserverAnalyser.</param>
		/// <returns>Seff with attributes.</returns>
		private static IFiniteStateMachine CreateSeffWithAttributes(Config configuration)
		{
			Measure.Hrt.Start();
			Measure.Hrt.Stop();
			SeffWithAttributeCreator seffCreator =
				new SeffWithAttributeCreator(configuration.MeasureFile, configuration.Samplingrate);
/*	
			IWebserverSeffFactory seffFactory = new WebserverSeffFactory();
			Type t = typeof (IWebserverSeffFactory);
			MethodInfo m = t.GetMethod("CreateSeff_" + configuration.SeffName);
			IFiniteStateMachine fsm = (IFiniteStateMachine) m.Invoke(seffFactory, new object[] {});
*/	
			IWebAudioStoreSeffFactory seffFactory = new WebAudioStoreSeffFactory();
			Type t = typeof (IWebAudioStoreSeffFactory);
			MethodInfo m = t.GetMethod("CreateSeff_" + configuration.SeffName);
			IFiniteStateMachine fsm = (IFiniteStateMachine) m.Invoke(seffFactory, new object[] {});
			
			fsm = seffCreator.AddAttributesToSeff(fsm, configuration.ServiceName);
			Measure.Hrt.Stop();
			Console.WriteLine(Measure.GetTimeHrt());
			return fsm;
		}

		/// <summary>
		/// Computes the performance of the Seff and stores the result.
		/// </summary>
		/// <param name="fsm"></param>
		/// <param name="configuration"></param>
		private static void ComputeAndWriteFile(IFiniteStateMachine fsm, Config configuration)
		{
			RandomVariable result = null;
			try
			{
				IPerformanceCalculator calculator;
				if(configuration.FrequencyDomain)
				{
					calculator = CalculatorFactory.CalculatorFrequencyDomain(configuration.Epsilon);
				} else
				{
					calculator = CalculatorFactory.CalculatorTimeDomain(configuration.Epsilon);
				}
					
				Measurement.Measure.Hrt.Start();
				result = calculator.CalculatePerformance(fsm);
				Measurement.Measure.Hrt.Stop();
				Console.WriteLine("Calculation finished. Calculation took " 
					+ Measurement.Measure.GetTimeHrt());
			}
			catch (ApplicationException e)
			{
				Console.WriteLine
					("The toal performance was not computable." +e);
				throw;
			}
			StoreResult(result, configuration, fsm);
		}

		/// <summary>
		/// Stores the result.
		/// </summary>
		/// <param name="result"></param>
		/// <param name="configuration"></param>
		/// <param name="fsm"></param>
		private static void StoreResult(RandomVariable result, Config configuration, IFiniteStateMachine fsm)
		{
			IDiscreteFunction resultFunction = result.ProbabilityDensityFunction;
	
			if (configuration.NumberOfFunctionValues != 0)
				resultFunction = resultFunction.FunctionWithNValues(configuration.NumberOfFunctionValues);
	
			Measurement.Measure.Hrt.Start();
			XmlFileCreator.CreateXmlFile(configuration,fsm,result);
			Measurement.Measure.Hrt.Stop();

			Console.WriteLine("CreateXmlFile took " + Measure.GetTimeHrt());
		}
	}
}