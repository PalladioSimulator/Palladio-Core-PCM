using System;
using NUnit.Framework;
using FiniteStateMachines;
using FiniteStateMachines.Decorators;
using Utils.Collections;
using System.Collections;

namespace UnitTests.FiniteStateMachines.Decorators {
	/// <summary>
	/// Unit test for MachineReducer.
	/// </summary>
	[TestFixture]
	public class MachineReducerTest {
		public AbstractFiniteStateMachine expandedRecursion, expandedIncomplete, expandedComplex, expandedSimple, topMachine;
		public Hashtable tableSimple,tableComplex, tableIncomplete, tableRecursion;

		[SetUp] public void Init() {
			AbstractFiniteStateMachine d1,d1s,d2,d3,d3s,d3incomplete;
			topMachine = AbstractFiniteStateMachine.Loader("../../data/provides.xml");
			d1 = AbstractFiniteStateMachine.Loader("../../data/se_d1.xml");
			d1s = AbstractFiniteStateMachine.Loader("../../data/se_d1s.xml");
			d2 = AbstractFiniteStateMachine.Loader("../../data/se_d2.xml");
			d3 = AbstractFiniteStateMachine.Loader("../../data/se_d3.xml");
			d3s = AbstractFiniteStateMachine.Loader("../../data/se_d3s.xml");
			d3incomplete = AbstractFiniteStateMachine.Loader("../../data/se_d3incomplete.xml");


			tableSimple = new Hashtable();
			tableSimple.Add(new Input("d1"),d1);
			tableSimple.Add(new Input("d2"),d2);
			expandedSimple = new FiniteStackMachine(topMachine,tableSimple);

			tableComplex = new Hashtable();
			tableComplex.Add(new Input("d1"),d1s);
			tableComplex.Add(new Input("d2"),d2);
			tableComplex.Add(new Input("d3"),d3s);
			expandedComplex = new FiniteStackMachine(topMachine,tableComplex);

			tableIncomplete = new Hashtable();
			tableIncomplete.Add(new Input("d1"),d1s);
			tableIncomplete.Add(new Input("d2"),d2);
			tableIncomplete.Add(new Input("d3"),d3incomplete);
			expandedIncomplete = new FiniteStackMachine(topMachine,tableIncomplete);

			tableRecursion = new Hashtable();
			tableRecursion.Add(new Input("d1"),d1s);
			tableRecursion.Add(new Input("d2"),d2);
			tableRecursion.Add(new Input("d3"),d3);
			expandedRecursion = new FiniteStackMachine(topMachine,tableRecursion);
		}


		[Test] public void SimpleReduction() {
			MachineReducer reducer = new MachineReducer(tableSimple,expandedSimple);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			Assert.IsTrue(red.Equals(topMachine));
		}

		[Test] public void MoreComplexReduction() {
			MachineReducer reducer = new MachineReducer(tableComplex,expandedComplex);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			Assert.IsTrue(red.Equals(topMachine));
		}

		[Test] public void IncompleteReduction() {
			MachineReducer reducer = new MachineReducer(tableIncomplete,expandedComplex);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			//Assert.IsFalse(topMachine.Equals(red));
			//TODO: Equals does not work with incomplete automatons.
		}

		[Test] public void RecursionReduction(){
			MachineReducer reducer = new MachineReducer(tableRecursion,expandedRecursion);
		}

		public static void Main(){
			MachineReducerTest test = new MachineReducerTest();
			test.Init();
			test.RecursionReduction();
		}

	}
}
