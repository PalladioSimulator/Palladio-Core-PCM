using System;
using ComponentNetworkSimulation.Structure;

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

		public Component(ITimeConsumer nextTimeConsumer, long timeToWait)
		{
			this.tc = nextTimeConsumer;
			this.tw = timeToWait;
		}

		public Component(long timeToWait)
		{
			this.tw = timeToWait;
		}

		protected ITimeConsumer tc = null;

		protected long tw = 0;

		#region ITimeConsumer Member

		public ComponentNetworkSimulation.Structure.ITimeConsumer NextTimeConsumer
		{
			get
			{
				return tc;
			}
		}

		public bool HasNextTimeConsumer
		{
			get
			{
				return tc != null;
			}
		}


		public ComponentNetworkSimulation.Structure.LoggingType_t LoggingType
		{
			get
			{
				return LoggingType_t.NO_LOG;
			}
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

	public class ExternalCall : Component, ISubCallingTimeConsumer
	{
		private ITimeConsumer tcAfterReturn;			

		public static ITimeConsumer CreatePathStartingWithTimeConsumer()
		{
			ExternalCall lastTree = new ExternalCall(3,Component.createPath2(),new Component(5));
			ExternalCall firstTree = new ExternalCall(1,Component.createPath1(),new Component(lastTree,2));
			
			return new Component(firstTree,6);			
		}

		public static ITimeConsumer CreatePathStartingWithSubCall()
		{
			ExternalCall lastTree = new ExternalCall(3,Component.createPath2(),new Component(5));
			ExternalCall firstTree = new ExternalCall(1,Component.createPath1(),new Component(lastTree,2));
			
			return firstTree;			
		}

		public ExternalCall(long time, ITimeConsumer nextTC, ITimeConsumer tcAfterReturn) : base(nextTC,time)
		{
			this.tcAfterReturn = tcAfterReturn;
		}

		#region ISubCallingTimeConsumer Member

		public ITimeConsumer NextTimeConsumerAfterReturn
		{
			get
			{
				return this.tcAfterReturn;
			}
		}

		#endregion
	}
}