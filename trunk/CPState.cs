using System;

namespace FSM
{
	/// <summary>
	/// Zusammenfassung für CPState.
	/// </summary>
	public class CPState : State
	{
		protected State one;
		protected State two;
		protected String CPname;
		protected State state;
		

		/// <summary>
		/// Creates an empty CPState
		/// </summary>
		public CPState()
		{
		}
		/// <summary>
		/// Creates a CPState
		/// </summary>
		/// <param name="one">A State</param>
		/// <param name="two">Another State, together with one a CPState can be 
		/// created</param>
		public CPState(State one, State two)
		{
			this.one = one;
			this.two = two;
			this.state = new State(this.getName(),this.getStart(),this.getFinal());
		}
		/// <summary>
		/// returns a 'normal' FSMState, witch can be used in all FSMs
		/// </summary>
		/// <returns>The normal FSM state</returns>
		public State getState()
		{
			return this.state;
		}
		/// <summary>
		/// Checks if the state is a Startstate
		/// </summary>
		/// <returns>true if is a StartState, false if not </returns>
		public  bool getStart()
		{
			if(this.one.getStart() == this.two.getStart())
				return this.one.getStart();
			return false;
		}

		/// <summary>
		/// Checks if the state is a finalstate
		/// </summary>
		/// <returns>true if it is a finalstate, false if not</returns>
		public bool getFinal()
		{
			if(this.one.getFinal() == this.two.getFinal())
				return this.one.getFinal();
			return false;
		}

		/// <summary>
		/// returns the name of a state in a string
		/// </summary>
		/// <returns>the name of the state</returns>
		public string getName()
		{
			return this.one.getName()+"-X-"+this.two.getName();
		}
	}
}
