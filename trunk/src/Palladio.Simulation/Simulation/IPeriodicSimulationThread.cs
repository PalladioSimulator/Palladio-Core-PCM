using System;
using Palladio.Simulation.Model;

namespace Palladio.Simulation.Simulation
{
	/// <summary>
	/// This interface extends a SimulationThread to provide some additional methods, events and properties, used for
	/// periodic threads.
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
		/// return the length of the periodlength of this thread
		/// </summary>
		long PeriodLength 
		{
			get;
		}

		/// <summary>
		/// return the periodID of this thread.
		/// </summary>
		int PeriodID 
		{
			get;
		}

		/// <summary>
		/// return the startingpoint of this thread in order to create new one from the same one.
		/// </summary>
		IThreadStartingPoint StartingPoint
		{
			get;
		}

		/// <summary>
		/// return the observer of this thread.
		/// </summary>
		IThreadObserver Observer
		{
			get;
		}

		#endregion
	}
}
//EOF
