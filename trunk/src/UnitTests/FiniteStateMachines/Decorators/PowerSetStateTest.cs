using System;
using NUnit.Framework;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Decorators;
using Utils.Collections;
using System.Collections;

namespace UnitTests.FiniteStateMachines.Decorators
{
	/// <summary>
	/// Unit test for <code>PowerSetState</code>.
	/// </summary>
	[TestFixture]
	public class PowerSetStateTest{

		Set statesSetOne, statesSetTwo, statesSetThree;
		PowerSetState stateOne, stateTwo, stateThree;

		[SetUp] public void Init() {
			statesSetOne = new Set();
			statesSetOne.Add(new State("stateZero",true,false));
			statesSetOne.Add(new State("stateOne",false,false));
			statesSetOne.Add(new State("stateTwo",false,false));
			
			statesSetTwo = new Set();
			statesSetTwo.Add(new State("stateZero",true,false));
			statesSetTwo.Add(new State("stateOne",false,false));
			statesSetTwo.Add(new State("stateTwo",false,false));
			
			statesSetThree = new Set();
			statesSetThree.Add(new State("stateThree",false,false));
			statesSetThree.Add(new State("stateFour",false,true));

			stateOne = new PowerSetState(statesSetOne,true);
			stateTwo = new PowerSetState(statesSetTwo,true);
			stateThree = new PowerSetState(statesSetThree,false);
		}

		[Test] public void IsStartState() {
			Assert.IsTrue(stateOne.IsStartState);
			Assert.IsFalse(stateThree.IsStartState);
		}

		[Test] public void IsFinalState() {
			Assert.IsTrue(stateThree.IsFinalState);
			Assert.IsFalse(stateOne.IsFinalState);
		}

		[Test] public void Equals() {
			Assert.AreEqual(stateOne,stateTwo);
			Assert.IsFalse(stateOne.Equals(stateThree));
		}

		[Test] public void GetStates() {
			Assert.AreEqual(statesSetOne,stateOne.States);
		}
	}
}
