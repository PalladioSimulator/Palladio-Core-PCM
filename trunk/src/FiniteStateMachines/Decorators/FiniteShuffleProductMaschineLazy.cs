using System;
using System.Collections;
using Utils.Collections;
using Palladio.FiniteStateMachines;

namespace Palladio.FiniteStateMachines.Decorators {
	/// <summary>
	///The FiniteShuffleProductMaschine (FSP) is a specialization of a normal FSM. Is generated out
	/// of two FSMs. 
	/// FSM A, FSM B 
	/// FSP(A B)={
	/// Input: (Input A + Input B);
	/// StartState: ((Startstate A, StartState B)) 
	/// FinalState: ((FinalState A, FinalState B))
	/// FSPState: ((aState of A, aState of B))
	/// Transition: ((FSPState x, Input i, FSPState y) |
	///		1. i is in Input A and Input B:  
	///			FSPState y =(a State of A.next reachable with i),(a State of B.next reachable with i))
	///		2. i is in Input A and not in Input B:
	///			FSPState y =(a State of A.next reachable with i),(a State of B))
	///		3. i is in Input B and not in Input A
	///			FSPState y =(a State of A),(a State of B.next reachable with i))
	///		4. i is not in Input A and not in Inptut B
	///			FSPState Y = ErrorState.
	///	}
	/// 
	/// But the there is one Difference between a normal FiniteShuffleProductMaschine and
	/// this. The FiniteShuffleProductMaschineeLazy implemts <code>IFiniteStateMachine</code>
	/// Interface. The other spezial thing of the FiniteShuffleProductMaschineLazy is that 
	/// when your call its methods, you don't have to visit the whole FSM, only the realted
	/// parts. This will be much faster when you have huge FSMs then creating a normal 
	/// FiniteCrossProduktMaschine.
	/// </summary>
	public class FiniteShuffleProductMaschineLazy : AbstractFSM {
		/// <summary>
		/// An indicator says if the input has already been created.
		/// </summary>
		protected bool inputGenerated;

		/// <summary>
		/// The input of both given FSMs stored in a Set.
		/// </summary>
		public Set inputAl;

		/// <summary>
		/// the cross Input of the FiniteShuffleProductMaschine stored in a 
		/// <code>Set</code>.
		/// </summary>
		public Set crossInput;

		/// <summary>
		/// Stores all states which has been visited during iteration in a 
		/// <code>Set</code>
		/// </summary>
		protected Set visitedStates;

		/// <summary>
		/// The first FiniteTabularMachine which is used to generate 
		/// FiniteShuffleProductMaschine
		/// </summary>
		protected IFiniteStateMachine aFSM;

		/// The second FiniteTabularMachine which is used to generate 
		/// FiniteShuffleProductMaschine
		protected IFiniteStateMachine anotherFSM;


		/// <summary>
		/// Initated a FiniteShuffleProductMaschineLazy with the two given FSMs.
		/// </summary>
		/// <param name="one">A <code>FiniteTabularMaschine</code></param>
		/// <param name="two">Another <code>FiniteTabularMaschine</code></param>
		public FiniteShuffleProductMaschineLazy(IFiniteStateMachine aFSM, IFiniteStateMachine anotherFSM) {
			this.aFSM = aFSM;
			this.anotherFSM = anotherFSM;
		}
		
		
		/// <summary>
		/// Returns the input of the FiniteShuffleProductMaschineLazy
		/// </summary>
		public override Set InputAlphabet {
			get {
				if(!this.inputGenerated)
					GenerateInput();
				return this.inputAl;
			}
		}


		/// <summary>
		/// Generates a Set which only contains the input elements which are in both <code>FiniteTabularMaschine</code>
		/// (intersection of the input of the two given FiniteStatesMaschines)
		/// </summary>
		protected void GenerateCrossInput() {
			this.crossInput = new Set();
			foreach(Input i in aFSM.InputAlphabet) {
				foreach(Input p in anotherFSM.InputAlphabet)
					if(p.Equals(i)) {
						this.crossInput.Add((Input) i);
					}
			}
		}


		/// <summary>
		/// Generates the inputalphabet for the FiniteShuffleProductMaschine from the inputalphabets
		/// of the two given FiniteStateMaschines.
		/// </summary>
		protected void GenerateInput() {
			this.inputGenerated = true;
			GenerateCrossInput();
			this.inputAl = new Set();
			Set oneInput = this.aFSM.InputAlphabet;
			Set twoInput = this.anotherFSM.InputAlphabet;
			foreach(Input i in oneInput)
				this.inputAl.Add(i);
			foreach(Input i in twoInput)
				this.inputAl.Add(i);
		}
		/// <summary>
		/// Returns the ErrorState of the FiniteShuffleProductMaschine
		/// </summary>
		public override IState ErrorState {
			get { return new DualState(this.aFSM.ErrorState,anotherFSM.ErrorState);}
		}
		


		/// <summary>
		/// Represents the FinalStates of a FiniteShuffleProductMaschineLazy in a <code>Set</code>
		/// </summary>
		public override Set FinalStates {
			get {
				Set finalStates = new Set();
				foreach(State oneFinal in this.aFSM.FinalStates) {
					foreach(State twoFinal in this.anotherFSM.FinalStates) {
						if(oneFinal.IsFinalState &&  twoFinal.IsFinalState)
							finalStates.Add(new DualState(oneFinal,twoFinal));
					}
				}
				return finalStates;
			}
		}


		/// <summary>
		/// Delivers the next State from the given parameters
		/// </summary>
		/// <param name="state">A <code>DualState</code> from which the next rechable State should be delivered</param>
		/// <param name="input">An <code>Input</code></param>
		/// <returns>the next reachable DualState</returns>
		public override IState GetNextState(IState aState, Input input) {
			TabularFSM d = new TabularFSM();
			if(aState is DualState == false)
				throw new InvalidStateException();
			IState oneNext;
			IState twoNext;
			DualState cpState = (DualState) aState;
			try {
				oneNext = (State)this.aFSM.GetNextState(cpState.oneState,input);
			}
			catch(Exception) {
				oneNext = (State)d.ErrorState;
			}
			try {

				twoNext = (State)this.anotherFSM.GetNextState(cpState.twoState,input);

			}
			catch(Exception) {
				twoNext = (State) d.ErrorState;
			}
			
			if(this.crossInput.Contains(input)) {
				if(oneNext!=ErrorState && twoNext != anotherFSM.ErrorState)
					return new DualState(oneNext,twoNext);
				else return this.ErrorState;
			}
			//is in one
			if(this.aFSM.InputAlphabet.Contains(input)) {
				if(oneNext!= this.aFSM.ErrorState)
					return new DualState(oneNext,cpState.twoState);
				else return this.ErrorState;
			}
			//is in two
			if(this.anotherFSM.InputAlphabet.Contains(input)) {
				if(twoNext != this.anotherFSM.ErrorState)
					return new DualState(cpState.oneState,twoNext);
				else return this.ErrorState;
			}
			return this.ErrorState;
		}
		


		/// <summary>
		/// The Startstate of the FiniteShuffleProductMaschineLazy
		/// </summary>
		public override IState StartState {
			get {
				return new DualState(this.aFSM.StartState,this.anotherFSM.StartState);
			}
		}


		/// <summary>
		/// Delivers the next reachable <code>Transition</code> with the given parameters
		/// </summary>
		/// <param name="state">The sourceState for the new <code>Transition</code></param>
		/// <param name="input">The<code>Input</code>for the <code>Transition</code></param>
		/// <returns>The <code>Transition</code> which is reachable</returns>
		public override Transition GetNextTransition(IState aState, Input input) {
			if(aState is DualState== false)
				throw new InvalidStateException();
			DualState cpState = (DualState) aState;
			return new Transition(cpState,input, this.GetNextState(cpState,input));
		}


		/// <summary>
		/// Delivers all reachable Transitions from the given <code>DualState</code>
		/// </summary>
		/// <param name="aState">The State from which all transition should be delivered</param>
		/// <returns>A<code>Hashtable</code> with all reachale Transitions</returns>
		public override IList GetOutgoingTransitions(IState aState) {
			if(aState is DualState == false)
				throw new InvalidStateException();
			IList transitionList = new ArrayList();
			DualState cpState = (DualState) aState;
			foreach(Input input in this.inputAl) {
				if(this.GetNextState(cpState,input)!=this.ErrorState) {
					Transition newTransition = new Transition(cpState,input,this.GetNextState(cpState,input));
					transitionList.Add(newTransition);
				}
			}
			return transitionList;
		}


		/// <summary>
		/// Delivers all Transitions of the FiniteShuffleProductMaschineLazy.
		/// Note: For this the whole Maschine has to be explored.
		/// </summary>
		/// <returns>A Array which contains all Transitions</returns>
		public Transition[] GetTransitions() {
			Hashtable transitions = new Hashtable();

			this.visitedStates = new Set();
			Stack oneStates = new Stack();
			Stack twoStates = new Stack();
			Set spInput = this.inputAl;
			DualState startState = new DualState(aFSM.StartState,anotherFSM.StartState);
			oneStates.Push(aFSM.StartState);
			twoStates.Push(anotherFSM.StartState);
			bool iterated = false;
			while(oneStates.Count!= 0 && twoStates.Count!=0) {
				State oneBefore = (State) oneStates.Pop();
				State twoBefore = (State) twoStates.Pop();
				DualState fromState = new DualState(oneBefore,twoBefore);
				foreach(DualState s in this.visitedStates) {
					if(s.oneState == fromState.oneState)
						if(s.twoState == fromState.twoState)
							iterated = true;

				}
				//the fromState has already been explored
				if(iterated) {
					continue;
				}
				DualState toState = new DualState();
				this.GenerateInput();
				State oneNext;
				State twoNext;
				foreach(Input input in this.inputAl) {
					this.visitedStates.Add(fromState);
					try {
						oneNext = (State)this.aFSM.GetNextState(oneBefore,input);
					}
					catch(Exception){
						oneNext = (State) this.aFSM.ErrorState;
					}
					try {
						twoNext = (State)this.anotherFSM.GetNextState(twoBefore,input);
					}
					catch(Exception) {
						twoNext = (State) this.anotherFSM.ErrorState;
					}
					if(this.crossInput.Contains(input)) {
						//act like FCP
						if(oneNext != this.aFSM.ErrorState && twoNext!= anotherFSM.ErrorState) {
							transitions.Add(new Transition(fromState,input,new DualState(oneNext,twoNext)),
								new Transition(fromState,input,new DualState(oneNext,twoNext)));
							oneStates.Push(oneNext);
							twoStates.Push(twoNext);
							continue;
						}
						else
							//Errorstate
							continue;
					}
					if(this.aFSM.InputAlphabet.Contains(input)) {
						if(oneNext != aFSM.ErrorState) {

							transitions.Add(new Transition(fromState,input,new DualState(oneNext,fromState.twoState)),
								new Transition(fromState,input,new DualState(oneNext,fromState.twoState)));
							oneStates.Push(oneNext);
							twoStates.Push(fromState.twoState);
							continue;
						}
						else
							//ErrorState
							continue;
					}
					if(this.anotherFSM.InputAlphabet.Contains(input)) {
						if(twoNext != anotherFSM.ErrorState) {
							transitions.Add(new Transition(fromState,input,new DualState(fromState.oneState,twoNext)),
								new Transition(fromState,input,new DualState(fromState.oneState,twoNext)));
							oneStates.Push(fromState.oneState);
							twoStates.Push(twoNext);
							continue;
						}
						else
							//ErrorState
							continue;
					}
				}
			}
			Transition[] allTransitions = new Transition[transitions.Count];
			int indexer = 0;
			foreach(DictionaryEntry dic in transitions) {
				allTransitions[indexer] = (Transition) dic.Key;
				indexer++;
			}
			return allTransitions;
		}

	}
}
