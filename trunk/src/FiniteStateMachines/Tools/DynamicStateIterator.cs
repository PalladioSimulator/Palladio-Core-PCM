using System;
using System.Collections;
using Palladio.FiniteStateMachines;

namespace Palladio.FiniteStateMachines {

	/// <summary>
	///		Dynamically iterates over a set of states constructed during
	///		the iteration by appending new states to the enumerator.
	///		
	///		author: JH
	/// </summary>
	public class DynamicStateIterator : IEnumerator {

		/// <summary>
		///		States which have been already visited during 
		///		the iteration.
		/// </summary>
		private Stack visitedStates;

		/// <summary>
		///		States which are left for iteration.
		/// </summary>
		private Stack statesToVisit;

		/// <summary>
		///		State currently processed.
		/// </summary>
		private IState currentState;

		/// <summary>
		///		First state of the iteration.
		/// </summary>
		private IState startState;

		/// <summary>
		///		Creates a new enumerator starting at aState.
		/// </summary>
		/// <param name="aState">
		///		The starting point of the iteration.
		/// </param>
		public DynamicStateIterator(IState aState) {
			visitedStates = new Stack();
			statesToVisit = new Stack();
			statesToVisit.Push(aState);
			currentState = null;
			startState = aState;
		}

		/// <summary>
		///		Get the currently processed state.
		/// </summary>
		public IState Current {
			get { return currentState; }
		}

		/// <summary>
		///		Appends a new state to the iteration list, but
		///		only if it not has been already processed and it 
		///		is not in the processing list.
		/// </summary>
		/// <param name="aState">
		///		A state wich should be enumerated.
		/// </param>
		public void Append(IState aState){
			if (!visitedStates.Contains(aState) &&
				!statesToVisit.Contains(aState) &&
				(currentState != aState)){
				statesToVisit.Push(aState);
			}
		}

		/// <summary>
		///		Implementation of the IEnumerator Interface.
		/// </summary>
		#region IEnumerator Member

		/// <summary>
		///		Moves the iterator to the next state.
		/// </summary>
		/// <returns> 
		///		True if a next state exists, false oterwise.
		///	</returns>
		public bool MoveNext(){
			if (currentState != null) {
				visitedStates.Push(currentState);
			}

			if (statesToVisit.Count > 0) {
				currentState = (IState)statesToVisit.Pop();
				return true;
			} 
			return false;
		}

		/// <summary>
		///		Resets the enumerator back to its start state.
		///		All appended states are lost.
		/// </summary>
		public void Reset() {
			visitedStates.Clear();
			statesToVisit.Clear();
			currentState = null;
			statesToVisit.Push(startState);
		}

		/// <summary>
		///		Gives access to the current state.
		/// </summary>
		object System.Collections.IEnumerator.Current {
			get { return currentState; }
		}

		#endregion
	}
}
