using System;

namespace FiniteStateMachines {

	/// <summary>
	///		Class representing the abstract type of a state.
	///		
	///		author: JH
	/// </summary>
	public abstract class AbstractState {
		
        /// <summary>
		///		Denotes this state as a start state of the
		///		finite state machine it belongs to.
		/// </summary>
		public abstract bool IsStartState { get; }

		
		/// <summary>
		///		Denotes this state as a final state of the
		///		finite state machine it belongs to.
		/// </summary>
		public abstract bool IsFinalState { get; }

		
		/// <summary>
		///		The name of the state.
		/// </summary>
		public abstract string Name { get; }

		
		/// <summary>
		///		Default implementation of ToString().
		/// </summary>
		/// <returns>
		///		The name of the State.
		///	</returns>
		public override string ToString() {
			return this.Name;
		}

		
		/// <summary>
		///		Default implementation of GetHashCode(). 
		///		Refers to the hashcode of name.
		/// </summary>
		/// <returns>
		///		Hashcode of Name
		///	</returns>
		public override int GetHashCode() {
			return Name.GetHashCode();
		}

		
		/// <summary>
		///		Default implementation of Equals.
		/// </summary>
		/// <param name="obj">
		///		The other object.
		///	</param>
		/// <returns>
		///		True, if Name, IsStartState and
		///		IsFinalState are Equal; false otherwise.
		///	</returns>
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
		///		Default comparison of two states based on the 
		///		implementation of Equals.
		/// </summary>
		/// <returns>
		///		True, if stateOne.Equals(stateTwo); false otherwise
		///	</returns>
		public static bool operator == (AbstractState one, AbstractState two){
			try {
				return one.Equals(two);
			} catch( NullReferenceException  ) {
				try {
					return two.Equals(one);
				} catch( NullReferenceException ) {
					return true;
				}
			}
		}

		
		/// <summary>
		///		Default comparison of two states based on the 
		///		implementation of Equals.
		/// </summary>
		/// <returns>
		///		True if _NOT_ stateOne.Equals(stateTwo); false otherwise.
		///	</returns>
		public static bool operator != (AbstractState one, AbstractState two){
			try {
				return !one.Equals(two);
			} catch( NullReferenceException  ) {
				try {
					return !two.Equals(one);
				} catch( NullReferenceException ) {
					return false;
				}
			}
		}
	}
}