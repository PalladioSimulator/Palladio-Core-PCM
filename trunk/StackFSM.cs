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
		Set inputAlphabet;

		Hashtable counterConditions;

		public StackFSM(Getters aProvidesFSM, Hashtable aServiceEffectSpecificationSet){
			// TODO check for every element of the input alphabet if there exists a corresponding SESP
			providesFSM = aProvidesFSM;
			serviceEffectSpecifications = (Hashtable)aServiceEffectSpecificationSet.Clone();;
			errorState = State.CreateErrorState();
			inputAlphabet = DetermineInputAlphabet();
			counterConditions = new Hashtable();
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


		private Set DetermineInputAlphabet() {
			Set resultSet = new Set();
			for (IDictionaryEnumerator e = serviceEffectSpecifications.GetEnumerator(); e.MoveNext();){
				for (IEnumerator f = ((Getters)e.Value).getInputAl().GetEnumerator(); f.MoveNext();){
					resultSet.Add(f.Current);
				}
			}
			for (IEnumerator e = providesFSM.getInputAl().GetEnumerator(); e.MoveNext();){
				resultSet.Add(e.Current);
			}
			resultSet.Add(Input.RETURN);

			return resultSet;
		}

		public Set getInputAl() {
			return inputAlphabet;
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
				if (input is RecursionInput) {
					resultState = HandleRecursionInput(state,(RecursionInput)input);
				} else if (serviceEffectSpecifications.ContainsKey(input)) {
					resultState = CallService(state,input);
				} else if ((!state.IsEmpty) && (serviceEffectSpecifications.ContainsKey(state.PeekService()))){
					Getters topService = (Getters)serviceEffectSpecifications[state.PeekService()];
					if (topService.getInputAl().Contains(input)){
						resultState = GetNextStateInService(topService,state,input);
					} else if (input == Input.RETURN){
						resultState = ReturnFromService(state);
					}
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
			State toState = getNextState(fromState,inChar);
			return new Transition(fromState,inChar,toState);
		}

		/// <summary>
		/// Returns all Transitions from a given State.
		/// </summary>
		/// <returns>A Hashtable witch contatins all Transtions from the given State.</returns>
		public Hashtable getTransitionMap(State state) {
			Hashtable result = new Hashtable();
			for (IEnumerator e = inputAlphabet.GetEnumerator(); e.MoveNext();){
				result.Add(e.Current,getNextState(state,(Input)e.Current));
			}
			return result;
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
				resultState = HandleRecursionCall(aState,anInput);
			} else {
				resultState = new StackState(aState);
				Getters service = (Getters)serviceEffectSpecifications[anInput];
				((StackState)resultState).Push(anInput,service.getStartState());
			}
			return resultState;
		}

		private State HandleRecursionCall(StackState aState, Input anInput){
			Getters service = (Getters)serviceEffectSpecifications[aState.TopService];
			State nextState = service.getNextState(aState.TopState,anInput);
			RecursionInput recInput = new RecursionInput(aState.TopService,nextState);
			// TODO check this condition
			if (!inputAlphabet.Contains(recInput)){
				CounterCondition cc = new CounterCondition(anInput,recInput,1);
				inputAlphabet.Add(recInput);
				counterConditions.Add(recInput,cc);
			}
			return aState.LookupService(anInput);
		}

		private State HandleRecursionInput(StackState aState, RecursionInput recInput){
			State resultState = ErrorState;
			if( (aState.TopState.getFinal()) && (aState.LookupServiceTwice(recInput.Service).IsEmpty)){
				FSM service = (FSM)serviceEffectSpecifications[aState.TopService];
				Set reachableStates = service.GetReachableStates(recInput.State);
				if (reachableStates.Contains(aState.TopState)){
					resultState = new StackState(aState);
					((StackState)resultState).ChangeTopState(recInput.State);
				}
			}
			return resultState;
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
				// TODO if transitions with different results should be handled, the object
				// calledServiceName has to be extended by the result of the last transition
				State nextState = service.getNextState(resultState.TopState,calledServiceName);
				resultState.ChangeTopState(nextState);
			} else {
				return ErrorState;
			}
			return resultState;
		}
	}
}