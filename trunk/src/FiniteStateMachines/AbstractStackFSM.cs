using System;
using System.Collections;

using FiniteStateMachines.Decorators;
using Utils.Collections;
using FiniteStateMachines;

namespace ParameterisedContracts {
	
	/// <summary>
	///     This class represents a final state machine, which simulates a conjunction of several
	///     others FSMs. The providesProtocol is the top FSM, which invokes all others.
	///     The serviceEffectSpecificationTable maps each input symbol of the
	///     providesProtocol onto another FSM.
	/// </summary>
	public abstract class AbstractStackFiniteStateMachine : AbstractFiniteStateMachine {

		/// <summary>
		///     Name of the top FSM calling all other automatons.
		/// </summary>
		private Input topServiceName;

		/// <summary>
		///     Mapping of a set of input symbols onto a set of automatons.
		/// </summary>
		private Hashtable serviceTable;

		/// <summary>
		///     A set of valid input symbols for this automaton.
		/// </summary>
		private Set inputAlphabet;

		/// <summary>
		///     If the automaton reaches one of this states
		///     during reading an input sequence, the
		///     sequence is accepted.
		/// </summary>
		private Set finalStates;

		/// <summary>
		/// Default type for all transitions, which have to be created.
		/// </summary>
		private System.Type defaultTransitonType;



		protected AbstractStackFiniteStateMachine() {}

		/// <summary>
		/// Excecute this after all your other initialisations have been done.
		/// </summary>
		/// <param name="aTopServiceName"></param>
		/// <param name="aServiceTable"></param>
		protected void Initialize(Input aTopServiceName, Hashtable aServiceTable) {
			topServiceName = aTopServiceName;
			serviceTable = (Hashtable)aServiceTable.Clone();
			inputAlphabet = DetermineInputAlphabet();
			finalStates = DetermineFinalStates();
			DefaultTransitionType = Type.GetType("FiniteStateMachines.Transition");

			// Iterate through the Machine once, to find all recursions.
			TransitionIterator it = new TransitionIterator(this);
			while (it.MoveNext()) {}
		}


		/// <summary>
		///     Determins the complete input alphabet.
		/// 
		///     The input alphabet is a conjunction of all
		///     input alphabets of the automatons this machine
		///     consits of.</summary>
		/// 
		/// <returns>The complete input alphabet.</returns>
		private Set DetermineInputAlphabet() {
			Set resultSet = new Set();
			foreach (DictionaryEntry entry in serviceTable) {
				foreach (Input input in ((IFiniteStateMachine)entry.Value).InputAlphabet) {
					resultSet.Add(input);
				}
			}
			foreach (Input input in LookUpService(topServiceName).InputAlphabet) {
				resultSet.Add(input);
			}
			resultSet.Add(Input.RETURN);

			return resultSet;
		}


		/// <summary>
		/// Determins all final states of the StackFiniteStateMachine.
		/// </summary>
		/// <returns></returns>
		private Set DetermineFinalStates() {
			Set resultStates = new Set();
			foreach (AbstractState state in LookUpService(topServiceName).FinalStates) {
				resultStates.Add(new StackState(state,topServiceName));
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
		///     FinalStates, constructed out of the final states
		///     of the provides protocol.</summary>
		public override Set FinalStates {
			get { return finalStates; }
		}


		/// <summary>
		///     Constructed out of the start state of the
		///     provides protocol.
		/// </summary>
		/// 
		/// <seealso cref="IFiniteStateMachine.StartState"></seealso>
		public override AbstractState StartState {
			get {return new StackState(LookUpService(topServiceName).StartState,topServiceName);}
		}


		/// <summary>
		///     Conjunction of all input alphabets of all automatons 
		///     included in this stack machine.
		/// </summary>
		/// 
		/// <seealso cref="IFiniteStateMachine.InputAphabet"></seealso>
		public override Set InputAlphabet {
			get { return inputAlphabet; }
		}

	
		/// <summary>
		///		Gives subclasses access to the serviceTable.
		/// </summary>
		protected Hashtable ServiceTable {
			get { return serviceTable; }
		}


		/// <summary>
		///     Returns the the target of a transiton starting at aSourceState
		///     with the input symbol anInput.
		/// </summary>
		/// 
		/// <param name="sourceState"></param>
		/// <param name="anInput"></param>
		/// 
		/// <returns>The destination of the transition.</returns>
		/// <seealso cref="IFiniteStateMachine.GetNextState"></seealso>
		public override AbstractState GetNextState(AbstractState sourceState, Input anInput) {
			return GetNextTransition(sourceState,anInput).DestinationState;
		}

		
		/// <summary>
		///     Returns all _valid_ transitions with the source aSourceState.
		/// </summary>
		/// 
		/// <param name="aSourceState"></param>
		/// 
		/// <returns>
		///		A Hashtable which contains all transtions for the given state.
		///     The key of the Hashtable is the Input and the value the
		///     corresponding Transition.
		/// </returns>
		/// <seealso cref="IFiniteStateMachine.GetOutgoingTransitions"></seealso>
		public override IList GetOutgoingTransitions(AbstractState aSourceState) {
			ArrayList result = new ArrayList();
			// the input alphabet has to be cloned, because it could be modified during the
			// iteration leading to an exception, otherwise
			IList alphabet = (IList)InputAlphabet.Clone();
			foreach (Input input in alphabet) {
				Transition nextTransition = GetNextTransition(aSourceState,input);
				if (nextTransition.DestinationState != ErrorState) {
					result.Add(nextTransition);
				}
			}
			return result;
		}

		
		/// <summary>
		/// Identifies the transition starting at aSourceState with the 
		/// input anInput.
		/// 
		/// Determins the destination StackState by simulating a transition in 
		/// aService and updating the top state in aState.
		/// 
		/// pre: - aService is the service corresponding to aSourceState.PeekService()
		///		 - the input alphabet of aService contains anInput
		///		 - aSourceState.IsEmpty == false
		/// </summary>
		/// <param name="aService">FSM corresponding to aState.PeekService()</param>
		/// <param name="aSourceState">StackState for which the transition must be simulated</param>
		/// <param name="anInput">The input symbol for the transition</param>
		/// <returns>The transition object of aService with altered states</returns>
		protected Transition GetTransitionInService(IFiniteStateMachine aService, StackState aSourceState, Input aServiceName) {
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
		/// Identifies the transition starting at aSourceState with the 
		/// input anInput.
		/// 
		/// Pushes the name of the called service (= aServiceName) and the start state of
		/// the service on the stack of the aSourceState and creates a new transition
		/// from the source to the destination.
		/// 
		/// pre: serviceTable contains aServiceName
		///		 = the service effect specification of the service aServiceName exists
		/// </summary>
		/// <param name="aSourceState">StackState for which the transition must be simulated</param>
		/// <param name="aServiceName">called service</param>
		/// <returns>The transition object of aSourceState.Peek().ServiceName with altered states</returns>
		protected Transition CallService(StackState aSourceState, Input aServiceName) {
			Transition result = CreateTransition(aSourceState,aServiceName,ErrorState);
			IFiniteStateMachine topService = LookUpService(aSourceState.Peek().ServiceName);
			
			// check if the input symbol is valid for topService
			if (topService.InputAlphabet.Contains(aServiceName)) {
				// check if the transition is valid in this context
				Transition topTransition = topService.GetNextTransition(aSourceState.Peek().State,aServiceName);
				if(topTransition.DestinationState != topService.ErrorState) {
					// check for recursion
					if (CheckRecursion(aSourceState,aServiceName)) {
						result = HandleRecursionCall(aSourceState,aServiceName);
					} else {
						AbstractState destinationState = new StackState(aSourceState);
						IFiniteStateMachine calledService = LookUpService(aServiceName);
						((StackState)destinationState).Push(aServiceName,calledService.StartState);
						result = (Transition)topTransition.Clone();
						result.SetValues(aSourceState,aServiceName,destinationState);
					}
				}
			}
			return result;
		}


		/// <summary>
		/// Tests aState and aServiceName for recursion.
		/// </summary>
		/// <param name="aState"></param>
		/// <param name="aServiceName"></param>
		/// <returns></returns>
		protected abstract bool CheckRecursion(StackState aState,Input aServiceName);



		/// <summary>
		/// Identifies the transition starting at aSourceState with the 
		/// input aServiceName.
		/// 
		/// Creates a "cycle" in the FSM representing the recursion. Adds a new RecursionInput 
		/// and CounterCondition object to the FSM.
		/// 
		/// pre: a recursion was detected
		/// </summary>
		/// <param name="aSourceState">StackState for which the recursion was detected</param>
		/// <param name="aServiceName">Recursive symbol</param>
		/// <returns>The transition object of aSourceState.Peek().ServiceName with altered states</returns>
		protected abstract Transition HandleRecursionCall(StackState aSourceState, Input aServiceName);


		/// <summary>
		/// Identifies the transition starting at aSourceState with the 
		/// input Input.RETURN.
		/// 
		/// Checks if Input.RETURN is a valid input and returns to the calling service.
		/// 
		/// pre: the input symbol was Input.RETURN
		/// </summary>
		/// <param name="aSourceState">source</param>
		/// <returns>The transition object of the calling service with altered states</returns>
		protected Transition ReturnFromService(StackState aSourceState) {
			Transition result = CreateTransition(aSourceState,Input.RETURN,ErrorState);
			if (!aSourceState.InTopService) {
				StackState destinationState = new StackState(aSourceState);
				StackContext currentContext = destinationState.Pop();
				if (currentContext.State.IsFinalState) {
					IFiniteStateMachine service;
					Input calledServiceName = currentContext.ServiceName;

					service = LookUpService(destinationState.Peek().ServiceName);

					// TODO if transitions with different results should be handled, the object
					// calledServiceName has to be extended by the result of the last transition
					result = (Transition)service.GetNextTransition(destinationState.Peek().State,calledServiceName).Clone();
					destinationState.ChangeTopState(result.DestinationState);
					result.SetValues(aSourceState,Input.RETURN,destinationState);
				}
			}
			return result;
		}


		/// <summary>
		/// Returns the service corresponding to aServiceName. If the lookup fails
		/// an Exception is thrown.
		/// </summary>
		/// <param name="aServiceName">The name of the service.</param>
		/// <returns>The service corresponding to <code aServiceName/></returns>
		protected IFiniteStateMachine LookUpService(Input aServiceName) {
			IFiniteStateMachine service = (IFiniteStateMachine)serviceTable[aServiceName];
			if (service == null) 
				throw new ApplicationException("Service "+aServiceName+" not known!");
			return service;
		}

		/// <summary>
		///     Creates a new Transition using the default type.
		/// </summary>
		/// 
		/// <param name="aSourceState">source</param>
		/// <param name="anInputSymbol">input</param>
		/// <param name="aDestinationState">destination</param>
		/// 
		/// <returns>New transition object</returns>
		protected Transition CreateTransition(AbstractState aSourceState, Input anInputSymbol, AbstractState aDestinationState) {
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
	}
}