using System;

namespace Palladio.ComponentModel
{
	#region interface
	/// <summary>
	/// Protocol information is additional specification data attached to a certain
	/// interface model. For example protocol information specified by the means
	/// of FSMs, Petri Nets, .... or constraints given as pre- and postconditions or
	/// OCL constraints.<br />
	/// Implement this interface if you want to add further additional specification data
	/// to an interface model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1.2.1  2005/02/18 13:32:58  joemal
	/// xxx
	///
	/// </pre>
	/// </remarks>
	public interface IProtocolInformation : ISerializable
	{
		/// <summary>
		/// Event handler handling notifications of changes in the underlying signature list.
		/// This event handler is for implementing an observer pattern on the signature list so that
		/// any kind of auxiliary information can stay consistend. For example, an FSM protocol
		/// automaton used this events to update its input symbol set accordingly. 
		/// </summary>
		/// <param name="sender">The signature list being changed</param>
		/// <param name="args">The event args specifing the event in more detail</param>
		void SignatureListChangeEventHandler(object sender, SignatureListChangeEventArgs args);
	}	
	#endregion

	#region eventargs
	/// <summary>
	/// This is a class used as event arguments for SignatureListChangeEvents.
	/// </summary>
	public class SignatureListChangeEventArgs
	{
		private ChangeTimeEnum time;
		private ChangeTypeEnum type;
		private ISignature item;

		/// <summary>
		/// The signature being added or deleted from the signature list raising the event
		/// </summary>
		public ISignature Signature
		{
			get
			{
				return item;
			}
		}
		
		/// <summary>
		/// Point in the process when this event occured
		/// </summary> 
		public ChangeTimeEnum ChangeTime
		{
			get
			{
				return time;
			}
		}

		/// <summary>
		/// Kind of the change made to the signature list raising the event
		/// </summary>
		public ChangeTypeEnum ChangeType
		{
			get
			{
				return type;
			}
		}

		/// <summary>
		/// Default constructor
		/// </summary>
		/// <param name="item">The Signature being added or deleted</param>
		/// <param name="time">The state of the process</param>
		/// <param name="type">Is the signature added or deleted</param>
		public SignatureListChangeEventArgs(ISignature item, ChangeTimeEnum time, ChangeTypeEnum type)
		{
			this.time = time;
			this.type = type;
			this.item = item;
		}
	}

	#endregion
	
	#region delegate
	
	/// <summary>
	/// The event delegate for SignatureListChangeEvents
	/// </summary>
	public delegate void SignatureListChangeEventHandler(object sender, SignatureListChangeEventArgs args);
	
	#endregion
}
