using System;
using ComponentNetworkSimulation.Structure.Elements;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure.Builder
{
	/// <summary>
	/// This class is the default implementation of the builder used to fill a service.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/06/22 12:17:19  joemal
	/// inital class creation
	///
	///
	/// 
	/// </pre>	
	/// </remarks>
	public class DefaultServiceBuilder : IServiceBuilder
	{
		#region data

		/// <summary>
		/// holds the editable fsm of the service
		/// </summary>
		private IEditableFiniteStateMachine fsm;

		/// <summary>
		/// holds the component that contains the service
		/// </summary>
		private IBasicComponent component;

		/// <summary>
		/// holds the elementfactory 
		/// </summary>
		private IElementFactory elementFactory;

		#endregion

		#region constructor

		/// <summary>
		/// constructs a new DefaultServiceBuilder 
		/// </summary>
		/// <param name="component">the component, that contains the service</param>
		/// <param name="fsmSeff">the FSM service effect, that has to be filled</param>
		/// <param name="factory">the factory, used to create the elements of the fsm</param>
		public DefaultServiceBuilder(IBasicComponent component, IFSMServiceEffect fsmSeff, IElementFactory factory)
		{
			this.component = component;
			this.fsm = fsmSeff.EditFSM;
			this.elementFactory = elementFactory;
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
			fsm.AddStates(newState);
		}

		/// <summary>
		/// set the state with the given id as startstate
		/// </summary>
		/// <param name="id">the id of the state</param>
		public void SetStartState(string id)
		{
			fsm.StartState = fsm.GetState(id);
		}

		/// <summary>
		/// set the given states as final states.
		/// </summary>
		/// <param name="ids">the ids of the states</param>
		public void SetFinalStates(params string[] ids)
		{
			IState[] finalState = new IState[ids.Length];
			for(int a=0;a<ids.Length;a++)
				finalState[a] = fsm.GetState(ids[a]);			
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

			ISignature[] sigs = ComponentFactory.CreateSignatureArray(signatureID.ToString());
			this.component.GetRequiresInterface(reqIFaceID).SignatureList.AddSignatures(sigs);

			fsm.AddTransition(sourceStateID,sigs[0],destStateID);
		}

		#endregion
	}
}
//EOF
