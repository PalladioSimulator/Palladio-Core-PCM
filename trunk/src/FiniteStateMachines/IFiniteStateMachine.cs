using System;
using System.Collections;
using Utils.Collections;


namespace FiniteStateMachines {

	/// <summary>
	/// All finite state machines have to implement this interface. It 
	/// provides a simple protocol for the default functionality of a finte
	/// state machine.
	/// </summary>
	public interface IFiniteStateMachine {

		/// <summary>
		/// The errorstate of the FSM.
		/// </summary>
		AbstractState ErrorState { get; }

		/// <summary>
		/// The start state of the FSM.
		/// </summary>
		AbstractState StartState { get; }

		/// <summary>
		/// The final states of the FSM.
		/// </summary>
		Set FinalStates { get; }

		/// <summary>
		/// The input alphabet; a set of <code Input/> objects.
		/// </summary>
		Set InputAlphabet { get; }

		/// <summary>
		/// Returns the the target of a transiton starting at <code aSourceState/> 
		/// with the input symbol <code anInput/>.
		/// </summary>
		/// <returns>The destination of the transition.</returns>
		AbstractState GetNextState(AbstractState aSourceState, Input anInput);

		/// <summary>
		/// Returns the next Transition starting at <code aSourceState/> with the
		/// input symbol <code anInput/>.
		/// </summary>
		/// <returns>The transition starting at <code aSourceState/> 
		/// with the input symbol <code anInput/> </returns>
		Transition GetNextTransition(AbstractState aSourceState, Input anInput);

		/// <summary>
		/// Returns all transitions from a given State.
		/// </summary>
		/// <returns>A <code Hashtable/> which contains all transtions from the given State.
		/// The key of the <code Hashtable/> is the <code Input/> and the value the 
		/// corresponding <code Transition/>.</returns>
		Hashtable GetOutgoingTransitions(AbstractState aSourceState);

		/// <summary>
		/// Returns all Transitions of the FSM in Transition Array.
		/// </summary>
		/// <returns>All Transitions of the FSM in a Array of Transitions.</returns>
		Transition[] GetTransitions();
	}

}




