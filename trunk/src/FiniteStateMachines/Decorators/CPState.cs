using System;

namespace FiniteStateMachines.Decorators {
	/// <summary>
	/// Zusammenfassung für CPState.
	/// </summary>
	public class CPState : State {
		protected State one;
		protected State two;
		protected String CPname;
		protected State state;
		

		/// <summary>
		/// Creates an empty CPState
		/// </summary>
		public CPState() {
		}

		public CPState(CPState state) {
			
			this.one = state.one;
			this.two = state.two;
			this.CPname = state.CPname;
			this.state = state.state;
		}
		/// <summary>
		/// Creates a CPState
		/// </summary>
		/// <param name="one">A State</param>
		/// <param name="two">Another State, together with one a CPState can be 
		/// created</param>
		public CPState(State one, State two) {
			this.one = one;
			this.two = two;
			this.state = new State(this.getName(),this.IsStartState,this.IsFinalState);
		}
		/// <summary>
		/// returns a 'normal' FSMState, witch can be used in all FSMs
		/// </summary>
		/// <returns>The normal FSM state</returns>
		public State getState() {
			return this.state;
		}
		/// <summary>
		/// Checks if the state is a Startstate
		/// </summary>
		/// <returns>true if is a StartState, false if not </returns>
		public override bool IsStartState {
			get {
				if(this.one.IsStartState == this.two.IsStartState)
					return this.one.IsStartState;
				return false;
			}
		}

		/// <summary>
		/// Checks if the state is a finalstate
		/// </summary>
		/// <returns>true if it is a finalstate, false if not</returns>
		public override bool IsFinalState {
			get {
				if(this.one.IsFinalState == this.two.IsFinalState)
					return this.one.IsFinalState;
				return false;
			}
		}

		/// <summary>
		/// returns the name of a state in a string
		/// </summary>
		/// <returns>the name of the state</returns>
		public override string getName() {
			return this.one.getName()+"-X-"+this.two.getName();
		}

		public State oneState {
			get {return this.one;}
		}
		public State twoState {
			get {return this.two;}
		}
		public override bool Equals(object obj) {
			CPState state;
			
			if (obj is CPState) { 
				state = (CPState)obj;
				if(this.getName() == state.getName()) {
					if(this.IsStartState == state.IsStartState)
						if(this.IsFinalState == state.IsFinalState)
							if(this.oneState == state.twoState)
								if(this.twoState == state.twoState)
									if(this.state == state.state)
										return true;
				}
			}
			return false;
		}
		public static bool operator == (CPState one, CPState two) {
			return one.Equals(two);
		}
		public static bool operator !=(CPState one, CPState two) {
			return !one.Equals(two);
		}
		public override int GetHashCode() {
			return getName().GetHashCode();
		}
	}
}
