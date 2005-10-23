namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This class provides all events that can be fired from a composite component in the componentmodel.
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
	public interface ICompositeComponentEvents : IComponentEvents
	{
		/// <summary>
		/// fired, when a component has been added to the composite component
		/// </summary>
		event ComponentUseEventHandler ComponentAddedEvent;

		/// <summary>
		/// fired, when a component has been removed from the composite component
		/// </summary>
		event ComponentUseEventHandler ComponentRemovedEvent;

		/// <summary>
		/// fired, when an assembly connector has been added to the composite component
		/// </summary>
		event AssemblyConnectorBuildEventHandler AssemblyConnectorAddedEvent;

		/// <summary>
		/// fired, when a delegation connector has been added to the composite component
		/// </summary>
		event DelegationConnectorBuildEventHandler DelegationConnectorAddedEvent;

		/// <summary>
		/// fired, when a connector has been removed from the composite component
		/// </summary>
		event ConnectorRemovedEventHandler ConnectorRemovedEvent;
	}
}