using System;
using NUnit.Framework;
using FiniteStateMachines;
using FiniteStateMachines.Decorators;
using Utils.Collections;
using System.Collections;

namespace UnitTests.FiniteStateMachines.Decorators {
	/// <summary>
	/// Unit test for <code>FiniteEpsilonMachine</code>
	/// </summary>
	[TestFixture]
	public class ExpanderTest{
		AbstractState[] states;
		Input[] inputs;
		Transition[] transitionSet;
		FiniteTabularMachine tabularMachine;
		FiniteEpsilonMachine epsilonMachine;
		Set epsilonAlphabet;
		IFiniteStateMachine deterministicFSM;

		[SetUp] public void Init() {
			states = new State[6];
			states[0] = new State("stateZero",true,false);
			states[1] = new State("stateOne",false,false);
			states[2] = new State("stateTwo",false,false);
			states[3] = new State("stateThree",false,false);
			states[4] = new State("stateFour",false,false);
			states[5] = new State("stateFive",false,true);

			inputs = new Input[6];
			inputs[0] = new Input("zero");
			inputs[1] = new Input("one");
			inputs[2] = new Input("two");
			inputs[3] = new Input("three");
			inputs[4] = new Input("four");
			inputs[5] = new Input("five");

			transitionSet = new Transition[7];
			transitionSet[0] = new Transition(states[0],inputs[0],states[1]);
			transitionSet[1] = new Transition(states[0],inputs[2],states[3]);
			transitionSet[2] = new Transition(states[1],inputs[5],states[2]);
			transitionSet[3] = new Transition(states[2],inputs[1],states[0]);
			transitionSet[4] = new Transition(states[3],inputs[4],states[4]);
			transitionSet[5] = new Transition(states[4],inputs[1],states[5]);
			transitionSet[6] = new Transition(states[4],inputs[3],states[3]);
			tabularMachine = new FiniteTabularMachine();
			tabularMachine.addTransitions(transitionSet);

			epsilonAlphabet = new Set();
			epsilonAlphabet.Add(inputs[0]);
			epsilonAlphabet.Add(inputs[1]);
			epsilonAlphabet.Add(inputs[2]);

			epsilonMachine = new FiniteEpsilonMachine(tabularMachine,epsilonAlphabet);
			deterministicFSM = epsilonMachine.GetDeterministicFiniteStateMachine();
		}
		

		[Test] public void ExpandedEqualsOriginal() {
			MinimizedAndEqualsFSM fec = new MinimizedAndEqualsFSM(deterministicFSM);
			IFiniteStateMachine min = fec.getMinimizedFSM();
			Expander exp = new Expander(tabularMachine,min,epsilonAlphabet);
			IFiniteStateMachine expanded = exp.GetExpandedMachine();
			fec = new MinimizedAndEqualsFSM(tabularMachine);
			Assert.IsTrue(fec.equal(expanded));
		}

		
		[Test] public void ExpandReduced(){
			FiniteTabularMachine reduced = new FiniteTabularMachine();
			reduced.addTransition(states[0],inputs[4],states[5]);
			reduced.addTransition(states[5],inputs[3],states[1]);
			reduced.addTransition(states[1],inputs[4],states[5]);
			FiniteTabularMachine expected = new FiniteTabularMachine();
			expected.addTransition(transitionSet[0]);
			expected.addTransition(transitionSet[1]);
			expected.addTransition(transitionSet[4]);
			expected.addTransition(transitionSet[5]);
			expected.addTransition(transitionSet[6]);
			
			Expander exp = new Expander(tabularMachine,reduced,epsilonAlphabet);
			MinimizedAndEqualsFSM min = new MinimizedAndEqualsFSM(exp.GetExpandedMachine());
			Console.WriteLine(min.getMinimizedFSM());
			Assert.IsTrue(min.equal(expected));
		}
		
	}
}
