namespace Palladio.Simulation.Model
{
	#region declarations

	/// <summary>
	/// this type defines the logging behavior of all timeconsumer in the framework
	/// </summary>
	public enum LoggingType_t 
	{
	
		//bitvektoren einbauen (nachgucken ob noch woanders nötig) ...
		/// <summary>
		/// the timeconsumer is not a logging point
		/// </summary>
		NO_LOG,

		/// <summary>
		/// the timeconsumer should be logged, when a thread entered
		/// </summary>
		LOG_ON_ENTER,

		/// <summary>
		/// the timeconsumer should be logged, when a thread exited
		/// </summary>
		LOG_ON_EXIT,

		/// <summary>
		/// the timeconsumer should be logged, when a thread entered and exited
		/// </summary>
		LOG_BOTH
	};	

	#endregion

	/// <summary>
	/// this interface marks an implementing class as timeconsumer. A timeconsumer in the componentarchitecture is an element,
	/// that consumes time in relality. It supports a property that returns the loggingtype of the timeconsumer. Two methods, 
	/// <code>ThreadEntered()</code> and <code>ThreadExited()</code> are called by simulationthreads. The method 
	/// <code>ThreadEntered()</code> returns the time, the entered thread has to stay in this timeconsumer.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/07/28 15:34:46  sbecker
	/// Review comments added
	///
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface ITimeConsumer
	{

		/// <summary>
		/// returns the Logging Type of the timeconsumer.
		/// </summary>
		LoggingType_t LoggingType
		{
			get;
		}

		/// <summary>
		/// called by a simulationthread, when it entered this timeconsumer in the architecture. The consumer has to return 
		/// the time, the simulationthread has to stay, until the next timeconsumer is entered. 
		/// </summary>
		/// <returns>the time, the thread has to wait</returns>
		long ThreadEntered();

		/// <summary>
		/// called by a simulationthread, when it left this timeconsumer
		/// </summary>
		void ThreadExited();

		/// <summary>
		/// this method is called, when the simulation wants to reset the architecture. Dynamic timeconsumer should
		/// implement this method to reset its state.
		/// </summary>
		void Reset();
	}
}
//EOF