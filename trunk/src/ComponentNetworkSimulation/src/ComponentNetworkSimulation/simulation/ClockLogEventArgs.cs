using System;
using ComponentNetworkSimulation.Analysis;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This class extends BasicLogEventArgs in order to add some parameters belong to a log from the clock.
	/// </summary>
	public class ClockLogEventArgs : BasicLogEventArgs
	{
		#region declaration
		
		/// <summary>
		/// declaration of the type of clock log event
		/// </summary>
		public enum EventType {CLOCK_RESET, CLOCK_STEP, CLOCK_REACHED_MAXTIME, CLOCK_NO_MORE_THREADS};

		#endregion

		#region data		
		
		/// <summary>
		/// the length of the timestep. 
		/// </summary>
		protected long timeStep;

		/// <summary>
		/// the type of clock log event
		/// </summary>
		protected ClockLogEventArgs.EventType type;

		/// <summary>
		/// the clock, that fired this event
		/// </summary>
		protected IClock clock;

		#endregion

		#region constructor

		/// <summary>
		/// constructs a new ClockLogEvent
		/// </summary>
		/// <param name="message">the log message of this event</param>
		/// <param name="theClock">the clock </param>
		/// <param name="type">the type of event</param>
		/// <param name="timeStep">the length of the timestep</param>
		public ClockLogEventArgs(String message, IClock clock, ClockLogEventArgs.EventType type, long timeStep) :
			base(message)
		{
			this.clock = clock;
			this.type = type;
			this.timeStep = timeStep;
		}

		#endregion

		#region properties
		
		/// <summary>
		/// returns the reference to the clock, that fired this event
		/// </summary>
		public IClock Clock
		{
			get {return this.clock;}
		}

		/// <summary>
		/// returns the type of event
		/// </summary>
		public ClockLogEventArgs.EventType TheType
		{
			get {return this.type;}
		}

		/// <summary>
		/// return the timestep
		/// </summary>
		public long TimeStep 
		{
			get {return this.timeStep;}
		}

		#endregion
	}
}
//EOF