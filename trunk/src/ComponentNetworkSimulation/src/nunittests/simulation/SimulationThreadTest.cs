using System;
using NUnit.Framework;
using ComponentNetworkSimulation.Simulation;
using ComponentNetworkSimulation.Structure;

using nunittests.structure;

namespace nunittests.simulation
{
	/// <summary>
	/// Zusammenfassung für SimulationThreadTest.
	/// </summary>
	/// 
	[TestFixture]
	public class SimulationThreadTest : IThreadObserver
	{
		protected bool newThreadCreated;
		
		public SimulationThreadTest()
		{
		}

		[SetUp]
		public void doInit()
		{
			this.newThreadCreated = false;
		}

		[Test]
		public void test_single_thread()
		{
			IThreadStartingPoint start = new DefaultThreadStartingPoint(TestArchitectures.createFSM());
			ISimulationThread testThread =new DefaultSimulationThread(0,start,SimulationThreadType.TYPE_LOG_ON_LPS,this);

			Assert.AreEqual(testThread.TimeInFuture,5);
			testThread.TimeMoved(1);
			Assert.IsTrue(testThread.IsAlive);

			Assert.AreEqual(testThread.TimeInFuture,4);
			testThread.TimeMoved(4);
			Assert.IsTrue(testThread.IsAlive);

			Assert.AreEqual(testThread.TimeInFuture,7);
			testThread.TimeMoved(7);
			Assert.IsTrue(testThread.IsAlive);

			if (testThread.TimeInFuture == 3)
			{
				Console.WriteLine("long way");
				testThread.TimeMoved(3);
			}
			Assert.AreEqual(testThread.TimeInFuture,8);
			testThread.TimeMoved(8);
			Assert.IsFalse(testThread.IsAlive);
		}

		[Test]
		public void test_periodic_thread_short_period()
		{
			IThreadStartingPoint start = new DefaultThreadStartingPoint(TestArchitectures.createFSM());

			DefaultPeriodicSimulationThread testThread = new DefaultPeriodicSimulationThread(7,0,0,start,
				SimulationThreadType.TYPE_LOG_ON_LPS,this);
			testThread.NewPeriodicThreadEvent += new EventHandler(OnNewPeriodicThread);

			Assert.AreEqual(testThread.TimeInFuture,5);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsFalse(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,2);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsTrue(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,5);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsTrue(this.newThreadCreated);

			if (testThread.TimeInFuture == 3)
			{
				Console.WriteLine("long way");
				testThread.TimeMoved(3);
				Assert.IsTrue(this.newThreadCreated);
			}
			Assert.AreEqual(testThread.TimeInFuture,8);
			testThread.TimeMoved(8);
			Assert.IsFalse(testThread.IsAlive);
			Assert.IsTrue(this.newThreadCreated);
		}

		[Test]
		public void test_periodic_thread_long_period()
		{
			IThreadStartingPoint start = new DefaultThreadStartingPoint(TestArchitectures.createFSM());

			DefaultPeriodicSimulationThread testThread = new DefaultPeriodicSimulationThread(30,0,0,start,
				SimulationThreadType.TYPE_LOG_ON_LPS,this);
			testThread.NewPeriodicThreadEvent += new EventHandler(OnNewPeriodicThread);

			Assert.AreEqual(testThread.TimeInFuture,5);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsFalse(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,7);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsFalse(this.newThreadCreated);

			int time = 12;
			if (testThread.TimeInFuture == 3)
			{
				Console.WriteLine("long way");
				testThread.TimeMoved(3);
				Assert.IsFalse(this.newThreadCreated);
				time += 3;
			}

			time += 8;
			Assert.AreEqual(testThread.TimeInFuture,8);
			testThread.TimeMoved(8);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsFalse(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,30-time);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsFalse(testThread.IsAlive);
			Assert.IsTrue(this.newThreadCreated);
		}

		private void OnNewPeriodicThread(object sender, EventArgs args)
		{
			this.newThreadCreated = !this.newThreadCreated;
			Console.WriteLine("Notified to create a new Thread ...");
			
			ISimulationThread newThread = ((IPeriodicSimulationThread)sender).CreateFollowingThread(1);
			Assert.AreEqual(((IPeriodicSimulationThread)newThread).PeriodID,0);
			Assert.AreEqual(newThread.ThreadID,1);
			Assert.IsTrue(newThread.IsAlive);
		}

		#region IThreadObserver Member

		public void NotifyThreadReachedEnd(ISimulationThread sender)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") reached end...");
		}

		public void NotifyThreadChangedTimeConsumer(ISimulationThread sender, ComponentNetworkSimulation.Structure.ITimeConsumer previous)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") changed TimeConsumer.");
		}

		public void NotifyTimeStep(ISimulationThread sender, long timeStep)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") step: "+timeStep);
		}

		#endregion
	}
}
