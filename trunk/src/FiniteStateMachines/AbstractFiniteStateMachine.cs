using System;
using System.Collections;
using Utils.Collections;
using Utils.Exceptions;


namespace FiniteStateMachines {

    /// <summary>The AbstractFiniteStateMachine implements some
    ///     default functionality useful for most finite state
    ///     machines.
    /// 
    /// </summary>
	public abstract class AbstractFiniteStateMachine : IFiniteStateMachine {
		
    	/// <summary>
		/// Constant for the name of an error state.
		/// </summary>
		private const string ERROR_STATE_NAME = "ErrorState";

        /// <summary>
        ///     All transitions with an unallowed input
        ///     lead to this error state.
        /// </summary>
		private AbstractState errorState;

        /// <summary>All transitions with an unallowed input
        ///     lead to this error state.</summary>
		public virtual AbstractState ErrorState { 
            get{
                if(errorState == null){
                    errorState = CreateErrorState();
                }
                return errorState;
            }
        }

        /// <summary>If the automata is used for accepting 
        ///     an input sequence, this is the state to
        ///     start with.
        /// </summary>
		public abstract AbstractState StartState { get; }

        /// <summary>If the automata reaches one of this states
        ///     during reading an input sequence, the
        ///     sequence is accepted.</summary>
		public abstract Set FinalStates { get; }

        /// <summary>
        /// A set of <code>Input</code> objects.
        /// This are the valid input symbols for
        /// this automata.
        /// </summary>
		public abstract Set InputAlphabet { get; }

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
		public abstract AbstractState GetNextState(AbstractState aSourceState, Input anInput);

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
		public abstract Transition GetNextTransition(AbstractState aSourceState, Input anInput);
        
        
        /// <summary>
        ///     Returns all _valid_ transitions with the source state.
        /// </summary>
        /// 
        /// <param name="aSourceState">The source for which all valid transitions are returned.</param>
        /// 
        /// <returns>A Hashtable which contains all transtions for the source state.
        ///     The key of the Hashtable is the Input and the value the
        ///     corresponding Transition.</returns>
		public abstract IList GetOutgoingTransitions(AbstractState aSourceState);

        /// <summary>Adds a single transition to the automata.
        ///     The default behaviour is to throw an MethodNotImplementedException, 
        ///     because for some automatas it is not possible to
        ///     implement this method.</summary>
        /// 
        /// <param name="aTransition">The transition to add to the automata.</param>
        public virtual void AddTransition(Transition aTransition){
            throw new MethodNotImplementedException();
        }

        /// <summary>Adds a list of transitions to the automata.
        ///     The default behaviour is to throw an MethodNotImplementedException, 
        ///     because for some automatas it is not possible to
        ///     implement this method.
        /// </summary>
        /// 
        /// <param name="aTransitionList">A list of transitions.</param>
        public virtual void AddTransitionList(IList aTransitionList){
            throw new MethodNotImplementedException();
        }


        /// <summary>Searches for all states reachable from aState. This means
        ///     there exists a path from aState to every state contained 
        ///     in the result. Certainly aState is also included in
        ///     the result.</summary>
        /// 
        /// <param name="aState">The search starts here.</param>
        /// 
        /// <returns>An IList containing all reachable States.</returns>
		public virtual IList GetReachableStates(AbstractState aState) {
			IList resultSet = new ArrayList();
			GetReachableStatesRecursive(aState,ref resultSet);
			return resultSet;
		}


        /// <summary>Searches for all states reachable from aState. This means
        ///     there exists a path from aState to every state contained 
        ///     in the result. Certainly aState is also included in
        ///     the result. This is done recursively.</summary>
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

