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
	/// Revision 1.3  2004/07/29 15:13:48  joemal
	/// - changes from the review
	///
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
		/// the enumeration of causes that can make the scheduler to let the simulationstep end here
		/// </summary>
		public enum CauseType_t
		{		
			/// <summary>
			/// added to the field <c>cause</c> in order to indicate that the event 
			/// was fired by a thread, that reached its time in future.
			/// </summary>
			THREAD_REACHED_TIME_IN_FUTURE,
		
			/// <summary>
			/// added to the field <c>cause</c> in order to indicate that the event 
			/// was fired by the clock, that reached its ClockStopTime
			/// </summary>
			CLOCK_STOP_EVENT,

			/// <summary>
			/// added to the field <c>cause</c> in order to indicate that the event 
			/// was fired by the clock, that reached its maximum simulationtime
			/// </summary>
			MAX_TIME_REACHED
		}

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
		private TimeStepEventArgs.CauseType_t cause;

		#endregion

		#region constructor
		/// <summary>
		/// constructs a new TimeStepEventArgs object
		/// </summary>
		/// <param name="timeStep">the timestep</param>
		/// <param name="currentSimulationTime">the current simulation time</param>
		/// <param name="cause">the cause, that let the timestep end here. This can be a combination of the
		/// constants, defined in <c>TimeStepEventArgs</c></param>
		public TimeStepEventArgs(long timeStep, long currentSimulationTime, CauseType_t cause)
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
		public TimeStepEventArgs.CauseType_t Cause
		{
			get{ return this.cause;}
		}

		/// <summary>
		/// returns true, if changing the timeconsumer caused this event
		/// </summary>
		public bool IsThreadChangingTimeConsumer
		{
			get{ return (this.cause & CauseType_t.THREAD_REACHED_TIME_IN_FUTURE) != 0;}
		}

		/// <summary>
		/// returns true, if a ClockStopEvent caused this event
		/// </summary>
		public bool IsClockStopEvent
		{
			get{ return (this.cause & CauseType_t.CLOCK_STOP_EVENT) != 0;}
		}

		/// <summary>
		/// returns true, if reaching the maximum simulationtime caused this event
		/// </summary>
		public bool IsMaximumSimulationTimeReached
		{
			get{ return (this.cause & CauseType_t.MAX_TIME_REACHED) != 0;}
		}		

		#endregion
	}
}
//EOF