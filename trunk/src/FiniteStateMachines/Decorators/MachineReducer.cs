using System;
using System.Collections;
using FiniteStateMachines;
using FiniteStateMachines.Tools;
using FiniteStateMachines.Decorators;
using Utils.Collections;

namespace ParameterisedContracts {
	/// <summary>
	///		The MachineReducer reduces an automaton using a set of rules (for
	///		more information see graph-grammars). These rules are applied sequentially
	///		to the automaton beginning at its startnode.
	///		
	///		- rules only implicit
	///			- one transition right side
	///			- fsm left side
	///			- using hashtable key: input, value set of fsms
	///			-> all these fsm mapped on a transition with the same input symbol
	///			- calling and return transition not explicitly given in rule, but expected
	///			  by the algorithm.
	///			- application of rules in a predefined order, beginning at the startstate
	///			- recursive match calls (apply all required rules during the application of
	///			  the outer rule)
	///			- the original machine is not reduced, but a new reduced version of the automaton
	///			  is constructed in parallel
	/// </summary>
	public class FiniteStateMachineReducer {
		
		/// <summary>
		///		The ruleTable impicitly contains all rules which should be applied to the 
		///		automaton. It is organized as follwed:
		///		Key: Input 
		///		Value: IList of IFiniteStateMachines 
		/// </summary>
		private Hashtable ruleTable;

		
		/// <summary>
		///		The source automaton, which should be reduced.
		/// </summary>
		private AbstractFiniteStateMachine originalFSM;


		/// <summary>
		///		Applies the rule associated with the Input of aStartTransition to
		///		the originalMachine. Recursively all other rules needed to perform this
		///		reduction are executed.
		/// </summary>
		/// <param name="aStartTransition">
		///		The first transition of the left side of the rule that 
		///		should be applied to the sourceMachine. The rule can be identified
		///		by its input symbol.
		/// </param>
		/// <returns>
		///		If the application of the rule finished successfully the resulting
		///		transition is returned, otherwise a RuleNotApplicableException is
		///		thrown.
		/// </returns>
		private Transition Match(Transition aStartTransition, IFiniteStateMachine anExpectedFSM) {
			AbstractState finalTargetInOriginal = originalFSM.ErrorState;
			AbstractState stateInRule = anExpectedFSM.StartState;
			AbstractState stateInOriginal = aStartTransition.DestinationState;

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
					foreach (Transition transitionInRule in transitionInRuleList){
						AbstractState targetInOriginal = originalFSM.ErrorState;
						Transition transitionInOriginal = originalFSM.GetNextTransition(stateInOriginal,transitionInRule.InputSymbol);

						if(ruleTable.Contains(transitionInOriginal.InputSymbol)) {
							targetInOriginal = MatchAll(transitionInOriginal).DestinationState;
						} else {
							targetInOriginal = transitionInOriginal.DestinationState;
						}

						if (targetInOriginal == originalFSM.ErrorState) {
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

			if (finalTargetInOriginal == originalFSM.ErrorState) {
				throw new ApplicationException("No match found:\tNo return statement found!");
			}

			Transition result = (Transition)aStartTransition.Clone();
			result.DestinationState = finalTargetInOriginal;
			return result;
		}


		/// <summary>
		///		Finds the destination state of all return transitions 
		///		belonging to the FSM associated to the applied rule in 
		///		the originalFSM.
		/// </summary>
		/// <param name="aStateInSource"></param>
		/// <param name="aDestination"></param>
		private void FindTargetInOriginal(AbstractState aStateInOriginal, ref AbstractState aTargetInOriginal) {
			AbstractState tempState = originalFSM.GetNextState(aStateInOriginal,Input.RETURN);
			if( tempState != originalFSM.ErrorState){
				if( aTargetInOriginal == originalFSM.ErrorState ){
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
		///		Transition, where the application of the rules starts.
		/// </param>
		/// <returns>
		///		A transition leading from the source state of aStartTransiton to
		///		the destination of the return-transistions associtated with the
		///		fsm for the applied rule.
		/// </returns>
		private Transition MatchAll(Transition aStartTransition) {
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
			IFiniteStateMachine resultMachine = new FiniteTabularMachine();
			DynamicTransitionIterator iterator = new DynamicTransitionIterator(originalFSM.StartState,originalFSM);
			while(iterator.MoveNext()){
				if (ruleTable.Contains(iterator.Current.InputSymbol)){
					try {
						Transition result = MatchAll(iterator.Current);
						resultMachine.AddTransition(result);
						iterator.Append(result.DestinationState);
					} catch( ApplicationException ) {
						Console.WriteLine("Transition "+iterator.Current+" could not be taken.");
						// The transition could not be taken, so there is nothing to do.
					}
				}
			}
			return resultMachine;
		}


		/// <summary>
		/// </summary>
		/// <param name="aServiceTable"></param>
		/// <param name="aFSM"></param>
		/// <returns></returns>
		protected Hashtable CreateRuleTable(Hashtable aServiceTable, AbstractFiniteStateMachine aFSM) {
			// Adding the default rules to the table.
			Hashtable result = new Hashtable();
			foreach ( DictionaryEntry entry in aServiceTable ) {
				IList fsmList = new ArrayList();
				fsmList.Add(entry.Value);
				result.Add(entry.Key,fsmList);
			}

			// Adding recursion Rules to the table
			foreach ( Input input in aFSM.InputAlphabet ) {
				if ( input is RecursionInput ) {
					RecursionInput recInput = (RecursionInput) input;
					
					IFiniteStateMachine recursiveFSM = new RecursiveFiniteStateMachine ( recInput.RecursiveServiceName, aServiceTable );
					IList fsmList = new ArrayList();
					fsmList.Add ( recursiveFSM );
					MarkedInput markedInput = new MarkedInput ( recInput.RecursiveServiceName );
					result.Add ( markedInput, recursiveFSM );

					IFiniteStateMachine fsm = (IFiniteStateMachine) aServiceTable [ recInput.CallingServiceName ];
					IFiniteStateMachine callingFSM = new CallingFiniteStateMachine ( fsm, recInput );
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
		public FiniteStateMachineReducer(Hashtable aServiceTable, AbstractFiniteStateMachine aMachine){
			ruleTable = CreateRuleTable(aServiceTable,aMachine);
			originalFSM = aMachine;
		}
	}
}
