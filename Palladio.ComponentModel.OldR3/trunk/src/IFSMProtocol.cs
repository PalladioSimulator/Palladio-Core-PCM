using System;
using System.Collections;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A ProtocolIModel is an extension of a SignatureListModel. In
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
	/// Revision 1.4  2004/05/24 15:20:44  sliver
	/// added cvs log
	///
	/// </pre>
	/// </remarks>
	public interface IFSMProtocol : ISignatureList  
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
	}
}
