using System;
using System.Collections;
using Utils.Collections;
using Utils.Exceptions;


namespace FiniteStateMachines {

    /// <summary>
    ///     The AbstractFiniteStateMachine implements some
    ///     default functionality useful for most finite state
    ///     machines.
    /// </summary>
	public abstract class AbstractFiniteStateMachine : IFiniteStateMachine {
		
        /// <summary>
        ///     Constant for the name of an error state.
        /// </summary>
		private const string ERROR_STATE_NAME = "error state";

        /// <summary>
        ///     All transitions with an unallowed input
        ///     lead to this error state.
        /// </summary>
        /// 
        /// <seealso cref="ErrorState"></seealso>
		private AbstractState errorState;

        /// <summary>
        ///     All transitions with an unallowed input
        ///     lead to this error state.
        /// </summary>
        /// 
        /// <seealso cref="IFiniteStateMachine.ErrorState"></seealso>
		public virtual AbstractState ErrorState { 
            get{
                if(errorState == null){
                    errorState = CreateErrorState();
                }
                return errorState;
            }
        }

        /// <summary>
        ///     If the automaton is used for accepting
        ///     an input sequence, this is the state to
        ///     start with.
        /// </summary>
        /// 
        /// <seealso cref="IFiniteStateMachine.StartState"></seealso>
		public abstract AbstractState StartState { get; }

        /// <summary>
        ///     If the automaton reaches one of this states
        ///     during reading an input sequence, the
        ///     sequence is accepted.
        /// </summary>
        /// 
        /// <seealso cref="IFiniteStateMachine.FinalStates"></seealso>
		public abstract Set FinalStates { get; }

        /// <summary>
        ///     A set of valid input symbols for this automaton.
        /// </summary>
		public abstract Set InputAlphabet { get; }

        /// <summary>
        ///     Returns the target of a transition
        ///     starting at aSourceState with the input
        ///     symbol anInput.
        /// </summary>
        /// 
        /// <param name="aSourceState">The source of the transition.</param>
        /// <param name="anInput">The input symbol of the transition.</param>
        /// 
        /// <returns>The destination of the transition.</returns>
        /// <seealso cref="IFiniteStateMachine.GetNextState"></seealso>
		public abstract AbstractState GetNextState(AbstractState aSourceState, Input anInput);

        /// <summary>
        ///     Returns the next Transition
        ///     starting at aSourceState
        ///     with the input symbol anInput.
        /// </summary>
        /// 
        /// <param name="aSourceState">The source of the transition.</param>
        /// <param name="anInput">The input of the transition.</param>
        /// 
        /// <returns>The transition starting at aSourceState
        ///     with the input symbol anInput. </returns>
        /// <seealso cref="IFiniteStateMachine.GetNextTransition"></seealso>
		public abstract Transition GetNextTransition(AbstractState aSourceState, Input anInput);
        
        
        /// <summary>
        ///     Returns all _valid_ transitions with the source state.
        /// </summary>
        /// 
        /// <param name="aSourceState">The source for which all valid transitions are returned.</param>
        /// 
        /// <returns>A Hashtable which contains all transitions for the source state.
        ///     The key of the Hashtable is the Input and the value the
        ///     corresponding Transition.</returns>
        /// <seealso cref="IFiniteStateMachine.GetOutgoingTransitions"></seealso>
		public abstract IList GetOutgoingTransitions(AbstractState aSourceState);

        /// <summary>
        ///     Adds a single transition to the automaton.
        ///     The default behaviour is to throw an MethodNotImplementedException,
        ///     because for some automatons it is not possible to
        ///     implement this method.
        /// </summary>
        /// 
        /// <param name="aTransition">The transition to add to the automaton.</param>
        /// 
        /// <seealso cref="IFiniteStateMachine.AddTransition"></seealso>
        public virtual void AddTransition(Transition aTransition){
            throw new MethodNotImplementedException();
        }

        /// <summary>
        ///     Adds a list of transitions to the automaton.
        ///     The default behaviour is to throw an MethodNotImplementedException,
        ///     because for some automatons it is not possible to
        ///     implement this method.
        /// </summary>
        /// 
        /// <param name="aTransitionList">A list of transitions.</param>
        /// 
        /// <seealso cref="IFiniteStateMachine.AddTransitionList"></seealso>
        public virtual void AddTransitionList(IList aTransitionList){
            throw new MethodNotImplementedException();
        }


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
		public virtual IList GetReachableStates(AbstractState aState) {
			IList resultSet = new ArrayList();
			GetReachableStatesRecursive(aState,ref resultSet);
			return resultSet;
		}


        /// <summary>
        ///     Searches for all states reachable from aState. This means
        ///     there exists a path from aState to every state contained
        ///     in the result. Certainly aState is also included in
        ///     the result. This is done recursively.
        /// </summary>
        /// 
        /// <param name="aState">starting here</param>
        /// <param name="resultSet">An IList containing the visited states.</param>
		private void GetReachableStatesRecursive(AbstractState aState,ref IList resultSet) {
			if ((!resultSet.Contains(aState)) && (aState!=ErrorState)) {
				resultSet.Add(aState);
				IList transitions = GetOutgoingTransitions(aState);
				if (transitions != null) {
					foreach (Transition trans in transitions) {
						GetReachableStatesRecursive(trans.DestinationState,ref resultSet);
					}
				}
			}
		}


        /// <summary>
        ///     Creates a new state representing a default error state.
        /// </summary>
        /// 
        /// <returns>Default error state.</returns>
		public static AbstractState CreateErrorState(){
			return new State(ERROR_STATE_NAME,false,false);
		}
    }
}

