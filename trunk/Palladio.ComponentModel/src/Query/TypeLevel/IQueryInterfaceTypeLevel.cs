using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Query.TypeLevel
{
	/// <summary>
	/// This interface defines several query methods to find the entities that are contained in and 
	/// belong to an interface.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/18 08:50:50  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IQueryInterfaceTypeLevel
	{
		#region properties

		/// <summary>
		/// called to return the interface used to query the entities of the component model
		/// </summary>
		IQueryEntities QueryEntities
		{
			get;
		}

		#endregion

		#region methods

		/// <summary>
		/// called to return an array with ids of the signatures that belong to the interface
		/// </summary>
		/// <returns>an array with signatures that belong to the interface</returns>
		ISignatureIdentifier GetSignatures();
		
		/// <summary>
		/// returns true, if the signature with given id exists and belongs to the interface
		/// </summary>
		/// <param name="signatureID">the id of the signature</param>
		/// <returns>true, if the signature belongs to the interface</returns>
		bool IsSignatureFromInterface(ISignatureIdentifier signatureID);

		/// <summary>
		/// called to return an array with ids of the protocols that belong to the interface
		/// </summary>
		/// <returns>an array with protocols that belong to the interface</returns>
		IProtocolIdentifier GetProtocols();
		
		/// <summary>
		/// returns true, if the protocol with given id exists and belongs to the interface
		/// </summary>
		/// <param name="protocolID">the id of the protocol</param>
		/// <returns>true, if the protocol belongs to the interface</returns>
		bool IsProtocolFromInterface(IProtocolIdentifier protocolID);

		#endregion
	}
}
