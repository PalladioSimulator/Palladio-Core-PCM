using System;
using System.Globalization;
using System.IO;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.RegularExpressions;
using Palladio.Reliability.Math;
using Palladio.Reliability.Attributes;
using Palladio.Reliability.DatabaseSchema;
using Palladio.Reliability.RegexASTVisitor;
using Palladio.Reliability.WebserverComponentModel;

namespace Palladio.Reliability.WebserverAnalyser
{
	/// <summary>
	/// </summary>
	public class MainClass
	{
		private const string CONNECTION_STRING = "workstation id=INSPIRON;packet size=4096;integrated security=SSPI;data source=localhost;persist security info=False;initial catalog=ReliabilityDB";

		/// <summary>
		/// </summary>
		[STAThread]
		private static void Main(string[] args)
		{
			ClearDatabase();
			AnalyseData();
			
			PrintResults();

			IDiscreteFunction pdf = ComputeExecutionTime();
			PrintPdfForMatlab("computed.m", pdf);

			PrintResultsForMatlab();

			Console.WriteLine("Press Return to exit.");
			Console.ReadLine();
		}

		private static void PrintResultsForMatlab()
		{
			string interfaceName = "IHTTPRequestProcessor";
			string methodName = "HandleRequest";
			IBasicComponent component = WebserverComponentFactory.CreateStaticFileProvider();
			Console.WriteLine(component.Name + "\t" + interfaceName + "." + methodName);

			CompTimesAttribute compTimes = CompTimesAttribute.GetAttribute(component);
			MeasuredTimeAttribute measuredTime = compTimes.GetTime(interfaceName, methodName);
			IDiscreteFunction measured = measuredTime.ProbabilityDensityFunction as IDiscreteFunction;

			PrintPdfForMatlab("measured.m", measured);
		}

		private static void PrintPdfForMatlab(string fileName, IDiscreteFunction pdf)
		{
			CultureInfo ci = new CultureInfo("en-US",false);
			IFormatProvider prov = ci.NumberFormat;

			string x = "x = [";
			string y = "y = [";
			double xPos = 0;
			double xInc = pdf.SamplingRate;
			int max = GetLastValueOfInterest(pdf.Data);
			for(int i=0; i<=max; i++)
			{
				if (i != 0)
				{
					x += ", ";
					y += ", ";
				}
				x += System.Math.Round(xPos,4).ToString(prov);
				y += System.Math.Round(pdf.Data[i], 4).ToString(prov);
				xPos += xInc;
			}
			x += "];";
			y += "];";

			StreamWriter sw;
			using (sw = File.CreateText(fileName))
			{
				sw.WriteLine(x);
				sw.WriteLine(y);
			}
		}

		private static int GetLastValueOfInterest(double[] data)
		{
			int lastValOfIntrest = data.Length - 1;
			double minVal = 0.00001;
			for (int i = data.Length-1; i >= 0; i--)
			{
				lastValOfIntrest = data[i] < minVal ? i : lastValOfIntrest;
			}
			return lastValOfIntrest;
		}

		private static IDiscreteFunction ComputeExecutionTime()
		{
			IBasicComponent comp = WebserverComponentFactory.CreateStaticFileProvider();
			IServiceEffectSpecification seff = WebserverModelHelper.FindServiceEffectSpecification(comp, "IHTTPRequestProcessor", "HandleRequest");
			return ComputeExecutionTimeForSeff(seff);
		}

		private static IDiscreteFunction ComputeExecutionTimeForSeff(IServiceEffectSpecification seff)
		{
			if (seff == null)
				return null;
			IFSMServiceEffect fsmSeff = (IFSMServiceEffect) seff.GetServiceInformation(typeof (IFSMServiceEffect));
			IFiniteStateMachine iFSM = FSMTransformer.FSMTransformer.FSMWithIntermediateState(fsmSeff.FSM);
			IFiniteStateMachine aFSM = FSMTransformer.FSMTransformer.FSMAcceptingStateSequence(iFSM);
			IFiniteStateMachine uFSM = FSMTransformer.FSMTransformer.UniqueInputSymbolForTransitions(aFSM);
			IRegEx regex = RegexFactory.FSMToRegex(uFSM);
			ASTVisitor visitor = new ASTVisitor(regex);
			return visitor.TimePdf;
		}

		private static void PrintResults()
		{
			IBasicComponent comp = WebserverComponentFactory.CreateStaticFileProvider();
			IServiceEffectSpecification seff = WebserverModelHelper.FindServiceEffectSpecification(comp, "IHTTPRequestProcessor", "HandleRequest");
			PrintSeff(seff);
			PrintExecTime(comp, "IHTTPRequestProcessor", "HandleRequest");
		}

		private static void PrintExecTime(IComponent component, string interfaceName, string methodName)
		{
			Console.WriteLine(component.Name + "\t" + interfaceName + "." + methodName);

			CompTimesAttribute compTimes = CompTimesAttribute.GetAttribute(component);
			MeasuredTimeAttribute measuredTime = compTimes.GetTime(interfaceName, methodName);
			IDiscreteFunction pdf = measuredTime.ProbabilityDensityFunction as IDiscreteFunction;
			double sum = 0;
			for (int i = 0; i < pdf.Data.Length; i++)
			{
				sum += pdf.Data[i];
				Console.WriteLine(i + "\t" + System.Math.Round(pdf.Data[i], 3));
			}
			Console.WriteLine("Sum: " + System.Math.Round(sum, 3));
		}

		private static void PrintSeff(IServiceEffectSpecification seff)
		{
			if (seff == null)
				return;
			IFSMServiceEffect fsmSeff = (IFSMServiceEffect) seff.GetServiceInformation(typeof (IFSMServiceEffect));
			foreach (ITransition transition in fsmSeff.FSM.Transitions)
			{
				Console.WriteLine(TransitionWithProbabilityToString(transition));
			}
		}

		private static string TransitionWithProbabilityToString(ITransition transition)
		{
			double prob = ProbabilityAttribute.GetAttribute(transition).Probability;
			prob = System.Math.Round(prob, 3);
			string result = prob.ToString();
			result += "\t";
			result += transition.SourceState.ID;
			result += " - ";
			IService service = (IService) transition.InputSymbol.ID;
			result += service.Interface.Name;
			result += ".";
			result += service.Signature.Name;
			result += " - ";
			result += transition.DestinationState.ID;
			return result;
		}

		private static void AnalyseData()
		{
			Console.Write("Analysing Data...");
			ConnectionPool pool = new ConnectionPool(CONNECTION_STRING);
			try
			{
				pool.Open();

//				DBRestructurer restructurer = new DBRestructurer(pool);
//				restructurer.Run();
//
				DBSeffAnalyser seffAnalyser = new DBSeffAnalyser(pool);
				seffAnalyser.Analyse();

				DBTransitionProbilitiesAnalyser.ComputeTransitionProbabilities(WebserverComponentFactory.GetBasicComponents());

				DBExecutionTimeAnalyser execTimeAnalyser = new DBExecutionTimeAnalyser(pool);
				execTimeAnalyser.Analyse();
			}
			finally
			{
				pool.ForceClose();
			}
			Console.WriteLine("done.");
		}

		private static void ClearDatabase()
		{
			// Clear DB
			Console.Write("Clearing Database...");
			DropAnalyseDB(CONNECTION_STRING);
			CreateAnalyseDB(CONNECTION_STRING);
			Console.WriteLine("done.");
		}

		public static void CreateAnalyseDB(string connectionString)
		{
			DBFactory.ClassTableFactory.CreateTable(connectionString);
			DBFactory.MethodTableFactory.CreateTable(connectionString);
			DBFactory.CallInfoTableFactory.CreateTable(connectionString);
			DBFactory.ExecutionTimeTable.CreateTable(connectionString);
		}

		public static void DropAnalyseDB(string connectionString)
		{
			DBFactory.ExecutionTimeTable.DropTable(connectionString);
			DBFactory.CallInfoTableFactory.DropTable(connectionString);
			DBFactory.MethodTableFactory.DropTable(connectionString);
			DBFactory.ClassTableFactory.DropTable(connectionString);
		}

	}
}