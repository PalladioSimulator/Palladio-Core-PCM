using System;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
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
	public abstract class AbstractRootBuilder : IRootBuilder
	{
		#region data

		private ModelDataManager modelDataManager;

		#endregion

		#region methods

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		public void Init(IModelDataManager modelDataManager)
		{
			this.modelDataManager = this.modelDataManager;
		}

		/// <summary>
		/// Creates a new <see cref="IBasicComponentBuilder"/>, which allows to create new components.
		/// </summary>
		/// <returns>The new ComponentBuilder.</returns>
		public IBasicComponentTypeLevelBuilder AddBasicComponent (string name)
		{
			IComponent component = EntityFactory.CreateComponent(ComponentType.BASIC, name);
			modelDataManager.LowLevelBuilder.AddComponent(component, null);
			return new DefaultBasicComponentTypeLevelBuilder(modelDataManager, component);
		}

		/// <summary>
		/// Adds a <see cref="IComponent"/> (Type <see cref="ComponentType.COMPOSITE"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="ICompositeComponentBuilder"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder AddCompositeComponent (string name)
		{
			IComponent component = EntityFactory.CreateComponent(ComponentType.COMPOSITE, name);
			modelDataManager.LowLevelBuilder.AddComponent(component, null);
			return new DefaultCompositeComponentTypeLevelBuilder(modelDataManager, component);
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
		public void AddAssemblyConnector (string connectionName, IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID)
		{
			IConnection connection = EntityFactory.CreateConnection(connectionName);
			modelDataManager.LowLevelBuilder.AddAssemblyConnector(connection, reqCompID, reqIFaceID, provCompID, provIFaceID);
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
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <param name="name">The interfaces name.</param>
		/// <returns>A new InterfaceBuilder.</returns>
		public IInterfaceTypeLevelBuilder AddInterface (string name)
		{
			IInterface iInterface = EntityFactory.CreateInterface(name);
			modelDataManager.LowLevelBuilder.AddInterface(iInterface);
			return new DefaultInterfaceTypeLevelBuilder(modelDataManager, iInterface);
		}

		/// <summary>
		/// called to remove an interface from a component. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		public void RemoveInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			modelDataManager.LowLevelBuilder.RemoveInterface(ifaceIdentifier);
		}

		/// <summary>
		/// call to remove all entities and there relations from the model
		/// </summary>
		public void ClearAll ()
		{
			modelDataManager.LowLevelBuilder.ClearAll();
		}

		#endregion
	}
}
