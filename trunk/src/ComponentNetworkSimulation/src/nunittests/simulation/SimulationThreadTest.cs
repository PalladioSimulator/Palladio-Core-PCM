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
		protected SimulationThread testThread;
		
		public SimulationThreadTest()
		{
		}

		[SetUp]
		public void doInit()
		{
			testThread = new SimulationThread(0,Component.createPath1(),SimulationThread.SimuationThreadType.TYPE_LOG_ON_LPS,this);
		}

		[Test]
		public void test_1()
		{
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

		#region IThreadObserver Member

		public void NotifyThreadReachedEnd(SimulationThread sender)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") reached end...");
		}

		public void NotifyThreadChangedTimeConsumer(SimulationThread sender, ComponentNetworkSimulation.structure.TimeConsumer previous)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") changed timeconsumer.");
		}

		public void NotifyTimeStep(SimulationThread sender, long timeStep)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") step: "+timeStep);
		}

		#endregion
	}
}
