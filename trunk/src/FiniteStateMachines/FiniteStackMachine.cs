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
	public class FiniteStackMachine : IFiniteStateMachine {

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
		private FiniteStackMachine() {
		}


		/// <summary>
		/// Standard constructor. Creates a new <code>StackFiniteStateMachine</code>.
		/// </summary>
		/// <param name="aProvidesProtocol"></param>
		/// <param name="aServiceEffectSpecificationTable"></param>
		public FiniteStackMachine(IFiniteStateMachine aProvidesProtocol, Hashtable aServiceEffectSpecificationTable) {
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
		private Set DetermineFinalStates() {
			Set resultStates = new Set();
			foreach (AbstractState state in providesProtocol.FinalStates) {
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
			return GetNextTransition(sourceState,anInput).DestinationState;
		}

		
		/// <summary>
		/// Returns all Transitions from a given state.
		/// </summary>
		/// <returns>A Hashtable witch contatins all transtions from the given State.</returns>
		public Hashtable GetOutgoingTransitions(AbstractState aSourceState) {
			// TODO change the key - value reference key = input, value = transition
			try {
				Hashtable result = new Hashtable();
				foreach (Input input in inputAlphabet) {
					result.Add(input,GetNextTransition(aSourceState,input));
				}
				return result;
			} catch ( InvalidOperationException ) {
				Hashtable result = new Hashtable();
				foreach (Input input in inputAlphabet) {
					result.Add(input,GetNextTransition(aSourceState,input));
				}
				return result;
			}
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
		/// Identifies the transition starting at <code>aSourceState</code> with the 
		/// input <code>anInput</code>.
		/// </summary>
		/// <returns>The next possible transition</returns>
		public Transition GetNextTransition(AbstractState aSourceState, Input anInput) {
			Transition result = CreateTransition(aSourceState,anInput,ErrorState);

			if (aSourceState is StackState) {
				StackState state = (StackState)aSourceState;
				if (anInput is RecursionInput) {
					result = HandleRecursionInput(state,(RecursionInput)anInput);
				} 
				else if (serviceEffectSpecificationTable.ContainsKey(anInput)) {
					result = CallService(state,anInput);
				} 
				else if ((!state.IsEmpty) && (serviceEffectSpecificationTable.ContainsKey(state.Peek().ServiceName))) {
					IFiniteStateMachine topService = LookUpService(state.Peek().ServiceName);
					if (topService.InputAlphabet.Contains(anInput)) {
						result = GetTransitionInService(topService,state,anInput);
					} 
					else if (anInput == Input.RETURN) {
						result = ReturnFromService(state);
					}
				}
			} 
			else if (aSourceState == ErrorState) {
				// Stay in ErrorState, nothing to do
			} 
			else {
				throw new InvalidStateException("The state '"+aSourceState+"' is not a StackState");
			}
			return result;
		}


		/// <summary>
		/// Identifies the transition starting at <code>aSourceState</code> with the 
		/// input <code>anInput</code>.
		/// 
		/// Determins the destination <code>StackState</code> by simulating a transition in 
		/// <code>aService</code> and updating the top state in <code>aState</code>.
		/// 
		/// pre: - <code>aService</code> is the service corresponding to <code>aSourceState.PeekService()</code>
		///		 - the input alphabet of <code>aService</code> contains <code>anInput</code>
		///		 - <code>aSourceState.IsEmpty == false</code>
		/// </summary>
		/// <param name="aService">FSM corresponding to <code>aState.PeekService()</code></param>
		/// <param name="aSourceState"><code>StackState</code> for which the transition must be simulated</param>
		/// <param name="anInput">The input symbol for the transition</param>
		/// <returns>The transition object of <code>aService</code> with altered states</returns>
		private Transition GetTransitionInService(IFiniteStateMachine aService, StackState aSourceState, Input aServiceName) {
			Transition result = (Transition)aService.GetNextTransition(aSourceState.Peek().State,aServiceName).Clone();
			if (result.DestinationState != aService.ErrorState) {
				AbstractState destinationState = new StackState(aSourceState);
				((StackState)destinationState).ChangeTopState(result.DestinationState);
				result.SetValues(aSourceState,aServiceName,destinationState);
			} else {
				result.SetValues(aSourceState,aServiceName,ErrorState);
			}
			return result;
		}
	

		/// <summary>
		/// Identifies the transition starting at <code>aSourceState</code> with the 
		/// input <code>anInput</code>.
		/// 
		/// Pushes the name of the called service (= <code>aServiceName</code>) and the start state of
		/// the service on the stack of the <code>aSourceState</code> and creates a new transition
		/// from the source to the destination.
		/// 
		/// pre: <code>serviceEffectSpecificationTable</code> contains <code>aServiceName</code>
		///		 = the service effect specification of the service <code>anInput</code> exists
		/// </summary>
		/// <param name="aSourceState"><code>StackState</code> for which the transition must be simulated</param>
		/// <param name="aServiceName">called service</param>
		/// <returns>The transition object of <code>aSourceState.Peek().ServiceName</code> with altered states</returns>
		private Transition CallService(StackState aSourceState, Input aServiceName) {
			Transition result = CreateTransition(aSourceState,aServiceName,ErrorState);
			IFiniteStateMachine topService;

			if (aSourceState.IsEmpty) {
				topService = providesProtocol;
			} else {
				topService = LookUpService(aSourceState.Peek().ServiceName);
			}

			// check if the transition is valid in this context
			Transition topTransition = topService.GetNextTransition(aSourceState.Peek().State,aServiceName);
			if(topTransition.DestinationState != topService.ErrorState) {
				// check for recursion
				if (!aSourceState.LookupServiceNameTwice(aServiceName).IsEmpty) {
					result = HandleRecursionCall(aSourceState,aServiceName);
				} else {
					AbstractState destinationState = new StackState(aSourceState);
					IFiniteStateMachine calledService = LookUpService(aServiceName);
					((StackState)destinationState).Push(aServiceName,calledService.StartState);
					result = (Transition)topTransition.Clone();
					result.SetValues(aSourceState,aServiceName,destinationState);
				}
			}
			return result;
		}


		/// <summary>
		/// Identifies the transition starting at <code>aSourceState</code> with the 
		/// input <code>aServiceName</code>.
		/// 
		/// Creates a "cycle" in the FSM representing the recursion. Adds a new <code>RecursionInput</code> 
		/// and <code>CounterCondition</code> object to the FSM.
		/// 
		/// pre: a recursion was detected
		/// </summary>
		/// <param name="aSourceState"><code>StackState</code> for which the recursion was detected</param>
		/// <param name="aServiceName">Recursive symbol</param>
		/// <returns>The transition object of <code>aSourceState.Peek().ServiceName</code> with altered states</returns>
		private Transition HandleRecursionCall(StackState aSourceState, Input aServiceName) {
			Transition result = null;
			IFiniteStateMachine service = LookUpService(aSourceState.Peek().ServiceName);
			result = (Transition)service.GetNextTransition(aSourceState.Peek().State,aServiceName).Clone();
			RecursionInput recInput = new RecursionInput(aSourceState.Peek().ServiceName,result.DestinationState);
			// TODO check this condition - does it detect already handled recursions?
			if (!inputAlphabet.Contains(recInput)) {
				CounterCondition cc = new CounterCondition(aServiceName,recInput,1);
				inputAlphabet.Add(recInput);
				counterConditionTable.Add(recInput,cc);
			}
			result.SetValues(aSourceState,aServiceName,aSourceState.LookupServiceName(aServiceName));
			return result;
		}


		/// <summary>
		/// Identifies the transition starting at <code>aSourceState</code> with the 
		/// input <code>aRecInput</code>.
		/// 
		/// Check if the recursion input is allowed and determin the destination of the transition.
		/// 
		/// pre: the current input symbol is a <code>RecursionInput</code>
		/// </summary>
		/// <param name="aSourceState">Source state</param>
		/// <param name="aRecInput">Recursion input</param>
		/// <returns>A new transition from source to destination</returns>
		private Transition HandleRecursionInput(StackState aSourceState, RecursionInput aRecInput) {
			AbstractState destinationState = ErrorState;
			if( (aSourceState.Peek().State.IsFinalState) && (aSourceState.LookupServiceNameTwice(aRecInput.Service).IsEmpty)) {
				FiniteTabularMachine service = (FiniteTabularMachine)LookUpService(aSourceState.Peek().ServiceName);
				Set reachableStates = service.GetReachableStates(aRecInput.State);
				if (reachableStates.Contains(aSourceState.Peek().State)) {
					destinationState = new StackState(aSourceState);
					((StackState)destinationState).ChangeTopState(aRecInput.State);
				}
			}
			return CreateTransition(aSourceState,aRecInput,destinationState);
		}


		/// <summary>
		/// Identifies the transition starting at <code>aSourceState</code> with the 
		/// input <code>Input.RETURN</code>.
		/// 
		/// Checks if <code>Input.RETURN</code> is a valid input and returns to the calling service.
		/// 
		/// pre: the input symbol was <code>Input.RETURN</code>
		/// </summary>
		/// <param name="aSourceState">source</param>
		/// <returns>The transition object of the calling service with altered states</returns>
		private Transition ReturnFromService(StackState aSourceState) {
			Transition result = CreateTransition(aSourceState,Input.RETURN,ErrorState);
			StackState destinationState = new StackState(aSourceState);
			Context currentContext = destinationState.Pop();
			if (currentContext.State.IsFinalState) {
				IFiniteStateMachine service;
				Input calledServiceName = currentContext.ServiceName;
				if (destinationState.IsEmpty) {
					service = providesProtocol;
				}
				else {
					service = LookUpService(destinationState.Peek().ServiceName);
				}
				// TODO if transitions with different results should be handled, the object
				// calledServiceName has to be extended by the result of the last transition

				result = (Transition)service.GetNextTransition(destinationState.Peek().State,calledServiceName).Clone();
				destinationState.ChangeTopState(result.DestinationState);
				result.SetValues(aSourceState,Input.RETURN,destinationState);
			}
			return result;
		}


		/// <summary>
		/// Returns the service corresponding to <code aServiceName/>. If the lookup fails
		/// an Exception is thrown.
		/// </summary>
		/// <param name="aServiceName">The name of the service.</param>
		/// <returns>The service corresponding to <code aServiceName/></returns>
		private IFiniteStateMachine LookUpService(Input aServiceName) {
			IFiniteStateMachine service = (IFiniteStateMachine)serviceEffectSpecificationTable[aServiceName];
			if (service == null) 
				throw new StackStateException("Service "+aServiceName+" not known!");
			return service;
		}

		/// <summary>
		/// Creates a new Transition of the default type.
		/// </summary>
		/// <param name="aSourceState">source</param>
		/// <param name="anInputSymbol">input</param>
		/// <param name="aDestinationState">destination</param>
		/// <returns>New transition object</returns>
		private Transition CreateTransition(AbstractState aSourceState, Input anInputSymbol, AbstractState aDestinationState) {
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