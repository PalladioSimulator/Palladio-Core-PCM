namespace Palladio.Simulation.Simulation
{
	/// <summary>
	/// This interface defines all methods, properties and events provided by a simulation thread.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/07/22 20:28:18  joemal
	/// - changed some comments
	///
	/// Revision 1.1  2004/07/20 11:46:42  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface ISimulationThread
	{
		#region events

		/// <summary>
		/// This event is fired, if the current TimeConsumer has changed to the next one in the controlflow of the thread.
		/// </summary>
		event NextTCEventHandler NextTCEvent;

		#endregion events

		#region properties

		/// <summary>
		/// returns the current TimeConsumer
		/// </summary>
		Palladio.Simulation.Model.ITimeConsumer CurrentTimeConsumer
		{
			get;
		}

		/// <summary>
		/// this is the difference between the current simulationtime and the threads current time.
		/// </summary>
		long TimeInFuture 
		{
			get;
		}

		/// <summary>
		/// is true, if the thread has a following TimeConsumer
		/// </summary>
		bool IsAlive 
		{
			get;
		}

		/// <summary>
		/// returns the id of the thread
		/// </summary>
		int ThreadID
		{
			get;
		}

		/// <summary>
		/// returns the type of this thread
		/// </summary>
		SimulationThreadType TheType
		{
			get;
		}

		#endregion

		#region methods

		/// <summary>
		/// call to start the thread. This method usually is started by the scheduler, when the thread is inserted in the queue
		/// of threads. This method only shall be called only once in the whole lifecycle of the thread.
		/// </summary>
		void Start();

		/// <summary>
		/// called to increase the timeline of the thread.
		/// </summary>
		/// <param name="time">the timestep to be increased.</param>
		void TimeMoved(long time);

		#endregion
	}
}
//EOF
