namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This interface provides all events that can be fired from the static view of a componentmodel.
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
	public interface IStaticViewEvents
	{
		/// <summary>
		/// fired, when a component has been added to the static view
		/// </summary>
		event ComponentUseEventHandler ComponentAddedEvent;

		/// <summary>
		/// fired, when a component has been removed from the static view
		/// </summary>
		event ComponentUseEventHandler ComponentRemovedEvent;

		/// <summary>
		/// fired, when an assembly connector has been added to the static view
		/// </summary>
		event AssemblyConnectorBuildEventHandler AssemblyConnectorAddedEvent;

		/// <summary>
		/// fired, when an assembly connector has been removed from the static view
		/// </summary>
		event ConnectorRemovedEventHandler AssembyConnectorRemovedEvent;
	}
}