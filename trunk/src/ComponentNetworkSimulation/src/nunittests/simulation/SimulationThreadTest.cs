using System;
using NUnit.Framework;
using ComponentNetworkSimulation.Simulation;

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
			ISimulationThread testThread =new DefaultSimulationThread(0,Component.createPath1(),
				SimulationThreadType.TYPE_LOG_ON_LPS,this);

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
			ISimulationThread testThread =new DefaultSimulationThread(0,Component.createPath_with_Zero_TC(),
				SimulationThreadType.TYPE_LOG_ON_LPS,this);

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
			DefaultPeriodicSimulationThread testThread = new DefaultPeriodicSimulationThread(3,0,0,Component.createPath1(),
				SimulationThreadType.TYPE_LOG_ON_LPS,this);
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
			DefaultPeriodicSimulationThread testThread = new DefaultPeriodicSimulationThread(20,0,0,Component.createPath1(),
				SimulationThreadType.TYPE_LOG_ON_LPS,this);
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
			DefaultPeriodicSimulationThread testThread = new DefaultPeriodicSimulationThread(20,0,0,Component.createPath_with_Zero_TC(),
				SimulationThreadType.TYPE_LOG_ON_LPS,this);
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

		public void NotifyThreadChangedTimeConsumer(ISimulationThread sender, ComponentNetworkSimulation.structure.ITimeConsumer previous)
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
