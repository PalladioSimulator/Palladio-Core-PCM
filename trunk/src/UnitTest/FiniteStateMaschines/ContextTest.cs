using System;
using FiniteStateMachines;
using NUnit.Framework;

namespace UnitTests.FiniteStateMachines{

	/// <summary>
	/// Unit test for <code>Context</code>.
	/// </summary>
	[TestFixture]
	public class ContextTest{
		AbstractState stateOne,stateTwo;
		Input inputOne, inputTwo;

		[SetUp] public void Init() {
			stateOne = new State("stateOne",false,false);
			inputOne = new Input("inputOne");
			stateTwo = new State("stateTwo",false,false);
			inputTwo = new Input("inputTwo");
		}
		
		[Test] public void Constructor() {
			Context context = new Context(inputOne,stateOne);
			Assert.AreEqual(stateOne,context.State);
			Assert.AreEqual(inputOne,context.ServiceName);
		}

		[Test] public void Equals () {
			Context contextOne = new Context(inputOne,stateOne);
			Context contextTwo = new Context(inputOne,stateOne);
			Assert.AreEqual(contextOne,contextTwo);
			contextTwo.ServiceName = inputTwo;
			Assert.IsFalse(contextOne.Equals(contextTwo));
			contextTwo.State = stateTwo;
			Assert.IsFalse(contextOne.Equals(contextTwo));
			Assert.IsFalse(contextOne.Equals(contextOne.ToString()));
			Assert.IsFalse(contextOne.Equals(null));
		}

		[Test] public void CopyConstructor() {
			Context contextOne = new Context(inputOne,stateOne);
			Context contextTwo = new Context(contextOne);
			Assert.AreEqual(contextOne,contextTwo);
			contextTwo.ServiceName = inputTwo;
			contextTwo.State = stateTwo;
			Assert.IsFalse(contextOne.Equals(contextTwo));
		}

		[Test] public void Clone() {
			Context contextOne = new Context(inputOne,stateOne);
			Context contextTwo = (Context)contextOne.Clone();;
			Assert.AreEqual(contextOne,contextTwo);
			contextTwo.ServiceName = inputTwo;
			contextTwo.State = stateTwo;
			Assert.IsFalse(contextOne.Equals(contextTwo));
		}

		[Test] public void EqualsOperator () {
			Context contextOne = new Context(inputOne,stateOne);
			Context contextTwo = new Context(inputOne,stateOne);
			Assert.IsTrue(contextOne == contextTwo);
			contextTwo.ServiceName = inputTwo;
			Assert.IsFalse(contextOne == contextTwo);
			contextTwo.State = stateTwo;
			Assert.IsFalse(contextOne == contextTwo);
//			Assert.IsFalse(contextOne == null);
//			Assert.IsFalse(null == contextTwo);
		}
	}
}
