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
		public Hashtable GetOutgoingTransitions(AbstractState aSourceState) {
			// TODO change the key - value reference key = input, value = transition
			Hashtable result = new Hashtable();
			foreach (Input input in inputAlphabet){
				result.Add(input,GetTransition(aSourceState,input));
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
		/// Identifies the transition starting at <code>sourceState</code> with the 
		/// input <code>anInput</code>.
		/// </summary>
		/// <returns>The next possible transition</returns>
		public Transition GetTransition(AbstractState sourceState, Input anInput) {
			Transition result = CreateTransition(sourceState,anInput,ErrorState);

			if (sourceState is StackState) {
				StackState state = (StackState)sourceState;
				if (anInput is RecursionInput) {
					result = HandleRecursionInput(state,(RecursionInput)anInput);
				} else if (serviceEffectSpecificationTable.ContainsKey(anInput)) {
					result = CallService(state,anInput);
				} else if ((!state.IsEmpty) && (serviceEffectSpecificationTable.ContainsKey(state.Peek().ServiceName))){
					IFiniteStateMachine topService = (IFiniteStateMachine)serviceEffectSpecificationTable[state.Peek().ServiceName];
					if (topService.InputAlphabet.Contains(anInput)){
						result = GetTransitionInService(topService,state,anInput);
					} else if (anInput == Input.RETURN){
						result = ReturnFromService(state);
					}
				}
			} else if (sourceState == ErrorState) {
				// Stay here, nothing to do
			} else {
				throw new InvalidStateException("The state '"+sourceState+"' is not a StackState");
			}
			return result;
		}


		/// <summary>
		/// Identifies the transition starting at <code>sourceState</code> with the 
		/// input <code>anInput</code>.
		/// 
		/// Determins the destination <code>StackState</code> by simulating a transition in 
		/// <code>aService</code> and updating the top state in <code>aState</code>.
		/// 
		/// pre: <code>aService</code> is the service corresponding to <code>aState.PeekService()</code>
		///		 <code>aState.IsEmpty == false</code>
		/// </summary>
		/// <param name="aService">FSM corresponding to <code>aState.PeekService()</code></param>
		/// <param name="aState"><code>StackState</code> for which the transition must be simulated</param>
		/// <param name="anInput">The input symbol for the transition</param>
		/// <returns>The transition object of <code>aService</code> with altered states</returns>
		private Transition GetTransitionInService(IFiniteStateMachine aService, StackState aSourceState, Input aServiceName){
			Transition result = CreateTransition(aSourceState,aServiceName,ErrorState);
			if(aService.InputAlphabet.Contains(aServiceName)) {
				result = (Transition)aService.GetTransition(aSourceState.Peek().State,aServiceName).Clone();
				if (result.DestinationState != aService.ErrorState){
					AbstractState destinationState = new StackState(aSourceState);
					((StackState)destinationState).ChangeTopState(result.DestinationState);
					result.SetValues(aSourceState,aServiceName,destinationState);
				} else {
					result.SetValues(aSourceState,aServiceName,ErrorState);
				}
			}
			return result;
		}
	

		/// <summary>
		/// Identifies the transition starting at <code>sourceState</code> with the 
		/// input <code>anInput</code>.
		/// 
		/// Pushes the name of the called service (= <code>serviceName</code>) and the start state of
		/// the service on the stack of the <code>sourceState</code> and creates a new transition
		/// from the source to the destination.
		/// 
		/// pre: <code>serviceEffectSpecificationTable</code> contains <code>anInput</code>
		///		 = the service effect specification of the service <code>anInput</code> exists
		/// </summary>
		/// <param name="aState"><code>StackState</code> for which the transition must be simulated</param>
		/// <param name="serviceName">called service</param>
		/// <returns>The transition object of <code>sourceState.Peek().ServiceName</code> with altered states</returns>
		private Transition CallService(StackState sourceState, Input serviceName){
			Transition result = CreateTransition(sourceState,serviceName,ErrorState);

			// check for recursion
			if (!sourceState.LookupServiceNameTwice(serviceName).IsEmpty) {
				result = HandleRecursionCall(sourceState,serviceName);
			} else {
				IFiniteStateMachine topService;
				if (sourceState.IsEmpty) {
					topService = providesProtocol;
				} else {
					topService = (IFiniteStateMachine)serviceEffectSpecificationTable[sourceState.Peek().ServiceName];
				}
				// check if the transition exists in the c
				Transition topTransition = topService.GetTransition(sourceState.Peek().State,serviceName);
				if(topTransition.DestinationState != topService.ErrorState) {
					AbstractState destinationState = new StackState(sourceState);
					IFiniteStateMachine calledService = (IFiniteStateMachine)serviceEffectSpecificationTable[serviceName];
					((StackState)destinationState).Push(serviceName,calledService.StartState);
					result = (Transition)topTransition.Clone();
					result.SetValues(sourceState,serviceName,destinationState);
				}
			}
			return result;
		}


		/// <summary>
		/// Identifies the transition starting at <code>sourceState</code> with the 
		/// input <code>serviceName</code>.
		/// 
		/// Creates a "cycle" in the FSM represinting the recursion. Adds a new <code>RecursionInput</code> 
		/// and <code>CounterCondition</code> object to the FSM.
		/// 
		/// pre: a recursion was detected
		/// </summary>
		/// <param name="aState"><code>StackState for which the recursion was detected</code></param>
		/// <param name="serviceName">Recursive symbol</param>
		/// <returns>The transition object of <code>sourceState.Peek().ServiceName</code> with altered states</returns>
		private Transition HandleRecursionCall(StackState sourceState, Input serviceName){
			Transition result = null;
			IFiniteStateMachine service = (IFiniteStateMachine)serviceEffectSpecificationTable[sourceState.Peek().ServiceName];
			result = (Transition)service.GetTransition(sourceState.Peek().State,serviceName).Clone();
			RecursionInput recInput = new RecursionInput(sourceState.Peek().ServiceName,result.DestinationState);
			// TODO check this condition
			if (!inputAlphabet.Contains(recInput)){
				CounterCondition cc = new CounterCondition(serviceName,recInput,1);
				inputAlphabet.Add(recInput);
				counterConditionTable.Add(recInput,cc);
			}
			result.SetValues(sourceState,serviceName,sourceState.LookupServiceName(serviceName));
			return result;
		}


		/// <summary>
		/// Identifies the transition starting at <code>sourceState</code> with the 
		/// input <code>recInput</code>.
		/// 
		/// Check if the recursion input is allowed and determin the destination of the transition.
		/// 
		/// pre: the current input symbol is a <code>RecursionInput</code>
		/// </summary>
		/// <param name="aState">Source state</param>
		/// <param name="recInput">Recursion input</param>
		/// <returns>A new transition from source to destination</returns>
		private Transition HandleRecursionInput(StackState sourceState, RecursionInput recInput){
			AbstractState destinationState = ErrorState;
			if( (sourceState.Peek().State.IsFinalState) && (sourceState.LookupServiceNameTwice(recInput.Service).IsEmpty)){
				FSM service = (FSM)serviceEffectSpecificationTable[sourceState.Peek().ServiceName];
				Set reachableStates = service.GetReachableStates(recInput.State);
				if (reachableStates.Contains(sourceState.Peek().State)){
					destinationState = new StackState(sourceState);
					((StackState)destinationState).ChangeTopState(recInput.State);
				}
			}
			return CreateTransition(sourceState,recInput,destinationState);
		}


		/// <summary>
		/// Identifies the transition starting at <code>sourceState</code> with the 
		/// input <code>Input.RETURN</code>.
		/// 
		/// Checks if <code>Input.RETURN</code> is a valid input and returns to the calling service.
		/// 
		/// pre: the input symbol was <code>Input.RETURN</code>
		/// </summary>
		/// <param name="sourceState">source</param>
		/// <returns>The transition object of the calling service with altered states</returns>
		private Transition ReturnFromService(StackState sourceState){
			Transition result = CreateTransition(sourceState,Input.RETURN,ErrorState);
			StackState destinationState = new StackState(sourceState);
			Context currentContext = destinationState.Pop();
			if (currentContext.State.IsFinalState) {
				IFiniteStateMachine service;
				Input calledServiceName = currentContext.ServiceName;
				if (destinationState.IsEmpty){
					service = providesProtocol;
				}else {
					service = (IFiniteStateMachine)serviceEffectSpecificationTable[destinationState.Peek().ServiceName];
				}
				// TODO if transitions with different results should be handled, the object
				// calledServiceName has to be extended by the result of the last transition

				result = (Transition)service.GetTransition(destinationState.Peek().State,calledServiceName).Clone();
				destinationState.ChangeTopState(result.DestinationState);
				result.SetValues(sourceState,Input.RETURN,destinationState);
			}
			return result;
		}



		/// <summary>
		/// Creates a new Transition of the default type.
		/// </summary>
		/// <param name="aSourceState">source</param>
		/// <param name="anInputSymbol">input</param>
		/// <param name="aDestinationState">destination</param>
		/// <returns>New transition object</returns>
		private Transition CreateTransition(AbstractState aSourceState, Input anInputSymbol, AbstractState aDestinationState){
			Type[] types = new Type[3];
			types[0] = typeof(AbstractState);
			types[1] = typeof(Input);
			types[2] = typeof(AbstractState);
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