using System;
using System.Collections;
using Utils.Collections;
using Utils.Exceptions;
using FiniteStateMachines.Decorators;


namespace FiniteStateMachines {

	/// <summary>
	///     The AbstractFiniteStateMachine implements some
	///     default functionality useful for most finite state
	///     machines.
	///     
	///     author: JH
	/// </summary>
	public abstract class AbstractFiniteStateMachine : IFiniteStateMachine {
		
		/// <summary>
		///     Constant for the name of an error state.
		/// </summary>
		private const string ERROR_STATE_NAME = "error state";

		/// <summary>
		///     All transitions with an unallowed input
		///     lead to this error state.
		/// </summary>
		private AbstractState errorState;

		/// <summary>
		///     All transitions with an unallowed input
		///     lead to this error state.
		/// </summary>
		public virtual AbstractState ErrorState { 
			get{
				if(errorState == null){
					errorState = CreateErrorState();
				}
				return errorState;
			}
		}

		/// <summary>
		///     If the automaton is used for accepting
		///     an input sequence, this is the state to
		///     start with.
		/// </summary>
		public abstract AbstractState StartState { get; }

		/// <summary>
		///     If the automaton reaches one of this states
		///     during reading an input sequence, the
		///     sequence is accepted.
		/// </summary>
		public abstract Set FinalStates { get; }

		/// <summary>
		///     A set of valid input symbols for this automaton.
		/// </summary>
		public abstract Set InputAlphabet { get; }

		/// <summary>
		///     Returns the next Transition
		///     starting at aSourceState
		///     with the input symbol anInput.
		/// </summary>
		/// 
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
		public abstract Transition GetNextTransition(AbstractState aSourceState, Input anInput);
        
		/// <summary>
		///     Adds a single transition to the automaton.
		///     The default behaviour is to throw an MethodNotImplementedException,
		///     because for some automatons it is not possible to
		///     implement this method.
		/// </summary>
		/// <param name="aTransition">
		///		The transition to add to the automaton.
		///	</param>
		public virtual void AddTransition(Transition aTransition){
			throw new MethodNotImplementedException();
		}

		/// <summary>
		///     Adds a list of transitions to the automaton.
		///     The default behaviour is to throw an MethodNotImplementedException,
		///     because for some automatons it is not possible to
		///     implement this method.
		/// </summary>
		/// <param name="aTransitionList">
		///		A list of transitions.
		///	</param>
		public virtual void AddTransitionList(IList aTransitionList){
			throw new MethodNotImplementedException();
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
		public virtual AbstractState GetNextState(AbstractState aSourceState, Input anInput) {
			return GetNextTransition(aSourceState,anInput).DestinationState;
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
		public virtual IList GetOutgoingTransitions(AbstractState aSourceState) {
			IList result = new ArrayList();
			foreach( Input input in InputAlphabet ) {
				Transition trans = GetNextTransition(aSourceState,input);
				if ( trans.DestinationState != ErrorState ) {
					result.Add(trans);
				}
			}
			return result;
		}

		/// <summary>
		///     Searches for all states reachable from aState. This means
		///     there exists a path from aState to every state contained
		///     in the result. Certainly aState is also included in
		///     the result.
		/// </summary>
		/// <param name="aState">
		///		The search starts here.
		///	</param>
		/// <returns>
		///		An IList containing all reachable States.
		///	</returns>
		public virtual IList GetReachableStates(AbstractState aState) {
			IList resultSet = new ArrayList();
			GetReachableStatesRecursive(aState,ref resultSet);
			return resultSet;
		}


		/// <summary>
		///     Searches for all states reachable from aState. This means
		///     there exists a path from aState to every state contained
		///     in the result. Certainly aState is also included in
		///     the result. This is done recursively.
		/// </summary>
		/// <param name="aState">
		///		starting here
		///	</param>
		/// <param name="resultSet">
		///		An IList containing the visited states.
		///	</param>
		private void GetReachableStatesRecursive(AbstractState aState,ref IList resultSet) {
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
		///		Calculates a minimized version of the current FSM.
		/// </summary>
		public IFiniteStateMachine GetMinimzed() {
			//TODO: evtl TabFSM zurückgeben
			return new MinimisedFSM(this);
		}


		public override bool Equals(object obj) {
			if ( obj is IFiniteStateMachine) {
				return AreEqual( this, (IFiniteStateMachine) obj );
			} 
			return false;
		}

		public static bool AreEqual( IFiniteStateMachine fsmOne, IFiniteStateMachine fsmTwo ) {
			IFiniteStateMachine minOne = new MinimisedFSM(fsmOne);
			IFiniteStateMachine minTwo = new MinimisedFSM(fsmTwo);

			DynamicStateEnumerator iter = new DynamicStateEnumerator(new DualState(fsmOne.StartState,fsmTwo.StartState));
			while (iter.MoveNext()) {
				DualState current = (DualState) iter.Current;
				if ((current.oneState.IsFinalState == current.twoState.IsFinalState) &&
					(current.oneState.IsStartState == current.twoState.IsStartState)) {
					foreach (Input input in minOne.InputAlphabet) {
						AbstractState nextOne = minOne.GetNextState(current.oneState, input);
						AbstractState nextTwo = minTwo.GetNextState(current.twoState, input);	
						if (( nextOne != minOne.ErrorState ) &&
							( nextTwo != minTwo.ErrorState )) {
							iter.Append(new DualState (nextOne, nextTwo));
						} else {
							return false;
						}
					}
				} else {
					return false;
				}
			}
			return true;
		}

		/// <summary>
		///     Creates a new state representing a default error state.
		/// </summary>
		/// 
		/// <returns>Default error state.</returns>
		public static AbstractState CreateErrorState(){
			return new State(ERROR_STATE_NAME,false,false);
		}

		/// <summary>
		///		General loader for FSM-files. Depending on the
		///		type the corresponding machine type is chosen and
		///		instanced.
		/// </summary>
		/// <param name="aFilename">
		///		Name of the file. It must be in XML. You can find
		///		more details on the file format in the corresponding
		///		documentation of the loaders for each FSM-type.
		/// </param>
		/// <returns>
		///		A loaded version of the FSM described in aFilename.
		///	</returns>
		public static IFiniteStateMachine Loader(string aFilename) {
			//Just Tabular FSM can be loaded at the moment
			FiniteTabularMachine result = new FiniteTabularMachine();
			result.Load(aFilename);
			return result;
		}

		/// <summary>
		///		Default implementation of ToString for FSMs.
		/// </summary>
		/// <returns>
		///		A string describing the FSM.
		/// </returns>
		public override string ToString() {
			string result = "start state : ";
			try {
				result += StartState+"\n";
				result += "transitions : \n";
				DynamicTransitionEnumerator iterator = new DynamicTransitionEnumerator(StartState,this);
				while(iterator.MoveNext()){
					result += "\t"+iterator.Current+"\n";
					iterator.Append(iterator.Current.DestinationState);
				}
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
			return result;
		}

		/// <summary>
		///		Calculate a hashcode for the FSM.
		/// </summary>
		/// <returns>
		///		A hashcode.
		/// </returns>
		public override int GetHashCode() {
			return base.GetHashCode();
		}

	}
}

