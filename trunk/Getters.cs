using System;
using System.Collections;

namespace FSM
{

	public interface Getters
	{
		/// <summary>
		/// Returns the startstate of a FSM.
		/// </summary>
		/// <returns>The stratstate of a FSM.</returns>
		State getStartState();
		/// <summary>
		/// Returns the finalstate of a FSM.
		/// </summary>
		/// <returns>The finalstate of a FSM.</returns>
		Set getFinalStates();
		/// <summary>
		/// Returns the next State of FSM with a given Input.
		/// </summary>
		/// <returns>The next possoble State.</returns>
		State getNextState(State fromState, Input input);
		/// <summary>
		/// Returns the next Transition from a State with a given Input
		/// </summary>
		/// <returns>The next reachable Transition.</returns>
		Transition getTransition(State fromState, Input inChar);
		/// <summary>
		/// Returns all Transitions from a given State.
		/// </summary>
		/// <returns>A Hashtable witch contatins all Transtions from the given State.</returns>
		Hashtable getTransitionMap(State state);
		/// <summary>
		/// Returns all Transitions of the FSM in Transition Array.
		/// </summary>
		/// <returns>All Transitions of the FSM in a Array of Transitions.</returns>
		Transition[] getTransitions();
		Set getInputAl();
		/// <summary>
		/// displays alls Transitions on the console.
		/// </summary>
//		string transitionsToString();

		/// <summary>
		/// The errorstate of the FSM.
		/// </summary>
		State ErrorState {
			get;
		}
	}

}




