using System;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This class extends the class EventArgs. It is used in TimeStepEventHandler.
	/// </summary>
	public class TimeStepEventArgs : EventArgs
	{
		/// <summary>
		/// the field which holds the timestep
		/// </summary>
		private long timeStep;

		/// <summary>
		/// the field which holds the current simulation time
		/// </summary>
		private long currentSimulationTime;

		/// <summary>
		/// constructs a new TimeStepEventArgs object
		/// </summary>
		/// <param name="timeStep">the timestep</param>
 		/// <param name="currentSimulationTime">the current simulation time</param>
		public TimeStepEventArgs(long timeStep, long currentSimulationTime)
		{
			this.timeStep = timeStep;
			this.currentSimulationTime = currentSimulationTime;
		}

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
	}
}
//EOF