namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This interface defines all methods, properties and events provided by a SimulationThread.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.5  2004/07/02 16:20:12  joemal
	/// - now the threads must be started, after they have been created
	///
	/// Revision 1.4  2004/05/26 16:29:53  joemal
	/// add cvs log tag
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface ISimulationThread
	{
		#region events

		/// <summary>
		/// This event is fired, if the TimeConsumer has changed to next one
		/// </summary>
		event NextTCEventHandler NextTCEvent;

		#endregion events

		#region properties

		/// <summary>
		/// the current TimeConsumer
		/// </summary>
		ComponentNetworkSimulation.Structure.ITimeConsumer CurrentTimeConsumer
		{
			get;
		}

		/// <summary>
		/// this time contains the difference between the simulation time and the threads current state time.
		/// </summary>
		long TimeInFuture 
		{
			get;
		}

		/// <summary>
		/// is true, if the thread already has any following TimeConsumer 
		/// </summary>
		bool IsAlive 
		{
			get;
		}

		/// <summary>
		/// the id of the thread
		/// </summary>
		int ThreadID
		{
			get;
		}

		/// <summary>
		/// returns the type of the thread
		/// </summary>
		SimulationThreadType TheType
		{
			get;
		}

		#endregion

		#region methods

		/// <summary>
		/// call to start the thread. This method normaly is started by the scheduler when it is inserted in the queue
		/// of threads. This method only must be called one time in the whole lifecycle of the thread.
		/// </summary>
		void Start();

		/// <summary>
		/// called to move the timeline of the thread.
		/// </summary>
		/// <param name="time">The timestep to be moved.</param>
		void TimeMoved(long time);

		#endregion
	}
}
//EOF
