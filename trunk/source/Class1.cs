using System;

namespace FSM
{

	public class State
	{
		protected string name;
		protected bool startState, finalState;
		protected int _hashcode;
		
		public State()
		{
		}
		public State(string id, bool start, bool final)
		{
			this.name = id;
			this.startState = start;
			this.finalState = final;
			this._hashcode = this.GetHashCode();
		}
		public State(State s)
		{
			this.name = s.name;
			this.startState = s.startState;
			this.finalState = s.finalState;
			this._hashcode = s._hashcode;
		}
		private int computeHashCode (String s) 
		{
			int i,result = 0;
			for (i=0;i < s.Length;i++) 
			{
				result += s[i] * (i + 1);
			}
			return result % 2047;
		}

		override public string ToString()
		{
			return this.name;
		}

		public bool getStart()
		{
			return this.startState;
		}
		public bool getFinal()
		{
			return this.finalState;
		}

	}
}
