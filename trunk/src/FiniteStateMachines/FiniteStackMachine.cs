using System;
using System.Collections;

using FiniteStateMachines;
using FiniteStateMachines.Decorators;
using Utils.Collections;

namespace ParameterisedContracts {
	
	/// <summary>
	///     Class simulating a conjunction of several others FSMs. 
	///     
	///     author: JH
	/// </summary>
	public class StackFSM : AbstractStackFSM {

		/// <summary>
		/// A set of counter conditions. These conditions are not checked!
		/// </summary>
		private Hashtable counterConditionTable;

		/// <summary>
		///     Standard constructor. Creates a new StackFiniteStateMachine.
		/// </summary>
		/// 
		/// <param name="aProvidesProtocol">The top finite state machine which calls all other automatons.</param>
		/// <param name="aServiceEffectSpecificationTable">Mapping of a set of input symbols onto a set of automatons.</param>
		public StackFSM(IFiniteStateMachine aTopService, Input aTopServiceName, Hashtable aServiceTable) {
			// avoid modifications of the original table
			Hashtable serviceTable = (Hashtable) aServiceTable.Clone();
			serviceTable.Add(aTopServiceName,aTopService);
			counterConditionTable = new Hashtable();
			Initialize(aTopServiceName,serviceTable);
		}


		public StackFSM(Input aTopServiceName, Hashtable aServiceTable) {
			counterConditionTable = new Hashtable();
			Initialize(aTopServiceName,aServiceTable);
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
		public override Transition GetNextTransition(IState aSourceState, Input anInput) {
			Transition result = CreateTransition(aSourceState,anInput,ErrorState);

			if (aSourceState is StackState) {
				StackState state = (StackState)aSourceState;
				if (anInput is RecursionInput) {
					result = HandleRecursionInput(state,(RecursionInput)anInput);
				} 
				else if (ServiceTable.ContainsKey(anInput)) {
					result = CallService(state,anInput);
				} 
				else if ((!state.InTopService) && (ServiceTable.ContainsKey(state.Peek().ServiceName))) {
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
			Transition result = null;
			IFiniteStateMachine service = LookUpService(aSourceState.Peek().ServiceName);
			result = (Transition)service.GetNextTransition(aSourceState.Peek().State,aServiceName).Clone();
			RecursionInput recInput = new RecursionInput(aSourceState.Peek().ServiceName,aServiceName, result.DestinationState);
			// TODO check this condition - does it detect already handled recursions?
			if (!InputAlphabet.Contains(recInput)) {
				CounterCondition cc = new CounterCondition(aServiceName,recInput,1);
				InputAlphabet.Add(recInput);
				counterConditionTable.Add(recInput,cc);
			}
			StackState destination = aSourceState.LookupServiceName(aServiceName);
			if (!destination.IsEmpty){
				result.SetValues(aSourceState,aServiceName,destination);
			} else {
				throw new ApplicationException("Empty destination state!");
			}
			return result;
		}


		/// <summary>
		/// Identifies the transition starting at aSourceState with the 
		/// input aRecInput.
		/// 
		/// Check if the recursion input is allowed and determin the destination of the transition.
		/// 
		/// pre: the current input symbol is a RecursionInput
		/// </summary>
		/// <param name="aSourceState">Source state</param>
		/// <param name="aRecInput">Recursion input</param>
		/// <returns>A new transition from source to destination</returns>
		private Transition HandleRecursionInput(StackState aSourceState, RecursionInput aRecInput) {
			IState destinationState = ErrorState;
			// Recursive Transitions are only allowed in the corresponding service
			if( aSourceState.Peek().ServiceName == aRecInput.CallingServiceName) {
				// the transition is only allowed outside the recursion handling
				if( (aSourceState.Peek().State.IsFinalState) && (aSourceState.LookupServiceNameTwice(aRecInput.RecursiveServiceName).IsEmpty)) {
					TabularFSM service = (TabularFSM)LookUpService(aSourceState.Peek().ServiceName);
					IList reachableStates = service.GetReachableStates(aRecInput.TargetState);
					if (reachableStates.Contains(aSourceState.Peek().State)) {
						destinationState = new StackState(aSourceState);
						((StackState)destinationState).ChangeTopState(aRecInput.TargetState);
					}
				}
			}
			return CreateTransition(aSourceState,aRecInput,destinationState);
		}


		/// <summary>
		/// Tests aState and aServiceName for recursion. If aServiceName is
		/// called in aState, is that a recursion?
		/// </summary>
		protected override bool CheckRecursion(StackState aState, Input aServiceName) {
			return !aState.LookupServiceNameTwice(aServiceName).IsEmpty;
		}

	}
}