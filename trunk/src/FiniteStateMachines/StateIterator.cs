using System;
using System.Collections;
using Utils.Collections;

namespace FiniteStateMachines 
{
	/// <summary>
	/// Iterates over the States of a IFiniteStateMachine with depth-first-search-
	/// </summary>
	public class StateIterator 
	{

		/// <summary>
		/// Stores all states that has been visited in a <code>Set</code>
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
		/// The current state, that will be returned
		/// </summary>
		private AbstractState returnState;

		/// <summary>
		/// The currant Transition that will be returned
		/// </summary>
		private Transition currentTransition;

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
		protected bool debugOutput = true;
		
		/// <summary>
		/// Initiates a FSM Iterator.
		/// </summary>
		/// <param name="d">The FSM which should be iterated</param>
		public StateIterator(IFiniteStateMachine aIFiniteStateMachine) 
		{
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
		public bool MoveNext() 
		{
			if(!this.isInitialised) 
			{
				try
				{
					if(this.getters.StartState == null)
						Console.WriteLine(" ");
				}
				catch(System.NullReferenceException)
				{//if you have no Startstate you can't iterate over a FSM
					return false;
				}
				CreateInitailTransition();
				return true;
			}
			else 
			{
				AbstractState currentState = (AbstractState) this.states.Peek();
				IList nextStates = this.getters.GetOutgoingTransitions(currentState);
				while(nextStates == null) 
				{
					if(this.debugOutput)
						Console.WriteLine("There are no Children from "+currentState.ToString());
					//now there are no children left and this this state is now complety explored,
					this.visited.Add(currentState);
//					while(thatsEqual(currentState, (AbstractState) this.states.Peek()))
//					{
						this.states.Pop();
//						Console.Read();
//					}
					this.transitions.Pop();
					//next children 
					nextStates = this.getters.GetOutgoingTransitions((AbstractState) this.states.Peek());
				}		
				currentState = (AbstractState) this.states.Peek();
				nextStates = getters.GetOutgoingTransitions(currentState);
				Transition tempTransition = new Transition();
				IEnumerator iterateOverChildren = nextStates.GetEnumerator();
				while(iterateOverChildren.MoveNext()) 
				{
					
					ExploreAllChildrenOfCurrentState(iterateOverChildren);
				}
				//now all children of CS are no on the stack, and cs is completly explored 
				this.visited.Add(currentState);
				if(this.debugOutput)
					Console.WriteLine(currentState.ToString()+ " now has been completly doscovered");
				//search of the next State which will be returned
				while(this.alreadyReturned.Contains(this.states.Peek())) 
				{
					if(this.debugOutput)
						Console.WriteLine("This State hs already been discovered "+this.states.Peek().ToString());
					this.states.Pop();
					this.transitions.Pop();
					if(this.states.Count==0)
						return false;
				}
				//Now a State is found, which jet has not been returning
				if(this.states.Peek().Equals(new State("ErrorState",false,false))) 
				{
					states.Pop();
					this.MoveNext();
				}
				this.returnState = (AbstractState) this.states.Peek();
				this.currentTransition = (Transition) this.transitions.Peek();
				this.alreadyReturned.Add((AbstractState) this.states.Peek());
				return true;
			}
		}


		public bool thatsEqual(AbstractState aState, AbstractState bState)
		{
			if(aState.Name == bState.Name)
				if(aState.IsFinalState == bState.IsFinalState)
					if(aState.IsStartState == bState.IsStartState)
						return true;
			return false;
 		}
		/// <summary>
		/// Explores all children of the currentState and stores.
		/// </summary>
		/// <param name="iterateOverChildren">IEnumerator which helps to iterate</param>
		private void ExploreAllChildrenOfCurrentState(IEnumerator iterateOverChildren)
		{
			Transition tempTransition;
			tempTransition = (Transition) iterateOverChildren.Current;
			this.states.Push(tempTransition.DestinationState);
			this.transitions.Push(tempTransition);
			if(this.debugOutput)
				Console.WriteLine(tempTransition.DestinationState.ToString()+" ís pushed on the stack");
		}


		/// <summary>
		/// When a state has completly been explored, this is use to remove the state from the Stack and
		/// add him to the visited states. And look for the next state, which has to be explored.
		/// </summary>
		/// <param name="currentState">The State which has been completly explored</param>
		/// <param name="nextStates">A List of nextStates</param>
//		private void tidyUp(AbstractState currentState, out IList nextStates)
//		{
//			
//		}


		/// <summary>
		/// Creates a Transition from nowhere to the Startstate
		/// </summary>
		private void CreateInitailTransition()
		{
			this.states.Push(this.getters.StartState); 
			this.isInitialised = true;
			this.returnState = (AbstractState) this.states.Peek();
			//First Transition of a FSM 
			AbstractState none = new State("null",false,false);
			Input noInput = new Input("null"); 
			Transition initialTransition = new Transition(none,new Input("null"),this.returnState);
			this.transitions.Push(initialTransition);
			this.alreadyReturned.Add(this.returnState);
			this.currentTransition = (Transition) this.transitions.Peek();
		}


		/// <summary>
		/// Returns the current object of the FSM.
		/// </summary>
		public object Current 
		{
			get 
			{
				return this.returnState;
			}
		}


		/// <summary>
		/// return the current Transtion.
		/// </summary>
		public object getCurrentTransition 
		{
			get 
			{
				return this.currentTransition;
			}
		}
	
	}
}
