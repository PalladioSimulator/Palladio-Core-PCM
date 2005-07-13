using System;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Query;

namespace Palladio.ComponentModel.BuilderConstraints.DefaultConstraints.TypeLevelConstraints
{

	/// <summary>
	/// Default constraints for root at the type level. This constraints are used always
	/// as they are the neccessary for a valid and consistent static structure of the component model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.8  2005/07/13 11:08:30  joemal
	/// add query property
	///
	/// Revision 1.7  2005/06/05 11:06:52  joemal
	/// - add method DestroyComponent
	/// - rename method RemoveInterface to DestroyInterface
	///
	/// Revision 1.6  2005/06/05 10:38:31  joemal
	/// - replace the entities by the ids
	/// - components now can be added to more than one container
	///
	/// Revision 1.5  2005/05/30 13:09:35  kelsaka
	/// - methods for adding connections are now returning ids.
	///
	/// Revision 1.4  2005/05/25 18:15:27  kelsaka
	/// - added new methods to BuilderManager
	/// - use of new methods in example
	///
	/// Revision 1.3  2005/05/25 16:27:09  kelsaka
	/// - renamed former BuilderFactory / therefore removed former BuilderManager
	///
	/// Revision 1.2  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// Revision 1.1  2005/04/23 17:42:08  kelsaka
	/// - added further methods for constraint-support
	///
	///
	/// </pre>
	/// </remarks>
	public class RootTypeLevelConstraint : IRootTypeLevelBuilder
	{
		#region data
		
		private IRootTypeLevelBuilder rootBuilderSuccessor;
		private IQuery query;

		#endregion

		#region constructors

		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="query">the query interface of the model</param>
		public RootTypeLevelConstraint(IQuery query)
		{
			this.query = query;
		}

		#endregion

		/// <summary>
		/// Adds an existing component <see cref="IComponent"/> (identified by component identifier).
		/// </summary>
		/// <param name="componentIdentifier">The id of the existing component.</param>
		/// <returns>Type level builder of the basic component with the given ID.</returns>
		public void AddExistingComponent (IComponentIdentifier componentIdentifier)
		{
			//todo: constrains 
			rootBuilderSuccessor.AddExistingComponent(componentIdentifier);
		}

		/// <summary>
		/// Adds a new <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>) to the model.
		/// </summary>
		/// <param name="name">The components name.</param>
		/// <returns>Type level builder of the new basic component.</returns>
		public IBasicComponentTypeLevelBuilder AddNewBasicComponent(string name)
		{
			return this.AddNewBasicComponent(new InternalEntityIdentifier().AsComponentIdentifier(),name);			
		}

		/// <summary>
		/// Adds a new <see cref="ComponentType.BASIC"/> (Type <see cref="IComponent"/>) to the model.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>Type level builder of the new basic component with the given ID.</returns>
		public IBasicComponentTypeLevelBuilder AddNewBasicComponent(IComponentIdentifier componentIdentifier, string name)
		{
			//todo: constrains 
			return rootBuilderSuccessor.AddNewBasicComponent(componentIdentifier,name);
		}

		/// <summary>
		/// Adds a new <see cref="ICompositeComponentBuilder"/> (Type <see cref="ComponentType.COMPOSITE"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="IComponent"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder AddNewCompositeComponent(string name)
		{
			//todo: constrains 
			return rootBuilderSuccessor.AddNewCompositeComponent(name);
		}

		/// <summary>
		/// Adds a new <see cref="ComponentType.COMPOSITE"/> (Type <see cref="IComponent"/>) to the component model.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>A <see cref="ICompositeComponentBuilder"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder AddNewCompositeComponent(IComponentIdentifier componentIdentifier, string name)
		{
			//todo: constrains 
			return rootBuilderSuccessor.AddNewCompositeComponent(componentIdentifier,name);
		}

		/// <summary>
		/// Called to remove the component which belongs to the given id. All contained components
		/// (Type <see cref="ComponentType.COMPOSITE"/>) and
		/// all connections to and from this components are also removed.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		public void RemoveComponent (IComponentIdentifier componentId)
		{
			this.rootBuilderSuccessor.RemoveComponent(componentId);
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
		public IConnectionIdentifier AddAssemblyConnector (string connectionName, IComponentIdentifier reqCompID,
			IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID)
		{
			return this.rootBuilderSuccessor.AddAssemblyConnector(connectionName, reqCompID, reqIFaceID, provCompID, provIFaceID);
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
			this.rootBuilderSuccessor.AddAssemblyConnector(connectionIdentifier, connectionName, reqCompID,
				reqIFaceID, provCompID, provIFaceID);
		}

		/// <summary>
		/// called to remove the connection that belongs to the given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		public void RemoveConnection (IConnectionIdentifier connectionID)
		{
			this.rootBuilderSuccessor.RemoveConnection(connectionID);
		}

		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <param name="name">The interfaces name.</param>
		/// <returns>A new InterfaceBuilder.</returns>
		public IInterfaceTypeLevelBuilder CreateInterface (string name)
		{
			return this.rootBuilderSuccessor.CreateInterface(name);
		}

		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <param name="interfaceIdentifier">The new interfaces identifier.</param>
		/// <param name="name">The interfaces name.</param>
		/// <returns>A new InterfaceBuilder.</returns>
		public IInterfaceTypeLevelBuilder CreateInterface (IInterfaceIdentifier interfaceIdentifier, string name)
		{
			return this.rootBuilderSuccessor.CreateInterface(interfaceIdentifier, name);
		}

		/// <summary>
		/// called to remove an interface from a component. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		public void DestroyInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			this.rootBuilderSuccessor.DestroyInterface(ifaceIdentifier);
		}

		/// <summary>
		/// Creates a new <see cref="ComponentType.BASIC"/> (Type <see cref="IComponent"/>).
		/// </summary>
		/// <param name="name">The components name.</param>
		/// <returns>Type level builder of the new basic component.</returns>
		public IBasicComponentTypeLevelBuilder CreateBasicComponent(string name)
		{
			return this.rootBuilderSuccessor.CreateBasicComponent(name);
		}

		/// <summary>
		/// Creates a new <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>).
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>Type level builder of the new basic component with the given ID.</returns>
		public IBasicComponentTypeLevelBuilder CreateBasicComponent(IComponentIdentifier componentIdentifier, string name)
		{
			return this.rootBuilderSuccessor.CreateBasicComponent(componentIdentifier,name);
		}

		/// <summary>
		/// Creates a new <see cref="ICompositeComponentBuilder"/> (Type <see cref="IComponent"/>).
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="ComponentType.COMPOSITE"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder CreateCompositeComponent(string name)
		{
			return this.rootBuilderSuccessor.CreateCompositeComponent(name);
		}

		/// <summary>
		/// Creates a new <see cref="ICompositeComponentBuilder"/> (Type <see cref="IComponent"/>).
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>A <see cref="ComponentType.COMPOSITE"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder CreateCompositeComponent(IComponentIdentifier componentIdentifier, string name)
		{
			return this.rootBuilderSuccessor.CreateCompositeComponent(componentIdentifier,name);
		}

		/// <summary>
		/// called to destroy a component. All references and all contained entities are also removed. 
		/// </summary>
		/// <param name="componentIdentifier"></param>
		public void DestroyComponent(IComponentIdentifier componentIdentifier)
		{
			this.rootBuilderSuccessor.DestroyComponent(componentIdentifier);
		}

		/// <summary>
		/// call to remove all entities and their relations from the model
		/// </summary>
		public void ClearAll ()
		{
			this.rootBuilderSuccessor.ClearAll();
		}

		/// <summary>
		/// called to query the repository of the componentmodel
		/// </summary>
		public IQueryRepository QueryRepository
		{
			get
			{
				return this.rootBuilderSuccessor.QueryRepository;
			}
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		public IRootImplementationLevelBuilder ImplementationLevelBuilder
		{
			get
			{
				return this.rootBuilderSuccessor.ImplementationLevelBuilder;
			}
		}

		#region constraint-management

		/// <summary>
		/// The child builder to call for each method defined in the builder interface.
		/// </summary>
		public IRootTypeLevelBuilder ChildBuilder
		{
			set
			{
				this.rootBuilderSuccessor = value;
			}
		}

		/// <summary>
		/// Clones the actual builder / constraints instance.
		/// </summary>
		/// <returns>A copy of the actual builder / constraint.</returns>
		public IRootTypeLevelBuilder Clone ()
		{
			return new RootTypeLevelConstraint(this.query);
		}

		#endregion
	}
}
