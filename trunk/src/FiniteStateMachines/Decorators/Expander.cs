using System;
using FiniteStateMachines;
using Utils.Collections;
using System.Collections;

namespace FiniteStateMachines.Decorators {

	/// <summary>
	///
	/// </summary>
	public class Expander {
		
		private IFiniteStateMachine completeMachine;

		private IFiniteStateMachine reducedMachine;
		
		private Set epsilonAlphabet;
		
		private IFiniteStateMachine expanded;

		public Expander(IFiniteStateMachine aCompleteMachine, IFiniteStateMachine aReducedMachine, Set anEpsilonAlphabet) {
			completeMachine = aCompleteMachine;
			reducedMachine = aReducedMachine;
			epsilonAlphabet = anEpsilonAlphabet;
			expanded = Expand();
		}

		public IFiniteStateMachine GetExpandedMachine(){
			return expanded;
		}



		/// <summary>
		/// <param name="aState"></param>
		/// <param name="resultSet"></param>
		/// <returns></returns>
		private void GetEpsilonTransitionsRecursive(AbstractState aState, ref IList resultTransitionList, ref IList visitedStatesList){
            if (!visitedStatesList.Contains(aState)) {
                foreach (Input input in epsilonAlphabet) {
                    Transition outgoingTranstion = completeMachine.GetNextTransition(aState,input);
                    if(outgoingTranstion.DestinationState != completeMachine.ErrorState){
                        resultTransitionList.Add(outgoingTranstion);
                        GetEpsilonTransitionsRecursive(outgoingTranstion.DestinationState,ref resultTransitionList,ref visitedStatesList);
                    }
                }
            }
		}

			
		
		private IFiniteStateMachine Expand(){
			IList visitedStatesList = new ArrayList();
            IList transitionList = new ArrayList();
			ExpandRecursive(completeMachine.StartState,reducedMachine.StartState,ref transitionList, ref visitedStatesList);
            FiniteTabularMachine resultMachine = new FiniteTabularMachine(transitionList);
			return resultMachine;
		}
		
		
        private void ExpandRecursive(AbstractState completeState, AbstractState reducedState, ref IList transitionList, ref IList visitedStatesList){
            if (!visitedStatesList.Contains(reducedState)){
                visitedStatesList.Add(reducedState);
                IList possibleStatesList = new ArrayList(); 
                IList epsilonTransitionList = new ArrayList(); 

                // Determine all states reachable by an epsilon input
                // and store the corresponding transitions
                GetEpsilonTransitionsRecursive(completeState,ref epsilonTransitionList,ref possibleStatesList);
                foreach (Transition trans in epsilonTransitionList) {
                    transitionList.Add(GetNewTransition(trans,reducedState));
                }

                // For each transition in the reduced fsm look for possible
                // transitions in the complete fsm
                IList outgoingTransitions = reducedMachine.GetOutgoingTransitions(reducedState);
                foreach (Transition trans in  outgoingTransitions) {
                    if (trans.DestinationState != reducedMachine.ErrorState) {
                        foreach (AbstractState state in possibleStatesList) {
                            AbstractState nextState = completeMachine.GetNextState(state,trans.InputSymbol);
                            if (nextState != completeMachine.ErrorState) {
                                transitionList.Add(GetNewTransition(trans,reducedState));
                                ExpandRecursive(nextState,trans.DestinationState,ref transitionList,ref visitedStatesList);
                            }
                        }
                    }
                }
                
            }
        }

        private Transition GetNewTransition(Transition aTransition, AbstractState reducedState) {
            DualState source = new DualState(aTransition.SourceState,reducedState);
            DualState destination = new DualState(aTransition.DestinationState,reducedState);
            Transition newTransition = (Transition)aTransition.Clone();
            newTransition.SetValues(source,aTransition.InputSymbol,destination);
            return newTransition;
        }

	}
}
