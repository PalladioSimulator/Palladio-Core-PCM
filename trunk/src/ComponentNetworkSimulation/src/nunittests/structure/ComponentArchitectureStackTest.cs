using System;
using NUnit.Framework;

using ComponentNetworkSimulation.Structure.Visitor;
using Palladio.FiniteStateMachines;

namespace nunittests.structure
{
	/// <summary>
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/05/24 16:00:14  joemal
	/// initial creation
	///
	/// </pre>
	/// </remarks>
	[TestFixture]
	public class ComponentArchitectureStackTest
	{
		private DefaultComponentArchitectureStack stack = new DefaultComponentArchitectureStack();

		public ComponentArchitectureStackTest()
		{
		}

		[SetUp]
		public void Init()
		{
			stack.Clear();
		}

		[Test]
		public void EmptyTest()
		{
			stack.Push(FSMFactory.CreateDefaultState("State"));
			Assert.IsNotNull(stack.Peek());
			stack.Clear();
			Assert.IsNull(stack.Peek());
		}

		[ExpectedException(typeof(NotImplementedException))]
		[Test]
		public void TestPushObjectMethod()
		{
			stack.Push(new object());
		}

		[Test]
		public void TestPushMethods()
		{
			IState startState = FSMFactory.CreateDefaultState("StartState");
			IFiniteStateMachine fsm = FSMFactory.CreateFSM(startState);
			stack.Push(fsm);
			Assert.AreEqual(2,stack.Count);
			Assert.AreSame(stack.Peek(),startState);
			stack.Push(FSMFactory.CreateDefaultTransition(startState,FSMFactory.CreateDefaultInput("e1"),startState));
			Assert.IsTrue(stack.Peek() is ITransition);
			stack.Pop();
			stack.Pop();
			Assert.AreSame(stack.Peek(),fsm);
			stack.Pop();
			Assert.IsNull(stack.Peek());
			stack.Pop();
			Assert.IsNull(stack.Peek());
			stack.Pop();
			Assert.IsNull(stack.Peek());
		}

		[Test]
		public void TestCountMethod()
		{
			IState startState = FSMFactory.CreateDefaultState("StartState");
			IFiniteStateMachine fsm = FSMFactory.CreateFSM(startState);
			stack.Push(fsm);
			Assert.AreEqual(1,stack.GetCountOfElement(startState));
			Assert.AreEqual(1,stack.GetCountOfElement(fsm));
			stack.Push(FSMFactory.CreateDefaultTransition(startState,FSMFactory.CreateDefaultInput("e1"),startState));
			Assert.AreEqual(1,stack.GetCountOfElement(startState));
			Assert.AreEqual(1,stack.GetCountOfElement(fsm));
			stack.Pop();
			stack.Pop();
			Assert.AreEqual(0,stack.GetCountOfElement(startState));
			Assert.AreEqual(1,stack.GetCountOfElement(fsm));
			stack.Push(fsm);
			stack.Push(fsm);
			stack.Push(fsm);
			Assert.AreEqual(3,stack.GetCountOfElement(startState));
			Assert.AreEqual(4,stack.GetCountOfElement(fsm));
			stack.Clear();
			Assert.AreEqual(0,stack.GetCountOfElement(startState));
		}
	}
}
//EOF