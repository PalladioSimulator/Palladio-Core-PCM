using System;
using FSM;
using System.Collections;

namespace FSM {
	/// <summary>
	///A FSM simulating a conjunction of several FSMs
	/// </summary>
	public class StackFSM : Getters {

		Getters providesFSM;
		Hashtable serviceEffectSpecifications;



		/// <summary>
		/// Returns the finalstate of a FSM.
		/// </summary>
		/// <returns>The finalstate of a FSM.</returns>
		public Set getFinalStates() {
			Set finalStates = new Set();
			for (IEnumerator e = providesFSM.getFinalStates().GetEnumerator(); e.MoveNext();){
				finalStates.Add(new StackState((State)e.Current));
			}
			return finalStates;
		}

		/// <summary>
		/// Returns the startstate of a FSM.
		/// </summary>
		/// <returns>The stratstate of a FSM.</returns>
		public State getStartState() {
			return new StackState(providesFSM.getStartState());
		}

		public Set getInputAl() {
			Set resultSet = new Set();
			for (IDictionaryEnumerator e = serviceEffectSpecifications.GetEnumerator(); e.MoveNext();){
				for (IEnumerator f = ((Getters)e.Value).getInputAl().GetEnumerator(); e.MoveNext();){
					resultSet.Add(f.Current);
				}
			}
			for (IEnumerator e = providesFSM.getInputAl().GetEnumerator(); e.MoveNext();){
				resultSet.Add(e.Current);
			}
			resultSet.Add(Input.INPUT_RETURN);
			resultSet.Add(Input.INPUT_RECURSION);

			return resultSet;
		}

		/// <summary>
		/// displays alls Transitions on the console.
		/// </summary>
		public string transitionsToString() {
			// TODO Implement Method
			return null;
		}


		/// <summary>
		/// Returns the next State of FSM with a given Input.
		/// </summary>
		/// <returns>The next possible State.</returns>
		public State getNextState(State fromState, Input input) {
			if (fromState is StackState) {
				StackState state = (StackState)fromState;
				if (serviceEffectSpecifications.ContainsKey(state.PeekService())){
					Getters topService = (Getters)serviceEffectSpecifications[state.PeekService()];
					if (topService.getInputAl().Contains(input)){
					} else if (providesFSM.getInputAl().Contains(input)) {
					} else if (input == Input.INPUT_RETURN){
					} else if (input == Input.INPUT_RECURSION) {
					}
				} else {
					// throw exception: service not found
				}
			} else {
				// throw exception: invalid state
			}
			return null;
		}

		/// <summary>
		/// Returns the next Transition from a State with a given Input
		/// </summary>
		/// <returns>The next reachable Transition.</returns>
		public Transition getTransition(State fromState, Input inChar) {
			// TODO Implement Method
			return null;
		}

		/// <summary>
		/// Returns all Transitions from a given State.
		/// </summary>
		/// <returns>A Hashtable witch contatins all Transtions from the given State.</returns>
		public Hashtable getTransitionMap(State state) {
			// TODO Implement Method
			return null;
		}

		/// <summary>
		/// Returns all Transitions of the FSM in Transition Array.
		/// </summary>
		/// <returns>All Transitions of the FSM in a Array of Transitions.</returns>
		public Transition[] getTransitions() {
			// TODO Implement Method
			return null;
		}

	
	}
}