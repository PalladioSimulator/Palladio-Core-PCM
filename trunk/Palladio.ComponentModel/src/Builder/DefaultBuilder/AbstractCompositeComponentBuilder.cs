using Palladio.ComponentModel.Builder;
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
	/// Revision 1.23  2005/06/05 11:06:18  joemal
	/// - fix bug in RemoveComponent
	///
	/// Revision 1.22  2005/06/05 10:37:33  joemal
	/// - replace the entities by the ids
	/// - components now can be added to more than one container
	///
	/// Revision 1.21  2005/05/30 13:09:35  kelsaka
	/// - methods for adding connections are now returning ids.
	///
	/// Revision 1.20  2005/05/27 15:22:51  kelsaka
	/// - added return of entity ids
	///
	/// Revision 1.19  2005/05/27 13:34:41  kelsaka
	/// - AbstractEntity now holds the ModelDataManger and the BuilderManager
	///
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
	internal abstract class AbstractCompositeComponentBuilder : AbstractComponentBuilder, ICompositeComponentBuilder
	{
		#region constructors

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="compId">the id of this builders component</param>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="builderManager">The factory to use for creating other builders.</param>
		public AbstractCompositeComponentBuilder(IComponentIdentifier compId,IModelDataManager modelDataManager, IBuilderManager builderManager)
			: base(compId, modelDataManager,builderManager)
		{
		}

		#endregion

		#region methods

		/// <summary>
		/// Adds a new <see cref="ComponentType.BASIC"/> (Type <see cref="IComponent"/>) to the model.
		/// </summary>
		/// <param name="name">The components name.</param>
		/// <returns>Type level builder of the new basic component.</returns>
		public IBasicComponentTypeLevelBuilder AddNewBasicComponent(string name)
		{
			return AddNewBasicComponent(new InternalEntityIdentifier().AsComponentIdentifier(), name);
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
			IComponent component = EntityFactory.CreateComponent(componentIdentifier, ComponentType.BASIC, name);
			base.ModelDataManager.LowLevelBuilder.CreateComponent(component);
			base.ModelDataManager.LowLevelBuilder.AddComponent(componentIdentifier,this.ComponentId);
			return this.BuilderManager.GetBasicComponentTypeLevelBuilder(component);			
		}

		/// <summary>
		/// Adds a new <see cref="ComponentType.COMPOSITE"/> (Type <see cref="ICompositeComponentBuilder"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="IComponent"/> to build the further component.</returns>
		public ICompositeComponentTypeLevelBuilder AddNewCompositeComponent(string name)
		{
			return this.AddNewCompositeComponent(new InternalEntityIdentifier().AsComponentIdentifier(),name);
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
			IComponent component = EntityFactory.CreateComponent(componentIdentifier, ComponentType.COMPOSITE, name);
			base.ModelDataManager.LowLevelBuilder.CreateComponent(component);
			base.ModelDataManager.LowLevelBuilder.AddComponent(componentIdentifier,this.ComponentId);
			return this.BuilderManager.GetCompositeComponentTypeLevelBuilder(component);			
		}

		/// <summary>
		/// Adds an existing component <see cref="IComponent"/> (identified by component identifier) to the model.
		/// </summary>
		/// <param name="componentIdentifier">The id of the existing component.</param>
		public void AddExistingComponent(IComponentIdentifier componentIdentifier)
		{
			base.ModelDataManager.LowLevelBuilder.AddComponent(componentIdentifier,this.ComponentId);
		}

		/// <summary>
		/// Called to remove the component which belongs to the given id. All contained components
		/// (Type <see cref="ComponentType.COMPOSITE"/>) and
		/// all connections to and from this components are also removed.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		public void RemoveComponent (IComponentIdentifier componentId)
		{
			this.ModelDataManager.LowLevelBuilder.RemoveComponentFromComponent(componentId,this.ComponentId);
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
		/// <returns>The identifier of the new connection, created by this method.</returns>
		public IConnectionIdentifier AddAssemblyConnector (string connectionName, IComponentIdentifier reqCompID,
			IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID,
			IInterfaceIdentifier provIFaceID)
		{
			IConnectionIdentifier identifier = new InternalEntityIdentifier().AsConnectionIdentifier();
			AddAssemblyConnector(identifier,connectionName, reqCompID, reqIFaceID, provCompID, provIFaceID);
			return identifier;
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
			this.ModelDataManager.LowLevelBuilder.AddAssemblyConnector(connection,this.ComponentId, reqCompID,reqIFaceID, 
				provCompID, provIFaceID);
		}

		/// <summary>
		/// called to remove the connection that belongs to the given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		public void RemoveConnection (IConnectionIdentifier connectionID)
		{
			this.ModelDataManager.LowLevelBuilder.RemoveConnection(connectionID);
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
		public IConnectionIdentifier AddProvidesDelegationConnector(string connectionName, IInterfaceIdentifier outerIFaceID, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID)
		{
			IConnectionIdentifier identifier = new InternalEntityIdentifier().AsConnectionIdentifier();
			AddProvidesDelegationConnector(identifier,
				connectionName, outerIFaceID, innerCompID, innerIFaceID);
			return identifier;
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
		public void AddProvidesDelegationConnector(IConnectionIdentifier connectionIdentifier, string connectionName, IInterfaceIdentifier outerIFaceID, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID)
		{
			IConnection connection = EntityFactory.CreateConnection(connectionName);
			base.ModelDataManager.LowLevelBuilder.AddProvidesDelegationConnector(connection, this.ComponentId,
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
		public IConnectionIdentifier AddRequiresDelegationConnector(string connectionName, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID, IInterfaceIdentifier outerIFaceID)
		{
			IConnectionIdentifier identifier = new InternalEntityIdentifier().AsConnectionIdentifier();
			this.AddRequiresDelegationConnector(identifier, connectionName,innerCompID,innerIFaceID,outerIFaceID);
			return identifier;
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
		public void AddRequiresDelegationConnector(IConnectionIdentifier connectionIdentifier, string connectionName, IComponentIdentifier innerCompID,
		                                           IInterfaceIdentifier innerIFaceID, IInterfaceIdentifier outerIFaceID)
		{
			IConnection connection = EntityFactory.CreateConnection(connectionName);
			base.ModelDataManager.LowLevelBuilder.AddRequiresDelegationConnector(connection, innerCompID,
				innerIFaceID, this.ComponentId, outerIFaceID);
		}

		#endregion
	}
}
