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
