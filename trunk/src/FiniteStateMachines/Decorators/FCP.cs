using System;
using System.Collections;
using Utils.Collections;

namespace FiniteStateMachines.Decorators {
	/// <summary>
	/// Zusammenfassung für FCP.
	/// </summary>
	public class FCP {
		protected FiniteTabularMachine cp;
		protected Set CPInput;
		protected Stack oneStates;
		protected Stack twoStates;
		protected bool debug  = !true;
		/// <summary>
		/// Initaites a empty FCP
		/// </summary>
		public FCP() {
		}
		/// <summary>
		/// Initiates a FCP and generates the crossprodukt of the two given FSMs
		/// </summary>
		/// <param name="one">the first FSM</param>
		/// <param name="two">the other FSM, together with one they are used to
		/// create the crossprodukt></param>
		public FCP(FiniteTabularMachine one, FiniteTabularMachine two) {
			this.cp = generateCP(one,two);
		}
		/// <summary>
		/// Returns the cp FSM 
		/// </summary>
		/// <returns></returns>
		public FiniteTabularMachine getCP() {
			return this.cp;
		}
		/// <summary>
		/// Cenerates the crossprodukt from two given FSMs
		/// </summary>
		/// <param name="one">the first FSM</param>
		/// <param name="two">the second FSM</param>
		/// <returns>the cp of the two FSM</returns>
		public FiniteTabularMachine generateCP(FiniteTabularMachine one, FiniteTabularMachine two) {
			//			try
			//			{

			this.cp = new FiniteTabularMachine();
			this.oneStates = new Stack();
			this.twoStates = new Stack();
			generateCPInput(one,two);
			if(this.debug) {
				Console.WriteLine("CP Input: ");
				this.printInput();
			}
			CPState StartState = new CPState(one.StartState,two.StartState);
			this.oneStates.Push(one.StartState);
			this.twoStates.Push(two.StartState);
			while(this.oneStates.Count!= 0 && this.twoStates.Count!=0) {

				AbstractState oneBefore = (AbstractState) this.oneStates.Pop();
				AbstractState twoBefore = (AbstractState) this.twoStates.Pop();

				foreach(Input i in this.CPInput) {


					AbstractState oneNext = one.GetNextState(oneBefore,i);
					if(this.debug)
						Console.WriteLine("oneNext is: "+oneNext.ToString());


					AbstractState twoNext = two.GetNextState(twoBefore,i);
					if(this.debug)
						Console.WriteLine("twoNext is: "+twoNext.ToString());
					
					if(selfPointing(one,oneBefore,i)&& selfPointing(two,twoBefore,i)&&
						!oneNext.Equals(one.ErrorState) && !twoNext.Equals(two.ErrorState)) {
						//Console.WriteLine("Both Selfpointing");
						CPState sps = new CPState(oneNext,twoNext);
						//							if(this.cp.getAllTransitionHashtable().Contains(new Transition(sps.getState(),i,sps.getState())))
						//							{
						//								Console.Write("es geht");
						//								continue;
						//							}
						Console.WriteLine("in selfpointing folling transition set: "+"\n"
							+new Transition(sps,i,sps));
						this.cp.addTransition(sps,i,sps);
						this.oneStates.Pop();
						this.twoStates.Pop();
						continue;
					}
					if(!oneNext.Equals(one.ErrorState)&&
						!twoNext.Equals(two.ErrorState)) {

						CPState fromState = new CPState(oneBefore, twoBefore);
						if(this.debug)
							Console.WriteLine("CPState fromState: "+fromState.getState().ToString());
						CPState toState = new CPState(oneNext,twoNext);
						if(this.debug)
							Console.WriteLine("CPState toState is: "+toState.getState().ToString());
						Console.WriteLine("both sre! ES following transition added: " +"\n" 
							+ new Transition(fromState.getState(),i,toState.getState()));
						this.cp.addTransition(fromState.getState(),i,toState.getState());
						this.oneStates.Push(oneNext);
						this.twoStates.Push(twoNext);
						if(this.debug) {
							Console.WriteLine("I put one oneStates: "+oneNext.ToString());
							Console.WriteLine("I put on twoStates: "+twoNext.ToString());
						}
					}

					else {
					
					}
			
				}

			}
			return this.cp;
			//			}
			//			catch
			//			{
			//				return new FSM();
			//			}

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
		/// <summary>
		/// Generates the cross input of two FSMs 
		/// </summary>
		/// <param name="one">the first FSM</param>
		/// <param name="two">the second FSM</param>
		protected void generateCPInput(FiniteTabularMachine one, FiniteTabularMachine two) {
			this.CPInput = new Set();
			foreach(Input i in one.InputAlphabet) {
				foreach(Input p in two.InputAlphabet)
					if(p.Equals(i)) {
						//Console.WriteLine("I just added in CPInput: "+i.ToString());
						this.CPInput.Add((Input) i);
					}
			}
		}
		/// <summary>
		/// for debugging prints the cp Input
		/// </summary>
		public void printInput() {
			foreach(Input i in this.CPInput)
				Console.WriteLine(i.ToString());
		}

	}
}
