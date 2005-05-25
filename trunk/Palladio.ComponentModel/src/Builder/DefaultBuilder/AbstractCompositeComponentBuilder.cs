using System;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the composite component builder - methods that are available at all levels.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.18  2005/05/25 19:44:54  kelsaka
	/// - optimized usings
	/// - builders are now returning identifiers again
	///
	/// Revision 1.17  2005/05/25 18:15:27  kelsaka
	/// - added new methods to BuilderManager
	/// - use of new methods in example
	///
	/// Revision 1.16  2005/05/25 16:27:10  kelsaka
	/// - renamed former BuilderFactory / therefore removed former BuilderManager
	///
	/// Revision 1.15  2005/05/23 09:16:38  kelsaka
	/// - fix: not all builder methods for use in the deserialisation used the given
	/// identifier
	///
	/// Revision 1.14  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// Revision 1.13  2005/04/23 11:00:44  kelsaka
	/// - removed Init-Methods from AbstractBuilder - created constructors
	///
	/// Revision 1.12  2005/04/20 18:27:45  kelsaka
	/// - made classes internal
	/// - removed unused init-methods
	/// - use of InternalEntityIdentifier for creating new Identifiers
	///
	/// Revision 1.11  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.10  2005/04/20 13:26:43  kelsaka
	/// - added new Init-method implementation
	///
	/// Revision 1.9  2005/04/20 13:08:30  kelsaka
	/// - introduced IModelDataManagement
	/// - integrated use of the new interface
	///
	/// Revision 1.8  2005/04/15 08:29:45  kelsaka
	/// - fixed errors on xml-comments
	///
	/// Revision 1.7  2005/04/13 20:24:08  kelsaka
	/// - added enitity methods
	///
	/// Revision 1.6  2005/04/13 17:06:02  kelsaka
	/// - added further support for building signatures
	///
	/// Revision 1.5  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// Revision 1.4  2005/04/12 12:32:39  kelsaka
	/// - removed property to access typed IDs directly from the builders
	/// - renamed the property from 'SignaturID' to 'SignatureID' in ISignature
	///
	/// Revision 1.3  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.2  2005/04/08 14:40:55  kelsaka
	/// - added implementation and unit-tests
	///
	/// Revision 1.1  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// </pre>
	/// </remarks>
	internal abstract class AbstractCompositeComponentBuilder : AbstractEntityBuilder, ICompositeComponentBuilder
	{
		#region data

		protected IModelDataManager modelDataManager;
		protected IComponent component;
		protected IBuilderManager builderManager;

		#endregion

		#region constructors

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="component">The component to build.</param>
		/// <param name="builderManager">The factory to use for creating other builders.</param>
		public AbstractCompositeComponentBuilder(IModelDataManager modelDataManager, IComponent component, IBuilderManager builderManager)
			: base(component)
		{
			this.modelDataManager = modelDataManager;
			this.component = component;
			this.builderManager = builderManager;
		}

		#endregion

		#region methods

		/// <summary>
		/// Adds a <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name.</param>
		/// <returns>The builder for the newly created basic component.</returns>
		public IBasicComponentTypeLevelBuilder AddBasicComponent (string name)
		{
			return AddBasicComponent(new InternalEntityIdentifier().AsComponentIdentifier(), name);
		}

		/// <summary>
		/// Adds a new <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>) to the component model.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>Type level builder of the new basic component with the given ID.</returns>
		public IBasicComponentTypeLevelBuilder AddBasicComponent (IComponentIdentifier componentIdentifier, string name)
		{
			IComponent component = EntityFactory.CreateComponent(componentIdentifier, ComponentType.BASIC, name);
			modelDataManager.LowLevelBuilder.AddComponent(component, this.component.ComponentID);
			return builderManager.GetBasicComponentTypeLevelBuilder(component);
		}

		/// <summary>
		/// Adds an existing basic component <see cref="IComponent"/> (identified by component identifier).
		/// </summary>
		/// <param name="componentIdentifier">The id of the existing component.</param>
		/// <returns>Type level builder of the basic component with the given ID.</returns>
		public IBasicComponentTypeLevelBuilder AddExistingBasicComponent (IComponentIdentifier componentIdentifier)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Adds a <see cref="ComponentType.COMPOSITE"/> (Type <see cref="ICompositeComponentBuilder"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="ICompositeComponentTypeLevelBuilder"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder AddCompositeComponent (string name)
		{
			return AddCompositeComponent(new InternalEntityIdentifier().AsComponentIdentifier(), name);
		}

		/// <summary>
		/// Adds a new <see cref="ComponentType.COMPOSITE"/> (Type <see cref="ICompositeComponentBuilder"/>) to the component model.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>A <see cref="IComponent"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder AddCompositeComponent (IComponentIdentifier componentIdentifier, string name)
		{
			IComponent component = EntityFactory.CreateComponent(componentIdentifier, ComponentType.COMPOSITE, name);
			modelDataManager.LowLevelBuilder.AddComponent(component, this.component.ComponentID);
			return builderManager.GetCompositeComponentTypeLevelBuilder(component);
		}

		/// <summary>
		/// Adds an existing Composite Component <see cref="IComponent"/> (identified by component identifier).
		/// </summary>
		/// <param name="componentIdentifier">The id of the existing component.</param>
		/// <returns>Type level builder of the basic component with the given ID.</returns>
		public ICompositeComponentTypeLevelBuilder AddExistingCompositeComponent (IComponentIdentifier componentIdentifier)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Called to remove the component which belongs to the given id. All contained components
		/// (Type <see cref="ComponentType.COMPOSITE"/>) and
		/// all connections to and from this components are also removed.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		public void RemoveComponent (IComponentIdentifier componentId)
		{
			modelDataManager.LowLevelBuilder.RemoveComponent(componentId);
		}

		/// <summary>
		/// called to add an assemblyConnector from a requires interfaces of a component to a provides interface of 
		/// another component. Both components must have the same parent component or must be placed at the top level of the
		/// model.
		/// This method creates a new connection.
		/// </summary>
		/// <param name="connectionName">the connections name to be added</param>
		/// <param name="reqCompID">the id of the incoming component</param>
		/// <param name="reqIFaceID">the incoming components interface</param>
		/// <param name="provCompID">the id of the outgoing component</param>
		/// <param name="provIFaceID">the outgoing components interface</param>
		public void AddAssemblyConnector (string connectionName, IComponentIdentifier reqCompID,
			IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID,
			IInterfaceIdentifier provIFaceID)
		{
			AddAssemblyConnector(new InternalEntityIdentifier().AsConnectionIdentifier(),
				connectionName, reqCompID, reqIFaceID, provCompID, provIFaceID);
		}

		/// <summary>
		/// called to add an assemblyConnector from a requires interfaces of a component to a provides interface of 
		/// another component. Both components must have the same parent component or must be placed at the top level of the
		/// model.
		/// This method creates a new connection.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="connectionIdentifier">The identifier used for the new connection.</param>
		/// <param name="connectionName">The new connections name.</param>
		/// <param name="reqCompID">the id of the incoming component</param>
		/// <param name="reqIFaceID">the incoming components interface</param>
		/// <param name="provCompID">the id of the outgoing component</param>
		/// <param name="provIFaceID">the outgoing components interface</param>
		public void AddAssemblyConnector (IConnectionIdentifier connectionIdentifier, string connectionName, IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID)
		{
			IConnection connection = EntityFactory.CreateConnection(connectionIdentifier, connectionName);
			modelDataManager.LowLevelBuilder.AddAssemblyConnector(connection, reqCompID, reqIFaceID, provCompID, provIFaceID);
		}

		/// <summary>
		/// Called to add an existing interface as provided interface  to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddProvidesInterface (IInterfaceIdentifier ifaceIdentifier)
		{			
			modelDataManager.LowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, ifaceIdentifier, InterfaceRole.PROVIDES);
		}

		/// <summary>
		/// Called to add an existing interface as required interface to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			modelDataManager.LowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, ifaceIdentifier, InterfaceRole.REQUIRES);
		}

		/// <summary>
		/// Creates a new interface and adds it as provided interface to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddProvidesInterface (string interfaceName)
		{
			return AddProvidesInterface(new InternalEntityIdentifier().AsInterfaceIdentifier(),
				interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="ifaceIdentifier">The new interfaces identifier.</param>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddProvidesInterface (IInterfaceIdentifier ifaceIdentifier, string interfaceName)
		{
			IInterface iInterface = EntityFactory.CreateInterface(ifaceIdentifier, interfaceName);
			modelDataManager.LowLevelBuilder.AddInterface(iInterface);
			modelDataManager.LowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, iInterface.InterfaceID, InterfaceRole.PROVIDES);
			return builderManager.GetInterfaceTypeLevelBuilder(iInterface);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddRequiresInterface (string interfaceName)
		{
			return AddRequiresInterface(new InternalEntityIdentifier().AsInterfaceIdentifier(), 
				interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="ifaceIdentifier">The new interfaces identifier.</param>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier, string interfaceName)
		{
			IInterface iInterface = EntityFactory.CreateInterface(ifaceIdentifier, interfaceName);
			modelDataManager.LowLevelBuilder.AddInterface(iInterface);
			modelDataManager.LowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, iInterface.InterfaceID, InterfaceRole.REQUIRES);
			return builderManager.GetInterfaceTypeLevelBuilder(iInterface);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as provides interface (<see cref="InterfaceRole.PROVIDES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveProvidesInterface (IInterfaceIdentifier ifaceID)
		{
			modelDataManager.LowLevelBuilder.RemoveInterfaceFromComponent(this.component.ComponentID, ifaceID, InterfaceRole.PROVIDES);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as requires interface (<see cref="InterfaceRole.REQUIRES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveRequiresInterface (IInterfaceIdentifier ifaceID)
		{
			modelDataManager.LowLevelBuilder.RemoveInterfaceFromComponent(this.component.ComponentID, ifaceID, InterfaceRole.REQUIRES);
		}

		/// <summary>
		/// called to remove the connection that belongs to the given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		public void RemoveConnection (IConnectionIdentifier connectionID)
		{
			modelDataManager.LowLevelBuilder.RemoveConnection(connectionID);
		}

		/// <summary>
		/// called to add a delegationconnector from the provides interface of an component to the provides 
		/// interface of an inner component.
		/// Creates a new connector.
		/// </summary>
		/// <param name="connectionName">the new connections name</param>
		/// <param name="outerIFaceID">the id of the outer component</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the inner components interface</param>
		public void AddProvidesDelegationConnector (string connectionName, IInterfaceIdentifier outerIFaceID,
			IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID)
		{
			AddProvidesDelegationConnector(new InternalEntityIdentifier().AsConnectionIdentifier(),
				connectionName, outerIFaceID, innerCompID, innerIFaceID);
		}

		/// <summary>
		/// called to add a delegationconnector from the provides interface of an component to the provides 
		/// interface of an inner component.
		/// Creates a new connector.
		/// (use for deserialization.)
		/// </summary>
		/// <param name="connectionIdentifier">the id used for the new connection.</param>
		/// <param name="connectionName">the new connections name</param>
		/// <param name="outerIFaceID">the id of the outer component</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the inner components interface</param>
		public void AddProvidesDelegationConnector (IConnectionIdentifier connectionIdentifier, string connectionName,
			IInterfaceIdentifier outerIFaceID, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID)
		{
			IConnection connection = EntityFactory.CreateConnection(connectionIdentifier, connectionName);
			modelDataManager.LowLevelBuilder.AddProvidesDelegationConnector(connection,
				this.component.ComponentID, outerIFaceID, innerCompID, innerIFaceID);
		}

		/// <summary>
		/// called to add a delegationconnector from the requires interface of an component to the requires 
		/// interface of its parent component
		/// </summary>
		/// <param name="connectionName">the new connections name</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the inner components interface</param>
		/// <param name="outerIFaceID">the id of the outer component</param>
		public void AddRequiresDelegationConnector (string connectionName, IComponentIdentifier innerCompID,
			IInterfaceIdentifier innerIFaceID, IInterfaceIdentifier outerIFaceID)
		{
			IConnection connection = EntityFactory.CreateConnection(connectionName);
			modelDataManager.LowLevelBuilder.AddRequiresDelegationConnector(connection, innerCompID,
				innerIFaceID, this.component.ComponentID, outerIFaceID);
		}

		/// <summary>
		/// called to add a delegationconnector from the requires interface of an component to the requires 
		/// interface of its parent component
		/// (use for deserialization.)
		/// </summary>
		/// <param name="connectionIdentifier">the new connections id.</param>
		/// <param name="connectionName">the new connections name.</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the inner components interface</param>
		/// <param name="outerIFaceID">the id of the outer component</param>
		public void AddRequiresDelegationConnector (IConnectionIdentifier connectionIdentifier,
			string connectionName, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID,
			IInterfaceIdentifier outerIFaceID)
		{
			IConnection connection = EntityFactory.CreateConnection(connectionIdentifier, connectionName);
			modelDataManager.LowLevelBuilder.AddRequiresDelegationConnector(connection, innerCompID,
				innerIFaceID, this.component.ComponentID, outerIFaceID);
		}

		#endregion

		#region Properties

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public IComponent Component
		{
			get { return this.component; }
		}

		/// <summary>
		/// Accesses the identifier of the actual instance.
		/// </summary>
		public IComponentIdentifier ComponentIdentifier
		{
			get { throw new NotImplementedException (); }
		}

		#endregion
	}
}
