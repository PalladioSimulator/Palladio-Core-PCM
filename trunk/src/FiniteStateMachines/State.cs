using System;

namespace Palladio.FiniteStateMachines {

	/// <summary>
	/// This class represents a default state type of a finite state machine. 
	/// It is primarily used by the class FiniteTabularMachine.
	/// 
	/// author: JH
	/// </summary>
	public class State : AbstractState {

		/// <summary>
		/// The name or identifier of the state.
		/// </summary>
		private string name;

		/// <summary>
		/// Marks this state as the start state of the corresponding finite
		/// state machine.
		/// </summary>
		private bool isStartState; 
		
		/// <summary>
		/// Marks this state as a final state.
		/// </summary>
		private bool isFinalState;
		

		/// <summary>
		/// The default Constructor is invisible to the public because
		/// it does not produce a valid state.
		/// </summary>
		private State() {
		}


		/// <summary>
		/// Constructs a new state with the identifier aName.
		/// </summary>
		/// <param name="aName">The name of the state.</param>
		/// <param name="isStartState">true, if the state is a start state.</param>
		/// <param name="isFinalState">true, if the state is a final state</param>
		public State(string aName, bool isStartState, bool isFinalState) {
			this.name = aName;
			this.isStartState = isStartState;
			this.isFinalState = isFinalState;
		}


		/// <summary>
		/// Denotes this state as a start state of the
		/// finite state machine it belongs to.
		/// </summary>
		public override bool IsStartState {
			get {return this.isStartState;}
		}


		/// <summary>
		/// Denotes this state as a final state of the
		/// finite state machine it belongs to.
		/// </summary>
		public override bool IsFinalState {
			get {return this.isFinalState;}
		}


		/// <summary>
		/// The name or identifier of this state.
		/// </summary>
		public override string Name {
			get {return this.name;}
		}
	}
}
