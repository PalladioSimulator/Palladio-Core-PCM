using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{
	/// <summary>
	/// ICompositeBase. Interface base for composite-like structures like composite component- and the outer
	/// component model (created by the root-builder).
	/// This interface does justice to the fact, that composite components (respective their builder) do not have
	/// methods to add non-connected first class entities, those entities only can be added by the RootBuilder.
	/// Anyway the <see cref="ICompositeComponentBuilder"/> and the <see cref="IRootBuilder"/> have lot of methods
	/// in common.
	/// </summary>
	/// <p>This builder interface contains all non model-level specifical methods of a composite
	/// like structures.</p>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.14  2005/06/05 10:36:34  joemal
	/// - replace the entities by the ids
	/// - components now can be added to more than one container
	///
	/// Revision 1.13  2005/05/30 13:09:35  kelsaka
	/// - methods for adding connections are now returning ids.
	///
	/// Revision 1.12  2005/05/27 15:22:51  kelsaka
	/// - added return of entity ids
	///
	/// Revision 1.11  2005/05/25 19:44:54  kelsaka
	/// - optimized usings
	/// - builders are now returning identifiers again
	///
	/// Revision 1.10  2005/05/25 18:15:27  kelsaka
	/// - added new methods to BuilderManager
	/// - use of new methods in example
	///
	/// Revision 1.9  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.8  2005/04/12 12:32:39  kelsaka
	/// - removed property to access typed IDs directly from the builders
	/// - renamed the property from 'SignaturID' to 'SignatureID' in ISignature
	///
	/// Revision 1.7  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.6  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// Revision 1.5  2005/04/07 17:49:32  kelsaka
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
	/// Revision 1.2  2005/03/18 07:17:38  kelsaka
	/// - added comments
	///
	/// Revision 1.1  2005/03/17 19:54:12  kelsaka
	/// - added builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public interface ICompositeBaseBuilder
	{
		#region methods

		/// <summary>
		/// Adds a new <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>) to the model.
		/// </summary>
		/// <param name="name">The components name.</param>
		/// <returns>Type level builder of the new basic component.</returns>
		IBasicComponentTypeLevelBuilder AddNewBasicComponent(string name);

		/// <summary>
		/// Adds a new <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>) to the model.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>Type level builder of the new basic component with the given ID.</returns>
		IBasicComponentTypeLevelBuilder AddNewBasicComponent(IComponentIdentifier componentIdentifier, string name);

		/// <summary>
		/// Adds a new <see cref="IComponent"/> (Type <see cref="ComponentType.COMPOSITE"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="ICompositeComponentBuilder"/> to build the further component.</returns>
		ICompositeComponentTypeLevelBuilder AddNewCompositeComponent(string name);

		/// <summary>
		/// Adds a new <see cref="IComponent"/> (Type <see cref="ComponentType.COMPOSITE"/>) to the component model.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>A <see cref="ICompositeComponentBuilder"/> to build the further component.</returns>
		ICompositeComponentTypeLevelBuilder AddNewCompositeComponent(IComponentIdentifier componentIdentifier, string name);

		/// <summary>
		/// Adds an existing basic component <see cref="IComponent"/> (identified by component identifier) to the model.
		/// </summary>
		/// <param name="componentIdentifier">The id of the existing component.</param>
		void AddExistingComponent(IComponentIdentifier componentIdentifier);
		
		/// <summary>
		/// Called to remove the component which belongs to the given id. All
		/// connections to and from this components are also removed.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		void RemoveComponent(IComponentIdentifier componentId);

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
		IConnectionIdentifier AddAssemblyConnector(string connectionName, IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID,
			IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID);

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
		void AddAssemblyConnector(IConnectionIdentifier connectionIdentifier, string connectionName,
			IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID,
			IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID);

		/// <summary>
		/// called to remove the connection that belongs to the given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		void RemoveConnection(IConnectionIdentifier connectionID);

		#endregion
	}
}
