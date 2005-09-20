using System;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.Query.Impl;
using Palladio.ComponentModel.Query.TypeLevel;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Query
{
	/// <summary>
	/// This factory returns the implementation for all entity specific query implementations in the type level.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/09/20 15:07:44  fst
	/// add new query for signatures
	///
	/// Revision 1.2  2005/07/30 15:43:48  joemal
	/// add basiccomponent queries (for seffs)
	///
	/// Revision 1.1  2005/04/19 16:47:13  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	internal class QueryTypeLevelFactory : IQueryTypeLevel
	{
		#region data

		//holds the dataset
		private ModelDataSet dataset;

		//holds the entities
		private EntityHashtable entities;

		//holds the implementation of all queries
		private IQuery query;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new implementation of the queries
		/// </summary>
		/// <param name="dataset">the dataset</param>
		/// <param name="entities">the hashtable with the entities</param>
		/// <param name="query">the root of the query tree</param>
		public QueryTypeLevelFactory(ModelDataSet dataset, EntityHashtable entities, IQuery query)
		{
			this.dataset = dataset;
			this.entities = entities;
			this.query = query;
		}

		#endregion

		#region public methods

		/// <summary>
		/// returns an interface that contains several methods to query entities that belong to the static view
		/// </summary>
		/// <returns>the interface</returns>
		public IQueryStaticViewTypeLevel QueryStaticView()
		{
			return new QueryStaticViewImpl(this.dataset,this.entities,this.query);
		}

		/// <summary>
		/// returns an interface that contains several methods to query entities and relations that belong 
		/// to a component.
		/// </summary>
		/// <param name="componentID">the id of the component</param>
		/// <returns>the interface</returns>
		/// <exception cref="EntityNotFoundException">thrown if the component could not be found in the model.</exception>
		public IQueryComponentTypeLevel QueryComponent(IComponentIdentifier componentID)
		{
			return new QueryComponentImpl(componentID,this.dataset,this.entities,this.query);
		}

		/// <summary>
		/// returns an interface that contains several methods to query entities and relations that belong 
		/// to a basic component.
		/// </summary>
		/// <param name="bcID">the id of the component</param>
		/// <returns>the interface</returns>
		/// <exception cref="EntityNotFoundException">thrown if the component could not be found in the model.</exception>
		public IQueryBasicComponentTypeLevel QueryBasicComponent(IComponentIdentifier bcID)
		{
			return new QueryBasicComponentImpl(bcID,this.dataset,this.entities,this.query);
		}

		/// <summary>
		/// returns an interface that contains several methods to query entities and relations that belong 
		/// to a composite component.
		/// </summary>
		/// <param name="ccID">the id of the component</param>
		/// <returns>the interface</returns>
		/// <exception cref="EntityNotFoundException">thrown if the component could not be found in the model.</exception>
		/// <exception cref="WrongComponentTypeException">thrown, if the id of the component is 
		/// not a composite component</exception>
		public IQueryCompositeComponentTypeLevel QueryCompositeComponent(IComponentIdentifier ccID)
		{
			return new QueryCompositeComponentImpl(ccID,this.dataset,this.entities,this.query);
		}

		/// <summary>
		/// returns an interface that contains several methods to query entities and relations that belong 
		/// to a connection.
		/// </summary>
		/// <param name="connectionID">the id of the connection</param>
		/// <returns>the interface</returns>
		/// <exception cref="EntityNotFoundException">thrown if the connection could not be found in the model.</exception>
		public IQueryConnectionTypeLevel QueryConnection(IConnectionIdentifier connectionID)
		{
			return new QueryConnectionImpl(connectionID,this.dataset,this.entities,this.query);
		}

		/// <summary>
		/// returns an interface that contains several methods to query entities and relations that belong 
		/// to an interface.
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>the queryinterface</returns>
		/// <exception cref="EntityNotFoundException">thrown if the interface could not be found in the model.</exception>
		public IQueryInterfaceTypeLevel QueryInterface(IInterfaceIdentifier ifaceID)
		{
			return new QueryInterfaceImpl(ifaceID, this.dataset,this.entities,this.query);
		}

		/// <summary>
		/// returns an interface that contains several methods to query entities and relations that belong 
		/// to a signature.
		/// </summary>
		/// <param name="sigId">the id of the signature</param>
		/// <returns>the query interface</returns>
		public IQuerySignatureTypeLevel QuerySignature(ISignatureIdentifier sigId)
		{
			return new QuerySignatureImpl(sigId,this.dataset,this.entities,this.query);
		}

		#endregion
	}
}
