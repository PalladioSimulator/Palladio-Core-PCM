using System;
using System.Collections;

namespace Palladio.FiniteStateMachines
{
	/// <summary>
	/// A helper class for editing FSMs. An array of <see cref="IState"/> is loaded
	/// into this hash and the single <see cref="IState"/> can be accessed by their
	/// IDs from the hashmap. 
	/// </summary>
	/// <remarks>
	/// An usage example:
	/// <code>
	///	IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
	///	StateHash states = FSMFactory.CreateStatesFromList("1","2","3");
	///	InputSymbolHash inputs = FSMFactory.CreateInputFromList("a","b","c","eps");
	///	fsm.AddStates(states.StoredStates);
	///	fsm.AddInputSymbols(inputs.StoredInputs);
	///	fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["1"],inputs["a"],states["1"]));
	///	fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["1"],inputs["b"],states["2"]));
	///	fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["2"],inputs["c"],states["3"]));
	///	fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["3"],inputs["eps"],states["1"]));
	///	Assert.IsTrue(fsm.Transitions.Length == 4);
	///	states = FSMFactory.CreateStatesFromList("1","2","3");
	///	fsm.FinalStates = new IState[] { states["1"], states["3"] };
	///	fsm.StartState = states["1"];
	/// </code>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/05/12 13:28:04  sbecker
	/// Added documentation and CVS log
	///
	///
	/// </pre>
	/// </remarks>
	public class StateHash
	{
		/// <summary>
		/// Internally used Hashtable
		/// </summary>
		protected Hashtable stateHash = new Hashtable();

		/// <summary>
		/// Return the IState with the given ID
		/// </summary>
		public IState this[object key]
		{
			get
			{
				return (IState)stateHash[key];
			}
		}

		/// <summary>
		/// Add the given IState to this hashmap
		/// </summary>
		/// <param name="s">The IState to be added to the hashmap</param>
		public void Add(IState s)
		{
			stateHash.Add(s.ID,s);
		}

		/// <summary>
		/// Return the states stored in the hashmap as array of IState
		/// </summary>
		public IState[] StoredStates
		{
			get
			{
				IState[] result = new IState[stateHash.Values.Count];
				stateHash.Values.CopyTo(result,0);
				return result;
			}
		}

		/// <summary>
		/// Default constructor - creates an empty state hash
		/// </summary>
		public StateHash()
		{
		}

		/// <summary>
		/// Constructor creating a state hash from an array of IStates
		/// </summary>
		/// <param name="states">The IStates to be initially added to the state hash</param>
		public StateHash(IState[] states)
		{
			foreach (IState s in states)
			{
				this.Add(s);
			}
		}

		/// <summary>
		/// Return a string representation of the state hash
		/// </summary>
		/// <returns>A string representing this state hash</returns>
		public override string ToString()
		{
			string result = "";

			foreach (IState s in stateHash.Values)
			{
				result += s.ID + " | ";
			}
			if (result.Length > 0)
				return result.Substring(0,result.Length - 3);
			else
				return "";
		}
	}
}
