using System;
using NUnit.Framework;
using FiniteStateMachines;
using ParameterisedContracts;

namespace UnitTests.FiniteStateMachines {
	/// <summary>
	/// Unit test for <code>StackState</code>
	/// </summary>
	[TestFixture]
	public class StackStateTest {
		AbstractState a,b,c,d;
		Input s1,s2,s3,s4;

		[SetUp] public void Init() {
			a = new State("a",true,false);
			b = new State("b",false,false);
			c = new State("c",false,false);
			d = new State("d",false,true);

			s1 = new Input("1");
			s2 = new Input("2");
			s3 = new Input("3");
			s4 = new Input("2");
		}

		[Test] public void Constructor() {
			StackState state = new StackState(a);
			Assert.AreSame(a,state.Peek().State);
		}


		[Test] public void Equals(){
			StackState state1 = new StackState(a);
			StackState state2 = new StackState(b);
			StackState state3 = new StackState(a);

			Assert.IsFalse(state1.Equals(state2));
			Assert.IsTrue(state1.Equals(state3));

			state1.Push(s1,b);
			Assert.IsFalse(state1.Equals(state3));

			state3.Push(s1,b);
			Assert.IsTrue(state1.Equals(state3));

			state1.Push(s2,c);
			state3.Push(s3,c);
			Assert.IsFalse(state1.Equals(state3));
		}

		[Test] public void CopyConstructor(){
			StackState state = new StackState(a);
			StackState clone = new StackState(state);
			Assert.AreEqual(state,clone);
			
			clone.ChangeTopState(b);
			Assert.IsFalse(state.Equals(clone));
			
			clone = new StackState(state);

			state.Push(s1,b);
			state.Push(s2,c);
			clone = new StackState(state);
			Assert.AreEqual(state,clone);

			clone.Push(s3,d);
			Assert.IsFalse(state.Equals(clone));

			clone.Pop();
			clone.ChangeTopState(d);
			Assert.IsFalse(state.Equals(clone));

		}

		[Test] public void IsEmpty() {
			StackState state = new StackState(a);
			Assert.IsTrue(state.InTopService);
			state.Push(s1,a);
			Assert.IsFalse(state.InTopService);
		}

		[Test] public void PushPeek() {
			StackState state = new StackState(a);
			state.Push(s1,b);
			Assert.AreSame(s1,state.Peek().ServiceName);
			Assert.AreSame(b,state.Peek().State);
		}

		[Test] public void EmptyPeek() {
			StackState state = new StackState(a);
			Assert.AreEqual(StackState.TOP_SERVICE_NAME,state.Peek().ServiceName);
			Assert.AreSame(a,state.Peek().State);
		}

		[Test] public void Pop() {
			StackState state = new StackState(a);
			state.Push(s1,b);
			StackContext con = state.Pop();
			Assert.AreSame(s1,con.ServiceName);
			Assert.AreSame(b,con.State);
			con = state.Pop();
			Assert.AreSame(a,con.State);
			Assert.AreEqual(StackState.TOP_SERVICE_NAME,con.ServiceName);
		}

		
		[Test] public void PopEmptyServiceName() {
			StackState state = new StackState(a);
			Assert.AreEqual(StackState.TOP_SERVICE_NAME,state.Pop().ServiceName);
		}

		[Test] public void PopEmptyState() {
			StackState state = new StackState(a);
			state.Pop();
			Assert.IsTrue(state.IsEmpty);
			Assert.IsFalse(state.InTopService);
		}

		[Test] public void LookUpServiceName() {
			StackState stateOne = new StackState(a);
			stateOne.Push(s1,b);
			stateOne.Push(s2,c);

			StackState stateTwo = new StackState(a);
			stateTwo.Push(s1,b);
			Assert.AreEqual(stateTwo,stateOne.LookupServiceName(s1));
			Assert.IsTrue(stateOne.LookupServiceName(s3).IsEmpty);
		}

		[Test] public void LookUpServiceNameTwice() {
			StackState stateOne = new StackState(a);
			stateOne.Push(s1,b);
			stateOne.Push(s2,c);
			stateOne.Push(s3,d);
			stateOne.Push(s2,c);

			StackState stateTwo = new StackState(a);
			stateTwo.Push(s1,b);
			stateTwo.Push(s2,c);
			Assert.AreEqual(stateTwo,stateOne.LookupServiceNameTwice(s2));
			Assert.IsTrue(stateOne.LookupServiceNameTwice(s3).IsEmpty);
		}

		[Test] public void ChangeTopState(){
			StackState stateOne = new StackState(a);
			StackState stateTwo = new StackState(b);
			stateOne.ChangeTopState(b);
			Assert.AreEqual(stateTwo,stateOne);
			stateTwo.Push(s1,a);
			stateTwo.Push(s2,c);
			stateOne.Push(s1,a);
			stateOne.Push(s2,d);
			stateOne.ChangeTopState(c);
			Assert.AreEqual(stateTwo,stateOne);
		}
	}
}
