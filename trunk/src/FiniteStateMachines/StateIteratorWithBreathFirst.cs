using System;
using System.Collections;
using Utils.Collections;

namespace FiniteStateMachines {
	/// <summary>
	/// Helps to iterate over the States of a FSM by brearh-first-search. 
	/// When this class has been initiated, all states of this fsm are stored
	/// in a array-List.
	/// Its only usefull for small FSMs.
	/// </summary>
	public class StateIteratorWithBreathFirst {
		protected ArrayList visitedStates;
		protected int howMany;
		protected State currentState;
		protected int currentIndex;
		protected Set fsmInput;
		protected FSM fsm;
		protected bool debugOutput = !true;
		protected int outGoingIndex;
		
		/// <summary>
		/// initiates a StateIteratorWithBreath-FrstWithBreath-firstWithBreath-first
		/// </summary>
		/// <param name="f"></param>
		public StateIteratorWithBreathFirst(IFiniteStateMachine f) {
			this.fsm = (FSM)f;
			this.currentState = this.fsm.StartState;
			this.visitedStates = new ArrayList();
			this.visitedStates.Add(this.currentState);
			this.howMany = 0;
			this.currentIndex = 0;
			traverse();
			this.outGoingIndex = -1;
		}
		protected void traverse() {
			while(true) {
				try {
					Hashtable tmp = this.fsm.GetOutgoingTransitions(this.currentState);
					IDictionaryEnumerator iterator = tmp.GetEnumerator();
					while(iterator.MoveNext()) {
						Transition  t = (Transition)iterator.Value;
						State visiting = t.toState;
						if(!this.visitedStates.Contains(visiting)) {
							this.visitedStates.Add(visiting);
							this.howMany++;
						}
					}
				}
				catch(InvalidInputException) {
				}
				
				catch(InvalidStateException) {
				}
				this.currentIndex++;
				if(this.howMany < this.currentIndex)
					break;
				this.currentState = (State) this.visitedStates[this.currentIndex];

			}
			if(this.debugOutput) {
				Console.WriteLine("vor Arrayauagabe");
				foreach(State t in this.visitedStates)
					Console.WriteLine("After traverse in Array: "+t.ToString());
			}

					
		
		}
		/// <summary>
		/// checks if there is another State to iterate over.
		/// </summary>
		/// <returns></returns>
		public bool MoveNext() {
			this.outGoingIndex++;
			if(this.outGoingIndex>this.howMany)
				return false;
			return true;
		}

		/// <summary>
		/// Returns the Current object of the iteration
		/// </summary>
		public object Current {
			get {
				return this.visitedStates[this.outGoingIndex];
			}
		}

	}
}
		