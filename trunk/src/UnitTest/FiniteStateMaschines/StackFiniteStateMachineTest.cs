using System;
using System.Collections;
using NUnit.Framework;
using FiniteStateMachines;
using Utils.Collections;

namespace UnitTests.FiniteStateMachines
{
	/// <summary>
	/// Unit test for <code>StackFiniteStateMachine</code>
	/// </summary>
	[TestFixture]
	public class StackFiniteStateMachineTest
	{
		FSM d1, d2, p;
		Input id1,id2, e1,e2,e3;
		AbstractState p1,p2, d11,d12, d21,d22;
		StackFiniteStateMachine sfsm;
		StackState s,t,u,v,w,x,y,z;


		[SetUp] public void Init() {
			p = new FSM();
			p1 = new State("p1",true,false);
			p2 = new State("p2",false,true);
			id1 = new Input("d1");
			id2 = new Input("d2");
			p.setTransition(p1,id2,p1);
			p.setTransition(p1,id1,p2);
			p.setTransition(p2,id2,p2);

			d1 = new FSM();
			d11 = new State("d1_1",true,false);
			d12 = new State("d1_2",false,true);
			e1 = new Input("e1");
			e2 = new Input("e2");
			d1.setTransition(d11,e1,d12);
			d1.setTransition(d12,e2,d11);

			d2 = new FSM();
			d21 = new State("d2_1",true,false);
			d22 = new State("d2_2",false,true);
			e3 = new Input("e3");
			d2.setTransition(d21,e3,d22);

			Hashtable sespSet = new Hashtable();
			sespSet.Add(id1,d1);
			sespSet.Add(id2,d2);
			sfsm = new StackFiniteStateMachine(p,sespSet);

			s = new StackState(p1);
			t = new StackState(p1);
			t.Push(id2,d21);
			u = new StackState(p1);
			u.Push(id2,d22);
			v = new StackState(p1);
			v.Push(id1,d11);
			w = new StackState(p1);
			w.Push(id1,d12);
			x = new StackState(p2);
			y = new StackState(p2);
			y.Push(id2,d21);
			z = new StackState(p2);
			z.Push(id2,d22);
		}

		[Test] public void FinalStates() {
			Assert.IsTrue(sfsm.FinalStates.Contains(new StackState(p2)));
			Assert.IsTrue(sfsm.FinalStates.Count == 1);
			foreach(StackState s in sfsm.FinalStates) {
				Assert.IsTrue(s.IsFinalState);
			}
		}

		[Test] public void StartState () {
			Assert.IsTrue(sfsm.StartState.IsStartState);
			Assert.AreEqual(new StackState(p1),sfsm.StartState);
		}

		[Test] public void InputAlphabet () {
			Assert.IsTrue(sfsm.InputAlphabet.Count == 6); // e1,e2,e3,id1,id2,return
			Assert.IsTrue(sfsm.InputAlphabet.Contains(e1));
			Assert.IsTrue(sfsm.InputAlphabet.Contains(e2));
			Assert.IsTrue(sfsm.InputAlphabet.Contains(e3));
			Assert.IsTrue(sfsm.InputAlphabet.Contains(id1));
			Assert.IsTrue(sfsm.InputAlphabet.Contains(id2));
			Assert.IsTrue(sfsm.InputAlphabet.Contains(Input.RETURN));
		}

		[Test] public void ErrorState() {
			Assert.AreEqual(StackState.CreateErrorState(),sfsm.ErrorState);
		}

		[Test] public void GetTransition() {
			// Trace FSM p.123
			Assert.AreEqual(new Transition(s,e1,sfsm.ErrorState),sfsm.GetTransition(s,e1));
			Assert.AreEqual(new Transition(s,e2,sfsm.ErrorState),sfsm.GetTransition(s,e2));
			Assert.AreEqual(new Transition(s,e3,sfsm.ErrorState),sfsm.GetTransition(s,e3));
			Assert.AreEqual(new Transition(s,id1,v),sfsm.GetTransition(s,id1));
			Assert.AreEqual(new Transition(s,id2,t),sfsm.GetTransition(s,id2));
			Assert.AreEqual(new Transition(s,Input.RETURN,sfsm.ErrorState),sfsm.GetTransition(s,Input.RETURN));

			Assert.AreEqual(new Transition(t,e1,sfsm.ErrorState),sfsm.GetTransition(t,e1));
			Assert.AreEqual(new Transition(t,e2,sfsm.ErrorState),sfsm.GetTransition(t,e2));
			Assert.AreEqual(new Transition(t,e3,u),sfsm.GetTransition(t,e3));
			Assert.AreEqual(new Transition(t,id1,sfsm.ErrorState),sfsm.GetTransition(t,id1));
			Assert.AreEqual(new Transition(t,id2,sfsm.ErrorState),sfsm.GetTransition(t,id2));
			Assert.AreEqual(new Transition(t,Input.RETURN,sfsm.ErrorState),sfsm.GetTransition(t,Input.RETURN));

			Assert.AreEqual(new Transition(u,e1,sfsm.ErrorState),sfsm.GetTransition(u,e1));
			Assert.AreEqual(new Transition(u,e2,sfsm.ErrorState),sfsm.GetTransition(u,e2));
			Assert.AreEqual(new Transition(u,e3,sfsm.ErrorState),sfsm.GetTransition(u,e3));
			Assert.AreEqual(new Transition(u,id1,sfsm.ErrorState),sfsm.GetTransition(u,id1));
			Assert.AreEqual(new Transition(u,id2,sfsm.ErrorState),sfsm.GetTransition(u,id2));
			Assert.AreEqual(new Transition(u,Input.RETURN,s),sfsm.GetTransition(u,Input.RETURN));

			Assert.AreEqual(new Transition(v,id1,sfsm.ErrorState),sfsm.GetTransition(v,id1));
			Assert.AreEqual(new Transition(v,id2,sfsm.ErrorState),sfsm.GetTransition(v,id2));
			Assert.AreEqual(new Transition(v,e1,w),sfsm.GetTransition(v,e1));
			Assert.AreEqual(new Transition(v,e2,sfsm.ErrorState),sfsm.GetTransition(v,e2));
			Assert.AreEqual(new Transition(v,e3,sfsm.ErrorState),sfsm.GetTransition(v,e3));
			Assert.AreEqual(new Transition(v,Input.RETURN,sfsm.ErrorState),sfsm.GetTransition(v,Input.RETURN));

			Assert.AreEqual(new Transition(w,id1,sfsm.ErrorState),sfsm.GetTransition(w,id1));
			Assert.AreEqual(new Transition(w,id2,sfsm.ErrorState),sfsm.GetTransition(w,id2));
			Assert.AreEqual(new Transition(w,e1,sfsm.ErrorState),sfsm.GetTransition(w,e1));
			Assert.AreEqual(new Transition(w,e2,v),sfsm.GetTransition(w,e2));
			Assert.AreEqual(new Transition(w,e3,sfsm.ErrorState),sfsm.GetTransition(w,e3));
			Assert.AreEqual(new Transition(w,Input.RETURN,x),sfsm.GetTransition(w,Input.RETURN));

			Assert.AreEqual(new Transition(x,id1,sfsm.ErrorState),sfsm.GetTransition(x,id1));
			Assert.AreEqual(new Transition(x,id2,y),sfsm.GetTransition(x,id2));
			Assert.AreEqual(new Transition(x,e1,sfsm.ErrorState),sfsm.GetTransition(x,e1));
			Assert.AreEqual(new Transition(x,e2,sfsm.ErrorState),sfsm.GetTransition(x,e2));
			Assert.AreEqual(new Transition(x,e3,sfsm.ErrorState),sfsm.GetTransition(x,e3));
			Assert.AreEqual(new Transition(x,Input.RETURN,sfsm.ErrorState),sfsm.GetTransition(x,Input.RETURN));

			Assert.AreEqual(new Transition(y,id1,sfsm.ErrorState),sfsm.GetTransition(y,id1));
			Assert.AreEqual(new Transition(y,id2,sfsm.ErrorState),sfsm.GetTransition(y,id2));
			Assert.AreEqual(new Transition(y,e1,sfsm.ErrorState),sfsm.GetTransition(y,e1));
			Assert.AreEqual(new Transition(y,e2,sfsm.ErrorState),sfsm.GetTransition(y,e2));
			Assert.AreEqual(new Transition(y,e3,z),sfsm.GetTransition(y,e3));
			Assert.AreEqual(new Transition(y,Input.RETURN,sfsm.ErrorState),sfsm.GetTransition(y,Input.RETURN));

			Assert.AreEqual(new Transition(z,id1,sfsm.ErrorState),sfsm.GetTransition(z,id1));
			Assert.AreEqual(new Transition(z,id2,sfsm.ErrorState),sfsm.GetTransition(z,id2));
			Assert.AreEqual(new Transition(z,e1,sfsm.ErrorState),sfsm.GetTransition(z,e1));
			Assert.AreEqual(new Transition(z,e2,sfsm.ErrorState),sfsm.GetTransition(z,e2));
			Assert.AreEqual(new Transition(z,e3,sfsm.ErrorState),sfsm.GetTransition(z,e3));
			Assert.AreEqual(new Transition(z,Input.RETURN,x),sfsm.GetTransition(z,Input.RETURN));
		}

		[Test] public void GetOutgoingTransitions() {
			Set outgoing = sfsm.GetOutgoingTransitions(s);
			Assert.IsTrue(outgoing.Contains(new Transition(s,id1,t)));
		}

		public static void Main() {
		}
	}
}
