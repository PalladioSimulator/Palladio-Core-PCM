using System;
using Palladio.FiniteStateMachines;
using Utils.Collections;
using System.Collections;

namespace Palladio.FiniteStateMachines.Decorators {

	/// <summary>
	///     A FiniteEpsilonMachine is based on a regular finite state machine. For
	///     this automaton an epsilon alphabet is defined which is a subset of the input alphabet.
	///     The elements of this alphabet are interpreted as the empty word epsilon. This leads to
	///     a non-deterministic finite state machine. To handle this non-determinism the
	///     FiniteEpsilonMachine computes the epsilon-closure for each destination state of a 
	///     transition.
	///     
	///     author: JH
	/// </summary>
	public class FiniteEpsilonMachine : AbstractFSM {

		/// <summary>
		///     The regular finite state machine which is used to simulate the
		///     FiniteEpsilonMachine.
		/// </summary>
		private IFiniteStateMachine defaultMachine;

		/// <summary>
		/// The alphabet which elements are interpreted as the empty word epsilon. 
		/// </summary>
		private Set epsilonAlphabet;
		
		
		/// <summary>
		///     Creates a new FiniteEpsilonMachine based on a regular finite state
		///     machine and an alphabet anEpsilonAlphabet which elements are interpreted
		///     as the empty word / empty input epsilon.
		/// </summary>
		/// 
		/// <param name="aFiniteStateMachine">A regular finite state machine.</param>
		/// <param name="anEpsilonAlphabet">The alphabet which elements are interpreted as epsilon.</param>
		public FiniteEpsilonMachine(IFiniteStateMachine aFiniteStateMachine, Set anEpsilonAlphabet){
			defaultMachine = aFiniteStateMachine;
			epsilonAlphabet = anEpsilonAlphabet;
		}

		
		/// <summary>
		///		The alphabet whose elements are interpreted as 
		///		the empty word epsilon. 
		/// </summary>
		public Set EpsilonAlphabet {
			get{
				return epsilonAlphabet;
			}
		}

		
		/// <summary>
		///		Constructs a new regular finite state machine. The advantage 
		///		of this machine is that the whole machine is pre-calculated, 
		///		so its faster; the disadvantage is the wastage of memory.
		/// </summary>
		/// <returns>
		///		A new pre-calculated finite state machine.
		///	</returns>
		public IFiniteStateMachine GetDeterministicFiniteStateMachine(){
			IList transitionList = GetAllTransitions();
			TabularFSM deterministicFSM = new TabularFSM(transitionList);
			return deterministicFSM;
		}



		/// <summary>
		///		Determins all transitons of this automaton.
		/// </summary>
		private IList GetAllTransitions(){
			Vector transitions = new Vector();
			Vector visitedStates = new Vector();
			GetAllTransitionsRecursive(StartState,ref transitions,ref visitedStates);
			return transitions;
		}


		/// <summary>
		///		Recursive implementation of GetAllTransitions.
		/// </summary>
		/// <param name="aState"></param>
		/// <param name="resultSet"></param>
		/// <returns></returns>
		private void GetAllTransitionsRecursive(IState aState, ref Vector resultSet, ref Vector visitedStates ){
			if ((aState!=ErrorState) && (!visitedStates.Contains(aState))) {
				visitedStates.Add(aState);
				IList outgoing = GetOutgoingTransitions(aState);
				foreach (ITransition trans in outgoing) {
					resultSet.Add(trans);
					GetAllTransitionsRecursive(trans.DestinationState,ref resultSet,ref visitedStates);
				}
			}
		}	


		/// <summary>
		///		Determins the epsilon-closure for aState. Only
		///		PowerSetStates are allowed as input. The method
		///		determins the epsilon-closure for all included states.
		/// </summary>
		/// <param name="aState">
		///		The state for which the epsilon-closure is determined.
		///	</param>
		/// <returns>
		///		A PowerSetState representing the epsilon-closure of aState.
		/// </returns>
		private PowerSetState GetEpsilonClosure(PowerSetState aState){
			Set closure = new Set();
			foreach (IState state in aState.States){
				GetEpsilonClosureRecursive(state,ref closure);
			}
			return new PowerSetState(closure,aState.IsStartState);
		}


		/// <summary>
		///		Recursive implementation of GetEpsilonClosure.
		/// </summary>
		/// <param name="aState"></param>
		/// <param name="resultSet"></param>
		/// <returns></returns>
		private void GetEpsilonClosureRecursive(IState aState, ref Set resultSet){
			if ((aState!=ErrorState) && (!resultSet.Contains(aState))) {
				resultSet.Add(aState);
				foreach (Input input in epsilonAlphabet) {
					GetEpsilonClosureRecursive(defaultMachine.GetNextState(aState,input),ref resultSet);
				}
			}
		}


		/// <summary>
		///		The errorstate of the FSM.
		/// </summary>
		public override IState ErrorState { 
			get{
				return defaultMachine.ErrorState;
			} 
		}

		
		/// <summary>
		///		The start state of the FSM.
		/// </summary>
		public override IState StartState { 
			get {
				PowerSetState initialStartState = new PowerSetState(defaultMachine.StartState);
				return GetEpsilonClosure(initialStartState);
			} 
		}

		
		/// <summary>
		///		The final states of the FSM.
		/// </summary>
		public override Set FinalStates { 
			get{
				//TODO create new PowerSetStates 
				return defaultMachine.FinalStates; 
			}
		}

		
		/// <summary>
		///		The input alphabet; a set of Input objects.
		/// </summary>
		public override Set InputAlphabet { 
			get {
				return defaultMachine.InputAlphabet;
			}
		}

		
		/// <summary>
		///     Returns the target of a transition
		///     starting at aSourceState with the input 
		///     symbol anInput.
		/// </summary>
		/// <param name="aSourceState">
		///		The source of the transition.
		///	</param>
		/// <param name="anInput">
		///		The input symbol of the transition.
		///	</param>
		/// <returns>
		///		The destination of the transition.
		///	</returns>
		public override IState GetNextState(IState aSourceState, Input anInput){
			return GetNextTransition(aSourceState,anInput).DestinationState;
		}

		
		/// <summary>
		///     Returns the next ITransition starting 
		///     at aSourceState with the input symbol 
		///     anInput.
		/// </summary>
		/// <param name="aSourceState">
		///		The source of the transition.
		///	</param>
		/// <param name="anInput">
		///		The input of the transition.
		///	</param>
		/// 
		/// <returns>
		///		The transition starting at aSourceState
		///     with the input symbol anInput.
		/// </returns>
		public override ITransition GetNextTransition(IState aSourceState, Input anInput){
			IState resultState = ErrorState;
			PowerSetState powerState = (PowerSetState)aSourceState;
			Set resultSet = new Set();
			foreach (IState state in powerState.States) {
				ITransition trans = defaultMachine.GetNextTransition(state,anInput);
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
		///     Returns all _valid_ transitions with the source state.
		/// </summary>
		/// <param name="aSourceState">
		///		The source for which all valid transitions are returned.
		///	</param>
		/// <returns>
		///		A Hashtable which contains all transitions for the source state.
		///     The key of the Hashtable is the Input and the value the
		///     corresponding ITransition.
		/// </returns>
		public override IList GetOutgoingTransitions(IState aSourceState){
			Vector result = new Vector();
			foreach(Input i in InputAlphabet) {
				if (!EpsilonAlphabet.Contains(i)) {
					ITransition nextTransition = GetNextTransition(aSourceState,i);
					if(nextTransition.DestinationState != ErrorState) {
						result.Add(nextTransition);
					}
				}
			}
			return result;
		}
	}
}
