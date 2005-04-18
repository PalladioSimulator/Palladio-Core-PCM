using System;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.Query.TypeLevel;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Query.Impl
{
	/// <summary>
	/// This is the implementing class of the query interfaces.
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
	internal class ModelQueryManager : IQuery
	{
		#region data

		//holds the implementation of the query entities interface
		private IQueryEntities queryEntities;

		//holds the implementation of the query typelevel interface
		private IQueryTypeLevel queryTypeLevel;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new model query manager
		/// </summary>
		/// <param name="dataset">the dataset of the model</param>
		/// <param name="entityHashtable">the hashtable that holds the entities</param>
		internal ModelQueryManager(ModelDataSet dataset, EntityHashtable entityHashtable)
		{
			this.queryEntities = new QueryEntitiesImpl(dataset,entityHashtable);
			this.queryTypeLevel = null;//new QueryImpl(dataset,entityHashtable);
		}

		#endregion

		/// <summary>
		/// returns an interface that contains several methods to query all entities of the componentmodel
		/// </summary>
		public IQueryEntities QueryEntities
		{
			get
			{
				return queryEntities;
			}
		}

		/// <summary>
		/// returns an interface that contains several methods to query the model in type level
		/// </summary>
		public IQueryTypeLevel QueryTypeLevel
		{
			get 
			{
				return this.queryTypeLevel;
			}
		}
	}
}
