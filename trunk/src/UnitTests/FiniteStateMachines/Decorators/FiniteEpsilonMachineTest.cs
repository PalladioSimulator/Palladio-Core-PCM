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
	public class FiniteEpsilonMachineTest{
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
		
		[Test] public void GetStartState() {
			Set dump = new Set();
			dump.Add(states[0]);
			dump.Add(states[1]);
			dump.Add(states[3]);
			Assert.AreEqual(new PowerSetState(dump,true),epsilonMachine.StartState);
		}

		[Test] public void GetNextTransitonForValidEpsilonInput() {
			AbstractState state = epsilonMachine.StartState;
			Transition trans = epsilonMachine.GetNextTransition(state,inputs[0]);
			Assert.AreEqual(state,trans.SourceState);
			Assert.AreEqual(inputs[0],trans.InputSymbol);
			Assert.AreEqual(state,trans.DestinationState);
		}

		[Test] public void GetNextTransitonForInvalidEpsilonInput() {
			AbstractState state = epsilonMachine.StartState;
			Transition trans = epsilonMachine.GetNextTransition(state,inputs[1]);
			Assert.AreEqual(state,trans.SourceState);
			Assert.AreEqual(inputs[1],trans.InputSymbol);
			Assert.AreEqual(epsilonMachine.ErrorState,trans.DestinationState);
		}

		[Test] public void GetNextTransitonForValidInput() {
			AbstractState state = epsilonMachine.StartState;
			Set destSet = new Set();
			destSet.Add(states[4]);
			destSet.Add(states[5]);
			PowerSetState destination = new PowerSetState(destSet,false);
			Transition trans = epsilonMachine.GetNextTransition(state,inputs[4]);
			Assert.AreEqual(state,trans.SourceState);
			Assert.AreEqual(inputs[4],trans.InputSymbol);
			Assert.AreEqual(destination,trans.DestinationState);
		}

		[Test] public void GetNextTransitonForValidInputAndComplexClosure() {
			AbstractState state = epsilonMachine.StartState;
			Set destSet = new Set();
			destSet.Add(states[0]);
			destSet.Add(states[1]);
			destSet.Add(states[2]);
			destSet.Add(states[3]);
			PowerSetState destination = new PowerSetState(destSet,false);
			Transition trans = epsilonMachine.GetNextTransition(state,inputs[5]);
			Assert.AreEqual(state,trans.SourceState);
			Assert.AreEqual(inputs[5],trans.InputSymbol);
			Assert.AreEqual(destination,trans.DestinationState);
		}

		[Test] public void GetNextTransitonForInvalidInput() {
			AbstractState state = epsilonMachine.StartState;
			Transition trans = epsilonMachine.GetNextTransition(state,inputs[3]);
			Assert.AreEqual(state,trans.SourceState);
			Assert.AreEqual(inputs[3],trans.InputSymbol);
			Assert.AreEqual(epsilonMachine.ErrorState,trans.DestinationState);
		}

		[Test] public void GetNextStateSameAsGetNextTransition() {
			AbstractState start = epsilonMachine.StartState;
			foreach (Input i in epsilonMachine.InputAlphabet) {
				Assert.AreEqual(epsilonMachine.GetNextTransition(start,i).DestinationState,epsilonMachine.GetNextState(start,i));
			}
		}

		[Test] public void GetOutgoingTransitions() {
			Set destSet = new Set();
			destSet.Add(states[0]);
			destSet.Add(states[1]);
			destSet.Add(states[2]);
			destSet.Add(states[3]);
			PowerSetState destination = new PowerSetState(destSet,false);

			IList outgoing = epsilonMachine.GetOutgoingTransitions(epsilonMachine.StartState);
			Assert.IsTrue(outgoing.Count==2);
			Transition trans = new Transition(epsilonMachine.StartState,inputs[5],destination);
			Assert.IsTrue(outgoing.Contains(trans));
		}

		[Test] public void DeterministicStartState() {
			Assert.AreEqual(epsilonMachine.StartState,deterministicFSM.StartState);
		}

		[Test] public void DeterministicInputAlphabet() {
			foreach(Input i in deterministicFSM.InputAlphabet) {
				Assert.IsFalse(epsilonMachine.EpsilonAlphabet.Contains(i));
			}
			foreach(Input i in epsilonMachine.InputAlphabet) {
				if (!epsilonMachine.EpsilonAlphabet.Contains(i)) {
					Assert.IsTrue(deterministicFSM.InputAlphabet.Contains(i));
				}
			}
		}

		[Test] public void DeterministicTransitions() {
			AbstractState epsilonStart = epsilonMachine.StartState;
			AbstractState deterministicStart = deterministicFSM.StartState;

			foreach(Input i in deterministicFSM.InputAlphabet) {
				Assert.AreEqual(epsilonMachine.GetNextTransition(epsilonStart,i),
								deterministicFSM.GetNextTransition(deterministicStart,i));
			}
		}
	}
}
