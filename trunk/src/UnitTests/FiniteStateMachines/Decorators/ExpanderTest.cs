using System;
using NUnit.Framework;
using FiniteStateMachines;
using FiniteStateMachines.Decorators;
using Utils.Collections;
using System.Collections;
using ParameterisedContracts;

namespace UnitTests.FiniteStateMachines.Decorators {
	/// <summary>
	/// Unit test for MachineExpander
	/// </summary>
	[TestFixture]
	public class MachineExpanderTest{
		AbstractState[] states;
		Input[] inputs;
		Transition[] transitionSet;
		FiniteTabularMachine tabularMachine;
		FiniteEpsilonMachine epsilonMachine;
		Set epsilonAlphabet;
		IFiniteStateMachine deterministicFSM;
        IFiniteStateMachine minimizedFSM;

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
			tabularMachine.AddTransitionList(transitionSet);

			epsilonAlphabet = new Set();
			epsilonAlphabet.Add(inputs[0]);
			epsilonAlphabet.Add(inputs[1]);
			epsilonAlphabet.Add(inputs[2]);

			epsilonMachine = new FiniteEpsilonMachine(tabularMachine,epsilonAlphabet);
			deterministicFSM = epsilonMachine.GetDeterministicFiniteStateMachine();
			MinimizedAndEqualsFSM fec = new MinimizedAndEqualsFSM(deterministicFSM);
			minimizedFSM = fec.getMinimizedFSM();
		}


		[Test] public void ExpandedEqualsOriginal() {
			MachineExpander exp = new MachineExpander(tabularMachine,minimizedFSM,epsilonAlphabet);
            IFiniteStateMachine expanded = exp.GetExpandedMachine();
			MinimizedAndEqualsFSM fec = new MinimizedAndEqualsFSM(tabularMachine);
			Assert.IsTrue(fec.equal(expanded));
		}

		
		[Test] public void ExpandReduced(){
			FiniteTabularMachine reduced = new FiniteTabularMachine();
			reduced.AddTransition(states[0],inputs[4],states[5]);
			reduced.AddTransition(states[5],inputs[3],states[1]);
			reduced.AddTransition(states[1],inputs[4],states[5]);
			FiniteTabularMachine expected = new FiniteTabularMachine();
			expected.AddTransition(transitionSet[0]);
			expected.AddTransition(transitionSet[1]);
			expected.AddTransition(transitionSet[4]);
			expected.AddTransition(transitionSet[5]);
			expected.AddTransition(transitionSet[6]);

			MachineExpander exp = new MachineExpander(tabularMachine,reduced,epsilonAlphabet);
			FiniteShuffleProductMaschine shuffle = new FiniteShuffleProductMaschine(tabularMachine,reduced);

			MinimizedAndEqualsFSM min = new MinimizedAndEqualsFSM(exp.GetExpandedMachine());
			Assert.IsTrue(min.equal(expected));
			Assert.IsTrue(min.equal(shuffle.ShuffleProduct));
		}

        [Test] public void ExpandModified(){
			FiniteTabularMachine reduced = new FiniteTabularMachine();
			reduced.AddTransition(states[3],inputs[4],states[5]);
			reduced.AddTransition(states[5],inputs[3],states[4]);
			reduced.AddTransition(states[4],inputs[4],states[5]);
			reduced.AddTransition(states[0],inputs[5],states[1]);
			reduced.AddTransition(states[1],inputs[5],states[2]);
			reduced.AddTransition(states[2],inputs[5],states[3]);
			MachineExpander machineExpander = new MachineExpander(tabularMachine,reduced,epsilonAlphabet);
            IFiniteStateMachine expanded = machineExpander.GetExpandedMachine();
            AbstractState state = expanded.StartState;
            state = expanded.GetNextState (state,inputs[2]);
            Assert.IsTrue(expanded.GetOutgoingTransitions(state).Count == 0);
            state = expanded.StartState;
            state = expanded.GetNextState (state,inputs[0]);
            state = expanded.GetNextState (state,inputs[5]);
            state = expanded.GetNextState (state,inputs[1]);
            state = expanded.GetNextState (state,inputs[0]);
            state = expanded.GetNextState (state,inputs[5]);
            state = expanded.GetNextState (state,inputs[1]);
            state = expanded.GetNextState (state,inputs[0]);
            state = expanded.GetNextState (state,inputs[5]);
            state = expanded.GetNextState (state,inputs[1]);
            Assert.IsFalse(state == expanded.ErrorState);
            Assert.IsTrue(expanded.GetOutgoingTransitions(expanded.GetNextState(state,inputs[0])).Count == 0);
            state = expanded.GetNextState (state,inputs[2]);
            state = expanded.GetNextState (state,inputs[4]);
            state = expanded.GetNextState (state,inputs[1]);
            Assert.IsTrue(expanded.FinalStates.Contains(state));

			FiniteShuffleProductMaschine shuffle = new FiniteShuffleProductMaschine(tabularMachine,reduced);
			MinimizedAndEqualsFSM min = new MinimizedAndEqualsFSM(expanded);
			Assert.IsTrue(min.equal(shuffle.ShuffleProduct));
		}
	}
}
