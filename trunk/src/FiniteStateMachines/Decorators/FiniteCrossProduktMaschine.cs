using System;
using System.Collections;
using Utils.Collections;

namespace FiniteStateMachines.Decorators
{
	/// <summary>
	/// Generates a FiniteCrossProduktMaschine.
	/// </summary>
	public class FiniteCrossProduktMaschine 
	{
		protected FiniteTabularMachine cp;
		protected Set CPInput;
		protected Stack oneStates;
		protected Stack twoStates;
		protected bool debug  = !true;


		/// <summary>
		/// Initaites a empty FiniteCrossProduktMaschine
		/// </summary>
		public FiniteCrossProduktMaschine() 
		{
		}


		/// <summary>
		/// Initiates a FiniteCrossProduktMaschine and generates the crossprodukt of the two given 
		/// FiniteTabularMaschines
		/// </summary>
		/// <param name="one">the first FSM</param>
		/// <param name="two">the other FSM, together with one they are used to
		/// create the crossprodukt></param>
		public FiniteCrossProduktMaschine(FiniteTabularMachine aFSM, FiniteTabularMachine anotherFSM) 
		{
			this.cp = GenerateCP(aFSM,anotherFSM);
		}
		/// <summary>
		/// Returns the cp FSM 
		/// </summary>
		/// <returns></returns>
		public FiniteTabularMachine getCP() 
		{
			return this.cp;
		}
		public FiniteTabularMachine CP
		{
			get
			{
				return this.cp;
			}
		}
		/// <summary>
		/// Cenerates the crossprodukt from two given FSMs
		/// </summary>
		/// <param name="one">the first FSM</param>
		/// <param name="two">the second FSM</param>
		/// <returns>the cp of the two FSM</returns>
		public FiniteTabularMachine GenerateCP(FiniteTabularMachine aFSM, FiniteTabularMachine anotherFSM) 
		{
			//			try
			//			{

			this.cp = new FiniteTabularMachine();
			this.oneStates = new Stack();
			this.twoStates = new Stack();
			GenerateCrossProductInput(aFSM,anotherFSM);
			if(this.debug) 
			{
				Console.WriteLine("CP Input: ");
				this.PrintInput();
			}
			DualState StartState = new DualState(aFSM.StartState,anotherFSM.StartState);
			this.oneStates.Push(aFSM.StartState);
			this.twoStates.Push(anotherFSM.StartState);
			while(this.oneStates.Count!= 0 && this.twoStates.Count!=0) 
			{

				AbstractState oneBefore = (AbstractState) this.oneStates.Pop();
				AbstractState twoBefore = (AbstractState) this.twoStates.Pop();

				foreach(Input i in this.CPInput) 
				{


					AbstractState oneNext = aFSM.GetNextState(oneBefore,i);
					if(this.debug)
						Console.WriteLine("oneNext is: "+oneNext.ToString());


					AbstractState twoNext = anotherFSM.GetNextState(twoBefore,i);
					if(this.debug)
						Console.WriteLine("twoNext is: "+twoNext.ToString());
					
					if(LoopChecking(aFSM,oneBefore,i)&& LoopChecking(anotherFSM,twoBefore,i)&&
						!oneNext.Equals(aFSM.ErrorState) && !twoNext.Equals(anotherFSM.ErrorState)) 
					{
						//Console.WriteLine("Both Selfpointing");
						DualState selfPointingState = new DualState(oneNext,twoNext);
						//							if(this.cp.getAllTransitionHashtable().Contains(new Transition(sps.getState(),i,sps.getState())))
						//							{
						//								Console.Write("es geht");
						//								continue;
						//							}
						//						Console.WriteLine("in selfpointing folling transition set: "+"\n"
						//							+new Transition(selfPointingState,i,selfPointingState));
						this.cp.addTransition(selfPointingState,i,selfPointingState);
						this.oneStates.Pop();
						this.twoStates.Pop();
						continue;
					}
					if(!oneNext.Equals(aFSM.ErrorState)&&
						!twoNext.Equals(anotherFSM.ErrorState)) 
					{

						DualState fromState = new DualState(oneBefore, twoBefore);
						if(this.debug)
							Console.WriteLine("CPState fromState: "+fromState.getState().ToString());
						DualState toState = new DualState(oneNext,twoNext);
						if(this.debug)
							Console.WriteLine("CPState toState is: "+toState.getState().ToString());
						//						Console.WriteLine("both sre! ES following transition added: " +"\n" 
						//							+ new Transition(fromState.getState(),i,toState.getState()));
						this.cp.addTransition(fromState.getState(),i,toState.getState());
						this.oneStates.Push(oneNext);
						this.twoStates.Push(twoNext);
						if(this.debug) 
						{
							Console.WriteLine("I put one oneStates: "+oneNext.ToString());
							Console.WriteLine("I put on twoStates: "+twoNext.ToString());
						}
					}

					else 
					{
					
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
		/// Checks if one state with an given input is selfpointing(loop checking)
		/// </summary>
		/// <param name="fsm">A FSM which state and input should be checked</param>
		/// <param name="state">the state which should be checked</param>
		/// <param name="i">the inpt </param>
		/// <returns>true if it is selfpointing, false if not</returns>
		protected bool LoopChecking(FiniteTabularMachine fsm, AbstractState state, Input i) 
		{
			//Console.WriteLine("Checking selfPointing");

			return state == fsm.GetNextState(state,i);
			AbstractState temp = null;
			foreach(AbstractState s in fsm.States) 
			{
				if(s.Equals(state)) 
				{
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
		protected void GenerateCrossProductInput(FiniteTabularMachine one, FiniteTabularMachine two) 
		{
			this.CPInput = new Set();
			foreach(Input i in one.InputAlphabet) 
			{
				foreach(Input p in two.InputAlphabet)
					if(p.Equals(i)) 
					{
						//Console.WriteLine("I just added in CPInput: "+i.ToString());
						this.CPInput.Add((Input) i);
					}
			}
		}
		/// <summary>
		/// for debugging prints the cp Input
		/// </summary>
		public void PrintInput() 
		{
			foreach(Input i in this.CPInput)
				Console.WriteLine(i.ToString());
		}

	}
}
