using System;
using NUnit.Framework;

using ComponentNetworkSimulation.Structure.Visitor;
using ComponentNetworkSimulation.Structure;
using Palladio.FiniteStateMachines;

namespace nunittests.structure
{
	/// <summary>
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/05/27 10:32:36  joemal
	/// xxx
	///
	/// Revision 1.2  2004/05/26 16:38:46  joemal
	/// xxx
	///
	/// Revision 1.1  2004/05/24 16:00:14  joemal
	/// initial creation
	///
	/// </pre>
	/// </remarks>
	[TestFixture]
	public class ComponentArchitectureVisitorTest
	{
		private DefaultComponentArchitectureVisitor visitor;

		public ComponentArchitectureVisitorTest()
		{
		}

		[SetUp]
		public void Init()
		{
			visitor = new DefaultComponentArchitectureVisitor();
		}

		[Test]
		public void EmptyTest()
		{
			Assert.IsNull(visitor.CurrentTimeConsumer);
		} 

		[Test]
		public void TestPathThroughFSM()
		{
			IFiniteStateMachine fsm = TestArchitectures.createFSM();
			StateHash sh = new StateHash(fsm.States);

			visitor.SetStart(new DefaultThreadStartingPoint(fsm));
			Assert.AreSame(fsm.StartState,visitor.CurrentTimeConsumer);
			visitor.NextTimeConsumer();
			Assert.AreSame(sh["1"],visitor.CurrentTimeConsumer);			
			visitor.NextTimeConsumer();
			Assert.IsTrue(visitor.CurrentTimeConsumer == sh["2"] || visitor.CurrentTimeConsumer == sh["3"]);
			if (visitor.CurrentTimeConsumer == sh["2"]) 
			{
				Console.WriteLine("Langer weg");
				visitor.NextTimeConsumer();
				Assert.AreSame(sh["3"],visitor.CurrentTimeConsumer);			
			}
			visitor.NextTimeConsumer();
			Assert.IsNull(visitor.CurrentTimeConsumer);
			visitor.NextTimeConsumer();
			Assert.IsNull(visitor.CurrentTimeConsumer);
			visitor.NextTimeConsumer();
			Assert.IsNull(visitor.CurrentTimeConsumer);
		}

		[Test]
		public void TestPathThroughFSM1()
		{
			IFiniteStateMachine fsm = TestArchitectures.createFSMSEqualsFOneT();
			StateHash sh = new StateHash(fsm.States);

			visitor.SetStart(new DefaultThreadStartingPoint(fsm));
			Assert.AreSame(fsm.StartState,visitor.CurrentTimeConsumer);

			int count = 0;
			while(visitor.NextTimeConsumer() != null)
			{
				count ++;			
				Assert.IsTrue(visitor.CurrentTimeConsumer == sh["0"] || visitor.CurrentTimeConsumer == null);
			}

            Console.WriteLine(""+count+" times moved until left fsm."); 
		}

		[Test]
		public void TestPathThroughFSM2()
		{
			IFiniteStateMachine fsm = TestArchitectures.createFSM2();
			StateHash sh = new StateHash(fsm.States);

			visitor.SetStart(new DefaultThreadStartingPoint(fsm));
			Assert.AreSame(fsm.StartState,visitor.CurrentTimeConsumer);
			visitor.NextTimeConsumer();
			
			Assert.AreSame(sh["1"],visitor.CurrentTimeConsumer);			
			visitor.NextTimeConsumer();

			int cntr = 0;
			while (visitor.CurrentTimeConsumer == sh["2"]) 
			{
				visitor.NextTimeConsumer();
				cntr ++;
				Assert.AreSame(sh["1"],visitor.CurrentTimeConsumer,"State: "+((IState)visitor.CurrentTimeConsumer).ID);			
				visitor.NextTimeConsumer();
			}

			Assert.AreSame(sh["3"],visitor.CurrentTimeConsumer);			
			visitor.NextTimeConsumer();

			Assert.IsNull(visitor.CurrentTimeConsumer);
			Console.WriteLine("Moved in loop for "+cntr+" times.");
		}
	}
}
//EOF