using System;

namespace Palladio.Simulation.Model
{
	#region declarations

	/// <summary>
	/// this type defines the logging behavior of all timeconsumer in the framework
	/// </summary>
	[Flags]
	public enum LoggingType_t 
	{
		/// <summary>
		/// the timeconsumer should not be logged
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
	};	

	#endregion

	/// <summary>
	/// this interface marks an implementing class as timeconsumer. A timeconsumer in the componentarchitecture is an element,
	/// that consumes time in relality. It supports a property that returns the loggingtype of the timeconsumer. Two methods, 
	/// <c>ThreadEntered()</c> and <c>ThreadExited()</c> are called by simulationthreads. The method 
	/// <c>ThreadEntered()</c> returns the time, the entered thread has to stay in this timeconsumer.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.3  2004/07/29 15:13:47  joemal
	/// - changes from the review
	///
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