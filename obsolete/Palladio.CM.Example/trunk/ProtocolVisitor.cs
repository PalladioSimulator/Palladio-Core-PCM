using System;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel;

namespace Palladio.CM.Example
{
	public class ExternalCallNeededEventArgs
	{
		protected IMatchable externalCall;
		
		public IMatchable ExternalCall
		{
			get
			{
				return externalCall;
			}
		}

		public ExternalCallNeededEventArgs(IMatchable sig)
		{
			this.externalCall = sig;
		}
	}

	public delegate void ExternalCallNeededEventHandler(object sender, ExternalCallNeededEventArgs args);

	/// <summary>
	/// Zusammenfassung für ProtocolVisitor.
	/// </summary>
	public class ProtocolVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor
	{
		protected IFiniteStateMachine fsm;
		protected Random rand = new Random();
		protected int level;

		public override void VisitObject(object o) {}

		public void VisitIState(IState s)
		{
			if (fsm.GetOutgoingTransitions(s).Length > 0)
			{
				if (fsm.IsFinalState(s))
				{
					// 50:50 weitergehen oder ende
					if (rand.Next(100) < 20) 
					{
						// Console.WriteLine("Final state found and randomly aborting");
						return;
					}
				}
				// Visit a transition equally randomly
				int visitTransition = rand.Next(fsm.GetOutgoingTransitions(s).Length);
				Visit(fsm.GetOutgoingTransitions(s)[visitTransition]);
			}
		}

		public void VisitITransition(ITransition t)
		{
			IMatchable sig = (IMatchable)t.InputSymbol.ID;
			Console.WriteLine("".PadRight(level*2) + "Calling: " + sig);
			ExternalCallNeededEvent(this,new ExternalCallNeededEventArgs(sig));
			Console.WriteLine("".PadRight(level*2) + "Returned from: " + sig);
			Visit(t.DestinationState);
		}

		public ProtocolVisitor(IFiniteStateMachine fsm,int level) : base (false)
		{
			this.fsm = fsm;
			this.level = level;
		}

		public event ExternalCallNeededEventHandler ExternalCallNeededEvent;
	}
}
