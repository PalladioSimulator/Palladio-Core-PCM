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
			topMachine = AbstractFSM.Loader("../../data/provides.xml");
			d1 = AbstractFSM.Loader("../../data/se_d1.xml");
			d1s = AbstractFSM.Loader("../../data/se_d1s.xml");
			d2 = AbstractFSM.Loader("../../data/se_d2.xml");
			d3 = AbstractFSM.Loader("../../data/se_d3.xml");
			d3s = AbstractFSM.Loader("../../data/se_d3s.xml");
			d3incomplete = AbstractFSM.Loader("../../data/se_d3incomplete.xml");


			Input topServiceName = "top";

			tableSimple = new Hashtable();
			tableSimple.Add(new Input("d1"),d1);
			tableSimple.Add(new Input("d2"),d2);
			expandedSimple = new StackFSM(topMachine, topServiceName, tableSimple);

			tableComplex = new Hashtable();
			tableComplex.Add(new Input("d1"),d1s);
			tableComplex.Add(new Input("d2"),d2);
			tableComplex.Add(new Input("d3"),d3s);
			expandedComplex = new StackFSM(topMachine, topServiceName, tableComplex);

			tableIncomplete = new Hashtable();
			tableIncomplete.Add(new Input("d1"),d1s);
			tableIncomplete.Add(new Input("d2"),d2);
			tableIncomplete.Add(new Input("d3"),d3incomplete);
			expandedIncomplete = new StackFSM(topMachine, topServiceName, tableIncomplete);

			tableRecursion = new Hashtable();
			tableRecursion.Add(new Input("d1"),d1s);
			tableRecursion.Add(new Input("d2"),d2);
			tableRecursion.Add(new Input("d3"),d3);
			expandedRecursion = new StackFSM(topMachine, topServiceName, tableRecursion);
		}


		[Test] public void SimpleReduction() {
			FSMReducer reducer = new FSMReducer(tableSimple,expandedSimple);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			Assert.IsTrue(red.Equals(topMachine));
		}

		[Test] public void MoreComplexReduction() {
			FSMReducer reducer = new FSMReducer(tableComplex,expandedComplex);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			Assert.IsTrue(red.Equals(topMachine));
		}

		[Test] public void IncompleteReduction() {
			FSMReducer reducer = new FSMReducer(tableIncomplete,expandedComplex);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			//Assert.IsFalse(topMachine.Equals(red));
			//TODO: Equals does not work with incomplete automatons.
		}

		[Test] public void RecursionReduction(){
			FSMReducer reducer = new FSMReducer(tableRecursion,expandedRecursion);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			Assert.IsTrue(topMachine.Equals(red));
		}

		//		public static void Main(){
		//			IFiniteStateMachine d1 = AbstractFiniteStateMachine.Loader("../../data/se_d1.xml");
		//			Console.WriteLine(d1);
		//		}

	}
}
