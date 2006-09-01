using System;
using Palladio.Simulation.Model;
using Palladio.ComponentModel;

namespace Palladio.Simulation.Simulation
{
	/// <summary>
	/// This interface declares implementing classes as observers for simulationthreads. Each created thread can only be observed 
	/// by one of these observers.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/07/22 20:28:18  joemal
	/// - changed some comments
	///
	/// Revision 1.1  2004/07/20 11:46:42  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IThreadObserver
	{
		/// <summary>
		/// called, when the thread reaches the end of its controlflow.
		/// </summary>
		/// <param name="sender">the thread</param>
		void NotifyThreadReachedEnd(ISimulationThread sender);

		/// <summary>
		/// called, when the thread has entered its first timeconsumer
		/// </summary>
		/// <param name="sender">the thread</param>
		void NotifyThreadEnteredFirstTimeConsumer(ISimulationThread sender);

		/// <summary>
		/// called, when the current TimeConsumer of the thread has changed. This method is not called, when the thread
		/// has entered its first TimeConsumer.
		/// </summary>
		/// <param name="sender">the thread</param>
		/// <param name="previous">the previous TimeConsumer</param>
		void NotifyThreadChangedTimeConsumer(ISimulationThread sender, ITimeConsumer previous);

		/// <summary>
		/// called, when the timeline is increased
		/// </summary>
		/// <param name="sender">the thread</param>
		/// <param name="timeStep">the timestep, the timeline has been increased</param>
		void NotifyTimeStep(ISimulationThread sender, long timeStep);

		/// <summary>
		/// called, if the componentarchitecture contains unknown elements. The controlflow of this thread is stopped.
		/// And the thread is removed from the scheduler.
		/// </summary>
 		/// <param name="sender">the thread</param>
		void NotifyUnknownElementFound(ISimulationThread sender);

		/// <summary>
		/// called, when a signature of the requiresinterface of a component is called by the thread but not bound 
		/// with any providesinterface of another component. The thread follows the way through its controlflow 
		/// without invoking this call.
		/// </summary>
		/// <param name="callingComponent">the calling component</param>
		/// <param name="externalSignature">the signature of the call</param>
		/// <param name="sender">the thread</param>
		void NotifyUnboundExternalCall(ISimulationThread sender,IComponent callingComponent, 
			IExternalSignature externalSignature);
	}
}
//EOF