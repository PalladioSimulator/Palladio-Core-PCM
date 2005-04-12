using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Builder for creating Basic Components.
	/// </summary>
	/// <remarks>
	/// <p>This builder interface contains all non model-level specifical methods of a basic
	/// component.</p>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.6  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// Revision 1.5  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.4  2005/04/07 17:49:31  kelsaka
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
	public interface IBasicComponentBuilder : IComponentBuilder
	{
		#region methods

		//TODO: basic methods that are non level specific for bc.

		#endregion


	}
}
