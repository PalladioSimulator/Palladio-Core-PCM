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
		State errorState;

		
		public StackFSM(Getters aProvidesFSM, Hashtable aServiceEffectSpecificationSet){
			// TODO check for every element of the input alphabet if there exists a corresponding SESP
			providesFSM = aProvidesFSM;
			serviceEffectSpecifications = new Hashtable(aServiceEffectSpecificationSet);
			errorState = State.CreateErrorState();
		}

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
			State resultState = ErrorState;

			if (fromState is StackState) {
				StackState state = (StackState)fromState;
				if ((!state.IsEmpty) && (serviceEffectSpecifications.ContainsKey(state.PeekService()))){
					Getters topService = (Getters)serviceEffectSpecifications[state.PeekService()];
					if (topService.getInputAl().Contains(input)){
						resultState = GetNextStateInService(topService,state,input);
					} else if (input == Input.INPUT_RETURN){
						resultState = ReturnFromService(state);
					}
				} else if (serviceEffectSpecifications.ContainsKey(input)) {
					resultState = CallService(state,input);
				} else if (input == Input.INPUT_RECURSION) {
				}
			} else if (fromState == ErrorState) {
				// stay in ErrorState; nothing to do
			} else {
				throw new InvalidStateException("The state '"+fromState+"' is not a StackState");
			}
			return resultState;
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

		public State ErrorState {
			get {
				return errorState;
			}
		}

		private State GetNextStateInService(Getters aService, StackState aState, Input anInput){
			State resultState = ErrorState;
			State nextState = aService.getNextState(aState.PeekState(),anInput);
			if (nextState != aService.ErrorState){
				resultState = new StackState(aState);
				((StackState)resultState).ChangeTopState(nextState);
			}
			return resultState;
		}
	
		private State CallService(StackState aState, Input anInput){
			State resultState = ErrorState;

			// check for recursion
			if (!aState.LookupServiceTwice(anInput).IsEmpty) {
				resultState = HandleRecursion(aState,anInput);
			} else {
				resultState = new StackState(aState);
				Getters service = (Getters)serviceEffectSpecifications[anInput];
				((StackState)resultState).Push(anInput,service.getStartState());
			}
			return resultState;
		}

		private State HandleRecursion(StackState aState, Input anInput){
			return ErrorState;
		}

		private State ReturnFromService(StackState aState){
			StackState resultState = new StackState(aState);
			if (resultState.PopState().getFinal()) {
				Getters service;
				Input calledServiceName = resultState.PopService();
				if (resultState.IsEmpty){
					service = providesFSM;
				}else {
					service = (Getters)serviceEffectSpecifications[resultState.TopService];
				}
				// TODO if transitions with different results should be handled, the calledServiceName
				// has to be extended by the result of the last transition
				State nextState = service.getNextState(resultState.TopState,calledServiceName);
				resultState.ChangeTopState(nextState);
			} else {
				return ErrorState;
			}
			return resultState;
		}
	}
}