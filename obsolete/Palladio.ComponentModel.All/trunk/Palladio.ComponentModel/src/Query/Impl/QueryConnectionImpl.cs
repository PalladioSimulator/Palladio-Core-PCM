using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
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
	/// Revision 1.2  2005/06/17 18:33:10  joemal
	/// changes in the connection tables
	///
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

		//holds the requiring role of the connection
		private ModelDataSet.RolesRow  requiringRole;
		//holds the providing role of the connection
		private ModelDataSet.RolesRow  providingRole;

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
			return ComponentModelIdentifier.CreateComponentID(this.RequiringRole.fk_comp);
		}

		/// <summary>
		/// called to return the id of the interface on requires side of the connection
		/// </summary>
		/// <returns>the id of the interface</returns>
		public IInterfaceIdentifier GetRequiringInterface()
		{
			return ComponentModelIdentifier.CreateInterfaceID(this.RequiringRole.fk_iface);
		}

		/// <summary>
		/// call to return the id of the component on provides side of the connection
		/// </summary>
		/// <returns>the id of the component</returns>
		public IComponentIdentifier GetProvidingComponent()
		{
			return ComponentModelIdentifier.CreateComponentID(this.ProvidingRole.fk_comp);
		}

		/// <summary>
		/// called to return the id of the interface on provides side of the connection
		/// </summary>
		/// <returns>the id of the interface</returns>
		public IInterfaceIdentifier GetProvidingInterface()
		{
			return ComponentModelIdentifier.CreateInterfaceID(this.ProvidingRole.fk_iface);
		}

		#endregion

		#region private

		//returns the requiring role of the connection (lazy loading)
		private ModelDataSet.RolesRow RequiringRole
		{
			get
			{
				if (this.requiringRole == null)
					this.requiringRole = GetAssemblyConnectorRequiringRole();
				if (this.requiringRole == null)
					this.requiringRole = GetDelegationConnectorRequiringRole();

				return this.requiringRole;
			}
		}

		//returns the providing role of the connection (lazy loading)
		private ModelDataSet.RolesRow ProvidingRole
		{
			get
			{
				if (this.providingRole == null)
					this.providingRole = GetAssemblyConnectorProvidingRole();
				if (this.providingRole == null)
					this.providingRole = GetDelegationConnectorProvidingRole();

				return this.providingRole;
			}
		}

		//try to find the connection in the delegation connector table and returns its providing role
		private ModelDataSet.RolesRow GetDelegationConnectorProvidingRole()
		{
			ModelDataSet.DelegationConnectorsRow conRow = 
				this.Dataset.DelegationConnectors.FindByguid(this.connectionID.Key);

			if (conRow == null) return null;

			ModelDataSet.RolesRow innerRole = this.Dataset.Roles.FindByid(conRow.fk_inner_role);
			ModelDataSet.RolesRow outerRole = this.Dataset.Roles.FindByid(conRow.fk_outer_role);
            
			if (outerRole.type == (sbyte)InterfaceRole.PROVIDES)
				//we have a delegation on the provides side. The providing part is the inner components one
				return innerRole;
			else
				//we have a delegation on the requires side. The providing part is the outer components one
				return outerRole;
		}

		//try to find the connection in the delegation connector table and returns its requiring role
		private ModelDataSet.RolesRow GetDelegationConnectorRequiringRole()
		{
			ModelDataSet.DelegationConnectorsRow conRow = 
				this.Dataset.DelegationConnectors.FindByguid(this.connectionID.Key);

			if (conRow == null) return null;

			ModelDataSet.RolesRow innerRole = this.Dataset.Roles.FindByid(conRow.fk_inner_role);
			ModelDataSet.RolesRow outerRole = this.Dataset.Roles.FindByid(conRow.fk_outer_role);
            
			if (outerRole.type == (sbyte)InterfaceRole.PROVIDES)
				//we have a delegation on the provides side. The requiring part is the outer components one
				return outerRole;
			else
				//we have a delegation on the requires side. The requiring part is the inner components one
				return innerRole;
		}

		//try to find the connection in the assembly connector table and returns its providing role
		private ModelDataSet.RolesRow GetAssemblyConnectorProvidingRole()
		{
			ModelDataSet.AssemblyConnectorsRow conRow = 
				this.Dataset.AssemblyConnectors.FindByguid(this.connectionID.Key);
			if (conRow == null) return null;

			return this.Dataset.Roles.FindByid(conRow.fk_prov_role);
		}

		//try to find the connection in the assembly connector table and returns its requiring role
		private ModelDataSet.RolesRow GetAssemblyConnectorRequiringRole()
		{
			ModelDataSet.AssemblyConnectorsRow conRow = 
				this.Dataset.AssemblyConnectors.FindByguid(this.connectionID.Key);
			if (conRow == null) return null;

			return this.Dataset.Roles.FindByid(conRow.fk_req_role);
		}

		#endregion
	}
}
