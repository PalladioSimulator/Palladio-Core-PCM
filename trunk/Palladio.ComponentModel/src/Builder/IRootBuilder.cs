using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;

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
		IInterfaceTypeLevelBuilder AddInterface(string name);

		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <param name="interfaceIdentifier">The new interfaces identifier.</param>
		/// <param name="name">The interfaces name.</param>
		/// <returns>A new InterfaceBuilder.</returns>
		IInterfaceTypeLevelBuilder AddInterface(IInterfaceIdentifier interfaceIdentifier, string name);

		/// <summary>
		/// called to remove an interface from a component. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		void RemoveInterface(IInterfaceIdentifier ifaceIdentifier);

		/// <summary>
		/// call to remove all entities and their relations from the model
		/// </summary>
		void ClearAll();

		#endregion
	}
}
