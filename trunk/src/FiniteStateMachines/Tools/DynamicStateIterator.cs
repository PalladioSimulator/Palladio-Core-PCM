using System;
using System.Collections;
using FiniteStateMachines;

namespace FiniteStateMachines.Tools {
	/// <summary>
	/// Zusammenfassung für StateVisitor.
	/// </summary>
	public class DynamicStateIterator {
		private Stack visitedStates, statesToVisit;

		private AbstractState currentState;

		public AbstractState Current {
			get {
				return currentState;
			}
		}

		public bool MoveNext(){
			if (currentState != null) {
				visitedStates.Push(currentState);
			}

			if (statesToVisit.Count > 0) {
				currentState = (AbstractState)statesToVisit.Pop();
				return true;
			} 
			return false;
		}

		public void Append(AbstractState aState){
			if (!visitedStates.Contains(aState) &&
				!statesToVisit.Contains(aState) &&
				(currentState != aState)){
				statesToVisit.Push(aState);
			}
		}

		public DynamicStateIterator(AbstractState aState) {
			visitedStates = new Stack();
			statesToVisit = new Stack();
			statesToVisit.Push(aState);
			currentState = null;
		}
	}
}
