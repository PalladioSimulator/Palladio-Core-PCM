using System.Data;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Query.Impl
{
	/// <summary>
	/// This is the base class of all classes that support querys to the component model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.8  2005/07/29 16:02:57  joemal
	/// now service effect specifications can be added ...
	///
	/// Revision 1.7  2005/06/25 16:54:44  joemal
	/// some more queries are need for the xml serlialization
	///
	/// Revision 1.6  2005/06/17 18:33:10  joemal
	/// changes in the connection tables
	///
	/// Revision 1.5  2005/06/12 17:07:31  joemal
	/// renamed from QueryEntity to QueryRepository
	///
	/// Revision 1.4  2005/04/19 16:47:41  joemal
	/// implement query methods
	///
	/// Revision 1.3  2005/04/18 17:46:13  joemal
	/// implement query methods
	///
	/// Revision 1.2  2005/04/18 09:45:21  joemal
	/// implement query methods
	///
	/// Revision 1.1  2005/04/18 08:50:50  joemal
	/// initial creation
	///
	/// Revision 1.1  2005/04/10 15:33:48  joemal
	/// initial class creation
	///
	///
	/// </pre>
	/// </remarks>
	internal class BasicQueryImpl
	{
		#region data

		//holds the dataset of the model
		private ModelDataSet dataset;

		//holds the entities of the model
		private EntityHashtable entityHashtable;

		//holds the interface of all queries to create cross reference to other query interfaces
		private IQuery query;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a basic query implementation
		/// </summary>
		/// <param name="dataset">the dataset</param>
		/// <param name="hashtable">the hashtable</param>
		/// <param name="query">the basic query implementation</param>
		public BasicQueryImpl(ModelDataSet dataset, EntityHashtable hashtable, IQuery query)
		{
			this.dataset = dataset;
			this.entityHashtable = hashtable;
			this.query = query;
		}

		#endregion

		#region protected methods

		/// <summary>
		/// called to return the models entity with given identifier.
		/// </summary>
		/// <param name="entityId">the identifier</param>
		/// <returns>the entity or null if the entity could not be found</returns>
		protected IIdentifiable getModelEntity(IIdentifier entityId)
		{
			return entityHashtable[entityId];
		}

		/// <summary>
		/// called to return the models entity with given identifier.
		/// </summary>
		/// <param name="entitykey">the key of the identifier</param>
		/// <returns>the entity or null if the entity could not be found</returns>
		protected IIdentifiable getModelEntity(string entitykey)
		{
			return entityHashtable[entitykey];
		}

		/// <summary>
		/// called to query a role from dataset
		/// </summary>
		/// <param name="compID">the id of the component</param>
		/// <param name="ifaceID">the id of the interface</param>
		/// <param name="role">the role of the interface in the component</param>
		/// <returns>the row of the roles table</returns>
		protected ModelDataSet.RolesRow QueryRole(IComponentIdentifier compID, IInterfaceIdentifier ifaceID, InterfaceRole role)
		{
			DataRow[] result = null;			
			string query = "fk_comp = '"+compID.Key+"' and fk_iface ='"+ifaceID.Key+"' and type = "+(byte)role;
			result = dataset.Roles.Select(query);

			if (result.Length == 0) return null;

			return (ModelDataSet.RolesRow) result[0];
		}

		/// <summary>
		/// called to check whether an entity exits in the componentmodel. If it doesn't exits, an EntityNotFoundException is
		/// thrown 
		/// </summary>
		/// <param name="entityID">the entity</param>
		/// <exception cref="EntityNotFoundException">thrown if the given entity doesn't exists in the cm</exception>
		protected void CheckEntityExists(IIdentifier entityID)
		{
			if (!this.ContainsEntity(entityID))
				throw new EntityNotFoundException(entityID);
		}

		#endregion

		#region protected properties

		/// <summary>
		/// called to return the component relation row between two component if present
		/// </summary>
		/// <returns>the row of the component relation table</returns>
		protected ModelDataSet.CompRelationsRow QueryParent(IComponentIdentifier parentComponentID, 
			IComponentIdentifier childComponentID)
		{
            string query = "fk_parent='"+parentComponentID.Key+"' and fk_child";
			if (parentComponentID == null)
				query += " is null";
			else
				query += "='"+childComponentID.Key+"'";
			DataRow[] result = this.Dataset.CompRelations.Select(query);
			if (result.Length == 0) return null;
			return (ModelDataSet.CompRelationsRow) result[0];
		}

		/// <summary>
		/// called to return the dataset of the model
		/// </summary>
		protected ModelDataSet Dataset
		{
			get
			{
				return dataset;
			}
		}

		/// <summary>
		/// called to return the implementation of the all query methods of the componentmodel. 
		/// This property can be used to create cross references to other query implemenations.
		/// </summary>
		protected IQuery Query
		{
			get
			{
				return this.query;
			}
		}

		/// <summary>
		/// called to return the refenence to the hashtable that holds the entities of the componentmodel
		/// </summary>
		protected EntityHashtable Entities
		{
			get
			{
				return this.entityHashtable;
			}
		}

		#endregion

		#region public methods

		/// <summary>
		/// returns true, if an entity with given id exists in the componentmodel.
		/// </summary>
		/// <param name="entityIdentifier">the id of entity</param>
		/// <returns>true, if the entity exists in the componentmodel</returns>
		public bool ContainsEntity(IIdentifier entityIdentifier)
		{
			return this.entityHashtable.ContainsKey(entityIdentifier.Key);
		}

		#endregion

		#region public properties

		/// <summary>
		/// called to return the interface that is used to query the entities of the model
		/// </summary>
		public IQueryRepository QueryRepository
		{
			get
			{
				return this.query.QueryRepository;
			}
		}

		#endregion
	}
}
