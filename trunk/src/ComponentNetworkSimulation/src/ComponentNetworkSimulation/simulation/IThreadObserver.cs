using System;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.simulation
{
	/// <summary>
	/// This interface declares implementing classes as observer for simulationthreads. Each created thread may have 
	/// one of these observers.
	/// </summary>
	public interface IThreadObserver
	{
		/// <summary>
		/// called, when the thread reaches the end of its control flow.
		/// </summary>
		/// <param name="sender">the thread</param>
		void NotifyThreadReachedEnd(SimulationThread sender);

		/// <summary>
		/// called, when the current timeconsumer of the thread has changed
		/// </summary>
		/// <param name="sender">the thread</param>
		/// <param name="previous">the previous timeconsumer</param>
		void NotifyThreadChangedTimeConsumer(SimulationThread sender, TimeConsumer previous);

		/// <summary>
		/// called, when the timeline of the thread move
		/// </summary>
		/// <param name="sender">the thread</param>
		/// <param name="timeStep">the timestep, the timeline moved</param>
		void NotifyTimeStep(SimulationThread sender, long timeStep);
	}
}
//EOF