using System;
using System.Data;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.Identifier;

namespace Palladio.ComponentModel.ModelDataManagement
{
	/// <summary>
	/// This is the implementation of the LowLevelBuilder for the componentmodel. It supports several basic non 
	/// hierarical methods to create the componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/03/16 13:32:34  joemal
	/// implement lowlevelbuilder
	///
	/// Revision 1.1  2005/03/15 12:31:02  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class LowLevelBuilder : ILowLevelBuilder
	{
		#region data

		//the counter of the ids
		private long idCntr=0;

		//holds the database of the model
		private ModelDataSet modelDataset;

		//holds the entities of the model
		private EntityHashtable entityTable;

		//holds the constrains check for the componentmodel
		private ModelConstrainsCheck modelCheck;

		#endregion
		
		#region constructor

		/// <summary>
		/// called to create a new LowLevelBuilder for the componentmodel.
		/// </summary>
		/// <param name="dataset">the datasets that represents the relational db to the model</param>
		/// <param name="hashtable">the entity hashable that holds the entities of the model</param>
		public LowLevelBuilder(ModelDataSet dataset, EntityHashtable hashtable)
		{
			this.modelDataset = dataset;
			this.entityTable = hashtable;
			this.modelCheck = new ModelConstrainsCheck(dataset,hashtable);
			Init();
		}

		#endregion

		#region public methods

		//connect the rowremoved-events of the tables to the eventhandler in this class
		private void Init()
		{
			ComponentsTable.RowDeleted += new DataRowChangeEventHandler(this.EntityDatatable_HandleRowDeleted);			
			InterfacesTable.RowDeleted += new DataRowChangeEventHandler(this.EntityDatatable_HandleRowDeleted);			
			SignaturesTable.RowDeleted += new DataRowChangeEventHandler(this.EntityDatatable_HandleRowDeleted);			
			ProtocolsTable.RowDeleted += new DataRowChangeEventHandler(this.EntityDatatable_HandleRowDeleted);			
			ConnectionsTable.RowDeleted += new DataRowChangeEventHandler(this.EntityDatatable_HandleRowDeleted);			
		}

		/// <summary>
		/// call to remove all entities and there relations from the model
		/// </summary>
		public void ClearAll()
		{
			RolesTable.Clear();
			ComponentsTable.Clear();
			InterfacesTable.Clear();
			SignaturesTable.Clear();
			ProtocolsTable.Clear();
			ConnectionsTable.Clear();
			entityTable.Clear();
			idCntr = 0;
		}

		/// <summary>
		/// call to add a component to the dataset.
		/// </summary>
		/// <param name="component">the component which has to be added</param>
		/// <param name="parentComponentID">the id of the parent component of this one. 
		/// Set this value to null if the component belongs to the top level of the static view.</param>
		/// <exception cref="ComponentNotFoundException">the parent component could not be found in the model.</exception>
		/// <exception cref="WrongComponentTypeException">the parent component is not a composite component.</exception>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void AddComponent(IComponent component, IComponentIdentifier parentComponentID)
		{	
			modelCheck.AddComponentCheck(component,parentComponentID);
		
			ModelDataSet.ComponentsRow newRow = ComponentsTable.NewComponentsRow();
			newRow.id = NextID;
			newRow.guid = component.ID.Key;
			newRow.type = (sbyte) component.Type;

			ModelDataSet.ComponentsRow parentComp = GetComponentsRow(parentComponentID);
			if (parentComp != null)
				newRow.parentComponent = parentComp.id;

			ComponentsTable.AddComponentsRow(newRow);
			ComponentsTable.AcceptChanges();

			entityTable.AddEntity(component);
		}

		/// <summary>
		/// called to remove the component which belongs to the given id. All contained components and
		/// all connections to and from this components are also removed.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		public void RemoveComponent(IComponentIdentifier componentId)
		{
			this.RemoveRow(componentId,ComponentsTable);
		}

		/// <summary>
		/// called to add an existing interface to a component.
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		/// <param name="role">determ whether the interface is bound as requires or provides interface</param>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">the component could not be found in cm</exception>
		public void AddInterfaceToComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier, 
			InterfaceRole role)
		{
			modelCheck.AddIFaceToCompCheck(componentIdentifier,ifaceIdentifier,role);

			ModelDataSet.ComponentsRow compRow = GetComponentsRow(componentIdentifier);
			ModelDataSet.InterfacesRow ifaceRow = GetInterfacesRow(ifaceIdentifier);

			string query = "fk_comp = "+compRow.id+" and fk_iface = "+ifaceRow.id;
			DataRow[] result = modelDataset.Roles.Select(query);

			//still exists
			if (result.Length == 2) return;
			if (result.Length == 1)
				if (((ModelDataSet.RolesRow)result[0]).type == (sbyte)role) return;
            
			RolesTable.AddRolesRow(this.NextID,compRow,ifaceRow,(sbyte) role);
			RolesTable.AcceptChanges();
		}

		/// <summary>
		/// called to remove an interface from a component.
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		/// <param name="role">the role bound of the interface in the component</param>
		public void RemoveInterfaceFromComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier,
			InterfaceRole role)
		{
			ModelDataSet.RolesRow rolesRow = QueryRole(componentIdentifier,ifaceIdentifier,role);
			if (rolesRow == null) return;

			rolesRow.Delete();
			RolesTable.AcceptChanges();
		}

		/// <summary>
		/// called to add a delegationconnector from the provides interface of an component to the provides 
		/// interface of an inner component.
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="outerCompID">the id of the outer component</param>
		/// <param name="outerIFaceID">the id of the outer component</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the inner components interface</param>
		public void AddProvidesDelegationConnector(IConnection connection, IComponentIdentifier outerCompID, IInterfaceIdentifier outerIFaceID, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to add a delegationconnector from the requires interface of an component to the requires 
		/// interface of its parent component
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the inner components interface</param>
		/// <param name="outerCompID">the id of the outer component</param>
		/// <param name="outerIFaceID">the id of the outer component</param>
		public void AddRequiresDelegationConnector(IConnection connection, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID, IComponentIdentifier outerCompID, IInterfaceIdentifier outerIFaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to add an assemblyConnector from a requires interfaces of a component to a provides interface of 
		/// another component. Both components must have the same parent component or must be placed at the top level of the
		/// model.
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="reqCompID">the id of the incoming component</param>
		/// <param name="reqIFaceID">the incoming components interface</param>
		/// <param name="provCompID">the id of the outgoing component</param>
		/// <param name="provIFaceID">the outgoing components interface</param>
		public void AddAssemblyConnector(IConnection connection, IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to remove the connection that belongs to the given id.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		public void RemoveConnection(IConnectionIdentifier connectionID)
		{
			RemoveRow(connectionID,ConnectionsTable);
		}

		/// <summary>
		/// called to add an interface to the model. 
		/// </summary>
		/// <param name="iface">the interface to be added</param>
		/// <exception cref="EntityAlreadyExistsException">an interface with given id already exists in cm</exception>
		public void AddInterface(IInterface iface)
		{
			this.modelCheck.AddInterfaceCheck(iface);
			this.InterfacesTable.AddInterfacesRow(this.NextID,iface.ID.Key);
			this.InterfacesTable.AcceptChanges();
			this.entityTable.AddEntity(iface);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed.
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveInterface(IInterfaceIdentifier ifaceID)
		{
			this.RemoveRow(ifaceID,InterfacesTable);
		}

		/// <summary>
		/// called to add the given signature to the interfaces, specified by the given interface id.
		/// </summary>
		/// <param name="signature">the signature to be added</param>
		/// <param name="ifaceID">the id of the interface, to which the signature has to be added</param>
		/// <exception cref="EntityAlreadyExistsException">an signature with given id already exists in cm</exception>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		public void AddSignature(ISignature signature, IInterfaceIdentifier ifaceID)
		{
			modelCheck.AddSignatureCheck(signature, ifaceID);
			ModelDataSet.InterfacesRow ifaceRow = GetInterfacesRow(ifaceID);
			SignaturesTable.AddSignaturesRow(this.NextID,signature.ID.Key,ifaceRow);
		}

		/// <summary>
		/// called to remove the signature with given id.
		/// </summary>
		/// <param name="signatureID">the id of the signature that has to be removed</param>
		public void RemoveSignature(ISignatureIdentifier signatureID)
		{
			this.RemoveRow(signatureID,SignaturesTable);			
		}

		/// <summary>
		/// called to add a protocol to the interfaces that is specified by the given interface id.
		/// </summary>
		/// <param name="protocol">the protocol to be added</param>
		/// <param name="ifaceID">the id of the interface, to which the protocol has to be added</param>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		public void AddProtocol(IProtocol protocol, IInterfaceIdentifier ifaceID)
		{
			modelCheck.AddProtocolCheck(ifaceID);

			ModelDataSet.InterfacesRow ifaceRow = GetInterfacesRow(ifaceID);
			ProtocolsTable.AddProtocolsRow(protocol.ID.Key,ifaceRow);
			ProtocolsTable.AcceptChanges();
		}

		/// <summary>
		/// called to remove the protocol with given id. 
		/// </summary>
		/// <param name="protocolID">the id of the protocol that has to be removed</param>
		public void RemoveProtocol(IProtocolIdentifier protocolID)
		{
			this.RemoveRow(protocolID,ProtocolsTable);			
		}

		#endregion

		#region private methods

		//return the row from the componenttable that is matching to given component identifier.
		private ModelDataSet.ComponentsRow GetComponentsRow(IComponentIdentifier compId)
		{
			return (ModelDataSet.ComponentsRow) GetRow(compId,ComponentsTable);
		}

		//return the row from the interfacetable that is matching to given interface identifier.
		private ModelDataSet.InterfacesRow GetInterfacesRow(IInterfaceIdentifier ifaceId)
		{
			return (ModelDataSet.InterfacesRow) GetRow(ifaceId,InterfacesTable);
		}

		//returns the row of the given table that is matching to the given id.
		private DataRow GetRow(IIdentifier id, DataTable table)
		{
			if (id == null) return null;
			DataRow[] result = table.Select("guid = '"+id.Key+"'");
			if (result.Length != 0)
				return result[0];
			
			return null;
		}

		//called to remove the row that is matching to id from given table
		private void RemoveRow(IIdentifier id, DataTable table)
		{
			DataRow row = GetRow(id,table);
			if (row != null)
				row.Delete();

			table.AcceptChanges();            			
		}

		//queries the role by componentid, interfaceid and role
		private ModelDataSet.RolesRow QueryRole(IComponentIdentifier compId, IInterfaceIdentifier iFaceId, InterfaceRole role)
		{
			ModelDataSet.ComponentsRow compRow = GetComponentsRow(compId);
			ModelDataSet.InterfacesRow ifaceRow = GetInterfacesRow(iFaceId);

			if (compRow == null || ifaceRow == null) return null;

			string query = "fk_comp = "+compRow.id+" and fk_iface = "+ifaceRow.id+" and type = "+(sbyte)role;
			DataRow[] result = modelDataset.Roles.Select(query);

			if (result.Length == 0) return null;	

			return (ModelDataSet.RolesRow) result[0];
		}

		//called to add a connection between two roles
		private void AddConnection(IConnection connection, ModelDataSet.RolesRow rolesRow1, 
			ModelDataSet.RolesRow rolesRow2)
		{
			ConnectionsTable.AddConnectionsRow(rolesRow1,rolesRow2,connection.ID.Key);
			ConnectionsTable.AcceptChanges();
			entityTable.AddEntity(connection);
		}

		//the handler of the RowRemovedEvents of the datasets tables. 
		//all tables that are observed by this handler must contain a column from type string that holds
		//the key of the entities identifier. This key is used to find the entity in the hashtable.
		private void EntityDatatable_HandleRowDeleted(object sender, DataRowChangeEventArgs e)
		{
			this.entityTable.RemoveEntity((string) e.Row["guid",DataRowVersion.Original]);
		}

		#endregion

		#region properties

		//returns the table of the components
		private ModelDataSet.ComponentsDataTable ComponentsTable
		{
			get
			{
				return modelDataset.Components;
			}
		}
		
		//returns the table of the interfaces
		private ModelDataSet.InterfacesDataTable InterfacesTable
		{
			get
			{
				return modelDataset.Interfaces;
			}
		}
		
		//returns the table of the signatures
		private ModelDataSet.SignaturesDataTable SignaturesTable
		{
			get
			{
				return modelDataset.Signatures;
			}
		}
		
		//returns the table of the protocols
		private ModelDataSet.ProtocolsDataTable ProtocolsTable
		{
			get
			{
				return modelDataset.Protocols;
			}
		}
		
		//returns the table of the roles
		private ModelDataSet.RolesDataTable RolesTable
		{
			get
			{
				return modelDataset.Roles;
			}
		}
		
		//returns the table of the connections
		private ModelDataSet.ConnectionsDataTable ConnectionsTable
		{
			get
			{
				return modelDataset.Connections;
			}
		}

		//call return a new id
		private long NextID
		{
			get
			{
				return idCntr++;
			}
		}
		#endregion
	}
}
