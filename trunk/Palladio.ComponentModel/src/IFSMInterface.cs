using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A IFSMInterface is an extension of a SignatureListModel. In
	/// addition to the list of services it describes the set of all possible
	/// call sequences of these services using a finite state machine 
	/// called protocol. The language accepted by the protocol
	/// represents the possible call sequences.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	///</pre>
	///</remarks>
	public interface IFSMInterface : IAttributable, IProtocolInformation
	{
		/// <summary>
		/// A Protocol describing
		/// the possible call sequences of the services.
		/// </summary>
		IFiniteStateMachine FSM
		{
			get;
		}

		/// <summary>
		/// A Protocol describing
		/// the possible call sequences of the services.
		/// </summary>
		IEditableFiniteStateMachine EditFSM
		{
			get;
		}
		
		/// <summary>
		/// Return the items which can be used as input alphabeth for the FSM
		/// </summary>
		ISignature[] Signatures 
		{
			get;
		}
		
	}
}
