using System;

using ComponentNetworkSimulation.Simulation;
using ComponentNetworkSimulation.Structure;
using ComponentNetworkSimulation.Analysis;

namespace ComponentNetworkSimulation
{
	/// <summary>
	/// Zusammenfassung für SimpleTestSimulationEnvironment.
	/// </summary>
	public class SimpleTestSimulationEnvironment : AbstractSimulationEnvironment 
	{
		public SimpleTestSimulationEnvironment()
		{
		}

		protected override ComponentNetworkSimulation.Simulation.IClock CreateClock()
		{
			return new DefaultClock(this);
		}

		protected override ComponentNetworkSimulation.Structure.AbstractComponentNetwork CreateComponentNetwork()
		{
			return new SimpleTestComponentNetwork();
		}

		protected override IDataPool CreateDataPool()
		{
			return DataPoolFactory.CreateConsoleWriterDataPool(this);
		}

		protected override void CreateSystemSimulationThreads()
		{
			foreach(ITimeConsumer tc in this.TheComponentNetwork.getSystemServices())
				this.Clock.ThreadScheduler.CreateSimulationThread(tc,SimulationThreadType.TYPE_LOG_ALL);
		}
	}
}
