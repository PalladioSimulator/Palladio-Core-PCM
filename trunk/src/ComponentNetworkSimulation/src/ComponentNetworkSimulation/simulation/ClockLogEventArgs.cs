using System;
using ComponentNetworkSimulation.Analysis;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// Zusammenfassung für ClockLogEventArgs.
	/// </summary>
	public class ClockLogEventArgs : BasicLogEventArgs
	{
		public enum EventType {CLOCK_RESET, CLOCK_STEP, CLOCK_REACHED_MAXTIME, CLOCK_NO_MORE_THREADS};

		
		protected long timeStep;
		protected ClockLogEventArgs.EventType type;
		protected IClock theClock;

		public ClockLogEventArgs(String message, IClock theClock, ClockLogEventArgs.EventType type, long timeStep) :
			base(message)
		{
			this.theClock = theClock;
			this.type = type;
			this.timeStep = timeStep;
		}

		public IClock TheClock
		{
			get {return this.theClock;}
		}

		public ClockLogEventArgs.EventType TheType
		{
			get {return this.type;}
		}

		public long TimeStep 
		{
			get {return this.timeStep;}
		}

	}
}
