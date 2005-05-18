using System;
using System.Collections;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.BuilderConstraints.DefaultConstraints.TypeLevelConstraints
{

	/// <summary>
	/// Default constraints for composite components at the type level. This constraints are used always
	/// as they are the neccessary for a valid and consistent static structure of the component model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.2  2005/05/18 09:47:38  kelsaka
	/// - added BC default constraints implementation
	/// - fixed error in unit tests / added new test-case
	///
	/// Revision 1.1  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// </pre>
	/// </remarks>
	public class CompositeComponentTypeLevelConstraint : ICompositeComponentTypeLevelBuilder
	{
		#region data
		
		private ICompositeComponentTypeLevelBuilder compositeComponentBuilderSuccessor;
		private IModelDataManager modelDataManager;
		private IComponent component;

		#endregion

		#region constructors

		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="modelDataManager">The model data manager to use for executing e. g. queries.</param>
		public CompositeComponentTypeLevelConstraint(IModelDataManager modelDataManager)
		{
			this.modelDataManager = modelDataManager;
		}

		/// <summary>
		/// Internal constructor.
		/// </summary>
		/// <param name="modelDataManager">The model data manager to use for executing e. g. queries.</param>
		/// <param name="component">The component this instance is constraint for.</param>
		private CompositeComponentTypeLevelConstraint(IModelDataManager modelDataManager, IComponent component)
		{
			this.modelDataManager = modelDataManager;
			this.component = component;
		}

		#endregion

		/// <summary>
		/// Adds a new <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name.</param>
		/// <returns>Type level builder of the new basic component.</returns>
		public IBasicComponentTypeLevelBuilder AddBasicComponent (string name)
		{
			//this.modelDataManager.Query.

			/*// create a arraylist from the list im required interfaces to allow
			// easy searching.
			ArrayList interfaceIdentifierList = new ArrayList(this.modelDataManager.Query.QueryTypeLevel
							.QueryBasicComponent(component.ComponentID).GetRequiresInterfaceIDs());
			
			if(!interfaceIdentifierList.Contains(ifaceID))
			{			
				throw new InterfaceNotFromComponentException(this.component.ComponentID, ifaceID);
			}
			else
			{
				this.basicComponentBuilderSuccessor.RemoveRequiresInterface(ifaceID);
			}*/	

			return compositeComponentBuilderSuccessor.AddBasicComponent(name);
		}

		/// <summary>
		/// Adds a new <see cref="ComponentType.BASIC"/> (Type <see cref="IComponent"/>) to the component model.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>Type level builder of the new basic component with the given ID.</returns>
		public IBasicComponentTypeLevelBuilder AddBasicComponent (IComponentIdentifier componentIdentifier, string name)
		{
			return compositeComponentBuilderSuccessor.AddBasicComponent(componentIdentifier, name);
		}

		/// <summary>
		/// Adds a new <see cref="ComponentType.COMPOSITE"/> (Type <see cref="ICompositeComponentBuilder"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="IComponent"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder AddCompositeComponent (string name)
		{
			return compositeComponentBuilderSuccessor.AddCompositeComponent(name);
		}

		/// <summary>
		/// Adds a new <see cref="IComponent"/> (Type <see cref="ComponentType.COMPOSITE"/>) to the component model.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>A <see cref="ICompositeComponentBuilder"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder AddCompositeComponent (IComponentIdentifier componentIdentifier, string name)
		{
			return compositeComponentBuilderSuccessor.AddCompositeComponent(componentIdentifier, name);
		}

		/// <summary>
		/// Called to remove the component which belongs to the given id. All contained components
		/// (Type <see cref="ComponentType.COMPOSITE"/>) and
		/// all connections to and from this components are also removed.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		public void RemoveComponent (IComponentIdentifier componentId)
		{
			compositeComponentBuilderSuccessor.RemoveComponent(componentId);
		}

		/// <summary>
		/// called to add an assemblyConnector from a requires interfaces of a component to a provides interface of 
		/// another component. Both components must have the same parent component or must be placed at the top level of the
		/// model.
		/// This method creates a new connection.
		/// </summary>
		/// <param name="connectionName">the new connections name</param>
		/// <param name="reqCompID">the id of the incoming component</param>
		/// <param name="reqIFaceID">the incoming components interface</param>
		/// <param name="provCompID">the id of the outgoing component</param>
		/// <param name="provIFaceID">the outgoing components interface</param>
		public void AddAssemblyConnector (string connectionName, IComponentIdentifier reqCompID,
			IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID,
			IInterfaceIdentifier provIFaceID)
		{
			compositeComponentBuilderSuccessor.AddAssemblyConnector(connectionName, reqCompID, reqIFaceID,
				provCompID, provIFaceID);
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
		public void AddAssemblyConnector (IConnectionIdentifier connectionIdentifier, string connectionName,
			IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID,
			IInterfaceIdentifier provIFaceID)
		{
			compositeComponentBuilderSuccessor.AddAssemblyConnector(connectionIdentifier, connectionName,
				reqCompID, reqIFaceID, provCompID, provIFaceID);
		}

		/// <summary>
		/// Called to add an existing interface as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddProvidesInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			compositeComponentBuilderSuccessor.AddProvidesInterface(ifaceIdentifier);
		}

		/// <summary>
		/// Called to add an existing interface as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			compositeComponentBuilderSuccessor.AddRequiresInterface(ifaceIdentifier);
		}

		/// <summary>
		/// Creates a new interface and adds it as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddProvidesInterface (string interfaceName)
		{
			return compositeComponentBuilderSuccessor.AddProvidesInterface(interfaceName);
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
			return compositeComponentBuilderSuccessor.AddProvidesInterface(ifaceIdentifier, interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddRequiresInterface (string interfaceName)
		{
			return compositeComponentBuilderSuccessor.AddRequiresInterface(interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface (<see cref="IInterfaceTypeLevelBuilder"/>) to the actual component.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="ifaceIdentifier">The new interfaces identifier.</param>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="InterfaceRole.REQUIRES"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier, string interfaceName)
		{
			return compositeComponentBuilderSuccessor.AddRequiresInterface(ifaceIdentifier, interfaceName);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as provided interface (<see cref="InterfaceRole.PROVIDES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveProvidesInterface (IInterfaceIdentifier ifaceID)
		{
			compositeComponentBuilderSuccessor.RemoveProvidesInterface(ifaceID);
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
			compositeComponentBuilderSuccessor.RemoveRequiresInterface(ifaceID);
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
			compositeComponentBuilderSuccessor.AddProvidesDelegationConnector(connectionName, outerIFaceID,
				innerCompID, innerIFaceID);
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
		public void AddProvidesDelegationConnector (IConnectionIdentifier connectionIdentifier, 
			string connectionName, IInterfaceIdentifier outerIFaceID, IComponentIdentifier innerCompID,
			IInterfaceIdentifier innerIFaceID)
		{
			compositeComponentBuilderSuccessor.AddProvidesDelegationConnector(connectionIdentifier, connectionName,
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
			compositeComponentBuilderSuccessor.AddRequiresDelegationConnector(connectionName, innerCompID,
				innerIFaceID, outerIFaceID);
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		public ICompositeComponentImplementationLevelBuilder ImplementationLevelBuilder
		{
			get
			{
				return compositeComponentBuilderSuccessor.ImplementationLevelBuilder;
			}
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
			compositeComponentBuilderSuccessor.AddRequiresDelegationConnector(connectionIdentifier,
				connectionName, innerCompID, innerIFaceID, outerIFaceID);
		}

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public IComponent Component
		{
			get
			{
				return compositeComponentBuilderSuccessor.Component;
			}
		}

		/// <summary>
		/// called to remove the connection that belongs to the given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		public void RemoveConnection (IConnectionIdentifier connectionID)
		{
			compositeComponentBuilderSuccessor.RemoveConnection(connectionID);
		}

		#region constraint-management
		
		/// <summary>
		/// The child builder to call for each method defined in the builder interface.
		/// </summary>
		public ICompositeComponentTypeLevelBuilder ChildBuilder
		{
			set
			{
				this.compositeComponentBuilderSuccessor = value;
			}
		}

		/// <summary>
		/// Clones the actual builder / constraints instance except the created / supervised
		/// component model entity.
		/// </summary>
		/// <param name="component">The component model entity that has to be builder /
		/// supervised.</param>
		/// <returns>A copy of the actual builder / constraint.</returns>
		public ICompositeComponentTypeLevelBuilder Clone (IComponent component)
		{
			return new CompositeComponentTypeLevelConstraint(modelDataManager, component);
		}

		#endregion
	}
}
