using System;
using System.Collections;

namespace FiniteStateMachines 
{
	/// <summary>
	/// Íterates over the Transitions of a FSM.
	/// </summary>
	public class TransitionIterator 
	{		
		private StateIterator stateIter;

		public TransitionIterator(IFiniteStateMachine aFSM)
		{
			this.stateIter = new StateIterator(aFSM);
		}

		public bool MoveNext()
		{
			return this.stateIter.MoveNext();
		}

		public object Current
		{
			get
			{
				return this.stateIter.getCurrentTransition;
			}
		}
	}
}
//		protected Transition[] array;
//		protected ArrayList store;
//		protected int counter;
//		public TransitionIterator(IFiniteStateMachine f) {
//			
//			this.array = f.GetTransitions();
//			this.store = new ArrayList();
//			foreach(Transition t in this.array)
//				this.store.Add(t);
//			this.counter =-1;
//		}
//		/// <summary>
//		/// checks, if there is a another Transition to iterate over.
//		/// </summary>
//		/// <returns></returns>
//		public bool MoveNext() {
//			this.counter++;
//			if(this.store.Count<= this.counter)
//				return false;
//			return true;
//		}
//		/// <summary>
//		/// returns the current Transition
//		/// </summary>
//		public object Current {
//			get {
//				return this.store[this.counter];
//			}
//		}
//
//	}
//}
