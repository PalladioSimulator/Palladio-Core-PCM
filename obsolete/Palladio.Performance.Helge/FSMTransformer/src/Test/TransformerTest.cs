#if TEST
using System;
using NUnit.Framework;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;
using Palladio.Performance.FSMTransformer;

namespace Palladio.Performance.FSMTransformer.Test
{
	/// <summary>
	/// Zusammenfassung für TransformerTest.
	/// </summary>
	[TestFixture]
	public class TransformerTest
	{
		[Test]
		public void FSMWithIntermediateState()
		{
			IFiniteStateMachine validSeff = FSMTransformer.SEFFValidity(fsm2);
			IFiniteStateMachine iFSM = FSMTransformer.FSMWithIntermediateState(validSeff);
			Assert.AreEqual(5, iFSM.Transitions.Length);

			Assert.AreEqual("intermediateState for state 1",iFSM.StartState.ID);

			inputHash2 = FSMFactory.CreateInputFromList("a", "b", "1", "2");

			IState state1 = iFSM.GetNextState(iFSM.StartState, inputHash2["1"]);

			Assert.AreEqual("1",state1.ID);

			IState iState2 = iFSM.GetNextState(state1, inputHash2["a"]);

			Assert.AreEqual("intermediateState for state 2",iState2.ID);
			IState iState1 = iFSM.GetNextState(state1, inputHash2["b"]);

			Assert.AreEqual("intermediateState for state 1",iState1.ID);
			IState state2 = iFSM.GetNextState(iState2, inputHash2["2"]);

			Assert.AreEqual("2",state2.ID);

			iState1 = iFSM.GetNextState(state2,inputHash2["a"]);

			Assert.AreEqual("intermediateState for state 1",iState1.ID);
		}

		[Test]
		[ExpectedException(typeof(ApplicationException))]
		public void SEFFValidityException()
		{
			FSMTransformer.SEFFValidity(fsm1);
		}

		[Test]
		public void SEFFValidity()
		{
			IFiniteStateMachine validFSM=FSMTransformer.SEFFValidity(fsm2);

			foreach(ITransition transition in validFSM.Transitions)
			{
				Assert.IsTrue(transition.Attributes.Contains(RandomVariable.AttributeType));
				Assert.IsTrue(transition.Attributes.Contains(ProbabilityAttribute.AttributeType));
			}

			foreach(IState state in validFSM.States)
			{
				Assert.IsTrue(state.Attributes.Contains(RandomVariable.AttributeType));
				ITransition[] transitions =validFSM.GetOutgoingTransitions(state);
				double sum=0;
				for (int i=0;i<transitions.Length;i++)
				{
					sum += ProbabilityAttribute.GetAttribute(transitions[i]).Probability;
				}
			}
		}


		[TestFixtureSetUp]
		public void Init()
		{
			stateHash1 = FSMFactory.CreateStatesFromList("1", "2");
			inputHash1 = FSMFactory.CreateInputFromList("a", "b");
			stateHash2 = FSMFactory.CreateStatesFromList("1", "2");
			inputHash2 = FSMFactory.CreateInputFromList("a", "b");

			fsm1 = FSMFactory.CreateEmptyFSM();
			fsm1.AddInputSymbols(inputHash1.StoredInputs);
			fsm1.AddStates(stateHash1.StoredStates);
			fsm1.StartState = stateHash1["1"];
			fsm1.FinalStates = new IState[] {stateHash1["2"]};

			fsm1.AddTransitions(
				FSMFactory.CreateDefaultTransition(stateHash1["1"], inputHash1["a"], stateHash1["2"]),
				FSMFactory.CreateDefaultTransition(stateHash1["2"], inputHash1["a"], stateHash1["1"]),
				FSMFactory.CreateDefaultTransition(stateHash1["1"], inputHash1["b"], stateHash1["1"])
				);
			fsm2 = FSMFactory.CreateEmptyFSM();
			fsm2.AddInputSymbols(inputHash2.StoredInputs);
			fsm2.AddStates(stateHash2.StoredStates);
			fsm2.StartState = stateHash2["1"];
			fsm2.FinalStates = new IState[] {stateHash2["2"]};

			fsm2.AddTransitions(
				FSMFactory.CreateDefaultTransition(stateHash2["1"], inputHash2["a"], stateHash2["2"]),
				FSMFactory.CreateDefaultTransition(stateHash2["2"], inputHash2["a"], stateHash2["1"]),
				FSMFactory.CreateDefaultTransition(stateHash2["1"], inputHash2["b"], stateHash2["1"])
				);



			foreach(IState state in fsm2.States)
			{
				state.Attributes.Add(QMLAttribute.AttributeType,
					new QMLAttribute(new double[]{100},new long[]{0}));
			}
			foreach(ITransition trans in fsm2.Transitions)
			{
				trans.Attributes.Add(QMLAttribute.AttributeType,
					new QMLAttribute(new double[]{100},new long[]{0}));
			}
			
		}

		private StateHash stateHash1,stateHash2;
		private InputSymbolHash inputHash1, inputHash2;
		private IEditableFiniteStateMachine fsm1, fsm2;

	}
}
#endif