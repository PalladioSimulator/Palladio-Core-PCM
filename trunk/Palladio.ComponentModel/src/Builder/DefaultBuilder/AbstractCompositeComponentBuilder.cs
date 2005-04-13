using System;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the composite component builder - methods that are available at all levels.
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
	public abstract class AbstractCompositeComponentBuilder : AbstractEntityBuilder, ICompositeComponentBuilder
	{
		#region data

		private ILowLevelBuilder lowLevelBuilder;
		private IComponent component;

		#endregion

		#region methods

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="component">The component to build.</param>
		public void Init(ILowLevelBuilder lowLevelBuilder, IComponent component)
		{
			this.lowLevelBuilder = lowLevelBuilder;
			this.component = component;
			base.Init(component);
		}

		/// <summary>
		/// TODO: useful for builder?
		/// Creates a new <see cref="IComponentBuilder"/>, which allows to create new components.
		/// </summary>
		/// <param name="component">The component to add to the actual composite component.</param>
		/// <returns>The new ComponentBuilder.</returns		
		public IComponentBuilder AddComponent (IComponent component)
		{
			lowLevelBuilder.AddComponent(component, this.component.ComponentID);
			//TODO: use CC-Builder or own Builder?
			return new DefaultCompositeComponentTypeLevelBuilder(lowLevelBuilder, component);
		}

		/// <summary>
		/// Adds a <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name.</param>
		/// <returns>The builder for the newly created basic component.</returns>
		public IBasicComponentTypeLevelBuilder AddBasicComponent (string name)
		{
			IComponent component = EntityFactory.CreateComponent(ComponentType.BASIC, name);
			lowLevelBuilder.AddComponent(component, this.component.ComponentID);
			return new DefaultBasicComponentTypeLevelBuilder(lowLevelBuilder, component);
		}

		/// <summary>
		/// Adds a <see cref="ComponentType.COMPOSITE"/> (Type <see cref="ICompositeComponentBuilder"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="ICompositeComponentTypeLevelBuilder"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder AddCompositeComponent (string name)
		{
			IComponent component = EntityFactory.CreateComponent(ComponentType.COMPOSITE, name);
			lowLevelBuilder.AddComponent(component, this.component.ComponentID);
			return new DefaultCompositeComponentTypeLevelBuilder(lowLevelBuilder, component);
		}

		/// <summary>
		/// Called to remove the component which belongs to the given id. All contained components
		/// (Type <see cref="ComponentType.COMPOSITE"/>) and
		/// all connections to and from this components are also removed.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		public void RemoveComponent (IComponentIdentifier componentId)
		{
			//TODO: allow only sub-components. Check wether ID exists.
			lowLevelBuilder.RemoveComponent(componentId);
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
		public void AddAssemblyConnector (string connectionName, IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID)
		{
			IConnection connection = EntityFactory.CreateConnection(connectionName);
			lowLevelBuilder.AddAssemblyConnector(connection, reqCompID, reqIFaceID, provCompID, provIFaceID);
		}

		/// <summary>
		/// Called to add an existing interface as provided interface  to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddProvidesInterface (IInterfaceIdentifier ifaceIdentifier)
		{			
			lowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, ifaceIdentifier, InterfaceRole.PROVIDES);
		}

		/// <summary>
		/// Called to add an existing interface as required interface to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			lowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, ifaceIdentifier, InterfaceRole.REQUIRES);
		}

		/// <summary>
		/// Creates a new interface and adds it as provided interface to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddProvidesInterface (string interfaceName)
		{
			IInterface iInterface = EntityFactory.CreateInterface(interfaceName);
			lowLevelBuilder.AddInterface(iInterface);
			lowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, iInterface.InterfaceID, InterfaceRole.PROVIDES);
			return new DefaultInterfaceTypeLevelBuilder(lowLevelBuilder, iInterface);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddRequiresInterface (string interfaceName)
		{
			IInterface iInterface = EntityFactory.CreateInterface(interfaceName);
			lowLevelBuilder.AddInterface(iInterface);
			lowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, iInterface.InterfaceID, InterfaceRole.REQUIRES);
			return new DefaultInterfaceTypeLevelBuilder(lowLevelBuilder, iInterface);
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
			lowLevelBuilder.RemoveInterfaceFromComponent(this.component.ComponentID, ifaceID, InterfaceRole.PROVIDES);
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
			lowLevelBuilder.RemoveInterfaceFromComponent(this.component.ComponentID, ifaceID, InterfaceRole.REQUIRES);
		}

		/// <summary>
		/// called to remove the connection that belongs to the given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		public void RemoveConnection (IConnectionIdentifier connectionID)
		{
			lowLevelBuilder.RemoveConnection(connectionID);
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
			IConnection connection = EntityFactory.CreateConnection(connectionName);
			lowLevelBuilder.AddProvidesDelegationConnector(connection, this.component.ComponentID,
			                                               outerIFaceID, innerCompID, innerIFaceID);
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
			lowLevelBuilder.AddRequiresDelegationConnector(connection, innerCompID, innerIFaceID,
			                                               this.component.ComponentID, outerIFaceID);
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

		#endregion
	}
}
