using System;
using ComponentNetworkSimulation.Structure;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This interface extends a SimulationThread to provide some additional methods, events and properties, used for
	/// periodic threads.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.3  2004/06/19 16:00:23  joemal
	/// - now this interface extends ISimulationThread
	///
	/// Revision 1.2  2004/05/26 16:29:54  joemal
	/// add cvs log tag
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
		#endregion
	}
}
//EOF
