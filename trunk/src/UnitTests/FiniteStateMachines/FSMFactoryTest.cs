using System;
using NUnit.Framework;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Decorators;
using Utils.Collections;
using System.Collections;
using Palladio.ParameterisedContracts;

namespace UnitTests.FiniteStateMachines
{
	/// <summary>
	/// Zusammenfassung für FSMFactoryTest.
	/// </summary>
	[TestFixture]
	public class FSMFactoryTest
	{
		IFiniteStateMachine FSMOne;
		IFiniteStateMachine FSMTwo;
		FSMFactory factory;
		[SetUp] void Init()
		{
			this.factory = new FSMFactory();
			this.FSMOne = factory.CreateFSM();
			IState one = new State("one",true,false);
			IState two = new State("two",false, false);
			IState three = new State("three",false,true);
			Input a = new Input("a");
			Input b = new Input("b");
			Input c = new Input("c");
			Input d = new Input("d");
			this.FSMOne.AddTransition(new Transition(one,a,three));
			this.FSMOne.AddTransition(new Transition(three,a,three));
			this.FSMOne.AddTransition(new Transition(three,b,three));
			this.FSMOne.AddTransition(new Transition(one,c,three));

			this.FSMTwo = this.factory.CreateFSM();
			this.FSMTwo.AddTransition(new Transition(one,d,three));
			this.FSMTwo.AddTransition(new Transition(one,a,three));
			this.FSMTwo.AddTransition(new Transition(one,b,three));
			this.FSMTwo.AddTransition(new Transition(two,b,three));
			this.FSMTwo.AddTransition(new Transition(three,a,three));
		}

		[Test] public void InitTest()
		{
			FSMFactory factory = new FSMFactory();
			IFiniteStateMachine fsm = factory.CreateFSM();
			State a = new State("eins",true,false);
			Input i = new Input("i");
			fsm.AddTransition(new Transition(a,i,a));

			IFiniteStateMachine res = factory.Intersect(this.FSMOne,this.FSMTwo);
			IFiniteStateMachine merge = factory.Merge(this.FSMOne,this.FSMTwo);


		}

		/// <summary>
		/// 
		/// </summary>
		public static void Main()
		{
			FSMFactoryTest test = new FSMFactoryTest();
			test.Init();
			test.InitTest();
		}
	}
}
