using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.FiniteStateMachines 
{
	/// <summary>
	/// Íterates over the Transitions of a FSM.
	/// </summary>
	public class TransitionIterator 
	{		

		//the TransitionIterator uses a StateIterator 
		private Stack transitions;
		private Set visited;
		private IFiniteStateMachine fsm;
		private bool init = false;


		/// <summary>
		/// Inits a  Transitioniterator
		/// </summary>
		/// <param name="aFSM">The <code>IFiniteStateMachine</code> which should be iterated</param>
		public TransitionIterator(IFiniteStateMachine aFSM)
		{
			this.fsm =  aFSM;
			this.transitions = new Stack();
			this.visited = new Set();
		}

		private void traverse()
		{
			ITransition current = (ITransition)this.transitions.Pop();
			IState destinationState = current.DestinationState;
			//look for next Transitions
			IList nextTransitions = this.fsm.GetOutgoingTransitions(destinationState);
			foreach(ITransition tr in nextTransitions)
			{
					if(!(this.transitions.Contains(tr)))
						if((current!= tr))
							if(!this.visited.Contains(tr))
							{
								this.transitions.Push(tr);
							}
			}
		}


		/// <summary>
		/// Checks if there is another ITransition to iterate
		/// </summary>
		/// <returns></returns>
		public bool MoveNext()
		{
			if(!this.init)
			{
				IList trans  = this.fsm.GetOutgoingTransitions(fsm.StartState);
				foreach(ITransition tr in trans)
				{
					this.transitions.Push(tr);
	
				}
				this.visited.Add(this.transitions.Peek());
				this.init = true;
				return true;
			}
			traverse();
			if(this.transitions.Count!=0)
				this.visited.Add(this.transitions.Peek());
			return (this.transitions.Count!=0);
		}


		/// <summary>
		/// Retruns the current ITransition
		/// </summary>
		public object Current
		{
			get
			{
				return (ITransition) this.transitions.Peek();
			}
		}
	}
}