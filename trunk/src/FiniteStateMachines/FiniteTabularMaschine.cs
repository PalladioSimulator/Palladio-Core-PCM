using System;
using System.Collections;
using System.Xml;
using System.Xml.XPath;
using Utils.Collections;

namespace FiniteStateMachines {
    /// <summary>
    ///     The FiniteTabularMachine is the default implementation of the IFiniteStateMachine interface.
    ///     It uses a table of transitions as input to create the finite state
    ///     machine. A FiniteTabularMachine is always deterministic.
    ///     
    ///     author: JH
    /// </summary>
	public class FiniteTabularMachine : AbstractFiniteStateMachine {

		/// <summary>
		///     A set of valid input symbols for this automaton.
		/// </summary>
		private Set inputAlphabet;

		/// <summary>
		///     If the automaton is used for accepting
		///     an input sequence, this is the state to
		///     start with.
		/// </summary>
		private AbstractState startState;

		/// <summary>
		///     If the automaton reaches one of this states
		///     during reading an input sequence, the
		///     sequence is accepted.
		/// </summary>
		private Set finalStates;


		/// <summary>
		///		The transitionTable contains all transitions of the finite
		///		state machine. The key of the Hashtable is the
		///		source state, the value is another Hashtable. In this
		///		sub-Hashtable the key is the Input of the 
		///		Transition and the value the Transition itself.
		/// 
		///		This produces a hierarchie which can be used for a quick lookup of all
		///		Transition objects.
		/// </summary>
		private Hashtable transitionTable;

		/// <summary>
		///		Set containing all states of the FSM.
		/// </summary>
		private Set states;


		/// <summary>
		///		Creates a new, empty finite state machine.
		/// </summary>
		public FiniteTabularMachine() {
			this.inputAlphabet = new Set();
			this.transitionTable = new Hashtable();
			this.finalStates = new Set();
			this.states = new Set();
		}

		
		/// <summary>
		///		Creates a new finite state machine using an array of transitions.
		/// </summary>
		/// <param name="aTransitionList">
		///		All transitions of the finite state machine.
		///	</param>
		public FiniteTabularMachine(IList aTransitionList) {
			this.inputAlphabet = new Set();
			this.transitionTable = new Hashtable();
			this.finalStates = new Set();
			this.states = new Set();
			this.AddTransitionList(aTransitionList);
		}



	  
		/// <summary>
		///		Loader for tabular FSMs using a xml-file as input.
		///		An example is listed below:
		/// 
		/// <?xml version="1.0" encoding="utf-8" ?> 
		/// <fsm>
		///		<state name="one" start="true"/>
		///		<state name="two" final="true"/>
		///		
		///		<transition source="one" target="one" input="d2"/>
		///		<transition source="one" target="two" input="d1"/>
		///		<transition source="two" target="two" input="d2"/>
		/// </fsm>
		/// 
		/// </summary>
		public void Load(string aFilename) {

			XmlDocument doc = new XmlDocument();
			doc.Load(aFilename);

			XPathNavigator nav = doc.CreateNavigator();
			int stateCnt = 0;
			Hashtable stateTable = new Hashtable();

			// Loading States
			XPathNodeIterator iterator = nav.Select("/fsm/state");
			while (iterator.MoveNext()){
				string	name = "state "+stateCnt;
				bool	start = false;
				bool	final = false;

				if (iterator.Current.MoveToAttribute("name","")) {
					name = iterator.Current.Value;
					iterator.Current.MoveToParent();
				}

				if (iterator.Current.MoveToAttribute("start","")) {
					if (iterator.Current.Value == "true"){
						start = true;
					}
					iterator.Current.MoveToParent();
				}

				if (iterator.Current.MoveToAttribute("final","")) {
					if (iterator.Current.Value == "true"){
						final = true;
					}
					iterator.Current.MoveToParent();
				}

				AbstractState state = new State(name,start,final);
				stateTable.Add(name,state);
				AddState(state);
				stateCnt++;
			}

			// Loading Transitions
			iterator = nav.Select("/fsm/transition");
			Hashtable inputTable = new Hashtable();
			while (iterator.MoveNext()){
				AbstractState source = null;
				AbstractState target = null;
				Input input = null;

				if (iterator.Current.MoveToAttribute("source","")) {
					source = (AbstractState)stateTable[iterator.Current.Value];
					iterator.Current.MoveToParent();
				}
				if (iterator.Current.MoveToAttribute("target","")) {
					target = (AbstractState)stateTable[iterator.Current.Value];
					iterator.Current.MoveToParent();
				}
				if (iterator.Current.MoveToAttribute("input","")) {
					input = (Input)inputTable[iterator.Current.Value];
					if (input == null) {
						input = new Input(iterator.Current.Value);
						inputTable.Add(iterator.Current.Value, input);
					}
					iterator.Current.MoveToParent();
				}

				if ((source != null) && (target != null) && (input != null)) {
					AddTransition(new Transition(source,input,target));
				} else {
					throw new ApplicationException("Incomplete Transition found!");
				}
			}
			
		}
		

		/// <summary>
		///     A set of valid input symbols for this automaton.
		/// </summary>
		public override Set InputAlphabet {
			get {
				return this.inputAlphabet;
			}
		}

		
		/// <summary>
		///		The start state of the FSM. If no start state is defined
		///		an exception is thrown because the FSM is not valid.
		/// 
		///     If the automaton is used for accepting
		///     an input sequence, this is the state to
		///     start with.
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
		///		The final states of the FSM. If no final states are defined
		///		an exception is thrown because the FSM is not valid.
		/// 
		///     If the automaton reaches one of this states
		///     during reading an input sequence, the
		///     sequence is accepted.
		/// </summary>
		public override Set FinalStates {
			get {
				if (finalStates.Count != 0) {
					return finalStates;
				} else {
					throw new ApplicationException("No final states defined");
				}
			}
		}

		
		/// <summary>
		///		The set of states of the finite state machine.
		/// </summary>
		public Set States {
			get {return this.states;}
		}


        /// <summary>
		///     Returns the next Transition
		///     starting at aSourceState
		///     with the input symbol anInput.
		///     
		///     The source state must be in the set of states an the input symbol must be
        ///     in the input alphabet of the finite state machine, otherwise
        ///     an excption is thrown.
        /// </summary>
		/// <param name="aSourceState">
		///		The source of the transition.
		///	</param>
		/// <param name="anInput">
		///		The input of the transition.
		///	</param>
		/// <returns>
		///		The transition starting at aSourceState
		///     with the input symbol anInput. 
		/// </returns>
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

		
		/// <summary>
		///     Returns all _valid_ transitions with the source state.
		/// </summary>
		/// <param name="aSourceState">
		///		The source for which all valid transitions are returned.
		///	</param>
		/// <returns>
		///		A Hashtable which contains all transitions for the source state.
		///     The key of the Hashtable is the Input and the value the
		///     corresponding Transition.
		/// </returns>
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
        ///		Returns all Transitions of the finite state machine.
        /// </summary>
        /// 
        /// <returns>
        ///		A IList of Transitions
        ///	</returns>
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
		///     Adds a single transition to the automaton.
		/// </summary>
		public void AddTransition(AbstractState aSourceState, Input anInput, AbstractState aDestinationState) {	
			//TODO use DefaultTransitionType here 
			this.AddTransition(new Transition(aSourceState, anInput, aDestinationState));
		}


        /// <summary>
        ///     Adds the transtion and the states included in the
        ///     transition to the finite state machine.
        /// </summary>
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
		///		Adds a state to the finite state machine.
		/// </summary>
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
		///		Adds an input symbol to the input alphabet.
		/// </summary>
		private void AddInput(Input anInput) {
			if (!inputAlphabet.Contains(anInput)) {
				inputAlphabet.Add(anInput);
			}
		}

		
        /// <summary>
        ///     Adds a list of transitions to the finite state machine.
        /// </summary>
		public override void AddTransitionList(IList aTransitionList) {	
			foreach (Transition trans in aTransitionList){
				this.AddTransition(trans);
			}
		}
	}
}
