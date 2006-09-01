using System;
using ComponentNetworkSimulation.Simulation;
using ComponentNetworkSimulation.Structure;

namespace ComponentNetworkSimulation.Analysis
{
	/// <summary>
	/// this class implements a default datapool. This datapool supportes seperating the incomming logs in
	/// three types, ClockLogs, ThreadLogs and Unknown logs by there parameterclasses. For each of these types, 
	/// a method virtual exits. This implementation also holds an instance of simualtionenvironment.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.3  2004/05/26 16:26:52  joemal
	/// add cvs log tag
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DefaultDataPool : IDataPool
	{
		#region data
		
		/// <summary>
		/// the instance of the simulation environment
		/// </summary>
		private ISimulationEnvironment simulationEnvironment;
		
		#endregion

		#region constructors

		/// <summary>
		/// constructs a new instance of DefaultDatapool
		/// </summary>
		/// <param name="simulationEnvironment">the instance of simulation environment, using this datapool.</param>
		public DefaultDataPool(ISimulationEnvironment simulationEnvironment)
		{
			if (simulationEnvironment == null) 
				throw(new NullReferenceException("Parameter simulationEnvironment must not be null."));

			this.simulationEnvironment = simulationEnvironment;
		}

		#endregion

		#region properties

		/// <summary>
		/// return the current simulationtime using the simulation clock of the environent
		/// </summary>
		protected long SimulationTime
		{
			get{return this.SimulationEnvironment.Clock.CurrentTime;}
		}

		/// <summary>
		/// return the simulation environment, using this datapool
		/// </summary>
		protected ISimulationEnvironment SimulationEnvironment
		{
			get {return this.simulationEnvironment;}
		}

		#endregion

		#region methods

		/// <summary>
		/// called on every incomming log. This methods seperates the log by there EventArgs in 
		/// ClockLog, ThreadLogs or Unknown Logs. The matching methods is called.
		/// </summary>
		/// <param name="sender">the sender of the log event</param>
		/// <param name="eventArgs">the event arguments</param>
		public virtual void OnLogEvent(object sender, BasicLogEventArgs eventArgs)
		{
			if (eventArgs is ClockLogEventArgs)
				OnClockEvent(sender,(ClockLogEventArgs)eventArgs);
			else if (eventArgs is ThreadLogEventArgs)
				OnThreadEvent(sender,(ThreadLogEventArgs)eventArgs);
			else OnUnknownEvent(sender,eventArgs);
		}

		/// <summary>
		/// called by the simulation environment, when the simulation was reseted.
		/// </summary>
		public virtual void Reset()
		{
		}

		/// <summary>
		/// called by OnLogEvent(...), if the incoming event is a Clocklog.
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="eventArgs">the arguments</param>
		protected virtual void OnClockEvent(object sender, ClockLogEventArgs eventArgs)
		{
		}

		/// <summary>
		/// called by OnLogEvent(...), if the incoming event is a Threadlog.
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="eventArgs">the arguments</param>
		protected virtual void OnThreadEvent(object sender, ThreadLogEventArgs eventArgs)
		{
		}

		/// <summary>
		/// called by OnLogEvent(...), if the incoming event is a unknown log.
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="eventArgs">the arguments</param>
		protected virtual void OnUnknownEvent(object sender, BasicLogEventArgs eventArgs)
		{
		}

		#endregion
	}
}
//EOF