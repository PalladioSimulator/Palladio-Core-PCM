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
	/// </summary>
	public class MachineReducer {
		
		/// <summary>
		///		The ruleTable impicitly contains all rules which should be applied to the 
		///		automaton. It is organized as follwed:
		///		Key: Input 
		///		Value: AbstractFiniteStateMachine 
		/// </summary>
		private Hashtable ruleTable;

		
		/// <summary>
		///		The source automaton, which should be reduced.
		/// </summary>
		private AbstractFiniteStateMachine sourceMachine;


		/// <summary>
		///		Applies the rule associated with the Input of aStartTransition to
		///		the sourceMachine. Recursively all other rules needed to perform this
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
			AbstractState finalDestination = sourceMachine.ErrorState;
			AbstractState stateInRule = anExpectedFSM.StartState;
			AbstractState stateInSource = aStartTransition.DestinationState;

			if(stateInRule.IsFinalState) {
				FindDestination(stateInSource,ref finalDestination);
			}

			DynamicStateIterator iterator = new DynamicStateIterator(new DualState(stateInRule,stateInSource));

			while(iterator.MoveNext()){
				stateInRule = ((DualState)iterator.Current).oneState;
				stateInSource = ((DualState)iterator.Current).twoState;

				IList transitionInRuleList = anExpectedFSM.GetOutgoingTransitions(stateInRule);
				IList transitionInSourceList = sourceMachine.GetOutgoingTransitions(stateInSource);

				if (transitionInRuleList.Count == transitionInSourceList.Count) {
					foreach (Transition transitionInRule in transitionInRuleList){
						AbstractState destinationInSource = sourceMachine.ErrorState;
						Transition transitionInSource = sourceMachine.GetNextTransition(stateInSource,transitionInRule.InputSymbol);

						if(ruleTable.Contains(transitionInSource.InputSymbol)) {
							destinationInSource = MatchAll(transitionInSource).DestinationState;
						} else {
							destinationInSource = transitionInSource.DestinationState;
						}

						if (destinationInSource == sourceMachine.ErrorState) {
							throw new ApplicationException("No match found!\nNo target for "+transitionInRule.InputSymbol+" in state "+((DualState)iterator.Current).twoState);
						} 
						if(transitionInRule.DestinationState.IsFinalState){
							FindDestination(destinationInSource,ref finalDestination);
						}
					}
				} else {
					throw new ApplicationException("No match found:\tDifferent number of transitions for "+stateInRule+" and "+stateInSource);
				}
			}

			if (finalDestination == sourceMachine.ErrorState) {
				throw new ApplicationException("No match found:\tNo return statement found!");
			}

			Transition result = (Transition)aStartTransition.Clone();
			result.DestinationState = finalDestination;
			return result;
		}

		
		private void FindDestination(AbstractState aStateInSource, ref AbstractState aDestination) {
			AbstractState tempState = sourceMachine.GetNextState(aStateInSource,Input.RETURN);
			if( tempState != sourceMachine.ErrorState){
				if( aDestination == sourceMachine.ErrorState ){
					aDestination = tempState;
				} else {
					if (aDestination != tempState) {
						throw new ApplicationException(" Multiple return targets found: "+aStateInSource+"\tand\t"+tempState);
					}
				}
			} else {
				throw new ApplicationException("No match found:\tNo return statement in state "+aStateInSource);
			}
		}

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
			DynamicTransitionIterator iterator = new DynamicTransitionIterator(sourceMachine.StartState,sourceMachine);
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

		protected Hashtable CreateRuleTable(Hashtable aServiceTable, AbstractFiniteStateMachine aMachine) {
			
			// Adding the default rules to the table.
			Hashtable result = new Hashtable();
			foreach ( DictionaryEntry entry in aServiceTable ) {
				IList fsmList = new ArrayList();
				fsmList.Add(entry.Value);
				result.Add(entry.Key,fsmList);
			}

			// Adding recursion Rules to the table
			foreach ( Input input in aMachine.InputAlphabet ) {
				if ( input is RecursionInput ) {
					RecursionInput recInput = (RecursionInput) input;
					
					IFiniteStateMachine recursiveFSM = new RecursiveFSM ( recInput.RecursiveServiceName, aServiceTable );
					IList fsmList = new ArrayList();
					fsmList.Add ( recursiveFSM );
					MarkedInput markedInput = new MarkedInput ( recInput.RecursiveServiceName );
					result.Add ( markedInput, recursiveFSM );

					IFiniteStateMachine fsm = (IFiniteStateMachine) aServiceTable [ recInput.CallingServiceName ];
					IFiniteStateMachine callingFSM = new CallingFSM ( fsm, recInput );
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
		public MachineReducer(Hashtable aServiceTable, AbstractFiniteStateMachine aMachine){
			ruleTable = CreateRuleTable(aServiceTable,aMachine);
			sourceMachine = aMachine;
		}
	}
}
