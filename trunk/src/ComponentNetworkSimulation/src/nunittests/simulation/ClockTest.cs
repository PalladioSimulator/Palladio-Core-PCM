using System;
using ComponentNetworkSimulation.Simulation;
using ComponentNetworkSimulation.Structure;

using nunittests.structure;

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
		protected long nextClockStopTime;
		protected long lastTime;
		protected Random random = new Random();
		IThreadStartingPoint start1 = new DefaultThreadStartingPoint(TestArchitectures.createFSM());
		IThreadStartingPoint start2 = new DefaultThreadStartingPoint(TestArchitectures.createFSM2());


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
			clock.ThreadScheduler.CreateSimulationThread(start1,SimulationThreadType.TYPE_LOG_ON_LPS);
			int steps = 1;
			while(clock.SimulationStep()) 
			{
				steps++;
				if (steps > 10) 
					throw(new Exception("Clock works to long: "+steps));
			}
			Assert.IsTrue((clock.CurrentTime == 20 && steps == 3) || (clock.CurrentTime == 23 && steps == 4));
		}
		
		[Test]
		public void validateSimulationWithTwoThread()
		{
			clock.Reset();
			clock.ThreadScheduler.CreateSimulationThread(start1,SimulationThreadType.TYPE_LOG_ON_LPS);
			clock.ThreadScheduler.CreateSimulationThread(start2,SimulationThreadType.TYPE_LOG_ON_LPS);
			int steps = 1;
			while(clock.SimulationStep()) 
			{
				steps++;
				if (steps > 30) 
					throw(new Exception("Clock works to long: "+steps));
			}
			Assert.IsTrue(clock.CurrentTime>=20);
		}

		[Test]
		public void validateSimulationMaxTime()
		{
			clock.MaximumSimulationTime = 8;
			clock.Reset();
			clock.ThreadScheduler.CreateSimulationThread(start1,SimulationThreadType.TYPE_LOG_ON_LPS);
			clock.ThreadScheduler.CreateSimulationThread(start2,SimulationThreadType.TYPE_LOG_ON_LPS);
			int steps = 1;
			while(clock.SimulationStep()) 
			{
				steps++;
				if (steps > 10) 
					throw(new Exception("Clock works to long: "+steps));
			}
			Assert.AreEqual(clock.CurrentTime,8);
			Assert.IsTrue(steps==3 || steps == 4);
		}

		[Test]
		public void validateClockLockEvent()
		{
			clock.MaximumSimulationTime = 30;
			clock.Reset();
			clock.ThreadScheduler.CreateSimulationThread(start2,SimulationThreadType.TYPE_LOG_ON_LPS);
			SetNextClockStopTime();
			while(clock.SimulationStep());

		}

		private void OnReset(object sender, EventArgs args)
		{
			Console.WriteLine("Clock reseted");
		}
		
		private void OnSimulationStep(object sender, TimeStepEventArgs args)
		{
			Console.WriteLine("SimulationStep: "+args.TimeStep+", Time: "+args.CurrentSimulationTime+",Cause: "+args.Cause);
			if (args.IsClockStopEvent)
			{
				Assert.AreEqual(this.lastTime + this.nextClockStopTime, args.CurrentSimulationTime);
				SetNextClockStopTime();
			}
		}

		private void SetNextClockStopTime()
		{
			this.lastTime = clock.CurrentTime;
			this.nextClockStopTime = random.Next(6);
			clock.SetClockStopEventTime(this.nextClockStopTime);
			Console.WriteLine("Next clockstoptime: "+this.nextClockStopTime);
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
