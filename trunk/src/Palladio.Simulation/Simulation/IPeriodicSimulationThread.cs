using System;
using Palladio.Simulation.Model;

namespace Palladio.Simulation.Simulation
{
	/// <summary>
	/// This interface extends <code>ISimulationThread</code> to provide some additional methods, events and properties, used for
	/// periodic threads.
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
	public interface IPeriodicSimulationThread : ISimulationThread
	{
		#region events
		
		/// <summary>
		/// this event is fired, when the timeline of the thread reached the periodlength.
		/// </summary>
		event EventHandler NewPeriodicThreadEvent;

		#endregion

		#region properties

		/// <summary>
		/// returns the periodlength of this thread
		/// </summary>
		long PeriodLength 
		{
			get;
		}

		/// <summary>
		/// returns the periodID of this thread.
		/// </summary>
		int PeriodID 
		{
			get;
		}

		/// <summary>
		/// returns the startingpoint of this thread.
		/// </summary>
		IThreadStartingPoint StartingPoint
		{
			get;
		}

		/// <summary>
		/// returns the observer of this thread.
		/// </summary>
		IThreadObserver Observer
		{
			get;
		}

		#endregion
	}
}
//EOF
