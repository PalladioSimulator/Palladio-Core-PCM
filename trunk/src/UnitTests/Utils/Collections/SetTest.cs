using System;
using Utils.Collections;
using NUnit.Framework;
using FiniteStateMachines;

namespace UnitTests.Utils.Collections
{
	/// <summary>
	/// Unit test for <code>Set</code>.
	/// </summary>
	[TestFixture]
	public class SetTest {
		Set setOne, setTwo;
		State[] states;

		[SetUp] public void Init() {
			states = new State[16];
			states[0] = new State("stateZero",true,false);
			states[1] = new State("stateOne",false,false);
			states[2] = new State("stateTwo",false,false);
			states[3] = new State("stateThree",false,false);
			states[4] = new State("stateFour",false,false);
			states[5] = new State("stateFive",false,true);
			states[6] = new State("stateSix",false,true);
			states[7] = new State("stateSeven",true,false);
			states[8] = new State("stateZero",true,false);
			states[9] = new State("stateOne",false,false);
			states[10] = new State("stateTwo",false,false);
			states[11] = new State("stateThree",false,false);
			states[12] = new State("stateFour",false,false);
			states[13] = new State("stateFive",false,true);
			states[14] = new State("stateSix",false,true);
			states[15] = new State("stateSeven",true,false);
			
			setOne = new Set();
			for (int i = 0; i<8; i++) {
				setOne.Add(states[i]);
			}

			setTwo = new Set();
			for (int i = 8; i<16; i++) {
				setTwo.Add(states[i]);
			}
		}
		
		[Test] public void Constructor() {
		}

		[Test] public void Equals() {
			Console.Error.WriteLine(setOne+"\n"+setTwo);
			Console.Error.WriteLine(setOne.Count+"\n"+setTwo.Count);
			Assert.IsTrue(setOne.Equals(setTwo));
			setTwo.Add(new State("dummy",false,false));
			Assert.IsFalse(setOne.Equals(setTwo));
		}

		[Test] public void Clone() {
			Set three = (Set)setOne.Clone();
			Assert.AreEqual(setOne,three);
			three.Add(new State("new state",false,false));
			Assert.IsFalse(setOne.Equals(three));
		}
	}
}
