using System;
using System.Collections;
using FiniteStateMachines;

namespace FiniteStateMachines.Decorators
{
	/// <summary>
	///		The MachineReducer reduces an automaton using a set of rules (for
	///		more information see graph-grammars). These rules are applied sequentially
	///		to the automaton beginning at its startnode.
	/// </summary>
	public class MachineReducer
	{
		
		/// <summary>
		///		The ruleTable contains all rules which should be applied to the 
		///		automaton. They are indexed by its names.
		///		Key: Input 
		///		Value: RulePair 
		/// </summary>
		private Hashtable ruleTable;
		

		/// <summary>
		///		The source automaton, which should be reduced.
		/// </summary>
		private IFiniteStateMachine sourceMachine;


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
			Rule rule = (Rule)ruleTable[aStartTransition.InputSymbol];
			AbstractState matchDestination = sourceMachine.ErrorState;
			Stack statesVisited = new Stack();
			Stack statesToVisit = new Stack();
			statesToVisit.Push(new DualState(rule.Left.StartState,aStartTransition.DestinationState));
			while(statesToVisit.Count != 0){
				DualState currentState = (DualState)statesToVisit.Pop();
				IList transitionList = rule.Left.GetOutgoingTransitions(currentState.oneState);
				foreach (Transition t in transitionList){
					AbstractState destination = sourceMachine.GetNextState(currentState.twoState,t.InputSymbol);
					if (destination == sourceMachine.ErrorState) {
						throw new ApplicationException("No match found!\nNo target for "+t.InputSymbol+" in state "+currentState.twoState);
					} 
					if(rule.Left.FinalStates.Contains(t.DestinationState)){
						matchDestination = sourceMachine.GetNextState(destination,Input.RETURN);
						if( matchDestination == sourceMachine.ErrorState){
							throw new ApplicationException("No match found!\nNo return statement in state "+destination);
						}
					}
					DualState nextState = new DualState(t.DestinationState,destination);
					if( !statesToVisit.Contains(nextState) &&
						!statesVisited.Contains(nextState)) {
						statesToVisit.Push(nextState);
					}
				}
				statesVisited.Push(currentState);
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
			Stack statesToVisit = new Stack();
			Stack statesVisited = new Stack();
			statesToVisit.Push(sourceMachine.StartState);
			while(statesToVisit.Count != 0){
				AbstractState currentState = (AbstractState)statesToVisit.Pop();
				IList transitionList = sourceMachine.GetOutgoingTransitions(currentState);
				foreach(Transition t in transitionList){
					if (ruleTable.Contains(t.InputSymbol)){
						Transition result = Match(t);
						resultMachine.AddTransition(result);
						if (!statesVisited.Contains(result.DestinationState) &&
							!statesToVisit.Contains(result.DestinationState)){
							statesToVisit.Push(result.DestinationState);
						}
					}
				}
				statesVisited.Push(currentState);
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
		public MachineReducer(Hashtable aRuleTable, IFiniteStateMachine aMachine){
			ruleTable = aRuleTable;
			sourceMachine = aMachine;
		}
	}
}
