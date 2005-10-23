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
	/// Revision 1.4  2005/10/23 16:26:42  kelsaka
	/// - extracted event interfaces to make the events adaptable
	/// - made event classes internal
	///
	/// Revision 1.3  2005/06/05 10:40:06  joemal
	/// - components now can be added to more than one container
	///
	/// Revision 1.2  2005/04/04 16:27:28  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.1  2005/03/29 13:05:37  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class StaticViewEvents : IStaticViewEvents
	{
		#region internal notify methods
		
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
		internal void NotifyAssemblyConnectorRemoved(object sender, ConnectorRemovedEventArgs args)
		{
			if (AssembyConnectorRemovedEvent != null)
				AssembyConnectorRemovedEvent(sender,args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyComponentAdded(object sender, ComponentUseEventArgs args)
		{
			if (ComponentAddedEvent != null)
				ComponentAddedEvent(sender, args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyComponentRemoved(object sender, ComponentUseEventArgs args)
		{
			if (ComponentRemovedEvent != null)
				ComponentRemovedEvent(sender, args);
		}

		#endregion

		#region constructor

		/// <summary>
		/// no need to be used from outside of the assembly
		/// </summary>
		public StaticViewEvents(){}

		#endregion

		#region events

		/// <summary>
		/// fired, when a component has been added to the static view
		/// </summary>
		public event ComponentUseEventHandler ComponentAddedEvent;

		/// <summary>
		/// fired, when a component has been removed from the static view
		/// </summary>
		public event ComponentUseEventHandler ComponentRemovedEvent;

		/// <summary>
		/// fired, when an assembly connector has been added to the static view
		/// </summary>
		public event AssemblyConnectorBuildEventHandler AssemblyConnectorAddedEvent;

		/// <summary>
		/// fired, when an assembly connector has been removed from the static view
		/// </summary>
		public event ConnectorRemovedEventHandler AssembyConnectorRemovedEvent;

		#endregion
	}
}
