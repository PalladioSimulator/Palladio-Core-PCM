using System;
using Palladio.ComponentModel;

namespace Palladio.CM.Example
{
	public class CallOnRequiresInterfaceEventArgs : ExternalCallNeededEventArgs
	{
		protected IBasicComponent component;

		public IBasicComponent CallingComponent
		{
			get
			{
				return component;
			}
		}

		public CallOnRequiresInterfaceEventArgs(IBasicComponent callingComponent, ISignature sig):base(sig)
		{
			this.component = callingComponent;
			this.externalCall = sig;
		}
	}

	public delegate void CallOnRequiresInterfaceEventHandler(object sender, CallOnRequiresInterfaceEventArgs args);

	/// <summary>
	/// Zusammenfassung für BasicComponentVisitor.
	/// </summary>
	public class BasicComponentVisitor
	{
		protected IBasicComponent component;

		public void ExternalCallHandler(object sender, ExternalCallNeededEventArgs args)
		{
			if (component.HasProvidesInterface(args.ExternalCall.RoleID))
			{
				VisitComponentMethod(args.ExternalCall);
			}
			else if (component.HasRequiresInterface(args.ExternalCall.RoleID))
			{
				CallOnRequiresInterfaceEvent(this,new CallOnRequiresInterfaceEventArgs(component,args.ExternalCall));
			}
			else
			{
				throw new Exception("External Method not found!");
			}
		}

		public void VisitComponentMethod(ISignature sig)
		{
			Console.WriteLine("Visit Component Method "+sig);
			IFSMProtocol serviceEffect = (IFSMProtocol)component.GetServiceEffectSpecification(sig);
			ProtocolVisitor fsmVisitor = new ProtocolVisitor(serviceEffect.FSM);
			fsmVisitor.ExternalCallNeededEvent += new ExternalCallNeededEventHandler(this.ExternalCallHandler);
			fsmVisitor.VisitIState(serviceEffect.FSM.StartState);
			Console.WriteLine("End visit "+sig);
		}

		public BasicComponentVisitor(IBasicComponent basicComponent)
		{
			component = basicComponent;
		}

		public event CallOnRequiresInterfaceEventHandler CallOnRequiresInterfaceEvent;
	}
}
