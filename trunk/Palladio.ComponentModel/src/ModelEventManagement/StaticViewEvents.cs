namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This class provides all events that can be fired from the static view of a componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/29 13:05:37  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class StaticViewEvents
	{
		#region internal notify methods
		
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

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyAssemblyConnectorAdded(object sender, AssemblyConnectorBuildEventArgs args)
		{
			if (AssemblyConnectorAddedEvent != null)
				AssemblyConnectorAddedEvent(sender, args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyAssemblyConnectorRemoved(object sender, AssemblyConnectorBuildEventArgs args)
		{
			if (AssembyConnectorRemovedEvent != null)
				AssemblyConnectorAddedEvent(sender, args);
		}

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

		#endregion

		#region constructor

		/// <summary>
		/// no need to be used from outside of the assembly
		/// </summary>
		internal StaticViewEvents(){}

		#endregion

		#region events

		/// <summary>
		/// fired, when an interfaces has been added to the static view
		/// </summary>
		public event InterfaceBuildEventHandler InterfaceAddedEvent;

		/// <summary>
		/// fired, when an interface has been removed from the static view
		/// </summary>
		public event InterfaceBuildEventHandler InterfaceRemovedEvent;

		/// <summary>
		/// fired, when a component has been added to the static view
		/// </summary>
		public event ComponentBuildEventHandler ComponentAddedEvent;

		/// <summary>
		/// fired, when a component has been removed from the static view
		/// </summary>
		public event ComponentBuildEventHandler ComponentRemovedEvent;

		/// <summary>
		/// fired, when an assembly connector has been added to the static view
		/// </summary>
		public event AssemblyConnectorBuildEventHandler AssemblyConnectorAddedEvent;

		/// <summary>
		/// fired, when an assembly connector has been removed from the static view
		/// </summary>
		public event AssemblyConnectorBuildEventHandler AssembyConnectorRemovedEvent;

		#endregion
	}
}
