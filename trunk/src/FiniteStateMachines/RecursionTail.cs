using System;
using Utils.Collections;
using System.Collections;
using FiniteStateMachines;

namespace ParameterisedContracts {

	public class CallingFSM : AbstractFiniteStateMachine {

		private AbstractState recursiveStartState;
		private Set recursiveFinalStates;
		private Set inputAlphabet;

		private IFiniteStateMachine fsm;
		private RecursionInput recursionInput;
		private IList reachableStatesList;

		public CallingFSM ( IFiniteStateMachine aFSM, RecursionInput aRecursionInput){
			fsm = aFSM;
			recursionInput = aRecursionInput;

			recursiveStartState = recursionInput.TargetStateOfCallingService;
			recursiveFinalStates = new Set();
			reachableStatesList = fsm.GetReachableStates(recursiveStartState);
			foreach( AbstractState state in reachableStatesList ){
				if (state.IsFinalState) {
					recursiveFinalStates.Add(state);
				}
			}

			inputAlphabet = (Set)fsm.InputAlphabet.Clone();
			inputAlphabet.Add(recursionInput);
			inputAlphabet.Remove(recursionInput.RecursiveServiceName);
			inputAlphabet.Add(new MarkedInput(recursionInput.RecursiveServiceName));
		}

		/// <summary>
		///     If the automaton is used for accepting
		///     an input sequence, this is the state to
		///     start with.
		/// </summary>
		/// 
		/// <seealso cref="IFiniteStateMachine.StartState"></seealso>
		public override AbstractState StartState { 
			get { return fsm.StartState; } 
		}

		/// <summary>
		///     If the automaton reaches one of this states
		///     during reading an input sequence, the
		///     sequence is accepted.
		/// </summary>
		/// 
		/// <seealso cref="IFiniteStateMachine.FinalStates"></seealso>
		public override Set FinalStates { 
			get { return fsm.FinalStates; } 
		}

		/// <summary>
		///     A set of valid input symbols for this automaton.
		/// </summary>
		public override Set InputAlphabet { 
			get { return  inputAlphabet; }
		}


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
		public override Transition GetNextTransition(AbstractState aSourceState, Input anInput) {
			Transition result = new Transition(aSourceState,anInput,ErrorState);

			if (anInput is MarkedInput) {
				Input input = ((MarkedInput) anInput).GetUnMarkedInput();
				result.DestinationState = fsm.GetNextState(aSourceState,input);
			} else {
				if ( anInput == recursionInput ) {
					if ( recursiveFinalStates.Contains( aSourceState )) {
						result.DestinationState = recursiveStartState;
					}
				} else {
					result = fsm.GetNextTransition(aSourceState,anInput);
				}
			}
			return result;
		}
	}
}
