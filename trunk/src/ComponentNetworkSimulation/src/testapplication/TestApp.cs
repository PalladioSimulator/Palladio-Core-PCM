using System;
using ComponentNetworkSimulation.structure;
using ComponentNetworkSimulation.structure.componentnetwork;
using ComponentNetworkSimulation.structure.connectors;

namespace testapplication
{
	public class TestApp
	{
		public static void Main()
		{
			new Simulator().simulate();
			System.Console.In.ReadLine();
		}
	}

	public class Simulator
	{
		Network network = new Network();
		Message[] messages = new Message[2];

		private void builUp()
		{
			network.buildUp();
			Clock.getInstance().createMessage(network.getSystemService(0),"Message of path 1");
			Clock.getInstance().createMessage(network.getSystemService(1),"Message of path 2");
		}

		public void simulate() 
		{
			builUp();
			Clock.getInstance().simulate();
		}				

		public static void logMessage(String message) 
		{
			System.Console.Out.WriteLine(message+" Time: "+Clock.getInstance().getCurTime());
		}
	}

	public class Network : ComponentNetworkSimulation.structure.AbstractComponentNetwork
	{
		public void buildUp()
		{
			this.SystemServices.Add(createFirstPath());
			this.SystemServices.Add(createSecondPath());
		}

		private Component createFirstPath() 
		{
			Component comp = new Component(10,"FirstPath Comp 2");
			comp = new Component(5,"FirstPath Comp 1",comp);
			return new Component(3,"FirstPath Comp 0",comp);			
		}

		private Component createSecondPath() 
		{
			AbstractConnector aConnector = ConnectorFactory.createConstantTimeConnector(0,3);
			Component comp = new Component(5,"SecondPath Comp 1");
			TimeUser tmUser = new ConnectorPath(aConnector,comp);
			return new Component(10,"SecondPath Comp 0",tmUser);			
		}

		public override System.String getName()
		{
			return "TestNetwork";
		}
	}

	public class Message 
	{
		TimeUser curTimeUser = null;
		long timeInFuture = 0;
		String name = "";

		public Message(TimeUser firstTimeUser, String name) 
		{
			this.curTimeUser = firstTimeUser;
			this.timeInFuture = curTimeUser.getUsedTime();
			this.name = name;
		}

		public TimeUser getTimeUser() 
		{
			return curTimeUser;
		}

		protected void nextTimeUser()
		{
			if (!isAlive()) return;

			if (!curTimeUser.hasNextTimeUser()) {
				Simulator.logMessage("Message "+name+" ended.");
				curTimeUser = null;
				return;
			}

			curTimeUser = curTimeUser.getNextTimeUser();
			timeInFuture = curTimeUser.getUsedTime();
			Simulator.logMessage("Entered Component "+curTimeUser+".");
		}

		public bool isAlive() 
		{
			return curTimeUser != null;
		}

		public void timeMoved(long time) 
		{
			timeInFuture -= time;
			if (timeInFuture <= 0) nextTimeUser();
		}

		public long getTimeInFuture() 
		{
			return timeInFuture;
		}
	}

	public class Clock
	{
		private System.Collections.ArrayList messages = new System.Collections.ArrayList();

		public static long MAX_SIMULTIME = 30;

		private static Clock instance = null;

		private long curTime = 0;

		private Clock() 
		{
		}

		public static Clock getInstance() 
		{
			if (instance == null) instance = new Clock();
            return instance;
		}

		public void createMessage(TimeUser firstTimeUser, String name)
		{
			Simulator.logMessage("Create message "+name+".");
			messages.Add(new Message(firstTimeUser,name));
		}

		public long getCurTime()
		{
			return this.curTime;
		}

		public bool isMaxTimeReached() 
		{
			return curTime >= MAX_SIMULTIME;
		}

		public void simulate() 
		{
			while(simulationStep() && !isMaxTimeReached());
		}

		public bool simulationStep() 
		{
			long shortestFutureTime = findShortestFutureTime();
			if (shortestFutureTime == -1) 
			{
				Simulator.logMessage("No more work.");
				return false;
			}

			moveTimeLine(shortestFutureTime);
			Simulator.logMessage("Simulation Step: "+shortestFutureTime+" time units.");

			return true;
		}

		private long findShortestFutureTime() 
		{
			long minTime = -1;
			for (int a=0;a<this.messages.Count;a++) 
			{
				Message mes = (Message)messages[a];
				if ((mes.getTimeInFuture() < minTime || minTime == -1) &&
					mes.isAlive()) minTime = mes.getTimeInFuture();
			}
			return minTime;
		}

		private void moveTimeLine(long time) 
		{
			timeMoved(time);
			for (int a=0;a<messages.Count;a++) 
				((Message)messages[a]).timeMoved(time);				
		}


		private void timeMoved(long time) 
		{
			this.curTime += time;
			if (curTime >= MAX_SIMULTIME) 
				System.Console.Out.WriteLine("Simulation ended. Max time reached ...");
		}
	}

	public class Component : TimeUser
	{
		long waitingTime = 0;		
		String name = "";
		TimeUser nextTimeUser = null;

		public Component(long time, String name) : this(time,name,null) 
		{
		}

		public Component(long time, String name, TimeUser nextTimeUser) 
		{
			this.waitingTime = time;
			this.nextTimeUser = nextTimeUser;
			this.name = name;
		}
		
		public override string ToString()
		{
			return name;
		}

		#region TimeUser Member

		public TimeUser getNextTimeUser()
		{
			return nextTimeUser;
		}

		public bool hasNextTimeUser()
		{
			return nextTimeUser != null;
		}

		public long getUsedTime()
		{
			return this.waitingTime;
		}

		public LoggingType getLoggingType()
		{
			return LoggingType.NO_LOG;
		}

		#endregion
	}
}
