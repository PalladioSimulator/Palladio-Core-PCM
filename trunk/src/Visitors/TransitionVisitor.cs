using System;
using ReflectionBasedVisitor;
using Utils.Collections;

namespace Palladio.FiniteStateMachines.Visitors
{
	/// <summary>
	/// A visitor visiting all the reachable transitions of a FSM
	/// </summary>
	internal class TransitionVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor
	{
		private Set transitions = new Set();
		private IFiniteStateMachine fsm = null;

		public ITransition[] VisitedTransitions
		{
			get
			{
				return (ITransition[])transitions.ToArray(Type.GetType("Palladio.FiniteStateMachines.ITransition",true));
			}
		}

		public override void VisitObject(object o)
		{
		}

		public void VisitITransition(ITransition trans)
		{
			transitions.Add(trans);
			Visit(trans.DestinationState);
		}

		public void VisitIState(IState s)
		{
			ITransition[] outgoingTransitions = fsm.GetOutgoingTransitions(s);
			foreach (ITransition trans in outgoingTransitions)
			{
				if (!transitions.Contains(trans))
				{
					Visit(trans);
				}
			}
		}

		public TransitionVisitor(IFiniteStateMachine fsm) : base (false)
		{
			this.fsm = fsm;
		}
	}
}
