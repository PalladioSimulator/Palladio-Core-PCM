using System;
using System.Collections;

namespace Palladio.FiniteStateMachines {

	/// <summary>
	///     All finite state machines have to implement this interface. It
	///     provides a simple protocol for the default functionality of a finte
	///     state machine.
	///     
	///     author: JH
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2004/05/12 14:12:24  sliver
	/// Comments reviewed.
	///
	/// Revision 1.3  2004/05/12 13:40:19  sbecker
	/// Added documentation and CVS log
	///
	///
	/// </pre>
	/// </remarks>
	public interface IFiniteStateMachine : ICloneable 
	{
		/// <summary>
		/// Return an array containing all the states of this FSM. NOTE: This getter may be time and
		/// memory intensive!
		/// </summary>
		IState[] States { get; }

		/// <summary>
		/// Return an array containing all the transitions of this FSM. NOTE: This getter may be time and
		/// memory intensive!
		/// </summary>
		ITransition[] Transitions { get; }

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
		/// </summary>
		IState[] FinalStates { get; }

		/// <summary>
		///     A set of valid input symbols for
		///     this automaton.
		/// </summary>
		IInput[] InputAlphabet { get; }

		/// <summary>
		///     Returns the targets of a transition
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
		IState[] GetNextStates(IState aSourceState, IInput anInput);

		/// <summary>
		/// Return the next state starting from a given state and using the given input
		/// symbol. NOTE: An exception is thrown if there are more than a single target 
		/// state! So its only save to use this method for DFAs!
		/// </summary>
		/// <param name="aSourceState">The state to start from</param>
		/// <param name="anInput">The input symbol to be read by the FSM</param>
		/// <returns>The state being reached from aSourceState when parsing input symbol
		/// anInput</returns>
		IState GetNextState(IState aSourceState, IInput anInput);
		
		/// <summary>
		///     Returns an array of the ITransitions starting 
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
		///		The transitions starting at aSourceState
		///   with the input symbol anInput.
		/// </returns>
		ITransition[] GetNextTransitions(IState aSourceState, IInput anInput);
		
		/// <summary>
		///     Returns the next ITransition starting 
		///     at aSourceState with the input symbol 
		///     anInput. <br></br>
		///     NOTE: This method is only save for DFAs. If there are more than a single
		///     transtion fullfiling the criteria an exception is thrown!
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
		ITransition GetNextTransition(IState aSourceState, IInput anInput);

		/// <summary>
		///     Returns all <b>valid</b> transitions for aSourceState.
		/// </summary>
		/// <param name="aSourceState">
		///		The source for which all valid transitions are returned.
		///	</param>
		/// <returns>
		///		A Hashtable containing all transitions for the source state.
		///     The key of the Hashtable is the Input and the value the
		///     corresponding ITransition.
		/// </returns>
		ITransition[] GetOutgoingTransitions(IState aSourceState);

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
		IState[] GetReachableStates(IState aState);

		/// <summary>
		///     Searches for all transitions reachable from aState. This means
		///     there exists a path from aState to every transition contained
		///     in the result.
		/// </summary>
		/// 
		/// <param name="aState">The search starts here.</param>
		/// 
		/// <returns>An IList containing all reachable transitions.</returns>
		ITransition[] GetReachableTransitions(IState aState);

		/// <summary>
		/// Checks whether aState is in FinalStates or not.
		/// </summary>
		/// <param name="aState">A state of this FSM.</param>
		/// <returns>True, if FinalStates contains aState, false otherwise.</returns>
		bool IsFinalState(IState aState);
	}
}




