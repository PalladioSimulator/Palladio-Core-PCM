namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This class provides all events that can be fired from the repository in the componentmodel.
	/// The repository holds all components and interfaces of the model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/06/05 10:28:35  joemal
	/// initial creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class RepositoryEvents
	{
		#region constructor

		/// <summary>
		/// called to create a eventstructure for the repository
		/// </summary>
		internal RepositoryEvents()
		{
		}

		#endregion

		#region notify methods

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyComponentAdded(object sender, ComponentBuildEventArgs args)
		{
			if (ComponentAddedEvent != null)
				ComponentAddedEvent(sender, args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyComponentRemoved(object sender, ComponentBuildEventArgs args)
		{
			if (ComponentRemovedEvent != null)
				ComponentRemovedEvent(sender, args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyInterfaceAdded(object sender, InterfaceBuildEventArgs args)
		{
			if (InterfaceAddedEvent != null)
				InterfaceAddedEvent(sender, args);
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
		/// fired, when a component has been added 
		/// </summary>
		public event ComponentBuildEventHandler ComponentAddedEvent;

		/// <summary>
		/// fired, when a component has been removed 
		/// </summary>
		public event ComponentBuildEventHandler ComponentRemovedEvent;

		/// <summary>
		/// fired, when an interfaces has been added 
		/// </summary>
		public event InterfaceBuildEventHandler InterfaceAddedEvent;

		/// <summary>
		/// fired, when an interface has been removed 
		/// </summary>
		public event InterfaceBuildEventHandler InterfaceRemovedEvent;

		#endregion

	}
}
