using ComponentNetworkSimulation.structure;
using ComponentNetworkSimulation.simulation;

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

		protected abstract void createSystemSimulationThreads();
		
		protected abstract Clock createClock();

		protected abstract AbstractComponentNetwork createComponentNetwork();

		protected Clock clock = null;
		protected AbstractComponentNetwork componentNetwork = null;
	}	
}
