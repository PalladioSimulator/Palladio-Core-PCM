using System;
using NUnit.Framework;
using ComponentNetworkSimulation.Simulation;
using ComponentNetworkSimulation.Structure;
using nunittests.structure;

namespace nunittests.simulation
{
	/// <summary>
	/// Zusammenfassung für ThreadScheduler.
	/// </summary>
/*	[TestFixture]
	public class ThreadSchedulerTest
	{
		IThreadScheduler scheduler = new DefaultThreadScheduler(null);
		IThreadStartingPoint start1 = new DefaultThreadStartingPoint(TestArchitectures.createFSM());
		IThreadStartingPoint start2 = new DefaultThreadStartingPoint(TestArchitectures.createFSM2());

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
			scheduler.CreateSimulationThread(start1,SimulationThreadType.TYPE_LOG_ON_LPS);
			while (scheduler.IsAnyThreadAlive) 
			{
				scheduler.SimulationStep(long.MaxValue);
			}
		}

		[Test]
		public void TestTwoThreadsSameTime()
		{
			scheduler.Reset();
			scheduler.CreateSimulationThread(start1,SimulationThreadType.TYPE_LOG_ON_LPS);
			scheduler.CreateSimulationThread(start2,SimulationThreadType.TYPE_LOG_ON_LPS);

			while (scheduler.IsAnyThreadAlive) 
			{
				scheduler.SimulationStep(long.MaxValue);
			}
		}

		[Test]
		public void TestTwoThreadsDiffStartTime()
		{
			scheduler.Reset();
			scheduler.CreateSimulationThread(start1,SimulationThreadType.TYPE_LOG_ON_LPS);

			bool flag = false;

			while (scheduler.IsAnyThreadAlive) 
			{
				scheduler.SimulationStep(long.MaxValue);
				if (!flag)
				{
					scheduler.CreateSimulationThread(start2,SimulationThreadType.TYPE_LOG_ON_LPS);
					flag = true;
				}
			}
		}

		[Test]
		public void TestPeriodicThread()
		{
			scheduler.Reset();
			scheduler.CreateSimulationThread(start1,SimulationThreadType.TYPE_LOG_ON_LPS,3);
			long simTime = 0;

			while (scheduler.IsAnyThreadAlive && simTime < 40) 
			{
				long step = scheduler.CalculateNextTimeStep();
				simTime += step;
				scheduler.SimulationStep(step);
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
	}*/
}
