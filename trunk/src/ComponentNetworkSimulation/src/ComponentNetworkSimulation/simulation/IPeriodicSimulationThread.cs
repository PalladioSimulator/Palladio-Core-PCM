using System;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This interface extends a SimulationThread to provide some additional methods, events and properties, used for
	/// periodic threads.
	/// </summary>
	public interface IPeriodicSimulationThread
	{
		#region events
		
		/// <summary>
		/// this event is fired, when the timeline of the thread reached the periodlength.
		/// </summary>
		event EventHandler NewPeriodicThreadEvent;

		#endregion

		#region properties

		/// <summary>
		/// return the length of the periodlength of this thread
		/// </summary>
		long PeriodLength 
		{
			get;
		}

		/// <summary>
		/// return the periodID of this thread.
		/// </summary>
		int PeriodID 
		{
			get;
		}
		#endregion

		#region methods

		/// <summary>
		/// This method creates a new thread with same periodID, firstTimeConsumer, observer and periodLength like this one.
		/// It is called when the scheduler is notified to create a new thread.
		/// </summary>
		/// <param name="newThreadID">The id of the new thread.</param>
		/// <returns>the new thread</returns>
		ISimulationThread CreateFollowingThread(int newThreadID);

		#endregion
	}
}
//EOF
