using System;
using System.Collections;
using FiniteStateMachines;
using FiniteStateMachines.Tools;

namespace FiniteStateMachines.Decorators {
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
		private Transition Match(Transition aStartTransition){
			AbstractFiniteStateMachine leftSide = (AbstractFiniteStateMachine)ruleTable[aStartTransition.InputSymbol];
			AbstractState matchDestination = sourceMachine.ErrorState;
			DynamicStateIterator iterator = new DynamicStateIterator(new DualState(leftSide.StartState,aStartTransition.DestinationState));

			while(iterator.MoveNext()){
				AbstractState leftState = ((DualState)iterator.Current).oneState;
				AbstractState rightState = ((DualState)iterator.Current).twoState;
				IList transitionList = leftSide.GetOutgoingTransitions(leftState);
				foreach (Transition trans in transitionList){
					AbstractState destState = sourceMachine.GetNextState(rightState,trans.InputSymbol);
					if (destState == sourceMachine.ErrorState) {
						throw new ApplicationException("No match found!\nNo target for "+trans.InputSymbol+" in state "+((DualState)iterator.Current).twoState);
					} 
					if(leftSide.FinalStates.Contains(trans.DestinationState)){
						matchDestination = sourceMachine.GetNextState(destState,Input.RETURN);
						if( matchDestination == sourceMachine.ErrorState){
							throw new ApplicationException("No match found!\nNo return statement in state "+destState);
						}
					}
					iterator.Append(new DualState(trans.DestinationState,destState));
				}
			}
			if (matchDestination == sourceMachine.ErrorState) {
				throw new ApplicationException("No match found\nNo return statement found!");
			}
			Transition result = (Transition)aStartTransition.Clone();
			result.DestinationState = matchDestination;
			return result;
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
					Transition result = Match(iterator.Current);
					resultMachine.AddTransition(result);
					iterator.Append(result.DestinationState);
				}
			}
			return resultMachine;
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
		public MachineReducer(Hashtable aRuleTable, AbstractFiniteStateMachine aMachine){
			ruleTable = aRuleTable;
			sourceMachine = aMachine;
		}
	}
}
