using System;
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
		}

		#endregion

		#region member of IEntityRegistration

		/// <summary>
		/// called to register a component.
		/// </summary>
		/// <param name="component">the component which has to be registerted</param>
		/// <param name="parentComponent">the parent component</param>
		public void RegisterComponent(IComponent component, IComponentIdentifier parentComponent)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to register an interface.
		/// </summary>
		/// <param name="iface">the interface to be registered</param>
		public void RegisterInterface(IInterface iface)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called after an interface has bound to a component to notify the components eventlistener.
		/// </summary>
		/// <param name="componentIdentifier">the id of the component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		/// <param name="role">the role of the interface in the component</param>
		public void RegisterInterfaceToComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier, InterfaceRole role)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to register a signature.
		/// </summary>
		/// <param name="signature">the signature which has to be registered</param>
		/// <param name="ifaceID">the interface, to which the signature belongs</param>
		public void RegisterSignature(ISignature signature, IInterfaceIdentifier ifaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to register a protocol.
		/// </summary>
		/// <param name="protocol">the protocol to be registered</param>
		/// <param name="ifaceID">the interface, to which the protocol belongs</param>
		public void RegisterProtocol(IProtocol protocol, IInterfaceIdentifier ifaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to register a reguires delegation connector.
		/// </summary>
		/// <param name="connection">the connector</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the interface of the inner component</param>
		/// <param name="outerCompID">the id of the outer component</param>
		/// <param name="outerIFaceID">the id of the interface of the outer component</param>
		public void RegisterRequiresDelegation(IConnection connection, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID, IComponentIdentifier outerCompID, IInterfaceIdentifier outerIFaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to register a provides delegation connector.
		/// </summary>
		/// <param name="connection">the connector</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the interface of the inner component</param>
		/// <param name="outerCompID">the id of the outer component</param>
		/// <param name="outerIFaceID">the id of the interface of the outer component</param>
		public void RegisterProvidesDelegation(IConnection connection, IComponentIdentifier outerCompID, IInterfaceIdentifier outerIFaceID, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to register a new assembly connector.
		/// </summary>
		/// <param name="connection">the connector</param>
		/// <param name="reqCompID">the id of the requiring component</param>
		/// <param name="reqIFaceID">the id of the requiring components interface</param>
		/// <param name="provCompID">the id of the providing component</param>
		/// <param name="provIFaceID">the id of the providing components interface</param>
		public void RegisterAssemblyConnection(IConnection connection, IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called if one of the componentmodels entities has been removed
		/// </summary>
		/// <param name="id">the id of the identifier</param>
		public void EntityRemoved(IIdentifier id)
		{
			throw new NotImplementedException();
		}

		#endregion

		#region member of IEventInterface

		/// <summary>
		/// called to register to one of the static view's events
		/// </summary>
		/// <returns>the class that holds the events of the static view</returns>
		public StaticViewEvents GetStaticViewEvents()
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to register to one of the events of the componentmodels entities
		/// </summary>
		/// <param name="entityID">the id of the entity</param>
		/// <returns>the class that holds the events of an entity</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		public EntityEvents GetEntityEvents(IIdentifier entityID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to register to one of the events of a component
		/// </summary>
		/// <param name="componentID">the id of the component</param>
		/// <returns>the class that holds the events of a component</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		public ComponentEvents GetComponentEvents(IComponentIdentifier componentID)
		{
			throw new NotImplementedException();
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
			throw new NotImplementedException();
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
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to register to one of the events of an interface
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>the class that holds the events of an interface</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		public InterfaceEvents GetInterfaceEvents(IInterfaceIdentifier ifaceID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to register to one of the events of a signature
		/// </summary>
		/// <param name="sigID">the id of the signature</param>
		/// <returns>the class that holds the events of a signature</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		public SignatureEvents GetSignatureEvents(ISignatureIdentifier sigID)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// called to register to one of the events of a connection
		/// </summary>
		/// <param name="conID">the id of the connection</param>
		/// <returns>the class that holds the events of a connection</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		public ConnectionEvents GetConnectionEvents(IConnectionIdentifier conID)
		{
			throw new NotImplementedException();
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
	}
}
