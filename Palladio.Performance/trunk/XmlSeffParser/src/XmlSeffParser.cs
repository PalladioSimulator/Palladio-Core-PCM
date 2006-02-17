using System;
using System.Collections;
using System.IO;
using System.Xml;
using System.Xml.Schema;
using System.Xml.XPath;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;

namespace Palladio.Performance.XmlSeffParser
{
	/// <summary>
	/// Parser for service effect automaton specified by a xml file.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
	public class XmlSeffParser
	{
		XmlDocument doc;
		IFiniteStateMachine fsm;


		/// <summary>
		/// Constructor. Parses the Xml-File and generates the sevice effect automaton
		/// </summary>
		/// <param name="file">Path to XML file.</param>
		public XmlSeffParser(string file)
		{
			doc = LoadXmlFile(file);
			fsm = CreateSeff();
		}

		/// <summary>
		/// Service effect automaton
		/// </summary>
		public IFiniteStateMachine Seff
		{
			get { return fsm; }
		}

		/// <summary>
		/// Verifies and load the XML fiel.
		/// </summary>
		/// <param name="file"></param>
		/// <returns></returns>
		private XmlDocument LoadXmlFile(string file)
		{
			XmlDocument doc;
			try
			{
				ValidateXmlFile(file);
				doc = new XmlDocument();
				doc.Load(file);
			}
			catch (XmlException e)
			{
				Console.WriteLine(e);
				return null;
			}
			catch (IOException e)
			{
				Console.WriteLine("File Was not Found!" + e);
				return null;
			}

			return doc;
		}

		/// <summary>
		/// Returns a <c>XPathNodeIterator</c> for the given XPath expression.
		/// </summary>
		/// <param name="xpathExpression">XPath expression.</param>
		/// <returns>Iterator for XPath expression.</returns>
		private XPathNodeIterator GetIterator(string xpathExpression)
		{
			XPathNavigator nav = doc.CreateNavigator();
			return nav.Select(xpathExpression);
		}

		/// <summary>
		/// Returns the value of the first child.
		/// </summary>
		/// <param name="it">Actual position in the document.</param>
		/// <param name="child">Name of the child.</param>
		/// <returns>Value of the first child.</returns>
		private string GetValueOfChild(XPathNodeIterator it, string child)
		{
			XPathNodeIterator it2;
			it2 = it.Current.SelectChildren(child, it.Current.NamespaceURI);
			it2.MoveNext();
			return it2.Current.Value;
		}

		/// <summary>
		/// Creates a QMLAttribute out of the time_consumption children.
		/// </summary>
		/// <param name="nav"></param>
		/// <returns></returns>
		private QMLAttribute GetTimeConsumption(XPathNavigator nav)
		{
			XPathNodeIterator it = nav.SelectChildren("time_consumption", nav.NamespaceURI);
			double[] percentile = new double[it.Count];
			long[] time = new long[it.Count];
			for (int i = 0; i < it.Count; i++)
			{
				it.MoveNext();

				percentile[i] = Convert.ToDouble(it.Current.GetAttribute("percentile", nav.NamespaceURI));
				time[i] = Convert.ToInt64(it.Current.GetAttribute("time", nav.NamespaceURI));
			}
			return new QMLAttribute(percentile, time);
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


		/// <summary>
		/// Validates the Xml file.
		/// </summary>
		/// <param name="file">File to validate.</param>
		private void ValidateXmlFile(string file)
		{
			try
			{
				XmlTextReader textReader = new XmlTextReader(file);
				XmlValidatingReader val = new XmlValidatingReader(textReader);
				val.ValidationType = ValidationType.DTD;
				val.ValidationEventHandler +=
					new ValidationEventHandler(OnValidateError);
				while (val.Read()) ;
			}
			catch(Exception e)
			{
				Console.WriteLine("An Exception was thrown while validation the XML file." + e);
				throw;
			}
		}

		/// <summary>
		/// Error function for the ValidationEventHandler.
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="args"></param>
		private void OnValidateError(Object sender, ValidationEventArgs args)
		{
			throw new XmlException("File does not match XmlSeffParser.dtd", null);
		}

		#region CreateSeff

		/// <summary>
		/// Creates the service effect automaton from the xml file.
		/// </summary>
		/// <returns>The service effect automaton.</returns>
		private IFiniteStateMachine CreateSeff()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();

			StateHash stateHash = ReadAndCreateStates(fsm);

			InputSymbolHash inputhash = ReadAndCreateInputs(fsm);

			ReadAndCreateTransitions(stateHash, inputhash, fsm);
			return fsm;
		}

		/// <summary>
		/// Searches the <c>statelist</c> tag and creates the states and adds them to the finite
		/// state machine.
		/// </summary>
		/// <param name="fsm"></param>
		/// <returns></returns>
		private StateHash ReadAndCreateStates(IEditableFiniteStateMachine fsm)
		{
			XPathNodeIterator it = GetIterator("/ServiceEffectAutomaton/statelist/state");

			string[] states = GetStates(it.Clone());
			StateHash stateHash = FSMFactory.CreateStatesFromList(states);
			fsm.AddStates(stateHash.StoredStates);

			AddStartState(stateHash, fsm);

			ArrayList finalStates = DetermineFinalStates(it.Clone());
			AddFinalStates(finalStates, stateHash, fsm);

			Hashtable qmlHash = CreateTimeConsumptionForStates(it.Clone());

			AddTimeAttributesToStates(stateHash, qmlHash);
			return stateHash;
		}

		/// <summary>
		/// Creates a QMLAttribute for each state.
		/// </summary>
		/// <param name="it">Iterator pointing to the states list.</param>
		/// <returns>Hashtable conatining a QMLAttribute for each state.</returns>
		private Hashtable CreateTimeConsumptionForStates(XPathNodeIterator it)
		{
			Hashtable qmlHash = new Hashtable();
			while (it.MoveNext())
			{
				try
				{
					qmlHash[it.Current.Value] = GetTimeConsumption(it.Current);
				}
				catch (ApplicationException)
				{
					Console.WriteLine("No time_consumption for state " + it.Current.Value + ".");
					throw;
				}
				catch (FormatException)
				{
					Console.WriteLine("Some time_consumtion values are not convertable to integers.");
					throw;
				}
			}
			return qmlHash;
		}

		/// <summary>
		/// Creates a list of final states.
		/// </summary>
		/// <returns>List of final states.</returns>
		private ArrayList DetermineFinalStates(XPathNodeIterator it)
		{
			ArrayList finalStates = new ArrayList();
			string isFinalState;
			while (it.MoveNext())
			{
				isFinalState = it.Current.GetAttribute("isFinalState", it.Current.NamespaceURI);
				if (isFinalState.ToLower().Equals("true"))
					finalStates.Add(it.Current.Value);
			}
			return finalStates;
		}

		/// <summary>
		/// Returns the id of each state.
		/// </summary>
		/// <returns>Id of states.</returns>
		private string[] GetStates(XPathNodeIterator it)
		{
			string[] states = new string[it.Count];
			for (int i = 0; i < states.Length; i++)
			{
				it.MoveNext();
				states[i] = GetValueOfChild(it, "name");
			}
			return states;
		}

		/// <summary>
		/// Adds a RandomVariable to all states.
		/// </summary>
		/// <param name="stateHash">Hashtable containing all states.</param>
		/// <param name="qmlHash">Hashtable containing the <c>QMLAttribute</c> for each state.</param>
		private void AddTimeAttributesToStates(StateHash stateHash, Hashtable qmlHash)
		{
			for (int i = 0; i < stateHash.StoredStates.Length; i++)
			{
				if (qmlHash[stateHash.StoredStates[i].ID] != null)
				{
					RandomVariable rand = AttributeTransformer.Qml2RandomVariable(
						(QMLAttribute) qmlHash[stateHash.StoredStates[i].ID]);
					stateHash.StoredStates[i].Attributes.Add(RandomVariable.AttributeType, rand);
				}
			}
		}

		/// <summary>
		/// Adds start state to the service effect automaton.
		/// </summary>
		/// <param name="stateHash"></param>
		/// <param name="fsm"></param>
		private void AddStartState(StateHash stateHash, IEditableFiniteStateMachine fsm)
		{
			XPathNodeIterator it = GetIterator("/ServiceEffectAutomaton/statelist");
			it.MoveNext();
			try
			{
				fsm.StartState = stateHash[it.Current.GetAttribute("startstate", it.Current.NamespaceURI)];
			}
			catch (Exception e)
			{
				Console.WriteLine("Wrong start state: " +
					it.Current.GetAttribute("startstate", it.Current.NamespaceURI) + e);
				throw;
			}
		}

		/// <summary>
		/// Adds final states to the service effect automaton.
		/// </summary>
		/// <param name="finalStates"></param>
		/// <param name="stateHash"></param>
		/// <param name="fsm"></param>
		private void AddFinalStates(ArrayList finalStates, StateHash stateHash, IEditableFiniteStateMachine fsm)
		{
			IState[] finalStatesAsIState = new IState[finalStates.Count];
			for (int i = 0; i < finalStates.Count; i++)
			{
				finalStatesAsIState[i] = stateHash[(string) finalStates[i]];
				if (finalStatesAsIState[i] == null)
				{
					Console.WriteLine(" Final state " + (string) finalStates[i] + " is not in states." +
						"State is not added to final states.");
				}
			}
			fsm.FinalStates = finalStatesAsIState;
		}

		/// <summary>
		/// Searches for the <c>inputlist</c> tag and creates an <c>InputSymbolHash</c>
		/// and adds the inputs to the finite state machine.
		/// </summary>
		/// <param name="fsm">Service effect automaton.</param>
		/// <returns>Inputs of the service effect automaton.</returns>
		private InputSymbolHash ReadAndCreateInputs(IEditableFiniteStateMachine fsm)
		{
			XPathNodeIterator it = GetIterator("/ServiceEffectAutomaton/inputlist/input");
			string[] inputsAsString = new string[it.Count];
			for (int i = 0; i < inputsAsString.Length; i++)
			{
				it.MoveNext();
				inputsAsString[i] = it.Current.Value;
			}
			InputSymbolHash inputhash = FSMFactory.CreateInputFromList(inputsAsString);
			fsm.AddInputSymbols(inputhash.StoredInputs);
			return inputhash;
		}

		/// <summary>
		/// Searches for the <c>transitionlist</c> tag and creates the transitions.
		/// </summary>
		/// <param name="states1">States of the FSM.</param>
		/// <param name="inputhash">Inputs of the FSM.</param>
		/// <param name="fsm">The service effect automaton.</param>
		private void ReadAndCreateTransitions(StateHash states1, InputSymbolHash inputhash, IEditableFiniteStateMachine fsm)
		{
			XPathNodeIterator it = GetIterator("/ServiceEffectAutomaton/transitionlist/transition");

			while (it.MoveNext())
			{
				ITransition transition = ReadAndCreateTransition(states1, inputhash, it);
				AddAttributes(transition, it);
				AddTransition(fsm, transition);
			}
		}

		/// <summary>
		/// Adds the transition to the finite state machine.
		/// </summary>
		/// <param name="fsm">Service effect automaton.</param>
		/// <param name="transition">Transition to be added.</param>
		private void AddTransition(IEditableFiniteStateMachine fsm, ITransition transition)
		{
			try
			{
				fsm.AddTransitionList(new ITransition[] {transition});
			}
			catch (Exception e)
			{
				Console.WriteLine("Transition (" + transition.SourceState.ID + "," + transition.InputSymbol.ID.ToString()
					+ "," + transition.DestinationState.ID + ") could not be added to FSM.");
				Console.WriteLine(e);
				throw;
			}
		}

		/// <summary>
		/// Creates a transition from the actual <c>transition</c> tag.
		/// </summary>
		/// <param name="stateHash">Hashtable containing states of the service effect
		/// automaton.</param>
		/// <param name="inputhash">Hashtable containing the inputs of the service effect automaton.</param>
		/// <param name="it">Actual position.</param>
		/// <returns>Transition of the actual transition tag.</returns>
		private ITransition ReadAndCreateTransition(StateHash stateHash, InputSymbolHash inputhash, XPathNodeIterator it)
		{
			string source = GetValueOfChild(it, "sourcestate");
			string destination = GetValueOfChild(it, "destinationstate");
			string input = GetValueOfChild(it, "input");
			return FSMFactory.CreateDefaultTransition
				(stateHash[source], inputhash[input], stateHash[destination]);
		}


		/// <summary>
		/// Adds the <c>ProbabilityAttribute</c> and <c>RandomVariable</c> to the transition.
		/// </summary>
		/// <param name="transition">Transition which shall get the attributes.</param>
		/// <param name="it">Actual position.</param>
		private void AddAttributes(ITransition transition, XPathNodeIterator it)
		{
				AddProbabilityAttribute(transition, it);
				AddRandomVariable(transition, it);
		}

		/// <summary>
		/// Adds a <c>RandomVariable</c> to the transition.
		/// </summary>
		/// <param name="transition">Transition which shall get the attribute.</param>
		/// <param name="it">Actual position in the document.</param>
		private void AddRandomVariable(ITransition transition, XPathNodeIterator it)
		{
			try
			{
				transition.Attributes.Add(RandomVariable.AttributeType,
				                          AttributeTransformer.Qml2RandomVariable(GetTimeConsumption(it.Current)));
			}
			catch (FormatException e)
			{
				Console.WriteLine("At Transition (" + transition.SourceState.ID + "," +
					transition.InputSymbol.ID.ToString() + "," + transition.DestinationState.ID +
					"): Some time_consumption values are not convertable to integers.");
				Console.WriteLine(e);
				throw;
			}
		}

		/// <summary>
		/// Adds a <c>ProbabilityAttribute</c> to the transition.
		/// </summary>
		/// <param name="transition">Transition which shall get the attribute.</param>
		/// <param name="it">Actual position.</param>
		private void AddProbabilityAttribute(ITransition transition, XPathNodeIterator it)
		{
			string probability = GetValueOfChild(it, "probability");
			try
			{
				transition.Attributes.Add(ProbabilityAttribute.AttributeType,
				                          new ProbabilityAttribute(Convert.ToDouble(ConvertToDoubleString(
				                          	probability))));
			}
			catch (FormatException e)
			{
				Console.WriteLine("At transition (" + transition.SourceState.ID + "," +
					transition.InputSymbol.ID.ToString() + "," + transition.DestinationState.ID +
					"): Probability " + probability + "is not convertable to an double.");
				Console.WriteLine(e);
				throw;
			}
		}

		#endregion CreateSeff
	}
}