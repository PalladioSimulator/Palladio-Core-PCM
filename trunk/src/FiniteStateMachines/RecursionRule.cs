using System;
using System.Collections;

using FiniteStateMachines;
using FiniteStateMachines.Decorators;
using Utils.Collections;

namespace ParameterisedContracts {

	public class RecursiveFSM : AbstractStackFSM {

		public RecursiveFSM ( Input aRecursiveServiceName, Hashtable aServiceTable ) {
			Initialize( aRecursiveServiceName, aServiceTable );
		}


		/// <summary>
		///     Identifies the transition starting at aSourceState with the
		///     input anInput.
		/// </summary>
		/// 
		/// <param name="aSourceState"></param>
		/// <param name="anInput"></param>
		/// 
		/// <returns>The next possible transition</returns>
		/// <seealso cref="IFiniteStateMachine.GetNextTransition"></seealso>
		public override Transition GetNextTransition(AbstractState aSourceState, Input anInput) {
			Transition result = CreateTransition(aSourceState,anInput,ErrorState);

			if (aSourceState is StackState) {
				StackState state = (StackState)aSourceState;
				if (ServiceTable.ContainsKey(anInput)) {
					result = CallService(state,anInput);
				} 
				else if ((!state.IsEmpty) && (ServiceTable.ContainsKey(state.Peek().ServiceName))) {
					IFiniteStateMachine topService = LookUpService(state.Peek().ServiceName);
					if (topService.InputAlphabet.Contains(anInput)) {
						result = GetTransitionInService(topService,state,anInput);
					} 
					else if (anInput == Input.RETURN) {
						result = ReturnFromService(state);
					}
				}
			} 
			else if (aSourceState == ErrorState) {
				// Stay in ErrorState, nothing to do
			} 
			else {
				throw new InvalidStateException("The state '"+aSourceState+"' is not a StackState");
			}
			return result;
		}


		/// <summary>
		/// Identifies the transition starting at aSourceState with the 
		/// input aServiceName.
		/// 
		/// Creates a "cycle" in the FSM representing the recursion. Adds a new RecursionInput 
		/// and CounterCondition object to the FSM.
		/// 
		/// pre: a recursion was detected
		/// </summary>
		/// <param name="aSourceState">StackState for which the recursion was detected</param>
		/// <param name="aServiceName">Recursive symbol</param>
		/// <returns>The transition object of aSourceState.Peek().ServiceName with altered states</returns>
		protected override Transition HandleRecursionCall(StackState aSourceState, Input aServiceName) {
			Input callingServiceName = aSourceState.Peek().ServiceName;
			Transition recursiveTransition = LookUpService(callingServiceName).GetNextTransition(aSourceState.Peek().State,aServiceName);
			RecursionInput recInput = new RecursionInput( callingServiceName, aServiceName, recursiveTransition.DestinationState);
			InputAlphabet.Add(recInput);
			Console.WriteLine ( "Recursion detected: " + recInput);
			Transition result = (Transition) recursiveTransition.Clone();
			result.SetValues ( aSourceState, aServiceName, StartState);
			return result;
		}



		protected override bool CheckRecursion(StackState aState, Input aServiceName) {
			return !aState.LookupServiceName(aServiceName).IsEmpty;
		}
	}
}
