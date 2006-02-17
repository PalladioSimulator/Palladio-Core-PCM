using System;

namespace Palladio.Simulation.Analysis
{
	/// <summary>
	/// the eventhandler for all logs
	/// </summary>
	public delegate void LogEventHandler(object sender, BasicLogEventArgs eventArgs);	

	/// <summary>
	/// The interface defines a DataPool. 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IDataPool
	{
		/// <summary>
		/// called by the simualtionenvironment, when the simulation was reseted
		/// </summary>
		void Reset();

		/// <summary>
		/// called to send a log to the datapool
		/// </summary>
		/// <param name="sender">the sender of the log</param>
		/// <param name="eventArgs">the event arguments</param>
		void OnLogEvent(object sender, BasicLogEventArgs eventArgs);
	}
}
//EOF
