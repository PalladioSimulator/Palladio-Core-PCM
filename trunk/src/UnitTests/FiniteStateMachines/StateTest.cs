using System;
using NUnit.Framework;
using Palladio.FiniteStateMachines;

namespace UnitTests.FiniteStateMachines
{
	/// <summary>
	/// Unit test for <code>State</code>.
	/// </summary>
	[TestFixture]
	public class StateTest
	{
		/// <summary>
		/// 
		/// </summary>
		[Test] public void Constructor() {
			State state = new State("state",true,false);
			Assert.AreEqual("state",state.Name);
			Assert.IsTrue(state.IsStartState);
			Assert.IsFalse(state.IsFinalState);
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void Equals () {
			State stateOne = new State("stateOne",true,false);
			State stateTwo = new State("stateTwo",true,false);
			State stateThree = new State("stateOne",true,true);
			State stateFour = new State("stateOne",true,false);
			Assert.AreEqual(stateOne,stateFour);
			Assert.IsFalse(stateOne.Equals(stateTwo));
			Assert.IsFalse(stateOne.Equals(stateThree));
			Assert.IsFalse(stateTwo.Equals(stateThree));
			Assert.IsFalse(stateTwo.Equals(stateFour));
		}


		/// <summary>
		/// 
		/// </summary>
		[Test] public void EqualOperator () {
			State stateOne = new State("stateOne",true,false);
			State stateTwo = new State("stateTwo",true,false);
			State stateThree = new State("stateOne",true,true);
			State stateFour = new State("stateOne",true,false);
			Assert.IsTrue(stateOne==stateFour);
			Assert.IsFalse(stateOne==stateTwo);
			Assert.IsFalse(stateOne==stateThree);
			Assert.IsFalse(stateTwo==stateThree);
			Assert.IsFalse(stateTwo==stateFour);
			Assert.IsFalse(stateOne == null);
			Assert.IsFalse(stateOne == stateTwo);
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void NotEqualOperator () {
			State stateOne = new State("stateOne",true,false);
			State stateTwo = new State("stateTwo",true,false);
			State stateThree = new State("stateOne",true,true);
			State stateFour = new State("stateOne",true,false);
			Assert.IsFalse(stateOne!=stateFour);
			Assert.IsTrue(stateOne!=stateTwo);
			Assert.IsTrue(stateOne!=stateThree);
			Assert.IsTrue(stateTwo!=stateThree);
			Assert.IsTrue(stateTwo!=stateFour);
			Assert.IsTrue(stateOne != null);
			Assert.IsTrue(stateOne != stateTwo);
		}
	}
}
