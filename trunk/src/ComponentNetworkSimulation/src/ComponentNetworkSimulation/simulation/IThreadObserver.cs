using System;
using ComponentNetworkSimulation.Structure;
using Palladio.ComponentModel;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This interface declares implementing classes as observer for simulationthreads. Each created thread may have 
	/// one of these observers.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.7  2004/06/23 16:32:18  joemal
	/// - add sender attribute to some methods of the observer
	///
	/// Revision 1.6  2004/06/19 13:48:49  joemal
	/// - add some methods to the observer
	///
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

		/// <summary>
		/// called, if the componentarchitecture contains unknown elements. The controlflow of this thread is stopped.
		/// And the thread is removed from the scheduler.
		/// </summary>
 		/// <param name="sender">the thread</param>
		void NotifyUnknownElementFound(ISimulationThread sender);

		/// <summary>
		/// called, when a signature of the requires interface of a component is called by the thread but not bound 
		/// with any provides interface of another component. The thread follows the way through its controlflow 
		/// without invoking this call.
		/// </summary>
		/// <param name="callingComponent">the calling component</param>
		/// <param name="externalSignature">the signature of this call</param>
		/// <param name="sender">the thread</param>
		void NotifyUnboundExternalCall(ISimulationThread sender,IComponent callingComponent, 
			IExternalSignature externalSignature);
	}
}
//EOF