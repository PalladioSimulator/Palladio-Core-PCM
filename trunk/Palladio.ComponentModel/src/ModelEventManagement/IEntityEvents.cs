namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This interface provides all events that can be fired from any entity in the componentmodel.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/10/23 16:26:42  kelsaka
	/// - extracted event interfaces to make the events adaptable
	/// - made event classes internal
	///
	/// </code>
	/// </remarks>
	public interface IEntityEvents
	{
		/// <summary>
		/// fired, when an attribute of the attribute hashtable has been changed
		/// </summary>
		event AttributeChangedEventHandler AttributeChangedEvent;

		/// <summary>
		/// called when the name of the entity has been changed
		/// </summary>
		event StaticAttributeChangedEventHandler NameChangedEvent;
	}
}