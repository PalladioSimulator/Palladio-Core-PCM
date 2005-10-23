namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This interface provides all events that can be fired from the repository in the componentmodel.
	/// The repository holds all components and interfaces of the model.
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
	public interface IRepositoryEvents
	{
		/// <summary>
		/// fired, when a component has been added 
		/// </summary>
		event ComponentBuildEventHandler ComponentAddedEvent;

		/// <summary>
		/// fired, when a component has been removed 
		/// </summary>
		event ComponentBuildEventHandler ComponentRemovedEvent;

		/// <summary>
		/// fired, when an interfaces has been added 
		/// </summary>
		event InterfaceBuildEventHandler InterfaceAddedEvent;

		/// <summary>
		/// fired, when an interface has been removed 
		/// </summary>
		event InterfaceBuildEventHandler InterfaceRemovedEvent;
	}
}
