using System;
using ComponentNetworkSimulation.structure;
namespace ComponentNetworkSimulation.simulation
{
	public class Clock
	{	
		public Clock(ComponentNetworkSimulation.AbstractSimulationEnvironment simulationEnvironment)
		{
			this.simulationEnvironment = simulationEnvironment;
		}

		public Clock(int maxSimulationTime) 
		{
			this.maxSimulationTime = maxSimulationTime;
		}

		public long getCurTime()
		{
			return this.currentTime;
		}

		public bool isMaxTimeReached() 
		{
			return currentTime >= maxSimulationTime;
		}

		public void simulate() 
		{
			while(simulationStep() && !isMaxTimeReached());
		}

		public bool simulationStep() 
		{
			long shortestFutureTime = findShortestFutureTime();
			moveTimeLine(shortestFutureTime);
			return true;
		}

		public void createSimulationThread(TimeUser firstTimeUser, String name)
		{
			simulationThreads.Add(new SimulationThread(name,firstTimeUser));
		}

		public void createSimulationThread(TimeUser firstTimeUser, String name, SimuationThreadType type)
		{
			simulationThreads.Add(new SimulationThread(name,firstTimeUser,type));
		}

		public void createPeriodicalSimulationThreads(TimeUser firstTimeUser, String name, long period)
		{
			throw (new Exception("To be Implemented"));
		}
		
		public void createPeriodicalSimulationThreads(TimeUser firstTimeUser, String name, long period,
			SimuationThreadType type)
		{
			throw (new Exception("To be Implemented"));
		}

		public void reset() 
		{
			simulationThreads.Clear();
		}

		
		protected void moveTimeLine(long time) 
		{
			currentTime += time;
			for (int a=0;a<simulationThreads.Count;a++) 
				((SimulationThread)simulationThreads[a]).timeMoved(time);				
		}

		protected long findShortestFutureTime() 
		{
			long minTime = -1;
			for (int a=0;a<this.simulationThreads.Count;a++) 
			{
				SimulationThread thread = (SimulationThread)simulationThreads[a];
				if ((thread.getTimeInFuture() < minTime || minTime == -1) &&
					thread.isAlive()) minTime = thread.getTimeInFuture();
			}
			return minTime;
		}

		protected long maxSimulationTime = long.MaxValue;
		protected ComponentNetworkSimulation.AbstractSimulationEnvironment simulationEnvironment = null;
		protected System.Collections.ArrayList simulationThreads = new System.Collections.ArrayList();
		private long currentTime = 0;
	}
}
