using System;
using System.Collections;

namespace Palladio.FiniteStateMachines 
{
	/// <summary>
	/// Íterates over the Transitions of a FSM.
	/// </summary>
	public class TransitionIterator 
	{		

		//the TransitionIterator uses a StateIterator 
		private StateIterator stateIter;


		/// <summary>
		/// Inits a  Transitioniterator
		/// </summary>
		/// <param name="aFSM">The <code>IFiniteStateMachine</code> which should be iterated</param>
		public TransitionIterator(IFiniteStateMachine aFSM)
		{
			this.stateIter = new StateIterator(aFSM);
		}

		/// <summary>
		/// Checks if there is another Transition to iterate
		/// </summary>
		/// <returns></returns>
		public bool MoveNext()
		{
			return this.stateIter.MoveNext();
		}

		/// <summary>
		/// Retruns the current Transition
		/// </summary>
		public object Current
		{
			get
			{
				return this.stateIter.getCurrentTransition;
			}
		}
	}
}