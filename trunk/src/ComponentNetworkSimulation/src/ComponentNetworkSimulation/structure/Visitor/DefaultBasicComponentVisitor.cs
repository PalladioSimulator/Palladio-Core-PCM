using System;
using ComponentNetworkSimulation.Structure.Elements;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure.Visitor
{
	/// <summary>
	/// This class is the default visitor for basic components in this framework. It walks through the service effect fsm of 
	/// its component, identified by the given signature.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/06/18 17:20:13  joemal
	/// initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DefaultBasicComponentVisitor : AbstractComponentVisitor
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
		/// constructs a new <code>DefaultBasicComponentVisitor</code> from the given basic component and signature.
		/// </summary>
		/// <param name="component">the component to be visited</param>
		/// <param name="signature">the signature</param>
		public DefaultBasicComponentVisitor(IBasicComponent component, IExternalSignature signature):base(component)
		{
			IServiceEffectSpecification seff = component.GetServiceEffectSpecification(signature);
			IFSMServiceEffect serviceEffect = (IFSMServiceEffect)seff.GetAuxiliarySpecification(typeof(IFSMServiceEffect));
			this.serviceFSM = serviceEffect.FSM;
			this.currentElement = serviceFSM.StartState;
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

		#endregion
	}
}
//EOF