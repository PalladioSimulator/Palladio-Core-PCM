using System;
using System.Collections;
using Utils.Collections;

namespace FiniteStateMachines {
    /// <summary>
    ///     The FiniteTabularMachine is the default implementation of the IFiniteStateMachine interface.
    ///     It uses a table of transitions as input to create the finite state
    ///     machine. A FiniteTabularMachine is always deterministic.
    /// </summary>
	public class FiniteTabularMachine : AbstractFiniteStateMachine {

        /// <summary></summary>
        /// 
        /// <seealso cref="IFiniteStateMachine.InputAlphabet"></seealso>
		private Set inputAlphabet;

        /// <summary></summary>
        /// 
        /// <seealso cref="IFiniteStateMachine.StartState"></seealso>
		private AbstractState startState;

        /// <summary></summary>
        /// 
        /// <seealso cref="IFiniteStateMachine.FinalStates"></seealso>
		private Set finalStates;


		/// <summary>
		/// The transitionTable contains all transitions of the finite
		/// state machine. The key of the Hashtable is the
		/// source state, the value is another Hashtable. In this
		/// sub-Hashtable the key is the Input of the 
		/// Transition and the value the Transition itself.
		/// 
		/// This produces a hierarchie which can be used for a quick lookup of all
		/// Transition objects.
		/// </summary>
		private Hashtable transitionTable;

		/// <summary>
		/// Set containing all states of the FSM.
		/// </summary>
		private Set states;


		/// <summary>
		/// Creates a new finite state machine.
		/// 
		/// jh: this constructor should be invisilbe to the public 
		/// because it does not create a valid instance of a tabular fsm.
		/// </summary>
		public FiniteTabularMachine() {
			this.inputAlphabet = new Set();
			this.transitionTable = new Hashtable();
			this.finalStates = new Set();
			this.states = new Set();
		}

		
		/// <summary>
		/// Creates a new finite state machine using an array of transitions.
		/// </summary>
		/// <param name="aTransitionList">All transitions of the finite state machine.</param>
		public FiniteTabularMachine(IList aTransitionList) {
			this.inputAlphabet = new Set();
			this.transitionTable = new Hashtable();
			this.finalStates = new Set();
			this.states = new Set();
			this.AddTransitionList(aTransitionList);
		}



	   
		

        /// <summary></summary>
        /// 
        /// <seealso cref="IFiniteStateMachine.InputAphabet"></seealso>
		public override Set InputAlphabet {
			get {
				return this.inputAlphabet;
			}
		}

		
		/// <summary>
		/// The start state of the FSM. If no start state is defined
		/// an exception is thrown because the FSM is not valid.
		/// </summary>
		public override AbstractState StartState {
			get {
				if (startState != null) {
					return startState; 
				} else {
					throw new InvalidStateException("No start state defined");
				}
			}
		}


		/// <summary>
		/// The final states of the FSM. If no final states are defined
		/// an exception is thrown because the FSM is not valid.
		/// </summary>
		public override Set FinalStates {
			get {
				if (finalStates.Count != 0) {
					return finalStates;
				} else {
					throw new InvalidStateException("No final states defined");
				}
			}
		}

		
		/// <summary>
		/// The set of states of the finite state machine.
		/// </summary>
		public Set States {
			get {return this.states;}
		}


        /// <summary></summary>
        /// 
        /// <param name="aSourceState"></param>
        /// <param name="anInput"></param>
        /// 
        /// <returns>the next State which is reachable with the state and the inputcharacter</returns>
        /// <seealso cref="IFiniteStateMachine.GetNextState"></seealso>
		public override AbstractState GetNextState(AbstractState aSourceState, Input anInput) {
			// The exception has to be thrown, if the input is not in
			// the InputAlphabet or the source state is not a state of the fsm
			return GetNextTransition(aSourceState,anInput).DestinationState;
		}


        /// <summary>
        ///     The source state must be in the set of states an the input symbol must be
        ///     in the input alphabet of the finite state machine, otherwise
        ///     an excption is thrown.
        /// </summary>
        /// 
        /// <param name="aSourceState"></param>
        /// <param name="anInput"></param>
        /// 
        /// <returns>The transition starting at aSourceState
        /// with the input symbol anInput </returns>
        /// <seealso cref="IFiniteStateMachine.GetNextTransition"></seealso>
		public override Transition GetNextTransition(AbstractState aSourceState, Input anInput) {
			//TODO use DefaultTransitionType here
			Transition result = new Transition(aSourceState,anInput,ErrorState);
			if((!States.Contains(aSourceState)) && (aSourceState != ErrorState)) {
				throw new InvalidStateException(aSourceState+" is not a valid state for this finite state machine!");
			} 
			else if (!InputAlphabet.Contains(anInput)) {
				throw new InvalidInputException(anInput+" is not a valid input symbol for this finite state machine!");
			}
			else if (transitionTable.Contains(aSourceState)) {
				Hashtable inputTable = (Hashtable) transitionTable[aSourceState];
				if (inputTable.Contains(anInput)){
					result = (Transition)inputTable[anInput];
				}
			}
			return result;
		}

		
        /// <summary></summary>
        /// 
        /// <param name="state"></param>
        /// 
        /// <returns></returns>
        /// <seealso cref="IFiniteStateMachine.GetOutgoingTransitions "></seealso>
		public override IList GetOutgoingTransitions(AbstractState state) {
			ArrayList result = new ArrayList();
			Hashtable outgoing = (Hashtable)transitionTable[state];
			if (outgoing != null) {
				foreach (DictionaryEntry entry in outgoing) {
					result.Add(entry.Value);
				}
			}
			return result;
		}


        /// <summary>
        /// Returns all Transitions of the finite state machine.
        /// </summary>
        /// 
        /// <returns>A IList of Transitions</returns>
		public IList GetTransitions() {
			ArrayList transitionArray = new ArrayList();
			foreach (DictionaryEntry entry in transitionTable) {
				foreach (DictionaryEntry subEntry in ((Hashtable)entry.Value)){
					transitionArray.Add(subEntry.Value);
				}
			}
			return transitionArray;
		}


        /// <summary>
        /// Adds a Transition to the finite state machine.
        /// </summary>
        /// 
        /// <param name="aSourceState">Source of the transition.</param>
        /// <param name="anInput">Input used for the transition</param>
        /// <param name="aDestinationState">Target of the transition.</param>
		public void AddTransition(AbstractState aSourceState, Input anInput, AbstractState aDestinationState) {	
			//TODO use DefaultTransitionType here 
			this.AddTransition(new Transition(aSourceState, anInput, aDestinationState));
		}


        /// <summary>
        ///     Adds the transtion and the states included in the
        ///     transition to the finite state machine.
        /// </summary>
        /// 
        /// <param name="aTransition">The transition.</param>
        /// 
        /// <seealso cref="IFiniteStateMachine.AddTransition"></seealso>
		public override void AddTransition(Transition aTransition) {	
			AddState(aTransition.SourceState);
			AddState(aTransition.DestinationState);
			AddInput(aTransition.InputSymbol);

			Hashtable inputTable;
			if(transitionTable.Contains(aTransition.SourceState)) {
				inputTable = (Hashtable)transitionTable[aTransition.SourceState];
			} else {
				inputTable = new Hashtable();
			}

			if(!inputTable.Contains(aTransition.InputSymbol)) {
				inputTable[aTransition.InputSymbol] = aTransition;
			} else {
				// TODO create a new exception type
				throw new InvalidStateException("A transition from "+aTransition.SourceState+" with the input symbol "+aTransition.InputSymbol+" is already defined!");
			}
			
				transitionTable[aTransition.SourceState] = inputTable;
			
		}


		/// <summary>
		/// Adds a state to the finite state machine.
		/// </summary>
		/// <param name="aState"></param>
		private void AddState(AbstractState aState) {
			if (!states.Contains(aState)){
				if (aState.IsStartState){ 
					if (startState == null) {
						startState = aState;
						
					} else {
						throw new InvalidStateException("A start state is already defined! \nstart state: "+StartState+"\nnew state  :"+aState);
					}
				}
				if (aState.IsFinalState) {
					finalStates.Add(aState);
				}
				states.Add(aState);
			}
		}
	


		/// <summary>
		/// Adds an input symbol to the input alphabet.
		/// </summary>
		/// <param name="anInput"></param>
		private void AddInput(Input anInput) {
			if (!inputAlphabet.Contains(anInput)) {
				inputAlphabet.Add(anInput);
			}
		}

		
        /// <summary>
        ///     Adds an array of transitions to the finite state machine.
        /// </summary>
        /// 
        /// <param name="aTransitionList">A list of a transitions.</param>
        /// 
        /// <seealso cref="IFiniteStateMachine.AddTransitionList"></seealso>
		public override void AddTransitionList(IList aTransitionList) {	
			foreach (Transition trans in aTransitionList){
				this.AddTransition(trans);
			}
		}


        /// <summary>
        /// Default implementation of ToString.
        /// </summary>
        /// 
        /// <returns></returns>
		public override string ToString() {
			string result = "start state : ";
			try {
				result += StartState+"\n";
			} catch (InvalidStateException e){
				result += e.Message+"\n";
			}	
			try {
				result += "final states: ";
				foreach (AbstractState state in FinalStates) {
					result += state + " ";
				}
			} catch (InvalidStateException e){
				result += e.Message+"\n";
			}	
			result += "\n";
			result += "transitions : \n";
			foreach (Transition trans in GetTransitions()) {
				result += "\t" + trans + "\n";
			}
			return result;
		}
	}
}
