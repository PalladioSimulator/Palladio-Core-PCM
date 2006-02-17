using System;

namespace FSM
{
	
	public class Transition
	{
		public State fromState;
		public  Input input;
		public State toState;
		public int hashcode;

		public Transition(State f, Input i, State t)
		{
			this.fromState = f;
			this.input = i;
			this.toState = t;
			this.hashcode = this.GetHashCode();
		}
		public Transition()
		{
			//Console.WriteLine("Leere Transition!");
		}
		public Transition(Transition t)
		{
			this.fromState = t.fromState;
			this.input = t.input;
			this.toState = t.toState;
			this.hashcode = t.hashcode;
		}
		public Transition(int i)
		{
		}

		override public string ToString()
		{
			return ("von " +this.fromState.ToString() + " nach " + this.toState.ToString() +" mit: " + this.input.ToString());
		}
		
	}
}
