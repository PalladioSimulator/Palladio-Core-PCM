using System;
using ComponentNetworkSimulation.Analysis;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This class extends BasicLogEventArgs in order to add some parameters belong to a log from a thread.
	/// </summary>
	public class ThreadLogEventArgs : BasicLogEventArgs
	{
		#region declaration

		/// <summary>
		/// declaration of the type of thread log event
		/// </summary>
		public enum EventType {THREAD_CREATED, THREAD_ENTERED_TIMECONSUMER, THREAD_EXITED_TIMECONSUMER, THREAD_REACHED_END};

		#endregion

		#region data

		/// <summary>
		/// the thread that fired this event
		/// </summary>
		protected ISimulationThread simulationThread;

		/// <summary>
		/// the type of event
		/// </summary>
		protected ThreadLogEventArgs.EventType type;

		/// <summary>
		/// the timeConsumer
		/// </summary>
		protected ITimeConsumer timeConsumer;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new instance of ThreadLogEventArgs 
		/// </summary>
		/// <param name="message">the log message</param>
		/// <param name="theThread">the thread, that fired this event</param>
		/// <param name="type">the type of the event</param>
		/// <param name="timeConsumer">the timeconsumer</param>
		public ThreadLogEventArgs(String message, ISimulationThread simulationThread, ThreadLogEventArgs.EventType type, 
			ITimeConsumer timeConsumer) : base(message)
		{
			this.simulationThread = simulationThread;
			this.type = type;
			this.timeConsumer = timeConsumer;
		}

		#endregion

		#region properties

		/// <summary>
		/// the thread that fired this event
		/// </summary>
		public ISimulationThread SimulationThread
		{
			get {return this.simulationThread;}
		}

		/// <summary>
		/// the type of this event
		/// </summary>
		public ThreadLogEventArgs.EventType TheType
		{
			get {return this.type;}
		}

		/// <summary>
		/// the timeconsumer
		/// </summary>
		public ITimeConsumer TimeConsumer 
		{
			get {return this.timeConsumer;}
		}

		#endregion
	}
}
//EOF
