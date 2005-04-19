using System.Data;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.Query;
using Palladio.ComponentModel.Query.Impl;
using Palladio.ComponentModel.Query.TypeLevel;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Query.Impl
{
	/// <summary>
	/// This is the implementing class of the interfaces query methods
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/19 16:47:13  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	internal class QueryInterfaceImpl : BasicQueryImpl,IQueryInterfaceTypeLevel
		//todo: add query methods of the other layers
	{
		#region data

		//holds the id of the interface
		private IInterfaceIdentifier ifaceID;

		#endregion

		#region constructor

		/// <summary>
		/// called to create the implementation of the query methods for interfaces.
		/// </summary>
		/// <param name="dataset">the dataset</param>
		/// <param name="entities">the hashtable</param>
		/// <param name="ifaceID">the interface</param>
		/// <param name="query">the root implementation of the query tree</param>
		/// <exception cref="EntityNotFoundException">thrown if the entity could not be found in the model.</exception>
		public QueryInterfaceImpl(IInterfaceIdentifier ifaceID, ModelDataSet dataset, EntityHashtable entities, IQuery query)
			: base(dataset, entities, query)
		{
			CheckEntityExists(ifaceID);
			this.ifaceID = ifaceID;
		}

		#endregion

		#region methods

		/// <summary>
		/// called to return an array with ids of the signatures that belong to the interface
		/// </summary>
		/// <returns>an array with signatures that belong to the interface</returns>
		public ISignatureIdentifier[] GetSignatures()
		{
			DataRow[] resultRows = this.Dataset.Signatures.Select("fk_iface = '"+this.ifaceID.Key+"'");
			if (resultRows == null) return new ISignatureIdentifier[0];

			ISignatureIdentifier[] results = new ISignatureIdentifier[resultRows.Length];
			for (int a=0;a<resultRows.Length;a++)
                results[a] = ComponentModelIdentifier.CreateSignatureID(((ModelDataSet.SignaturesRow)resultRows[a]).guid);

			return results;
		}

		/// <summary>
		/// returns true, if the signature with given id exists and belongs to the interface
		/// </summary>
		/// <param name="signatureID">the id of the signature</param>
		/// <returns>true, if the signature belongs to the interface</returns>
		public bool IsSignatureFromInterface(ISignatureIdentifier signatureID)
		{
			ModelDataSet.SignaturesRow sigRow = this.Dataset.Signatures.FindByguid(signatureID.Key);
			if (sigRow == null) return false;
			return sigRow.fk_iface.Equals(ifaceID.Key);
		}

		/// <summary>
		/// called to return an array with ids of the protocols that belong to the interface
		/// </summary>
		/// <returns>an array with protocols that belong to the interface</returns>
		public IProtocolIdentifier[] GetProtocols()
		{
			DataRow[] resultRows = this.Dataset.Protocols.Select("fk_iface = '"+this.ifaceID.Key+"'");
			if (resultRows == null) return new IProtocolIdentifier[0];

			IProtocolIdentifier[] results = new IProtocolIdentifier[resultRows.Length];
			for (int a=0;a<resultRows.Length;a++)
				results[a] = ComponentModelIdentifier.CreateProtocolID(((ModelDataSet.ProtocolsRow)resultRows[a]).guid);

			return results;
		}

		/// <summary>
		/// returns true, if the protocol with given id exists and belongs to the interface
		/// </summary>
		/// <param name="protocolID">the id of the protocol</param>
		/// <returns>true, if the protocol belongs to the interface</returns>
		public bool IsProtocolFromInterface(IProtocolIdentifier protocolID)
		{
			ModelDataSet.ProtocolsRow proRow = this.Dataset.Protocols.FindByguid(protocolID.Key);
			if (proRow == null) return false;
			return proRow.fk_iface.Equals(ifaceID.Key);
		}

		#endregion
	}
}
