using System.Data;
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

		#endregion

		#region constructor

		/// <summary>
		/// called to create a basic query implementation
		/// </summary>
		/// <param name="dataset">the dataset</param>
		/// <param name="hashtable">the hashtable</param>
		public BasicQueryImpl(ModelDataSet dataset, EntityHashtable hashtable)
		{
			this.dataset = dataset;
			this.entityHashtable = hashtable;
		}

		#endregion

		#region protected methods

		/// <summary>
		/// called to return the models entity with given identifier.
		/// </summary>
		/// <param name="entityId">the identifier</param>
		/// <returns>the entity or null if the entity could not be found</returns>
		protected IComponentModelEntity getModelEntity(IIdentifier entityId)
		{
			return (IComponentModelEntity) entityHashtable[entityId];
		}

		/// <summary>
		/// called to return the models entity with given identifier.
		/// </summary>
		/// <param name="entitykey">the key of the identifier</param>
		/// <returns>the entity or null if the entity could not be found</returns>
		protected IComponentModelEntity getModelEntity(string entitykey)
		{
			return (IComponentModelEntity) entityHashtable[entitykey];
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
			string query = "fk_comp = '"+compID.Key+"' and fk_iface ='"+ifaceID.Key+"' and type = "+role;
			result = dataset.Roles.Select(query);
			if (result == null) return null;

			return (ModelDataSet.RolesRow) result[0];
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

		#region protected properties

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

		#endregion
	}
}
