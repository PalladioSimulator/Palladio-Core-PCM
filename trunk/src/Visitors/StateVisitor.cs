using System;
using ReflectionBasedVisitor;
using Utils.Collections;

namespace Palladio.FiniteStateMachines.Visitors
{
	/// <summary>
	/// A visitor visiting all the reachable states of a FSM
	/// </summary>
	internal class StateVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor
	{
		private Set stateSet = new Set();
		private IFiniteStateMachine fsm = null;

		public IState[] VisitedStates
		{
			get
			{																		
				return (IState[])stateSet.ToArray(typeof(IState));
			}
		}

		public override void VisitObject(object o)
		{
		}

		public void VisitIState(IState s)
		{
			stateSet.Add(s);
			ITransition[] outgoingTransitions = fsm.GetOutgoingTransitions(s);
			foreach (ITransition trans in outgoingTransitions)
			{
				if (!stateSet.Contains(trans.DestinationState))
				{
					Visit(trans.DestinationState);
				}
			}
		}

		public StateVisitor(IFiniteStateMachine fsm) : base (false)
		{
			this.fsm = fsm;
		}
	}
}
