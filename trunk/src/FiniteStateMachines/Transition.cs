using System;

namespace FiniteStateMachines {
	/// <summary>
	/// Represents the transitions of the FSM.
	/// 
	/// Important:	Every class which inherits from <code>Transition</code> has to
	///				implement a constructor of the following type:
	///				
	///				XXXTransition(AbstractState, Input, AbstractState)
	/// </summary>
	public class Transition {
		private AbstractState sourceState;
		private Input inputSymbol;
		private AbstractState destinationState;


		/// <summary>
		/// Deafault constructor
		/// Initializes a new instance of the Transition.
		/// <param name="f">State, the source of the Transition.</param>
		/// <param name="i">Input of the Transition.</param>
		/// <param name="t">State, where the Transition leads to.</param>
		public Transition(AbstractState aSourceState, Input anInputSymbol, AbstractState aDestinationState) {
			this.SourceState = aSourceState;
			this.InputSymbol = anInputSymbol;
			this.DestinationState = aDestinationState;
		}


		public Transition() {
		}

		
		/// <summary>
		/// The copy constructor.
		/// </summary>
		/// <param name="t"></param>
		public Transition(Transition newTransition) {
			this.SourceState = newTransition.SourceState;
			this.InputSymbol = newTransition.InputSymbol;
			this.DestinationState = newTransition.DestinationState;
		}


		public AbstractState SourceState {
			get { return sourceState; }
			set { sourceState = value; }
		}


		public AbstractState DestinationState {
			get { return destinationState; }
			set { destinationState = value; }
		}

		
		public Input InputSymbol {
			get { return inputSymbol; }
			set { inputSymbol = value; }
		}


		public void SetValues(AbstractState aSourceState, Input anInputSymbol, AbstractState aDestinationState) {
			this.SourceState = aSourceState;
			this.InputSymbol = anInputSymbol;
			this.DestinationState = aDestinationState;
		}


		/// <summary>
		/// Returns the instance of a Transition as a string.
		/// </summary>
		/// <returns>The Transition as string.</returns>
		override public string ToString() {
			return ("from " +this.SourceState.ToString() + " to " + this.DestinationState.ToString() +" with: " + this.InputSymbol.ToString());
		}
		
		
		/// <summary>
		/// Default implementation.
		/// </summary>
		/// <returns></returns>
		public override int GetHashCode() {
			return ToString().GetHashCode();
		}


		/// <summary>
		/// Default implementation.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public virtual object Clone(){
			return new Transition(this);
		}
	}
}
