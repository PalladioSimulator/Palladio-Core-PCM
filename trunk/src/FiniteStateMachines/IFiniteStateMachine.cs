using System;
using System.Collections;
using Utils.Collections;


namespace FiniteStateMachines {

	/// <summary>
	///     All finite state machines have to implement this interface. It
	///     provides a simple protocol for the default functionality of a finte
	///     state machine.
	///     
	///     author: JH
	/// </summary>
	public interface IFiniteStateMachine {

		/// <summary>
		///     All transitions with a not allowed input
		///     lead to errorState.
		/// </summary>
		IState ErrorState { get; }

		/// <summary>
		///     If the automaton is used for accepting
		///     an input sequence, this is the state to
		///     start with.
		///     
		///     If no start state is defined an exception has to
		///     be thrown.
		/// </summary>
		IState StartState { get; }

		/// <summary>
		///     If the automaton reaches one of this states
		///     during reading an input sequence, the
		///     sequence is accepted.
		///     
		///     If no finalstates are defined an exception has to
		///     be thrown. (type?)
		/// </summary>
		Set FinalStates { get; }

		/// <summary>
		///     A set of valid input symbols for
		///     this automaton.
		/// </summary>
		Set InputAlphabet { get; }

		/// <summary>
		///     Returns the target of a transition
		///     starting at aSourceState with the input 
		///     symbol anInput.
		/// </summary>
		/// <param name="aSourceState">
		///		The source of the transition.
		///	</param>
		/// <param name="anInput">
		///		The input symbol of the transition.
		///	</param>
		/// <returns>
		///		The destination of the transition.
		///	</returns>
		IState GetNextState(IState aSourceState, Input anInput);

		/// <summary>
		///     Returns the next Transition starting 
		///     at aSourceState with the input symbol 
		///     anInput.
		/// </summary>
		/// <param name="aSourceState">
		///		The source of the transition.
		///	</param>
		/// <param name="anInput">
		///		The input of the transition.
		///	</param>
		/// 
		/// <returns>
		///		The transition starting at aSourceState
		///     with the input symbol anInput.
		/// </returns>
		Transition GetNextTransition(IState aSourceState, Input anInput);

		/// <summary>
		///     Returns all _valid_ transitions for aSourceState.
		/// </summary>
		/// <param name="aSourceState">
		///		The source for which all valid transitions are returned.
		///	</param>
		/// <returns>
		///		A Hashtable containing all transitions for the source state.
		///     The key of the Hashtable is the Input and the value the
		///     corresponding Transition.
		/// </returns>
		IList GetOutgoingTransitions(IState aSourceState);

		/// <summary>
		///     Searches for all states reachable from aState. This means
		///     there exists a path from aState to every state contained
		///     in the result. Certainly aState is also included in
		///     the result.
		/// </summary>
		/// 
		/// <param name="aState">The search starts here.</param>
		/// 
		/// <returns>An IList containing all reachable States.</returns>
		IList GetReachableStates(IState aState);

		/// <summary>
		///     Adds a single transition to the automaton.
		/// </summary>
		/// 
		/// <param name="aTransition">The transition to add to the automaton.</param>
		void AddTransition(Transition aTransition);

		/// <summary>
		///     Adds a list of transitions to the automaton.
		/// </summary>
		/// 
		/// <param name="aTransitionList">A list of transitions.</param>
		void AddTransitionList(IList aTransitionList);
	}

}




