using System;
using Palladio.Simulation.Analysis;

namespace Palladio.Simulation.Simulation
{
	/// <summary>
	/// This declaration is used to define a eventhandler for timestep events.
	/// TimeStepEvents are fired on every finished simulationstep.
	/// </summary>
	public delegate void TimeStepEventHandler(object sender, TimeStepEventArgs eventArgs);

	/// <summary>
	/// This interface defines all methods, properties and events, the clock of the simulation environment provides.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:42  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IClock
	{
		#region events

		/// <summary>
		/// This event is fired, when the timeline of the clock moves a step. The arguments of this events contains
		/// the step length and the new absolute time.
		/// </summary>
		event TimeStepEventHandler TimeStepEvent;

		/// <summary>
		/// This event is fired, when the maximum simulation time s reached
		/// </summary>
		event EventHandler MaxTimeReachedEvent;

		/// <summary>
		/// This event is fired, when the clock was reseted.
		/// </summary>
		event EventHandler ClockResetEvent;

		/// <summary>
		/// This event is fired, when the clock wants something to be logged by the datapool
		/// </summary>
		event LogEventHandler ClockLogEvent;

		#endregion

		#region Properties

		/// <summary>
		/// This property sets and returns the maximum simulation time.
		/// </summary>
		long MaximumSimulationTime 
		{
			get ;
			set ;
		}

		/// <summary>
		/// return the instance of IThreadScheduler
		/// </summary>
		IThreadScheduler ThreadScheduler
		{
			get;
		}

		/// <summary>
		/// return the current absolute simulation time
		/// </summary>
		long CurrentTime
		{
			get;
		}

		/// <summary>
		/// returns true, if the maximum simulation time is reached 
		/// </summary>
		bool IsMaxTimeReached 
		{
			get;
		}

		/// <summary>
		/// returns true, if any next step is possible at calling time
		/// </summary>
		bool HasNextStep
		{
			get;
		}

		#endregion

		#region methods

		/// <summary>
		/// call to set the time, after which the simulation has to fire a TimeStepEvent with cause CLOCK_STOP_EVENT.
		/// The clock might finish other steps before.
		/// </summary>
		/// <param name="time">the time, after which a TimeStepEvent has to be fired</param>
		void SetClockStopEventTime(long time);

		/// <summary>
		/// call to simulate one step
		/// </summary>
		/// <returns>returns false, if the simulation reached its end</returns>
		bool SimulationStep();

		/// <summary>
		/// called to reset the current simulation.
		/// </summary>
		void Reset(); 
		
		#endregion
	}
}
//EOF
