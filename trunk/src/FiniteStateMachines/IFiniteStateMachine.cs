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
		/// The input alphabet; a set of <code>Input</code> objects.
		/// </summary>
		Set InputAlphabet { get; }

		/// <summary>
		/// Returns the the target of a transiton starting at <code>aSourceState</code> 
		/// with the input symbol <code>anInput</code>.
		/// </summary>
		/// <returns>The destination of the transition.</returns>
		AbstractState GetNextState(AbstractState aSourceState, Input anInput);

		/// <summary>
		/// Returns the next <code>Transition</code> starting at <code>aSourceState</code> with the
		/// input symbol <code>anInput</code>.
		/// </summary>
		/// <returns>The transition starting at <code>aSourceState</code>  
		/// with the input symbol <code>anInput</code> </returns>
		Transition GetNextTransition(AbstractState aSourceState, Input anInput);

		/// <summary>
		/// Returns all transitions with the source <code>aSourceState</code>.
		/// </summary>
		/// <returns>A <code>Hashtable</code> which contains all transtions for the given state.
		/// The key of the <code>Hashtable</code> is the <code>Input</code> and the value the 
		/// corresponding <code>Transition</code>.</returns>
		IList GetOutgoingTransitions(AbstractState aSourceState);
	}

}




