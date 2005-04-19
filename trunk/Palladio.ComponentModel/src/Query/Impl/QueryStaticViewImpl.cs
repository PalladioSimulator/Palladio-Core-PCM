using System.Data;
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
	/// This is the implementing class of the static views query methods.
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
	internal class QueryStaticViewImpl : BasicQueryImpl,IQueryStaticViewTypeLevel
		//todo: add query methods of the other layers
	{
		#region constructor

		/// <summary>
		/// called to create the implementation of the query methods for the static view.
		/// </summary>
		/// <param name="dataset">the dataset</param>
		/// <param name="entities">the hashtable</param>
		/// <param name="query">the root implementation of the query tree</param>
		public QueryStaticViewImpl(ModelDataSet dataset, EntityHashtable entities, IQuery query)
			: base(dataset, entities, query)
		{
		}

		#endregion

		#region methods

		/// <summary>
		/// returns the ids of the components that are contained in this component.
		/// </summary>
		/// <returns>the ids of the components</returns>
		public IComponentIdentifier[] GetComponents()
		{
			string query = "parentComponent is null";
			DataRow[] compRows = this.Dataset.Components.Select(query);

			IComponentIdentifier[] compIds = new IComponentIdentifier[compRows.Length];

			for (int a=0;a<compRows.Length;a++)
				compIds[a] = ComponentModelIdentifier.CreateComponentID(((ModelDataSet.ComponentsRow)compRows[a]).guid);

			return compIds;
		}

		/// <summary>
		/// returns true, if the component that belongs to given id is part of this component
		/// </summary>
		/// <param name="compID">the id of the component</param>
		/// <returns>true, if the component that belongs to the given id is part of this component.</returns>
		public bool IsChildren(IComponentIdentifier compID)
		{
			ModelDataSet.ComponentsRow row = this.Dataset.Components.FindByguid(compID.Key);
			if (row == null) return false;
			return row.IsparentComponentNull();
		}

		/// <summary>
		/// returns the ids of the connections that are contained in this component.
		/// </summary>
		/// <returns>the ids of the connections</returns>
		public IConnectionIdentifier[] GetConnections()
		{
			string query = "fk_comp is null";
			DataRow[] conRows = this.Dataset.Connections.Select(query);

			IConnectionIdentifier[] conIds = new IConnectionIdentifier[conRows.Length];

			for (int a=0;a<conRows.Length;a++)
				conIds[a] = ComponentModelIdentifier.CreateConnectionID(((ModelDataSet.ConnectionsRow)conRows[a]).guid);

			return conIds;
		}

		/// <summary>
		/// returns true, if the connection that belongs to given id is part of this component.
		/// </summary>
		/// <param name="connectionID">the id of the connection</param>
		/// <returns>true, if the connection that belongs to given id is part of this component</returns>
		public bool IsConnectionFromComponent(IConnectionIdentifier connectionID)
		{
			ModelDataSet.ConnectionsRow row = this.Dataset.Connections.FindByguid(connectionID.Key);
			if (row == null) return false;
			return row.Isfk_compNull();
		}

		/// <summary>
		/// called to return the assembly connector that connects the two given components.
		/// </summary>
		/// <param name="reqCompID">the id of the requiring component</param>
		/// <param name="reqIFaceID">the id of the requires interface</param>
		/// <param name="provCompID">the id of the provides component</param>
		/// <param name="provIFaceID">the id of the provides interface</param>
		/// <returns>the id of the connection</returns>
		public IConnectionIdentifier GetAssemblyConnector(IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID)
		{
			ModelDataSet.RolesRow incomingRole = this.QueryRole(reqCompID,reqIFaceID,InterfaceRole.REQUIRES);
			if (incomingRole == null) return null;
			ModelDataSet.RolesRow outgoingRole = this.QueryRole(provCompID,provIFaceID,InterfaceRole.PROVIDES);
			if (outgoingRole == null) return null;

			string query = "incoming = "+incomingRole.id+" and outgoing = "+outgoingRole.id;
			DataRow[] result = this.Dataset.Connections.Select(query);
			if (result.Length==0) return null;
			return ComponentModelIdentifier.CreateConnectionID(((ModelDataSet.ConnectionsRow)result[0]).guid);
		}

		#endregion
	}
}
