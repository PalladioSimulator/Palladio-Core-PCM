using System;
using ComponentNetworkSimulation.structure;

namespace nunittests.simulation
{
	public class Component : TimeConsumer
	{
		public static TimeConsumer createPath1()
		{
			return new Component(new Component(new Component(10),3),2);
		}

		public static TimeConsumer createPath2()
		{
			return new Component(new Component(5),10);
		}

		public static TimeConsumer createPath_with_Zero_TC()
		{
			return new Component(new Component(new Component(4),0),6);
		}

		public Component(TimeConsumer nextTimeConsumer, int timeToWait)
		{
			this.tc = nextTimeConsumer;
			this.tw = timeToWait;
		}

		public Component(int timeToWait)
		{
			this.tw = timeToWait;
		}

		protected TimeConsumer tc = null;

		protected int tw = 0;

		#region TimeConsumer Member

		public ComponentNetworkSimulation.structure.TimeConsumer getNextTimeConsumer()
		{
			return tc;
		}

		public bool hasNextTimeConsumer()
		{
			return tc != null;
		}

		public long getUsedTime()
		{
			return tw;
		}

		public ComponentNetworkSimulation.structure.LoggingType getLoggingType()
		{
			return LoggingType.NO_LOG;
		}

		#endregion
	}
}
