using System;
using NUnit.Framework;
using FiniteStateMachines;

namespace UnitTests.FiniteStateMachines
{
	/// <summary>
	/// Unit test for <code>StackState</code>
	/// </summary>
	[TestFixture]
	public class StackStateTest
	{
		AbstractState a,b,c,d;
		Input s1,s2,s3,s4;
		StackState state;

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
			state = new StackState(a);
			Assert.AreSame(a,state.PeekState());
		}


		[Test] public void Equal(){
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

		//[ExpectedException(typeof(StackStateException))]	
		[Test] public void CopyConstructor(){
			state = new StackState(a);
			StackState clone = new StackState(state);
			Assert.AreEqual(state,clone);

			state.Push(s1,b);
			state.Push(s2,c);
			clone = new StackState(state);
			Assert.AreEqual(state,clone);
		}

		[Test] public void IsEmpty() {
			state = new StackState(a);
			Assert.IsTrue(state.IsEmpty);
			state.Push(s1,a);
			Assert.IsFalse(state.IsEmpty);
		}

		[Test] public void Push() {
			state = new StackState(a);
			state.Push(s1,b);
			Assert.AreSame(s1,state.PeekServiceName());
			Assert.AreSame(b,state.PeekState());
		}

		[Test] public void Pop() {
			state = new StackState(a);
			state.Push(s1,b);
			Context con = state.Pop();
			Assert.AreSame(s1,con.ServiceName);
			Assert.AreSame(b,con.State);
			con = state.Pop();
			Assert.AreSame(a,con.State);
			Assert.AreSame(StackState.TOP_SERVICE_NAME,con.ServiceName);
		}

		
//		[ExpectedException(typeof(StackStateException))]	
		[Test] public void PopEmptyServiceName() {
			state = new StackState(a);
			Assert.AreSame(StackState.TOP_SERVICE_NAME,state.Pop().ServiceName);
		}

		[Test] public void PopEmptyState() {
			state = new StackState(a);
			state.Pop();
			Assert.AreSame(a,state.Pop().State);
			Assert.AreSame(a,state.Pop().State);
		}

	}
}
