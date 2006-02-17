namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This interface provides all events that can be fired from a interface in the componentmodel.
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
	public interface IInterfaceEvents : IEntityEvents
	{
		/// <summary>
		/// fired, when a signature has been added to the interface
		/// </summary>
		event SignatureBuildEventHandler SignatureAddedEvent;

		/// <summary>
		/// fired, when a signature has been removed from the interface
		/// </summary>
		event SignatureBuildEventHandler SignatureRemovedEvent;

		/// <summary>
		/// fired, when a protocol has been added to the interface
		/// </summary>
		event ProtocolBuildEventHandler ProtocolAddedEvent;

		/// <summary>
		/// fired, when a protocol has been removed from the interface
		/// </summary>
		event ProtocolBuildEventHandler ProtocolRemovedEvent;
	}
}