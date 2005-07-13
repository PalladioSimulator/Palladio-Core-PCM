using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Query;

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
	/// Revision 1.14  2005/07/13 11:09:08  joemal
	/// fix two bugs in method AddRequiresDelegationConnector
	///
	/// Revision 1.13  2005/06/12 17:07:31  joemal
	/// renamed from QueryEntity to QueryRepository
	///
	/// Revision 1.12  2005/06/05 10:38:31  joemal
	/// - replace the entities by the ids
	/// - components now can be added to more than one container
	///
	/// Revision 1.11  2005/05/30 13:09:35  kelsaka
	/// - methods for adding connections are now returning ids.
	///
	/// Revision 1.10  2005/05/25 19:44:54  kelsaka
	/// - optimized usings
	/// - builders are now returning identifiers again
	///
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
	public class CompositeComponentTypeLevelConstraint : ComponentTypeLevelConstraint,ICompositeComponentTypeLevelBuilder
	{
		#region constructors

		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="query">The query interface of the model.</param>
		public CompositeComponentTypeLevelConstraint(IQuery query) : base(query)
		{
		}

		/// <summary>
		/// Internal constructor.
		/// </summary>
		/// <param name="compId">the id of the component</param>
		/// <param name="query">The query interface of the model.</param>
		private CompositeComponentTypeLevelConstraint(IComponentIdentifier compId, IQuery query):base(compId,query)
		{
		}

		#endregion

		#region methods 

		/// <summary>
		/// Adds a new <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>) to the model.
		/// </summary>
		/// <param name="name">The components name.</param>
		/// <returns>Type level builder of the new basic component.</returns>
		public IBasicComponentTypeLevelBuilder AddNewBasicComponent(string name)
		{
			return CompositeComponentBuilderSuccessor.AddNewBasicComponent(name);
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
		public IBasicComponentTypeLevelBuilder AddNewBasicComponent(IComponentIdentifier componentIdentifier, string name)
		{
			if(this.Query.QueryRepository.ContainsEntity(componentIdentifier))
			{			
				throw new EntityAlreadyExistsException("The component can not be created with the "+
					"given identifier as is the identifier already exists.");
			}
			return CompositeComponentBuilderSuccessor.AddNewBasicComponent(componentIdentifier, name);
		}

		/// <summary>
		/// Adds a new <see cref="IComponent"/> (Type <see cref="ComponentType.COMPOSITE"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="ICompositeComponentBuilder"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder AddNewCompositeComponent(string name)
		{
			return CompositeComponentBuilderSuccessor.AddNewCompositeComponent(name);
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
		public ICompositeComponentTypeLevelBuilder AddNewCompositeComponent(IComponentIdentifier componentIdentifier, string name)
		{
			if(this.Query.QueryRepository.ContainsEntity(componentIdentifier))
			{			
				throw new EntityAlreadyExistsException("The component can not be created with "+
					"the given identifier as is the identifier already exists.");
			}
			return CompositeComponentBuilderSuccessor.AddNewCompositeComponent(componentIdentifier, name);
		}

		/// <summary>
		/// Adds an existing basic component <see cref="IComponent"/> (identified by component identifier) to the model.
		/// </summary>
		/// <param name="componentIdentifier">The id of the existing component.</param>
		public void AddExistingComponent(IComponentIdentifier componentIdentifier)
		{
			//todo: Constrains??
			CompositeComponentBuilderSuccessor.AddExistingComponent(componentIdentifier);
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
		public void RemoveComponent(IComponentIdentifier componentId)
		{
			if(!this.Query.QueryTypeLevel.QueryCompositeComponent(this.ComponentId).IsChild(componentId))
			{			
				throw new ComponentNotFoundException(componentId,
					"The given component can not be removed from the actual composite component as the"
					+ " composite component does not have a interal component with the given identifier.");
			}
			CompositeComponentBuilderSuccessor.RemoveComponent(componentId);
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
		/// <returns>The identifier of the new connection, created by this method.</returns>
		/// <exception cref="ComponentNotFoundException">Thrown if the specified component (provCompID
		/// or reqCompID) is not a child of the actual composite component.
		/// </exception>
		/// <exception cref="InterfaceNotFromComponentException">Thrown if the given interfaces are not
		/// required / provided by the specified component. reqCompID has to require reqIFaceID;
		/// provCompID has to provide provIFaceID.</exception>
		public IConnectionIdentifier AddAssemblyConnector (string connectionName, IComponentIdentifier reqCompID,
			IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID,
			IInterfaceIdentifier provIFaceID)
		{
			if(!Query.QueryTypeLevel.QueryCompositeComponent(this.ComponentId).IsChild(reqCompID))
			{
				throw new ComponentNotFoundException(reqCompID,
					"The component (reqCompID) is not a child of the actual composite component");
			}

			if(!this.Query.QueryTypeLevel.QueryCompositeComponent(this.ComponentId).IsChild(provCompID))
			{
				throw new ComponentNotFoundException(provCompID,
					"The component (provCompID) is not a child of the actual composite component");
			}

			if(!this.Query.QueryTypeLevel.QueryComponent(provCompID).IsProvidesInterface(provIFaceID))
			{
				throw new InterfaceNotFromComponentException(provCompID, provIFaceID,
					"The specified interface is not provided by the component.");
			}

			if(!this.Query.QueryTypeLevel.QueryComponent(reqCompID).IsRequiresInterface(reqIFaceID))
			{
				throw new InterfaceNotFromComponentException(reqCompID, reqIFaceID,
					"The specified interface is not required by the component.");
			}

			return CompositeComponentBuilderSuccessor.AddAssemblyConnector(connectionName, reqCompID, reqIFaceID,
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
			if(this.Query.QueryRepository.ContainsEntity(connectionIdentifier))
			{
				throw new EntityAlreadyExistsException("The connection " +
					"already exists in the component model.");
			}

			if(!this.Query.QueryTypeLevel.QueryCompositeComponent(this.ComponentId).IsChild(reqCompID))
			{
				throw new ComponentNotFoundException(reqCompID,
					"The component (reqCompID) is not a child of the actual composite component");
			}

			if(!this.Query.QueryTypeLevel.QueryCompositeComponent(this.ComponentId).IsChild(provCompID))
			{
				throw new ComponentNotFoundException(provCompID,
					"The component (provCompID) is not a child of the actual composite component");
			}

			if(!this.Query.QueryTypeLevel.QueryComponent(provCompID).IsProvidesInterface(provIFaceID))
			{
				throw new InterfaceNotFromComponentException(provCompID, provIFaceID,
					"The specified interface is not provided by the component.");
			}

			if(!this.Query.QueryTypeLevel.QueryComponent(reqCompID).IsRequiresInterface(reqIFaceID))
			{
				throw new InterfaceNotFromComponentException(reqCompID, reqIFaceID,
					"The specified interface is not required by the component.");
			}

			CompositeComponentBuilderSuccessor.AddAssemblyConnector(connectionIdentifier, connectionName,
				reqCompID, reqIFaceID, provCompID, provIFaceID);
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
		/// <returns>The identifier of the new connection, created by this method.</returns>
		/// <exception cref="InterfaceNotFromComponentException">Thrown, if
		/// <li>the outer interface is not provided by the actual composite component</li>
		/// <li>the inner interface is not provided by any inner component.</li>
		/// </exception>
		public IConnectionIdentifier AddProvidesDelegationConnector (string connectionName, IInterfaceIdentifier outerIFaceID,
			IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID)
		{
			if(!this.Query.QueryTypeLevel.QueryComponent(this.ComponentId).IsProvidesInterface(outerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.ComponentId, outerIFaceID,
					"The outer interface is not provided by the composite component.");
			}

			if(!this.Query.QueryTypeLevel.QueryComponent(innerCompID).IsProvidesInterface(innerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.ComponentId, innerIFaceID,
					"The inner interface is not provided by an inner component.");
			}

			return CompositeComponentBuilderSuccessor.AddProvidesDelegationConnector(connectionName, outerIFaceID,
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
			if(!this.Query.QueryTypeLevel.QueryComponent(this.ComponentId).IsProvidesInterface(outerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.ComponentId, outerIFaceID,
					"The outer interface is not provided by the composite component.");
			}

			if(!this.Query.QueryTypeLevel.QueryComponent(innerCompID).IsProvidesInterface(innerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.ComponentId, innerIFaceID,
					"The inner interface is not provided by an inner component.");
			}

			if(this.Query.QueryRepository.ContainsEntity(connectionIdentifier))
			{
				throw new EntityAlreadyExistsException(connectionIdentifier);
			}

			CompositeComponentBuilderSuccessor.AddProvidesDelegationConnector(connectionIdentifier, connectionName,
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
		/// <returns>The identifier of the new connection, created by this method.</returns>
		/// <exception cref="InterfaceNotFromComponentException">Thrown, if
		/// <li>the outer interface is not required by the actual composite component</li>
		/// <li>the inner interface is not required by any inner component.</li>
		/// </exception>
		public IConnectionIdentifier AddRequiresDelegationConnector (string connectionName, IComponentIdentifier innerCompID,
			IInterfaceIdentifier innerIFaceID, IInterfaceIdentifier outerIFaceID)
		{
			
			if(!this.Query.QueryTypeLevel.QueryComponent(this.ComponentId)
				.IsRequiresInterface(outerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.ComponentId, outerIFaceID,
					"The outer interface is not required by the composite component.");
			}

			if(!this.Query.QueryTypeLevel.QueryComponent(innerCompID).IsRequiresInterface(innerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.ComponentId, innerIFaceID,
					"The inner interface is not required by an inner component.");
			}

			return CompositeComponentBuilderSuccessor.AddRequiresDelegationConnector(connectionName, innerCompID,
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
			if(!this.Query.QueryTypeLevel.QueryComponent(this.ComponentId).IsRequiresInterface(outerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.ComponentId, outerIFaceID,
					"The outer interface is not required by the composite component.");
			}

			if(!this.Query.QueryTypeLevel.QueryComponent(innerCompID).IsRequiresInterface(innerIFaceID))
			{
				throw new InterfaceNotFromComponentException(this.ComponentId, innerIFaceID,
					"The inner interface is not required by an inner component.");
			}

			if(this.Query.QueryRepository.ContainsEntity(connectionIdentifier))
			{
				throw new EntityAlreadyExistsException(connectionIdentifier);
			}

			CompositeComponentBuilderSuccessor.AddRequiresDelegationConnector(connectionIdentifier,
				connectionName, innerCompID, innerIFaceID, outerIFaceID);
		}

		/// <summary>
		/// called to remove the connection that belongs to the given id.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		/// <exception cref="EntityNotFoundException">Thrown if the connection is not contained
		/// in the actual composite component.</exception>
		public void RemoveConnection (IConnectionIdentifier connectionID)
		{
			if(!this.Query.QueryTypeLevel.QueryCompositeComponent(this.ComponentId)
				.IsConnectionFromComponent(connectionID))
			{
				throw new EntityNotFoundException(connectionID,
					"The actual composite component does not contain the specified connection.");
			}
			CompositeComponentBuilderSuccessor.RemoveConnection(connectionID);
		}

		#endregion

		#region constraint-management

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		public ICompositeComponentImplementationLevelBuilder ImplementationLevelBuilder
		{
			get
			{
				return CompositeComponentBuilderSuccessor.ImplementationLevelBuilder;
			}
		}

		/// <summary>
		/// The child builder to call for each method defined in the builder interface.
		/// </summary>
		public ICompositeComponentTypeLevelBuilder ChildBuilder
		{
			set
			{
				this.componentBuilderSuccessor = value;
			}
		}

		/// <summary>
		/// Clones the actual builder / constraints instance except the created / supervised
		/// component model entity.
		/// </summary>
		/// <param name="compId">The id of component model entity that has to be builder 
		/// supervised.</param>
		/// <returns>A copy of the actual builder / constraint.</returns>
		/// <remarks>This method should only be used for constraints management.</remarks>
		public ICompositeComponentTypeLevelBuilder Clone(IComponentIdentifier compId)
		{
			return new CompositeComponentTypeLevelConstraint(compId,this.Query);
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
			return new CompositeComponentTypeLevelConstraint(this.ComponentId,this.Query);
		}

		#endregion

		#region properties

		//cast the succesor of the base class to this one
		private ICompositeComponentTypeLevelBuilder CompositeComponentBuilderSuccessor
		{
			get
			{
				return (ICompositeComponentTypeLevelBuilder) this.componentBuilderSuccessor;
			}
		}
        
		#endregion
	}
}
