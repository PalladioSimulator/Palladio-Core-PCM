using System;
using System.Collections;

namespace FSM
{
	/// <summary>
	/// A test for FSM
	/// </summary>
	public class Test
	{
		public Test()
		{
		}
		public static void Main()
		{
			FSM none = new FSM();
			State alpha = new State("alpha",true,true);	
			StateIterator iter = new StateIterator(none);
			Input wella = new Input("0");
			Transition soap = new Transition(alpha,wella,alpha);
			none.setTransition(soap);
			while(iter.MoveNext())
			{
				Console.WriteLine("FSM.Test.tree1: "+iter.Current.ToString());
					Console.WriteLine("FSM.Test.iter.TransitionIterator: "+iter.getCurrentTransition.ToString());
			}
			FSM easy = new FSM();
			Input z = new Input("z");
			alpha = new State("alpha",true,false);
			State beta = new State("beta", false, true);
			Transition tu = new Transition(alpha, z,beta);
			easy.setTransition(tu);
			
			easy.DisplayOnConsole();
			StateIterator StateIterTest = new StateIterator(easy);
			Console.WriteLine("Testing StateIterator");
			while(StateIterTest.MoveNext())
			{
				Console.WriteLine(StateIterTest.Current.ToString());
				Console.WriteLine("TransitionIterator for easy "+StateIterTest.getCurrentTransition.ToString());
			}

			Console.WriteLine("next FSM:");
			
			FSM tree = new FSM();
			Input q = new Input("q");
			State ceta = new State("ceta",false,true);
			Transition ti = new Transition(alpha,q,ceta);

			tree.setTransition(tu);
			tree.setTransition(ti);

			tree.DisplayOnConsole();
			StateIterTest = new StateIterator(tree);
			while(StateIterTest.MoveNext())
			{
				
				Console.WriteLine("FSM.Test.tree: "+StateIterTest.Current.ToString());
				Console.WriteLine("FSM.Test.tree.getCurrenTransition: "+StateIterTest.getCurrentTransition.ToString());
			}
			
			Console.WriteLine("------------------------------------------------------------");
			FSM tree1 = new FSM();
			State gamma =  new State("gamma",false,true);
			Transition treetr1 = new Transition(beta,z,gamma);
			tree1.setTransition(tu);
			tree1.setTransition(ti);
			tree1.setTransition(treetr1);
			iter = new StateIterator(tree1);
			while(iter.MoveNext())
			{
				Console.WriteLine("FSM.Test.tree1: "+iter.Current.ToString());
				Console.WriteLine("FSM.Test.tree1.TransitionIterator: "+iter.getCurrentTransition.ToString());
			}
			tree1.DisplayOnConsole();


			Console.WriteLine("Another more difficult FSM");

			State s = new State("s",true,false);
			State r = new State("r",false,false);
			State v = new State("v",false,true);
			State g = new State("g",false,false);
			State t = new State("t",false,false);
			State x = new State("x",false,false);
			State u = new State("u",false,false);
			State y = new State("y",false,true);
			
			Input a = new Input("a");
			Input b = new Input("b");
			Input c = new Input("c");
			Input d = new Input("d");

			Transition t2 = new Transition(r,d,v);
			Transition t4 = new Transition(g,d,t);
			Transition t5 = new Transition(g,b,x);
			Transition t1 = new Transition(s,a,r);
			Transition t6 = new Transition(x,c,u);
			Transition t7 = new Transition(x,d,y);
			Transition t8 = new Transition(g,c,u);
			Transition t3 = new Transition(s,c,g);

			FSM fsm = new FSM();

			fsm.setTransition(t6);
			fsm.setTransition(t2);
			fsm.setTransition(t1);
			fsm.setTransition(t4);
			fsm.setTransition(t5);
			fsm.setTransition(t3);
			fsm.setTransition(t7);
			fsm.setTransition(t8);

			StateIterator i = new StateIterator(fsm);
			while(i.MoveNext())
			{
				Console.WriteLine("FSM.Testing.fsm: "+i.Current.ToString());
				Console.WriteLine("FSM.Test.tree1: "+i.getCurrentTransition.ToString());
			}
			fsm.DisplayOnConsole();

			Console.WriteLine("Testing TransitionIterator:");
			TransitionIterator trI1= new TransitionIterator(easy);
			Console.WriteLine("for easy: ");
			while(trI1.MoveNext())
			{
				Console.WriteLine(trI1.Current.ToString());
			}
			trI1= new TransitionIterator(tree);
			Console.WriteLine("for tree: ");
			while(trI1.MoveNext())
				Console.WriteLine(trI1.Current.ToString());

			trI1= new TransitionIterator(tree1);
			Console.WriteLine("for tree1: ");
			while(trI1.MoveNext())
				Console.WriteLine(trI1.Current.ToString());

			trI1= new TransitionIterator(fsm);
			Console.WriteLine("for fsm: ");
			while(trI1.MoveNext())
				Console.WriteLine(trI1.Current.ToString());

			Console.WriteLine("finished");
			Console.Read();
		}
						  
	}
	
}
