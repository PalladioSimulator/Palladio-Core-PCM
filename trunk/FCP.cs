using System;
using System.Collections;

namespace FSM
{
	/// <summary>
	/// Zusammenfassung für FCP.
	/// </summary>
	public class FCP
	{
		protected FSM cp;
		protected Set CPInput;
		protected Stack oneStates;
		protected Stack twoStates;
		protected bool debug  = !true;
		/// <summary>
		/// Initaites a empty FCP
		/// </summary>
		public FCP()
		{
		}
		/// <summary>
		/// Initiates a FCP and generates the crossprodukt of the two given FSMs
		/// </summary>
		/// <param name="one">the first FSM</param>
		/// <param name="two">the other FSM, together with one they are used to
		/// create the crossprodukt></param>
		public FCP(FSM one, FSM two)
		{
				this.cp = generateCP(one,two);
		}
		/// <summary>
		/// Returns the cp FSM 
		/// </summary>
		/// <returns></returns>
		public FSM getCP()
		{
			return this.cp;
		}
		/// <summary>
		/// Cenerates the crossprodukt from two given FSMs
		/// </summary>
		/// <param name="one">the first FSM</param>
		/// <param name="two">the second FSM</param>
		/// <returns>the cp of the two FSM</returns>
		public FSM generateCP(FSM one, FSM two)
		{
			try
			{

				this.cp = new FSM();
				this.oneStates = new Stack();
				this.twoStates = new Stack();
				generateCPInput(one,two);
				if(this.debug)
				{
					Console.WriteLine("CP Input: ");
					this.printInput();
				}
				CPState StartState = new CPState(one.getStartState(),two.getStartState());
				this.oneStates.Push(one.getStartState());
				this.twoStates.Push(two.getStartState());
				while(this.oneStates.Count!= 0 && this.twoStates.Count!=0)
				{

					State oneBefore = (State) this.oneStates.Pop();
					State twoBefore = (State) this.twoStates.Pop();

					foreach(Input i in this.CPInput)
					{
						State oB = null;
						State tB = null;
						//look for next states
						foreach(State s in one.getStates())
						{
							if(s.Equals(oneBefore))
							{
								oB = s;
								break;
							}
						}
						State oneNext = one.getNextState(oB,i);
						if(this.debug)
							Console.WriteLine("oneNext is: "+oneNext.ToString());

						foreach(State s in two.getStates())
						{
							if(s.Equals(twoBefore))
							{
								tB = s;
								break;
							}
						}
						State twoNext = two.getNextState(tB,i);
						if(this.debug)
							Console.WriteLine("twoNext is: "+twoNext.ToString());
					
						if(selfPointing(one,oB,i)& selfPointing(two,tB,i)&&
							!oneNext.Equals(one.ErrorState) && !twoNext.Equals(two.ErrorState))
						{
							//Console.WriteLine("Both Selfpointing");
							CPState sps = new CPState(oneNext,twoNext);
							this.cp.setTransition(sps.getState(),i,sps.getState());
							continue;
						}
						if(!oneNext.Equals(one.ErrorState)&&
							!twoNext.Equals(two.ErrorState))
						{

							//						Console.WriteLine("---------------------");
							//						Console.WriteLine("this is what i Put: "+oneNext.ToString()
							//							+" "+twoNext.ToString());
							//						Console.WriteLine("----------------------------");

							CPState fromState = new CPState(oB, tB);
							if(this.debug)
								Console.WriteLine("CPState fromState: "+fromState.getState().ToString());
							CPState toState = new CPState(oneNext,twoNext);
							if(this.debug)
								Console.WriteLine("CPState toState is: "+toState.getState().ToString()); 
							this.cp.setTransition(fromState.getState(),i,toState.getState());
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
			}
			catch
			{
				return new FSM();
			}
		}
		/// <summary>
		/// Checks if one state with an given input is selfpointing
		/// </summary>
		/// <param name="fsm">A FSM witch state and input should be checked</param>
		/// <param name="state">the state witch should be checked</param>
		/// <param name="i">the inpt </param>
		/// <returns>true if it is selfpointing, false if not</returns>
		protected bool selfPointing(FSM fsm, State state, Input i)
		{
			//Console.WriteLine("Checking selfPointing");
			State temp = null;
			foreach(State s in fsm.getStates())
			{
				if(s.Equals(state))
				{
					temp = s;
					break;
				}
			}

			State t = fsm.getNextState(temp,i);
			if (t.Equals(state))
				return true;
			return false;
		}
		/// <summary>
		/// Generates the cross input of two FSMs 
		/// </summary>
		/// <param name="one">the first FSM</param>
		/// <param name="two">the second FSM</param>
		protected void generateCPInput(FSM one, FSM two)
		{
			this.CPInput = new Set();
			foreach(Input i in one.getInputAl())
			{
				foreach(Input p in two.getInputAl())
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
		public void printInput()
		{
			foreach(Input i in this.CPInput)
				Console.WriteLine(i.ToString());
		}

	}
}
