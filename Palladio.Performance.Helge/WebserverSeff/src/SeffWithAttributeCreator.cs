using System;
using System.Diagnostics;
using System.Xml;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;

namespace Palladio.Performance.WebserverSeff
{

	/// <summary>
	/// This class class contains the measured information of an invoked service.
	/// </summary>
	class TimeInfo
	{
		/// <summary>
		/// Start Time of the service.
		/// </summary>
		public long StartTime;
		/// <summary>
		/// Stop time of the service.
		/// </summary>
		public long StopTime;
		/// <summary>
		/// Execution time of the service.
		/// </summary>
		public long ExecutionTime;
		/// <summary>
		/// Name of the service.
		/// </summary>
		public string MethodName;
		/// <summary>
		/// Interface the service is part of.
		/// </summary>
		public string InterfaceName;

		/// <summary>
		/// Constructor. 
		/// </summary>
		/// <param name="startTime">Start time of the service.</param>
		/// <param name="stopTime">Stop time of the service.</param>
		/// <param name="executionTime">Execution time of the service.</param>
		/// <param name="methodName">Name of the Service.</param>
		/// <param name="interfaceName">Interface the service is part of.</param>
		public TimeInfo(long startTime, long stopTime, long executionTime, string methodName, string interfaceName)
		{
			this.StartTime=startTime;
			this.StopTime=stopTime;
			this.ExecutionTime=executionTime;
			this.MethodName=methodName;
			this.InterfaceName=interfaceName;
		}

		/// <summary>
		/// Reads out the <c>XmlNode</c> and generates a TimeInfoObject.
		/// </summary>
		/// <param name="node"><c>XmlNode</c> that contains the measured information.</param>
		/// <returns></returns>
		public static TimeInfo GetTimeInfo(XmlNode node) 
		{
			long startTime;
			long stopTime;
			long executionTime;
			string methodName;
			string interfaceName;
			try
			{
				XmlNode callTime = node.SelectSingleNode("CallTime");
				startTime = Convert.ToInt64(callTime.InnerText);
				XmlNode returnTime = node.SelectSingleNode("ReturnTime");
				stopTime = Convert.ToInt64(returnTime.InnerText);
				XmlNode exTime = node.SelectSingleNode("ExecutionTime");
				executionTime =Convert.ToInt64(exTime.InnerText);
				methodName = node.SelectSingleNode("MethodName").InnerText;
				interfaceName = node.SelectSingleNode("InterfaceName").InnerText;
				return new TimeInfo(startTime,stopTime,executionTime,methodName,interfaceName);
			} catch(Exception e)
			{
				Console.WriteLine(e);
				return null;
			}
		}

	}
	/// <summary>
	/// Class for creating the service effect automaton including the creation of attributes. The
	/// attributes are generated from from measures that are contained in a xml file.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: SeffWithAttributeCreator.cs,v $
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
	public class SeffWithAttributeCreator
	{
		/// <summary>
		/// Samplingrate of the created probability density functions.
		/// </summary>
		int samplingrate;

		/// <summary>
		/// Xml document containing the measures.
		/// </summary>
		XmlDocument doc;

		/// <summary>
		/// Constructor. 
		/// </summary>
		/// <param name="measureFile">Path to the file containing the measured data.</param>
		/// <param name="samplingrate">Samplingrate of the created probability density functions.</param>
		public SeffWithAttributeCreator(string measureFile, int samplingrate)
		{
			this.samplingrate=samplingrate;
			doc = new XmlDocument();
			doc.Load(measureFile);
		}

		/// <summary>
		/// Walks through the service effect automaton for each measure of the service and adds the 
		/// attributes to the service effect automaton. Each measure takes one possible path in the 
		/// service effect automaton.
		/// </summary>
		/// <param name="seff">Service Effect automaton without attributes.</param>
		/// <param name="servicename">Name of the service as it is found in the xml file.</param>
		/// <returns>Service Effect automaton with attributes.</returns>
		public IFiniteStateMachine AddAttributesToSeff(IFiniteStateMachine seff, string servicename)
		{
			IState activeState; // Holds the active state during the walk throug the seff.
			XmlNodeList serviceList = doc.GetElementsByTagName(servicename);

			AddEmptyMeasureAttributesToFSM(seff);

			int length = serviceList.Count;
			for(int k = 0; k<length;k++)
			{
				XmlNode actualServiceNode=serviceList[k];
				try 
				{
					long serviceStartTime = Convert.ToInt64(actualServiceNode.SelectSingleNode("CallTime").InnerText);
					long serviceStopTime = Convert.ToInt64(actualServiceNode.SelectSingleNode("ReturnTime").InnerText);
					TimeInfo[] timeInfo = GetTimeInfoOfCalledMethods(actualServiceNode);

					activeState = seff.StartState; // beginning with start state
					long stateStartTime = serviceStartTime;

					for(int i=0;i<timeInfo.Length;i++)
					{
						string transitionName = timeInfo[i].InterfaceName + "_" +timeInfo[i].MethodName;
						ITransition actualTransition = GetTransitionForService(transitionName, seff, activeState);

						AddMeasuredExecutionTime(timeInfo[i], activeState, stateStartTime, actualTransition, seff, serviceStopTime);
						activeState = actualTransition.DestinationState;
						long transitionStopTime = timeInfo[i].StopTime;
						stateStartTime = transitionStopTime;
					}
				} 
				catch (NullReferenceException e) 
				{
					Debug.WriteLine("SeffWithAttributeCreator: NullReference!"+e);
					continue;
				}
			}
			ConvertAttributes(seff);

			return seff;
		}

		/// <summary>
		/// Adds the measured execution times to the state and transition.
		/// </summary>
		/// <param name="timeInfo">Measured time information of the invoked service.</param>
		/// <param name="activeState">Active state of the service effect automaton.</param>
		/// <param name="stateStartTime">Start time of the state.</param>
		/// <param name="actualTransition">Transition representing the invoked service.</param>
		/// <param name="seff">The service effect automaton.</param>
		/// <param name="serviceStopTime">Stop time of the service specified by the service effect automaton.</param>
		private static void AddMeasuredExecutionTime(TimeInfo timeInfo, IState activeState, long stateStartTime, ITransition actualTransition, IFiniteStateMachine seff, long serviceStopTime)
		{
			// add measure to actual state
			long transitionStartTime = timeInfo.StartTime;
			long transitionStopTime = timeInfo.StopTime;
			MeasureAttribute.AddMeasure(activeState, transitionStartTime-stateStartTime);
	
			// add measure to transition
			MeasureAttribute.AddMeasure(actualTransition, timeInfo.ExecutionTime);
			// if state has no outgoing transition (isFinalState) add measure to destination state
			if(seff.IsFinalState(actualTransition.DestinationState))
			{
				MeasureAttribute.AddMeasure(actualTransition.DestinationState,
					serviceStopTime-transitionStopTime);
			}
		}

		/// <summary>
		/// Returns the measured information of all called services.
		/// </summary>
		/// <param name="actualServiceNode">The <c>XmlNode</c> should contain an idref "Calls".</param>
		/// <returns>Measured information of the called services.</returns>
		private TimeInfo[] GetTimeInfoOfCalledMethods(XmlNode actualServiceNode)
		{
			XmlNode callsNode = actualServiceNode.Attributes.GetNamedItem("Calls");
			string[] calls = callsNode.InnerText.Split(new char[]{' '});
			TimeInfo[] timeInfo= new TimeInfo[calls.Length]; // time info of all external calls

			for (int i=0;i<timeInfo.Length;i++) 
			{
				timeInfo[i] = TimeInfo.GetTimeInfo(doc.GetElementById(calls[i]));
				if(timeInfo[i] == null) Debugger.Break();
			}
			return timeInfo;
		}

		/// <summary>
		/// Adds empty measure attributes to all transition and states.
		/// </summary>
		/// <param name="seff">Service effect automaton.</param>
		private void AddEmptyMeasureAttributesToFSM(IFiniteStateMachine seff)
		{
			foreach(IState state in seff.States)
			{
				state.Attributes.Add(MeasureAttribute.AttributeType,new MeasureAttribute());
			}
			foreach(ITransition tarnsition in seff.Transitions)
			{
				tarnsition.Attributes.Add(MeasureAttribute.AttributeType,new MeasureAttribute());
			}
		}

		/// <summary>
		/// Creates a ProbabilityAttributes and a RandomVariable for each transition and
		/// a RandomVariable for each state.
		/// </summary>
		/// <param name="seff">Service effect automaton. Each state and transition must have a
		/// MeasureAttribute.</param>
		private void ConvertAttributes(IFiniteStateMachine seff)
		{
			foreach(IState state in seff.States)
			{
				AddRandomVariable(state);
			}
	
			foreach(ITransition transition in seff.Transitions)
			{
				AddRandomVariable(transition);

				ProbabilityAttribute p = 
					AttributeTransformer.CreateProbabilityAttributeForTransition(transition);
				transition.Attributes.Add(ProbabilityAttribute.AttributeType,p);
			}
		}

		/// <summary>
		/// Converts the MeasureAttribute of the <c>IAttributable</c> to a <c>RandomVariable</c>
		/// and append it.
		/// </summary>
		/// <param name="attributable">Object conatining a <c>MeasureAttribute</c>.</param>
		private void AddRandomVariable(IAttributable attributable)
		{
			MeasureAttribute measure = MeasureAttribute.GetAttribute(attributable);
			RandomVariable rv = AttributeTransformer.MeasureAttribute2RandomVariable(measure,samplingrate);
			if(rv.ProbabilityDensityFunction.SamplingRate != samplingrate) Debugger.Break();
			attributable.Attributes.Add(RandomVariable.AttributeType,rv);
		}

		/// <summary>
		/// Returns the transition for the invoked service starting from <c>state</c>.
		/// </summary>
		/// <param name="transitionName">Name of the service.</param>
		/// <param name="seff">Service effect automaton.</param>
		/// <param name="state">State from where the external service is called.</param>
		/// <returns>The transition of the invoked service.</returns>
		private ITransition GetTransitionForService(string transitionName, 
			IFiniteStateMachine seff, IState state)
		{
			foreach(ITransition transition in seff.GetOutgoingTransitions(state))
			{
				string method = (string) WebserverModelHelper.MethodHash[transition.InputSymbol.ToString()];
				if(method.Equals(transitionName)) return transition;
			}
			throw new ApplicationException("No service " + transitionName + " found.");
		}
	}
}
