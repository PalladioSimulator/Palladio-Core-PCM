using System;
using System.Collections;
using Utils.Collections;

namespace FiniteStateMachines 
{
	/// <summary>
	/// Helps to iterate over the States of a IFiniteStateMachine by brearh-first-search. 
	/// When this class has been initiated, all states of this fsm are stored
	/// in a array-List.
	/// Its only usefull for small IFiniteStateMachines.
	/// </summary>
	public class StateIteratorWithBreathFirst 
	{
		/// <summary>
		/// A <code>ArrayList</code> which contians all allready visited States
		/// </summary>
		private ArrayList visitedStates;

		/// <summary
		/// Counts how many states are in this FSM.
		/// </summary>
		private int howMany;

		/// <summary>
		/// The current state of the iteration 
		/// </summary>
		private AbstractState currentState;

		/// <summary>
		/// The index in visitedStates which has been already retruned.
		/// </summary>
		private int currentIndex;

		/// <summary>
		/// The thing we want to iterate over
		/// </summary>
		private IFiniteStateMachine fsm;

		/// <summary>
		/// for debugging
		/// </summary>
		private bool debugOutput = !true;

		/// <summary>
		/// the current number which is returned
		/// </summary>
		private int outGoingIndex;
		
		/// <summary>
		/// initiates a StateIteratorWithBreath-FrstWithBreath-firstWithBreath-first
		/// </summary>
		/// <param name="f"></param>
		public StateIteratorWithBreathFirst(IFiniteStateMachine aFsm) 
		{
			this.fsm = aFsm;
			this.currentState = this.fsm.StartState;
			this.visitedStates = new ArrayList();
			this.visitedStates.Add(this.currentState);
			this.howMany = 0;
			this.currentIndex = 0;
			traverse();
			this.outGoingIndex = -1;
		}

		/// <summary>
		/// Iterates over the IFiniteStateMachine and stores all explored states.
		/// </summary>
		protected void traverse() 
		{
			while(true) 
			{
				try 
				{
					IList tmp = this.fsm.GetOutgoingTransitions(this.currentState);
					IEnumerator iterator = tmp.GetEnumerator();
					while(iterator.MoveNext()) 
					{
						Transition  t = (Transition)iterator.Current;
						AbstractState visiting = t.DestinationState;
						if(!this.visitedStates.Contains(visiting)) 
						{
							this.visitedStates.Add(visiting);
							this.howMany++;
						}
					}
				}
				catch(InvalidInputException) 
				{}
				catch(InvalidStateException) 
				{}
				this.currentIndex++;
				if(this.howMany < this.currentIndex)
					break;
				this.currentState = (AbstractState) this.visitedStates[this.currentIndex];

			}
			if(this.debugOutput) 
			{
				Console.WriteLine("vor Arrayauagabe");
				foreach(AbstractState t in this.visitedStates)
					Console.WriteLine("After traverse in Array: "+t.ToString());
			}
		}


		/// <summary>
		/// checks if there is another State to iterate over.
		/// </summary>
		/// <returns></returns>
		public bool MoveNext() 
		{
			this.outGoingIndex++;
			if(this.outGoingIndex>this.howMany)
				return false;
			return true;
		}


		/// <summary>
		/// Returns the Current object of the iteration
		/// </summary>
		public object Current 
		{
			get 
			{
				return this.visitedStates[this.outGoingIndex];
			}
		}

	}
}
		