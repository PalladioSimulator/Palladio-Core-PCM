using Palladio.Attributes;
using Palladio.ComponentModel.ModelEventManagement;
using Palladio.Identifier;

namespace Palladio.ComponentModel.ModelEntities
{
	/// <summary>
	/// This interface is the base interfaces of all entities of the componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/04/05 14:23:59  joemal
	/// implement the rest of the notification
	///
	///
	/// </pre>
	/// </remarks>
	public interface IComponentModelEntity : IIdentifiable, IAttributable
	{
		/// <summary>
		/// The name of the entity
		/// </summary>
		string Name { get; set; }

		/// <summary>
		/// has to be fired when the name is changed
		/// </summary>
		event StaticAttributeChangedEventHandler NameChangedEvent;
	}
}
