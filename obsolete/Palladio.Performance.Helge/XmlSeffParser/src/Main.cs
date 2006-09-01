using System;
using System.IO;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;
using Palladio.Performance.Calculator;
using Palladio.Performance.Math;
using Palladio.Performance.PerformanceCalculator;

namespace Palladio.Performance.XmlSeffParser
{
	/// <summary>
	/// Creates a service effect automaton from a xml file and calculates the performance.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: Main.cs,v $
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
		[STAThread]
		static void Main()
		{
			try
			{
				ConfigReader reader = new ConfigReader("../../../config/");
				Config configuration = reader.ReadConfig();

				IFiniteStateMachine fsm = CreateSeff(configuration);

				RandomVariable rand = CalculatePerformance(configuration, fsm);
				StoreResult(rand, configuration);
			}
			catch (Exception e)
			{
				Console.WriteLine("The performance was not computable." + e);
			}
		}

		/// <summary>
		/// Calculates the performance of the service effect automaton.
		/// </summary>
		/// <param name="configuration"></param>
		/// <param name="fsm">Service effect automaton.</param>
		/// <returns></returns>
		private static RandomVariable CalculatePerformance(Config configuration, IFiniteStateMachine fsm)
		{
//			VisitorTest test = new VisitorTest();
//			test.Init();
//			test.TestAlternativeFrequencyDomain1();
//
			RandomVariable rand = null;
			IPerformanceCalculator calculator;
			if (configuration.FrequencyDomain)
			{
				calculator = CalculatorFactory.CalculatorFrequencyDomain(configuration.Epsilon);
			}
			else
			{
				calculator = CalculatorFactory.CalculatorTimeDomain(configuration.Epsilon);
			}
			rand = calculator.CalculatePerformance(fsm);
			return rand;
		}

		/// <summary>
		/// Stores the result of the calculation.
		/// </summary>
		/// <param name="rand">Calculated function.</param>
		/// <param name="configuration">Configuration of the Parser.</param>
		private static void StoreResult(RandomVariable rand, Config configuration)
		{
			IDiscretePDFunction result = (IDiscretePDFunction) rand.ProbabilityDensityFunction.Clone();

			if (configuration.NumberOfFunctionValues != 0)
			{
				result = result.FunctionWithNValues(Convert.ToInt32(configuration.NumberOfFunctionValues));
			}
			result.Crop();
			result.SaveAsXml(configuration.PdfOutputFile);

			Console.WriteLine("Total: " + result.Sum());
			QMLAttribute qmlResult = AttributeTransformer.RandomVariable2QML(new RandomVariable(result));
			qmlResult.SaveAsXml(configuration.QmlOutputFile);
		}

		/// <summary>
		/// Creates the service effect automaton.
		/// </summary>
		/// <param name="configuration">Configuration including the path to the xml file.</param>
		/// <returns>The service effect automaton.</returns>
		private static IFiniteStateMachine CreateSeff(Config configuration)
		{
			IFiniteStateMachine fsm = null;
			try
			{
				XmlSeffParser parser = new XmlSeffParser(configuration.InputFile);
				fsm = parser.Seff;
			}
			catch (ApplicationException e)
			{
				Console.WriteLine("An exception occured.");
				Console.WriteLine(e.ToString());
				throw;
			}
			catch (FileNotFoundException)
			{
				Console.WriteLine("File not found.");
				throw;
			}
			return fsm;
		}
	}
}