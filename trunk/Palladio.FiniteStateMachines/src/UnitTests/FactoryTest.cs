#if TEST
using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Palladio.Utils.Collections;
using Palladio.FiniteStateMachines.DefaultFSM;
using Palladio.FiniteStateMachines.Exceptions;

namespace Palladio.FiniteStateMachines.UnitTests
{
	/// <summary>
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:19:38  joemal
	/// initial import
	///
	/// Revision 1.17  2004/06/02 18:40:23  sbecker
	/// Fixed docu
	///
	/// Revision 1.16  2004/05/13 15:03:46  sliver
	/// IMatchable Interface added
	///
	/// Revision 1.15  2004/05/12 13:33:45  sliver
	/// Comments for the exceptions added
	///
	/// Revision 1.14  2004/05/12 12:54:33  sliver
	/// Comments for the exceptions added
	///
	/// Revision 1.13  2004/05/12 12:04:24  sliver
	/// Test for GetReachableTransitions added.
	///
	/// Revision 1.12  2004/05/12 08:55:34  sbecker
	/// Added GetNextState or GetNextStates tests
	///
	/// Revision 1.11  2004/05/12 08:54:16  sliver
	/// GetOutGoingTransitions throws an InvalidStateException now, if the state is NULL or not in fsm.States
	///
	/// Revision 1.10  2004/05/12 08:40:33  sbecker
	/// Added GetOutgoingTransitions tests
	///
	/// Revision 1.9  2004/05/12 08:24:34  sbecker
	/// Added GetReachableStates test
	///
	/// Revision 1.8  2004/05/12 08:23:15  sliver
	/// DeleteIllegalTransition expects a TransitionNotFoundException now
	///
	/// Revision 1.7  2004/05/12 08:19:39  sbecker
	/// Added DeleteState test
	///
	/// Revision 1.6  2004/05/12 08:18:14  sliver
	/// DeleteStates throws a StateDeletionNotAllowedException now, if the specified state has any incoming or outgoing transtions.
	///
	/// Revision 1.5  2004/05/12 08:12:50  sbecker
	/// Added DeleteTransition test
	///
	/// Revision 1.4  2004/05/12 08:06:58  sbecker
	/// Added DeleteIllegalTransition
	///
	/// Revision 1.3  2004/05/12 07:50:59  sbecker
	/// Added CVS log and DeleteIllegalState Test
	///
	///
	/// </pre>
	/// </remarks>
	[TestFixture]
	public class FactoryTest
	{
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
		}

		[ExpectedException(typeof(NoStartStateException))]
		[Test] public void NoStartState()
		{
			IFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState s = fsm.StartState;
		}

		[Test] public void CreateEmptyFSM()
		{
			IFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			Assert.IsTrue(fsm.States.Length == 0);
			Assert.IsTrue(fsm.Transitions.Length == 0);
			Assert.IsTrue(fsm.FinalStates.Length == 0);
		}

		[Test] public void AddStates()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			StateHash states = FSMFactory.CreateStatesFromList("1","2","3");
			fsm.AddStates(states.StoredStates);
			Assert.IsTrue(fsm.States.Length == 3);
			foreach(IState s in states.StoredStates)
			{
				Assert.IsTrue(Array.IndexOf(fsm.States,s) >= 0);
			}
			fsm.AddStates(states.StoredStates);
			Assert.IsTrue(fsm.States.Length == 3);
			foreach(IState s in states.StoredStates)
			{
				Assert.IsTrue(Array.IndexOf(fsm.States,s) >= 0);
			}
		}

		[ExpectedException(typeof(StateNotFoundException))]
		[Test] public void AddStartStateNotInStates()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState state = FSMFactory.CreateDefaultState("start");
			fsm.StartState = state;
		}

		[ExpectedException(typeof(StateNotFoundException))]
		[Test] public void AddFinalStatesNotInStates()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			StateHash states = FSMFactory.CreateStatesFromList("f1","f2");
			fsm.FinalStates = states.StoredStates;
		}

		[Test] public void AddStatesStartFinal()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			StateHash states = FSMFactory.CreateStatesFromList("1","2","3");
			fsm.AddStates(states.StoredStates);
			fsm.StartState = states["1"];
			fsm.FinalStates = new IState[] { states["1"], states["3"] };
			fsm.FinalStates = new IState[] { states["1"], states["3"], states["1"], states["3"] };
			Assert.IsTrue(fsm.StartState.Equals(states["1"]));
			Assert.IsTrue(fsm.FinalStates.Length == 2);
			Assert.IsTrue(Array.IndexOf(fsm.FinalStates,states["1"]) >= 0);
			Assert.IsTrue(Array.IndexOf(fsm.FinalStates,states["3"]) >= 0);
			Assert.IsTrue(Array.IndexOf(fsm.FinalStates,states["2"]) < 0);
		}

		[Test] public void AddInputSymbolsInitial()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			InputSymbolHash inputs = FSMFactory.CreateInputFromList("a","b");
			fsm.AddInputSymbols(inputs.StoredInputs);
			Assert.IsTrue(fsm.InputAlphabet.Length == 2);
			Assert.IsTrue(Array.IndexOf(fsm.InputAlphabet,inputs["a"]) >= 0);
			Assert.IsTrue(Array.IndexOf(fsm.InputAlphabet,inputs["b"]) >= 0);
		}
		
		[ExpectedException(typeof(InvalidStateException))]
		[Test]public void AddNullTransition()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			ITransition trans = FSMFactory.CreateDefaultTransition(null,null,null);
			fsm.AddTransitions(trans);
		}
		
		[ExpectedException(typeof(InvalidInputException))]
		[Test]public void AddNullInputTransition()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			StateHash states = FSMFactory.CreateStatesFromList("a","b");
			fsm.AddStates(states.StoredStates);
			ITransition trans = FSMFactory.CreateDefaultTransition(states["a"],null,states["b"]);
			fsm.AddTransitions(trans);
		}

		[Test] public void AddDuplicateTransitions()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			StateHash states = FSMFactory.CreateStatesFromList("a","b");
			InputSymbolHash inputs = FSMFactory.CreateInputFromList("a","b","c");
			ITransition trans = FSMFactory.CreateDefaultTransition(states["a"],inputs["a"],states["a"]);
			fsm.AddStates(states.StoredStates);
			fsm.AddInputSymbols(inputs.StoredInputs);
			fsm.AddTransitions(trans,trans,trans);
			Assert.IsTrue(fsm.Transitions.Length == 1);
			Assert.IsTrue(fsm.Transitions[0].DestinationState.Equals(states["a"]));
			Assert.IsTrue(fsm.Transitions[0].InputSymbol.Equals(inputs["a"]));
			Assert.IsTrue(fsm.Transitions[0].SourceState.Equals(states["a"]));
		}

		[Test] public void BuildTestFSM()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
		}
		
		[ExpectedException(typeof(StateDeletionNotAllowed))]
		[Test] public void DeleteIllegalState()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			fsm.DeleteStates(fsm.StartState);
		}

		[ExpectedException(typeof(TransitionNotFoundException))]
		[Test] public void DeleteIllegalTransition()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			StateHash states = new StateHash(fsm.States);
			InputSymbolHash inputs = new InputSymbolHash(fsm.InputAlphabet);
			ITransition trans = FSMFactory.CreateDefaultTransition(states["1"],inputs["b"],states["3"]);
			fsm.DeleteTransitions(trans);
		}

		[Test] public void DeleteTransition()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			StateHash states = new StateHash(fsm.States);
			InputSymbolHash inputs = new InputSymbolHash(fsm.InputAlphabet);
			ITransition trans1 = FSMFactory.CreateDefaultTransition(states["2"],inputs["c"],states["3"]);
			ITransition trans2 = FSMFactory.CreateDefaultTransition(states["3"],inputs["eps"],states["1"]);
			ITransition trans3 = FSMFactory.CreateDefaultTransition(states["1"],inputs["a"],states["1"]);
			ITransition trans4 = FSMFactory.CreateDefaultTransition(states["1"],inputs["b"],states["2"]);
			fsm.DeleteTransitions(trans1,trans2);
			Assert.IsTrue(fsm.Transitions.Length == 2);
			Assert.IsTrue(fsm.States.Length == 3);
			Assert.IsTrue(Array.IndexOf(fsm.Transitions,trans1) == -1);
			Assert.IsTrue(Array.IndexOf(fsm.Transitions,trans2) == -1);
			Assert.IsTrue(Array.IndexOf(fsm.Transitions,trans3) >= 0);
			Assert.IsTrue(Array.IndexOf(fsm.Transitions,trans4) >= 0);
		}

		[Test] public void DeleteState()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			StateHash states = new StateHash(fsm.States);
			InputSymbolHash inputs = new InputSymbolHash(fsm.InputAlphabet);
			ITransition trans1 = FSMFactory.CreateDefaultTransition(states["2"],inputs["c"],states["3"]);
			ITransition trans2 = FSMFactory.CreateDefaultTransition(states["3"],inputs["eps"],states["1"]);
			ITransition trans3 = FSMFactory.CreateDefaultTransition(states["1"],inputs["a"],states["1"]);
			ITransition trans4 = FSMFactory.CreateDefaultTransition(states["1"],inputs["b"],states["2"]);
			fsm.DeleteTransitions(trans1,trans2);
			fsm.DeleteStates(states["3"]);
			Assert.IsTrue(fsm.Transitions.Length == 2);
			Assert.IsTrue(fsm.States.Length == 2);
			Assert.IsTrue(Array.IndexOf(fsm.Transitions,trans1) == -1);
			Assert.IsTrue(Array.IndexOf(fsm.Transitions,trans2) == -1);
			Assert.IsTrue(Array.IndexOf(fsm.Transitions,trans3) >= 0);
			Assert.IsTrue(Array.IndexOf(fsm.Transitions,trans4) >= 0);
			Assert.IsTrue(fsm.FinalStates.Length == 1);
			Assert.IsTrue(Array.IndexOf(fsm.States,states["3"]) == -1);
		}

		[Test] public void DeleteInputSymbol()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			IInput i = FSMFactory.CreateDefaultInput("i");
			fsm.AddInputSymbols(i);
			Assert.IsTrue(fsm.InputAlphabet.Length == 5);
			fsm.DeleteInputSymbols(i);
			Assert.IsTrue(fsm.InputAlphabet.Length == 4);
		}

		[ExpectedException(typeof(InputDeletionNotAllowedException))]
		[Test] public void DeleteUsedInputSymbol()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			fsm.DeleteInputSymbols(FSMFactory.CreateDefaultInput("b"));
		}

		[ExpectedException(typeof(InputNotFoundException))]
		[Test] public void DeleteUnkownInput()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			fsm.DeleteInputSymbols(FSMFactory.CreateDefaultInput("i"));
		}

		[Test] public void GetReachableStatesAfterDeleteTransition()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			StateHash states = new StateHash(fsm.States);
			InputSymbolHash inputs = new InputSymbolHash(fsm.InputAlphabet);
			ITransition trans1 = FSMFactory.CreateDefaultTransition(states["2"],inputs["c"],states["3"]);
			ITransition trans2 = FSMFactory.CreateDefaultTransition(states["3"],inputs["eps"],states["1"]);
			ITransition trans3 = FSMFactory.CreateDefaultTransition(states["1"],inputs["a"],states["1"]);
			ITransition trans4 = FSMFactory.CreateDefaultTransition(states["1"],inputs["b"],states["2"]);
			fsm.DeleteTransitions(trans1,trans2);
			Assert.IsTrue(fsm.Transitions.Length == 2);
			Assert.IsTrue(fsm.States.Length == 3);
			Assert.IsTrue(Array.IndexOf(fsm.Transitions,trans1) == -1);
			Assert.IsTrue(Array.IndexOf(fsm.Transitions,trans2) == -1);
			Assert.IsTrue(Array.IndexOf(fsm.Transitions,trans3) >= 0);
			Assert.IsTrue(Array.IndexOf(fsm.Transitions,trans4) >= 0);
			IState[] reachableStates = fsm.GetReachableStates(fsm.StartState);
			Assert.IsTrue(reachableStates.Length == 2);
			Assert.IsTrue(Array.IndexOf(reachableStates,states["3"]) == -1); 
		}

		[Test] public void AddInputSymbols()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			InputSymbolHash inputs = new InputSymbolHash(fsm.InputAlphabet);
			InputSymbolHash newSymbols = FSMFactory.CreateInputFromList("d","e");
			fsm.AddInputSymbols(newSymbols.StoredInputs);
			Assert.IsTrue(fsm.InputAlphabet.Length == 6);
			Assert.IsTrue(Array.IndexOf(fsm.InputAlphabet,newSymbols[(MatchableString)"d"]) >= 0);
			Assert.IsTrue(Array.IndexOf(fsm.InputAlphabet,newSymbols[(MatchableString)"e"]) >= 0);
			fsm.AddInputSymbols(newSymbols.StoredInputs);
			Assert.IsTrue(fsm.InputAlphabet.Length == 6);
			Assert.IsTrue(Array.IndexOf(fsm.InputAlphabet,newSymbols[(MatchableString)"d"]) >= 0);
			Assert.IsTrue(Array.IndexOf(fsm.InputAlphabet,newSymbols[(MatchableString)"e"]) >= 0);
		}

		[Test]public void GetOutgoingTransitions()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			StateHash states = new StateHash(fsm.States);
			InputSymbolHash inputs = new InputSymbolHash(fsm.InputAlphabet);
			ITransition[] transitions = fsm.GetOutgoingTransitions(states["1"]);
			Assert.IsTrue(transitions.Length == 2);
			transitions = fsm.GetOutgoingTransitions(states["2"]);
			Assert.IsTrue(transitions.Length == 1);
			transitions = fsm.GetOutgoingTransitions(states["3"]);
			Assert.IsTrue(transitions.Length == 1);
			fsm.AddTransitions(FSMFactory.CreateDefaultTransition(states["3"],inputs["eps"],states["2"]));
			transitions = fsm.GetOutgoingTransitions(states["3"]);
			Assert.IsTrue(transitions.Length == 2);
		}

		[ExpectedException(typeof(InvalidStateException))]
		[Test]public void GetNullPointerOutgoingTransitions()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			fsm.GetOutgoingTransitions(null);
		}

		[ExpectedException(typeof(InvalidStateException))]
		[Test]public void GetOutgoingTransitionsWithNonExistingState()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			fsm.GetOutgoingTransitions(FSMFactory.CreateDefaultState("lala"));
		}

		[ExpectedException(typeof(NoStateWithIDException))]
		[Test]public void GetState()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			Assert.AreEqual(FSMFactory.CreateDefaultState("1"), fsm.GetState("1"));
			fsm.GetState("34");

		}

		[ExpectedException(typeof(NoInputWithIDException))]
		[Test]public void GetInput()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			Assert.AreEqual(FSMFactory.CreateDefaultInput("eps"),fsm.GetInput((MatchableString)"eps"));
			fsm.GetInput((MatchableString)"not here");
		}

		[Test]public void AddTransition()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			fsm.AddTransition("1",(MatchableString)"c","3");
			Assert.IsTrue(fsm.Transitions.Length == 5);
			Assert.AreEqual( fsm.GetNextState( fsm.GetState("1"), fsm.GetInput((MatchableString)"c") ), fsm.GetState("3"));
		}
		
		[Test]public void Clean()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			fsm.AddStates( FSMFactory.CreateStatesFromList("4","5").StoredStates );
			Assert.IsTrue( fsm.GetReachableStates(fsm.StartState).Length == 3 );
			fsm.AddTransition("4",(MatchableString)"b","5");
			fsm.AddTransition("4",(MatchableString)"c","3");
			fsm.Clean();
			Assert.IsTrue( fsm.States.Length == 3 );
			Assert.IsTrue( fsm.Transitions.Length == 4 );
		}

		[Test]public void GetReachableTransitions()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			Assert.IsTrue( fsm.GetReachableTransitions(fsm.StartState).Length == 4 );
		}

		[Test]public void GetNextState()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			StateHash states = new StateHash(fsm.States);
			InputSymbolHash inputs = new InputSymbolHash(fsm.InputAlphabet);
			Assert.AreEqual(states["1"],fsm.GetNextState(states["1"],inputs["a"]));
			Assert.AreEqual(states["2"],fsm.GetNextState(states["1"],inputs["b"]));
			Assert.AreEqual(states["3"],fsm.GetNextState(states["2"],inputs["c"]));
			Assert.AreEqual(states["1"],fsm.GetNextState(states["3"],inputs["eps"]));
		}

		[Test]public void GetNextStatesNonDeterministic()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			StateHash states = new StateHash(fsm.States);
			InputSymbolHash inputs = new InputSymbolHash(fsm.InputAlphabet);
			IState[] resultStates =	fsm.GetNextStates(states["3"],inputs["eps"]);
			Assert.IsTrue (resultStates.Length == 1);
			Assert.AreEqual (states["1"],resultStates[0]);
			fsm.AddTransitions(FSMFactory.CreateDefaultTransition(states["3"],inputs["eps"],states["2"]));
			resultStates =	fsm.GetNextStates(states["3"],inputs["eps"]);
			Assert.IsTrue (resultStates.Length == 2);
			Assert.IsTrue(Array.IndexOf(resultStates,states["1"]) >= 0);
			Assert.IsTrue(Array.IndexOf(resultStates,states["2"]) >= 0);
		}

		[ExpectedException(typeof(FsmNotDeterministicException))]
		[Test]public void GetNextStateNonDeterministic()
		{
			IEditableFiniteStateMachine fsm = BuildExampleFSM();
			StateHash states = new StateHash(fsm.States);
			InputSymbolHash inputs = new InputSymbolHash(fsm.InputAlphabet);
			fsm.AddTransitions(FSMFactory.CreateDefaultTransition(states["3"],inputs["eps"],states["2"]));
			fsm.GetNextState(states["3"],inputs["eps"]);
		}

		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
		}

		private IEditableFiniteStateMachine BuildExampleFSM()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			StateHash states = FSMFactory.CreateStatesFromList("1","2","3");
			InputSymbolHash inputs = FSMFactory.CreateInputFromList("a","b","c","eps");
			fsm.AddStates(states.StoredStates);
			fsm.AddInputSymbols(inputs.StoredInputs);
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["1"],inputs["a"],states["1"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["1"],inputs["b"],states["2"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["2"],inputs["c"],states["3"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["3"],inputs["eps"],states["1"]));
			Assert.IsTrue(fsm.Transitions.Length == 4);
			states = FSMFactory.CreateStatesFromList("1","2","3");
			fsm.FinalStates = new IState[] { states["1"], states["3"] };
			fsm.StartState = states["1"];
			return fsm;
		}
	}
}
#endif