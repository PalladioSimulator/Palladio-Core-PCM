using System;
using NUnit.Framework;
using ComponentNetworkSimulation.simulation;

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
			SimulationThread testThread =new SimulationThread(0,Component.createPath1(),
				SimulationThread.SimuationThreadType.TYPE_LOG_ON_LPS,this);

			Assert.AreEqual(testThread.TimeInFuture,2);
			testThread.TimeMoved(1);
			Assert.IsTrue(testThread.IsAlive);

			Assert.AreEqual(testThread.TimeInFuture,1);
			testThread.TimeMoved(1);
			Assert.IsTrue(testThread.IsAlive);

			Assert.AreEqual(testThread.TimeInFuture,3);
			testThread.TimeMoved(3);
			Assert.IsTrue(testThread.IsAlive);

			Assert.AreEqual(testThread.TimeInFuture,10);
			testThread.TimeMoved(10);
			Assert.IsFalse(testThread.IsAlive);
		}

		[Test]
		public void test_single_thread_with_zero_tc()
		{
			SimulationThread testThread =new SimulationThread(0,Component.createPath_with_Zero_TC(),
				SimulationThread.SimuationThreadType.TYPE_LOG_ON_LPS,this);

			Assert.AreEqual(testThread.TimeInFuture,6);
			testThread.TimeMoved(6);
			Assert.IsTrue(testThread.IsAlive);

			Assert.AreEqual(testThread.TimeInFuture,0);
			testThread.TimeMoved(0);
			Assert.IsTrue(testThread.IsAlive);

			Assert.AreEqual(testThread.TimeInFuture,4);
			testThread.TimeMoved(4);
			Assert.IsFalse(testThread.IsAlive);
		}

		[Test]
		public void test_periodic_thread_short_period()
		{
			PeriodicSimulationThread testThread = new PeriodicSimulationThread(3,0,0,Component.createPath1(),
				SimulationThread.SimuationThreadType.TYPE_LOG_ON_LPS,this);
			testThread.NewPeriodicThreadEvent += new EventHandler(OnNewPeriodicThread);

			Assert.AreEqual(testThread.TimeInFuture,2);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsFalse(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,1);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsTrue(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,2);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsTrue(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,10);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsFalse(testThread.IsAlive);
			Assert.IsTrue(this.newThreadCreated);
		}

		[Test]
		public void test_periodic_thread_long_period()
		{
			PeriodicSimulationThread testThread = new PeriodicSimulationThread(20,0,0,Component.createPath1(),
				SimulationThread.SimuationThreadType.TYPE_LOG_ON_LPS,this);
			testThread.NewPeriodicThreadEvent += new EventHandler(OnNewPeriodicThread);

			Assert.AreEqual(testThread.TimeInFuture,2);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsFalse(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,3);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsFalse(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,10);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsFalse(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,5);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsFalse(testThread.IsAlive);
			Assert.IsTrue(this.newThreadCreated);
		}

		[Test]
		public void test_periodic_thread_long_period_zero_tc()
		{
			PeriodicSimulationThread testThread = new PeriodicSimulationThread(20,0,0,Component.createPath_with_Zero_TC(),
				SimulationThread.SimuationThreadType.TYPE_LOG_ON_LPS,this);
			testThread.NewPeriodicThreadEvent += new EventHandler(OnNewPeriodicThread);

			Assert.AreEqual(testThread.TimeInFuture,6);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsFalse(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,0);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsFalse(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,4);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsTrue(testThread.IsAlive);
			Assert.IsFalse(this.newThreadCreated);

			Assert.AreEqual(testThread.TimeInFuture,10);
			testThread.TimeMoved(testThread.TimeInFuture);
			Assert.IsFalse(testThread.IsAlive);
			Assert.IsTrue(this.newThreadCreated);
		}

		private void OnNewPeriodicThread(object sender, EventArgs args)
		{
			this.newThreadCreated = !this.newThreadCreated;
			Console.WriteLine("Notified to create a new Thread ...");
			
			PeriodicSimulationThread newThread = (PeriodicSimulationThread)((PeriodicSimulationThread)sender).
				CreateFollowingThread(1);
			Assert.AreEqual(newThread.PeriodID,0);
			Assert.AreEqual(newThread.ThreadID,1);
			Assert.IsTrue(newThread.IsAlive);
		}



		#region IThreadObserver Member

		public void NotifyThreadReachedEnd(SimulationThread sender)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") reached end...");
		}

		public void NotifyThreadChangedTimeConsumer(SimulationThread sender, ComponentNetworkSimulation.structure.ITimeConsumer previous)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") changed TimeConsumer.");
		}

		public void NotifyTimeStep(SimulationThread sender, long timeStep)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") step: "+timeStep);
		}

		#endregion
	}
}
