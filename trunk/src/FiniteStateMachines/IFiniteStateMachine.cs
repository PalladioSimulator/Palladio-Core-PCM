using System;
using System.Collections;
using Utils.Collections;


namespace FiniteStateMachines {

    /// <summary>
    ///     All finite state machines have to implement this interface. It
    ///     provides a simple protocol for the default functionality of a finte
    ///     state machine.
    /// </summary>
	public interface IFiniteStateMachine {

        /// <summary>
		/// All transitions with an unallowed input
        /// lead to <code>errorState</code>.
		/// </summary>
		AbstractState ErrorState { get; }

        /// <summary>If the automata is used for accepting 
        ///     an input sequence, this is the state to
        ///     start with.
        /// </summary>
		AbstractState StartState { get; }

        /// <summary>If the automata reaches one of this states
        ///     during reading an input sequence, the
        ///     sequence is accepted.</summary>
		Set FinalStates { get; }

        /// <summary>
        /// A set of <code>Input</code> objects.
        /// This are the valid input symbols for
        /// this automata.
        /// </summary>
		Set InputAlphabet { get; }

        /// <summary>
        /// Returns the the target of a transiton
        /// starting at <code>aSourceState</code>
        /// with the input symbol <code>anInput</code>.
        /// </summary>
        /// 
        /// <param name="aSourceState">The source of the transition.</param>
        /// <param name="anInput">The input symbol of the transition.</param>
        /// 
        /// <returns>The destination of the transition.</returns>
		AbstractState GetNextState(AbstractState aSourceState, Input anInput);

        /// <summary>
        /// Returns the next <code>Transition</code> 
        /// starting at <code>aSourceState</code> 
        /// with the input symbol <code>anInput</code>.
        /// </summary>
        /// 
        /// <param name="aSourceState">The source of the transition.</param>
        /// <param name="anInput">The input of the transition.</param>
        /// 
        /// <returns>The transition starting at <code>aSourceState</code>
        /// with the input symbol <code>anInput</code> </returns>
		Transition GetNextTransition(AbstractState aSourceState, Input anInput);

        /// <summary>
        ///     Returns all _valid_ transitions with the source state.
        /// </summary>
        /// 
        /// <param name="aSourceState">The source for which all valid transitions are returned.</param>
        /// 
        /// <returns>A Hashtable which contains all transtions for the source state.
        ///     The key of the Hashtable is the Input and the value the
        ///     corresponding Transition.</returns>
		IList GetOutgoingTransitions(AbstractState aSourceState);

        /// <summary>Adds a single transition to the automata.</summary>
        /// 
        /// <param name="aTransition">The transition to add to the automata.</param>
        void AddTransition(Transition aTransition);

        /// <summary>Adds a list of transitions to the automata.</summary>
        /// 
        /// <param name="aTransitionList">A list of transitions.</param>
        void AddTransitionList(IList aTransitionList);
	}

}




