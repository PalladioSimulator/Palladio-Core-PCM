using System;

namespace Palladio.Simulation.Simulation
{
	/// <summary>
	/// This class extends the class EventArgs. It is used in ThreadLifeCycleEventHandler.
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
	public class ThreadLifeCycleEventArgs : EventArgs
	{
		/// <summary>
		/// holds the simulation thread
		/// </summary>
		private ISimulationThread theThread;

		/// <summary>
		/// constructs a new ThreadLifeCycleEventArgs object
		/// </summary>
		/// <param name="theThread">the simulation thread</param>
		public ThreadLifeCycleEventArgs(ISimulationThread theThread)
		{
			this.theThread = theThread;
		}

		/// <summary>
		/// return the simulationthread
		/// </summary>
		public ISimulationThread TheThread 
		{
			get {return this.theThread;}
		}
	}
}
//EOF