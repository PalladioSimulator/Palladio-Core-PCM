using System;
using ComponentNetworkSimulation.Structure.Elements;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure.Visitor
{
	/// <summary>
	/// This class is the default visitor for composite components in this framework. It walks through the components it contains.
	/// The start is defined by the composite component, the id of a provided interface and the id of a signature of 
	/// this provided interface.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.5  2004/07/05 11:16:03  joemal
	/// - changes in the CM after code review
	///
	/// Revision 1.4  2004/06/22 12:24:30  joemal
	/// now use the factory to create the component visitors
	///
	/// Revision 1.3  2004/06/19 16:04:42  joemal
	/// add new event for unbound requires interfaces
	///
	/// Revision 1.2  2004/06/19 13:43:53  joemal
	/// - add new constructors
	/// - add some exception handling
	///
	/// Revision 1.1  2004/06/18 17:20:13  joemal
	/// initial class creation
	///
	/// 
	/// </pre>	
	/// </remarks>
	public class DefaultCompositeComponentVisitor : AbstractComponentVisitor
	{
		#region data
		
		/// <summary>
		/// the stack used to hold the componentvisitors allong the controlflow.
		/// </summary>
		private System.Collections.Stack visitorStack = new System.Collections.Stack();

		/// <summary>
		/// holds the factory used to create visitors
		/// </summary>
		private IVisitorFactory factory;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new <code>DefaultCompositeVisitor</code> from given component. The given visitor belongs to an
		/// inner component of this one. This constructor normaly is used by <code>IComponentArchitecture</code> to
		/// create the chain of visitors to the given starting point. 
		/// </summary>
		/// <param name="component">the component</param>
		/// <param name="innerComponentVisitor">the visitor of one of the inner components.</param>
		/// <param name="factory">the factory used to create new visitors</param>
		public DefaultCompositeComponentVisitor(ICompositeComponent component, IComponentVisitor innerComponentVisitor,
			IVisitorFactory factory):base(component)
		{
			this.factory = factory;
			innerComponentVisitor.OnVisitorEvent += new VisitorEventHandler(HandleVisitorEvent);
			visitorStack.Push(innerComponentVisitor);
		}

		/// <summary>
		/// constructs a new <code>DefaultCompositeVisitor</code> from given component and signature.
		/// </summary>
		/// <param name="component">the component</param>
		/// <param name="signature">the external signature to be called</param>
 		/// <param name="factory">the factory used to create new visitors</param>
		public DefaultCompositeComponentVisitor(ICompositeComponent component, IExternalSignature signature, IVisitorFactory factory):
			this(component,signature.RoleID, signature.Signature.ID,factory)
		{			
		}

		/// <summary>
		/// constructs a new <code>DefaultCompositeVisitor</code> from given component, interfaceID and signatureID.
		/// This constructor normaly is used to create a visitor from <code>IThreadStartingPoint</code>.
		/// </summary>
		/// <param name="component">the composite component</param>
		/// <param name="interfaceID">the id of the interface</param>
		/// <param name="signatureID">the id of the signature</param>
  		/// <param name="factory">the factory used to create new visitors</param>
		/// <exception cref="Palladio.ComponentModel.RoleIDNotFoundException">
		/// thrown, if the interface with given id can't be found in the component
		/// </exception>
		///	<exception cref="Palladio.ComponentModel.SignatureNotFoundException">
		/// thrown, if the signature with given id can't be found in interface
		/// </exception>
		public DefaultCompositeComponentVisitor(ICompositeComponent component, IIdentifier interfaceID, IIdentifier signatureID,
			IVisitorFactory factory):base(component)
		{
			this.factory = factory;
			Init(interfaceID, signatureID);
		}

        #endregion

		#region properties
        
		/// <summary>
		/// return the composite component visited by this visitor
		/// </summary>
		public ICompositeComponent CompositeComponent
		{
			get
			{
				return (ICompositeComponent)Component;
			}
		}
		
		/// <summary>
		/// return the current element of the visitor. If the current visited element exists in an inner component, this
		/// call is delegated to the visitor of this component.
		/// </summary>
		public override object CurrentElement
		{
			get
			{
				if (visitorStack.Count == 0) return null;
				
				object top = visitorStack.Peek();
                if (top is IComponentVisitor)
					return ((IComponentVisitor)top).CurrentElement;
				else
					return top;
			}
		}

		#endregion 

		#region methods

		/// <summary>
		/// called to visit the next element. If the current element exists in an inner component, this call is deligated to
		/// the visitor of this inner component.
		/// </summary>
		public override void NextElement()
		{
			if (visitorStack.Count != 0) Visit(visitorStack.Peek());			
		}

		/// <summary>
		/// called by the visitor, if the element to be visited is a binding. This methods then visits the component in 
		/// provides role of this binding.
		/// </summary>
		/// <param name="binding">the binding</param>
		public void VisitIBinding(IBinding binding)
		{
			//remove binding, now a signature is on top of the stack
			visitorStack.Pop();	
			Visit(binding.ProvidingRole.Component);
		}

		/// <summary>
		/// this method is called, if the element to be visited is a <code>IBasicComponent</code>. In this case, 
		/// a new <code>DefaultBasicComponentVisitor</code> is created and pushed to the top of the stack.
		/// </summary>
		/// <param name="component">the component</param>
		public void VisitIBasicComponent(IBasicComponent component)
		{
			//in the stack, the external signature to be called is following the element binding
			IExternalSignature calledSignature = (IExternalSignature)visitorStack.Pop();

			IComponentVisitor compVisitor = factory.CreateVisitor(component,calledSignature);

			compVisitor.OnVisitorEvent +=new VisitorEventHandler(HandleVisitorEvent);
            visitorStack.Push(compVisitor);
		}

		/// <summary>
		/// this method is called, if the element to be visited is a <code>ICompositeComponent</code>. In this case, 
		/// a new <code>DefaultCompositeComponentVisitor</code> is created and pushed to the top of the stack.
		/// </summary>
		/// <param name="component">the component</param>
		public void VisitICompositeComponent(ICompositeComponent component)
		{
			//in the stack, the external signature to be called is following the element binding
			IExternalSignature calledSignature = (IExternalSignature)visitorStack.Pop();

			IComponentVisitor compVisitor = factory.CreateVisitor(component,calledSignature); 

			compVisitor.OnVisitorEvent += new VisitorEventHandler(HandleVisitorEvent);
			visitorStack.Push(compVisitor);
		}

		/// <summary>
		/// called, if the element to be visited is a component visitor. In this case, the methods <code>nextElement()</code>
		/// of this visitor is called.
		/// </summary>
		/// <param name="visitor">the visitor</param>
		public void VisitIComponentVisitor(IComponentVisitor visitor)
		{
			visitor.NextElement();
		}

		/// <summary>
		/// called by the constructor to find the first component after a mapping.
		/// </summary>
		/// <param name="interfaceID">the id of the provided interface of the composite component</param>
		/// <param name="signatureID">the id of the signature</param>
		/// <exception cref="Palladio.ComponentModel.RoleIDNotFoundException">
		/// thrown, if the interface with given id can't be found in the component
		/// </exception>
		///	<exception cref="Palladio.ComponentModel.SignatureNotFoundException">
		/// thrown, if the signature with given id can't be found in interface
		/// </exception>
		private void Init(IIdentifier interfaceID, IIdentifier signatureID)
		{
			IInterfaceModel iface = CompositeComponent.GetProvidesInterface(interfaceID);

			ISignature[] sig = iface.SignatureList.GetSignaturesByID(signatureID);
			if (sig.Length == 0)
				throw new Palladio.ComponentModel.Exceptions.SignatureNotFoundException(signatureID);

			IMapping mapping = CompositeComponent.GetProvidesMappingByOuter(interfaceID);
			IComponent innerComponent = mapping.ProvidingRole.Component;

			IExternalSignature calledSignature = ComponentFactory.
				CreateExternalSignature(mapping.ProvidingRole.RoleID,sig[0]);

			visitorStack.Push(calledSignature);
			Visit(innerComponent);
        }

		/// <summary>
		/// called by a visitor of an inner component to notify this visitor about something
		/// </summary>
		/// <param name="source">the calling visitor</param>
		/// <param name="args">the parameter</param>
		private void HandleVisitorEvent(object source, VisitorEventArgs args)
		{
			switch(args.Type)
			{
				case VisitorEventArgs.EventType.TYPE_EXTERNALCALL:
					HandleExternalCall(args.Component, args.Signature);
					break;
				case VisitorEventArgs.EventType.TYPE_RETURN:
					HandleExternalReturn();
					break;
				case VisitorEventArgs.EventType.TYPE_UNKNOWN_ELEMENT:
					visitorStack.Clear();
					NotifyUnknownElement();
					break;
				case VisitorEventArgs.EventType.TYPE_UNBOUNDREQUIRES:
					NotifyUnboundRequiresInterface(args.Component,args.Signature);
					break;
			}
		}

		/// <summary>
		/// called if the fired event is from type TYPE_EXTERNALCALL. In this case the binding of this external is searched.
		/// The provided external signature to be called is pushed to the stack. Then the binding is pushed too.
		/// </summary>
		/// <param name="callingComponent">the component that fired the event</param>
		/// <param name="callingSignature">the required signature to be called</param>
		private void HandleExternalCall(IComponent callingComponent, IExternalSignature callingSignature)
		{
			if (LookForBinding(callingComponent,callingSignature)) return;
			if (LookForMapping(callingComponent,callingSignature)) return;

			NotifyUnboundRequiresInterface(callingComponent, callingSignature);
				
		}

		/// <summary>
		/// look, if the requires interface of the calling component is bound via a requires mapping.
		/// </summary>
		/// <param name="comp">the calling component</param>
		/// <param name="extSig">the calling signature</param>
		/// <returns>true, if a requires mapping was found</returns>
		private bool LookForMapping(IComponent comp,IExternalSignature extSig)
		{
			try 
			{
				IMapping mapping = CompositeComponent.GetRequiresMappingByInner(comp.ID,extSig.RoleID);

				IExternalSignature calledSignature = ComponentFactory.CreateExternalSignature(mapping.RequiringRole.RoleID,
					extSig.Signature);

				NotifyExternalCall(calledSignature);
				return true;
			}
			catch
			{
				return false;
			}
		}

		/// <summary>
		/// look, if the requires interface of the calling component is bound via a binding.
		/// </summary>
		/// <param name="comp">the calling component</param>
		/// <param name="extSig">the calling signature</param>
		/// <returns>true, if a bindinf was found</returns>
		private bool LookForBinding(IComponent comp,IExternalSignature extSig)
		{
			try 
			{
				IBinding binding = CompositeComponent.GetBindingByRequires(comp.ID,extSig.RoleID);
				IExternalSignature calledSignature = ComponentFactory.CreateExternalSignature(binding.ProvidingRole.RoleID,
					extSig.Signature);

				//push the external signature of the providing component to the stack
				visitorStack.Push(calledSignature);			
				visitorStack.Push(binding);
				return true;
			}
			catch
			{
				return false;
			}
		}

		/// <summary>
		/// called, when the fired event is from type TYPE_RETURN. This indicates, that the visitor of the inner component
		/// reached the end of its controlflow. This visitor than is poped from the stack.
		/// </summary>
		private void HandleExternalReturn()
		{
			visitorStack.Pop();
			if (visitorStack.Count == 0) NotifyServiceReturned();
		}

		#endregion
	}
}
//EOF