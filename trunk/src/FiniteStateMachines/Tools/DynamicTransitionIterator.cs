using System;
using System.Collections;

namespace FiniteStateMachines.Tools
{
	/// <summary>
	/// Zusammenfassung für DynamicTransitionIterator.
	/// </summary>
	public class DynamicTransitionIterator
	{
		private DynamicStateIterator stateIterator;
		private IList transitionList;
		private Transition currentTransition;
		private IFiniteStateMachine fsm;
		private int index;

		public DynamicTransitionIterator(AbstractState aStartState, IFiniteStateMachine aFSM){
			stateIterator = new DynamicStateIterator(aStartState);
			transitionList = null;
			fsm = aFSM;
			index = 0;
		}

		public DynamicTransitionIterator(IFiniteStateMachine aFSM): this(aFSM.StartState,aFSM) {}

		public bool MoveNext(){
			if((transitionList == null) || (index <= 0)){
				if (stateIterator.MoveNext()){
					transitionList = fsm.GetOutgoingTransitions(stateIterator.Current);
					index = transitionList.Count;
				} else {
					return false;
				}
			}
			if(transitionList.Count > 0){
				currentTransition = (Transition)transitionList[--index];
				return true;
			} else {
				return false;
			}
		}

		public void Append(AbstractState aState){
			stateIterator.Append(aState);
		}

		public Transition Current {
			get {
				return currentTransition;
			}
		}
	}
}
