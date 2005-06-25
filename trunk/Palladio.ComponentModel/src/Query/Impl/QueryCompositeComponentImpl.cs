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
	/// Revision 1.7  2005/06/25 16:54:44  joemal
	/// some more queries are need for the xml serlialization
	///
	/// Revision 1.6  2005/06/17 18:33:10  joemal
	/// changes in the connection tables
	///
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
			ModelDataSet.CompRelationsRow[] compRelRows = (ModelDataSet.CompRelationsRow[]) 
				this.Dataset.CompRelations.Select("fk_parent = '"+this.componentID.Key+"'");

			ArrayList conIDs = new ArrayList();

			foreach(ModelDataSet.CompRelationsRow compRelRow in compRelRows)
			{
				foreach(ModelDataSet.AssemblyConnectorsRow conRow in compRelRow.GetAssemblyConnectorsRowsByCompRelAsmConReq())
					conIDs.Add(ComponentModelIdentifier.CreateConnectionID(conRow.guid));
			
				foreach(ModelDataSet.DelegationConnectorsRow conRow in compRelRow.GetDelegationConnectorsRows())
					conIDs.Add(ComponentModelIdentifier.CreateConnectionID(conRow.guid));			
			}

			return (IConnectionIdentifier[]) conIDs.ToArray(typeof(IConnectionIdentifier));
		}

		/// <summary>
		/// returns the ids of all delegation connectors that are contained in this composite component 
		/// </summary>
		/// <returns>the ids</returns>
		public IConnectionIdentifier[] GetDelegationConnectors()
		{
			ModelDataSet.CompRelationsRow[] compRelRows = (ModelDataSet.CompRelationsRow[]) 
				this.Dataset.CompRelations.Select("fk_parent = '"+this.componentID.Key+"'");

			ArrayList conIDs = new ArrayList();

			foreach(ModelDataSet.CompRelationsRow compRelRow in compRelRows)
			{
				foreach(ModelDataSet.DelegationConnectorsRow conRow in compRelRow.GetDelegationConnectorsRows())
					conIDs.Add(ComponentModelIdentifier.CreateConnectionID(conRow.guid));			
			}

			return (IConnectionIdentifier[]) conIDs.ToArray(typeof(IConnectionIdentifier));
		}

		/// <summary>
		/// returns the ids of all assembly connectors that are contained in this composite component 
		/// </summary>
		/// <returns>the ids</returns>
		public IConnectionIdentifier[] GetAssemblyConnectors()
		{
			ModelDataSet.CompRelationsRow[] compRelRows = (ModelDataSet.CompRelationsRow[]) 
				this.Dataset.CompRelations.Select("fk_parent = '"+this.componentID.Key+"'");

			ArrayList conIDs = new ArrayList();

			foreach(ModelDataSet.CompRelationsRow compRelRow in compRelRows)
			{
				foreach(ModelDataSet.AssemblyConnectorsRow conRow in compRelRow.GetAssemblyConnectorsRowsByCompRelAsmConReq())
					conIDs.Add(ComponentModelIdentifier.CreateConnectionID(conRow.guid));
			}

			return (IConnectionIdentifier[]) conIDs.ToArray(typeof(IConnectionIdentifier));
		}

		/// <summary>
		/// returns true, if the connection that belongs to given id is part of this component.
		/// </summary>
		/// <param name="connectionID">the id of the connection</param>
		/// <returns>true, if the connection that belongs to given id is part of this component</returns>
		public bool IsConnectionFromComponent(IConnectionIdentifier connectionID)
		{
			ModelDataSet.AssemblyConnectorsRow asmRow = this.Dataset.AssemblyConnectors.FindByguid(connectionID.Key);
			if (asmRow != null)
				return (asmRow.CompRelationsRowByCompRelAsmConProv.fk_parent.Equals(this.componentID.Key));
			
			ModelDataSet.DelegationConnectorsRow delRow = this.Dataset.DelegationConnectors.FindByguid(connectionID.Key);
			if (delRow != null)
				return (delRow.CompRelationsRow.fk_parent.Equals(this.componentID.Key));

			return false;
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
			return GetDelegationConnector(outerIfaceID, innerCompID, innerIfaceID,InterfaceRole.PROVIDES);
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
			return GetDelegationConnector(outerIfaceID, innerCompID, innerIfaceID,InterfaceRole.REQUIRES);
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
			ModelDataSet.RolesRow reqRole = this.QueryRole(reqCompID,reqIFaceID,InterfaceRole.REQUIRES);
			if (reqRole == null) return null;
			ModelDataSet.RolesRow provRole = this.QueryRole(provCompID,provIFaceID,InterfaceRole.PROVIDES);
			if (provRole == null) return null;
			ModelDataSet.CompRelationsRow reqCompRelRow = this.QueryParent(this.componentID,reqCompID);
			if (reqCompRelRow == null) return null;
			ModelDataSet.CompRelationsRow provCompRelRow = this.QueryParent(this.componentID,provCompID);
			if (provCompRelRow == null) return null;

			string query = "fk_req_role="+reqRole.id+" and fk_prov_role="+provRole.id+
						   " and fk_req_comp_rel="+reqCompRelRow.id+" and fk_prov_comp_rel="+provCompRelRow.id;
			DataRow[] result = this.Dataset.AssemblyConnectors.Select(query);
			if (result.Length==0) return null;
			return ComponentModelIdentifier.CreateConnectionID(((ModelDataSet.AssemblyConnectorsRow)result[0]).guid);
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

		//called to get the delegation connector to the component with given id on given interfaces
		private IConnectionIdentifier GetDelegationConnector(IInterfaceIdentifier outerIfaceID, IComponentIdentifier innerCompID, 
			IInterfaceIdentifier innerIfaceID,InterfaceRole ifaceRole)
		{
			ModelDataSet.RolesRow outerRoleRow = this.QueryRole(this.componentID,outerIfaceID,ifaceRole);
			if (outerRoleRow == null) return null;
			ModelDataSet.RolesRow innerRoleRow = this.QueryRole(innerCompID,innerIfaceID,ifaceRole);
			if (innerRoleRow == null) return null;
			ModelDataSet.CompRelationsRow compRelRow = this.QueryParent(this.componentID,innerCompID);
			if (compRelRow == null) return null;

			string query = "fk_inner_role="+innerRoleRow.id+" and fk_outer_role="+outerRoleRow.id+
				" and fk_inner_comp_rel="+compRelRow.id;
			DataRow[] result = this.Dataset.DelegationConnectors.Select(query);
			if (result.Length == 0) return null;

			return ComponentModelIdentifier.CreateConnectionID(((ModelDataSet.DelegationConnectorsRow)result[0]).guid);
		}

		#endregion		
	}
}
