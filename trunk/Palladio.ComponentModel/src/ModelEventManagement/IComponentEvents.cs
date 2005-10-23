namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This interfaces provides all events that can be fired from a component in the componentmodel.
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
	public interface IComponentEvents : IEntityEvents
	{
		/// <summary>
		/// fired, when an interfaces has been added to the requires side of a component
		/// </summary>
		event InterfaceUseEventHandler ProvidesInterfaceAddedEvent;

		/// <summary>
		/// fired, when an interfaces has been added to the provides side of a component
		/// </summary>
		event InterfaceUseEventHandler RequiresInterfaceAddedEvent;

		/// <summary>
		/// fired, when an interface has been removed from the component
		/// </summary>
		event InterfaceUseEventHandler InterfaceRemovedEvent;
	}
}