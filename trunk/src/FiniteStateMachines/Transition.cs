using System;

namespace FiniteStateMachines {
	/// <summary>
	/// Represents the transitions of the FSM.
	/// 
	/// Important:	Every class which inherits from <code>Transition</code> has to
	///				implement the method <code>Clone()</code> and a constructor 
	///				of the following type:
	///				
	///				XXXTransition(AbstractState, Input, AbstractState)
	///				
	///	author: JH
	/// </summary>
	public class Transition {

		/// <summary>
		/// The source of the transition.
		/// </summary>
		private IState sourceState;

		/// <summary>
		/// The input symbol.
		/// </summary>
		private Input inputSymbol;

		/// <summary>
		/// The destination of the transition.
		/// </summary>
		private IState destinationState;


		/// <summary>
		/// Deafault constructor
		/// Initializes a new instance of the Transition.
		/// <param name="f">State, the source of the Transition.</param>
		/// <param name="i">Input of the Transition.</param>
		/// <param name="t">State, where the Transition leads to.</param>
		public Transition(IState aSourceState, Input anInputSymbol, IState aDestinationState) {
			this.SourceState = aSourceState;
			this.InputSymbol = anInputSymbol;
			this.DestinationState = aDestinationState;
		}


		/// <summary>
		/// Empty Constructor; does nothing. Should be invisible to the public
		/// because it does not produce a valid transition object!
		/// 
		/// Use <code>transition = null</code> instead!
		/// </summary>
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


		/// <summary>
		/// The source of the transition.
		/// </summary>
		public IState SourceState {
			get { return sourceState; }
			set { sourceState = value; }
		}


		/// <summary>
		/// The destination of the transition.
		/// </summary>
		public IState DestinationState {
			get { return destinationState; }
			set { destinationState = value; }
		}

		
		/// <summary>
		/// The input symbol.
		/// </summary>
		public Input InputSymbol {
			get { return inputSymbol; }
			set { inputSymbol = value; }
		}

		
		/// <summary>
		/// Sets the important values of a transition object.
		/// </summary>
		/// <param name="aSourceState">Source</param>
		/// <param name="anInputSymbol">Input symbol</param>
		/// <param name="aDestinationState">Destination</param>
		public void SetValues(IState aSourceState, Input anInputSymbol, IState aDestinationState) {
			this.SourceState = aSourceState;
			this.InputSymbol = anInputSymbol;
			this.DestinationState = aDestinationState;
		}


		/// <summary>
		/// Returns a string representing the instance of a transition.
		/// </summary>
		/// <returns>The Transition as string.</returns>
		override public string ToString() {
			return "( " + SourceState + "\t-  " + InputSymbol + "\t-  " + DestinationState + ")";
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


		/// <summary>
		/// Default implementation for Equals.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public override bool Equals(object obj) {
			if (obj is Transition) {
				Transition trans = (Transition)obj;
				return (DestinationState.Equals(trans.DestinationState) &&
					SourceState.Equals(trans.SourceState) &&
					InputSymbol.Equals(trans.InputSymbol));
			} 
			return false;
		}

	}
}
