using System;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// The RootBuilder for the component model. Allows to build sub-builders. By default
	/// type-level builders are returned from all levels of builders. This means, that for
	/// each entity the default level is the type-level.
	/// <p>Abstract implementation of the root builder - methods that are available at all levels of the
	/// component model.</p>
	/// </summary>
	/// <remarks>
	/// Note: The root is not a component model entity.
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.18  2005/05/27 13:34:41  kelsaka
	/// - AbstractEntity now holds the ModelDataManger and the BuilderManager
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
	/// Revision 1.13  2005/04/23 17:42:08  kelsaka
	/// - added further methods for constraint-support
	///
	/// Revision 1.12  2005/04/23 14:56:44  kelsaka
	/// - enhanced constraints management
	///
	/// Revision 1.11  2005/04/23 11:00:44  kelsaka
	/// - removed Init-Methods from AbstractBuilder - created constructors
	///
	/// Revision 1.10  2005/04/20 18:27:45  kelsaka
	/// - made classes internal
	/// - removed unused init-methods
	/// - use of InternalEntityIdentifier for creating new Identifiers
	///
	/// Revision 1.9  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.8  2005/04/20 16:23:44  joemal
	/// fix a bug
	///
	/// Revision 1.7  2005/04/20 13:08:31  kelsaka
	/// - introduced IModelDataManagement
	/// - integrated use of the new interface
	///
	/// Revision 1.6  2005/04/16 12:37:46  kelsaka
	/// - added first ideas using constraints with the builders
	///
	/// Revision 1.5  2005/04/15 08:29:46  kelsaka
	/// - fixed errors on xml-comments
	///
	/// Revision 1.4  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.3  2005/04/08 14:40:55  kelsaka
	/// - added implementation and unit-tests
	///
	/// Revision 1.2  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// Revision 1.1  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// Revision 1.4  2005/04/06 19:06:58  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// Revision 1.3  2005/03/18 07:36:27  kelsaka
	/// - corrected errors
	///
	/// Revision 1.2  2005/03/17 19:54:12  kelsaka
	/// - added builder-interfaces
	///
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	internal abstract class AbstractRootBuilder : AbstractEntityBuilder, IRootBuilder
	{
		#region data

		#endregion

		#region constructors

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="builderManager">The factory to use for creating other builders.</param>
		public AbstractRootBuilder(IModelDataManager modelDataManager, IBuilderManager builderManager)
			: base(builderManager, modelDataManager)
		{
		}
		
		#endregion

		#region methods

		/// <summary>
		/// Creates a new <see cref="IBasicComponentBuilder"/>, which allows to create new components.
		/// </summary>
		/// <returns>The new ComponentBuilder.</returns>
		public IBasicComponentTypeLevelBuilder AddBasicComponent (string name)
		{			
			return AddBasicComponent(new InternalEntityIdentifier().AsComponentIdentifier(), name);
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
			IComponent component = EntityFactory.CreateComponent(componentIdentifier, ComponentType.BASIC, name);
			base.ModelDataManager.LowLevelBuilder.AddComponent(component, null);
			return base.BuilderManager.GetBasicComponentTypeLevelBuilder(component);
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
		/// Adds a <see cref="IComponent"/> (Type <see cref="ComponentType.COMPOSITE"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="ICompositeComponentBuilder"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder AddCompositeComponent (string name)
		{
			return AddCompositeComponent(new InternalEntityIdentifier().AsComponentIdentifier(), name);
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
			IComponent component = EntityFactory.CreateComponent(componentIdentifier, ComponentType.COMPOSITE, name);
			base.ModelDataManager.LowLevelBuilder.AddComponent(component, null);
			return base.BuilderManager.GetCompositeComponentTypeLevelBuilder(component);
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
			base.ModelDataManager.LowLevelBuilder.RemoveComponent(componentId);
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
		public void AddAssemblyConnector (IConnectionIdentifier connectionIdentifier,
			string connectionName, IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID,
			IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID)
		{
			IConnection connection = EntityFactory.CreateConnection(connectionIdentifier, connectionName);
			base.ModelDataManager.LowLevelBuilder.AddAssemblyConnector(connection, reqCompID,
				reqIFaceID, provCompID, provIFaceID);
		}

		/// <summary>
		/// called to remove the connection that belongs to the given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		public void RemoveConnection (IConnectionIdentifier connectionID)
		{
			base.ModelDataManager.LowLevelBuilder.RemoveConnection(connectionID);
		}

		/// <summary>
		/// Copies the actual element.
		/// </summary>
		/// <returns>A copy of the actual instance.</returns>
		public IRootBuilder Copy ()
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <param name="name">The interfaces name.</param>
		/// <returns>A new InterfaceBuilder.</returns>
		public IInterfaceTypeLevelBuilder CreateInterface (string name)
		{
			return CreateInterface(new InternalEntityIdentifier().AsInterfaceIdentifier(), name);
		}

		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <param name="interfaceIdentifier">The new interfaces identifier.</param>
		/// <param name="name">The interfaces name.</param>
		/// <returns>A new InterfaceBuilder.</returns>
		public IInterfaceTypeLevelBuilder CreateInterface (IInterfaceIdentifier interfaceIdentifier, string name)
		{
			IInterface iInterface = EntityFactory.CreateInterface(interfaceIdentifier, name);
			base.ModelDataManager.LowLevelBuilder.AddInterface(iInterface);
			return base.BuilderManager.GetInterfaceTypeLevelBuilder(iInterface);
		}

		/// <summary>
		/// Adds an existing interface with the given identifier to the component model. Returns a
		/// <see cref="IInterfaceBuilder"/>, which allows to customize the added interfaces.
		/// </summary>
		/// <param name="interfaceIdentifier">The existing interfaces identifier.</param>
		/// <returns>A InterfaceBuilder for the existing interface Identifier.</returns>
		public IInterfaceTypeLevelBuilder AddExistingInterface (IInterfaceIdentifier interfaceIdentifier)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// called to remove an interface from a component. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		public void RemoveInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			base.ModelDataManager.LowLevelBuilder.RemoveInterface(ifaceIdentifier);
		}

		/// <summary>
		/// call to remove all entities and there relations from the model
		/// </summary>
		public void ClearAll ()
		{
			base.ModelDataManager.LowLevelBuilder.ClearAll();
		}

		#endregion
	}
}
