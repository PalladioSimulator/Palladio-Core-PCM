using System;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

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
		private IModelDataManager modelDataManager;

		#endregion

		#region constructors

		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="modelDataManager">The model data manager to use for executing e. g. queries.</param>
		public RootTypeLevelConstraint(IModelDataManager modelDataManager)
		{
			this.modelDataManager = modelDataManager;
		}

		#endregion

		/// <summary>
		/// Adds a new <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name.</param>
		/// <returns>Type level builder of the new basic component.</returns>
		public IBasicComponentTypeLevelBuilder AddBasicComponent (string name)
		{
			return this.rootBuilderSuccessor.AddBasicComponent(name);
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
			return this.rootBuilderSuccessor.AddBasicComponent(componentIdentifier, name);
		}

		/// <summary>
		/// Adds a new <see cref="IComponent"/> (Type <see cref="ComponentType.COMPOSITE"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="ICompositeComponentBuilder"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder AddCompositeComponent (string name)
		{
			return this.rootBuilderSuccessor.AddCompositeComponent(name);
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
			return this.rootBuilderSuccessor.AddCompositeComponent(componentIdentifier, name);
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
		public void AddAssemblyConnector (string connectionName, IComponentIdentifier reqCompID,
			IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID)
		{
			this.rootBuilderSuccessor.AddAssemblyConnector(connectionName, reqCompID, reqIFaceID, provCompID, provIFaceID);
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
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <param name="name">The interfaces name.</param>
		/// <returns>A new InterfaceBuilder.</returns>
		public IInterfaceTypeLevelBuilder AddInterface (string name)
		{
			return this.rootBuilderSuccessor.AddInterface(name);
		}

		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <param name="interfaceIdentifier">The new interfaces identifier.</param>
		/// <param name="name">The interfaces name.</param>
		/// <returns>A new InterfaceBuilder.</returns>
		public IInterfaceTypeLevelBuilder AddInterface (IInterfaceIdentifier interfaceIdentifier, string name)
		{
			return this.rootBuilderSuccessor.AddInterface(interfaceIdentifier, name);
		}

		/// <summary>
		/// called to remove an interface from a component. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		public void RemoveInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			this.rootBuilderSuccessor.RemoveInterface(ifaceIdentifier);
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

		/// <summary>
		/// call to remove all entities and their relations from the model
		/// </summary>
		public void ClearAll ()
		{
			this.rootBuilderSuccessor.ClearAll();
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
			return new RootTypeLevelConstraint(modelDataManager);
		}

		#endregion
	}
}
