using System;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.simulation
{
	public enum SimuationThreadType {TYPE_LOG_ALL,TYPE_LOG_ON_LPS,TYPE_LOG_NOTHING};

	public class SimulationThread
	{

		public SimulationThread(String name, TimeUser firstTimeUser) : this (name, firstTimeUser,
			SimuationThreadType.TYPE_LOG_ON_LPS)
		{
		}

		public SimulationThread(String name, TimeUser firstTimeUser, SimuationThreadType type)
		{
			this.name = name;
			this.currentTimeUser = firstTimeUser;
			this.timeInFuture = currentTimeUser.getUsedTime();
			this.type = type;
		}

		public TimeUser getTimeUser() 
		{
			return currentTimeUser;
		}

		public long getTimeInFuture() 
		{
			return timeInFuture;
		}
		
		public void timeMoved(long time) 
		{
			timeInFuture -= time;
			if (timeInFuture <= 0) nextTimeUser();
		}

		public bool isAlive() 
		{
			return currentTimeUser != null;
		}

		protected void nextTimeUser()
		{
			if (!isAlive()) return;

			if (!currentTimeUser.hasNextTimeUser()) 
			{
				currentTimeUser = null;
				return;
			}

			currentTimeUser = currentTimeUser.getNextTimeUser();
			timeInFuture = currentTimeUser.getUsedTime();
		}

		protected String name = "";
		protected long timeInFuture=0;
		protected TimeUser currentTimeUser=null;
		protected SimuationThreadType type = SimuationThreadType.TYPE_LOG_ON_LPS;
	}
}
