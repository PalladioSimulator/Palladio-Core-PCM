using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// The RootBuilder for the component model. Allows to build sub-builders. This builder only allows
	/// to build the structure of the component model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/03/17 19:54:12  kelsaka
	/// - added builder-interfaces
	///
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public interface IRootBuilder : ICompositeComponentBuilder
	{

		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <returns>A new InterfaceBuilder.</returns>
		IInterfaceBuilder AddInterface();

	}
}
