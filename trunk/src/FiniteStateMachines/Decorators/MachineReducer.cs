using System;
using System.Collections;

using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Decorators;
using Utils.Collections;

namespace Palladio.ParameterisedContracts {
	/// <summary>
	///		The MachineReducer reduces a FSM using a set of other FSMs. 
	///		It is assumed, that the FSM which should be reduced is a 
	///		somehow modified StackFiniteStateMachine.
	///		
	///		The reduction of the source FSM is done by graph grammars, 
	///		using some essential modifications to meet the performance 
	///		requirements.
	///		
	///		So whats different to graph grammars:
	///			
	///		At first we don't have any indeterminism in our algorithm. It is
	///		always clear where a rule has to be applied and which one it must
	///		be. This is because we begin our application at the start state of the 
	///		FSM and walk from there trough the whole automaton. We know the rule
	///		to apply because of the calling transitions of the subautomatons. We
	///		also know, that the result of the application can only be a transiton,
	///		labeled the same as the calling transition.
	///		
	///		An other point is the possibility of recursive calls during a Match. If
	///		an other calling transition is found during a Match the corresponding Match 
	///		function is called recursively. This avoids the necessity of resets.
	///		
	///		author: JH
	/// </summary>
	internal class FSMReducer {
		
		/// <summary>
		///		The ruleTable impicitly contains all rules which should be applied to the 
		///		automaton. The calling transition and the return transition are not 
		///		explicitly added to the rule, but they are expected by the Match(...) 
		///		function. Also the transitions to which the FSMs are reduced are not 
		///		stored, but its input symbols.
		///		
		///		It is organized as follwed:
		///		Key: Input 
		///		Value: IList of IFiniteStateMachines 
		/// </summary>
		private Hashtable ruleTable;

		
		/// <summary>
		///		The original automaton, which is reduced.
		/// </summary>
		private IFiniteStateMachine originalFSM;


		/// <summary>
		///		Applies the rule associated with the Input of aStartTransition to
		///		the originalMachine. Recursively all other rules needed to perform this
		///		reduction are executed. Implicitly requires aCallingTransition and valid
		///		return transitions to surround the expected FSM.
		/// </summary>
		/// <param name="aCallingTransition">
		///		The first transition of the left side of the rule (it's only implicit) 
		///		that should be applied to the sourceMachine. The rule can be identified
		///		by its input symbol.
		/// </param>
		/// <returns>
		///		If the application of the rule finished successfully the resulting
		///		transition is returned, otherwise a ApplicationException is
		///		thrown.
		/// </returns>
		private ITransition Match(ITransition aCallingTransition, IFiniteStateMachine anExpectedFSM) {
			IState finalTargetInOriginal = originalFSM.ErrorState;
			IState stateInRule = anExpectedFSM.StartState;
			IState stateInOriginal = aCallingTransition.DestinationState;

			if(stateInRule.IsFinalState) {
				FindTargetInOriginal(stateInOriginal,ref finalTargetInOriginal);
			}

			DynamicStateIterator iterator = new DynamicStateIterator(new DualState(stateInRule,stateInOriginal));

			while(iterator.MoveNext()){
				stateInRule = ((DualState)iterator.Current).oneState;
				stateInOriginal = ((DualState)iterator.Current).twoState;

				IList transitionInRuleList = anExpectedFSM.GetOutgoingTransitions(stateInRule);
				IList transitionInOriginalList = originalFSM.GetOutgoingTransitions(stateInOriginal);

				if (transitionInRuleList.Count == transitionInOriginalList.Count) {
					foreach (ITransition transitionInRule in transitionInRuleList){
						IState targetInOriginal = originalFSM.ErrorState;
						ITransition transitionInOriginal = originalFSM.GetNextTransition(stateInOriginal,transitionInRule.InputSymbol);

						if(ruleTable.Contains(transitionInOriginal.InputSymbol)) {
							targetInOriginal = MatchAll(transitionInOriginal).DestinationState;
						} else {
							targetInOriginal = transitionInOriginal.DestinationState;
						}

						if (targetInOriginal.Equals(originalFSM.ErrorState)) {
							throw new ApplicationException("No match found!\nNo target for "+transitionInRule.InputSymbol+" in state "+((DualState)iterator.Current).twoState);
						} 
						if(transitionInRule.DestinationState.IsFinalState){
							FindTargetInOriginal(targetInOriginal,ref finalTargetInOriginal);
						}
					}
				} else {
					throw new ApplicationException("No match found:\tDifferent number of transitions for "+stateInRule+" and "+stateInOriginal);
				}
			}

			if (finalTargetInOriginal.Equals(originalFSM.ErrorState)) {
				throw new ApplicationException("No match found:\tNo return statement found!");
			}

			ITransition result = (ITransition)aCallingTransition.Clone();
			result.DestinationState = finalTargetInOriginal;
			return result;
		}


		/// <summary>
		///		Finds the destination state of all return transitions 
		///		belonging to the FSM associated to the applied rule in 
		///		the originalFSM.
		/// </summary>
		private void FindTargetInOriginal(IState aStateInOriginal, ref IState aTargetInOriginal) {
			IState tempState = originalFSM.GetNextState(aStateInOriginal,Input.RETURN);
			if( tempState != originalFSM.ErrorState){
				if( aTargetInOriginal.Equals(originalFSM.ErrorState )){
					aTargetInOriginal = tempState;
				} else {
					if (aTargetInOriginal != tempState) {
						throw new ApplicationException(" Multiple return targets found: "+aStateInOriginal+"\tand\t"+tempState);
					}
				}
			} else {
				throw new ApplicationException("No match found:\tNo return statement in state "+aStateInOriginal);
			}
		}


		/// <summary>
		///		Tries to apply one of the possible rules associated with the 
		///		input symbol of aStartTransition.
		///		
		///		If it fails an ApplicationException is thrown.
		/// </summary>
		/// <param name="aStartTransition">
		///		ITransition, where the application of the rules starts.
		/// </param>
		/// <returns>
		///		A transition leading from the source state of aStartTransiton to
		///		the destination of the return-transistions associtated with the
		///		fsm for the applied rule.
		/// </returns>
		private ITransition MatchAll(ITransition aStartTransition) {
			IList fsmList = (IList) ruleTable [ aStartTransition.InputSymbol ];
			string msg = "Following exceptions have been thrown:\n";
			foreach ( IFiniteStateMachine fsm in fsmList ) {
				try {
					return Match(aStartTransition,fsm);
				} catch ( ApplicationException e ) {
					msg += "\t"+e.Message+"\n";
				}
			}
			throw new ApplicationException(msg);
		}

		/// <summary>
		///		All rules given to the MachineReducer are applied as long as 
		///		possible. If a part of the sourceMachine cannot be reduced by 
		///		any rule it is deleted.
		/// </summary>
		/// <returns>
		///		A new, reduced machine.
		/// </returns>
		public IFiniteStateMachine GetReducedMachine(){
			IFiniteStateMachine resultMachine = new TabularFSM();
			DynamicTransitionIterator iterator = new DynamicTransitionIterator(originalFSM.StartState,originalFSM);
			while(iterator.MoveNext()){
				if (ruleTable.Contains(iterator.Current.InputSymbol)){
					try {
						ITransition result = MatchAll(iterator.Current);
						resultMachine.AddTransition(result);
						iterator.Append(result.DestinationState);
					} catch( ApplicationException ) {
						Console.WriteLine("ITransition "+iterator.Current+" could not be taken.");
						// The transition could not be taken, so there is nothing to do.
					}
				}
			}
			return resultMachine;
		}


		/// <summary>
		///		Generates a table associating an input symbol with a set of FSMs as
		///		it is required for a ruleTable.
		/// </summary>
		/// <param name="aServiceTable">
		///		Table of FSMs (value) associated with an input symbol (key).
		/// </param>
		/// <param name="aFSM">
		///		StackFiniteStateMachine used to identify the rules required
		///		for recursion handling.
		/// </param>
		/// <returns>
		///		A Hashtable as required for ruleTable.
		/// </returns>
		protected Hashtable CreateRuleTable (Hashtable aServiceTable, IFiniteStateMachine aFSM) {
			// Adding the default rules to the table.
			Hashtable result = new Hashtable();
			foreach ( DictionaryEntry entry in aServiceTable ) {
				IList fsmList = new Vector();
				fsmList.Add(entry.Value);
				result.Add(entry.Key,fsmList);
			}

			// Adding recursion Rules to the table
			foreach ( Input input in aFSM.InputAlphabet ) {
				if ( input is RecursionInput ) {
					RecursionInput recInput = (RecursionInput) input;
					
					IFiniteStateMachine recursiveFSM = new RecursiveServiceFSM ( recInput.RecursiveServiceName, aServiceTable );
					IList fsmList = new Vector();
					fsmList.Add ( recursiveFSM );
					MarkedInput markedInput = new MarkedInput ( recInput.RecursiveServiceName );
					result.Add ( markedInput, recursiveFSM );

					IFiniteStateMachine fsm = (IFiniteStateMachine) aServiceTable [ recInput.CallingServiceName ];
					IFiniteStateMachine callingFSM = new CallingServiceFSM ( fsm, recInput );
					fsmList = (IList) result [ recInput.CallingServiceName ];
					fsmList.Add ( callingFSM );
				}
			}

			return result;
		}


		/// <summary>
		///		Initialises the MachineReducer with a set of rules and a machine
		///		to which they will be applied.
		/// </summary>
		/// <param name="aRuleTable">
		///		Set of rules which should be applied to the machine.
		/// </param>
		/// <param name="anMachine">
		///		The machine affected by the rules.
		/// </param>
		public FSMReducer(Hashtable aServiceTable, IFiniteStateMachine aMachine){
			ruleTable = CreateRuleTable(aServiceTable,aMachine);
			originalFSM = aMachine;
		}
	}
}
