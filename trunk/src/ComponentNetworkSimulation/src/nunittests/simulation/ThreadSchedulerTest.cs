using System;
using NUnit.Framework;
using ComponentNetworkSimulation.Simulation;

namespace nunittests.simulation
{
	/// <summary>
	/// Zusammenfassung für ThreadScheduler.
	/// </summary>
	[TestFixture]
	public class ThreadSchedulerTest
	{
		IThreadScheduler scheduler = new DefaultThreadScheduler(null);

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
			scheduler.CreateSimulationThread(Component.createPath1(),SimulationThreadType.TYPE_LOG_ON_LPS);
			while (scheduler.IsAnyThreadAlive) 
			{
				scheduler.SimulationStep(long.MaxValue);
			}
		}

		[Test]
		public void TestTwoThreadsSameTime()
		{
			scheduler.Reset();
			scheduler.CreateSimulationThread(Component.createPath1(),SimulationThreadType.TYPE_LOG_ON_LPS);
			scheduler.CreateSimulationThread(Component.createPath2(),SimulationThreadType.TYPE_LOG_ON_LPS);

			while (scheduler.IsAnyThreadAlive) 
			{
				scheduler.SimulationStep(long.MaxValue);
			}
		}

		[Test]
		public void TestTwoThreadsDiffStartTime()
		{
			scheduler.Reset();
			scheduler.CreateSimulationThread(Component.createPath1(),SimulationThreadType.TYPE_LOG_ON_LPS);

			bool flag = false;

			while (scheduler.IsAnyThreadAlive) 
			{
				scheduler.SimulationStep(long.MaxValue);
				if (!flag)
				{
					scheduler.CreateSimulationThread(Component.createPath2(),SimulationThreadType.TYPE_LOG_ON_LPS);
					flag = true;
				}
			}
		}

		[Test]
		public void TestPeriodicThread()
		{
			scheduler.Reset();
			scheduler.CreateSimulationThread(Component.createPath1(),SimulationThreadType.TYPE_LOG_ON_LPS,3);
			long simTime = 0;

			while (scheduler.IsAnyThreadAlive && simTime < 40) 
			{
				simTime += scheduler.SimulationStep(long.MaxValue);
			}
		}

		protected void OnNextTCEvent(object sender, NextTCEventArgs args) 
		{
			Console.WriteLine("Thread("+((ISimulationThread)sender).ThreadID+") changed the TimeConsumer ...");
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
