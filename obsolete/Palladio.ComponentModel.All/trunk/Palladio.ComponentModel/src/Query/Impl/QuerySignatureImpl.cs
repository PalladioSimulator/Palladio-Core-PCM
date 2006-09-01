using System;
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
	/// This is the implementing class of the signature query methods
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/09/20 15:10:11  fst
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class QuerySignatureImpl : BasicQueryImpl,IQuerySignatureTypeLevel
	{
		#region data

		//holds the id of the signature
		private ISignatureIdentifier sigID;

		#endregion

		#region constructor

		/// <summary>
		/// called to create the implementation of the query methods for signatures.
		/// </summary>
		/// <param name="dataset">the dataset</param>
		/// <param name="entities">the hashtable</param>
		/// <param name="sigID">the signature</param>
		/// <param name="query">the root implementation of the query tree</param>
		/// <exception cref="EntityNotFoundException">thrown if the entity could not be found in the model.</exception>
		public QuerySignatureImpl(ISignatureIdentifier sigID, ModelDataSet dataset, EntityHashtable entities, IQuery query)
			: base(dataset, entities, query)
		{
			CheckEntityExists(sigID);
			this.sigID = sigID;
		}

		#endregion

		#region methods

		/// <summary>
		/// called to return the id of the interface that belongs to this queries signature.
		/// </summary>
		/// <returns>the id of the interface</returns>
		public IInterfaceIdentifier GetInterface()
		{
			ModelDataSet.SignaturesRow result = this.Dataset.Signatures.FindByguid(sigID.Key);
			return new InternalEntityIdentifier(result.fk_iface);
		}

		#endregion

	}
}
