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
		AbstractState[,] dbaStates;
		Input[] dbaInputs;
		Transition[][] dbaTransitions;
		IFiniteStateMachine[] dbas;
		IFiniteStateMachine expandedMachine;
		IFiniteStateMachine topMachine;
		Transition[] topTransitions;
		AbstractState[] topStates;
		Input[] topInput;
		Hashtable ruleTable;

		[SetUp] public void Init() 
		{
			dbaStates = new State[1,2];
			dbaStates[0,0] = new State("00",true,false);
			dbaStates[0,1] = new State("01",false,true);
			dbaInputs = new Input[6];
			dbaInputs[0] = new Input("a");
			dbaInputs[1] = new Input("b");
			dbaInputs[2] = new Input("c");
			dbaInputs[3] = new Input("d");
			dbaInputs[4] = new Input("e");
			dbaInputs[5] = new Input("f");
			dbaTransitions = new Transition[1][];
			dbaTransitions[0] = new Transition[1];
			dbaTransitions[0][0] = new Transition(dbaStates[0,0],dbaInputs[3],dbaStates[0,1]);
			dbas = new IFiniteStateMachine[1];
			dbas[0] = new FiniteTabularMachine(dbaTransitions[0]);

			topStates = new State[2];
			topStates[0] = new State("Zero",true,false);
			topStates[1] = new State("One",false,true);
			topInput = new Input[1];
			topInput[0] = new Input("d1");
			topTransitions = new Transition[1];
			topTransitions[0] = new Transition(topStates[0],topInput[0],topStates[1]);
			topMachine = new FiniteTabularMachine(topTransitions);

			Hashtable sesp = new Hashtable();
			sesp.Add(topInput[0],dbas[0]);
			expandedMachine = new FiniteStackMachine(topMachine,sesp);

			ruleTable = new Hashtable();
			ruleTable.Add(topInput[0],new Rule(dbas[0],topTransitions[0]));
		}


		[Test] public void SimpleReduction() {
			MachineReducer reducer = new MachineReducer(ruleTable,expandedMachine);
			IFiniteStateMachine red = reducer.GetReducedMachine();
			Console.WriteLine(red);
			MinimizedAndEqualsFSM min = new MinimizedAndEqualsFSM(red);
			Assert.IsTrue(min.equal(topMachine));
		}
	}
}
