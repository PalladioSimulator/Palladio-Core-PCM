using System;
using System.Collections;

namespace Palladio.FiniteStateMachines
{
	/// <summary>
	/// A helper class for editing FSMs. An array of <see cref="IInput"/> is loaded
	/// into this hash and the single <see cref="IInput"/> can be accessed by their
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
	/// Revision 1.4  2004/05/12 13:28:04  sbecker
	/// Added documentation and CVS log
	///
	/// Revision 1.3  2004/05/12 08:12:59  sbecker
	/// Fixed small typo
	///
	/// Revision 1.2  2004/05/12 08:07:25  sbecker
	/// Added constructor constructing from IInput[]
	/// Added CVS log
	///
	///
	/// </pre>
	/// </remarks>	
	public class InputSymbolHash
	{
		/// <summary>
		/// The internal used Hashtable to store the input symbols and their IDs
		/// </summary>
		protected Hashtable inputHash = new Hashtable();

		/// <summary>
		/// Get the input symbol with the given ID
		/// </summary>
		public IInput this[object key]
		{
			get
			{
				return (IInput)inputHash[key];
			}
		}

		/// <summary>
		/// Add an input symbol to this Hashtable
		/// </summary>
		/// <param name="anInput">An IInput to be added to the Hashtable</param>
		public void Add(IInput anInput)
		{
			inputHash.Add(anInput.ID,anInput);
		}

		/// <summary>
		/// Return the stored IInputs as an array of IInput
		/// </summary>
		public IInput[] StoredInputs
		{
			get
			{
				IInput[] result = new IInput[inputHash.Values.Count];
				inputHash.Values.CopyTo(result,0);
				return result;
			}
		}

		/// <summary>
		/// Default constructor - create an empty input symbol hash
		/// </summary>
		public InputSymbolHash()
		{
		}

		/// <summary>
		/// Create an input symbol hash from an array of IInput
		/// </summary>
		/// <param name="inputs">The IInput array to create the hashmap from</param>
		public InputSymbolHash(IInput[] inputs)
		{
			foreach (IInput i in inputs)
			{
				this.Add(i);
			}
		}

		/// <summary>
		/// A ToString to format the entries of this hashmap
		/// </summary>
		/// <returns>A string representation of the hashmap</returns>
		public override string ToString()
		{
			string result = "";

			foreach (IInput s in inputHash.Values)
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
