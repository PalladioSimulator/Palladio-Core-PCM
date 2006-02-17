using System;

namespace Palladio.Simulation.Simulation
{
	/// <summary>
	/// This class extends the class EventArgs. It is used in ThreadLifeCycleEventHandler.
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
	public class ThreadLifeCycleEventArgs : EventArgs
	{
		/// <summary>
		/// holds the simulation thread
		/// </summary>
		private ISimulationThread theThread;

		/// <summary>
		/// constructs a new <c>ThreadLifeCycleEventArgs</c> object
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