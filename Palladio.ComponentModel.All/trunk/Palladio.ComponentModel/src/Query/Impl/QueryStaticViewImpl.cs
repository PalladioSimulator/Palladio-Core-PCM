using System;
using System.Collections;
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
	/// Revision 1.10  2005/09/15 10:56:41  kelsaka
	/// - fixed bug: test used same instead of equals
	///
	/// Revision 1.9  2005/09/15 10:53:58  kelsaka
	/// - fixed bug in SELECT-Statement
	///
	/// Revision 1.8  2005/09/15 10:40:41  kelsaka
	/// - fixed test-bug
	///
	/// Revision 1.7  2005/09/15 09:11:02  kelsaka
	/// - added new method GetAssemblyConnectors()
	///
	/// Revision 1.6  2005/06/17 18:33:09  joemal
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
			return QueryComponents();
		}

		/// <summary>
		/// returns true, if the component that belongs to given id is part of this component
		/// </summary>
		/// <param name="compID">the id of the component</param>
		/// <returns>true, if the component that belongs to the given id is part of this component.</returns>
		public bool IsChild(IComponentIdentifier compID)
		{
			string query = "fk_parent is null and fk_child = '"+compID.Key+"'";
			return (this.Dataset.CompRelations.Select(query).Length != 0);
		}

		/// <summary>
		/// returns the ids of the connections that are contained in this component.
		/// </summary>
		/// <returns>the ids of the connections</returns>
		public IConnectionIdentifier[] GetConnections()
		{
			ModelDataSet.CompRelationsRow[] compRelRows = (ModelDataSet.CompRelationsRow[]) 
				this.Dataset.CompRelations.Select("fk_parent is null");

			ArrayList conIDs = new ArrayList();
			foreach(ModelDataSet.CompRelationsRow compRelRow in compRelRows)
			{
				foreach(ModelDataSet.AssemblyConnectorsRow conRow in compRelRow.GetAssemblyConnectorsRowsByCompRelAsmConReq())
					conIDs.Add(ComponentModelIdentifier.CreateConnectionID(conRow.guid));
			}

			return (IConnectionIdentifier[]) conIDs.ToArray(typeof(IConnectionIdentifier));
		}

		/// <summary>
		/// returns the ids of all interfaces that are contained in the type level of the componentmodel
		/// </summary>
		/// <returns>the ids of the interfaces</returns>
		public IInterfaceIdentifier[] GetInterfaces()
		{
			IInterfaceIdentifier[] ifaceIDs = new IInterfaceIdentifier[this.Dataset.Interfaces.Count];
			for(int a=0;a<ifaceIDs.Length;a++)
			{
				ModelDataSet.InterfacesRow row = (ModelDataSet.InterfacesRow) this.Dataset.Interfaces.Rows[a];
				ifaceIDs[a] = ComponentModelIdentifier.CreateInterfaceID(row.guid);
			}

			return ifaceIDs;
		}

		/// <summary>
		/// returns true, if the connection that belongs to given id is part of this component.
		/// </summary>
		/// <param name="connectionID">the id of the connection</param>
		/// <returns>true, if the connection that belongs to given id is part of this component</returns>
		public bool IsConnectionFromComponent(IConnectionIdentifier connectionID)
		{
			ModelDataSet.AssemblyConnectorsRow conRow = this.Dataset.AssemblyConnectors.FindByguid(connectionID.Key);
			if (conRow == null) return false;
			return conRow.CompRelationsRowByCompRelAsmConProv.Isfk_parentNull();
		}

		/// <summary>
		/// called to return the assembly connector that connects the given two components.
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

			string query = "fk_prov_role = "+provRole.id+" and fk_req_role = "+reqRole.id;
			DataRow[] result = this.Dataset.AssemblyConnectors.Select(query);

			foreach(ModelDataSet.AssemblyConnectorsRow conRow in result)
				if (conRow.CompRelationsRowByCompRelAsmConProv.Isfk_parentNull()) 
					return ComponentModelIdentifier.CreateConnectionID(conRow.guid);

			return null;
		}

		/// <summary>
		/// returns the ids of all assembly connectors that are contained in the static view, but not part
		/// of internal composite components. This means, that only assembly connectors lying 
		/// directly at the static view (with no outer composite component) are returned.
		/// </summary>
		/// <returns>the ids of all assembly connectors at the static view.</returns>
		public IConnectionIdentifier[] GetAssemblyConnectors ()
		{
			ModelDataSet.CompRelationsRow[] compRelRows = (ModelDataSet.CompRelationsRow[]) 
				this.Dataset.CompRelations.Select("fk_parent is null");

			ArrayList conIDs = new ArrayList();

			foreach(ModelDataSet.CompRelationsRow compRelRow in compRelRows)
			{
				foreach(ModelDataSet.AssemblyConnectorsRow conRow in compRelRow.GetAssemblyConnectorsRowsByCompRelAsmConReq())
					conIDs.Add(ComponentModelIdentifier.CreateConnectionID(conRow.guid));
			}

			return (IConnectionIdentifier[]) conIDs.ToArray(typeof(IConnectionIdentifier));
		}

		/// <summary>
		/// returns the ids of all basic components which are placed directly in the static view root.
		/// </summary>
		/// <returns>the ids</returns>
		public IComponentIdentifier[] GetBasicComponents()
		{
			return QueryComponents(ComponentType.BASIC);
		}

		/// <summary>
		/// returns the ids of all composite components which are placed directly in the static view root.
		/// </summary>
		/// <returns>the ids</returns>
		public IComponentIdentifier[] GetCompositeComponents()
		{
			return QueryComponents(ComponentType.COMPOSITE);
		}

		#endregion

		#region private 

		//called to query the components of the static view
		private IComponentIdentifier[] QueryComponents()
		{
			DataRow[] compRows = this.QueryChildComponents();
			IComponentIdentifier[] compIds = new IComponentIdentifier[compRows.Length];
	
			for (int a=0;a<compRows.Length;a++)
				compIds[a] = ComponentModelIdentifier.CreateComponentID(((ModelDataSet.CompRelationsRow)compRows[a]).fk_child);
			
			return compIds;
		}

		//called to query the components of the static view
		private IComponentIdentifier[] QueryComponents(ComponentType type)
		{
			DataRow[] compRows = this.QueryChildComponents();
			ArrayList cIDs = new ArrayList();
			foreach(ModelDataSet.CompRelationsRow compRelRow in compRows)
			{
				IComponentIdentifier compID = ComponentModelIdentifier.CreateComponentID(compRelRow.fk_child);
				if (this.QueryRepository.GetComponent(compID).Type == type) cIDs.Add(compID);
			}

			return (IComponentIdentifier[]) cIDs.ToArray(typeof(IComponentIdentifier));
		}

		//called to return a list of componentrelation rows that have the static view root as parent
		private DataRow[] QueryChildComponents()
		{
			string query = "fk_parent is null";
			return this.Dataset.CompRelations.Select(query);						
		}

		#endregion
	}
}
