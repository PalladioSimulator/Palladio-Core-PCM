using System;
using NUnit.Framework;
using ComponentNetworkSimulation.simulation;

namespace nunittests.simulation
{
	/// <summary>
	/// Zusammenfassung für ThreadScheduler.
	/// </summary>
	[TestFixture]
	public class ThreadSchedulerTest
	{
		ThreadScheduler scheduler = new ThreadScheduler(null);

		public ThreadSchedulerTest()
		{
		}

		[SetUp]
		public void SetUp()
		{
			scheduler.NextTCEvent += new NextTCEventHandler(this.OnNextTCEvent);
			scheduler.ThreadCreatedEvent += new ThreadLifeCycleEventHandler(this.OnThreadCreatedEvent);
			scheduler.ThreadDestroyedEvent += new ThreadLifeCycleEventHandler(this.OnThreadDestroyedEvent);
		}

		[Test]
		public void TestOneThread()
		{
            scheduler.Reset();
			scheduler.CreateSimulationThread(Component.createPath1(),SimulationThread.SimuationThreadType.TYPE_LOG_ON_LPS);
			while (scheduler.IsAnyThreadAlive) 
			{
				long time = scheduler.GetShortestFutureTime();
				scheduler.MoveTime(time);
			}
		}

		[Test]
		public void TestTwoThreadsSameTime()
		{
			scheduler.Reset();
			scheduler.CreateSimulationThread(Component.createPath1(),SimulationThread.SimuationThreadType.TYPE_LOG_ON_LPS);
			scheduler.CreateSimulationThread(Component.createPath2(),SimulationThread.SimuationThreadType.TYPE_LOG_ON_LPS);

			while (scheduler.IsAnyThreadAlive) 
			{
				long time = scheduler.GetShortestFutureTime();
				scheduler.MoveTime(time);
			}
		}

		[Test]
		public void TestTwoThreadsDiffStartTime()
		{
			scheduler.Reset();
			scheduler.CreateSimulationThread(Component.createPath1(),SimulationThread.SimuationThreadType.TYPE_LOG_ON_LPS);

			bool flag = false;

			while (scheduler.IsAnyThreadAlive) 
			{
				long time = scheduler.GetShortestFutureTime();
				scheduler.MoveTime(time);
				if (!flag)
				{
					scheduler.CreateSimulationThread(Component.createPath2(),SimulationThread.SimuationThreadType.TYPE_LOG_ON_LPS);
					flag = true;
				}
			}
		}

		protected void OnNextTCEvent(object sender, NextTCEventArgs args) 
		{
			Console.WriteLine("Thread("+((SimulationThread)sender).ThreadID+") changed the timeconsumer ...");
		}
		
		protected void OnThreadCreatedEvent(object sender, ThreadLifeCycleEventArgs args) 
		{
			Console.WriteLine("Thread ("+args.TheThread.ThreadID+") created ...");
		}

		protected void OnThreadDestroyedEvent(object sender, ThreadLifeCycleEventArgs args) 
		{
			Console.WriteLine("Thread ("+args.TheThread.ThreadID+") destroyed ...");
		}
	}
}
