using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.FiniteStateMachines {
	/// <summary>
	/// Iterates over the States of a IFiniteStateMachine with depth-first-search
	/// </summary>
	public class StateIterator {

		/// <summary>
		/// Stores all states that has been alrady returned in a <code>Set</code>
		/// </summary>
		private Set visited; 

		/// <summary>
		/// Temporary (during iteration) the states are stored here.
		/// </summary>
		private Stack states;

		/// <summary>
		/// An indicator that checks if the stateiterator has already been init.
		/// </summary>
		private bool isInitialised;

		/// <summary>
		/// The thing we want to iterate over.
		/// </summary>
		private IFiniteStateMachine getters;

		/// <summary>
		/// The current state of the iteration, this will be returned
		/// </summary>
		private IState returnState;

		/// <summary>
		/// The currant ITransition that will be returned
		/// </summary>
		private ITransition currentTransition;

		/// <summary>
		/// A <code>Stack</code> in which all transitions are stored during iteration.
		/// </summary>
		private Stack transitions;
		
		/// <summary>
		/// Stores all states, which has already been retruned in a <code>Set</code>
		/// </summary>
		protected Set alreadyReturned;

		/// <summary>
		/// for debugging
		/// </summary>
		protected bool debugOutput = !true;
		

		/// <summary>
		/// Initiates a FSM Iterator.
		/// </summary>
		/// <param name="d">The FSM which should be iterated</param>
		public StateIterator(IFiniteStateMachine aIFiniteStateMachine) {
			this.getters =  aIFiniteStateMachine;
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
				CreateInitailTransition();
				return true;
			}
			else {
				IState currentState = (IState) this.states.Peek();
				IList nextStates = this.getters.GetOutgoingTransitions(currentState);
				while(nextStates == null) {
					searchForChildrenOfTopOfStack(currentState, out nextStates);
				}		
				currentState = (IState) this.states.Peek();
				nextStates = getters.GetOutgoingTransitions(currentState);
				ITransition tempTransition = new Transition();
				IEnumerator iterateOverChildren = nextStates.GetEnumerator();
				while(iterateOverChildren.MoveNext()) {
					
					ExploreAllChildrenOfCurrentState(iterateOverChildren);
				}
				//now all children of CS are now on the stack, and cs is completly explored 
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
				TidyUpAndSetReturningValues();
				return true;
			}
		}



		/// <summary>
		/// After iteration this is used to remove ErrorStates from the Stack, 
		/// sets the State and the ITransition which will be returned and adds this
		/// state to the visited states so they won't be retruned again.
		/// </summary>
		private void TidyUpAndSetReturningValues() {
			if(this.states.Peek().Equals(new State("ErrorState",false,false))) {
				states.Pop();
				this.MoveNext();
			}
			this.returnState = (IState) this.states.Peek();
			this.currentTransition = (ITransition) this.transitions.Peek();
			this.alreadyReturned.Add((IState) this.states.Peek());
		}


		/// <summary>
		/// If the currentState has no children, this method is called to deliver all 
		/// children of the state which is on top of the stack.
		/// </summary>
		/// <param name="currentState">The current State of the iteration</param>
		/// <param name="nextStates">A list which contains the children of top of  stack </param>
		private void searchForChildrenOfTopOfStack(IState currentState, out IList nextStates) {
			if(this.debugOutput)
				Console.WriteLine("There are no Children from "+currentState.ToString());
			//now there are no children left and this this state is now complety explored,
			this.visited.Add(currentState);
			this.states.Pop();
			this.transitions.Pop();
			//next children 
			nextStates = this.getters.GetOutgoingTransitions((IState) this.states.Peek());
		}


		/// <summary>
		/// Explores all children of the currentState and stores.
		/// </summary>
		/// <param name="iterateOverChildren">IEnumerator which helps to iterate</param>
		private void ExploreAllChildrenOfCurrentState(IEnumerator iterateOverChildren) {
			ITransition tempTransition;
			tempTransition = (ITransition) iterateOverChildren.Current;
			this.states.Push(tempTransition.DestinationState);
			this.transitions.Push(tempTransition);
			if(this.debugOutput)
				Console.WriteLine(tempTransition.DestinationState.ToString()+" ís pushed on the stack");
		}


		/// <summary>
		/// Creates a ITransition from nowhere to the Startstate
		/// </summary>
		private void CreateInitailTransition() {
			this.states.Push(this.getters.StartState); 
			this.isInitialised = true;
			this.returnState = (IState) this.states.Peek();
			//First ITransition of a FSM 
			IState none = new State("null",false,false);
			Input noInput = new Input("null"); 
			ITransition initialTransition = new Transition(none,new Input("null"),this.returnState);
			this.transitions.Push(initialTransition);
			this.alreadyReturned.Add(this.returnState);
			this.currentTransition = (ITransition) this.transitions.Peek();
		}


		/// <summary>
		/// Returns the current object of the FSM.
		/// </summary>
		public object Current {
			get {
				return this.returnState;
			}
		}


		/// <summary>
		/// return the current Transtion.
		/// </summary>
		public object getCurrentTransition {
			get {
				return this.currentTransition;
			}
		}
	
	}
}
