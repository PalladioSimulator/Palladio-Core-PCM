using System;
using Palladio.FiniteStateMachines;
using NUnit.Framework;
using Palladio.ParameterisedContracts;

namespace UnitTests.FiniteStateMachines{

	/// <summary>
	/// Unit test for <code>Context</code>.
	/// </summary>
	[TestFixture]
	public class ContextTest{
		IState stateOne,stateTwo;
		Input inputOne, inputTwo;

		/// <summary>
		/// 
		/// </summary>
		[SetUp] public void Init() {
			stateOne = new State("stateOne",false,false);
			inputOne = new Input("inputOne");
			stateTwo = new State("stateTwo",false,false);
			inputTwo = new Input("inputTwo");
		}
		
		/// <summary>
		/// 
		/// </summary>
		[Test] public void Constructor() {
			StackContext context = new StackContext(inputOne,stateOne);
			Assert.AreEqual(stateOne,context.State);
			Assert.AreEqual(inputOne,context.ServiceName);
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void Equals () {
			StackContext contextOne = new StackContext(inputOne,stateOne);
			StackContext contextTwo = new StackContext(inputOne,stateOne);
			Assert.AreEqual(contextOne,contextTwo);
			contextTwo.ServiceName = inputTwo;
			Assert.IsFalse(contextOne.Equals(contextTwo));
			contextTwo.State = stateTwo;
			Assert.IsFalse(contextOne.Equals(contextTwo));
			Assert.IsFalse(contextOne.Equals(contextOne.ToString()));
			Assert.IsFalse(contextOne.Equals(null));
		}


		/// <summary>
		/// 
		/// </summary>
		[Test] public void CopyConstructor() {
			StackContext contextOne = new StackContext(inputOne,stateOne);
			StackContext contextTwo = new StackContext(contextOne);
			Assert.AreEqual(contextOne,contextTwo);
			contextTwo.ServiceName = inputTwo;
			contextTwo.State = stateTwo;
			Assert.IsFalse(contextOne.Equals(contextTwo));
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void Clone() {
			StackContext contextOne = new StackContext(inputOne,stateOne);
			StackContext contextTwo = (StackContext)contextOne.Clone();;
			Assert.AreEqual(contextOne,contextTwo);
			contextTwo.ServiceName = inputTwo;
			contextTwo.State = stateTwo;
			Assert.IsFalse(contextOne.Equals(contextTwo));
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void EqualOperator () {
			StackContext contextOne = new StackContext(inputOne,stateOne);
			StackContext contextTwo = new StackContext(inputOne,stateOne);
			Assert.IsTrue(contextOne == contextTwo);
			contextTwo.ServiceName = inputTwo;
			Assert.IsFalse(contextOne == contextTwo);
			contextTwo.State = stateTwo;
			Assert.IsFalse(contextOne == contextTwo);
			Assert.IsFalse(contextOne == null);
			Assert.IsFalse(null == contextTwo);
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void NotEqualOperator () {
			StackContext contextOne = new StackContext(inputOne,stateOne);
			StackContext contextTwo = new StackContext(inputOne,stateOne);
			Assert.IsFalse(contextOne != contextTwo);
			contextTwo.ServiceName = inputTwo;
			Assert.IsTrue(contextOne != contextTwo);
			contextTwo.State = stateTwo;
			Assert.IsTrue(contextOne != contextTwo);
			Assert.IsTrue(contextOne != null);
			Assert.IsTrue(null != contextTwo);
		}
	
	}
}
