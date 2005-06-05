using System;
using System.Data;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;
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
	/// Revision 1.14  2005/06/05 10:39:23  joemal
	/// - components now can be added to more than one container
	///
	/// Revision 1.13  2005/05/20 10:40:02  joemal
	/// remove some debug rubish
	///
	/// Revision 1.12  2005/05/19 18:09:40  joemal
	/// fix some bugs
	///
	/// Revision 1.11  2005/05/08 17:23:40  joemal
	/// fix a bug
	///
	/// Revision 1.10  2005/04/19 16:47:31  joemal
	/// fix two bugs
	///
	/// Revision 1.9  2005/04/11 17:06:26  joemal
	/// change the ClearAll method
	///
	/// Revision 1.8  2005/04/04 16:27:28  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.7  2005/03/31 11:02:03  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.6  2005/03/29 13:06:11  joemal
	/// add event support
	///
	/// Revision 1.5  2005/03/28 19:02:16  joemal
	/// primary keys in the dataset now are the guids of the entities
	///
	/// Revision 1.4  2005/03/28 18:13:33  joemal
	/// move private methods to private region
	///
	/// Revision 1.3  2005/03/19 18:35:41  joemal
	/// implement the rest of the lowlevelbuilder
	///
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
		private EntityHashtable entityHashtable;

		//holds the constrains check for the componentmodel
		private ModelConstrainsCheck modelCheck;

		//the entity registration interface of the model event manager
		private IEntityRegistration entityReg;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new LowLevelBuilder for the componentmodel.
		/// </summary>
		/// <param name="dataset">the datasets that represents the relational db to the model</param>
		/// <param name="hashtable">the entity hashable that holds the entities of the model</param>
		/// <param name="registration">the interface of the event manager that is used to register
		/// the enities</param>
		public LowLevelBuilder(ModelDataSet dataset, EntityHashtable hashtable, IEntityRegistration registration)
		{
			this.modelDataset = dataset;
			this.entityHashtable = hashtable;
			this.modelCheck = new ModelConstrainsCheck(dataset,hashtable);
			this.entityReg = registration;
			Init();			
		}

		#endregion

		#region private methods

		//connect the rowremoved-events of the tables to the eventhandler in this class
		private void Init()
		{
			modelDataset.Components.ComponentsRowDeleted += new ModelDataSet.ComponentsRowChangeEventHandler(CompDeleted);			
			modelDataset.Interfaces.InterfacesRowDeleted += new ModelDataSet.InterfacesRowChangeEventHandler(IfaceDeleted);			
			modelDataset.Signatures.SignaturesRowDeleted += new ModelDataSet.SignaturesRowChangeEventHandler(SigDeleted);			
			modelDataset.Protocols.ProtocolsRowDeleted += new ModelDataSet.ProtocolsRowChangeEventHandler(ProtocolDeleted);			
			modelDataset.Connections.ConnectionsRowDeleted += new ModelDataSet.ConnectionsRowChangeEventHandler(ConDeleted);			
			modelDataset.Roles.RolesRowDeleted +=new ModelDataSet.RolesRowChangeEventHandler(InterfaceUnbound);
			modelDataset.CompRelations.CompRelationsRowDeleted +=new ModelDataSet.CompRelationsRowChangeEventHandler(CompRelationsDeleted);
		}

		//clear the given dataset table
		private void ClearTable(DataTable table)
		{
			while(table.Rows.Count != 0)
			{
				table.Rows.RemoveAt(0);
				modelDataset.AcceptChanges();
			}
		}

		//queries the role by componentid, interfaceid and role
		private ModelDataSet.RolesRow QueryRole(IComponentIdentifier compId, IInterfaceIdentifier iFaceId, InterfaceRole role)
		{
			string query = "fk_comp = '"+compId.Key+"' and fk_iface = '"+iFaceId.Key+"' and type = "+(sbyte)role;
			DataRow[] result = modelDataset.Roles.Select(query);

			if (result.Length == 0) return null;	

			return (ModelDataSet.RolesRow) result[0];
		}

		//queries the parent relation between to components if exists
		private ModelDataSet.CompRelationsRow QueryParent(IComponentIdentifier childId, IComponentIdentifier parentId)
		{
			string query = "fk_child = '"+childId.Key+"' and fk_parent";
			if (parentId == null)
				query += " is null";
			else
				query += " = '"+parentId.Key+"'";

			DataRow[] result = modelDataset.CompRelations.Select(query);

			if (result.Length == 0) return null;	

			return (ModelDataSet.CompRelationsRow) result[0];			
		}

		//add a connection
		private void AddDelegation(IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID, IComponentIdentifier outerCompID, 
			IInterfaceIdentifier outerIFaceID, IConnection connection, InterfaceRole role)
		{
			modelCheck.EntityAlreadyExistsCheck(connection.ID);

			if (role == InterfaceRole.PROVIDES)
				modelCheck.AddProvidesDelegationCheck(innerCompID,innerIFaceID,outerCompID,outerIFaceID,role);
			else
				modelCheck.AddRequiresDelegationCheck(innerCompID,innerIFaceID,outerCompID,outerIFaceID,role);

			ModelDataSet.RolesRow innerRole = QueryRole(innerCompID,innerIFaceID,role);
			ModelDataSet.RolesRow outerRole = QueryRole(outerCompID,outerIFaceID,role);

			ModelDataSet.ComponentsRow outerCompRow = ComponentsTable.FindByguid(outerCompID.Key);
	
			if (role == InterfaceRole.PROVIDES)
				ConnectionsTable.AddConnectionsRow(outerRole,innerRole,connection.ID.Key,outerCompRow);
			else
				ConnectionsTable.AddConnectionsRow(innerRole, outerRole,connection.ID.Key,outerCompRow);

			ConnectionsTable.AcceptChanges();
			entityHashtable.AddEntity(connection);
		}

		//called when a component has been removed from dataset
		private void CompDeleted(object sender, ModelDataSet.ComponentsRowChangeEvent e)
		{
			string compKey = (string)e.Row["guid",DataRowVersion.Original];

			IComponent comp = (IComponent) entityHashtable[compKey];
			entityReg.UnregisterComponent(comp);
			entityHashtable.RemoveEntity(compKey);
		}

		//called when an interface has been removed from dataset
		private void IfaceDeleted(object sender, ModelDataSet.InterfacesRowChangeEvent e)
		{
			string ifaceKey = (string)e.Row["guid",DataRowVersion.Original];
			entityReg.UnregisterInterface((IInterface) entityHashtable[ifaceKey]);
			entityHashtable.RemoveEntity(ifaceKey);
		}

		//called when a protocol has been removed from dataset
		private void ProtocolDeleted(object sender, ModelDataSet.ProtocolsRowChangeEvent e)
		{
			string protKey = (string)e.Row["guid",DataRowVersion.Original];
			string ifaceKey = (string)e.Row["fk_iface",DataRowVersion.Original];

			entityReg.UnregisterProtocol((IProtocol)entityHashtable[protKey],
				((IInterface)entityHashtable[ifaceKey]).InterfaceID);
			
			entityHashtable.RemoveEntity(protKey);
		}

		//called when a connection has been removed from dataset
		private void ConDeleted(object sender, ModelDataSet.ConnectionsRowChangeEvent e)
		{
			string conKey = (string)e.Row["guid",DataRowVersion.Original];
			object parentCKey = e.Row["fk_comp",DataRowVersion.Original];
			IComponentIdentifier parentCompID = null;

			if (!(parentCKey is DBNull))
				parentCompID = new InternalEntityIdentifier((string)parentCKey);
			
			entityReg.UnregisterConnection((IConnection) entityHashtable[conKey],parentCompID);

            entityHashtable.RemoveEntity(conKey);
		}

		//called when a signature has been removed from dataset
		private void SigDeleted(object sender, ModelDataSet.SignaturesRowChangeEvent e)
		{
			string sigKey = (string)e.Row["guid",DataRowVersion.Original];
			string ifaceKey = (string)e.Row["fk_iface",DataRowVersion.Original];

			entityReg.UnregisterSignature((ISignature)entityHashtable[sigKey],
				((IInterface)entityHashtable[ifaceKey]).InterfaceID);
			
			entityHashtable.RemoveEntity(sigKey);
		}

		//called when an interface has been unbound from a component
		private void InterfaceUnbound(object sender, ModelDataSet.RolesRowChangeEvent e)
		{
			string compKey = (string)e.Row["fk_comp",DataRowVersion.Original];
			string ifaceKey = (string)e.Row["fk_iface",DataRowVersion.Original];
			entityReg.UnregisterInterfaceFromComponent(new InternalEntityIdentifier(compKey),
				new InternalEntityIdentifier(ifaceKey));
		}

		//called when a component relation 
		private void CompRelationsDeleted(object sender, ModelDataSet.CompRelationsRowChangeEvent e)
		{
			IComponentIdentifier child = new InternalEntityIdentifier((string)e.Row["fk_child",DataRowVersion.Original]);
			IComponentIdentifier parent = null;

			if (!e.Row["fk_parent",DataRowVersion.Original].Equals(System.DBNull.Value))
				parent = new InternalEntityIdentifier((string)e.Row["fk_parent",DataRowVersion.Original]);

			entityReg.UnregisterComponentRelation(child,parent);
		}

		#endregion

		#region public methods

		/// <summary>
		/// call to remove all entities and there relations from the model
		/// </summary>
		public void ClearAll()
		{
			this.ClearTable(ComponentsTable);
			this.ClearTable(CompRelationTable);
			this.ClearTable(InterfacesTable);
			this.ClearTable(ProtocolsTable);
			this.ClearTable(RolesTable);
			this.ClearTable(ConnectionsTable);			
			this.ClearTable(SignaturesTable);
			entityHashtable.Clear();
			idCntr = 0;
		}

		/// <summary>
		/// call to add a component to the dataset.
		/// </summary>
		/// <param name="component">the component which has to be added</param>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void CreateComponent(IComponent component)
		{	
			modelCheck.CreateComponentCheck(component);
		
			ComponentsTable.AddComponentsRow(component.ID.Key,(sbyte)component.Type);
			ComponentsTable.AcceptChanges();

			entityHashtable.AddEntity(component);
			entityReg.RegisterComponent(component);			
		}

		/// <summary>
		/// called to add an existing component to a composite component or to the static view. 
		/// </summary>
		/// <param name="componentId">the id of the component to be added</param>
		/// <param name="parentComponentId">the parent id or null if the component has 
		/// to be added to the static view.</param>
		/// <exception cref="ComponentNotFoundException">the component or the parent component doesn't exist in cm</exception>
		/// <exception cref="WrongComponentTypeException">the parent component is not a composite component.</exception>
		/// <exception cref="EntityAlreadyExistsException">the component is still a child of the parent component</exception>
		public void AddComponent(IComponentIdentifier componentId, IComponentIdentifier parentComponentId)
		{
			modelCheck.AddCompToCompCheck(componentId,parentComponentId);

			ModelDataSet.CompRelationsRow newRow = CompRelationTable.NewCompRelationsRow();
			newRow.fk_child = componentId.Key;
			if (parentComponentId != null)
				newRow.fk_parent = parentComponentId.Key;

			CompRelationTable.AddCompRelationsRow(newRow);

			RolesTable.AcceptChanges();

			entityReg.RegisterComponentToComponent(componentId,parentComponentId);
		}

		/// <summary>
		/// called to remove the component which belongs to the given id from the given parent component. 
		/// All connections to and from this components are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		/// <param name="parentComponentId">the id of the parent component of the one that
		/// has to be removed. Set null if the component has to be removed from the static view.</param>
		public void RemoveComponentFromComponent(IComponentIdentifier componentId, IComponentIdentifier parentComponentId)
		{
			ModelDataSet.CompRelationsRow compRelRow = QueryParent(componentId,parentComponentId);
			if (compRelRow == null) return;

			compRelRow.Delete();
			modelDataset.AcceptChanges();
		}

		/// <summary>
		/// called to remove the component which belongs to the given id from the model. All references of 
		/// this components and the connections to them are also removed. 
		/// If the entity could not be found in the componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		public void RemoveComponent(IComponentIdentifier componentId)
		{
			ModelDataSet.ComponentsRow row = ComponentsTable.FindByguid(componentId.Key);
			if (row == null) return;
			
			row.Delete();
			modelDataset.AcceptChanges();
		}

		/// <summary>
		/// called to add an existing interface to a component. 
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		/// <param name="role">determ whether the interface is bound as requires or provides interface</param>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">the component could not be found in cm</exception>
		/// <exception cref="EntityAlreadyExistsException">the interface is still bound with the component 
		/// at given role</exception>
		public void AddInterface(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier, 
			InterfaceRole role)
		{
			modelCheck.AddIFaceToCompCheck(componentIdentifier,ifaceIdentifier,role);

			ModelDataSet.ComponentsRow compRow = ComponentsTable.FindByguid(componentIdentifier.Key);
			ModelDataSet.InterfacesRow ifaceRow = InterfacesTable.FindByguid(ifaceIdentifier.Key);
          
			RolesTable.AddRolesRow(this.NextID,compRow,ifaceRow,(sbyte) role);
			RolesTable.AcceptChanges();

			entityReg.RegisterInterfaceToComponent(componentIdentifier,ifaceIdentifier,role);
		}

		/// <summary>
		/// called to add an interface to the model. 
		/// </summary>
		/// <param name="iface">the interface to be added</param>
		/// <exception cref="EntityAlreadyExistsException">an interface with given id already exists in cm</exception>
		public void CreateInterface(IInterface iface)
		{
			this.modelCheck.CreateInterfaceCheck(iface);
			this.InterfacesTable.AddInterfacesRow(iface.ID.Key);
			this.InterfacesTable.AcceptChanges();
			this.entityHashtable.AddEntity(iface);
			entityReg.RegisterInterface(iface);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveInterface(IInterfaceIdentifier ifaceID)
		{
			ModelDataSet.InterfacesRow row = InterfacesTable.FindByguid(ifaceID.Key);
			if (row == null) return;
			row.Delete();
			modelDataset.AcceptChanges();
		}

		/// <summary>
		/// called to remove an interface from a component. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
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
			modelDataset.AcceptChanges();
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
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="InterfaceNotFromComponentException">the interface is not bound to the component</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="ComponentHierarchyException">the outer component is not the parent of the inner component</exception>
		/// <exception cref="NotAProvidesIFaceException">one of the given interfaces is not a provides
		/// interface of the component</exception>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void AddProvidesDelegationConnector(IConnection connection, IComponentIdentifier outerCompID, IInterfaceIdentifier outerIFaceID, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID)
		{			
			AddDelegation(innerCompID, innerIFaceID, outerCompID, outerIFaceID, connection, InterfaceRole.PROVIDES);
			entityReg.RegisterProvidesDelegation(connection,outerCompID,outerIFaceID,innerCompID,innerIFaceID);
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
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="ComponentHierarchyException">the outer component is not the parent of the inner component</exception>
		/// <exception cref="NotARequiresIFaceException">one of the given interfaces is not a requires 
		/// interface of the component</exception>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void AddRequiresDelegationConnector(IConnection connection, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID, IComponentIdentifier outerCompID, IInterfaceIdentifier outerIFaceID)
		{
			AddDelegation(innerCompID, innerIFaceID, outerCompID, outerIFaceID, connection, InterfaceRole.REQUIRES);
			entityReg.RegisterRequiresDelegation(connection,innerCompID,innerIFaceID,outerCompID,outerIFaceID);
		}

		/// <summary>
		/// called to add an assemblyConnector from a requires interfaces of a component to a provides interface of 
		/// another component. Both components must have the same parent component or must be placed at the top level of the
		/// model.
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="parentCompID">the id of component that should contain the connection</param>
		/// <param name="reqCompID">the id of the incoming component</param>
		/// <param name="reqIFaceID">the incoming components interface</param>
		/// <param name="provCompID">the id of the outgoing component</param>
		/// <param name="provIFaceID">the outgoing components interface</param>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="InterfaceNotFromComponentException">the interface is not bound with the component</exception>
		/// <exception cref="ComponentNotFoundException">one of the components could not be found in cm</exception>
		/// <exception cref="NotARequiresIFaceException">the first given interface is not a requires</exception> 
		/// <exception cref="NotAProvidesIFaceException">the second given interface is not a provides </exception>
		/// <exception cref="ComponentHierarchyException">one of the components is not a child of the parent component.</exception>
		public void AddAssemblyConnector(IConnection connection, IComponentIdentifier parentCompID, 
			IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID, 
			IInterfaceIdentifier provIFaceID)
		{
			modelCheck.EntityAlreadyExistsCheck(connection.ID);

			ModelDataSet.RolesRow reqRole = QueryRole(reqCompID,reqIFaceID,InterfaceRole.REQUIRES);
			ModelDataSet.RolesRow provRole = QueryRole(provCompID,provIFaceID,InterfaceRole.PROVIDES);

			modelCheck.AddAssemblyConnectorCheck(parentCompID,reqCompID,reqIFaceID,provCompID,provIFaceID);

			ModelDataSet.ConnectionsRow newRow = ConnectionsTable.NewConnectionsRow();
			newRow.incoming = reqRole.id;
			newRow.outgoing = provRole.id;
			newRow.guid = connection.ID.Key;

			if (parentCompID != null)
				newRow.fk_comp = parentCompID.Key;

			ConnectionsTable.AddConnectionsRow(newRow);
			ConnectionsTable.AcceptChanges();
			entityHashtable.AddEntity(connection);
			entityReg.RegisterAssemblyConnection(connection,parentCompID,reqCompID,reqIFaceID,provCompID,provIFaceID);
		}

		/// <summary>
		/// called to remove the connection that belongs to the given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		public void RemoveConnection(IConnectionIdentifier connectionID)
		{
			ModelDataSet.ConnectionsRow row = ConnectionsTable.FindByguid(connectionID.Key);
			if (row == null) return;
			row.Delete();
			modelDataset.AcceptChanges();
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
			ModelDataSet.InterfacesRow ifaceRow = InterfacesTable.FindByguid(ifaceID.Key);
			SignaturesTable.AddSignaturesRow(signature.ID.Key,ifaceRow);
			SignaturesTable.AcceptChanges();
			entityHashtable.AddEntity(signature);
			entityReg.RegisterSignature(signature,ifaceID);
		}

		/// <summary>
		/// called to remove the signature with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="signatureID">the id of the signature that has to be removed</param>
		public void RemoveSignature(ISignatureIdentifier signatureID)
		{
			ModelDataSet.SignaturesRow row = SignaturesTable.FindByguid(signatureID.Key);
			if (row == null) return;
			row.Delete();
			modelDataset.AcceptChanges();
		}

		/// <summary>
		/// called to add a protocol to the interfaces that is specified by the given interface id.
		/// </summary>
		/// <param name="protocol">the protocol to be added</param>
		/// <param name="ifaceID">the id of the interface, to which the protocol has to be added</param>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void AddProtocol(IProtocol protocol, IInterfaceIdentifier ifaceID)
		{
			modelCheck.AddProtocolCheck(protocol,ifaceID);

			ModelDataSet.InterfacesRow ifaceRow = InterfacesTable.FindByguid(ifaceID.Key);
			ProtocolsTable.AddProtocolsRow(protocol.ID.Key,ifaceRow);
			ProtocolsTable.AcceptChanges();
			entityHashtable.AddEntity(protocol);

			entityReg.RegisterProtocol(protocol,ifaceID);
		}

		/// <summary>
		/// called to remove the protocol with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="protocolID">the id of the protocol that has to be removed</param>
		public void RemoveProtocol(IProtocolIdentifier protocolID)
		{
			ModelDataSet.ProtocolsRow row = ProtocolsTable.FindByguid(protocolID.Key);
			if (row == null) return;
			row.Delete();
			modelDataset.AcceptChanges();
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

		//returns the table that contains the relations between the components
		private ModelDataSet.CompRelationsDataTable CompRelationTable
		{
			get
			{
				return modelDataset.CompRelations;
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
