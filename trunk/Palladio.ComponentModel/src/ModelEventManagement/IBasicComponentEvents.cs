namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This class provides all events that can be fired from a basic component in the componentmodel.
	/// </summary>
	/// 
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
	public interface IBasicComponentEvents : IComponentEvents
	{
		/// <summary>
		/// fired, when a seff has been added to the basic component
		/// </summary>
		event SeffBuildEventHandler SeffAddedEvent;

		/// <summary>
		/// fired, when a seff has been removed from a basic component
		/// </summary>
		event SeffBuildEventHandler SeffRemovedEvent;
	}
}