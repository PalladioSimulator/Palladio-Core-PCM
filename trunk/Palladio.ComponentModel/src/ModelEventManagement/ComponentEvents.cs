using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This class provides all events that can be fired from a component in the componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/04/05 14:23:59  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.1  2005/03/29 13:05:37  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class ComponentEvents : EntityEvents
	{
		#region constructor

		/// <summary>
		/// called to create a eventstructure for a component
		/// </summary>
		/// <param name="component">the component</param>
		public ComponentEvents(IComponent component) : base(component)
		{
		}


		#endregion
		
		#region internal notify methods
		
		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyProvidesInterfaceAdded(object sender, InterfaceBuildEventArgs args)
		{
			if (ProvidesInterfaceAddedEvent != null)
				ProvidesInterfaceAddedEvent(sender, args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyRequiresInterfaceAdded(object sender, InterfaceBuildEventArgs args)
		{
			if (RequiresInterfaceAddedEvent != null)
				RequiresInterfaceAddedEvent(sender, args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyInterfaceRemoved(object sender, InterfaceBuildEventArgs args)
		{
			if (InterfaceRemovedEvent != null)
				InterfaceRemovedEvent(sender, args);
		}

		#endregion

		#region events

		/// <summary>
		/// fired, when an interfaces has been added to the requires side of a component
		/// </summary>
		public event InterfaceBuildEventHandler ProvidesInterfaceAddedEvent;

		/// <summary>
		/// fired, when an interfaces has been added to the provides side of a component
		/// </summary>
		public event InterfaceBuildEventHandler RequiresInterfaceAddedEvent;

		/// <summary>
		/// fired, when an interface has been removed from the component
		/// </summary>
		public event InterfaceBuildEventHandler InterfaceRemovedEvent;

		#endregion
	}
}
