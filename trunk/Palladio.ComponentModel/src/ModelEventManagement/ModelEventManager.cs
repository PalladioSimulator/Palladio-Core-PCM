using System.Collections;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.Identifier;

namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// The ModelEventManager is used to manage the event handling in the componentmodel. There are two interfaces 
	/// returned by the manager, one that provides the events and one that is used to register the entities of the
	/// componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/04/05 14:23:59  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.3  2005/04/04 16:27:28  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.2  2005/03/31 11:02:03  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.1  2005/03/29 13:05:37  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class ModelEventManager : IModelEventManager,IEventInterface,IEntityRegistration
	{
		#region data

		//holds the events of the static view
		private StaticViewEvents staticViewEvents;

		//holds the event structures for the entities
		private Hashtable eventStructures;

		//holds the dataset
		private ModelDataSet modelDataset;

		//holds the hashtable with the entities
		private EntityHashtable entityHashtable;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new ModelEventManager using the given dataset and hashtable.
		/// </summary>
		/// <param name="modelDataset">the dataset</param>
		/// <param name="ht">the hashtable</param>
		public ModelEventManager(ModelDataSet modelDataset,EntityHashtable ht)
		{
            this.modelDataset = modelDataset;
			this.entityHashtable = ht;
			this.eventStructures = new Hashtable();
			this.staticViewEvents = new StaticViewEvents();
		}

		#endregion

		#region member of IEntityRegistration

		/// <summary>
		/// called to register a component.
		/// </summary>
		/// <param name="component">the component which has to be registerted</param>
		/// <param name="parentComponent">the parent component</param>
		/// <exception cref="EntityNotFoundException">the parent component could not be found in cm.</exception>
		public void RegisterComponent(IComponent component, IComponentIdentifier parentComponent)
		{
			ComponentEvents compEv;
			if (component.Type == ComponentType.BASIC)
				compEv = new BasicComponentEvents(component);
			else
				compEv = new CompositeComponentEvents(component);

			eventStructures.Add(component.ID,compEv);

            if (parentComponent != null)
				GetCompositeComponentEvents(parentComponent).
					NotifyComponentAdded(this,new ComponentBuildEventArgs(component));
			else
				this.staticViewEvents.NotifyComponentAdded(this,new ComponentBuildEventArgs(component));
		}

		/// <summary>
		/// called to unregister the given component from the event manager 
		/// </summary>
		/// <param name="component">the component</param>
		/// <param name="parentComponentID">the parent component or null, if the component is placed 
		/// in the top level of the model</param>
		/// <exception cref="EntityNotFoundException">the parent component could not be found in cm.</exception>
		public void UnregisterComponent(IComponent component, IComponentIdentifier parentComponentID)
		{
			this.eventStructures.Remove(component.ID);
			if (parentComponentID == null)
				this.GetStaticViewEvents().NotifyComponentRemoved(this,new ComponentBuildEventArgs(component));
			else
				this.GetCompositeComponentEvents(parentComponentID).
					NotifyComponentRemoved(this,new ComponentBuildEventArgs(component));			
		}

		/// <summary>
		/// called to register an interface.
		/// </summary>
		/// <param name="iface">the interface to be registered</param>
		public void RegisterInterface(IInterface iface)
		{
			eventStructures.Add(iface.ID,new InterfaceEvents(iface));
			this.staticViewEvents.NotifyInterfaceAdded(this,new InterfaceBuildEventArgs(iface));
		}

		/// <summary>
		/// called to unregister the interface from the componentmodel
		/// </summary>
		/// <param name="iface"></param>
		public void UnregisterInterface(IInterface iface)
		{
			this.eventStructures.Remove(iface.ID);
			this.GetStaticViewEvents().NotifyInterfaceRemoved(this,new InterfaceBuildEventArgs(iface));
		}

		/// <summary>
		/// called after an interface has bound to a component to notify the components eventlistener.
		/// </summary>
		/// <param name="componentIdentifier">the id of the component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		/// <param name="role">the role of the interface in the component</param>
		/// <exception cref="EntityNotFoundException">the component or interface could not be found in cm.</exception>
		public void RegisterInterfaceToComponent(IComponentIdentifier componentIdentifier, 
			IInterfaceIdentifier ifaceIdentifier, InterfaceRole role)
		{
			if (!entityHashtable.ContainsKey(ifaceIdentifier.Key))
				throw new EntityNotFoundException(ifaceIdentifier);

			if (role == InterfaceRole.PROVIDES)
				this.GetComponentEvents(componentIdentifier).NotifyProvidesInterfaceAdded(this,
					new InterfaceBuildEventArgs((IInterface) entityHashtable[ifaceIdentifier]));
			else
				this.GetComponentEvents(componentIdentifier).NotifyRequiresInterfaceAdded(this,
					new InterfaceBuildEventArgs((IInterface) entityHashtable[ifaceIdentifier]));

		}

		/// <summary>
		/// called to unregister an interface from a component.
		/// </summary>
		/// <param name="compID">the id of the component</param>
		/// <param name="ifaceID">the id of the interface</param>
		public void UnregisterInterfaceFromComponent(IComponentIdentifier compID, IInterfaceIdentifier ifaceID)
		{
			IInterface iface = (IInterface) entityHashtable[ifaceID];
			this.GetComponentEvents(compID).NotifyInterfaceRemoved(this,new InterfaceBuildEventArgs(iface));
		}

		/// <summary>
		/// called to register a signature.
		/// </summary>
		/// <param name="signature">the signature which has to be registered</param>
		/// <param name="ifaceID">the interface, to which the signature belongs</param>
		/// <exception cref="EntityNotFoundException">the interface could not be found in cm.</exception>
		public void RegisterSignature(ISignature signature, IInterfaceIdentifier ifaceID)
		{
			eventStructures.Add(signature.ID,new SignatureEvents(signature));
			this.GetInterfaceEvents(ifaceID).NotifySignatureAddedEvent(this,new SignatureBuildEventArgs(signature));
		}

		/// <summary>
		/// called to unregister the signature
		/// </summary>
		/// <param name="signature">the signature</param>
		/// <param name="ifaceID">the iface, to which the signature belongs</param>
		public void UnregisterSignature(ISignature signature, IInterfaceIdentifier ifaceID)
		{
			this.eventStructures.Remove(signature.ID);
			this.GetInterfaceEvents(ifaceID).NotifySignatureRemovedEvent(this,new SignatureBuildEventArgs(signature));
		}

		/// <summary>
		/// called to register a protocol.
		/// </summary>
		/// <param name="protocol">the protocol to be registered</param>
		/// <param name="ifaceID">the interface, to which the protocol belongs</param>
		/// <exception cref="EntityNotFoundException">the interface could not be found in cm.</exception>
		public void RegisterProtocol(IProtocol protocol, IInterfaceIdentifier ifaceID)
		{
			this.GetInterfaceEvents(ifaceID).NotifyProtocolAddedEvent(this,new ProtocolBuildEventArgs(protocol));
		}

		/// <summary>
		/// called to unregister a protocol.
		/// </summary>
		/// <param name="protocol">the protocol to be registered</param>
		/// <param name="ifaceID">the interface, to which the protocol belongs</param>
		public void UnregisterProtocol(IProtocol protocol, IInterfaceIdentifier ifaceID)
		{
			this.eventStructures.Remove(protocol.ID);
			this.GetInterfaceEvents(ifaceID).NotifyProtocolRemovedEvent(this,new ProtocolBuildEventArgs(protocol));
		}

		/// <summary>
		/// called to register a reguires delegation connector.
		/// </summary>
		/// <param name="connection">the connector</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the interface of the inner component</param>
		/// <param name="outerCompID">the id of the outer component</param>
		/// <param name="outerIFaceID">the id of the interface of the outer component</param>
		/// <exception cref="EntityNotFoundException">one of the entities could not be found.</exception>
		public void RegisterRequiresDelegation(IConnection connection, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID, IComponentIdentifier outerCompID, IInterfaceIdentifier outerIFaceID)
		{
			this.eventStructures.Add(connection.ID,new ConnectionEvents(connection));
			this.GetCompositeComponentEvents(outerCompID).NotifyDelegationConnectorAdded(this,
				new DelegationConnectorBuildEventArgs(connection,innerCompID,innerIFaceID,outerCompID,outerIFaceID,
				InterfaceRole.REQUIRES));
		}

		/// <summary>
		/// called to register a provides delegation connector.
		/// </summary>
		/// <param name="connection">the connector</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the interface of the inner component</param>
		/// <param name="outerCompID">the id of the outer component</param>
		/// <param name="outerIFaceID">the id of the interface of the outer component</param>
		/// <exception cref="EntityNotFoundException">one of the entities could not be found.</exception>
		public void RegisterProvidesDelegation(IConnection connection, IComponentIdentifier outerCompID, IInterfaceIdentifier outerIFaceID, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID)
		{
			this.eventStructures.Add(connection.ID,new ConnectionEvents(connection));
			this.GetCompositeComponentEvents(outerCompID).NotifyDelegationConnectorAdded(this,
				new DelegationConnectorBuildEventArgs(connection,innerCompID,innerIFaceID,outerCompID,outerIFaceID,
				InterfaceRole.PROVIDES));
		}

		/// <summary>
		/// called to register a new assembly connector.
		/// </summary>
		/// <param name="connection">the connector</param>
		/// <param name="reqCompID">the id of the requiring component</param>
		/// <param name="reqIFaceID">the id of the requiring components interface</param>
		/// <param name="provCompID">the id of the providing component</param>
		/// <param name="provIFaceID">the id of the providing components interface</param>
		/// <exception cref="EntityNotFoundException">the parent component could not be found.</exception>
		public void RegisterAssemblyConnection(IConnection connection, IComponentIdentifier reqCompID, 
							IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID)
		{
			this.eventStructures.Add(connection.ID,new ConnectionEvents(connection));
			ModelDataSet.ComponentsRow compRow = modelDataset.Components.FindByguid(reqCompID.Key);
			if (compRow.parentComponent == null)
				this.staticViewEvents.NotifyAssemblyConnectorAdded(this,
					new AssemblyConnectorBuildEventArgs(connection,provCompID,provIFaceID,reqCompID,reqIFaceID));
			else
			{
				IComponent parentC = (IComponent) entityHashtable[compRow.parentComponent];
				this.GetCompositeComponentEvents(parentC.ComponentID).NotifyAssemblyConnectorAdded(this,
					new AssemblyConnectorBuildEventArgs(connection,provCompID,provIFaceID,reqCompID,reqIFaceID));
			}
		}

		/// <summary>
		/// called to unregister an assembly connector.
		/// </summary>
		/// <param name="connection">the connector</param>
		/// <param name="compositeCompID">the composite component, in which this connection is placed or null,
		/// if this connection belongs to the top level of the model.</param>
		public void UnregisterConnection(IConnection connection, IComponentIdentifier compositeCompID)
		{
			this.eventStructures.Remove(connection.ID);
			if (compositeCompID == null)
				this.GetStaticViewEvents().NotifyAssemblyConnectorRemoved(this,new ConnectorRemovedEventArgs(connection));
			else
				this.GetCompositeComponentEvents(compositeCompID).
					NotifyConnectorRemoved(this,new ConnectorRemovedEventArgs(connection));
		}

		#endregion

		#region member of IEventInterface

		/// <summary>
		/// called to register to one of the static view's events
		/// </summary>
		/// <returns>the class that holds the events of the static view</returns>
		public StaticViewEvents GetStaticViewEvents()
		{
			return this.staticViewEvents;
		}

		/// <summary>
		/// called to register to one of the events of the componentmodels entities
		/// </summary>
		/// <param name="entityID">the id of the entity</param>
		/// <returns>the class that holds the events of an entity</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		public EntityEvents GetEntityEvents(IIdentifier entityID)
		{
			this.EntityEventStructureExists(entityID);
			return (EntityEvents) eventStructures[entityID];
		}

		/// <summary>
		/// called to register to one of the events of a component
		/// </summary>
		/// <param name="componentID">the id of the component</param>
		/// <returns>the class that holds the events of a component</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		public ComponentEvents GetComponentEvents(IComponentIdentifier componentID)
		{
			this.EntityEventStructureExists(componentID);
			return (ComponentEvents) eventStructures[componentID];
		}

		/// <summary>
		/// called to register to one of the events of a composite component
		/// </summary>
		/// <param name="ccID">the id of the composite component</param>
		/// <returns>the class that holds the events of a composite component</returns>
		/// <exception cref="WrongComponentTypeException">the entity with given id could not be found in cm</exception>
		/// <exception cref="EntityNotFoundException">the component with given id is not a composite component</exception>
		public CompositeComponentEvents GetCompositeComponentEvents(IComponentIdentifier ccID)
		{
			this.EntityEventStructureExists(ccID);
			return (CompositeComponentEvents) eventStructures[ccID];
		}

		/// <summary>
		/// called to register to one of the events of a basic component
		/// </summary>
		/// <param name="bcID">the id of the basic component</param>
		/// <returns>the class that holds the events of a basic component</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		/// <exception cref="WrongComponentTypeException">the component with given id is not a basic component</exception>
		public BasicComponentEvents GetBasicComponentEvents(IComponentIdentifier bcID)
		{
			this.EntityEventStructureExists(bcID);
			return (BasicComponentEvents) eventStructures[bcID];
		}

		/// <summary>
		/// called to register to one of the events of an interface
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>the class that holds the events of an interface</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		public InterfaceEvents GetInterfaceEvents(IInterfaceIdentifier ifaceID)
		{
			this.EntityEventStructureExists(ifaceID);
			return (InterfaceEvents) eventStructures[ifaceID];
		}

		/// <summary>
		/// called to register to one of the events of a signature
		/// </summary>
		/// <param name="sigID">the id of the signature</param>
		/// <returns>the class that holds the events of a signature</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		public SignatureEvents GetSignatureEvents(ISignatureIdentifier sigID)
		{
			this.EntityEventStructureExists(sigID);
			return (SignatureEvents) eventStructures[sigID];
		}

		/// <summary>
		/// called to register to one of the events of a connection
		/// </summary>
		/// <param name="conID">the id of the connection</param>
		/// <returns>the class that holds the events of a connection</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		public ConnectionEvents GetConnectionEvents(IConnectionIdentifier conID)
		{
			this.EntityEventStructureExists(conID);
			return (ConnectionEvents) eventStructures[conID];
		}

		#endregion

		#region member of IModelEventManager

		/// <summary>
		/// returns the interface to all component model events. 
		/// </summary>
		public IEventInterface EventInterface
		{
			get
			{
				return this;
			}
		}

		/// <summary>
		/// returns the registration part of the manager. 
		/// </summary>
		public IEntityRegistration EntityRegistration
		{
			get
			{
				return this;
			}
		}

		#endregion

		#region private methods

		//checks whether an event structure for the given id exits in ht.
		private void EntityEventStructureExists(IIdentifier id)
		{
			if (!eventStructures.ContainsKey(id))
				throw new EntityNotFoundException(id);
		}

		#endregion
	}
}
