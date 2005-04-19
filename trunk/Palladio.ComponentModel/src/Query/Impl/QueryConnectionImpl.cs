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
	/// This is the implementing class of the connections query methods
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
	internal class QueryConnectionImpl : BasicQueryImpl,IQueryConnectionTypeLevel
		//todo: add query methods of the other layers
	{
		#region data

		//holds the id of the connection
		private IConnectionIdentifier connectionID;

		#endregion

		#region constructor

		/// <summary>
		/// called to create the implementation of the query methods for connections.
		/// </summary>
		/// <param name="dataset">the dataset</param>
		/// <param name="entities">the hashtable</param>
		/// <param name="conId">the connection</param>
		/// <param name="query">the root implementation of the query tree</param>
		/// <exception cref="EntityNotFoundException">thrown if the connection could not be found in the model.</exception>
		public QueryConnectionImpl(IConnectionIdentifier conId, ModelDataSet dataset, EntityHashtable entities, IQuery query)
			: base(dataset, entities, query)
		{
			this.CheckEntityExists(conId);
			this.connectionID = conId;
		}

		#endregion

		#region methods

		/// <summary>
		/// returns the query interface to the interface with given id.
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>the query interface</returns>
		/// <exception cref="EntityNotFoundException">thrown if the interface could not be found in the model.</exception>
		public IQueryInterfaceTypeLevel QueryInterfaceTypeLevel(IInterfaceIdentifier ifaceID)
		{
			return this.Query.QueryTypeLevel.QueryInterface(ifaceID);
		}

		/// <summary>
		/// returns the query interface to the component with given id.
		/// </summary>
		/// <param name="componentID">the id of the component</param>
		/// <returns>the query interface</returns>
		/// <exception cref="EntityNotFoundException">thrown if the component could not be found in the model.</exception>
		public IQueryComponentTypeLevel QueryComponentTypeLevel(IComponentIdentifier componentID)
		{
			return this.Query.QueryTypeLevel.QueryComponent(componentID);
		}

		/// <summary>
		/// call to return the id of the component on requires side of the connection
		/// </summary>
		/// <returns>the id of the component</returns>
		public IComponentIdentifier GetRequiringComponent()
		{
			long rolesID = this.Dataset.Connections.FindByguid(this.connectionID.Key).incoming;
			string compGuid = this.Dataset.Roles.FindByid(rolesID).fk_comp;
			return ComponentModelIdentifier.CreateComponentID(compGuid);
		}

		/// <summary>
		/// called to return the id of the interface on requires side of the connection
		/// </summary>
		/// <returns>the id of the interface</returns>
		public IInterfaceIdentifier GetRequiringInterface()
		{
			long rolesID = this.Dataset.Connections.FindByguid(this.connectionID.Key).incoming;
			string ifaceGuid = this.Dataset.Roles.FindByid(rolesID).fk_iface;
			return ComponentModelIdentifier.CreateInterfaceID(ifaceGuid);
		}

		/// <summary>
		/// call to return the id of the component on provides side of the connection
		/// </summary>
		/// <returns>the id of the component</returns>
		public IComponentIdentifier GetProvidingComponent()
		{
			long rolesID = this.Dataset.Connections.FindByguid(this.connectionID.Key).outgoing;
			string compGuid = this.Dataset.Roles.FindByid(rolesID).fk_comp;
			return ComponentModelIdentifier.CreateComponentID(compGuid);
		}

		/// <summary>
		/// called to return the id of the interface on provides side of the connection
		/// </summary>
		/// <returns>the id of the interface</returns>
		public IInterfaceIdentifier GetProvidingInterface()
		{
			long rolesID = this.Dataset.Connections.FindByguid(this.connectionID.Key).outgoing;
			string ifaceGuid = this.Dataset.Roles.FindByid(rolesID).fk_iface;
			return ComponentModelIdentifier.CreateInterfaceID(ifaceGuid);
		}

		#endregion
	}
}
