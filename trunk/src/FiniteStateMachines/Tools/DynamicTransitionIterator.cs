using System;
using System.Collections;

namespace FiniteStateMachines {

	/// <summary>
	///		Dynamically iterates over a set of transitions. 
	///		During the iteration process new states can be 
	///		added to the enumerator. The outgoing
	///		transitions of these states are enumerated.
	///		
	///		author: JH
	/// </summary>
	public class DynamicTransitionIterator : IEnumerator {

		/// <summary>
		///		Enumerator holding the states whose transitions
		///		are enumarated by the DynamicTransitionEnumerator.
		/// </summary>
		private DynamicStateIterator stateEnumerator;

		/// <summary>
		///		List of transitions belonging to the current state of
		///		the state enumerator.
		/// </summary>
		private IList transitionList;

		/// <summary>
		///		The currently active transition.
		/// </summary>
		private Transition currentTransition;

		/// <summary>
		///		FSM to which all transitions enumerated here belong.
		/// </summary>
		private IFiniteStateMachine fsm;

		/// <summary>
		///		Index of the currently active transition in
		///		transitionList.
		/// </summary>
		private int transitionIndex;


		/// <summary>
		///		Creates a new Enumerator. The Enumeration begins with the
		///		transitions of aStartState.
		/// </summary>
		/// <param name="aStartState">
		///		Entry point of the Enumeration. It must be a valid state of
		///		aFSM.
		/// </param>
		/// <param name="aFSM">
		///		FSM whose transitions are (partially) enumerated.
		/// </param>
		public DynamicTransitionIterator(IState aStartState, IFiniteStateMachine aFSM){
			stateEnumerator = new DynamicStateIterator(aStartState);
			transitionList = null;
			fsm = aFSM;
			transitionIndex = 0;
		}


		/// <summary>
		///		Creates a new Enumerator. The Enumeration begins with the
		///		transitions of the startstate of aFSM.
		/// </summary>
		/// <param name="aFSM">
		///		FSM whose transitions are (partially) enumerated.
		/// </param>
		public DynamicTransitionIterator(IFiniteStateMachine aFSM): this(aFSM.StartState,aFSM) {}

		
		/// <summary>
		///		Appends a new state to the iteration list, but
		///		only if it not has been already processed and it 
		///		is not in the processing list.
		///		
		///		The outgoing transitions of this state are enumerated.
		/// </summary>
		/// <param name="aState">
		///		A state whose transitions should be enumerated.
		/// </param>
		public void Append(IState aState){
			stateEnumerator.Append(aState);
		}


		/// <summary>
		///		Get the currently active transitions.
		/// </summary>
		public Transition Current {
			get { return currentTransition; }
		}


		/// <summary>
		/// Implementation of the IEnumerator interface.
		/// </summary>
		#region IEnumerator Member
		
		/// <summary>
		///		Moves the iterator to the next transition.
		/// </summary>
		/// <returns> 
		///		True if a next transition exists, false oterwise.
		///	</returns>
		public bool MoveNext(){
			if((transitionList == null) || (transitionIndex <= 0)){
				if (stateEnumerator.MoveNext()){
					transitionList = fsm.GetOutgoingTransitions(stateEnumerator.Current);
					transitionIndex = transitionList.Count;
				} else {
					return false;
				}
			}
			if(transitionList.Count > 0){
				currentTransition = (Transition)transitionList[--transitionIndex];
				return true;
			} else {
				return false;
			}
		}

		/// <summary>
		///		Resets the enumerator back to its start.
		///		All appended states are lost.
		/// </summary>
		public void Reset() {
			stateEnumerator.Reset();
			transitionList = null;
			currentTransition = null;
		}

		/// <summary>
		///		Get the currently active transitions.
		/// </summary>
		object System.Collections.IEnumerator.Current {
			get { return currentTransition; }
		}

		#endregion
	}
}
