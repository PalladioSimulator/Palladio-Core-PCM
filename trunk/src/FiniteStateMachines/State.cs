using System;
using FSM;

namespace FSM
{

	/// <summary>
	/// Represents the States of a FSM.
	/// 
	/// jh: some methods are 'virtual' now, so they can be overridden
	/// </summary>
	public class State
	{
		protected static string ERROR_STATE_NAME = "ErrorState";

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
			return this.getName();
		}

		/// <summary>
		/// Checks if this instance is startstate.
		/// </summary>
		/// <returns>true, if this instance is a startstate.</returns>
		public virtual bool getStart() {
			return this.startState;
		}
		/// <summary>
		/// Checks if this instance is a finalstate.
		/// </summary>
		/// <returns>true, if thid instance is a finalstate.</returns>
		public virtual bool getFinal() {
			return this.finalState;
		}

		// jh: override the original Equals-Method
		public override bool Equals(object obj) {
			State state;
			// jh: check if the object is an instance of State
			if (obj is State) { 
				state = (State)obj;
				if(this.getName() == state.getName()) {
					if(this.getStart() == state.getStart())
						if(this.getFinal() == state.getFinal())
							return true;
				}
			}
			return false;
		}

		public static bool operator == (State one, State two){
			return one.Equals(two);
		}

		public static bool operator != (State one, State two){
			return !one.Equals(two);
		}


		public virtual string getName() {
			return this.name;
		}
	
		public override int GetHashCode() {
			return getName().GetHashCode();
		}

		public static State CreateErrorState(){
			return new State(ERROR_STATE_NAME,false,false);
		}
	}
}
