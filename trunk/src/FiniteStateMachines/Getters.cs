using System;
using System.Collections;
using Utils.Collections;


namespace FiniteStateMachines {

	public interface IFiniteStateMachine {
		/// <summary>
		/// Returns the startstate of a FSM.
		/// </summary>
		/// <returns>The stratstate of a FSM.</returns>
		State StartState { get; }
		/// <summary>
		/// Returns the finalstate of a FSM.
		/// </summary>
		/// <returns>The finalstate of a FSM.</returns>
		Set FinalStates { get; }
		/// <summary>
		/// Returns the next State of FSM with a given Input.
		/// </summary>
		/// <returns>The next possoble State.</returns>
		State GetNextState(State fromState, Input input);
		/// <summary>
		/// Returns the next Transition from a State with a given Input
		/// </summary>
		/// <returns>The next reachable Transition.</returns>
		Transition GetTransition(State fromState, Input inChar);
		/// <summary>
		/// Returns all Transitions from a given State.
		/// </summary>
		/// <returns>A Hashtable witch contatins all Transtions from the given State.</returns>
		Hashtable GetOutgoingTransitions(State state);
		/// <summary>
		/// Returns all Transitions of the FSM in Transition Array.
		/// </summary>
		/// <returns>All Transitions of the FSM in a Array of Transitions.</returns>
		Transition[] GetTransitions();

		Set InputAlphabet { get; }

		/// <summary>
		/// The errorstate of the FSM.
		/// </summary>
		State ErrorState { get; }
	}

}




