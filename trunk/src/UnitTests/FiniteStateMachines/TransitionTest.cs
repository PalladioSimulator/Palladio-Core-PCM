using System;
using System.Collections;
using NUnit.Framework;
using Palladio.FiniteStateMachines;


namespace UnitTests.FiniteStateMachines {
	/// <summary>
	/// Unit test for <code>StackFiniteStateMachine</code>
	/// </summary>
	[TestFixture]
	public class TransitionTest {
		IState s1,s2,s3;
		Input i1,i2;
		Transition tOne, tTwo, tThree, tFour;

		/// <summary>
		/// 
		/// </summary>
		[SetUp] public void Init() {
			s1 = new State("s1",true,false);
			s2 = new State("s2",false,false);
			s3 = new State("s3",false,true);
			i1 = new Input("i1");
			i2 = new Input("i2");
			tOne = new Transition(s1,i1,s2);
			tTwo = new Transition(s1,i2,s2);
			tThree = new Transition(s2,i1,s1);
			tFour = new Transition(s1,i1,s2);
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void Constructor() {
			Assert.AreEqual(s1,tOne.SourceState);
			Assert.AreEqual(s2,tOne.DestinationState);
			Assert.AreEqual(i1,tOne.InputSymbol);
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void Equals() {
			Assert.IsFalse(tOne.Equals(tTwo));
			Assert.IsFalse(tOne.Equals(tThree));
			Assert.IsFalse(tThree.Equals(tTwo));
			Assert.IsTrue(tFour.Equals(tOne));
			Assert.IsFalse(tOne.Equals(null));
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void HashCode() {
			Assert.IsFalse(tOne.GetHashCode() == tTwo.GetHashCode());
			Assert.IsFalse(tOne.GetHashCode() == tThree.GetHashCode());
			Assert.IsFalse(tThree.GetHashCode() == tTwo.GetHashCode());
			Assert.IsTrue(tFour.GetHashCode() == tOne.GetHashCode());
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void SetValues() {
			Transition t = new Transition(s2,i2,s3);
			t.SetValues(tOne.SourceState,tOne.InputSymbol,tOne.DestinationState);
			Assert.AreEqual(tOne,t);
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void CopyConstructor() {
			Assert.AreEqual(tOne,new Transition(tOne));
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void Clone() {
			Assert.AreEqual(tOne,tOne.Clone());
		}
	}
}
