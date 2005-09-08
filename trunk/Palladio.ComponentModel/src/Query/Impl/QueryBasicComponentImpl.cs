using System.Collections;
using System.Data;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Query.TypeLevel;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Query.Impl
{
	/// <summary>
	/// This is the implementing class of the basic components query methods.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/09/08 18:22:17  joemal
	/// add new query methods ...
	///
	/// Revision 1.2  2005/09/06 15:01:05  joemal
	/// add query method for seffs
	///
	/// Revision 1.1  2005/07/30 15:43:15  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	internal class QueryBasicComponentImpl : QueryComponentImpl, IQueryBasicComponentTypeLevel
		//todo: add query methods of the other layers
	{
		#region constructor

		/// <summary>
		/// called to create the implementation of the query methods for composite components.
		/// </summary>
		/// <param name="dataset">the dataset</param>
		/// <param name="entities">the hashtable</param>
		/// <param name="compId">the component</param>
		/// <param name="query">the root implementation of the query tree</param>
		/// <exception cref="WrongComponentTypeException">thrown, if the id of the component is 
		/// not a composite component</exception>
		/// <exception cref="EntityNotFoundException">thrown if the component could not be found in the model.</exception>
		public QueryBasicComponentImpl(IComponentIdentifier compId, ModelDataSet dataset, EntityHashtable entities, IQuery query)
			: base(compId,dataset, entities, query)
		{
			if (((IComponent)entities[compId]).Type != ComponentType.BASIC)
				throw new WrongComponentTypeException(compId);
		}

		#endregion

		#region methods

		/// <summary>
		/// called to return an array with ids of the seffs that are contained in the bc
		/// </summary>
		/// <returns>an array with seff ids that belong to the bc</returns>
		public ISeffIdentifier[] GetServiceEffectSpecifications()
		{
			string query = "fk_comp = '"+this.componentID.Key+"' and type="+(byte)InterfaceRole.PROVIDES;
			DataRow[] resultRows = this.Dataset.Roles.Select(query);
			if (resultRows.Length==0) return new ISeffIdentifier[0];

			ArrayList results = new ArrayList();
			foreach (ModelDataSet.RolesRow rolesRow in resultRows)
			{
				query = "fk_role="+rolesRow.id;
				DataRow[] seffs = this.Dataset.Seffs.Select(query);
				foreach (ModelDataSet.SeffsRow seffsRow in seffs)
					results.Add(new InternalEntityIdentifier(seffsRow.guid));
			}

			return (ISeffIdentifier[]) results.ToArray(typeof(ISeffIdentifier));
		}

		/// <summary>
		/// called to query a seff from this basic component. The interface and signature must be specified. If no service
		/// effect specification can be found, null is returned. 
		/// </summary>
		/// <param name="ifaceId">the interface</param>
		/// <param name="sigId">the signature</param>
		/// <returns>the identifier of the service effect specification</returns>
		public ISeffIdentifier GetServiceEffectSpecification(IInterfaceIdentifier ifaceId, ISignatureIdentifier sigId)
		{
			ModelDataSet.RolesRow rolesRow=QueryRole(this.componentID,ifaceId,InterfaceRole.PROVIDES);
            if (rolesRow == null) return null;
			
			string query = "fk_role="+rolesRow.id+" and fk_signature='"+sigId.Key+"'";
			DataRow[] result = this.Dataset.Seffs.Select(query);
			if (result.Length==0) return null;

			return new InternalEntityIdentifier(((ModelDataSet.SeffsRow)result[0]).guid);
		}

		/// <summary>
		/// returns true, if the seff with given id exists and belongs to the bc
		/// </summary>
		/// <param name="seffID">the id of the seff</param>
		/// <returns>true, if the seff belongs to the bc</returns>
		public bool IsSeffFromBasicComponent(ISeffIdentifier seffID)
		{
			ModelDataSet.SeffsRow seffsRow=this.Dataset.Seffs.FindByguid(seffID.Key);
			if (seffsRow == null) return false;
			return seffsRow.RolesRow.fk_comp.Equals(this.componentID.Key);
		}

		/// <summary>
		/// called to return the identifier of the signature that belongs to the seff that belongs to 
		/// given seffId.
		/// </summary>
		/// <param name="seffId">the id of the service effect specification</param>
		/// <returns>the id of the signature</returns>
		public ISignatureIdentifier GetSignatureOfSeff(ISeffIdentifier seffId)
		{
			ModelDataSet.SeffsRow seffsRow=this.Dataset.Seffs.FindByguid(seffId.Key);
			if (seffsRow == null) return null;

			return new InternalEntityIdentifier(seffsRow.SignaturesRow.guid);
		}

		/// <summary>
		/// called to return the identifier of the interface that contains the signature of the seff 
		/// specified by given seffId.
		/// </summary>
		/// <param name="seffId">the id of the service effect specification</param>
		/// <returns>the id of the interface</returns>
		public ISignatureIdentifier GetInterfaceOfSeff(ISeffIdentifier seffId)
		{
			ModelDataSet.SeffsRow seffsRow=this.Dataset.Seffs.FindByguid(seffId.Key);
			if (seffsRow == null) return null;

			return new InternalEntityIdentifier(seffsRow.RolesRow.InterfacesRow.guid);
		}

		#endregion
	}
}
