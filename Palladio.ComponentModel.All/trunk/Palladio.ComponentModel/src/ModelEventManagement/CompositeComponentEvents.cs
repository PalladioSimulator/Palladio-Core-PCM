using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This class provides all events that can be fired from a composite component in the componentmodel.
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
	/// Revision 1.4  2005/06/05 10:40:06  joemal
	/// - components now can be added to more than one container
	///
	/// Revision 1.3  2005/04/05 14:23:59  joemal
	/// implement the rest of the notification
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
	internal class CompositeComponentEvents : ComponentEvents, ICompositeComponentEvents
	{
		#region constructor

		/// <summary>
		/// called to create a eventstructure for a composite component
		/// </summary>
		/// <param name="component">the component</param>
		internal CompositeComponentEvents(IComponent component) : base(component)
		{
		}

		#endregion

		#region notify methods

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
		internal void NotifyDelegationConnectorAdded(object sender, DelegationConnectorBuildEventArgs args)
		{
			if (DelegationConnectorAddedEvent != null)
				DelegationConnectorAddedEvent(sender, args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyConnectorRemoved(object sender, ConnectorRemovedEventArgs args)
		{
			if (ConnectorRemovedEvent != null)
				ConnectorRemovedEvent(sender, args);
		}

		#endregion
		
		#region events

		/// <summary>
		/// fired, when a component has been added to the composite component
		/// </summary>
		public event ComponentUseEventHandler ComponentAddedEvent;

		/// <summary>
		/// fired, when a component has been removed from the composite component
		/// </summary>
		public event ComponentUseEventHandler ComponentRemovedEvent;

		/// <summary>
		/// fired, when an assembly connector has been added to the composite component
		/// </summary>
		public event AssemblyConnectorBuildEventHandler AssemblyConnectorAddedEvent;

		/// <summary>
		/// fired, when a delegation connector has been added to the composite component
		/// </summary>
		public event DelegationConnectorBuildEventHandler DelegationConnectorAddedEvent;

		/// <summary>
		/// fired, when a connector has been removed from the composite component
		/// </summary>
		public event ConnectorRemovedEventHandler ConnectorRemovedEvent;

		#endregion

	}
}
