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

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new <code>DefaultCompositeVisitor</code> from given component, interfaceID and signatureID.
		/// </summary>
		/// <param name="component">the composite component</param>
		/// <param name="interfaceID">the id of the interface</param>
		/// <param name="signatureID">the id of the signature</param>
		public DefaultCompositeComponentVisitor(ICompositeComponent component, IIdentifier interfaceID, IIdentifier signatureID):
			base(component)
		{
			init(interfaceID, signatureID);
		}

		/// <summary>
		/// constructs a new <code>DefaultCompositeVisitor</code> from given component and a external signature which 
		/// describes the provided interface and the signature to be called.
		/// </summary>
		/// <param name="component">the component</param>
		/// <param name="signature">the signature to be called</param>
		public DefaultCompositeComponentVisitor(ICompositeComponent component, IExternalSignature signature):
			base(component)
		{
			visitorStack.Push(signature);
			Visit(component);
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

			IComponentVisitor compVisitor = new DefaultBasicComponentVisitor(component,calledSignature);
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

			IComponentVisitor compVisitor = new DefaultCompositeComponentVisitor(component,calledSignature);
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
		private void init(IIdentifier interfaceID, IIdentifier signatureID)
		{
			IInterfaceModel iface = CompositeComponent.GetProvidesInterface(interfaceID);
			ISignature signature = iface.SignatureList.GetSignaturesByID(signatureID)[0];

			IMapping mapping = CompositeComponent.GetProvidesMappingByOuter(interfaceID);
			IComponent innerComponent = mapping.ProvidingRole.Component;

			IExternalSignature calledSignature = ComponentFactory.
				CreateSignatureWithRole(mapping.ProvidingRole.RoleID,signature);

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
					NotifyUnknownElement();
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
			IBinding binding = CompositeComponent.GetBindingByRequires(callingComponent.ID,callingSignature.RoleID);
			IExternalSignature calledSignature = ComponentFactory.CreateSignatureWithRole(binding.ProvidingRole.RoleID,
				callingSignature.Signature);

			//push the external signature of the providing component to the stack
			visitorStack.Push(calledSignature);			
			visitorStack.Push(binding);
		}

		/// <summary>
		/// called, when the fired event is from type TYPE_RETURN. This indicates, that the visitor of the inner component
		/// reached the end of its controlflow. This visitor than is poped from the stack.
		/// </summary>
		private void HandleExternalReturn()
		{
			visitorStack.Pop();
		}

		#endregion
	}
}
//EOF