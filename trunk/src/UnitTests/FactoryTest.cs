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
	[TestFixture]
	public class DefaultTestFixture
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
	}
}