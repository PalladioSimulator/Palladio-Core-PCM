using System;
using ComponentNetworkSimulation.Analysis;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// Zusammenfassung für ThreadLogEventArgs.
	/// </summary>
	public class ThreadLogEventArgs : BasicLogEventArgs
	{
		#region definition

		public enum EventType {THREAD_CREATED, THREAD_ENTERED_TIMECONSUMER, THREAD_EXITED_TIMECONSUMER, THREAD_REACHED_END};

		#endregion

		#region data

		protected ISimulationThread theThread;

		protected ThreadLogEventArgs.EventType type;

		protected ITimeConsumer timeConsumer;

		#endregion

		#region constructors

		public ThreadLogEventArgs(String message, ISimulationThread theThread, ThreadLogEventArgs.EventType type, 
			ITimeConsumer timeConsumer) : base(message)
		{
			this.theThread = theThread;
			this.type = type;
			this.timeConsumer = timeConsumer;
		}

		#endregion

		#region properties

		public ISimulationThread TheThread
		{
			get {return this.theThread;}
		}

		public ThreadLogEventArgs.EventType TheType
		{
			get {return this.type;}
		}

		public ITimeConsumer TheTimeConsumer 
		{
			get {return this.timeConsumer;}
		}

		#endregion
	}
}
