using System;
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
	/// This is the implementing class of the composite components query methods.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2005/06/12 17:07:31  joemal
	/// renamed from QueryEntity to QueryRepository
	///
	/// Revision 1.4  2005/06/05 10:40:19  joemal
	/// - components now can be added to more than one container
	///
	/// Revision 1.3  2005/05/08 17:23:40  joemal
	/// fix a bug
	///
	/// Revision 1.2  2005/05/08 12:04:23  joemal
	/// implementation of xml serialization
	///
	/// Revision 1.1  2005/04/19 16:47:13  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	internal class QueryCompositeComponentImpl : QueryComponentImpl,IQueryCompositeComponentTypeLevel
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
		public QueryCompositeComponentImpl(IComponentIdentifier compId, ModelDataSet dataset, EntityHashtable entities, IQuery query)
			: base(compId,dataset, entities, query)
		{
			if (((IComponent)entities[compId]).Type != ComponentType.COMPOSITE)
				throw new WrongComponentTypeException(compId);
		}

		#endregion

		#region methods

		/// <summary>
		/// returns the ids of the components that are contained in this component.
		/// </summary>
		/// <returns>the ids of the components</returns>
		public IComponentIdentifier[] GetComponents()
		{
			return this.QueryComponents();
		}

		/// <summary>
		/// returns true, if the component that belongs to given id is part of this component
		/// </summary>
		/// <param name="compID">the id of the component</param>
		/// <returns>true, if the component that belongs to the given id is part of this component.</returns>
		public bool IsChild(IComponentIdentifier compID)
		{
			string query = "fk_parent = '"+this.componentID.Key+"' and fk_child = '"+compID.Key+"'";
			return (this.Dataset.CompRelations.Select(query).Length != 0);
		}

		/// <summary>
		/// returns the ids of the connections that are contained in this component.
		/// </summary>
		/// <returns>the ids of the connections</returns>
		public IConnectionIdentifier[] GetConnections()
		{
			string query = "fk_comp = '"+this.componentID.Key+"'";
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
			return row.fk_comp.Equals(this.componentID.Key);
		}

		/// <summary>
		/// returns the identifier of the provides delegation that connects this components interface with
		/// the inner components interface.
		/// </summary>
		/// <param name="outerIfaceID">the id of this components provides interface</param>
		/// <param name="innerCompID">the id the inner component</param>
		/// <param name="innerIfaceID">the id of the inner components provides interface</param>
		/// <returns>the id of the connection</returns>
		public IConnectionIdentifier GetProvidesDelegationConnector(IInterfaceIdentifier outerIfaceID, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIfaceID)
		{
			ModelDataSet.RolesRow incomingRole = this.QueryRole(this.componentID,outerIfaceID,InterfaceRole.PROVIDES);
			if (incomingRole == null) return null;
			ModelDataSet.RolesRow outgoingRole = this.QueryRole(innerCompID,innerIfaceID,InterfaceRole.PROVIDES);
			if (outgoingRole == null) return null;

			string query = "incoming = "+incomingRole.id+" and outgoing = "+outgoingRole.id;
			DataRow[] result = this.Dataset.Connections.Select(query);
			if (result.Length==0) return null;
			return ComponentModelIdentifier.CreateConnectionID(((ModelDataSet.ConnectionsRow)result[0]).guid);
		}

		/// <summary>
		/// returns the identifier of the requires delegation that connects this components interface with
		/// the inner components interface.
		/// </summary>
		/// <param name="outerIfaceID">the id of this components requires interface</param>
		/// <param name="innerCompID">the id the inner component</param>
		/// <param name="innerIfaceID">the id of the inner components requires interface</param>
		/// <returns>the id of the connection</returns>
		public IConnectionIdentifier GetRequiresDelegationConnector(IInterfaceIdentifier outerIfaceID, 
			IComponentIdentifier innerCompID, IInterfaceIdentifier innerIfaceID)
		{
			ModelDataSet.RolesRow outgoingRole = this.QueryRole(this.componentID,outerIfaceID,InterfaceRole.REQUIRES);
			if (outgoingRole == null) return null;
			ModelDataSet.RolesRow incomingRole = this.QueryRole(innerCompID,innerIfaceID,InterfaceRole.REQUIRES);
			if (incomingRole == null) return null;

			string query = "incoming = "+incomingRole.id+" and outgoing = "+outgoingRole.id;
			DataRow[] result = this.Dataset.Connections.Select(query);
			if (result.Length==0) return null;
			return ComponentModelIdentifier.CreateConnectionID(((ModelDataSet.ConnectionsRow)result[0]).guid);
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

		/// <summary>
		/// returns the ids of all basic components that are contained in this composite component
		/// </summary>
		/// <returns>the ids</returns>
		public IComponentIdentifier[] GetBasicComponents()
		{
			return this.QueryComponents(ComponentType.BASIC);
		}

		/// <summary>
		/// returns the ids of all composite components that are contained in this composite component
		/// </summary>
		/// <returns>the ids</returns>
		public IComponentIdentifier[] GetCompositeComponents()
		{
			return this.QueryComponents(ComponentType.COMPOSITE);
		}

		//called to query the components of the static view
		private IComponentIdentifier[] QueryComponents()
		{
			string query = "fk_parent='"+this.componentID.Key+"'";
			DataRow[] compRows = this.Dataset.CompRelations.Select(query);
			
			IComponentIdentifier[] compIds = new IComponentIdentifier[compRows.Length];
	
			for (int a=0;a<compRows.Length;a++)
				compIds[a] = ComponentModelIdentifier.CreateComponentID(((ModelDataSet.CompRelationsRow)compRows[a]).fk_child);
			
			return compIds;
		}

		//called to query the components of the static view
		private IComponentIdentifier[] QueryComponents(ComponentType type)
		{
			IComponentIdentifier[] compIDs = QueryComponents();
			ArrayList bcIDs = new ArrayList(compIDs.Length);
			foreach(IComponentIdentifier compID in compIDs)
				if (this.QueryRepository.GetComponent(compID).Type == type)
					bcIDs.Add(compID);

			return (IComponentIdentifier[]) bcIDs.ToArray(typeof(IComponentIdentifier));
		}

		#endregion
	}
}
