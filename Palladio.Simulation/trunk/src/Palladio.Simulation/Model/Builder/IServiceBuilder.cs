using System;
using Palladio.Simulation.Model.Elements;
using Palladio.Identifier;

namespace Palladio.Simulation.Model.Builder
{
	/// <summary>
	/// This interface defines a builder for services, used to fill basic components.
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
	public interface IServiceBuilder
	{
		/// <summary>
		/// call to add a state to the fsm of the service.
		/// </summary>
		/// <param name="stateParams">the parameters for the state</param>
		void AddState(ISimulationStateParams stateParams);

		/// <summary>
		/// set the state with the given id as startstate
		/// </summary>
		/// <param name="id">the id of the state</param>
		void SetStartState(string id);

		/// <summary>
		/// set the given states as final states.
		/// </summary>
		/// <param name="ids">the ids of the states</param>
		void SetFinalStates(params string[] ids);
        
		/// <summary>
		/// call to add a transition between two state in the fsm. The state are defined by 
		/// given stateids. A signature with given id is added to one of the requires interface of the basic component.
		/// </summary>
		/// <param name="sourceStateID">the id of the source state</param>
		/// <param name="signatureID">
		/// the id of the signature, created in the requires interfaces defined by reqIFaceID.</param>
		/// <param name="reqIFaceID">the id of the interface, where the signature has to be created.</param>
		/// <param name="destStateID">the id of the destination state</param>
		void AddTransition(string sourceStateID,IIdentifier signatureID, IIdentifier reqIFaceID, string destStateID);
 
		/// <summary>
		/// this method is called, when the simulation wants to reset the architecture. The implementing builder
		/// should reset all contained timeconsumers.
		/// </summary>
		void Reset();
	}
}
//EOF