using System;
using Utils.Collections;
using System.Collections;
using FiniteStateMachines;

namespace ParameterisedContracts {

	/// <summary>
	///		A CallingServiceFSM represents the inner context of a recursive
	///		service in a StackFSM. It is used to handle 
	///		the terminal part of the recursive function.
	///		
	///		author: JH
	/// </summary>
	public class CallingServiceFSM : AbstractFSM {

		/// <summary>
		///		Target state of the recursive transition.
		/// </summary>
		private IState recursionEndState;

		/// <summary>
		///		Final states reachable from recursionEndState.
		/// </summary>
		private Set reachableFinalStates;

		/// <summary>
		///     A set of valid input symbols for
		///     this automaton.
		/// </summary>
		private Set inputAlphabet;

		/// <summary>
		///		FSM used for adaption.
		/// </summary>
		private IFiniteStateMachine originalFSM;

		/// <summary>
		///		
		/// </summary>
		private RecursionInput recursionInput;

		/// <summary>
		///		States reachable from recursionEndState
		/// </summary>
		private IList reachableStatesList;


		/// <summary>
		///		Creates a new FSM by extending aFSM with transitions form
		///		certain final states to the destination state of the recursive
		///		transition. The input symbol of that transition is aRecursionInput.
		/// </summary>
		public CallingServiceFSM ( IFiniteStateMachine aFSM, RecursionInput aRecursionInput){
			originalFSM = aFSM;
			recursionInput = aRecursionInput;

			recursionEndState = recursionInput.TargetState;
			reachableFinalStates = new Set();
			reachableStatesList = originalFSM.GetReachableStates(recursionEndState);
			foreach( IState state in reachableStatesList ){
				if (state.IsFinalState) {
					reachableFinalStates.Add(state);
				}
			}

			inputAlphabet = (Set)originalFSM.InputAlphabet.Clone();
			inputAlphabet.Add(recursionInput);
			inputAlphabet.Remove(recursionInput.RecursiveServiceName);
			inputAlphabet.Add(new MarkedInput(recursionInput.RecursiveServiceName));
		}

		/// <summary>
		///     If the automaton is used for accepting
		///     an input sequence, this is the state to
		///     start with.
		/// </summary>
		public override IState StartState { 
			get { return originalFSM.StartState; } 
		}

		/// <summary>
		///     If the automaton reaches one of this states
		///     during reading an input sequence, the
		///     sequence is accepted.
		/// </summary>
		public override Set FinalStates { 
			get { return originalFSM.FinalStates; } 
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
		public override Transition GetNextTransition(IState aSourceState, Input anInput) {
			Transition result = new Transition(aSourceState,anInput,ErrorState);

			if (anInput is MarkedInput) {
				Input input = ((MarkedInput) anInput).GetUnMarkedInput();
				result.DestinationState = originalFSM.GetNextState(aSourceState,input);
			} else {
				if ( anInput == recursionInput ) {
					if ( reachableFinalStates.Contains( aSourceState )) {
						result.DestinationState = recursionEndState;
					}
				} else {
					result = originalFSM.GetNextTransition(aSourceState,anInput);
				}
			}
			return result;
		}
	}
}
