using System;
using NUnit.Framework;
using Palladio.FiniteStateMachines;
using Utils.Collections;
using System.Collections;

namespace UnitTests.FiniteStateMachines {
	/// <summary>
	/// Unit test for <code>FiniteTabularMachine</code>.
	/// </summary>
	[TestFixture]
	public class FiniteTabularMachineTest {
		IState[] states;
		Input[] inputs;
		Transition[] transitionSetOne;
		Transition[] transitionSetTwo;
		Transition[] transitionSetThree;
		Transition[] transitions;
		TabularFSM machineOne;
		TabularFSM machineTwo;
		TabularFSM machineThree;


		[SetUp] public void Init() {
			states = new State[8];
			states[0] = new State("stateZero",true,false);
			states[1] = new State("stateOne",false,false);
			states[2] = new State("stateTwo",false,false);
			states[3] = new State("stateThree",false,false);
			states[4] = new State("stateFour",false,false);
			states[5] = new State("stateFive",false,true);
			states[6] = new State("stateSix",false,true);
			states[7] = new State("stateSeven",true,false);

			inputs = new Input[5];
			inputs[0] = new Input("zero");
			inputs[1] = new Input("one");
			inputs[2] = new Input("two");
			inputs[3] = new Input("three");
			inputs[4] = new Input("four");

			transitionSetOne = new Transition[6];
			transitionSetOne[0] = new Transition(states[0],inputs[4],states[0]);
			transitionSetOne[1] = new Transition(states[0],inputs[1],states[1]);
			transitionSetOne[2] = new Transition(states[0],inputs[3],states[5]);
			transitionSetOne[3] = new Transition(states[1],inputs[1],states[1]);
			transitionSetOne[4] = new Transition(states[1],inputs[2],states[5]);
			transitionSetOne[5] = new Transition(states[1],inputs[3],states[5]);
			machineOne = new TabularFSM();
			machineOne.AddTransitionList(transitionSetOne);

			transitionSetTwo = new Transition[3];
			transitionSetTwo[0] = new Transition(states[4],inputs[0],states[6]);
			transitionSetTwo[1] = new Transition(states[4],inputs[1],states[5]);
			transitionSetTwo[2] = new Transition(states[6],inputs[1],states[5]);
			machineTwo = new TabularFSM();
			machineTwo.AddTransitionList(transitionSetTwo);

			transitionSetThree = new Transition[3];
			transitionSetThree[0] = new Transition(states[0],inputs[0],states[1]);
			transitionSetThree[1] = new Transition(states[0],inputs[1],states[2]);
			transitionSetThree[2] = new Transition(states[1],inputs[1],states[2]);
			machineThree = new TabularFSM();
			machineThree.AddTransitionList(transitionSetThree);

			transitions = new Transition[2];
			transitions[0] = new Transition(states[0],inputs[0],states[6]);
			transitions[1] = new Transition(states[6],inputs[1],states[7]);
		}
		
		[ExpectedException(typeof(InvalidStateException))]
		[Test] public void AddTwoStartStates(){
			TabularFSM machine = new TabularFSM();
			machine.AddTransition(transitions[0]);
			machine.AddTransition(transitions[1]);
		}

		[Test] public void AddState(){
			TabularFSM machine = new TabularFSM();
			machine.AddTransition(transitions[0]);
			Assert.IsTrue(machine.FinalStates.Count == 1);
			Assert.IsTrue(machine.FinalStates.Contains(states[6]));
			Assert.IsTrue(machine.States.Count == 2);
			Assert.IsTrue(machine.States.Contains(states[6]));
			Assert.IsTrue(machine.States.Contains(states[0]));
			Assert.AreEqual(states[0],machine.StartState);
		}

		[ExpectedException(typeof(InvalidStateException))]
		[Test] public void NoStartState() {
			IState startsState = machineTwo.StartState;
		}

		[ExpectedException(typeof(ApplicationException))]
		[Test] public void NoFinalStates() {
			Set finalStates = machineThree.FinalStates;
		}

		[Test] public void MultipleFinalStates(){
			Set finalStates = machineTwo.FinalStates;
			Assert.IsTrue(finalStates.Count==2);
			Assert.IsTrue(finalStates.Contains(states[5]));
			Assert.IsTrue(finalStates.Contains(states[6]));
		}

		[Test] public void AddInput(){
			Set input = machineOne.InputAlphabet;
			Assert.IsTrue(input.Count == 4);
			Assert.IsTrue(input.Contains(inputs[1]));
			Assert.IsTrue(input.Contains(inputs[2]));
			Assert.IsTrue(input.Contains(inputs[3]));
			Assert.IsTrue(input.Contains(inputs[4]));
		}

		[ExpectedException(typeof(InvalidStateException))]
		[Test] public void AddNonDeterministicTransition() {
			machineOne.AddTransition(states[0],inputs[4],states[1]);
		}

		[Test] public void GetTransitions(){
			IList transitionList = machineOne.GetTransitions();
			Assert.IsTrue(transitionList.Count==6);
			foreach (Transition t in transitionSetOne) {
				Assert.IsTrue(transitionList.Contains(t));
			}
		}

		[Test] public void GetNextExistingTransition() {
			Assert.AreEqual(transitionSetOne[1],machineOne.GetNextTransition(states[0],inputs[1]));
			State tempState = new State((string)states[0].Name.Clone(),states[0].IsStartState,states[0].IsFinalState);
			Input tempInput = new Input((string)inputs[1].InputSymbol.Clone());
			Assert.AreEqual(transitionSetOne[1],machineOne.GetNextTransition(tempState,tempInput));
		}

		[Test] public void GetErrorTransition(){
			Assert.AreEqual(new Transition(states[0],inputs[2],machineOne.ErrorState),machineOne.GetNextTransition(states[0],inputs[2]));
			Assert.AreEqual(new Transition(states[5],inputs[0],machineTwo.ErrorState),machineTwo.GetNextTransition(states[5],inputs[0]));
		}

		[ExpectedException(typeof(InvalidStateException))]
		[Test] public void InvalidSourceState(){
			machineOne.GetNextTransition(states[7],inputs[0]);
		}

		[Test] public void FromErrorState() {
			Assert.AreEqual(new Transition(machineOne.ErrorState,inputs[1],machineOne.ErrorState),machineOne.GetNextTransition(machineOne.ErrorState,inputs[1]));
		}

		[ExpectedException(typeof(InvalidInputException))]
		[Test] public void InvalidInput() {
			machineOne.GetNextTransition(states[0],new Input("wrong input"));
		}

		[Test] public void GetNextStateLikeGetNextTransition(){
			Assert.AreEqual(machineOne.GetNextTransition(states[0],inputs[4]).DestinationState,machineOne.GetNextState(states[0],inputs[4]));
			Assert.AreEqual(machineOne.GetNextTransition(states[0],inputs[2]).DestinationState,machineOne.GetNextState(states[0],inputs[2]));
			Assert.AreEqual(machineOne.GetNextTransition(machineOne.ErrorState,inputs[4]).DestinationState,machineOne.GetNextState(machineOne.ErrorState,inputs[4]));
		}

		[ExpectedException(typeof(InvalidInputException))]
		[Test] public void InvalidInputForNextState() {
			machineOne.GetNextState(states[0],new Input("wrong input"));
		}

		[ExpectedException(typeof(InvalidStateException))]
		[Test] public void InvalidSourceStateForNextState(){
			machineOne.GetNextState(states[7],inputs[0]);
		}

		[Test] public void GetOutgoingTransitions(){
			IList outgoing = machineOne.GetOutgoingTransitions(states[0]);
			foreach (Transition trans in outgoing) {
				Assert.IsTrue(machineOne.InputAlphabet.Contains(trans.InputSymbol));
				Assert.AreEqual(machineOne.GetNextTransition(states[0],trans.InputSymbol),trans);
			}
		}

		[Test] public void GetReachableStates() {
			IList reach = machineOne.GetReachableStates(states[1]);
			Assert.IsTrue(reach.Count == 2);
			Assert.IsTrue(reach.Contains(states[1]));
			Assert.IsTrue(reach.Contains(states[5]));
			
			reach = machineOne.GetReachableStates(states[0]);
			Assert.IsTrue(reach.Count == 3);
			Assert.IsTrue(reach.Contains(states[1]));
			Assert.IsTrue(reach.Contains(states[5]));
			Assert.IsTrue(reach.Contains(states[0]));
		}

		[Test] public void Equals() {
			Assert.IsTrue(machineOne.Equals(machineOne));
			//TODO not yet complete
		}
	}
}
