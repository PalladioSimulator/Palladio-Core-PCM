using System;
using Palladio.Simulation.Model;

namespace Palladio.Simulation.Simulation
{
	/// <summary>
	/// This class extends the class EventArgs. It is used in TimeStepEventHandler.
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
	public class TimeStepEventArgs : EventArgs
	{
		#region declaration

		/// <summary>
		/// added to the field <code>cause</code> in order to indicate that the event 
		/// was fired by a thread, that reached its time in future.
		/// </summary>
		public const int THREAD_REACHED_TIME_IN_FUTURE = 1;
		
		/// <summary>
		/// added to the field <code>cause</code> in order to indicate that the event 
		/// was fired by the clock, that reached its ClockStopTime
		/// </summary>
		public const int CLOCK_STOP_EVENT = 2;

		/// <summary>
		/// added to the field <code>cause</code> in order to indicate that the event 
		/// was fired by the clock, that reached its maximum simulationtime
		/// </summary>
		public const int MAX_TIME_REACHED = 4;

		#endregion

		#region data

		/// <summary>
		/// the field, which holds the timestep
		/// </summary>
		private long timeStep;

		/// <summary>
		/// the field, which holds the current simulation time
		/// </summary>
		private long currentSimulationTime;

		/// <summary>
		/// the field, which holds a combination of causes that let the timestep end at this time
		/// </summary>
		private int cause;

		#endregion

		#region constructor
		/// <summary>
		/// constructs a new TimeStepEventArgs object
		/// </summary>
		/// <param name="timeStep">the timestep</param>
		/// <param name="currentSimulationTime">the current simulation time</param>
		/// <param name="cause">the cause, that let the timestep end here. This can be a combination of the
		/// constants, defined in <code>TimeStepEventArgs</code></param>
		public TimeStepEventArgs(long timeStep, long currentSimulationTime, int cause)
		{
			this.timeStep = timeStep;
			this.currentSimulationTime = currentSimulationTime;
			this.cause = cause;
		}

		#endregion

		#region properties

		/// <summary>
		/// returns the timestep
		/// </summary>
		public long TimeStep
		{
			get{ return this.timeStep;}
		}

		/// <summary>
		/// returns the current simulationtime
		/// </summary>
		public long CurrentSimulationTime
		{
			get{ return this.currentSimulationTime;}
		}

		/// <summary>
		/// returns the cause that lets the step end at this time		
		/// </summary>
		public int Cause
		{
			get{ return this.cause;}
		}

		/// <summary>
		/// returns true, if changing the timeconsumer caused this event
		/// </summary>
		public bool IsThreadChangingTimeConsumer
		{
			get{ return (this.cause & THREAD_REACHED_TIME_IN_FUTURE) != 0;}
		}

		/// <summary>
		/// returns true, if a ClockStopEvent caused this event
		/// </summary>
		public bool IsClockStopEvent
		{
			get{ return (this.cause & CLOCK_STOP_EVENT) != 0;}
		}

		/// <summary>
		/// returns true, if reaching the maximum simulationtime caused this event
		/// </summary>
		public bool IsMaximumSimulationTimeReached
		{
			get{ return (this.cause & MAX_TIME_REACHED) != 0;}
		}		

		#endregion
	}
}
//EOF