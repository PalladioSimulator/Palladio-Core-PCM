using System;
using ComponentNetworkSimulation.Analysis;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This declaration is used to define a eventhandler for timestep events.
	/// TimeStepEvents are fired on every finished simulationstep.
	/// </summary>
	public delegate void TimeStepEventHandler(object sender, TimeStepEventArgs eventArgs);

	/// <summary>
	/// This interface defines all methods, properties and events, the clock of the simulation environment provides.
	/// </summary>
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

		#endregion

		#region methods

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
