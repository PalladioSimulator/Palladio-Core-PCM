using System;

namespace Palladio.ComponentModel
{
	#region interface

	/// <summary>
	/// Service information is additional data attached to a certain
	/// service effect specification. For example service effect information specified by the means
	/// of FSMs, Petri Nets, .... or constraints given as pre- and postconditions or
	/// OCL constraints.<br />
	/// Implement this interface if you want to add further additional specification data
	/// to an service effect specification.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1.2.1  2005/02/18 13:32:58  joemal
	/// xxx
	///
	///
	/// </pre>
	/// </remarks>
	public interface IServiceInformation : ISerializable
	{
		/// <summary>
		/// Event handler handling notifications of changes in the underlying service list.
		/// This event handler is for implementing an observer pattern on the service list so that
		/// any kind of information structure can stay consistend. For example, an FSM specification
		/// automaton used this events to update its input symbol set accordingly. 
		/// </summary>
		/// <param name="sender">The service list being changed</param>
		/// <param name="args">The event args specifing the event in more detail</param>
		void ServiceListChangeEventHandler(object sender, ServiceListChangeEventArgs args);
	}

	#endregion 

	#region eventargs
	/// <summary>
	/// This is a class used as event arguments for ServiceListChangeEvents.
	/// </summary>
	public class ServiceListChangeEventArgs
	{
		private ChangeTimeEnum time;
		private ChangeTypeEnum type;
		private IService service;

		/// <summary>
		/// The service being added or deleted from the service list raising the event
		/// </summary>
		public IService Service
		{
			get
			{
				return service;
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
		/// Kind of the change made to the service list raising the event
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
		/// <param name="item">The Service being added or deleted</param>
		/// <param name="time">The state of the process</param>
		/// <param name="type">Is the service added or deleted</param>
		public ServiceListChangeEventArgs(IService service, ChangeTimeEnum time, ChangeTypeEnum type)
		{
			this.time = time;
			this.type = type;
			this.service = service;
		}
	}
	#endregion

	#region delegate
	/// <summary>
	/// The event delegate for ServiceListChangeEvents
	/// </summary>
	public delegate void ServiceListChangeEventHandler(object sender, ServiceListChangeEventArgs args);
	#endregion
}
