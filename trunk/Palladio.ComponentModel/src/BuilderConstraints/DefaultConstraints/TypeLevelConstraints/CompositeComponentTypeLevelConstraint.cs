using System;
using System.Collections;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Exceptions;
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
	/// Revision 1.9  2005/05/25 18:15:27  kelsaka
	/// - added new methods to BuilderManager
	/// - use of new methods in example
	///
	/// Revision 1.8  2005/05/21 17:12:17  kelsaka
	/// - added new exception for use with signatures
	/// - finished adding constraints for the type level
	///
	/// Revision 1.7  2005/05/21 15:23:29  kelsaka
	/// - added further constraints
	///
	/// Revision 1.6  2005/05/20 18:08:39  kelsaka
	/// - added comments
	///
	/// Revision 1.5  2005/05/20 17:27:23  kelsaka
	/// - added further constraints
	/// - added new exception - for use in constraints
	///
	/// Revision 1.4  2005/05/18 13:45:36  kelsaka
	/// - added further constraint
	///
	/// Revision 1.3  2005/05/18 10:33:46  kelsaka
	/// - added default constraints implementation
	/// - added new test-case
	///
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
			return compositeComponentBuilderSuccessor.AddBasicComponent(name);
		}

		/// <summary>
		/// Adds a new <see cref="ComponentType.BASIC"/> (Type <see cref="IComponent"/>) to the component model.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>Type level builder of the new basic component with the given ID.</returns>
		/// <remarks>Grants that the component identifier is used nowhere else. The given
		/// identifier is not allowed to exits in the component model, otherwise a exception
		/// will be thrown.</remarks>
		/// <exception cref="EntityAlreadyExistsException">Is thrown if the component identifier
		/// already exists in the component model (the id is not new).</exception>
		public IBasicComponentTypeLevelBuilder AddBasicComponent (IComponentIdentifier componentIdentifier, string name)
		{			
			if(this.modelDataManager.Query.QueryEntities.ContainsEntity(componentIdentifier))
			{			
				throw new EntityAlreadyExistsException(componentIdentifier,
					"The component can not be created with the given identifier as is the identifier already exists.");
			}
			else
			{
				return compositeComponentBuilderSuccessor.AddBasicComponent(componentIdentifier, name);
			}
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
		/// <remarks>Grants that the component identifier is used nowhere else. The given
		/// identifier is not allowed to exits in the component model, otherwise a exception
		/// will be thrown.</remarks>
		/// <exception cref="EntityAlreadyExistsException">Is thrown if the component identifier
		/// already exists in the component model (the id is not new).</exception>
		public ICompositeComponentTypeLevelBuilder AddCompositeComponent (IComponentIdentifier componentIdentifier, string name)
		{
			if(this.modelDataManager.Query.QueryEntities.ContainsEntity(componentIdentifier))
			{			
				throw new EntityAlreadyExistsException(componentIdentifier,
					"The component can not be created with the given identifier as is the identifier already exists.");
			}
			else
			{
				return compositeComponentBuilderSuccessor.AddCompositeComponent(componentIdentifier, name);
			}			
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
		/// <remarks>Only internal components of the actual composite component can be removed.
		/// Otherwise a exception will be thrown.</remarks>
		/// <exception cref="ComponentNotFoundException">Thrown if the actual composite
		/// component does not have a internal component with the given component identifier.
		/// </exception>
		public void RemoveComponent (IComponentIdentifier componentId)
		{
			if(!this.modelDataManager.Query.
				QueryTypeLevel.QueryCompositeComponent(this.component.ComponentID).IsChildren(componentId))
			{			
				throw new ComponentNotFoundException(componentId,
					"The given component can not be removed from the actual composite component as the"
					+ " composite component does not have a interal component with the given identifier.");
			}
			else
			{
				compositeComponentBuilderSuccessor.RemoveComponent(componentId);
			}			
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
		/// <exception cref="ComponentNotFoundException">Thrown if the specified component (provCompID
		/// or reqCompID) is not a child of the actual composite component.
		/// </exception>
		/// <exception cref="InterfaceNotFromComponentException">Thrown if the given interfaces are not
		/// required / provided by the specified component. reqCompID has to require reqIFaceID;
		/// provCompID has to provide provIFaceID.</exception>
		public void AddAssemblyConnector (string connectionName, IComponentIdentifier reqCompID,
			IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID,
			IInterfaceIdentifier provIFaceID)
		{
			if(!modelDataManager.Query.QueryTypeLevel.QueryCompositeComponent(this.component.ComponentID).IsChildren(reqCompID))
			{
				throw new ComponentNotFoundException(reqCompID,
					"The component (reqCompID) is not a child of the actual composite component");
			}

			if(!modelDataManager.Query.QueryTypeLevel.QueryCompositeComponent(this.component.ComponentID).IsChildren(provCompID))
			{
				throw new ComponentNotFoundException(provCompID,
					"The component (provCompID) is not a child of the actual composite component");
			}

			if(!modelDataManager.Query.QueryTypeLevel.QueryComponent(provCompID).IsProvidesInterface(provIFaceID))
			{
				throw new InterfaceNotFromComponentException(provCompID, provIFaceID,
					"The specified interface is not provided by the component.");
			}

			if(!modelDataManager.Query.QueryTypeLevel.QueryComponent(reqCompID).IsRequiresInterface(reqIFaceID))
			{
				throw new InterfaceNotFromComponentException(reqCompID, reqIFaceID,
					"The specified interface is not required by the component.");
			}

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
		/// <remarks>The assembly connector is only added if the given identifier is new to the
		/// component model. Otherwise an exception will be thrown.</remarks>
		/// <exception cref="ComponentNotFoundException">Thrown if the specified component (provCompID
		/// or reqCompID) is not a child of the actual composite component.
		/// </exception>
		/// <exception cref="InterfaceNotFromComponentException">Thrown if the given interfaces are not
		/// required / provided by the specified component. reqCompID has to require reqIFaceID;
		/// provCompID has to provide provIFaceID.</exception>
		/// <exception cref="EntityAlreadyExistsException">Thrown if the given connection identifier
		/// already exists in the component model.</exception>
		public void AddAssemblyConnector (IConnectionIdentifier connectionIdentifier, string connectionName,
			IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID,
			IInterfaceIdentifier provIFaceID)
		{
			if(this.modelDataManager.Query.QueryEntities.ContainsEntity(connectionIdentifier))
			{
				throw new EntityAlreadyExistsException(connectionIdentifier, "The connection " +
					"already exists in the component model.");
			}

			if(!modelDataManager.Query.QueryTypeLevel.QueryCompositeComponent(this.component.ComponentID).IsChildren(reqCompID))
			{
				throw new ComponentNotFoundException(reqCompID,
					"The component (reqCompID) is not a child of the actual composite component");
			}

			if(!modelDataManager.Query.QueryTypeLevel.QueryCompositeComponent(this.component.ComponentID).IsChildren(provCompID))
			{
				throw new ComponentNotFoundException(provCompID,
					"The component (provCompID) is not a child of the actual composite component");
			}

			if(!modelDataManager.Query.QueryTypeLevel.QueryComponent(provCompID).IsProvidesInterface(provIFaceID))
			{
				throw new InterfaceNotFromComponentException(provCompID, provIFaceID,
					"The specified interface is not provided by the component.");
			}

			if(!modelDataManager.Query.QueryTypeLevel.QueryComponent(reqCompID).IsRequiresInterface(reqIFaceID))
			{
				throw new InterfaceNotFromComponentException(reqCompID, reqIFaceID,
					"The specified interface is not required by the component.");
			}

			compositeComponentBuilderSuccessor.AddAssemblyConnector(connectionIdentifier, connectionName,
				reqCompID, reqIFaceID, provCompID, provIFaceID);
		}

		/// <summary>
		/// Called to add an existing interface as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		/// <remarks>Checks wether the interface is already provided. If it is already provides an
		/// exception is thrown.</remarks>
		/// <exception cref="InterfaceAlreadyAddedException">Thrown if the same interface has
		/// previously been added (as provided) to the component.</exception>
		public void AddProvidesInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			if(this.modelDataManager.Query.QueryTypeLevel.
				QueryCompositeComponent(this.component.ComponentID).IsProvidesInterface(ifaceIdentifier))
			{
				throw new InterfaceAlreadyAddedException(this.component.ComponentID, ifaceIdentifier);
			}
			else
			{
				compositeComponentBuilderSuccessor.AddProvidesInterface(ifaceIdentifier);
			}
		}

		/// <summary>
		/// Called to add an existing interface as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		/// <remarks>Checks wether the interface is already required. If it is already provided an
		/// exception is thrown.</remarks>
		/// <exception cref="InterfaceAlreadyAddedException">Thrown if the same interface has
		/// previously been added (as required) to the component.</exception>
		public void AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			if(this.modelDataManager.Query.QueryTypeLevel.
				QueryCompositeComponent(this.component.ComponentID).IsRequiresInterface(ifaceIdentifier))
			{
				throw new InterfaceAlreadyAddedException(this.component.ComponentID, ifaceIdentifier);
			}
			else
			{
				compositeComponentBuilderSuccessor.AddRequiresInterface(ifaceIdentifier);;
			}			
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
		/// <exception cref="EntityAlreadyExistsException">Thrown if the interface identifier to add
		/// already exists in the component model.</exception>
		public IInterfaceTypeLevelBuilder AddProvidesInterface (IInterfaceIdentifier ifaceIdentifier, string interfaceName)
		{
			if(this.modelDataManager.Query.QueryEntities.ContainsEntity(ifaceIdentifier))
			{
				throw new EntityAlreadyExistsException(ifaceIdentifier);
			}
			else
			{
				return compositeComponentBuilderSuccessor.AddProvidesInterface(ifaceIdentifier, interfaceName);
			}			
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
		/// <exception cref="EntityAlreadyExistsException">Thrown if the interface identifier to add
		/// already exists in the component model.</exception>
		public IInterfaceTypeLevelBuilder AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier, string interfaceName)
		{
			if(this.modelDataManager.Query.QueryEntities.ContainsEntity(ifaceIdentifier))
			{
				throw new EntityAlreadyExistsException(ifaceIdentifier);
			}
			else
			{
				return compositeComponentBuilderSuccessor.AddRequiresInterface(ifaceIdentifier, interfaceName);
			}					
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as provided interface (<see cref="InterfaceRole.PROVIDES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		/// <exception cref="InterfaceNotFromComponentException">Thrown if the specified interface
		/// is not provided by the actual component.</exception>
		public void RemoveProvidesInterface (IInterfaceIdentifier ifaceID)
		{
			if(!this.modelDataManager.Query.QueryTypeLevel
				.QueryCompositeComponent(this.component.ComponentID).IsProvidesInterface(ifaceID))
			{			
				throw new InterfaceNotFromComponentException(this.component.ComponentID, ifaceID,
					"The interface to delete is not provided by the component.");
			}
			else
			{
				compositeComponentBuilderSuccessor.RemoveProvidesInterface(ifaceID);
			}			
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as requires interface (<see cref="InterfaceRole.REQUIRES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		/// <exception cref="InterfaceNotFromComponentException">Thrown if the specified interface
		/// is not provided by the actual component.</exception>
		public void RemoveRequiresInterface (IInterfaceIdentifier ifaceID)
		{
			if(!this.modelDataManager.Query.QueryTypeLevel
				.QueryCompositeComponent(this.component.ComponentID).IsRequiresInterface(ifaceID))
			{			
				throw new InterfaceNotFromComponentException(this.component.ComponentID, ifaceID,
					"The interface to delete is not required by the component.");
			}
			else
			{
				compositeComponentBuilderSuccessor.RemoveRequiresInterface(ifaceID);
			}
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
		/// <exception cref="InterfaceNotFromComponentException">Thrown, if
		/// <li>the outer interface is not provided by the actual composite component</li>
		/// <li>the inner interface is not provided by any inner component.</li>
		/// </exception>
		public void AddProvidesDelegationConnector (string connectionName, IInterfaceIdentifier outerIFaceID,
			IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID)
		{
			if(!this.modelDataManager.Query.QueryTypeLevel.QueryCompositeComponent(this.component.ComponentID)
				.IsProvidesInterface(outerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.component.ComponentID, outerIFaceID,
					"The outer interface is not provided by the composite component.");
			}

			if(!HasComponentInnerComponentWithProvidesInterface (innerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.component.ComponentID, innerIFaceID,
					"The inner interface is not provided by an inner component.");
			}

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
		/// <exception cref="InterfaceNotFromComponentException">Thrown, if
		/// <li>the outer interface is not provided by the actual composite component</li>
		/// <li>the inner interface is not provided by any inner component.</li>
		/// </exception>
		/// <exception cref="EntityAlreadyExistsException">Thrown if the given connectionIdentifier
		/// already exists in the component model.</exception>
		public void AddProvidesDelegationConnector (IConnectionIdentifier connectionIdentifier, 
			string connectionName, IInterfaceIdentifier outerIFaceID, IComponentIdentifier innerCompID,
			IInterfaceIdentifier innerIFaceID)
		{
			if(!this.modelDataManager.Query.QueryTypeLevel.QueryCompositeComponent(this.component.ComponentID)
				.IsProvidesInterface(outerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.component.ComponentID, outerIFaceID,
					"The outer interface is not provided by the composite component.");
			}

			if(!HasComponentInnerComponentWithProvidesInterface (innerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.component.ComponentID, innerIFaceID,
					"The inner interface is not provided by an inner component.");
			}

			if(this.modelDataManager.Query.QueryEntities.ContainsEntity(connectionIdentifier))
			{
				throw new EntityAlreadyExistsException(connectionIdentifier);
			}

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
		/// <exception cref="InterfaceNotFromComponentException">Thrown, if
		/// <li>the outer interface is not required by the actual composite component</li>
		/// <li>the inner interface is not required by any inner component.</li>
		/// </exception>
		public void AddRequiresDelegationConnector (string connectionName, IComponentIdentifier innerCompID,
			IInterfaceIdentifier innerIFaceID, IInterfaceIdentifier outerIFaceID)
		{
			
			if(!this.modelDataManager.Query.QueryTypeLevel.QueryCompositeComponent(this.component.ComponentID)
				.IsRequiresInterface(outerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.component.ComponentID, outerIFaceID,
					"The outer interface is not required by the composite component.");
			}

			if(!HasComponentInnerComponentWithRequiresInterface (innerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.component.ComponentID, innerIFaceID,
					"The inner interface is not required by an inner component.");
			}

			compositeComponentBuilderSuccessor.AddRequiresDelegationConnector(connectionName, innerCompID,
				innerIFaceID, outerIFaceID);
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
		/// <exception cref="InterfaceNotFromComponentException">Thrown, if
		/// <li>the outer interface is not required by the actual composite component</li>
		/// <li>the inner interface is not required by any inner component.</li>
		/// </exception>
		/// <exception cref="EntityAlreadyExistsException">Thrown if the given connectionIdentifier
		/// already exists in the component model.</exception>
		public void AddRequiresDelegationConnector (IConnectionIdentifier connectionIdentifier,
			string connectionName, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID,
			IInterfaceIdentifier outerIFaceID)
		{
			if(this.modelDataManager.Query.QueryTypeLevel.QueryCompositeComponent(this.component.ComponentID)
				.IsRequiresInterface(outerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.component.ComponentID, outerIFaceID,
					"The outer interface is not required by the composite component.");
			}

			if(!HasComponentInnerComponentWithRequiresInterface (innerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.component.ComponentID, innerIFaceID,
					"The inner interface is not required by an inner component.");
			}

			if(this.modelDataManager.Query.QueryEntities.ContainsEntity(connectionIdentifier))
			{
				throw new EntityAlreadyExistsException(connectionIdentifier);
			}

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
		/// called to remove the connection that belongs to the given id.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		/// <exception cref="EntityNotFoundException">Thrown if the connection is not contained
		/// in the actual composite component.</exception>
		public void RemoveConnection (IConnectionIdentifier connectionID)
		{
			if(!this.modelDataManager.Query.QueryTypeLevel.QueryCompositeComponent(this.component.ComponentID)
				.IsConnectionFromComponent(connectionID))
			{
				throw new EntityNotFoundException(connectionID,
					"The actual composite component does not contain the specified connection.");
			}
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

		#region private methods

		/// <summary>
		/// Checks wether the inner interface is provided by an inner component of the actual one. This 
		/// includes two checks:
		/// <li>check for existance of inner component.</li>
		/// <li>check for provides-relation between the given interface and the inner components.</li>
		/// </summary>
		/// <param name="innerIFaceID">The interface to check for.</param>
		/// <returns>true, if the interface is provided by an inner component; false otherwise.</returns>
		private bool HasComponentInnerComponentWithProvidesInterface (IInterfaceIdentifier innerIFaceID)
		{
			ArrayList identifierList;
			ArrayList innerInterfacesList;
			identifierList = new ArrayList(this.modelDataManager.Query.QueryTypeLevel
				.QueryCompositeComponent(this.component.ComponentID).GetComponents());
			bool foundMatchingComponent = false;
			foreach(IComponentIdentifier c in identifierList)
			{
				innerInterfacesList = new ArrayList(this.modelDataManager.Query.QueryTypeLevel
					.QueryComponent(c).GetProvidesInterfaceIDs());
				if(innerInterfacesList.Contains(innerIFaceID))
				{
					foundMatchingComponent = true;
				}
			}
			if(!foundMatchingComponent)
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		/// <summary>
		/// Checks wether the inner interface is provided by an inner component of the actual one. This 
		/// includes two checks:
		/// <li>check for existance of inner component.</li>
		/// <li>check for requires-relation between the given interface and the inner components.</li>
		/// </summary>
		/// <param name="innerIFaceID">The interface to check for.</param>
		/// <returns>true, if the interface is required by an inner component; false otherwise.</returns>
		private bool HasComponentInnerComponentWithRequiresInterface (IInterfaceIdentifier innerIFaceID)
		{
			ArrayList identifierList;
			ArrayList innerInterfacesList;
			identifierList = new ArrayList(this.modelDataManager.Query.QueryTypeLevel
				.QueryCompositeComponent(this.component.ComponentID).GetComponents());
			bool foundMatchingComponent = false;
			foreach(IComponentIdentifier c in identifierList)
			{
				innerInterfacesList = new ArrayList(this.modelDataManager.Query.QueryTypeLevel
					.QueryComponent(c).GetRequiresInterfaceIDs());
				if(innerInterfacesList.Contains(innerIFaceID))
				{
					foundMatchingComponent = true;
				}
			}
			if(!foundMatchingComponent)
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		#endregion
	}
}
