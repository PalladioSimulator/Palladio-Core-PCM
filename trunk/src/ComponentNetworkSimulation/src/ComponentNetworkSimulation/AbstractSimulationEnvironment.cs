using ComponentNetworkSimulation.structure;
using ComponentNetworkSimulation.simulation;
using ComponentNetworkSimulation.analysis;
using System.Collections;

namespace ComponentNetworkSimulation
{
	public abstract class AbstractSimulationEnvironment
	{
		public AbstractSimulationEnvironment()
		{
			this.clock = createClock();
			this.componentNetwork = createComponentNetwork();
		}

		public void simulate()
		{
			this.resetSimulation();
			this.prepairSimulation();
			this.doSimulate();
		}

		public bool simulationStep()
		{
			return this.clock.SimulationStep();
		}

		public void prepairSimulation()
		{
			this.createSystemSimulationThreads();
		}

		public void resetSimulation()
		{
			this.clock.Reset();
			this.componentNetwork.reset();
			this.dataPool.reset();
		}

		public Clock getClock()
		{
			return this.clock;
		}

		public AbstractComponentNetwork getComponentNetwork() 
		{
			return this.componentNetwork;
		}

		public AbstractDataPool getDataPool() 
		{
			return this.dataPool;
		}

		protected void doSimulate()
		{
			while(clock.SimulationStep() && !clock.IsMaxTimeReached);
		}

		protected abstract void createSystemSimulationThreads();
		
		protected abstract Clock createClock();

		protected abstract AbstractComponentNetwork createComponentNetwork();

		protected abstract AbstractDataPool createDataPool();

		protected Clock clock = null;
		protected AbstractComponentNetwork componentNetwork = null;
		protected AbstractDataPool dataPool = null;
	}	
}
