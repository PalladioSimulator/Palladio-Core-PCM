using ComponentNetworkSimulation.structure;
using ComponentNetworkSimulation.simulation;
using ComponentNetworkSimulation.analysis;

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
			this.clock.simulate();
		}

		public bool simulationStep()
		{
			return this.clock.simulationStep();
		}

		public void resetSimulation()
		{
			this.clock.reset();
			this.componentNetwork.reset();
			this.dataPool.reset();
			this.createSystemSimulationThreads();
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

		protected abstract void createSystemSimulationThreads();
		
		protected abstract Clock createClock();

		protected abstract AbstractComponentNetwork createComponentNetwork();

		protected abstract AbstractDataPool createDataPool();

		protected Clock clock = null;
		protected AbstractComponentNetwork componentNetwork = null;
		protected AbstractDataPool dataPool = null;
	}	
}
