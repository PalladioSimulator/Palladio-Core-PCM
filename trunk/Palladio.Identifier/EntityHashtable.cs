using System.Collections;

namespace Palladio.Identifier
{
	/// <summary>
	/// This is a hashtable that holds the entities of a model. 
	/// The entities identifiers string keys are used to find a stored entity.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/15 12:34:33  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class EntityHashtable
	{
		#region data

		//the hashtable that holds the entities
		private Hashtable hashTable = new Hashtable();

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new hashmaps for the entities of the model.
		/// </summary>
		public EntityHashtable()
		{
		}

		#endregion

		#region properties

		/// <summary>
		/// returns the entity that matchs to the given key, that matchs to the entites identifier
		/// </summary>
		public IIdentifiable this[string key]
		{
			get
			{
				return (IIdentifiable) hashTable[key];
			}
		}

		/// <summary>
		/// returns the entity that matchs to the given identifier
		/// </summary>
		public IIdentifiable this[IIdentifier identifier]
		{
			get
			{
				return (IIdentifiable) hashTable[identifier.Key];
			}
		}

		#endregion

		#region methods

		/// <summary>
		/// call to clear the whole table
		/// </summary>
		public void Clear()
		{
			hashTable.Clear();
		}

		/// <summary>
		/// call to add the given entity to the table.
		/// </summary>
		/// <param name="entity">the entity to be added</param>
		public void AddEntity(IIdentifiable entity)
		{
			hashTable.Add(entity.ID.Key,entity);
		}

		/// <summary>
		/// called to remove the entity that matchs to the given key.
		/// </summary>
		/// <param name="entityKey">the key of the entity that has to be removed</param>
		public void RemoveEntity(string entityKey)
		{
			hashTable.Remove(entityKey);
		}

		/// <summary>
		/// return an enumerator for all entities in the table.
		/// </summary>
		/// <returns>the enumerator</returns>
		public IEnumerator GetEnumerator()
		{
			return hashTable.GetEnumerator();
		}

		/// <summary>
		/// called to check whether the given key is present in the table.
		/// </summary>
		/// <param name="idKey">the searched key</param>
		/// <returns>true, if the given key is present in the table</returns>
		public bool ContainsKey(string idKey)
		{
			return hashTable.ContainsKey(idKey);
		}

		/// <summary>
		/// called to check whether the given identifiable entity is present in the table.
		/// </summary>
		/// <param name="entity">the searched entity</param>
		/// <returns>true, if the given identifiable entity is present in the table</returns>
		public bool Contains(IIdentifiable entity)
		{
			return hashTable.Contains(entity);
		}


		#endregion
	}
}
