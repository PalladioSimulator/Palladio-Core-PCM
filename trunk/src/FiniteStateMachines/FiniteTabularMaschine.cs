using System;
using System.Collections;
using Utils.Collections;

namespace FiniteStateMachines {
	/// <summary>
	/// The class <code>FiniteTabularMachine</code> is the default
	/// implementation of the interface <code>IFiniteStateMachine</code>.
	/// It uses a table of transitions as input to create the finite state
	/// machine. A <code>FiniteTabularMachine</code> is always deterministic.
	/// </summary>
	public class FiniteTabularMachine : IFiniteStateMachine {

		/// <summary>
		/// The input alphabet; a set of <code>Input</code> objects.
		/// </summary>
		private Set inputAlphabet;

		/// <summary>
		/// The start state of the FSM.
		/// </summary>
		private AbstractState startState;

		/// <summary>
		/// The final states of the FSM.
		/// </summary>
		private Set finalStates;

		/// <summary>
		/// The errorstate of the FSM.
		/// </summary>
		private AbstractState errorState;

		/// <summary>
		/// The <code>transitionTable</code> contains all transitions of the finite
		/// state machine. The key of the <code>Hashtable</code> is the
		/// source state, the value is another <code>Hashtable</code>. In this
		/// sub-<code>Hashtable</code> the key is the <code>Input</code> of the 
		/// <code>Transition</code> and the value the <code>Transition</code> itself.
		/// 
		/// This produces a hierarchie which can be used for a quick lookup of all
		/// <code>Transition</code> objects.
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
			this.errorState = AbstractState.CreateErrorState();
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
			this.errorState = AbstractState.CreateErrorState();
			this.states = new Set();
			this.addTransitions(aTransitionList);
		}



		/// <summary>
		/// Finds all reachable states for <code>aState</code>.
		/// </summary>
		/// <param name="aState">State to start from</param>
		/// <returns>Set containing all reachable States</returns>
		public Set GetReachableStates(AbstractState aState) {
			Set resultSet = new Set();
			GetReachableStatesRecursive(aState,ref resultSet);
			return resultSet;
		}


		/// <summary>
		/// Finds all reachable states for <code>aState</code>.
		/// 
		/// Used by the public method.
		/// </summary>
		/// <param name="aState">starting here</param>
		/// <param name="resultSet">has to be an empty set. contains the result</param>
		private void GetReachableStatesRecursive(AbstractState aState,ref Set resultSet) {
			if ((!resultSet.Contains(aState)) && (aState!=ErrorState)) {
				resultSet.Add(aState);
				IList transitions = GetOutgoingTransitions(aState);
				if (transitions != null) {
					foreach (Transition trans in transitions) {
						GetReachableStatesRecursive(trans.DestinationState,ref resultSet);
					}
				}
			}
		}
		

		/// <summary>
		/// The input alphabet; a set of <code>Input</code> objects.
		/// </summary>
		public Set InputAlphabet {
			get {
				return this.inputAlphabet;
			}
		}

		
		/// <summary>
		/// The start state of the FSM. If no start state is defined
		/// an exception is thrown because the FSM is not valid.
		/// </summary>
		public AbstractState StartState {
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
		public Set FinalStates {
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


		/// <summary>
		/// The errorstate of the FSM.
		/// </summary>
		public AbstractState ErrorState {
			get { return errorState; }
		}

		
		/// <summary>
		/// Returns the next State from a given State and an inputcharacter.
		/// </summary>
		/// <param name="fromState"> from State </param>
		/// <param name="input">the inputcharacter</param>
		/// <returns>the next State which is reachable with the state and the inputcharacter</returns>
		public AbstractState GetNextState(AbstractState aSourceState, Input anInput) {
			// The exception has to be thrown, if the input is not in
			// the InputAlphabet or the source state is not a state of the fsm
			return GetNextTransition(aSourceState,anInput).DestinationState;
		}


		/// <summary>
		/// Returns the next <code>Transition</code> starting at <code>aSourceState</code> with the
		/// input symbol <code>anInput</code>.
		/// 
		/// The source state must be in the set of states an the input symbol must be 
		/// in the input alphabet of the finite state machine, otherwise
		/// an excption is thrown.
		/// </summary>
		/// <returns>The transition starting at <code>aSourceState</code>  
		/// with the input symbol <code>anInput</code> </returns>
		public Transition GetNextTransition(AbstractState aSourceState, Input anInput) {
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

		
		/// <summary>
		/// Returns all transitions with the source <code>aSourceState</code>.
		/// </summary>
		/// <returns>A <code>Hashtable</code> which contains all transtions for the given state.
		/// The key of the <code>Hashtable</code> is the <code>Input</code> and the value the 
		/// corresponding <code>Transition</code>.</returns>
		public IList GetOutgoingTransitions(AbstractState state) {
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
		/// Returns all <code>Transitions</code> of the finite state machine.
		/// </summary>
		/// <returns>A <code>IList</code> of <code>Transition</code>s</returns>
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
		/// Adds a <code>Transition</code> to the finite state machine. 
		/// </summary>
		/// <param name="aSourceState">Source of the transition.</param>
		/// <param name="anInput">Input used for the transition</param>
		/// <param name="aDestinationState">Target of the transition.</param>
		public void addTransition(AbstractState aSourceState, Input anInput, AbstractState aDestinationState) {	
			//TODO use DefaultTransitionType here 
			this.addTransition(new Transition(aSourceState, anInput, aDestinationState));
		}


		/// <summary>
		/// Adds the transtion and the states included in the 
		/// transition to the finite state machine.
		/// </summary>
		/// <param name="aTransition">The transition.</param>
		public void addTransition(Transition aTransition) {	
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
		/// Adds an array of transitions to the finite state machine. 
		/// </summary>
		/// <param name="aTransitionList">A list of a transitions.</param>
		public void addTransitions(IList aTransitionList) {	
			foreach (Transition trans in aTransitionList){
				this.addTransition(trans);
			}
		}


		/// <summary>
		/// Default implementation of <code>ToString</code>.
		/// </summary>
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
