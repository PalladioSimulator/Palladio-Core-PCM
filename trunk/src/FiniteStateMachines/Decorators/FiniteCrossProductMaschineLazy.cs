using System;
using System.Collections;
using Utils.Collections;
using Palladio.FiniteStateMachines;


namespace Palladio.FiniteStateMachines.Decorators {
	/// <summary>
	/// Generates a FiniteCrossProduktMaschine. A FiniteCrossProduktMaschine (FSP) is a 
	/// specialization of a normal FSM. The FiniteCrossProduktMaschine is generated from
	/// two FSMs(A,B). And it only contains Transitions and the Inputs which is in both
	/// given FSMs.
	/// But the there is one Difference between a normal FiniteCrossProduktMaschine and
	/// this. The FiniteCrossProduktMaschineLazy implemts <code>IFiniteStateMachine</code>
	/// Interface. The other spezial thing of the FiniteCrossProduktMaschineLazy is that 
	/// when your call its methods, you don't have to visit the whole FSM, only the realted
	/// parts. This will be much faster when you have huge FSMs then creating a normal 
	/// FiniteCrossProduktMaschine.
	/// </summary>
	internal class FiniteCrossProductMaschineLazy : AbstractFSM {
		/// <summary>
		/// The ErrorState
		/// </summary>
		protected IState errorState;

		/// <summary>
		/// The first <code>FiniteTabularMachine</code> form whicch the crossproduct shoukd
		/// be gernerated.
		/// </summary>
		protected IFiniteStateMachine one;

		/// <summary>
		/// The second <code>FiniteTabularMachine</code> form which the crossproduct should
		/// be generated.
		/// </summary>
		protected IFiniteStateMachine two;

		/// <summary>
		/// if the Crossinput is gerated this will be set true, so the next time another
		/// procedure is called.
		/// </summary>
		protected bool InputCreated = false;

		/// <summary>
		/// The crossinput of the two given FSMs stored in a <code>Set</code>
		/// </summary>
		protected Set inputAl;

		/// <summary>
		/// An indicator that shows if the crossprudctMachine has already been greated
		/// </summary>
		protected bool TransitionsCreated;

		/// <summary>
		/// A Hashtable ih which all Transitions of the crossproduct maschine a stored.
		/// </summary>
		public Hashtable Transitions;
		
		/// <summary>
		/// for debugging
		/// </summary>
		protected bool debug = false;

		/// <summary>
		/// All states of the crossproductmaschine stored in a <code>Set</code>.
		/// </summary>
		protected Set States;

		/// <summary>
		/// All FinalSates of the Crossproduct Maschine stored un a <code>Set</code>
		/// </summary>
		protected Set finalStates;

		/// <summary>
		/// A indicator that shows if the Set of finalStates has been already 
		/// created.
		/// </summary>
		protected bool finalCreated = false;



		/// <summary>
		/// Initates an FiniteCrossProduktMaschineLazy with two given <code>FiniteTabularMachine</code>
		/// </summary>
		/// <param name="one"></param>
		/// <param name="two"></param>
		public FiniteCrossProductMaschineLazy(IFiniteStateMachine one, IFiniteStateMachine two) {
			this.InputCreated = false;
			this.TransitionsCreated = false;
			this.finalCreated  = false;
			this.one = one;
			this.two = two;
		}

		/// <summary>
		/// Delivers the Errorstate.
		/// </summary>
		public override IState ErrorState {
			get { return new DualState(one.ErrorState,two.ErrorState); }
		}

		/// <summary>
		/// Returns the Crossinput of the two given FSMs in a Set.
		/// </summary>
		public override Set InputAlphabet {
			get {
				if(!this.InputCreated)
					generateCPInput(this.one,this.two);
				return this.inputAl;
			}
		}


		/// <summary>
		/// Generates the input of the CrossProductMachine. 
		/// </summary>
		/// <param name="one">The first FiniteTabularMachine </param>
		/// <param name="two">the second FiniteTabularMachine</param>
		protected void generateCPInput(IFiniteStateMachine one, IFiniteStateMachine two) {
			Console.WriteLine("Generating CrossInput");
			this.InputCreated = true;
			this.inputAl = new Set();
			foreach(Input i in one.InputAlphabet) 
			{
//				if(two.InputAlphabet.Contains(i))
				foreach(Input p in two.InputAlphabet)
				if(p.ToString().Equals(i.ToString())) 
				{
					this.inputAl.Add( i);
					Console.WriteLine("I just added "+i.ToString());
				}
//					
			}	
		}
		
		/// <summary>
		/// Delivers the next AbstractState from the given State with the given Input.
		/// </summary>
		/// <param name="aState">AbstractState which is the source state, this must be a
		/// <code>DualState>
		///</code>code></param>
		/// <param name="input">the input which should be used to deliver the next state</param>
		/// <returns>The next reachable State</returns>
		public override IState GetNextState(IState aState, Input input) {
			if(aState  is DualState == false)
				throw new InvalidStateException();
			
			DualState state = (DualState) aState;
			if(this.InputAlphabet.Contains(input)== false)
				throw new InvalidInputException();
			IState OneNext;
			IState TwoNext;

			try {
				OneNext = this.one.GetNextState(state.oneState,input);
			}
			catch (Exception) {
				return this.ErrorState;
			}
			try {
				TwoNext = this.two.GetNextState(state.twoState,input);
			}
			catch (Exception) {
				return this.ErrorState;
			}
			return new DualState(OneNext,TwoNext);
		}


		/// <summary>
		/// Returns the Startstate of the FiniteCrossProductMachine,
		/// </summary>
		public override IState StartState {
			get {Console.WriteLine("StartStates are: "+one.StartState+two.StartState);
				return new DualState(this.one.StartState,this.two.StartState);}
		}

		/// <summary>
		/// Delivers all transitions which are reachsable from the given State
		/// </summary>
		/// <param name="state">A DualState from which all Transisiotion should be delivered</param>
		/// <returns>An Vector which contains the computed transitions.</returns>
		public override IList GetOutgoingTransitions(IState state) {
			if(state is DualState == false)
				throw new InvalidStateException();

			IList transitionList = new Vector();
			IState NextState = null;
			foreach(Input i in this.InputAlphabet) {
				try {
					NextState = this.GetNextState(state, i);
				}
				catch(Exception) {
					NextState = this.ErrorState;
				}
				if(!NextState.Equals(this.ErrorState)) {
					ITransition newTransition = new Transition(state,i,NextState);
					transitionList.Add(newTransition);
				}
			}
			return transitionList;
		}


		/// <summary>
		/// Delivers all transitions of the FiniteCrossProductMachine. 
		/// </summary>
		/// <returns>All transitions stored in a ITransition[]</returns>
		public ITransition[] GetTransitions() {
			if(!this.TransitionsCreated)
				CreateTransitions();

			ITransition[] TransitionsArray = new ITransition[this.Transitions.Count];
			int i = 0;
			foreach(DictionaryEntry dic in this.Transitions) {
				TransitionsArray[i] = (ITransition) dic.Value;
				i++;
			}
			return TransitionsArray;
		}

		/// <summary>
		/// 
		/// </summary>
		protected void CreateTransitions() {
			this.TransitionsCreated = true;
			this.Transitions = new Hashtable();
			Stack oneStates = new Stack();
			Stack twoStates = new Stack();
			oneStates.Push(one.StartState);
			twoStates.Push(two.StartState);
			while(oneStates.Count!= 0 && twoStates.Count!=0) {
				IState oneBefore = (IState) oneStates.Pop();
				IState twoBefore = (IState) twoStates.Pop();

				foreach(Input i in this.InputAlphabet) {
					IState oneNext = one.GetNextState(oneBefore,i);
					if(this.debug)
						Console.WriteLine("oneNext is: "+oneNext.ToString());
					
					IState twoNext = two.GetNextState(twoBefore,i);
					if(this.debug)
						Console.WriteLine("twoNext is: "+twoNext.ToString());
					
					if(selfPointing(one,oneBefore,i)&& selfPointing(two,twoBefore,i)&&
						!oneNext.Equals(one.ErrorState) && !twoNext.Equals(two.ErrorState)) {
						DualState sps = new DualState(oneNext,twoNext);
						this.Transitions.Add(new Transition(sps,i,sps),new Transition(sps,i,sps));
						oneStates.Pop();
						twoStates.Pop();
						continue;
					}
					if(!oneNext.Equals(one.ErrorState)&&
						!twoNext.Equals(two.ErrorState)) {
						DualState fromState = new DualState(oneBefore, twoBefore);
						DualState toState = new DualState(oneNext,twoNext);
						this.Transitions.Add(new Transition(fromState,i,toState),
							new Transition(fromState,i,toState));
						oneStates.Push(oneNext);
						twoStates.Push(twoNext);
					}
					else { 
					}
				}
			}
		}
		

		/// <summary>
		/// Returns all finalStates of the crossProductMachine in a <code>Set</code>
		/// </summary>
		public override Set FinalStates {
			get {
				if(this.finalCreated == false) {
					Set OneFinal = this.one.FinalStates;
					Set TwoFinal = this.two.FinalStates;
					this.finalStates = new Set();
					foreach(IState ofs in OneFinal) {
						foreach(IState tfs in TwoFinal) {
							this.finalStates.Add(new DualState(ofs,tfs));
						}
					}
				}
				return this.finalStates;
			}
		}


		/// <summary>
		/// Returns the next transition with the given parameters
		/// </summary>
		/// <param name="state">The souce State for the transition. It muzt be a DualState</param>
		/// <param name="i">The input for the transition</param>
		/// <returns>The ITransition</returns>
		public override ITransition GetNextTransition(IState state, Input i) {
			if(state is DualState== false)
				throw new InvalidStateException();
			if(!this.InputAlphabet.Contains(i))
				throw new InvalidInputException();
			return new Transition(state,i,this.GetNextState(state,i));
		}


		/// <summary>
		/// Checks if one state with an given input is selfpointing (loop checking)
		/// </summary>
		/// <param name="fsm">A FSM which state and input should be checked</param>
		/// <param name="state">The state which should be checked</param>
		/// <param name="i">the input </param>
		/// <returns>true if it is selfpointing, false if not</returns>
		protected bool selfPointing(IFiniteStateMachine fsm, IState state, Input i) {
			return state.Equals(fsm.GetNextState(state,i));
		}
	}
}
