using System;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Interface implemented by all component model builders that create entities.
	/// </summary>
	/// <remarks>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// </pre>
	/// </remarks>
	public interface IEntityBuilder
	{
		#region methods

		/// <summary>
		/// The name of the entity
		/// </summary>
		string Name { get; set; }

		/// <summary>
		/// has to be fired when the name is changed
		/// </summary>
		event StaticAttributeChangedEventHandler NameChangedEvent;

		#endregion
	}
}
