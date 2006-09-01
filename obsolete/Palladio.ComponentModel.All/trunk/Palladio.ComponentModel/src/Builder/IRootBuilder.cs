using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Query;

namespace Palladio.ComponentModel.Builder
{	

	/// <summary>
	/// The RootBuilder for the component model. Allows to build sub-builders. This builder only allows
	/// to build the structure of the component model.
	/// </summary>
	/// <remarks>
	/// The component model is divided into three levels. Each level has its own builders. To change
	/// between the levels the upper and / or lower level builder is available.
	/// All (sub-)builders return type level builders by default for new instances.
	/// 
	/// <p>This builder interface contains all non model-level specifical methods of a root.</p>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.17  2005/10/09 14:42:12  kelsaka
	/// - removed convenience properties to access a component model entity directly from a
	///  builder. use the access cm-environment>query instead
	///
	/// Revision 1.16  2005/07/13 11:08:30  joemal
	/// add query property
	///
	/// Revision 1.15  2005/06/05 11:06:52  joemal
	/// - add method DestroyComponent
	/// - rename method RemoveInterface to DestroyInterface
	///
	/// Revision 1.14  2005/06/05 10:36:34  joemal
	/// - replace the entities by the ids
	/// - components now can be added to more than one container
	///
	/// Revision 1.13  2005/05/25 16:27:10  kelsaka
	/// - renamed former BuilderFactory / therefore removed former BuilderManager
	///
	/// Revision 1.12  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// Revision 1.11  2005/04/23 17:42:08  kelsaka
	/// - added further methods for constraint-support
	///
	/// Revision 1.10  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.9  2005/04/12 12:32:39  kelsaka
	/// - removed property to access typed IDs directly from the builders
	/// - renamed the property from 'SignaturID' to 'SignatureID' in ISignature
	///
	/// Revision 1.8  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.7  2005/04/08 15:40:06  kelsaka
	/// - added SignatureBuilder
	/// - fixed bug: some new entities were not added to component model
	///
	/// Revision 1.6  2005/04/08 14:40:55  kelsaka
	/// - added implementation and unit-tests
	///
	/// Revision 1.5  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// Revision 1.4  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// Revision 1.3  2005/04/06 19:06:58  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// Revision 1.2  2005/03/17 19:54:12  kelsaka
	/// - added builder-interfaces
	///
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public interface IRootBuilder : ICompositeBaseBuilder
	{
		#region methods

		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <param name="name">The interfaces name.</param>
		/// <returns>A new InterfaceBuilder.</returns>
		IInterfaceTypeLevelBuilder CreateInterface(string name);

		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <param name="interfaceIdentifier">The new interfaces identifier.</param>
		/// <param name="name">The interfaces name.</param>
		/// <returns>A new InterfaceBuilder.</returns>
		IInterfaceTypeLevelBuilder CreateInterface(IInterfaceIdentifier interfaceIdentifier, string name);

		/// <summary>
		/// called to remove an interface from a component. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		void DestroyInterface(IInterfaceIdentifier ifaceIdentifier);

		/// <summary>
		/// Creates a new <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>).
		/// </summary>
		/// <param name="name">The components name.</param>
		/// <returns>Type level builder of the new basic component.</returns>
		IBasicComponentTypeLevelBuilder CreateBasicComponent(string name);

		/// <summary>
		/// Creates a new <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>).
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>Type level builder of the new basic component with the given ID.</returns>
		IBasicComponentTypeLevelBuilder CreateBasicComponent(IComponentIdentifier componentIdentifier, string name);

		/// <summary>
		/// Creates a new <see cref="IComponent"/> (Type <see cref="ComponentType.COMPOSITE"/>).
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="ICompositeComponentBuilder"/> to build the further component.</returns>
		ICompositeComponentTypeLevelBuilder CreateCompositeComponent(string name);

		/// <summary>
		/// Creates a new <see cref="IComponent"/> (Type <see cref="ComponentType.COMPOSITE"/>).
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="componentIdentifier">The id for the new component.</param>
		/// <param name="name">The new components name.</param>
		/// <returns>A <see cref="ICompositeComponentBuilder"/> to build the further component.</returns>
		ICompositeComponentTypeLevelBuilder CreateCompositeComponent(IComponentIdentifier componentIdentifier, string name);

		/// <summary>
		/// called to destroy a component. All references and all contained entities are also removed. 
		/// </summary>
		/// <param name="componentIdentifier"></param>
		void DestroyComponent(IComponentIdentifier componentIdentifier);

		/// <summary>
		/// call to remove all entities and their relations from the model
		/// </summary>
		void ClearAll();

		#endregion

		#region properties

		/// <summary>
		/// called to query the repository of the componentmodel.
		/// NOTE/TODO: This methods probably will be removed in future versions of the CM.
		/// To access the QueryRepository use the ComponentModelEnironment.Queries instead.
		/// </summary>
		IQueryRepository QueryRepository
		{
			get;
		}

		#endregion
	}
}
