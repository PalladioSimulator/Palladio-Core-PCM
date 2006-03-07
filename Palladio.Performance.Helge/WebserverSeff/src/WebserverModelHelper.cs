using System;
using System.Collections;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;

namespace Palladio.Performance.WebserverSeff
{
	/// <summary>
	/// Class for creating states and transitions. All created states and transitions are accessible 
	/// through a hashtable.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: WebserverModelHelper.cs,v $
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
	public class WebserverModelHelper
	{
		/// <summary>
		/// Adds a new transition to the editable fsm.
		/// </summary>
		/// <param name="id">Id of the transition. </param>
		/// <param name="fsm">FSM.</param>
		/// <param name="sourceID">ID of the source state.</param>
		/// <param name="destID">ID of the destination state</param>
		/// <param name="inputSymbol">Must be an IMatchable. For convenience the type cast is performed in this method.</param>
		public static void AddTransition(long id, ref IEditableFiniteStateMachine fsm,
			long sourceID, long destID, string inputSymbol)
		{
			IState source = CreateStates(sourceID)[0];
			IState dest = CreateStates(destID)[0];
			IInput input = FSMFactory.CreateDefaultInput(inputSymbol);
			ITransition transition = FSMFactory.CreateDefaultTransition(source, input, dest);
//			DatabaseIDAttribute.SetAttribute(transition, id);
			fsm.AddInputSymbols(transition.InputSymbol);
			fsm.AddTransitions(transition);
			if(!transitionHash.Contains(id)) 
			{
				transitionHash[id]=transition;
			} 
			else 
			{
				throw new ApplicationException("transitionHash already contains an id "+id+".");
			}
		}

		/// <summary>
		/// Adds a new transition to the editable fsm. Additional the Method corresponding to the input symbol
		/// is added to the <c>methodHash</c>.
		/// </summary>
		/// <param name="id">Id of the transition. </param>
		/// <param name="fsm">FSM.</param>
		/// <param name="sourceID">ID of the source state.</param>
		/// <param name="destID">ID of the destination state</param>
		/// <param name="inputSymbol">Must be an IMatchable. For convenience the type cast is performed in this method.</param>
		/// <param name="method">Method corresponding to the input symbol.</param>
		public static void AddTransition(long id, ref IEditableFiniteStateMachine fsm,
			long sourceID, long destID, string inputSymbol, string method)
		{
			AddTransition(id, ref fsm, sourceID, destID, inputSymbol);
			methodHash[inputSymbol] = method;
		}

		/// <summary>
		/// Returns the the transition instance with the given id.
		/// </summary>
		/// <param name="fsm">FSM containing the transition.</param>
		/// <param name="inputSymbol">Input symbol of the transition.</param>
		/// <returns>Requested transition.</returns>
		public static ITransition GetTransition(IFiniteStateMachine fsm, string inputSymbol) 
		{
			foreach(ITransition transition in fsm.Transitions) 
			{
				if(transition.InputSymbol.ID.ToString().Equals(inputSymbol))
					return transition;
			}
			return null;
		}

		/// <summary>
		/// Returns the transition of the given id.
		/// </summary>
		/// <param name="id">ID of the transition.</param>
		/// <returns>Requested transition.</returns>
		public static ITransition GetTransition(long id) 
		{
			return (ITransition) transitionHash[id];
		}


		/// <summary>
		/// Returns the state instance with the given id.
		/// </summary>
		/// <param name="id">ID of the state.</param>
		/// <returns>Requested state.</returns>
		public static IState GetState(long id)
		{
			return (IState) stateHash[id];
		}

		/// <summary>
		/// Creates a set of states using the given ids. If a
		/// state with the id already exists the existing instance
		/// is returned.
		/// </summary>
		/// <param name="ids">IDs of the states to create.</param>
		/// <returns>States that already exist.</returns>
		public static IState[] CreateStates(params long[] ids)
		{
			IState[] states = new IState[ids.Length];
			for (int i = 0; i < ids.Length; i++)
			{
				long cID = ids[i];
				if (!stateHash.Contains(cID))
				{
					IState state = FSMFactory.CreateDefaultState(cID.ToString());
//					DatabaseIDAttribute.SetAttribute(state, cID);
					stateHash[cID] = state;
				}
				states[i] = (IState) stateHash[cID];
			}
			return states;
		}

		/// <summary>
		/// Returns a more useful string representation of 
		/// a transition than the one of the component model does.
		/// </summary>
		/// <param name="transition">Transition for which a string representation is requested.</param>
		/// <returns>String representation of the transition.</returns>
		public static string TransitionToString(ITransition transition)
		{
			string result = transition.SourceState.ID;
			result += " - ";
			result +=  transition.InputSymbol.ID;
			result += " - ";
			result += transition.DestinationState.ID;
			result += " -- ";
			if(ProbabilityAttribute.GetAttribute(transition) != null) 
			{
				result += ProbabilityAttribute.GetAttribute(transition).Probability;
			} 
			else 
			{
				result += "null";
			}
			return result;
		}

		/// <summary>
		/// Hide the constructor.
		/// </summary>
		protected WebserverModelHelper()
		{
		}

		// hashtables used for the singleton pattern.
		private static Hashtable stateHash = new Hashtable();
		private static Hashtable transitionHash = new Hashtable();
		private static Hashtable methodHash = new Hashtable();

		/// <summary>
		/// Hashtable containing the method for a transition.
		/// key: input
		/// value: method
		/// </summary>
		public static Hashtable MethodHash
		{
			get
			{
				return methodHash;
			}
		}

		/// <summary>
		/// Hashtable containing all states of all cretaed service effect automaton.
		/// </summary>
		public static Hashtable StateHash
		{
			get
			{
				return stateHash;
			}
		}

		/// <summary>
		/// Hashtable containing all transitions of all cretaed service effect automaton.
		/// </summary>
		public static Hashtable TransitionHash
		{
			get
			{
				return transitionHash;
			}
		}
	}
}