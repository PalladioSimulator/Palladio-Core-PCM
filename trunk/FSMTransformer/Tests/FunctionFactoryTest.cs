/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/12/15 00:05:13  sliver
 * initial checkin after some major refactorings
 *
 * Revision 1.3  2004/11/08 03:50:06  sliver
 * *** empty log message ***
 *
 * Revision 1.2  2004/11/04 08:52:13  sliver
 * added regular expressions
 *
 * Revision 1.1  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 */
using NUnit.Framework;
using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.FSMTransformer.Tests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class FunctionFactoryTest
	{
		[Test]
		public void ToFSMWithIntermediateState()
		{
			IFiniteStateMachine iFSM = FSMTransformer.FSMWithIntermediateState(fsm);
			Assert.AreEqual(6, iFSM.Transitions.Length);

			IState state = fsm.GetNextState(fsm.StartState, inputHash["a"]);

			IState iState = iFSM.GetNextState(iFSM.StartState, inputHash["a"]);
			iState = iFSM.GetNextState(iState, FSMTransformer.RETURN_INPUT);
			Assert.AreEqual(state, iState);
		}

		[Test]
		public void FSMAcceptingStateSequence()
		{
			IFiniteStateMachine aFSM = FSMTransformer.FSMAcceptingStateSequence(fsm);
			IState aState = aFSM.GetNextState(aFSM.StartState, new StateInput(fsm.StartState));
			Assert.AreEqual(fsm.StartState, aState);

		}


		[TestFixtureSetUp]
		public void Init()
		{
			stateHash = FSMFactory.CreateStatesFromList("1", "2");
			inputHash = FSMFactory.CreateInputFromList("a", "b");

			fsm = FSMFactory.CreateEmptyFSM();
			fsm.AddInputSymbols(inputHash.StoredInputs);
			fsm.AddStates(stateHash.StoredStates);
			fsm.StartState = stateHash["1"];
			fsm.FinalStates = new IState[] {stateHash["2"]};

			fsm.AddTransitions(
				FSMFactory.CreateDefaultTransition(stateHash["1"], inputHash["a"], stateHash["2"]),
				FSMFactory.CreateDefaultTransition(stateHash["2"], inputHash["a"], stateHash["1"]),
				FSMFactory.CreateDefaultTransition(stateHash["1"], inputHash["b"], stateHash["1"])
				);
		}

		private StateHash stateHash;
		private InputSymbolHash inputHash;
		private IEditableFiniteStateMachine fsm;

	}
}