using System;
using System.Collections;
using Utils.Collections;


namespace FiniteStateMachines.Decorators {
	/// <summary>
	/// Zusammenfassung für FCPLazy.
	/// </summary>
	public class FCPLazy : IFiniteStateMachine {
		protected AbstractState errorState;
		protected FiniteTabularMachine one;
		protected FiniteTabularMachine two;
		protected bool InputCreated;
		protected Set inputAl;
		protected bool TransitionsCreated;
		public Hashtable Transitions;
		protected bool debug = false;
		protected Set States;
		protected Set finalStates;
		protected bool finalCreated = false;


		public FCPLazy(FiniteTabularMachine one, FiniteTabularMachine two) {
			this.InputCreated = false;
			this.TransitionsCreated = false;
			this.one = one;
			this.two = two;
		}
		public AbstractState ErrorState {
			get { return new CPState(one.ErrorState,two.ErrorState); }
		}
		public Set InputAlphabet {
			get {
				if(!this.InputCreated)
					generateCPInput(this.one,this.two);
				return this.inputAl;
			}
		}
		protected void generateCPInput(FiniteTabularMachine one, FiniteTabularMachine two) {
			this.InputCreated = true;
			this.inputAl = new Set();
			foreach(Input i in one.InputAlphabet) {
				foreach(Input p in two.InputAlphabet)
					if(p.Equals(i)) {
						this.inputAl.Add((Input) i);
					}
			}	
		}
		/// <summary>
		/// doesn't work jet.
		/// </summary>
		/// <returns></returns>
		//		public Set GetStates()
		//		{
		//			this.States = new Set();
		//
		//			foreach(Transition tr in this.getTransitions())
		//			{
		//
		//
		//				if(tr.toState != this.errorState) //&& !this.States.Contains(tr.toState))
		//				{
		//					
		//					if(!this.States.Contains(tr.toState))
		//					{
		//						this.States.Add(tr.toState);
		//						
		//					}
		////					Console.WriteLine("I just added "+tr.toState.ToString());
		//				}
		//				if(tr.fromState != this.errorState )//&& !this.States.Contains(tr.fromState))
		//				{
		//					if(!this.States.Contains(tr.fromState))
		//					
		//					this.States.Add(tr.fromState);
		////					Console.WriteLine("I just added "+tr.fromState.ToString());
		//				}
		//
		//			}
		//
		//			return this.States;
		//		}
					
					
		public AbstractState GetNextState(AbstractState stateI,Input i) {
			if(stateI  is CPState == false)
				throw new InvalidStateException();
			
			CPState state = (CPState) stateI;
			if(this.InputAlphabet.Contains(i)== false)
				throw new InvalidInputException();

			AbstractState OneNext = this.one.GetNextState(state.oneState,i);
			if(OneNext == this.one.ErrorState) {
				return this.ErrorState;
			}
			AbstractState TwoNext = this.two.GetNextState(state.twoState,i);
			if(TwoNext == this.two.ErrorState) {
				return this.ErrorState;
			}


			return new CPState(OneNext,TwoNext);

		}
		public AbstractState StartState {
			get {return new CPState(this.one.StartState,this.two.StartState);}
		}

		public Hashtable GetOutgoingTransitions(AbstractState state) {
			if(state is CPState == false)
				throw new InvalidStateException();

			Hashtable TransitionMap = new Hashtable();
			AbstractState NextState = null;
			foreach(Input i in this.InputAlphabet) {
				NextState = this.GetNextState(state, i);
				if(!NextState.Equals(this.ErrorState))
					TransitionMap.Add(NextState as CPState,NextState as CPState);
			}
			return TransitionMap;
		}
		/// <summary>
		/// da muss noch was gemacht werden !
		/// </summary>
		/// <returns></returns>
		public Transition[] GetTransitions() {
			if(!this.TransitionsCreated)
				CreateTransitions();

			Transition[] TransitionsArray = new Transition[this.Transitions.Count];
			int i = 0;
			foreach(DictionaryEntry dic in this.Transitions) {
				TransitionsArray[i] = (Transition) dic.Value;
				i++;
			}
			return TransitionsArray;
		}
		protected void CreateTransitions() {
			this.TransitionsCreated = true;
			this.Transitions = new Hashtable();
			//			this.cp = new FSM();
			Stack oneStates = new Stack();
			Stack twoStates = new Stack();

			//++++++++++++Wie war das mit der leeren Transition, die zum stsrtstae führt, muss da
			//			da hier auch was gemacht werden?
			//			CPState StartState = new CPState(one.getStartState,two.getStartState);
			oneStates.Push(one.StartState);
			twoStates.Push(two.StartState);
			while(oneStates.Count!= 0 && twoStates.Count!=0) {

				AbstractState oneBefore = (AbstractState) oneStates.Pop();
				AbstractState twoBefore = (AbstractState) twoStates.Pop();

				foreach(Input i in this.InputAlphabet) {


					AbstractState oneNext = one.GetNextState(oneBefore,i);
					if(this.debug)
						Console.WriteLine("oneNext is: "+oneNext.ToString());
					
					AbstractState twoNext = two.GetNextState(twoBefore,i);
					if(this.debug)
						Console.WriteLine("twoNext is: "+twoNext.ToString());
					
					if(selfPointing(one,oneBefore,i)&& selfPointing(two,twoBefore,i)&&
						!oneNext.Equals(one.ErrorState) && !twoNext.Equals(two.ErrorState)) {

						CPState sps = new CPState(oneNext,twoNext);
						//						Console.WriteLine("in selfpointing folling transition set: "+"\n"
						//							+new Transition(sps.getState(),i,sps.getState()));
						//this.cp.setTransition(sps.getState(),i,sps.getState());
						
						this.Transitions.Add(new Transition(sps,i,sps),new Transition(sps,i,sps));
						//						Console.WriteLine("fcpLazy createTransitions: I just added the transition: "+"\n"+
						//							new Transition(sps.getState(),i,sps.getState()).ToString());

						oneStates.Pop();
						twoStates.Pop();
						continue;
					}
					if(!oneNext.Equals(one.ErrorState)&&
						!twoNext.Equals(two.ErrorState)) {

						CPState fromState = new CPState(oneBefore, twoBefore);
						CPState toState = new CPState(oneNext,twoNext);
			
						//						Console.WriteLine("both sre! ES following transition added: " +"\n" 
						//							+ new Transition(fromState.getState(),i,toState.getState()));
						this.Transitions.Add(new Transition(fromState,i,toState),
							new Transition(fromState,i,toState));
						//						Console.WriteLine("I jsut added to this.transitions: "
						//							+new Transition(fromState.getState(),i,toState.getState()));
						//this.cp.setTransition(fromState.getState(),i,toState.getState());
						oneStates.Push(oneNext);
						twoStates.Push(twoNext);
						
					}

					else {
					
					}
			
				}
			}
		}
		
		public Set FinalStates {
			get {
				if(this.finalCreated == false) {
					Set OneFinal = this.one.FinalStates;
					Set TwoFinal = this.two.FinalStates;

					this.finalStates = new Set();
					//CPState FinalState = new CPState();

					foreach(AbstractState ofs in OneFinal) {
						foreach(AbstractState tfs in TwoFinal) {
							this.finalStates.Add(new CPState(ofs,tfs));
						}
					}
				}
				return this.finalStates;
			}
		}
		public Transition GetNextTransition(AbstractState state, Input i) {
			if(state is CPState== false)
				throw new InvalidStateException();
			//			CPState state = new CPState(state);
			if(!this.InputAlphabet.Contains(i))
				throw new InvalidInputException();

			//			return new Transition(new CPState(state.oneState,state.twoState),i
			//				,new CPState(one.getNextState(state.oneState,i),two.getNextState(state.twoState,i)));
			return new Transition(state,i,this.GetNextState(state,i));
		}


		/// <summary>
		/// Checks if one state with an given input is selfpointing
		/// </summary>
		/// <param name="fsm">A FSM witch state and input should be checked</param>
		/// <param name="state">the state witch should be checked</param>
		/// <param name="i">the inpt </param>
		/// <returns>true if it is selfpointing, false if not</returns>
		protected bool selfPointing(FiniteTabularMachine fsm, AbstractState state, Input i) {
			//Console.WriteLine("Checking selfPointing");
			AbstractState temp = null;
			foreach(AbstractState s in fsm.States) {
				if(s.Equals(state)) {
					temp = s;
					break;
				}
			}

			AbstractState t = fsm.GetNextState(temp,i);
			if (t.Equals(state))
				return true;
			return false;
		}

	}
}
