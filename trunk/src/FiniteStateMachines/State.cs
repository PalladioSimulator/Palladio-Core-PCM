using System;

namespace FiniteStateMachines {

	/// <summary>
	/// Represents the States of a FSM.
	/// </summary>
	public class State : AbstractState {

		private string name;
		private bool isStartState; 
		private bool isFinalState;
		//protected int _hashcode;
		
		private State() {
		}

		/// <summary>
		/// </summary>
		/// <param name="id">String, the name of the state.</param>
		/// <param name="start">bool true, if this state is a startstate.</param>
		/// <param name="final">bool true, if this state is a finalstate</param>
		public State(string id, bool start, bool final) {
			this.name = id;
			this.isStartState = start;
			this.isFinalState = final;
		}

		/// <summary>
		/// The copy construktor.
		/// </summary>
		/// <param name="s"></param>
		public State(State s) {
			this.name = s.name;
			isStartState = s.isStartState;
			this.isFinalState = s.isFinalState;
		}

		/// <summary>
		/// Checks if this instance is startstate.
		/// </summary>
		/// <returns>true, if this instance is a startstate.</returns>
		public override bool IsStartState {
			get {return this.isStartState;}
		}

		/// <summary>
		/// Checks if this instance is a finalstate.
		/// </summary>
		/// <returns>true, if thid instance is a finalstate.</returns>
		public override bool IsFinalState {
			get {return this.isFinalState;}
		}

		public override string Name {
			get {return this.name;}
		}
	}
}
