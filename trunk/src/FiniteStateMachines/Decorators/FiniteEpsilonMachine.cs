using System;
using FiniteStateMachines;
using Utils.Collections;
using System.Collections;

namespace FiniteStateMachines.Decorators {
	
	/// <summary>
	/// A <code>FiniteEpsilonMachine</code> is based on a regular finite state machine. For
	/// this automaton an epsilon alphabet is defined which is a subset of the input alphabet. 
	/// The elements of this alphabet are interpreted as the empty word epsilon. This leads to 
	/// a non-deterministic finite state machine. To handle this non-determinism the 
	/// <code>FiniteEpsilonMachine</code> computes the epsilon-closure for each state.
	/// </summary>
	public class FiniteEpsilonMachine : IFiniteStateMachine {

		/// <summary>
		/// The regular finite state machine which is used to simulate the 
		/// <code>FiniteEpsilonMachine</code>
		/// </summary>
		private IFiniteStateMachine defaultMachine;

		/// <summary>
		/// The alphabet which elements are interpreted as the empty word epsilon. 
		/// </summary>
		private Set epsilonAlphabet;
		
		
		/// <summary>
		/// Creates a new <code>FiniteEpsilonMachine</code> based on a regular finite state
		/// machine and an alphabet <code>anEpsilonAlphabet</code> which elements are interpreted
		/// as the empty word / empty input epsilon.
		/// </summary>
		/// <param name="aFiniteStateMachine">A regular finite state machine.</param>
		/// <param name="anEpsilonAlphabet">The alphabet which elements are interpreted as epsilon.</param>
		public FiniteEpsilonMachine(IFiniteStateMachine aFiniteStateMachine, Set anEpsilonAlphabet){
			defaultMachine = aFiniteStateMachine;
			epsilonAlphabet = anEpsilonAlphabet;
		}

		
		/// <summary>
		/// The alphabet which elements are interpreted as the empty word epsilon. 
		/// </summary>
		public Set EpsilonAlphabet {
			get{
				return epsilonAlphabet;
			}
		}

		
		/// <summary>
		/// Constructs a new regular finite state machine. The advantage of this machine is that the
		/// whole machine is pre-calculated, so its faster; the disadvantage is the wastage of memory.
		/// </summary>
		/// <returns>A new pre-calculated finite state machine.</returns>
		public IFiniteStateMachine GetDeterministicFiniteStateMachine(){
			IList transitionList = GetAllTransitions();
			FiniteTabularMachine deterministicFSM = new FiniteTabularMachine(transitionList);
			return deterministicFSM;
		}



		/// <summary>
		/// Determins all transitons of this automaton.
		/// </summary>
		private IList GetAllTransitions(){
			ArrayList transitions = new ArrayList();
			ArrayList visitedStates = new ArrayList();
			GetAllTransitionsRecursive(StartState,ref transitions,ref visitedStates);
			return transitions;
		}


		/// <summary>
		/// Recursive implementation of <code>GetAllTransitions</code>.
		/// </summary>
		/// <param name="aState"></param>
		/// <param name="resultSet"></param>
		/// <returns></returns>
		private void GetAllTransitionsRecursive(AbstractState aState, ref ArrayList resultSet, ref ArrayList visitedStates ){
			if ((aState!=ErrorState) && (!visitedStates.Contains(aState))) {
				visitedStates.Add(aState);
				IList outgoing = GetOutgoingTransitions(aState);
				foreach (Transition trans in outgoing) {
					resultSet.Add(trans);
					GetAllTransitionsRecursive(trans.DestinationState,ref resultSet,ref visitedStates);
				}
			}
		}


		/// <summary>
		/// Determins the epsilon-closure for <code>aState</code>. Only
		/// <code>PowerSetStates</code> are allowed as input. The method
		///	determins the epsilon-closure for all included states.
		/// <param name="aState">The state for which the epsilon-closure is determined.</param>
		/// <returns>A <code>PowerSetState</code> representing the epsilon-closure of <code>aState</code>.</returns>
		private PowerSetState GetEpsilonClosure(PowerSetState aState){
			Set closure = new Set();
			foreach (AbstractState state in aState.States){
				GetEpsilonClosureRecursive(state,ref closure);
			}
			return new PowerSetState(closure,aState.IsStartState);
		}


		/// <summary>
		/// Recursive implementation of <code>GetEpsilonClosure</code>.
		/// </summary>
		/// <param name="aState"></param>
		/// <param name="resultSet"></param>
		/// <returns></returns>
		private void GetEpsilonClosureRecursive(AbstractState aState, ref Set resultSet){
			if ((aState!=ErrorState) && (!resultSet.Contains(aState))) {
				resultSet.Add(aState);
				foreach (Input input in epsilonAlphabet) {
					GetEpsilonClosureRecursive(defaultMachine.GetNextState(aState,input),ref resultSet);
				}
			}
		}


		/// <summary>
		/// The errorstate of the FSM.
		/// </summary>
		public AbstractState ErrorState { 
			get{
				return defaultMachine.ErrorState;
			} 
		}

		
		/// <summary>
		/// The start state of the FSM.
		/// </summary>
		public AbstractState StartState { 
			get {
				PowerSetState initialStartState = new PowerSetState(defaultMachine.StartState);
				return GetEpsilonClosure(initialStartState);
			} 
		}

		
		/// <summary>
		/// The final states of the FSM.
		/// </summary>
		public Set FinalStates { 
			get{
				//TODO create new PowerSetStates 
				return defaultMachine.FinalStates; 
			}
		}

		
		/// <summary>
		/// The input alphabet; a set of <code>Input</code> objects.
		/// </summary>
		public Set InputAlphabet { 
			get {
				return defaultMachine.InputAlphabet;
			}
		}

		
		/// <summary>
		/// Returns the the target of a transiton starting at <code>aSourceState</code> 
		/// with the input symbol <code>anInput</code>.
		/// </summary>
		/// <returns>The destination of the transition.</returns>
		public AbstractState GetNextState(AbstractState aSourceState, Input anInput){
			return GetNextTransition(aSourceState,anInput).DestinationState;
		}

		
		/// <summary>
		/// Returns the next <code>Transition</code> starting at <code>aSourceState</code> with the
		/// input symbol <code>anInput</code>.
		/// </summary>
		/// <returns>The transition starting at <code>aSourceState</code>  
		/// with the input symbol <code>anInput</code> </returns>
		public Transition GetNextTransition(AbstractState aSourceState, Input anInput){
			AbstractState resultState = ErrorState;
			PowerSetState powerState = (PowerSetState)aSourceState;
			Set resultSet = new Set();
			foreach (AbstractState state in powerState.States) {
				Transition trans = defaultMachine.GetNextTransition(state,anInput);
				if (trans.DestinationState != ErrorState) {
					resultSet.Add(trans.DestinationState);
				}
			}
			if (resultSet.Count > 0) {
				if (epsilonAlphabet.Contains(anInput)) {
					resultState = aSourceState;
				} else {
					resultState = GetEpsilonClosure(new PowerSetState(resultSet,false));
				}
			}
			// TODO use default transition type or an existing transition.
			return new Transition(aSourceState,anInput,resultState);
		}

		
		/// <summary>
		/// Returns all _valid_ transitions with the source <code>aSourceState</code>.
		/// </summary>
		/// <returns>A <code>Hashtable</code> which contains all transtions for <code>aSourceState</code>.
		/// The key of the <code>Hashtable</code> is the <code>Input</code> and the value the 
		/// corresponding <code>Transition</code>.</returns>
		public IList GetOutgoingTransitions(AbstractState aSourceState){
			ArrayList result = new ArrayList();
			foreach(Input i in InputAlphabet) {
				if (!EpsilonAlphabet.Contains(i)) {
					Transition nextTransition = GetNextTransition(aSourceState,i);
					if(nextTransition.DestinationState != ErrorState) {
						result.Add(nextTransition);
					}
				}
			}
			return result;
		}
	}
}
