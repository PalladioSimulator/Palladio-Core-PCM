using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Utils.Collections;
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
		IFiniteStateMachine fsmOne, fsmTwo;
		
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

		[Test] public void AddInputSymbols()
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

		[ExpectedException(typeof(Exception))]
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