using System;
using NUnit.Framework;

using ComponentNetworkSimulation.Structure.Services;
using ComponentNetworkSimulation.Structure;
using Palladio.FiniteStateMachines;

namespace nunittests.structure
{
	/// <summary>
	/// Zusammenfassung für TimeConsumingFSMTest.
	/// </summary>
/*	[TestFixture]
	public class TimeConsumingFSMTest
	{
		public TimeConsumingFSMTest()
		{
		}

		[SetUp]
		public void doInit()
		{
		}

		[Test]
		public void test_probability()
		{
			IFiniteStateMachine fsm = new FSMFactory().GenerateFSM();
			StaticTimeState state1 = new StaticTimeState("State1",true,false,new BasicTimeStateParams(fsm,5,LoggingType_t.NO_LOG));
			StaticTimeState state2 = new StaticTimeState("State2",false,true,new BasicTimeStateParams(fsm,5,LoggingType_t.NO_LOG));

			StaticTimeTransition trans = new StaticTimeTransition(state1,new Input("e1"),state2,
				new BasicTimeTransitionParams(LoggingType_t.NO_LOG,0.5,5));

			fsm.AddTransition(trans);

			for (int a=0;a<100;a++) 
			{
				state1.ThreadEntered();	
				Assert.AreSame(state1.NextTimeConsumer,trans,"In run "+a);
			}

			for (int a=0;a<100;a++) 
			{
				state2.ThreadEntered();	
				Assert.IsNull(state2.NextTimeConsumer,"In run "+a);
			}

			StaticTimeTransition trans2 = new StaticTimeTransition(state1,new Input("e2"),state1,
				new BasicTimeTransitionParams(LoggingType_t.NO_LOG,0.5,2));
			fsm.AddTransition(trans2);

			int trans1Cntr = 0;

			for (int a=0;a<100;a++) 
			{
				state1.ThreadEntered();	
				if (state1.NextTimeConsumer==trans) trans1Cntr ++;
			}

			Console.Out.WriteLine("Verhältnis: "+((double)trans1Cntr/100.0));
			Assert.IsTrue(trans1Cntr > 40 && trans1Cntr < 60,"No problems if this test fails, the value "+((double)trans1Cntr/100.0)+
						" must be near to 0.5.");

			StaticTimeTransition trans3 = new StaticTimeTransition(state2,new Input("e3"),state2,
				new BasicTimeTransitionParams(LoggingType_t.NO_LOG,0.3,2));
			fsm.AddTransition(trans3);

			int trans2Cntr = 0;

			for (int a=0;a<100;a++) 
			{
				state2.ThreadEntered();	
				if (state2.NextTimeConsumer==null) trans2Cntr ++;
			}

			Console.Out.WriteLine("Verhältnis: "+((double)trans2Cntr/100.0));
			Assert.IsTrue(trans2Cntr > 60 && trans2Cntr < 80,"No problems if this test fails, the value "+((double)trans2Cntr/100.0)+
				" must be near to 0.7.");
		}
	}*/
}
