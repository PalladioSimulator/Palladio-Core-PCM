using System;
using ComponentNetworkSimulation.Structure;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This interface declares implementing classes as observer for simulationthreads. Each created thread may have 
	/// one of these observers.
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
	public interface IThreadObserver
	{
		/// <summary>
		/// called, when the thread reaches the end of its control flow.
		/// </summary>
		/// <param name="sender">the thread</param>
		void NotifyThreadReachedEnd(ISimulationThread sender);

		/// <summary>
		/// called, when the current TimeConsumer of the thread has changed
		/// </summary>
		/// <param name="sender">the thread</param>
		/// <param name="previous">the previous TimeConsumer</param>
		void NotifyThreadChangedTimeConsumer(ISimulationThread sender, ITimeConsumer previous);

		/// <summary>
		/// called, when the timeline of the thread move
		/// </summary>
		/// <param name="sender">the thread</param>
		/// <param name="timeStep">the timestep, the timeline moved</param>
		void NotifyTimeStep(ISimulationThread sender, long timeStep);
	}
}
//EOF