using System;
using Palladio.FiniteStateMachines;

namespace ComponentNetworkSimulation.Structure.Components
{
	/// <summary>
	/// Zusammenfassung für StaticTimeStateParams.
	/// </summary>
	public class BasicTimeStateParams
	{
		protected LoggingType_t loggingType;
		protected long staticTime;

		protected IFiniteStateMachine fsm;

		public BasicTimeStateParams(IFiniteStateMachine fsm, long staticTime, LoggingType_t loggingType)
		{
			this.fsm = fsm;
			this.staticTime = staticTime;
			this.loggingType = loggingType;
		}

		public long StaticTime
		{
			get	{return this.staticTime;}
		}

		public IFiniteStateMachine FiniteStateMachine
		{
			get {return this.fsm;}
		}

		public LoggingType_t LoggingType
		{
			get {return this.loggingType;}
		}
	}
}
//EOF