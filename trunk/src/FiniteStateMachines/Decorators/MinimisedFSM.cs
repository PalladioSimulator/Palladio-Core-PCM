using System;
using System.Collections;
using Utils.Collections;
using log4net;
using log4net.Config;

namespace FiniteStateMachines.Decorators
{
	/// <summary>
	/// </summary>
	public class MinimisedFSM : AbstractFiniteStateMachine
	{
		private static readonly int ERROR_STATE_INDEX = -1;

		private IList groups;

		private static readonly ILog log = LogManager.GetLogger(typeof(MinimisedFSM));

		private AbstractState startState;

		private Set finalStates;

		private IFiniteStateMachine fsm;

		/// <summary>
		/// Throws an exception if the incoming fsm has no start or final states.
		/// </summary>
		/// <param name="aFSM"></param>
		public MinimisedFSM(IFiniteStateMachine aFSM) {
			fsm = aFSM;
			CreateMinimizedGroups(aFSM);

			try {
				startState = GetRepresentative(aFSM.StartState);
			} catch (Exception) {
				throw new ApplicationException("aFSM has no start state!");
			}

			try {
				finalStates = new Set();
				foreach ( AbstractState state in aFSM.FinalStates ) {
					finalStates.Add( GetRepresentative( state ) );
				}
			} catch (Exception) {
				throw new ApplicationException("aFSM has no final states!");
			}
		}

		/// <summary>
		///     If the automaton is used for accepting
		///     an input sequence, this is the state to
		///     start with.
		/// </summary>
		public override AbstractState StartState { 
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
		///     Returns the next Transition
		///     starting at aSourceState
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
		public override Transition GetNextTransition(AbstractState aSourceState, Input anInput){
			Transition result = (Transition)fsm.GetNextTransition( aSourceState, anInput).Clone();
			AbstractState repState = GetRepresentative (result.DestinationState);
			result.DestinationState = repState;
			return result;
		}
        

		private void CreateMinimizedGroups ( IFiniteStateMachine aFSM ) {	
			this.groups = InitGroups(aFSM);
			bool changed;
			do {
				changed = false;
				for ( int groupIndex = 0; groupIndex < this.groups.Count; groupIndex++ ) {
					IList currentGroup = (IList) this.groups[groupIndex];
					IList newGroup = new ArrayList();
					AbstractState firstState = (AbstractState) currentGroup[0];

					for ( int i = 1; i < currentGroup.Count; i++ ) {
						AbstractState nextState = (AbstractState) currentGroup[i];

						foreach ( Input input in aFSM.InputAlphabet ) {
							AbstractState targetFirst = aFSM.GetNextState( firstState, input );
							AbstractState targetNext = aFSM.GetNextState( nextState, input );
							if(GetGroupIndex(targetFirst)!=GetGroupIndex(targetNext)) {
								newGroup.Add( nextState );
								break;
							}
						}
					}

					if ( newGroup.Count > 0 ) {
						changed = true;
						this.groups.Add( newGroup );

						foreach (AbstractState state in newGroup) {
							currentGroup.Remove(state);
						}
					}
				}
			} while ( changed );
		}


		private IList InitGroups(IFiniteStateMachine aFSM) {
			IList groups = new ArrayList();
			IList finalStates = new ArrayList();
			IList notFinalStates = new ArrayList();
			
			StateIterator stateIter = new StateIterator(aFSM);
			while(stateIter.MoveNext()){
				if(((AbstractState) stateIter.Current).IsFinalState){
					finalStates.Add(stateIter.Current);
				}
				else {
					notFinalStates.Add(stateIter.Current);
				}
			}
			if (finalStates.Count > 0){
				groups.Add(finalStates);
			}
			if (notFinalStates.Count > 0) {
				groups.Add(notFinalStates);
			}
			return groups;
		}


		protected int GetGroupIndex(AbstractState aState) {
			if (aState == fsm.ErrorState ) {
				return ERROR_STATE_INDEX;
			}
			for(int i = 0 ; i< this.groups.Count; i++) {	
				if(((IList)groups[i]).Contains(aState)) {
					return i;
				}
			}
			// index of the new group, when it is added
			return this.groups.Count;
		}


		private AbstractState GetRepresentative( AbstractState aState ) {
			if ( aState != fsm.ErrorState ) {
				int index = GetGroupIndex(aState);
				return (AbstractState) ((IList)this.groups[index])[0];
			} else {
				return ErrorState;
			}
		}
	}
}
