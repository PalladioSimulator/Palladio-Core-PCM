using System;
using System.Collections;

using FiniteStateMachines.Decorators;

using Utils.Collections;

namespace FiniteStateMachines {
	
	/// <summary>
	///	This class represents a final state machine, which simulates a conjunction of several 
	///	others FSMs. The <code>providesProtocol</code> is the top FSM, which invokes all others.
	///	The <code>serviceEffectSpecificationTable</code> maps each input symbol of the 
	///	<code>providesProtocol</code> onto another FSM.
	/// </summary>
	public class StackFiniteStateMachine : IFiniteStateMachine {

		/// <summary>
		/// Protocol specifing the provides interface.
		/// </summary>
		private IFiniteStateMachine providesProtocol;

		/// <summary>
		/// Mapping of a set of input symbols onto a set of FSMs.
		/// </summary>
		private Hashtable serviceEffectSpecificationTable;

		/// <summary>
		/// Default error state.
		/// </summary>
		private AbstractState errorState;

		/// <summary>
		/// The complete input alphabet of this FSM.
		/// </summary>
		private Set inputAlphabet;

		/// <summary>
		/// The final states of this FSM.
		/// </summary>
		private Set finalStates;

		/// <summary>
		/// A set of counter conditions. These conditions are not checked!
		/// </summary>
		private Hashtable counterConditionTable;


		/// <summary>
		/// Default constructor. Invisible to the public.
		/// </summary>
		private StackFiniteStateMachine() {
		}


		/// <summary>
		/// Standard constructor. Creates a new <code>StackFiniteStateMachine</code>.
		/// </summary>
		/// <param name="aProvidesProtocol"></param>
		/// <param name="aServiceEffectSpecificationTable"></param>
		public StackFiniteStateMachine(IFiniteStateMachine aProvidesProtocol, Hashtable aServiceEffectSpecificationTable){
			foreach (Input serviceName in aProvidesProtocol.InputAlphabet) {
				if(!aServiceEffectSpecificationTable.Contains(serviceName)) {
					throw new Exception("Can not resolve all servicenames!");
				}
			}

			providesProtocol = aProvidesProtocol;
			serviceEffectSpecificationTable = (Hashtable)aServiceEffectSpecificationTable.Clone();
			errorState = AbstractState.CreateErrorState();
			counterConditionTable = new Hashtable();

			inputAlphabet = DetermineInputAlphabet();
			finalStates = DetermineFinalStates();
		}


		/// <summary>
		/// Determins the complete input alphabet.
		/// </summary>
		/// <returns></returns>
		private Set DetermineInputAlphabet() {
			Set resultSet = new Set();
			foreach (DictionaryEntry entry in serviceEffectSpecificationTable) {
				foreach (Input input in ((IFiniteStateMachine)entry.Value).InputAlphabet) {
					resultSet.Add(input);
				}
			}
			foreach (Input input in providesProtocol.InputAlphabet) {
				resultSet.Add(input);
			}
			resultSet.Add(Input.RETURN);

			return resultSet;
		}


		/// <summary>
		/// Determins all final states of the <code>StackFiniteStateMachine</code>.
		/// </summary>
		/// <returns></returns>
		private Set DetermineFinalStates(){
			Set resultStates = new Set();
			foreach (AbstractState state in providesProtocol.FinalStates){
				resultStates.Add(new StackState(state));
			}
			return resultStates;
		}

		
		/// <summary>
		/// Final states of the FSM.
		/// </summary>
		public Set FinalStates {
			get { return finalStates; }
		}


		/// <summary>
		/// Start state of the FSM.
		/// </summary>
		public AbstractState StartState {
			get {return new StackState(providesProtocol.StartState);}
		}


		/// <summary>
		/// Input alphabet of the FSM.
		/// </summary>
		public Set InputAlphabet {
			get { return inputAlphabet; }
		}


		/// <summary>
		/// Returns the next transition from the source state with a given input.
		/// </summary>
		/// <returns>The next reachable transition.</returns>
		public Transition GetTransition(AbstractState sourceState, Input anInput) {
			//TODO preserve the type of the transition
			AbstractState destinationState = GetNextState(sourceState,anInput);
			return new Transition(sourceState,anInput,destinationState);
		}

		
		/// <summary>
		/// Returns all Transitions from a given state.
		/// </summary>
		/// <returns>A Hashtable witch contatins all transtions from the given State.</returns>
		public Hashtable GetOutgoingTransitions(AbstractState sourceState) {
			// TODO change the key - value reference key = input, value = transition
			Hashtable result = new Hashtable();
			for (IEnumerator e = inputAlphabet.GetEnumerator(); e.MoveNext();){
				result.Add(e.Current,GetNextState(sourceState,(Input)e.Current));
			}
			return result;
		}

		
		/// <summary>
		/// Returns all Transitions of the FSM in Transition Array.
		/// </summary>
		/// <returns>All Transitions of the FSM in a Array of Transitions.</returns>
		public Transition[] GetTransitions() {
			// TODO remove from the interface?
			return null;
		}


		/// <summary>
		/// Identifies the next <code>StackState</code> for the input symbol <code>anInput</code>.
		/// </summary>
		/// <returns>The next possible State.</returns>
		public AbstractState GetNextState(AbstractState sourceState, Input anInput) {
			AbstractState destinationState = ErrorState;

			if (sourceState is StackState) {
				StackState state = (StackState)sourceState;
				if (anInput is RecursionInput) {
					destinationState = HandleRecursionInput(state,(RecursionInput)anInput);
				} else if (serviceEffectSpecificationTable.ContainsKey(anInput)) {
					destinationState = CallService(state,anInput);
				} else if ((!state.IsEmpty) && (serviceEffectSpecificationTable.ContainsKey(state.PeekServiceName()))){
					IFiniteStateMachine topService = (IFiniteStateMachine)serviceEffectSpecificationTable[state.PeekServiceName()];
					if (topService.InputAlphabet.Contains(anInput)){
						destinationState = GetNextStateInService(topService,state,anInput);
					} else if (anInput == Input.RETURN){
						destinationState = ReturnFromService(state);
					}
				}
			} else if (sourceState == ErrorState) {
				// stay in ErrorState; nothing to do
			} else {
				throw new InvalidStateException("The state '"+sourceState+"' is not a StackState");
			}
			return destinationState;
		}


		/// <summary>
		/// Identifies the next <code>StackState</code> for the input symbol <code>anInput</code>.
		/// 
		/// Determins the new <code>StackState</code> by simulating a transition in 
		/// <code>aService</code> and updating the top state in <code>aState</code>.
		/// 
		/// pre: <code>aService</code> is the service corresponding to <code>aState.PeekService()</code>
		///		 <code>aState.IsEmpty == false</code>
		/// </summary>
		/// <param name="aService">FSM corresponding to <code>aState.PeekService()</code></param>
		/// <param name="aState"><code>StackState</code> for which the transition must be simulated</param>
		/// <param name="anInput">The input symbol for the transition</param>
		/// <returns>A new <code>StackState</code>, if the transition was allowed in <code>aService</code>, 
		/// the error state otherwise</returns>
		private AbstractState GetNextStateInService(IFiniteStateMachine aService, StackState aState, Input anInput){
			AbstractState resultState = ErrorState;
			AbstractState nextState = aService.GetNextState(aState.PeekState(),anInput);
			if (nextState != aService.ErrorState){
				resultState = new StackState(aState);
				((StackState)resultState).ChangeTopState(nextState);
			}
			return resultState;
		}
	

		/// <summary>
		/// Identifies the next <code>StackState</code> for the input symbol <code>anInput</code>.
		/// 
		/// Pushes the name of the called service (= <code>anInput</code>) and the start state of
		/// the service on the stack.
		/// 
		/// pre: <code>serviceEffectSpecificationTable</code> contains <code>anInput</code>
		///		 = the service effect specification of the service <code>anInput</code> exists
		/// </summary>
		/// <param name="aState"><code>StackState</code> for which the transition must be simulated</param>
		/// <param name="anInput">called service</param>
		/// <returns>A new <code>Stackstate</code></returns>
		private AbstractState CallService(StackState aState, Input anInput){
			AbstractState resultState = ErrorState;

			// check for recursion
			if (!aState.LookupServiceNameTwice(anInput).IsEmpty) {
				resultState = HandleRecursionCall(aState,anInput);
			} else {
				resultState = new StackState(aState);
				IFiniteStateMachine service = (IFiniteStateMachine)serviceEffectSpecificationTable[anInput];
				((StackState)resultState).Push(anInput,service.StartState);
			}
			return resultState;
		}


		/// <summary>
		/// Identifies the next <code>StackState</code> for the input symbol <code>anInput</code>.
		/// 
		/// Creates a "cycle" in the FSM represinting the recursion and adds a new <code>RecursionInput</code> 
		/// and <code>CounterCondition</code> object.
		/// 
		/// pre: a recursion was detected
		/// </summary>
		/// <param name="aState"><code>StackState for which the recursion was detected</code></param>
		/// <param name="anInput">Recursive symbol</param>
		/// <returns>A <code>StackState</code> representing a loop back to the start 
		/// of the recursion</returns>
		private AbstractState HandleRecursionCall(StackState aState, Input anInput){
			IFiniteStateMachine service = (IFiniteStateMachine)serviceEffectSpecificationTable[aState.PeekServiceName()];
			AbstractState nextState = service.GetNextState(aState.PeekState(),anInput);
			RecursionInput recInput = new RecursionInput(aState.PeekServiceName(),nextState);
			// TODO check this condition
			if (!inputAlphabet.Contains(recInput)){
				CounterCondition cc = new CounterCondition(anInput,recInput,1);
				inputAlphabet.Add(recInput);
				counterConditionTable.Add(recInput,cc);
			}
			return aState.LookupServiceName(anInput);
		}


		/// <summary>
		/// Identifies the next <code>StackState</code> for the input symbol <code>anInput</code>.
		/// 
		/// Check if the recursion input is allowed and determin the destination of the transition.
		/// 
		/// pre: the current input symbol is a <code>RecursionInput</code>
		/// </summary>
		/// <param name="aState">Source state</param>
		/// <param name="recInput">Recursion input</param>
		/// <returns><code>StackState</code></returns>
		private AbstractState HandleRecursionInput(StackState aState, RecursionInput recInput){
			AbstractState resultState = ErrorState;
			if( (aState.PeekState().IsFinalState) && (aState.LookupServiceNameTwice(recInput.Service).IsEmpty)){
				FSM service = (FSM)serviceEffectSpecificationTable[aState.PeekServiceName()];
				Set reachableStates = service.GetReachableStates(recInput.State);
				if (reachableStates.Contains(aState.PeekState())){
					resultState = new StackState(aState);
					((StackState)resultState).ChangeTopState(recInput.State);
				}
			}
			return resultState;
		}


		/// <summary>
		/// Identifies the next <code>StackState</code> for the input symbol <code>anInput</code>.
		/// 
		/// Checks if <code>Input.RETURN</code> is a valid input and returns to the calling service.
		/// 
		/// pre: the input symbol was <code>Input.RETURN</code>
		/// </summary>
		/// <param name="aState"></param>
		/// <returns></returns>
		private AbstractState ReturnFromService(StackState aState){
			StackState resultState = new StackState(aState);
			if (resultState.PopState().IsFinalState) {
				IFiniteStateMachine service;
				Input calledServiceName = resultState.PopServiceName();
				if (resultState.IsEmpty){
					service = providesProtocol;
				}else {
					service = (IFiniteStateMachine)serviceEffectSpecificationTable[resultState.PeekServiceName()];
				}
				// TODO if transitions with different results should be handled, the object
				// calledServiceName has to be extended by the result of the last transition
				AbstractState nextState = service.GetNextState(resultState.PeekState(),calledServiceName);
				resultState.ChangeTopState(nextState);
			} else {
				return ErrorState;
			}
			return resultState;
		}

		
		/// <summary>
		/// Default error state.
		/// </summary>
		public AbstractState ErrorState {
			get { return errorState;}
		}
	}
}