using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This class provides all events that can be fired from a basic component in the componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2005/10/23 16:26:42  kelsaka
	/// - extracted event interfaces to make the events adaptable
	/// - made event classes internal
	///
	/// Revision 1.4  2005/07/29 16:02:47  joemal
	/// now service effect specifications can be added ...
	///
	/// Revision 1.3  2005/06/05 10:40:06  joemal
	/// - components now can be added to more than one container
	///
	/// Revision 1.2  2005/04/05 14:23:59  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.1  2005/03/29 13:05:37  joemal
	/// initial class creation
	///
	/// </pre>
	/// </remarks>
	internal class BasicComponentEvents : ComponentEvents, IBasicComponentEvents
	{
		#region constructor

		/// <summary>
		/// called to create a eventstructure for a basic component
		/// </summary>
		/// <param name="component">the component</param>
		internal BasicComponentEvents(IComponent component) : base(component)
		{
		}

		#endregion

		#region notify methods

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifySeffAdded(object sender, SeffBuildEventArgs args)
		{
			if (SeffAddedEvent != null)
				SeffAddedEvent(sender, args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifySeffRemoved(object sender, SeffBuildEventArgs args)
		{
			if (SeffRemovedEvent != null)
				SeffRemovedEvent(sender, args);
		}

		#endregion
		
		#region events

		/// <summary>
		/// fired, when a seff has been added to the basic component
		/// </summary>
		public event SeffBuildEventHandler SeffAddedEvent;

		/// <summary>
		/// fired, when a seff has been removed from a basic component
		/// </summary>
		public event SeffBuildEventHandler SeffRemovedEvent;

		#endregion
	}
}
