using System;
using NUnit.Framework;
using FiniteStateMachines;
using FiniteStateMachines.Decorators;
using Utils.Collections;
using System.Collections;
using ParameterisedContracts;

namespace UnitTests.FiniteStateMachines.Decorators {
	/// <summary>
	/// Unit test for MachineReducer.
	/// </summary>
	[TestFixture]
	public class MachineReducerTest {
		public IFiniteStateMachine expandedRecursion, expandedIncomplete, expandedComplex, expandedSimple, topMachine;
		public Hashtable tableSimple,tableComplex, tableIncomplete, tableRecursion;

		[SetUp] public void Init() {
			IFiniteStateMachine d1,d1s,d2,d3,d3s,d3incomplete;
			topMachine = AbstractFiniteStateMachine.Loader("../../data/provides.xml");
			d1 = AbstractFiniteStateMachine.Loader("../../data/se_d1.xml");
			d1s = AbstractFiniteStateMachine.Loader("../../data/se_d1s.xml");
			d2 = AbstractFiniteStateMachine.Loader("../../data/se_d2.xml");
			d3 = AbstractFiniteStateMachine.Loader("../../data/se_d3.xml");
			d3s = AbstractFiniteStateMachine.Loader("../../data/se_d3s.xml");
			d3incomplete = AbstractFiniteStateMachine.Loader("../../data/se_d3incomplete.xml");


			Input topServiceName = new Input("top");

			tableSimple = new Hashtable();
			tableSimple.Add(new Input("d1"),d1);
			tableSimple.Add(new Input("d2"),d2);
			expandedSimple = new StackFiniteStateMachine(topMachine, topServiceName, tableSimple);

			tableComplex = new Hashtable();
			tableComplex.Add(new Input("d1"),d1s);
			tableComplex.Add(new Input("d2"),d2);
			tableComplex.Add(new Input("d3"),d3s);
			expandedComplex = new StackFiniteStateMachine(topMachine, topServiceName, tableComplex);

			tableIncomplete = new Hashtable();
			tableIncomplete.Add(new Input("d1"),d1s);
			tableIncomplete.Add(new Input("d2"),d2);
			tableIncomplete.Add(new Input("d3"),d3incomplete);
			expandedIncomplete = new StackFiniteStateMachine(topMachine, topServiceName, tableIncomplete);

			tableRecursion = new Hashtable();
			tableRecursion.Add(new Input("d1"),d1s);
			tableRecursion.Add(new Input("d2"),d2);
			tableRecursion.Add(new Input("d3"),d3);
			expandedRecursion = new StackFiniteStateMachine(topMachine, topServiceName, tableRecursion);
		}


		[Test] public void SimpleReduction() {
			FiniteStateMachineReducer reducer = new FiniteStateMachineReducer(tableSimple,expandedSimple);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			Assert.IsTrue(red.Equals(topMachine));
		}

		[Test] public void MoreComplexReduction() {
			FiniteStateMachineReducer reducer = new FiniteStateMachineReducer(tableComplex,expandedComplex);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			Assert.IsTrue(red.Equals(topMachine));
		}

		[Test] public void IncompleteReduction() {
			FiniteStateMachineReducer reducer = new FiniteStateMachineReducer(tableIncomplete,expandedComplex);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			//Assert.IsFalse(topMachine.Equals(red));
			//TODO: Equals does not work with incomplete automatons.
		}

		[Test] public void RecursionReduction(){
			FiniteStateMachineReducer reducer = new FiniteStateMachineReducer(tableRecursion,expandedRecursion);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			Assert.IsTrue(topMachine.Equals(red));
		}

		public static void Main(){
			MachineReducerTest test = new MachineReducerTest();
			test.Init();
			test.RecursionReduction();
		}

	}
}
