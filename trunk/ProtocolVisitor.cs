using System;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel;

namespace Palladio.CM.Example
{
	public class ExternalCallNeededEventArgs
	{
		protected ISignature externalCall;
		
		public ISignature ExternalCall
		{
			get
			{
				return externalCall;
			}
		}

		public ExternalCallNeededEventArgs(ISignature sig)
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

		public override void VisitObject(object o) {}

		public void VisitIState(IState s)
		{
			Console.WriteLine("Visiting State: "+s.ID);
			if (fsm.GetOutgoingTransitions(s).Length > 0)
			{
				if (fsm.IsFinalState(s))
				{
					// 50:50 weitergehen oder ende
					if (rand.Next(100) < 50) 
					{
						Console.WriteLine("Final state found and randomly aborting");
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
			ISignature sig = (ISignature)t.InputSymbol.ID;
			Console.WriteLine("Calling: " + sig);
			ExternalCallNeededEvent(this,new ExternalCallNeededEventArgs(sig));
			Visit(t.DestinationState);
		}

		public ProtocolVisitor(IFiniteStateMachine fsm) : base (false)
		{
			this.fsm = fsm;
		}

		public event ExternalCallNeededEventHandler ExternalCallNeededEvent;
	}
}
