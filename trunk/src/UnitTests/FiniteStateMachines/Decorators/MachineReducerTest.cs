using System;
using NUnit.Framework;
using FiniteStateMachines;
using FiniteStateMachines.Decorators;
using Utils.Collections;
using System.Collections;

namespace UnitTests.FiniteStateMachines.Decorators
{
	/// <summary>
	/// Unit test for MachineReducer.
	/// </summary>
	[TestFixture]
	public class MachineReducerTest
	{
		AbstractFiniteStateMachine expandedMachine, topMachine;
		Hashtable table;

		[SetUp] public void Init() {
			AbstractFiniteStateMachine d1,d2;
			topMachine = AbstractFiniteStateMachine.Loader("../../data/provides.xml");
			d1 = AbstractFiniteStateMachine.Loader("../../data/se_d1.xml");
			d2 = AbstractFiniteStateMachine.Loader("../../data/se_d2.xml");

			table = new Hashtable();
			table.Add(new Input("d1"),d1);
			table.Add(new Input("d2"),d2);
			expandedMachine = new FiniteStackMachine(topMachine,table);
			Console.WriteLine(expandedMachine);
		}


		[Test] public void SimpleReduction() {
			MachineReducer reducer = new MachineReducer(table,expandedMachine);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			red.Equals(topMachine);
		}

		[Test] public void MoreComplexReduction() {
		}

		public static void Main(){
			MachineReducerTest test = new MachineReducerTest();
			test.Init();
			test.SimpleReduction();
			Console.ReadLine();
		}

	}
}
