using System;
using NUnit.Framework;
using ComponentNetworkSimulation.Simulation;
using ComponentNetworkSimulation.Structure;
using ComponentNetworkSimulation;

using Palladio.Identifier;
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
		protected int pathIdentifier=0;
		
		public SimulationThreadTest()
		{
		}

		[SetUp]
		public void doInit()
		{
			this.pathIdentifier = 0;
		}

		[Test]
		public void test_single_thread()
		{
			IThreadStartingPoint sp = new DefaultThreadStartingPoint(ID("CC"),ID("P1"),ID("d1"));
			ISimulationEnvironment env = new DefaultSimulationEnvironment();

			TestArchitectures.FillCC(env.ComponentArchitecture.CreateCompositeRootComponent(ID("CC"),null));

			ISimulationThread testThread =new DefaultSimulationThread(0,env.ComponentArchitecture.CreateVisitor(sp),
				SimulationThreadType.TYPE_LOG_NOTHING,this);

			Assert.IsFalse(testThread.IsAlive);
			testThread.Start();
			Assert.IsTrue(testThread.IsAlive);
			Assert.AreEqual(this.pathIdentifier,5);

			testThread.TimeMoved(1);
			Assert.IsTrue(testThread.IsAlive);
			Assert.AreEqual(this.pathIdentifier,4);

			Assert.AreEqual(testThread.TimeInFuture,4);
			testThread.TimeMoved(4);
			Assert.IsTrue(testThread.IsAlive);
			Assert.AreEqual(this.pathIdentifier,3);

			Assert.AreEqual(testThread.TimeInFuture,3);
			testThread.TimeMoved(3);
			Assert.IsTrue(testThread.IsAlive);

			while(testThread.CurrentTimeConsumer.ToString().Equals("C2->e1->1"))
			{
				testThread.TimeMoved(10);
				Assert.IsTrue(testThread.IsAlive);

				Console.WriteLine("TC: "+testThread.CurrentTimeConsumer);
				Assert.AreEqual(testThread.TimeInFuture,3);
				testThread.TimeMoved(3);
				Assert.IsTrue(testThread.IsAlive);

				Console.WriteLine("TC: "+testThread.CurrentTimeConsumer);
				Assert.AreEqual(testThread.TimeInFuture,3);
				testThread.TimeMoved(3);
				Assert.IsTrue(testThread.IsAlive);

				Console.WriteLine("TC: "+testThread.CurrentTimeConsumer);
				Assert.AreEqual(testThread.TimeInFuture,10);
				testThread.TimeMoved(10);
				Assert.IsTrue(testThread.IsAlive);

				Console.WriteLine("TC: "+testThread.CurrentTimeConsumer);
				Assert.AreEqual(testThread.TimeInFuture,5);
				testThread.TimeMoved(5);
				Assert.IsTrue(testThread.IsAlive);

				Assert.AreEqual(testThread.TimeInFuture,3);
				testThread.TimeMoved(3);
				Assert.IsTrue(testThread.IsAlive);
			}
			
			Assert.AreEqual(testThread.CurrentTimeConsumer.ToString(),"C2->e4->1");
			Assert.AreEqual(testThread.TimeInFuture,10);
			testThread.TimeMoved(10);
			Assert.IsTrue(testThread.IsAlive);

			Assert.AreEqual(testThread.TimeInFuture,7);
			testThread.TimeMoved(7);
			Assert.IsFalse(testThread.IsAlive);
			Assert.AreEqual(this.pathIdentifier,2);
		}

		[Test]
		public void test_periodic_thread_short_period()
		{
			IThreadStartingPoint sp = new DefaultThreadStartingPoint(ID("CC"),ID("P1"),ID("d1"));
			ISimulationEnvironment env = new DefaultSimulationEnvironment();

			TestArchitectures.FillCC(env.ComponentArchitecture.CreateCompositeRootComponent(ID("CC"),null));

			IPeriodicSimulationThread testThread =new DefaultPeriodicSimulationThread(3,0,0,sp,
				env.ComponentArchitecture.CreateVisitor(sp),SimulationThreadType.TYPE_LOG_NOTHING,this);

			testThread.NewPeriodicThreadEvent += new EventHandler(this.OnNewPeriodicThread);

			Assert.IsFalse(testThread.IsAlive);
			testThread.Start();
			Assert.IsTrue(testThread.IsAlive);
			Assert.AreEqual(this.pathIdentifier,5);

			Assert.AreEqual(testThread.TimeInFuture,3);
			testThread.TimeMoved(3);
			Assert.IsTrue(testThread.IsAlive);
			Assert.AreEqual(this.pathIdentifier,104);

			Assert.AreEqual(testThread.TimeInFuture,2);
			testThread.TimeMoved(2);
			Assert.IsTrue(testThread.IsAlive);
			Assert.AreEqual(this.pathIdentifier,3);

			Assert.AreEqual(testThread.TimeInFuture,3);
			testThread.TimeMoved(3);
			Assert.IsTrue(testThread.IsAlive);

			while(testThread.CurrentTimeConsumer.ToString().Equals("C2->e1->1"))
			{
				testThread.TimeMoved(10);
				Assert.IsTrue(testThread.IsAlive);

				Console.WriteLine("TC: "+testThread.CurrentTimeConsumer);
				Assert.AreEqual(testThread.TimeInFuture,3);
				testThread.TimeMoved(3);
				Assert.IsTrue(testThread.IsAlive);

				Console.WriteLine("TC: "+testThread.CurrentTimeConsumer);
				Assert.AreEqual(testThread.TimeInFuture,3);
				testThread.TimeMoved(3);
				Assert.IsTrue(testThread.IsAlive);

				Console.WriteLine("TC: "+testThread.CurrentTimeConsumer);
				Assert.AreEqual(testThread.TimeInFuture,10);
				testThread.TimeMoved(10);
				Assert.IsTrue(testThread.IsAlive);

				Console.WriteLine("TC: "+testThread.CurrentTimeConsumer);
				Assert.AreEqual(testThread.TimeInFuture,5);
				testThread.TimeMoved(5);
				Assert.IsTrue(testThread.IsAlive);

				Assert.AreEqual(testThread.TimeInFuture,3);
				testThread.TimeMoved(3);
				Assert.IsTrue(testThread.IsAlive);
			}
			
			Assert.AreEqual(testThread.CurrentTimeConsumer.ToString(),"C2->e4->1");
			Assert.AreEqual(testThread.TimeInFuture,10);
			testThread.TimeMoved(10);
			Assert.IsTrue(testThread.IsAlive);

			Assert.AreEqual(testThread.TimeInFuture,7);
			testThread.TimeMoved(7);
			Assert.IsFalse(testThread.IsAlive);
			Assert.AreEqual(this.pathIdentifier,2);
		}

		[Test]
		public void test_periodic_thread_long_period()
		{
			IThreadStartingPoint sp = new DefaultThreadStartingPoint(ID("CC"),ID("P1"),ID("d1"));
			ISimulationEnvironment env = new DefaultSimulationEnvironment();

			long time = 0;

			TestArchitectures.FillCC(env.ComponentArchitecture.CreateCompositeRootComponent(ID("CC"),null));

			IPeriodicSimulationThread testThread =new DefaultPeriodicSimulationThread(10000,0,0,sp,
				env.ComponentArchitecture.CreateVisitor(sp),SimulationThreadType.TYPE_LOG_NOTHING,this);

			testThread.NewPeriodicThreadEvent += new EventHandler(this.OnNewPeriodicThread);

			Assert.IsFalse(testThread.IsAlive);
			testThread.Start();
			Assert.IsTrue(testThread.IsAlive);
			Assert.AreEqual(this.pathIdentifier,5);

			Assert.AreEqual(testThread.TimeInFuture,5);
			testThread.TimeMoved(5);
			time += 5;
			Assert.IsTrue(testThread.IsAlive);
			Assert.AreEqual(this.pathIdentifier,3);

			Assert.AreEqual(testThread.TimeInFuture,3);
			testThread.TimeMoved(3);
			time += 3;
			Assert.IsTrue(testThread.IsAlive);

			while(testThread.CurrentTimeConsumer.ToString().Equals("C2->e1->1"))
			{
				testThread.TimeMoved(10);
				Assert.IsTrue(testThread.IsAlive);
				time += 10;

				Console.WriteLine("TC: "+testThread.CurrentTimeConsumer);
				Assert.AreEqual(testThread.TimeInFuture,3);
				testThread.TimeMoved(3);
				time += 3;
				Assert.IsTrue(testThread.IsAlive);

				Console.WriteLine("TC: "+testThread.CurrentTimeConsumer);
				Assert.AreEqual(testThread.TimeInFuture,3);
				testThread.TimeMoved(3);
				time += 3;
				Assert.IsTrue(testThread.IsAlive);

				Console.WriteLine("TC: "+testThread.CurrentTimeConsumer);
				Assert.AreEqual(testThread.TimeInFuture,10);
				testThread.TimeMoved(10);
				time += 10;
				Assert.IsTrue(testThread.IsAlive);

				Console.WriteLine("TC: "+testThread.CurrentTimeConsumer);
				Assert.AreEqual(testThread.TimeInFuture,5);
				testThread.TimeMoved(5);
				time += 5;
				Assert.IsTrue(testThread.IsAlive);

				Assert.AreEqual(testThread.TimeInFuture,3);
				testThread.TimeMoved(3);
				time += 3;
				Assert.IsTrue(testThread.IsAlive);
			}
			
			Assert.AreEqual(testThread.CurrentTimeConsumer.ToString(),"C2->e4->1");
			Assert.AreEqual(testThread.TimeInFuture,10);
			testThread.TimeMoved(10);
			time += 10;
			Assert.IsTrue(testThread.IsAlive);

			Assert.AreEqual(testThread.TimeInFuture,7);
			testThread.TimeMoved(7);
			time += 7;
			Assert.IsTrue(testThread.IsAlive);
			Assert.AreEqual(this.pathIdentifier,2);

			Assert.AreEqual(testThread.TimeInFuture,10000-time);
			testThread.TimeMoved(10000-time);
			Assert.IsFalse(testThread.IsAlive);
			Assert.AreEqual(this.pathIdentifier,100);

		}

		private void OnNewPeriodicThread(object sender, EventArgs args)
		{
			Console.WriteLine("Notified to create a new Thread ...");
			this.pathIdentifier = 100;
		}

		#region IThreadObserver Member

		public void NotifyThreadReachedEnd(ISimulationThread sender)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") reached end...");
			this.pathIdentifier = 2;
		}

		public void NotifyThreadChangedTimeConsumer(ISimulationThread sender, ComponentNetworkSimulation.Structure.ITimeConsumer previous)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") changed TimeConsumer.");
			this.pathIdentifier = 3;
		}

		public void NotifyTimeStep(ISimulationThread sender, long timeStep)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") step: "+timeStep);
			if (this.pathIdentifier == 100) 
				this.pathIdentifier = 104;
			else
				this.pathIdentifier = 4;
		}

		public void NotifyThreadEnteredFirstTimeConsumer(ISimulationThread sender)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") entered first tc.");
			this.pathIdentifier = 5;
		}

		public void NotifyUnknownElementFound(ISimulationThread sender)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") unknown element found ...");
			this.pathIdentifier = 6;
		}

		public void NotifyUnboundExternalCall(ISimulationThread sender, Palladio.ComponentModel.IComponent callingComponent, 
			Palladio.ComponentModel.IExternalSignature externalSignature)
		{
			Console.WriteLine("Thread("+sender.ThreadID+") unbound external call.");
			this.pathIdentifier = 7;
		}

		#endregion

		public static IIdentifier ID(string id)
		{
			return IdentifiableFactory.CreateStringID(id);
		}
	}
}
