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
		/// Default type for all transitions, which have to be created.
		/// </summary>
		private System.Type defaultTransitonType;


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

			DefaultTransitionType = Type.GetType("FiniteStateMachines.Transition");
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
		/// Default type for all transitions, which have to be created.
		/// </summary>
		public System.Type DefaultTransitionType {
			set{ defaultTransitonType = value; }
			get{ return defaultTransitonType; }
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
		public AbstractState GetNextState(AbstractState sourceState, Input anInput) {
			return GetTransition(sourceState,anInput).DestinationState;
		}

		
		/// <summary>
		/// Returns all Transitions from a given state.
		/// </summary>
		/// <returns>A Hashtable witch contatins all transtions from the given State.</returns>
		public Hashtable GetOutgoingTransitions(AbstractState sourceState) {
			// TODO change the key - value reference key = input, value = transition
			Hashtable result = new Hashtable();
			for (IEnumerator e = inputAlphabet.GetEnumerator(); e.MoveNext();){
				result.Add(e.Current,GetTransition(sourceState,(Input)e.Current));
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
		public Transition GetTransition(AbstractState sourceState, Input anInput) {
			Transition result = null;

			if (sourceState is StackState) {
				StackState state = (StackState)sourceState;
				if (anInput is RecursionInput) {
					result = HandleRecursionInput(state,(RecursionInput)anInput);
				} else if (serviceEffectSpecificationTable.ContainsKey(anInput)) {
					result = CallService(state,anInput);
				} else if ((!state.IsEmpty) && (serviceEffectSpecificationTable.ContainsKey(state.PeekServiceName()))){
					IFiniteStateMachine topService = (IFiniteStateMachine)serviceEffectSpecificationTable[state.PeekServiceName()];
					if (topService.InputAlphabet.Contains(anInput)){
						result = GetTransitionInService(topService,state,anInput);
					} else if (anInput == Input.RETURN){
						result = ReturnFromService(state);
					}
				}
			} else if (sourceState == ErrorState) {
				result = CreateTransition(sourceState,anInput,ErrorState);
			} else {
				throw new InvalidStateException("The state '"+sourceState+"' is not a StackState");
			}
			return result;
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
		private Transition GetTransitionInService(IFiniteStateMachine aService, StackState sourceState, Input anInput){
			Transition result = null;
			AbstractState destinationState = ErrorState;
			result = (Transition)aService.GetTransition(sourceState.PeekState(),anInput).Clone();
			if (result.DestinationState != aService.ErrorState){
				destinationState = new StackState(sourceState);
				((StackState)destinationState).ChangeTopState(result.DestinationState);
			}
			result.SetValues(sourceState,anInput,destinationState);
			return result;
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
		private Transition CallService(StackState sourceState, Input serviceName){
			Transition result = null;
			AbstractState destinationState = ErrorState;

			// check for recursion
			if (!sourceState.LookupServiceNameTwice(serviceName).IsEmpty) {
				result = HandleRecursionCall(sourceState,serviceName);
			} else {
				destinationState = new StackState(sourceState);
				IFiniteStateMachine service = (IFiniteStateMachine)serviceEffectSpecificationTable[serviceName];
				((StackState)destinationState).Push(serviceName,service.StartState);
				result = CreateTransition(sourceState,serviceName,destinationState);
			}
			return result;
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
		private Transition HandleRecursionCall(StackState sourceState, Input anInput){
			Transition result = null;
			IFiniteStateMachine service = (IFiniteStateMachine)serviceEffectSpecificationTable[sourceState.PeekServiceName()];
			result = (Transition)service.GetTransition(sourceState.PeekState(),anInput).Clone();
			RecursionInput recInput = new RecursionInput(sourceState.PeekServiceName(),result.DestinationState);
			// TODO check this condition
			if (!inputAlphabet.Contains(recInput)){
				CounterCondition cc = new CounterCondition(anInput,recInput,1);
				inputAlphabet.Add(recInput);
				counterConditionTable.Add(recInput,cc);
			}
			result.SetValues(sourceState,anInput,sourceState.LookupServiceName(anInput));
			return result;
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
		/// <returns>New transition</returns>
		private Transition HandleRecursionInput(StackState sourceState, RecursionInput recInput){
			AbstractState destinationState = ErrorState;
			if( (sourceState.PeekState().IsFinalState) && (sourceState.LookupServiceNameTwice(recInput.Service).IsEmpty)){
				FSM service = (FSM)serviceEffectSpecificationTable[sourceState.PeekServiceName()];
				Set reachableStates = service.GetReachableStates(recInput.State);
				if (reachableStates.Contains(sourceState.PeekState())){
					destinationState = new StackState(sourceState);
					((StackState)destinationState).ChangeTopState(recInput.State);
				}
			}
			return CreateTransition(sourceState,recInput,destinationState);
		}


		/// <summary>
		/// Identifies the next <code>StackState</code> for the input symbol <code>anInput</code>.
		/// 
		/// Checks if <code>Input.RETURN</code> is a valid input and returns to the calling service.
		/// 
		/// pre: the input symbol was <code>Input.RETURN</code>
		/// </summary>
		/// <param name="sourceState">source</param>
		/// <returns>new Transition</returns>
		private Transition ReturnFromService(StackState sourceState){
			Transition result = null;
			StackState destinationState = new StackState(sourceState);
			if (destinationState.PopState().IsFinalState) {
				IFiniteStateMachine service;
				Input calledServiceName = destinationState.PopServiceName();
				if (destinationState.IsEmpty){
					service = providesProtocol;
				}else {
					service = (IFiniteStateMachine)serviceEffectSpecificationTable[destinationState.PeekServiceName()];
				}
				// TODO if transitions with different results should be handled, the object
				// calledServiceName has to be extended by the result of the last transition

				result = (Transition)service.GetTransition(destinationState.PeekState(),calledServiceName).Clone();
				destinationState.ChangeTopState(result.DestinationState);
				result.SetValues(sourceState,Input.RETURN,destinationState);
			} else {
				result.SetValues(sourceState,Input.RETURN,ErrorState);
			}
			return result;
		}



		/// <summary>
		/// Creates a new Transition of the default type.
		/// </summary>
		/// <param name="aSourceState">source</param>
		/// <param name="anInputSymbol">input</param>
		/// <param name="aDestinationState">destination</param>
		/// <returns></returns>
		private Transition CreateTransition(AbstractState aSourceState, Input anInputSymbol, AbstractState aDestinationState){
			System.Type[] types = new Type[3];
			types[0] = Type.GetType("FiniteStateMachines.AbstractState");
			types[1] = Type.GetType("FiniteStateMachines.Input");
			types[2] = Type.GetType("FiniteStateMachines.AbstractState");
			System.Reflection.ConstructorInfo constructorInfo = defaultTransitonType.GetConstructor(types);
			object[] parameters = new object[3];
			parameters[0] = aSourceState;
			parameters[1] = anInputSymbol;
			parameters[2] = aDestinationState;
			return (Transition)constructorInfo.Invoke(parameters);
		}


		
		/// <summary>
		/// Default error state.
		/// </summary>
		public AbstractState ErrorState {
			get { return errorState;}
		}
	}
}