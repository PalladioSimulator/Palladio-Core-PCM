using System;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{	//TODO: All (sub-)builders have to return type level builders by default.

	/// <summary>
	/// The RootBuilder for the component model. Allows to build sub-builders. This builder only allows
	/// to build the structure of the component model.
	/// </summary>
	/// <remarks>
	/// The component model is divided into three levels. Each level has its own builders. To change
	/// between the levels the upper and / or lower level builder is available.
	/// <pre>
	/// Version history:
	///
	/// $Log$
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

		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <param name="name">The interfaces name.</param>
		/// <returns>A new InterfaceBuilder.</returns>
		IInterfaceTypeLevelBuilder AddInterface(string name);

		/// <summary>
		/// called to remove an interface from a component. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		void RemoveInterface(IInterfaceIdentifier ifaceIdentifier);

	}
}
