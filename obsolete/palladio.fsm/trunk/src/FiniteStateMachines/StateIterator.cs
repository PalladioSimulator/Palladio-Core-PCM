using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.FiniteStateMachines 
{
	/// <summary>
	/// Iterates over the States of a IFiniteStateMachine with depth-first-search
	/// </summary>
	public class StateIterator
	{

		/// <summary>
		/// Stores all states that has been alrady returned in a <c>Set</c>
		/// </summary>
		private Set visited; 

		/// <summary>
		/// Temporary (during iteration) the states are stored here.
		/// </summary>
		private Stack states;


		/// <summary>
		/// The thing we want to iterate over.
		/// </summary>
		private IFiniteStateMachine StateMachine;

		/// <summary>
		/// The current state of the iteration, this will be returned
		/// </summary>
		private IState returnState;

		/// <summary>
		/// A flag whic signalized if further iteration is possible
		/// </summary>
		private bool furtherIterationPossible = true;


		/// <summary>
		/// Helps to start iteration
		/// </summary>
		private bool init = false;


		/// <summary>
		/// Initiates a FSM Iterator.
		/// </summary>
		/// <param name="d">The FSM which should be iterated</param>
		public StateIterator(IFiniteStateMachine aIFiniteStateMachine) 
		{
			this.StateMachine =  aIFiniteStateMachine;
			this.states = new Stack();
			this.visited = new Set();
//			this.states.Push(this.StateMachine.StartState);
//			this.returnState = (IState)this.states.Peek();
//			this.furtherIterationPossible = true;
		}


		private void traverse()
		{
			try
			{
				this.returnState = (IState) this.states.Pop();
			}
			catch(InvalidOperationException)
			{
			  this.furtherIterationPossible = false;
			}

			this.visited.Add(this.returnState);
			Set nextStates = new Set();
			foreach(Input i in this.StateMachine.InputAlphabet)
			{
				nextStates.Add(this.StateMachine.GetNextState(this.returnState,i));
			}
			IEnumerator enumerator = nextStates.GetEnumerator();

			while(enumerator.MoveNext())
			{

				IState currentState = (IState) enumerator.Current;

				if(!this.visited.Contains(currentState))
					if(!this.states.Contains(currentState))
						if(!(this.StateMachine.ErrorState.Equals(currentState)))
						{
							 this.states.Push(currentState);
						}
			}
			if(this.states.Count==0)
			{
				this.furtherIterationPossible = false;
			}
		}


		public bool MoveNext()
		{
			if(!this.init)
			{
				this.states.Push(this.StateMachine.StartState);
				this.returnState = (IState)this.states.Peek();
				this.init = true;
			}

			bool returnValue = this.furtherIterationPossible;
			traverse();
			return returnValue;
		}


		public IState Current
		{
		  get
		  {
		    return this.returnState;
		  }
		}
	}
}

