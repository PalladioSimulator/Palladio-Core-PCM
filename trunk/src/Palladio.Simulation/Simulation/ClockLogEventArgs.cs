using System;
using Palladio.Simulation.Analysis;

namespace Palladio.Simulation.Simulation
{
	/// <summary>
	/// This class extends BasicLogEventArgs in order to add some parameters belonging to a log from the clock.
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
	public class ClockLogEventArgs : BasicLogEventArgs
	{
		#region declaration
		
		/// <summary>
		/// declaration of the type of the clock log event
		/// </summary>
		public enum EventType 
		{
			/// <summary>
			/// the clock was reseted
			/// </summary>
			CLOCK_RESET, 

			/// <summary>
			/// the clock has done a timestep
			/// </summary>
			CLOCK_STEP, 

			/// <summary>
			/// the clock has reached the maximum simulationtime
			/// </summary>
			CLOCK_REACHED_MAXTIME, 

			/// <summary>
			/// no more threads are alive
			/// </summary>
			CLOCK_NO_MORE_THREADS
		};

		#endregion

		#region data		
		
		/// <summary>
		/// the length of the timestep. 
		/// </summary>
		protected long timeStep;

		/// <summary>
		/// the type of clock log event
		/// </summary>
		protected ClockLogEventArgs.EventType type;

		/// <summary>
		/// the clock, that fired this event
		/// </summary>
		protected IClock clock;

		#endregion

		#region constructor

		/// <summary>
		/// constructs a new ClockLogEvent
		/// </summary>
		/// <param name="message">the message of this log</param>
		/// <param name="clock">the clock </param>
		/// <param name="type">the type of the event</param>
		/// <param name="timeStep">the length of the timestep</param>
		public ClockLogEventArgs(String message, IClock clock, ClockLogEventArgs.EventType type, long timeStep) :
			base(message)
		{
			this.clock = clock;
			this.type = type;
			this.timeStep = timeStep;
		}

		#endregion

		#region properties
		
		/// <summary>
		/// returns the reference to the clock, that fired this event
		/// </summary>
		public IClock Clock
		{
			get {return this.clock;}
		}

		/// <summary>
		/// returns the type of the event
		/// </summary>
		public ClockLogEventArgs.EventType TheType
		{
			get {return this.type;}
		}

		/// <summary>
		/// returns the timestep
		/// </summary>
		public long TimeStep 
		{
			get {return this.timeStep;}
		}

		#endregion
	}
}
//EOF