using System;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace Palladio.CM.Example
{
	/// <summary>
	/// Zusammenfassung für CompositeComponentVisitor.
	/// </summary>
	public class CompositeComponentVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor
	{
		protected ICompositeComponent compCom;
		protected IIdentifier simulatedRole;
		protected IMapping externalMapping;

		public override void VisitObject(object o) { }

		public void VisitIMapping(IMapping mapping)
		{
			Console.WriteLine("Visit Mapping: " + mapping.OuterRole + " --> " + mapping.InnerRole);
		}

		public void VisitIBinding(IBinding binding,int level)
		{
			Console.WriteLine("".PadRight(level*2)+"Visit Binding: " + binding.RequiringRole + " --> " + binding.ProvidingRole);
		}

		public void ExternalRequiresCallHandler(object sender, CallOnRequiresInterfaceEventArgs args)
		{
			IExternalSignature sig = (IExternalSignature)args.ExternalCall;
			IBinding componentBinding = compCom.GetBindingByRequires(args.CallingComponent.ID,sig.RoleID);
			VisitIBinding(componentBinding,args.LastLevel);
			BasicComponentVisitor visitor = new BasicComponentVisitor((IBasicComponent)componentBinding.ProvidingRole.Component,args.LastLevel+1);
			visitor.CallOnRequiresInterfaceEvent += new CallOnRequiresInterfaceEventHandler(this.ExternalRequiresCallHandler);
			visitor.VisitComponentMethod(ComponentFactory.CreateSignatureWithRole(componentBinding.ProvidingRole.RoleID,sig.Signature));
		}

		public void ExternalCallHandler(object sender, ExternalCallNeededEventArgs args)
		{
			Visit(externalMapping);
			BasicComponentVisitor visitor = new BasicComponentVisitor((IBasicComponent)externalMapping.ProvidingRole.Component,1);
			visitor.CallOnRequiresInterfaceEvent += new CallOnRequiresInterfaceEventHandler(this.ExternalRequiresCallHandler);
			visitor.VisitComponentMethod(ComponentFactory.CreateSignatureWithRole(externalMapping.InnerRole.RoleID,(ISignature)args.ExternalCall));
		}
	
		public void VisitICompositeComponent(ICompositeComponent cc)
		{
			IInterfaceModel ifModel = cc.GetProvidesInterface(simulatedRole);
			IFSMInterface protocol = (IFSMInterface)ifModel.GetAuxiliarySpecification(typeof(IFSMInterface));
			ProtocolVisitor visitor = new ProtocolVisitor(protocol.FSM,0);
			visitor.ExternalCallNeededEvent += new ExternalCallNeededEventHandler(this.ExternalCallHandler);
			visitor.VisitIState(protocol.FSM.StartState);
		}

		public CompositeComponentVisitor(ICompositeComponent cc, IIdentifier roleID):base(false)
		{
			this.compCom = cc;
			this.simulatedRole = roleID;
			externalMapping = cc.GetProvidesMappingByOuter(roleID);
			Visit(cc);
		}
	}
}
