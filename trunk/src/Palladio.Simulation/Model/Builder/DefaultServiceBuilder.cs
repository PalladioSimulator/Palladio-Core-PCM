using System;
using Palladio.Simulation.Model.Elements;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;

namespace Palladio.Simulation.Model.Builder
{
	/// <summary>
	/// This class is the default implementation of the builder used to fill a service.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>	
	/// </remarks>
	internal class DefaultServiceBuilder : IServiceBuilder
	{
		#region data

		/// <summary>
		/// holds the editable fsm of the service
		/// </summary>
		private IServiceEffectSpecification serviceEffectSpecification;

		/// <summary>
		/// holds the component that contains the service
		/// </summary>
		private IBasicComponent component;

		/// <summary>
		/// holds the elementfactory 
		/// </summary>
		private IElementFactory elementFactory;

		/// <summary>
		/// holds the observer for this service
		/// </summary>
		private IServiceObserver observer;

		#endregion

		#region properties

		/// <summary>
		/// call to extract the editable fsm from service effect
		/// </summary>
		protected IEditableFiniteStateMachine FSM
		{
			get
			{
				return FSMServiceEffect.EditFSM;
			}
		}

		/// <summary>
		/// call to extract the service effect from effect specification
		/// </summary>
		protected IFSMServiceEffect FSMServiceEffect
		{
			get
			{
				return (IFSMServiceEffect)this.serviceEffectSpecification.GetAuxiliarySpecification(typeof(IFSMServiceEffect));
			}
		}

		#endregion

		#region constructor

		/// <summary>
		/// constructs a new DefaultServiceBuilder 
		/// </summary>
		/// <param name="component">the component, that contains the service</param>
		/// <param name="seff">the FSM service effect, that has to be filled</param>
		/// <param name="factory">the factory, used to create the elements of the fsm</param>
		/// <param name="observer">
		/// The observer for the service. If no observer is needed, this parameter may be null.
		/// </param>
		public DefaultServiceBuilder(IBasicComponent component, IServiceEffectSpecification seff, IElementFactory factory,
			IServiceObserver observer)
		{
			this.component = component;
			this.serviceEffectSpecification = seff;
			this.elementFactory = factory;
			this.observer = observer;
		}

		#endregion

		#region methods

		/// <summary>
		/// call to add a state to the fsm of the service.
		/// </summary>
		/// <param name="stateParams">the parameters for the state</param>
		public void AddState(ISimulationStateParams stateParams)
		{
			ISimulationState newState = elementFactory.CreateState(stateParams);
			FSM.AddStates(newState);

			if (this.observer != null) 
			{
				IExternalSignature extSig = serviceEffectSpecification.SignatureList[0];
				observer.OnStateAdded(extSig.RoleID,extSig.Signature.ID,stateParams);
			}
		}

		/// <summary>
		/// set the state with the given id as startstate
		/// </summary>
		/// <param name="id">the id of the state</param>
		public void SetStartState(string id)
		{
			FSM.StartState = FSM.GetState(id);
			if (this.observer != null) 
			{
				IExternalSignature extSig = serviceEffectSpecification.SignatureList[0];
				observer.OnStartStateSet(extSig.RoleID,extSig.Signature.ID,id);
			}
		}

		/// <summary>
		/// set the given states as final states.
		/// </summary>
		/// <param name="ids">the ids of the states</param>
		public void SetFinalStates(params string[] ids)
		{
			IState[] finalState = new IState[ids.Length];
			for(int a=0;a<ids.Length;a++)
				finalState[a] = FSM.GetState(ids[a]);			
			
			if (this.observer != null) 
			{
				IExternalSignature extSig = serviceEffectSpecification.SignatureList[0];
				observer.OnFinalStatesSet(extSig.RoleID,extSig.Signature.ID,ids);
			}
		}

		/// <summary>
		/// call to add a transition between two state in the fsm. The state are defined by 
		/// given stateids. A signature with given id is added to one of the requires interface of the basic component.
		/// </summary>
		/// <param name="sourceStateID">the id of the source state</param>
		/// <param name="signatureID">
		/// the id of the signature, created in the requires interfaces defined by reqIFaceID.</param>
		/// <param name="reqIFaceID">the id of the interface, where the signature has to be created.</param>
		/// <param name="destStateID">the id of the destination state</param>
		public void AddTransition(string sourceStateID, IIdentifier signatureID, IIdentifier reqIFaceID, string destStateID)
		{
			if (!this.component.HasRequiresInterface(reqIFaceID)) 
				this.component.AddRequiresInterface(reqIFaceID,ComponentFactory.CreateInterfaceModel());

			ISignature sig = ComponentFactory.CreateSignature(signatureID.ToString());
			this.component.GetRequiresInterface(reqIFaceID).SignatureList.AddSignatures(sig);

			IExternalSignature extSig = ComponentFactory.CreateExternalSignature(reqIFaceID,sig);

			serviceEffectSpecification.SignatureList.AddSignatures(extSig);
            
			FSM.AddTransition(sourceStateID,extSig,destStateID);

			if (this.observer != null) 
			{
				IExternalSignature exSig = serviceEffectSpecification.SignatureList[0];
				observer.OnTransitionAdded(exSig.RoleID,exSig.Signature.ID,sourceStateID,signatureID,reqIFaceID,destStateID);
			}
		}

		/// <summary>
		/// this method is called, when the simulation wants to reset the architecture. 
		/// All states in the fsm of this service are reseted.
		/// </summary>
		public void Reset()
		{
			foreach(IState state in this.FSM.States)
				if (state is ITimeConsumer) ((ITimeConsumer)state).Reset();
		}

		#endregion
	}
}
//EOF
