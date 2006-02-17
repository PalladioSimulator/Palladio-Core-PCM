using System;
using Palladio.Identifier;
using Palladio.Simulation.Model.Elements;

namespace Palladio.Simulation.Model.Builder
{
	/// <summary>
	/// This interface defines a observer for servicebuilders. Implementing classes are notified, when state or transitions
	/// are added to the service, or when the startstate or the finalstates are set.
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
	public interface IServiceObserver
	{
		/// <summary>
		/// called, when a state was added to the observing service.
		/// </summary>
		/// <param name="iFaceID">the id of the iface, to which the signature of the service belongs</param>
		/// <param name="signatureID">the id of the services signature</param>
		/// <param name="stateParams">the parameters for the state</param>
		void OnStateAdded(IIdentifier iFaceID, IIdentifier signatureID, ISimulationStateParams stateParams);

		/// <summary>
		/// called, when the startstate was set in the observing service.  
		/// </summary>
 		/// <param name="iFaceID">the id of the iface, to which the signature of the service belongs</param>
		/// <param name="signatureID">the id of the services signature</param>
		/// <param name="id">the id of the state</param>
		void OnStartStateSet(IIdentifier iFaceID, IIdentifier signatureID,string id);

		/// <summary>
		/// called, when the finalstates were set in the observing service. 
		/// </summary>
		/// <param name="iFaceID">the id of the iface, to which the signature of the service belongs</param>
		/// <param name="signatureID">the id of the services signature</param>
		/// <param name="ids">the ids of the states</param>
		void OnFinalStatesSet(IIdentifier iFaceID, IIdentifier signatureID,string[] ids);
        
		/// <summary>
		/// called, when  a transition was added to the observing service.
		/// </summary>
 		/// <param name="iFaceID">the id of the iface, to which the signature of the service belongs</param>
		/// <param name="signatureID">the id of the services signature</param>
		/// <param name="sourceStateID">the id of the source state</param>
		/// <param name="extSigID">
		/// the id of the signature, created in the requires interfaces defined by reqIFaceID.</param>
		/// <param name="reqIFaceID">the id of the interface, where the signature has to be created.</param>
		/// <param name="destStateID">the id of the destination state</param>
		void OnTransitionAdded(IIdentifier iFaceID, IIdentifier signatureID,string sourceStateID,
			IIdentifier extSigID, IIdentifier reqIFaceID, string destStateID);		
	}
}
//EOF