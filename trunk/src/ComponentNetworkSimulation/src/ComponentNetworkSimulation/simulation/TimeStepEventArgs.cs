using System;
using ComponentNetworkSimulation.Structure;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This class extends the class EventArgs. It is used in TimeStepEventHandler.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.5  2004/05/26 16:29:53  joemal
	/// add cvs log tag
	///
	/// 
	/// </pre>
	/// </remarks>
	public class TimeStepEventArgs : EventArgs
	{
		#region declaration

		/// <summary>
		/// added to cause in order to indicate that the event was fired by a thread, reaching its futuretime
		/// </summary>
		public const int THREAD_REACHED_TIME_IN_FUTURE = 1;
		
		/// <summary>
		/// added to cause in order to indicate that the event was fired by the clock, reaching its ClockStopTime
		/// </summary>
		public const int CLOCK_STOP_EVENT = 2;

		/// <summary>
		/// added to cause in order to indicate that the event was fired by the clock, reaching its maximum simulation time
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
		/// the field, which holds a combination of causes that let the step end at this time
		/// </summary>
		private int cause;

		#endregion

		#region constructor
		/// <summary>
		/// constructs a new TimeStepEventArgs object
		/// </summary>
		/// <param name="timeStep">the timestep</param>
		/// <param name="currentSimulationTime">the current simulation time</param>
		public TimeStepEventArgs(long timeStep, long currentSimulationTime, int cause)
		{
			this.timeStep = timeStep;
			this.currentSimulationTime = currentSimulationTime;
			this.cause = cause;
		}

		#endregion

		#region properties

		/// <summary>
		/// return the timestep
		/// </summary>
		public long TimeStep
		{
			get{ return this.timeStep;}
		}

		/// <summary>
		/// return the current simulation time
		/// </summary>
		public long CurrentSimulationTime
		{
			get{ return this.currentSimulationTime;}
		}

		/// <summary>
		/// the cause to let the step end at this time		
		/// </summary>
		public int Cause
		{
			get{ return this.cause;}
		}

		/// <summary>
		/// returns true, if one of the threads is a cause of this event
		/// </summary>
		public bool IsThreadChangingTimeConsumer
		{
			get{ return (this.cause & THREAD_REACHED_TIME_IN_FUTURE) != 0;}
		}

		/// <summary>
		/// returns true, if one of the threads is a cause of this event
		/// </summary>
		public bool IsClockStopEvent
		{
			get{ return (this.cause & CLOCK_STOP_EVENT) != 0;}
		}

		/// <summary>
		/// returns true, if one of the threads is a cause of this event
		/// </summary>
		public bool IsMaximumSimulationTimeReached
		{
			get{ return (this.cause & MAX_TIME_REACHED) != 0;}
		}		

		#endregion
	}
}
//EOF