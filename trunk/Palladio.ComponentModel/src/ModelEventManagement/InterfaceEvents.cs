using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This class provides all events that can be fired from a interface in the componentmodel.
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
	public class InterfaceEvents : EntityEvents
	{
		#region constructor

		/// <summary>
		/// called to create a eventstructure for an interface
		/// </summary>
		/// <param name="iface">the interface</param>
		public InterfaceEvents(IInterface iface) : base(iface)
		{
		}


		#endregion

		#region notify methods

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifySignatureAddedEvent(object sender, SignatureBuildEventArgs args)
		{
			if (SignatureAddedEvent != null)
				SignatureAddedEvent(sender, args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifySignatureRemovedEvent(object sender, SignatureBuildEventArgs args)
		{
			if (SignatureRemovedEvent != null)
				SignatureRemovedEvent(sender, args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyProtocolAddedEvent(object sender, ProtocolBuildEventArgs args)
		{
			if (ProtocolAddedEvent != null)
				ProtocolAddedEvent(sender, args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyProtocolRemovedEvent(object sender, ProtocolBuildEventArgs args)
		{
			if (ProtocolRemovedEvent != null)
				ProtocolRemovedEvent(sender, args);
		}

		#endregion

		#region events

		/// <summary>
		/// fired, when a signature has been added to the interface
		/// </summary>
		public event SignatureBuildEventHandler SignatureAddedEvent;

		/// <summary>
		/// fired, when a signature has been removed from the interface
		/// </summary>
		public event SignatureBuildEventHandler SignatureRemovedEvent;

		/// <summary>
		/// fired, when a protocol has been added to the interface
		/// </summary>
		public event ProtocolBuildEventHandler ProtocolAddedEvent;

		/// <summary>
		/// fired, when a protocol has been removed from the interface
		/// </summary>
		public event ProtocolBuildEventHandler ProtocolRemovedEvent;

		#endregion
	}
}
