using System;
using ComponentNetworkSimulation.structure;

namespace nunittests.simulation
{
	public class Component :ITimeConsumer
	{
		public static ITimeConsumer createPath1()
		{
			return new Component(new Component(new Component(10),3),2);
		}

		public static ITimeConsumer createPath2()
		{
			return new Component(new Component(5),10);
		}

		public static ITimeConsumer createPath_with_Zero_TC()
		{
			return new Component(new Component(new Component(4),0),6);
		}

		public Component(ITimeConsumer nextTimeConsumer, int timeToWait)
		{
			this.tc = nextTimeConsumer;
			this.tw = timeToWait;
		}

		public Component(int timeToWait)
		{
			this.tw = timeToWait;
		}

		protected ITimeConsumer tc = null;

		protected int tw = 0;

		#region ITimeConsumer Member

		public ComponentNetworkSimulation.structure.ITimeConsumer getNextTimeConsumer()
		{
			return tc;
		}

		public bool hasNextTimeConsumer()
		{
			return tc != null;
		}


		public ComponentNetworkSimulation.structure.LoggingType getLoggingType()
		{
			return LoggingType.NO_LOG;
		}

		public long ThreadEntered()
		{
			return tw;
		}

		public void ThreadExited()
		{
		}

		#endregion
	}
}
