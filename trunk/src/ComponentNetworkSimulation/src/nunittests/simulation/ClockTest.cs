using System;
using ComponentNetworkSimulation.Simulation;
using ComponentNetworkSimulation.structure;

namespace nunittests.simulation
{
	using NUnit.Framework;

	/// <summary>
	/// Zusammenfassung für ClockTest.
	/// </summary>
	[TestFixture]
	public class ClockTest
	{
		protected IClock clock = null;

		public ClockTest()
		{
		}

		[SetUp]
		public void doInit()
		{
			clock = new DefaultClock(null);
			clock.ClockResetEvent += new EventHandler(OnReset);
			clock.MaxTimeReachedEvent += new EventHandler(OnMaxSimulationTime);
			clock.TimeStepEvent += new TimeStepEventHandler(OnSimulationStep);
			clock.ThreadScheduler.NoMoreThreadsAliveEvent += new EventHandler(OnNoThreadAlive);
		}
		
		[Test]
		public void validateEmptyClock()
		{
			clock.Reset();
			Assert.IsFalse(clock.ThreadScheduler.IsAnyThreadAlive);
		}

		[Test]
		public void validateSimulationWithOneThread()
		{
			clock.Reset();
			clock.ThreadScheduler.CreateSimulationThread(Component.createPath1(),SimulationThreadType.TYPE_LOG_ON_LPS);
			int steps = 1;
			while(clock.SimulationStep()) 
			{
				steps++;
				if (steps > 10) 
					throw(new Exception("Clock works to long: "+steps));
			}
			Assert.AreEqual(clock.CurrentTime,15);
			Assert.AreEqual(steps,3);
		}
		
		[Test]
		public void validateSimulationWithTwoThread()
		{
			clock.Reset();
			clock.ThreadScheduler.CreateSimulationThread(Component.createPath1(),SimulationThreadType.TYPE_LOG_ON_LPS);
			clock.ThreadScheduler.CreateSimulationThread(Component.createPath2(),SimulationThreadType.TYPE_LOG_ON_LPS);
			int steps = 1;
			while(clock.SimulationStep()) 
			{
				steps++;
				if (steps > 10) 
					throw(new Exception("Clock works to long: "+steps));
			}
			Assert.AreEqual(clock.CurrentTime,15);
			Assert.AreEqual(steps,4);
		}

		[Test]
		public void validateSimulationMaxTime()
		{
			clock.MaximumSimulationTime = 8;
			clock.Reset();
			clock.ThreadScheduler.CreateSimulationThread(Component.createPath1(),SimulationThreadType.TYPE_LOG_ON_LPS);
			clock.ThreadScheduler.CreateSimulationThread(Component.createPath2(),SimulationThreadType.TYPE_LOG_ON_LPS);
			int steps = 1;
			while(clock.SimulationStep()) 
			{
				steps++;
				if (steps > 10) 
					throw(new Exception("Clock works to long: "+steps));
			}
			Assert.AreEqual(clock.CurrentTime,8);
			Assert.AreEqual(steps,3);
		}

		private void OnReset(object sender, EventArgs args)
		{
			Console.WriteLine("Clock reseted");
		}
		
		private void OnSimulationStep(object sender, TimeStepEventArgs args)
		{
			Console.WriteLine("SimulationStep: "+args.TimeStep+", Time: "+args.CurrentSimulationTime);
		}

		private void OnMaxSimulationTime(object sender, EventArgs args)
		{
			Console.WriteLine("Max time reached");
		}

		private void OnNoThreadAlive(object sender, EventArgs args)
		{
			Console.WriteLine("No more Thread alive");
		}
	}
}
