using System;
using Palladio.ComponentModel;

namespace Palladio.CM.Example
{
	/// <summary>
	/// Zusammenfassung für CompositeComponentVisitor.
	/// </summary>
	public class CompositeComponentVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor
	{
		protected ICompositeComponent compCom;
		protected string simulatedRole;
		protected IMapping externalMapping;

		public override void VisitObject(object o) { }

		public void ExternalRequiresCallHandler(object sender, CallOnRequiresInterfaceEventArgs args)
		{
			IBinding componentBinding = compCom.GetBindingByRequires(args.CallingComponent,args.ExternalCall.RoleID);
			Visit(componentBinding);
			BasicComponentVisitor visitor = new BasicComponentVisitor((IBasicComponent)componentBinding.ProvidesInterface.Component);
			visitor.CallOnRequiresInterfaceEvent += new CallOnRequiresInterfaceEventHandler(this.ExternalRequiresCallHandler);
			visitor.VisitComponentMethod(ComponentFactory.CreateSignatureFromOtherSignature(args.ExternalCall,componentBinding.ProvidesInterface.RoleID));
		}

		public void ExternalCallHandler(object sender, ExternalCallNeededEventArgs args)
		{
			Visit(externalMapping);
			BasicComponentVisitor visitor = new BasicComponentVisitor((IBasicComponent)externalMapping.InnerInterface.Component);
			visitor.CallOnRequiresInterfaceEvent += new CallOnRequiresInterfaceEventHandler(this.ExternalRequiresCallHandler);
			visitor.VisitComponentMethod(ComponentFactory.CreateSignatureFromOtherSignature(args.ExternalCall,externalMapping.InnerInterface.RoleID));
		}
	
		public void VisitICompositeComponent(ICompositeComponent cc)
		{
			IFSMProtocol protocol = (IFSMProtocol)cc.GetProvidesInterface(simulatedRole);
			ProtocolVisitor visitor = new ProtocolVisitor(protocol.FSM);
			visitor.ExternalCallNeededEvent += new ExternalCallNeededEventHandler(this.ExternalCallHandler);
			visitor.VisitIState(protocol.FSM.StartState);
		}

		public CompositeComponentVisitor(ICompositeComponent cc, string roleID):base(false)
		{
			this.compCom = cc;
			this.simulatedRole = roleID;
			externalMapping = cc.GetProvidesMappingByOuter(roleID);
			Visit(cc);
		}
	}
}
