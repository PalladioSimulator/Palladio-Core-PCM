using System;
using System.Collections;
using Utils.Collections;

namespace FiniteStateMachines {
	/// <summary>
	/// Iterates of the States of a FSM
	/// </summary>
	public class StateIterator {
		protected Set visited; 
		protected Stack states;
		protected bool isInitialised;
		protected IFiniteStateMachine getters;
		protected AbstractState returnState;
		protected Transition currentTransition;
		protected Stack transitions;
		//stores the elements which has been already retruned
		protected Set alreadyReturned;
		protected bool debugOutput = !true;
		
		/// <summary>
		/// Initiates a FSM Iterator.
		/// </summary>
		/// <param name="d">The FSM which should be iterated</param>
		public StateIterator(IFiniteStateMachine d) {
			this.getters =  d; // RR: what is if d is NOT a FSM but another class implementing Getters?
			// please use only the getter interface! 

			this.isInitialised =false;
			this.states = new Stack();
			this.visited = new Set();
			this.alreadyReturned = new Set();
			this.transitions = new Stack();
		}
		/// <summary>
		/// Checks if there is another State to visit.
		/// </summary>
		/// <returns>True if there is another state, false if not</returns>
		public bool MoveNext() {
			if(!this.isInitialised) {
				try
				{
					///State placboState = (State) this.getters.StartState;
					//
					if(this.getters.StartState == null)
//					if (placboState == null)
						Console.WriteLine(" ");
					
				}
				catch(System.NullReferenceException)
				{
					//if you have no Startstate you can't iterate over a FSM
					return false;
				}

				this.states.Push(this.getters.StartState); 
				this.isInitialised = true;
				this.returnState = (AbstractState) this.states.Peek();
				
				//First Transition of a FSM 
				AbstractState none = new State("null",false,false);
				Input noInput = new Input("null"); 
				Transition g = new Transition(none,noInput,this.returnState);
				Transition emptyTransition = new Transition(none,new Input("null"),this.returnState);
				this.transitions.Push(emptyTransition);
				this.alreadyReturned.Add(this.returnState);
				this.currentTransition = (Transition) this.transitions.Peek();
				return true;
			}
			else {
				//top of Stack has allready been returning
				AbstractState currentState = (AbstractState) this.states.Peek();
				//check if cs has chilldren();
				IList nextStates = this.getters.GetOutgoingTransitions(currentState);
				while(nextStates == null) {
					if(this.debugOutput)
						Console.WriteLine("There are no Children from "+currentState.ToString());
					//now there are no children left and this this state is now complety explored,
					this.visited.Add(currentState);
					this.states.Pop();
					this.transitions.Pop();
					//next children 
					nextStates = this.getters.GetOutgoingTransitions((AbstractState) this.states.Peek());

				}		
				currentState = (AbstractState) this.states.Peek();
				
				nextStates = getters.GetOutgoingTransitions(currentState);
				//E a Hashatabele which contains the children of CS
				//write every child on the Stack
				Transition tempTransition = new Transition();
				//				AbstractState tempState = new State();
				IEnumerator iterateOverChildren = nextStates.GetEnumerator();
				while(iterateOverChildren.MoveNext()) {
					
					tempTransition = (Transition) iterateOverChildren.Current;
					this.states.Push(tempTransition.DestinationState);
					this.transitions.Push(tempTransition);
					if(this.debugOutput)
						Console.WriteLine(tempTransition.DestinationState.ToString()+" ís pushed on the stack");
				}
				//now all children of CS are no on the stack, and cs is completly explored 
				this.visited.Add(currentState);
				if(this.debugOutput)
					Console.WriteLine(currentState.ToString()+ " now has been completly doscovered");
				//search of the next State which will be returned
				while(this.alreadyReturned.Contains(this.states.Peek())) {
					if(this.debugOutput)
						Console.WriteLine("This State hs already been discovered "+this.states.Peek().ToString());
					this.states.Pop();
					this.transitions.Pop();
					if(this.states.Count==0)
						return false;
				}
				//Now a State is found, which jet has not been returning
				if(this.states.Peek().Equals(new State("ErrorState",false,false))) {
					states.Pop();
					this.MoveNext();
				}
				this.returnState = (AbstractState) this.states.Peek();
				this.currentTransition = (Transition) this.transitions.Peek();
				this.alreadyReturned.Add((AbstractState) this.states.Peek());
				return true;
			}
		}

		/// <summary>
		/// Returns the current object of the FSM.
		/// </summary>
		public object Current {
			get {
				return this.returnState;
			}
		}
		public object getCurrentTransition {
			get {
				return this.currentTransition;
			}
		}
	
	}
}
