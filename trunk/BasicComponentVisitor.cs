using System;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;

namespace Palladio.CM.Example
{
	public class CallOnRequiresInterfaceEventArgs : ExternalCallNeededEventArgs
	{
		protected IBasicComponent component;
		protected int lastLevel;

		public IBasicComponent CallingComponent
		{
			get
			{
				return component;
			}
		}

		public int LastLevel
		{
			get
			{
				return lastLevel;
			}
		}

		public CallOnRequiresInterfaceEventArgs(IBasicComponent callingComponent, IMatchable sig, int lastLevel):base(sig)
		{
			this.component = callingComponent;
			this.externalCall = sig;
			this.lastLevel = lastLevel;
		}
	}

	public delegate void CallOnRequiresInterfaceEventHandler(object sender, CallOnRequiresInterfaceEventArgs args);

	/// <summary>
	/// Zusammenfassung für BasicComponentVisitor.
	/// </summary>
	public class BasicComponentVisitor
	{
		protected IBasicComponent component;
		protected int level;

		public void ExternalCallHandler(object sender, ExternalCallNeededEventArgs args)
		{
			IExternalSignature sig = (IExternalSignature)args.ExternalCall;

			if (component.HasProvidesInterface(sig.RoleID))
			{
				VisitComponentMethod(sig);
			}
			else if (component.HasRequiresInterface(sig.RoleID))
			{
				CallOnRequiresInterfaceEvent(this,new CallOnRequiresInterfaceEventArgs(component,args.ExternalCall,level));
			}
			else
			{
				throw new Exception("External Method not found!");
			}
		}

		public void VisitComponentMethod(IExternalSignature sig)
		{
			Console.WriteLine("".PadRight(level*2) + "Visit Component Method "+sig);
			IServiceEffectSpecification seff = component.GetServiceEffectSpecification(sig);
			IFSMServiceEffect serviceEffect = (IFSMServiceEffect)seff.GetAuxiliarySpecification(typeof(IFSMServiceEffect));
			ProtocolVisitor fsmVisitor = new ProtocolVisitor(serviceEffect.FSM,level);
			fsmVisitor.ExternalCallNeededEvent += new ExternalCallNeededEventHandler(this.ExternalCallHandler);
			fsmVisitor.VisitIState(serviceEffect.FSM.StartState);
			Console.WriteLine("".PadRight(level*2) + "End visit "+sig);
		}

		public BasicComponentVisitor(IBasicComponent basicComponent, int level)
		{
			component = basicComponent;
			this.level = level;
		}

		public event CallOnRequiresInterfaceEventHandler CallOnRequiresInterfaceEvent;
	}
}
