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

		#region methods

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

			ModelDataSet.ComponentsRow parentComp = getComponentsRow(parentComponentID);
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
			ModelDataSet.ComponentsRow component = getComponentsRow(componentId);
			if (component != null)
				ComponentsTable.RemoveComponentsRow(component);

			ComponentsTable.AcceptChanges();
		}

		/// <summary>
		/// called to add an existing interface as an provides interface to a component.
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		public void AddProvidesInterfaceToComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to add an existing interface as an requires interface to a component.
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		public void AddRequiresInterfaceToComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to remove an interface from a component.
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		public void RemoveInterfaceFromComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to add a connection from one component to another component. Therefore the interfaces and the two components
		/// have to be specified. Both components must have the same parent component or must be placed at the top level of the
		/// model.
		/// </summary>
		/// <param name="connection"></param>
		/// <param name="incomingCompID"></param>
		/// <param name="incomingIFaceID"></param>
		/// <param name="outgoingCompID"></param>
		/// <param name="outgoingIFaceID"></param>
		public void AddConnection(IConnection connection, IComponentIdentifier incomingCompID, IInterfaceIdentifier incomingIFaceID, IComponentIdentifier outgoingCompID, IInterfaceIdentifier outgoingIFaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to remove the connection that belongs to the given id.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		public void RemoveConnection(IConnectionIdentifier connectionID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to add an interface to the model. 
		/// </summary>
		/// <param name="iface">the interface to be added</param>
		public void AddInterface(IInterface iface)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed.
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveInterface(IInterfaceIdentifier ifaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to add the given signature to the interfaces, specified by the given interface id.
		/// </summary>
		/// <param name="signature">the signature to be added</param>
		/// <param name="ifaceID">the id of the interface, to which the signature has to be added</param>
		public void AddSignature(ISignature signature, IInterfaceIdentifier ifaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to remove the signature with given id.
		/// </summary>
		/// <param name="signatureID">the id of the signature that has to be removed</param>
		public void RemoveSignature(ISignatureIdentifier signatureID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to add a protocol to the interfaces that is specified by the given interface id.
		/// </summary>
		/// <param name="protocol">the protocol to be added</param>
		/// <param name="ifaceID">the id of the interface, to which the protocol has to be added</param>
		public void AddProtocol(IProtocol protocol, IInterfaceIdentifier ifaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to remove the protocol with given id. 
		/// </summary>
		/// <param name="protocolID">the id of the protocol that has to be removed</param>
		public void RemoveProtocol(IProtocolIdentifier protocolID)
		{
			throw new NotImplementedException();
		}

		//returns the row of the componenttable that is matching to the given component id.
		private ModelDataSet.ComponentsRow getComponentsRow(IComponentIdentifier compID)
		{
			if (compID == null) return null;

			DataRow[] result = ComponentsTable.Select("guid = '"+compID.Key+"'");
			if (result.Length != 0)
				return (ModelDataSet.ComponentsRow) result[0];
			
			return null;
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
