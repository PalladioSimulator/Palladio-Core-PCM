using System;

namespace ComponentNetworkSimulation.simulation
{
	/// <summary>
	/// This class extends the class EventArgs. It is used in ThreadLifeCycleEventHandler.
	/// </summary>
	public class ThreadLifeCycleEventArgs : EventArgs
	{
		/// <summary>
		/// holds the simulation thread
		/// </summary>
		private SimulationThread theThread;

		/// <summary>
		/// constructs a new ThreadLifeCycleEventArgs object
		/// </summary>
		/// <param name="theThread">the simulation thread</param>
		public ThreadLifeCycleEventArgs(SimulationThread theThread)
		{
			this.theThread = theThread;
		}

		/// <summary>
		/// return the simulationthread
		/// </summary>
		public SimulationThread TheThread 
		{
			get {return this.theThread;}
		}
	}
}
//EOF