using System;

namespace FSM
{
	/// <summary>
	/// Represents the transitions of the FSM. 
	/// </summary>
	public class Transition
	{
		public State fromState;
		public  Input input;
		public State toState;
		public int hashcode;

		/// <summary>
		/// Deafault constructor
		///Initializes a new instance of the Transition.
		/// <param name="f">State, the source of the Transition.</param>
		/// <param name="i">Input of the Transition.</param>
		/// <param name="t">State, where the Transition leads to.</param>
		public Transition(State f, Input i, State t)
		{
			this.fromState = f;
			this.input = i;
			this.toState = t;
		}
		public Transition()
		{
		}
		/// <summary>
		/// The copy constructor.
		/// </summary>
		/// <param name="t"></param>
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
		/// <summary>
		/// Returns the instance of a Transition as a string.
		/// </summary>
		/// <returns>The Transition as string.</returns>
		override public string ToString()
		{
			return ("from " +this.fromState.ToString() + " to " + this.toState.ToString() +" with: " + this.input.ToString());
		}
		
	}
}
