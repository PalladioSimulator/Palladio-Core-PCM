using System;
using ComponentNetworkSimulation.simulation;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.analysis
{
	public delegate void LogEventHandler(object sender, BasicLogEventArgs eventArgs);

	public abstract class AbstractDataPool
	{
		#region data
		
		private AbstractSimulationEnvironment simulationEnvironment;
		
		#endregion

		#region constructors

		public AbstractDataPool(AbstractSimulationEnvironment simulationEnvironment)
		{
			if (simulationEnvironment == null) 
				throw(new NullReferenceException("Parameter simulationEnvironment must not be null."));

			this.simulationEnvironment = simulationEnvironment;
		}

		#endregion

		#region properties

		protected long SimulationTime
		{
			get{return this.SimulationEnvironment.TheCLock.CurrentTime;}
		}

		protected AbstractSimulationEnvironment SimulationEnvironment
		{
			get {return this.simulationEnvironment;}
		}

		#endregion

		#region methods

		protected virtual void OnLogEvent(object sender, BasicLogEventArgs eventArgs)
		{
			if (eventArgs is ClockLogEventArgs)
				OnClockEvent(sender,(ClockLogEventArgs)eventArgs);
			else if (eventArgs is ThreadLogEventArgs)
				OnThreadEvent(sender,(ThreadLogEventArgs)eventArgs);
			else OnUnknownEvent(sender,eventArgs);
		}

		#endregion		

		#region abstract methods

		public abstract void Reset();

		protected abstract void OnClockEvent(object sender, ClockLogEventArgs eventArgs);

		protected abstract void OnThreadEvent(object sender, ThreadLogEventArgs eventArgs);

		protected abstract void OnUnknownEvent(object sender, BasicLogEventArgs eventArgs);

		#endregion
	}
}
