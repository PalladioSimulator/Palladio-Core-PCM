namespace ComponentNetworkSimulation.Structure
{
	#region declarations

	/// <summary>
	/// this type defines the logging behavior of all timeconsumer in the framework
	/// </summary>
	public enum LoggingType_t {NO_LOG,LOG_ON_ENTER,LOG_ON_EXIT,LOG_BOTH};	

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
	/// Revision 1.4  2004/05/26 16:34:59  joemal
	/// remove methods:
	/// - NextTimeConsumer
	/// - HasNextTimeConsumer
	/// Use visitor now
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
	}
}
//EOF