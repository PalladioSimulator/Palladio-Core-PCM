using System;

namespace FSM
{

	/// <summary>
	/// Represents the States of a FSM.
	/// </summary>f
	public class State
	{
		protected string name;
		protected bool startState; 
		protected bool finalState;
		//protected int _hashcode;
		
		public State()
		{
		}
		/// <summary>
		/// </summary>
		/// <param name="id">String, the name of the state.</param>
		/// <param name="start">bool true, if this state is a startstate.</param>
		/// <param name="final">bool true, if this state is a finalstate</param>
		public State(string id, bool start, bool final)
		{
			this.name = id;
			this.startState = start;
			this.finalState = final;
		}
		/// <summary>
		/// The copy construktor.
		/// </summary>
		/// <param name="s"></param>
		public State(State s)
		{
			this.name = s.name;
			this.startState = s.startState;
			this.finalState = s.finalState;

		}

		/// <summary>
		/// Returns the object as a string.
		/// </summary>
		/// <returns>Returns this instance of State as a string.</returns>
		override public string ToString()
		{
			return this.name;
		}

		/// <summary>
		/// Checks if this instance is startstate.
		/// </summary>
		/// <returns>true, if this instance is a startstate.</returns>
		public bool getStart()
		{
			return this.startState;
		}
		/// <summary>
		/// Checks if this instance is a finalstate.
		/// </summary>
		/// <returns>true, if thid instance is a finalstate.</returns>
		public bool getFinal()
		{
			return this.finalState;
		}

		public bool  Equals(State state)
		{
			if(this.name == state.name)
			{
				if(this.getStart() == state.getStart())
					if(this.getFinal() == state.getFinal())
						return true;
			}
					
		return false;
		}


	}
}
