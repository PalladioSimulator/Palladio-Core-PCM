using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.FiniteStateMachines.Decorators {
	
	/// <summary>
	/// The MinimisedFSM behaves like the original FSM. It accepts the same
	/// language, but it does not contain any equivalent states. So it has
	/// the smallest possible number of states.
	/// </summary>
	internal class MinimisedFSM : AbstractFSM {

		/// <summary>
		/// Group index of ErrorState.
		/// </summary>
		private static readonly int ERROR_STATE_INDEX = -1;

		/// <summary>
		/// IList of groups of equivalent states. Each group is
		/// also an IList.
		/// </summary>
		private IList groups;

		/// <summary>
		/// Representative of the group containing the start state 
		/// of the original FSM. This is not inevitable the same as
		/// in the original FSM!
		/// </summary>
		private IState startState;

		/// <summary>
		/// Set of representatives of the groups of each original
		/// final states. Not inevitable the same as in the original
		/// FSM.
		/// </summary>
		private Set finalStates;

		/// <summary>
		/// Original and unminimised FSM.
		/// </summary>
		private IFiniteStateMachine fsm;

		/// <summary>
		/// Requires a complete FSM, meaning that a start state and final states
		/// are required. Otherwise an exception is thrown.
		/// </summary>
		/// <param name="aFSM">
		/// FSM to minimise.
		/// </param>
		public MinimisedFSM(IFiniteStateMachine aFSM) {
			fsm = aFSM;
			groups = InitGroups(aFSM);
			
			MinimiseGroups(aFSM);

			try {
				startState = GetRepresentative(aFSM.StartState);
			} 
			catch (Exception) {
				throw new ApplicationException("aFSM has no start state!");
			}

			try {
				finalStates = new Set();
				foreach ( IState state in aFSM.FinalStates ) {
					finalStates.Add( GetRepresentative( state ) );
				}
			} 
			catch (Exception) {
				throw new ApplicationException("aFSM has no final states!");
			}
		}

		/// <summary>
		///     If the automaton is used for accepting
		///     an input sequence, this is the state to
		///     start with.
		/// </summary>
		public override IState StartState { 
			get { return startState; }
		}

		/// <summary>
		///     If the automaton reaches one of this states
		///     during reading an input sequence, the
		///     sequence is accepted.
		/// </summary>
		public override Set FinalStates { 
			get { return finalStates; }
		}

		/// <summary>
		///     A set of valid input symbols for this automaton.
		/// </summary>
		public override Set InputAlphabet { 
			get { return fsm.InputAlphabet; }
		}

		/// <summary>
		///     Returns the next ITransition starting at aSourceState
		///     with the input symbol anInput.
		/// </summary>
		/// 
		/// <param name="aSourceState">
		///		The source of the transition.
		///	</param>
		/// <param name="anInput">
		///		The input of the transition.
		///	</param>
		/// <returns>
		///		The transition starting at aSourceState
		///     with the input symbol anInput. 
		/// </returns>
		public override ITransition GetNextTransition(IState aSourceState, Input anInput) {
			ITransition result = (ITransition)fsm.GetNextTransition( aSourceState, anInput).Clone();
			result.DestinationState = GetRepresentative (result.DestinationState);
			return result;
		}
        

		/// <summary>
		/// Requires that the groups are initialised. Implements the default
		/// minimisation algorithm:
		/// As long as any of the groups contains states which are not equivalent,
		/// they are extracted into a new group.
		/// </summary>
		/// <param name="aFSM">
		/// Original and unminimised FSM.
		/// </param>
		private void MinimiseGroups ( IFiniteStateMachine aFSM ) {	
			bool changed;
			do {
				changed = false;
				for ( int groupIndex = 0; groupIndex < this.groups.Count; groupIndex++ ) {
					IList currentGroup = (IList) this.groups[groupIndex];
					IList newGroup = new Vector();
					IState firstState = (IState) currentGroup[0];

					for ( int i = 1; i < currentGroup.Count; i++ ) {
						IState nextState = (IState) currentGroup[i];

						foreach ( Input input in aFSM.InputAlphabet ) {
							IState targetFirst = aFSM.GetNextState( firstState, input );
							IState targetNext = aFSM.GetNextState( nextState, input );
							if(GetGroupIndex(targetFirst)!=GetGroupIndex(targetNext)) {
								newGroup.Add( nextState );
								break;
							}
						}
					}

					if ( newGroup.Count > 0 ) {
						changed = true;
						groups.Add( newGroup );

						foreach (IState state in newGroup) {
							currentGroup.Remove(state);
						}
					}

				}
			} while ( changed );
		}


		/// <summary>
		/// Creates two initial groups. One containg the final states, one
		/// containg the rest.
		/// </summary>
		/// <param name="aFSM">
		/// Original and unminimised FSM.
		/// </param>
		/// <returns>
		/// Initial group partitioning.
		/// </returns>
		private IList InitGroups(IFiniteStateMachine aFSM) {
			IList groups = new Vector();
			IList finalStates = new Vector();
			IList notFinalStates = new Vector();
			
		  StateIteratorOld stateIter = new StateIteratorOld(aFSM);
			while(stateIter.MoveNext()) {
				if(((IState) stateIter.Current).IsFinalState) {
					finalStates.Add(stateIter.Current);
				}
				else {
					notFinalStates.Add(stateIter.Current);
				}
			}
			if (finalStates.Count > 0) {
				groups.Add(finalStates);
			}
			if (notFinalStates.Count > 0) {
				groups.Add(notFinalStates);
			}
			return groups;
		}


		/// <summary>
		/// Index of the group containing aState. If aState is an
		/// ErrorState the ERROR_STATE_INDEX is returned. If aState
		/// is not in one of the groups, it is assumed that it is in 
		/// the new group and the index of the next free field is returned.
		/// (the new group will be stored there)
		/// </summary>
		/// <param name="aState">
		/// State to lookup.
		/// </param>
		/// <returns>
		/// Index of the group containing aState.
		/// </returns>
		protected int GetGroupIndex(IState aState) {
			if (!aState.Equals(fsm.ErrorState) ) {
				for(int i = 0 ; i< this.groups.Count; i++) {	
					if(((IList)groups[i]).Contains(aState)) {
						return i;
					}
				}
				// index of the new group, when it will be added
				return groups.Count;
			} else {
				return ERROR_STATE_INDEX;
			}
		}


		/// <summary>
		/// Returns one representative of the group aState belongs to.
		/// </summary>
		/// <param name="aState">
		/// State to represent.
		/// </param>
		/// <returns>
		/// One representative of the group of aState.
		/// </returns>
		private IState GetRepresentative( IState aState ) {
			if ( !aState.Equals(fsm.ErrorState) ) {
				int index = GetGroupIndex(aState);
				return (IState) ((IList)this.groups[index])[0];
			} 
			else {
				return ErrorState;
			}
		}
	}
}
