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

		#endregion
	}
}
