namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This class provides all events that can be fired from any entity in the componentmodel.
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
	public class EntityEvents
	{
		#region constructor
		/// <summary>
		/// no need to be used from outside of the assembly
		/// </summary>
		internal EntityEvents(){}

		#endregion

		#region notify methods

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyAttributeChangedEvent(object sender, AttributeChangedEventArgs args)
		{
			if (AttributeChangedEvent != null)
				AttributeChangedEvent(sender, args);
		}

		#endregion

		#region events
		
		/// <summary>
		/// fired, when an attribute of the attribute hashtable has been changed
		/// </summary>
		public event AttributeChangedEventHandler AttributeChangedEvent;

		#endregion
	}
}
