using System;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Decorators;
using Utils.Collections;
using System.Collections;

namespace Palladio.ParameterisedContracts {

	/// <summary>
	///     The FiniteStateMachineExpander reconstructs all epsilon
	///     transitions of the reduced automaton by means of
	///     the transitions in the original automaton.
	/// 
	///     The reduced automaton has to accomplish
	///     several constraints:
	///     - it must _NOT_ contain epsilon transitions
	///     - it must accept a language which is a subset
	///       of the language accepted by the original automaton.
	/// 
	///     An epsilon transition is a transition with an
	///     input symbol contained by the epsilon alphabet.
	///     The epsilon alphabet is a subset of the input
	///     alphabet of the original automaton.
	///     
	///     author: JH
	/// </summary>
	public class FSMExpander {
		
		/// <summary>
		///     Automaton used for reconstructing the
		///     epsilon transition in the reduced 
		///     automaton.
		/// </summary>
		private IFiniteStateMachine originalMachine;

		/// <summary>
		///     A reduced version of the original automaton.
		///     It does not contain any epsilon transition and
		///     the accepted language is a subset of the language
		///     accepted by the original automaton.
		/// </summary>
		private IFiniteStateMachine reducedMachine;
		
		/// <summary>
		///     Set of symbols interpreted as epsilon input.
		///     It has to be a subset of the input alphabet of
		///     the original automaton.
		/// </summary>
		private Set epsilonAlphabet;
		
		/// <summary>
		///     Initializes a new MachineExpander. This
		///     Constructor does not calculate anything.
		/// </summary>
		/// 
		/// <param name="aOriginalMachine">
		///     Automaton used for reconstructing the
		///     epsilon transition in the reduced
		///     automaton.
		/// </param>
		/// <param name="aReducedMachine">
		///     A reduced version of the original automaton.
		///     It does not contain any epsilon transition and
		///     the accepted language is a subset of the language
		///     accepted by the original automaton.
		/// </param>
		/// <param name="anEpsilonAlphabet">
		///     Set of symbols interpreted as epsilon input.
		///     It has to be a subset of the input alphabet of
		///     the original automaton.
		/// </param>
		public FSMExpander(IFiniteStateMachine aOriginalMachine, IFiniteStateMachine aReducedMachine, Set anEpsilonAlphabet) {
			originalMachine = aOriginalMachine;
			reducedMachine = aReducedMachine;
			epsilonAlphabet = anEpsilonAlphabet;
		}


		/// <summary>
		///     Expands the reduced automaton using the 
		///     original one as pattern, so that all missing
		///     epsilon transitions can be added.
		/// </summary>
		/// 
		/// <returns>
		///		A new IFiniteStateMachine representing the
		///     expanded version of the reduced automaton.
		///     "Expanded" means that it contains all possible
		///     epsilon transitions regarding to the original
		///     automaton.
		/// </returns>
		public IFiniteStateMachine GetExpandedMachine() {
			IList transitionList = new ArrayList();
			IList statesList = new ArrayList();
			DualState startState = new DualState(reducedMachine.StartState,originalMachine.StartState);
			ExpandRecursive(startState,ref transitionList, ref statesList);
			return new TabularFSM(transitionList);
		}


		/// <summary>
		///     Recursively steps through the virtual new
		///     automaton and reconstructs all transitions
		///     of the reduced automaton using the original
		///     automaton as pattern.
		/// </summary>
		/// 
		/// <param name="currentState">currently visited state</param>
		/// <param name="transitionList">List of collected transitions of the 
		///     expanded automaton.</param>
		/// <param name="visitedStatesList">List of already visited states.</param>
		private void ExpandRecursive(DualState currentState, ref IList transitionList, ref IList visitedStatesList){
			if(!visitedStatesList.Contains(currentState)){
				visitedStatesList.Add(currentState);
				IList outgoingTransitionList = originalMachine.GetOutgoingTransitions(currentState.twoState);
				foreach (Transition trans in outgoingTransitionList) {
					DualState nextState = null;
					bool nextStateFound = false;

					if (epsilonAlphabet.Contains(trans.InputSymbol)) {
						nextState = new DualState(currentState.oneState, trans.DestinationState);
						nextStateFound = true;
					} else {
						try {
							IState nextReducedState = reducedMachine.GetNextState(currentState.oneState,trans.InputSymbol);
							if (nextReducedState != reducedMachine.ErrorState) {
								nextState = new DualState(nextReducedState,trans.DestinationState);
								nextStateFound = true;
							} 
						} catch (InvalidInputException) {
							// This exception is thrown, if the reduced automaton does not
							// contain the current input symbol, so this transition can not 
							// be taken and the process can be continued.
							// There is nothing to do...
						}
					}
					if(nextStateFound){
						Transition newTransition = (Transition)trans.Clone();
						newTransition.SetValues(currentState,trans.InputSymbol,nextState);
						transitionList.Add(newTransition);
						ExpandRecursive(nextState,ref transitionList, ref visitedStatesList);
					}
				}
			}
		}
	}
}
