using System;
using Palladio.Simulation.Model.Elements;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;

namespace Palladio.Simulation.Model.Visitor
{
	/// <summary>
	/// This class is the default visitor for basic components in this framework. It walks through the service effect fsm of 
	/// its component, identified by the given signature.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/07/29 15:13:48  joemal
	/// - changes from the review
	///
	/// Revision 1.1  2004/07/20 11:46:42  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultBasicComponentVisitor : AbstractComponentVisitor
	{
		#region data

		/// <summary>
		/// the fsm of the service
		/// </summary>
		private IFiniteStateMachine serviceFSM;

		/// <summary>
		/// the current element
		/// </summary>
		private object currentElement;

		#endregion

		#region constructor
		
		/// <summary>
		/// constructs a new <c>DefaultBasicComponentVisitor</c> from the given basic component and signature.
		/// This constructor normaly is used by another visitor when an inner component should be entered.
		/// </summary>
		/// <param name="component">the component to be visited</param>
		/// <param name="signature">the signature</param>		
		public DefaultBasicComponentVisitor(IBasicComponent component, IExternalSignature signature):base(component)
		{
			Init(signature);
		}

		/// <summary>
		/// constructs a new <c>DefaultBasicComponentVisitor</c> from the given basic component using the given
		/// interface and signature. This constructor normaly is to create a visitor from <c>IThreadStartingPoint</c>.
		/// </summary>
		/// <param name="component">the component to be visited</param>
		/// <param name="interfaceID">the id of the interface</param>
		/// <param name="signatureID">the id of the signature</param>
		/// <exception cref="Palladio.ComponentModel.Exceptions.RoleIDNotFoundException">
		/// thrown, if the interface with given id can't be found in the component
		/// </exception>
		///	<exception cref="Palladio.ComponentModel.Exceptions.SignatureNotFoundException">
		/// thrown, if the signature with given id can't be found in interface
		/// </exception>
		public DefaultBasicComponentVisitor(IBasicComponent component, IIdentifier interfaceID, IIdentifier signatureID):base(component)
		{
			IInterfaceModel iface = component.GetProvidesInterface(interfaceID);
			ISignature[] sig = iface.SignatureList.GetSignaturesByID(signatureID);

			if (sig.Length == 0)
				throw new Palladio.ComponentModel.Exceptions.SignatureNotFoundException(signatureID);

			Init(ComponentFactory.CreateExternalSignature(interfaceID,sig[0]));			
		}

		#endregion

		#region properties

		/// <summary>
		/// return the current element of this visitor
		/// </summary>
		public override object CurrentElement
		{
			get
			{
				return this.currentElement;
			}
		}

		/// <summary>
		/// return the basic component of this visitor
		/// </summary>
		public IBasicComponent BasicComponent
		{
			get
			{
				return (IBasicComponent)this.Component;
			}
		}

		#endregion

		#region methods

		/// <summary>
		/// finds the fsm of the service described by the given external signature and set its startstate as current element.
		/// </summary>
		/// <param name="extSignature"></param>
		private void Init(IExternalSignature extSignature)
		{
			IServiceEffectSpecification seff = BasicComponent.GetServiceEffectSpecification(extSignature);
			IFSMServiceEffect serviceEffect = (IFSMServiceEffect)seff.GetAuxiliarySpecification(typeof(IFSMServiceEffect));
			this.serviceFSM = serviceEffect.FSM;
			this.currentElement = serviceFSM.StartState;			
		}

		/// <summary>
		/// call to let the visitor jump to the next element
		/// </summary>
		public override void NextElement()
		{
			if (currentElement!= null) Visit(currentElement);
		}
			
		/// <summary>
		/// called by the visitor, if the element to be visited is a state. This methods decides which transition
		/// has to be the next element. If this state is a final state, the next element might be null. In this case 
		/// a visitorevent from type TYPE_RETURN is fired to inicate that the visitor 
		/// reached the end of its controlflow.
		/// </summary>
		/// <param name="state">the state</param>
		public void VisitIState(IState state)
		{
			ITransition nextTransition;

			if (state is ISimulationState)
				nextTransition = ((ISimulationState)state).ControlFlowStrategy.GetNextTransition(state,serviceFSM);
			else
				nextTransition = DefaultRandomStrategy.getInstance().GetNextTransition(state,serviceFSM);

			if (nextTransition == null) NotifyServiceReturned();
			currentElement = nextTransition;
		}

		/// <summary>
		/// called by the visitor, if the element to be visited is a transition. This method fires a visitor event from
		/// type TYPE_EXTERNALCALL to make the super visitor invoke this external call. The current element of this visitor
		/// is set to the state after this transition.
		/// </summary>
		/// <param name="transition">the transition</param>
		public void VisitITransition(ITransition transition)
		{
			IMatchable signature = transition.InputSymbol.ID;
			if (signature is IExternalSignature)
				NotifyExternalCall((IExternalSignature)signature);
			currentElement = transition.DestinationState;
		}

		/// <summary>
		/// called, if the visitor has to visit an unknown object. Override this methods in order to end the controlflow
		/// of this visitor in this case.
		/// </summary>
		/// <param name="o"></param>
		public override void VisitObject(object o)
		{
			currentElement = null;
			base.VisitObject(o);
		}


		#endregion
	}
}
//EOF