using System;

namespace FiniteStateMachines {

	/// <summary>
	/// Class representing the abstract type of a state.
	/// </summary>
	public abstract class AbstractState {
		
		/// <summary>
		/// Constant for the name of an error state.
		/// </summary>
		private const string ERROR_STATE_NAME = "ErrorState";

		
		/// <summary>
		/// Denotes this state as a start state of the
		/// finite state machine it belongs to.
		/// </summary>
		public abstract bool IsStartState { get; }

		
		/// <summary>
		/// Denotes this state as a final state of the
		/// finite state machine it belongs to.
		/// </summary>
		public abstract bool IsFinalState { get; }

		
		/// <summary>
		/// Contains the name of the State.
		/// </summary>
		public abstract string Name { get; }

		
		/// <summary>
		/// Default implementation of <code ToString()/>.
		/// </summary>
		/// <returns>The name of the State.</returns>
		public override string ToString() {
			return this.Name;
		}

		
		/// <summary>
		/// Default implementation of <code>GetHashCode()</code>. 
		/// Refers to the hashcode of <code>name</code>.
		/// </summary>
		/// <returns>Hashcode of <code>name</code></returns>
		public override int GetHashCode() {
			return Name.GetHashCode();
		}

		
		/// <summary>
		/// Default implementation of <code>Equals</code>.
		/// </summary>
		/// <param name="obj">The other object.</param>
		/// <returns>True, if <code>Name</code>, <code>IsStartState</code> and
		/// <code>IsFinalState</code> are Equal; false otherwise.</returns>
		public override bool Equals(object obj) {
			AbstractState state;
			if (obj is AbstractState) { 
				state = (AbstractState)obj;
				return ((Name == state.Name) && 
						(IsStartState == state.IsStartState) &&
						(IsFinalState == state.IsFinalState));
			}
			return false;
		}

		
		/// <summary>
		/// Creates a new state, which represents the default error state.
		/// </summary>
		/// <returns>Default error state.</returns>
		public static AbstractState CreateErrorState(){
			return new State(ERROR_STATE_NAME,false,false);
		}

		
		/// <summary>
		/// Default comparison of two states based on the 
		/// implementation of <code>Equals</code>.
		/// </summary>
		/// <param name="stateOne"></param>
		/// <param name="stateTwo"></param>
		/// <returns>True, if <code>stateOne.Equals(stateTwo)</code>; false otherwise</returns>
		public static bool operator == (AbstractState stateOne, AbstractState stateTwo){
			return stateOne.Equals(stateTwo);
		}

		
		/// <summary>
		/// Default comparison of two states based on the 
		/// implementation of <code>Equals</code>.
		/// </summary>
		/// <param name="stateOne"></param>
		/// <param name="stateTwo"></param>
		/// <returns>True if _NOT_ <code>stateOne.Equals(stateTwo)</code>; false otherwise.</returns>
		public static bool operator != (AbstractState stateOne, AbstractState stateTwo){
			return !stateOne.Equals(stateTwo);
		}
	}
}