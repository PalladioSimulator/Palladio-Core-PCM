using System;
using System.Collections;
using Utils.Collections;


namespace FiniteStateMachines.Decorators
{
	/// <summary>
	/// The FiniteShuffleProductMaschine (FSP) is a specialization of a normal FSM. Is generated out
	/// of two FSMs. 
	/// 
	/// def!!!
	/// 
	/// </summary>
	public class FiniteShuffleProductMaschine 
	{
		/// <summary>
		/// The first FiniteTabularMachine which is used to generate the FiniteShuffleProductMaschine
		/// </summary>
		protected FiniteTabularMachine one;

		/// <summary>
		/// The second FiniteTabularProcuctMachine which is used to generate the FiniteShuffleProductMaschine
		/// </summary>
		protected FiniteTabularMachine two;

		/// <summary>
		/// The generates FiniteShuffleProductMaschine stored in a FiniteTabularMachine
		/// </summary>
		protected FiniteTabularMachine sp;

		/// <summary>
		/// it is important to know, when genrating the FiniteShuffleProductMaschine which 
		/// States has already been visited. Is is stored here in a Set.
		/// </summary>
		protected Set visitedStates;

		/// <summary>
		/// The cross Input of the FiniteShuffleProductMaschine stored in a <code>Set</code>
		/// </summary>
		protected Set crossInput;

		/// <summary>
		/// Initiates an empty FiniteShuffleProductMaschine
		/// </summary>
		public FiniteShuffleProductMaschine()
		{
		}


		/// <summary>
		/// Generates a FiniteShuffleProductMaschine with tow given FinitTabularStateMachines
		/// </summary>
		/// <param name="one">The first FinitStateMaschine</param>
		/// <param name="two">The second FiniteStatesMaschine</param>
		public FiniteShuffleProductMaschine(FiniteTabularMachine one, FiniteTabularMachine two)
		{
			this.sp = GenerateFSP(one,two);
		}


		/// <summary>
		/// Returns the generated FiniteShuffleProductMaschine in a FiniteTabularMachine
		/// </summary>
		/// <returns></returns>
		public FiniteTabularMachine ShuffleProduct
		{
			get
			{
				return this.sp;
			}
		}


		/// <summary>
		/// Returns the ErrorState of the FiniteShuffleProductMaschine
		/// </summary>
		public AbstractState ErrorState
		{
			get { return new DualState(one.ErrorState,two.ErrorState); }
		}


		/// <summary>
		/// Generates the FiniteShuffleProductMaschine from two given FiniteStatesMaschines
		/// </summary>
		/// <param name="one">The first FiniteStateMaschine</param>
		/// <param name="two">The second FinteStateMaschine</param>
		/// <returns>The generates FiniteShuffleProductMaschine</returns>
		public FiniteTabularMachine GenerateFSP(FiniteTabularMachine one, FiniteTabularMachine two)
		{
			
			this.one = one;
			this.two = two;
			this.sp = new FiniteTabularMachine();
			this.visitedStates = new Set();
			Stack oneStates = new Stack();
			Stack twoStates = new Stack();
			Set spInput = GenerateSpInput(one,two);
			DualState startState = new DualState(one.StartState,two.StartState);
			oneStates.Push(one.StartState);
			twoStates.Push(two.StartState);
			bool iterated = false;
			while(oneStates.Count!= 0 && twoStates.Count!=0)
			{
				State oneBefore = (State) oneStates.Pop();
				State twoBefore = (State) twoStates.Pop();
				
				DualState fromState = new DualState(oneBefore,twoBefore);
				
				foreach(DualState s in this.visitedStates)
				{
					if(s.oneState == fromState.oneState)
						if(s.twoState == fromState.twoState)
							iterated = true;
				}
				//the fromState has already been explored
				if(iterated)
				{
					continue;
				}
				DualState toState = new DualState();
				foreach(Input input in this.GenerateSpInput(this.one,this.two))
				{
					this.visitedStates.Add(fromState);
					State oneNext = (State) this.one.GetNextState(oneBefore,input);
					State twoNext = (State) this.two.GetNextState(twoBefore,input);
					if(this.crossInput.Contains(input))
						//act like FCP
					{
						if(oneNext != this.one.ErrorState && twoNext!= two.ErrorState)
						{
							this.sp.addTransition(fromState,input,new DualState(oneNext,twoNext));
							oneStates.Push(oneNext);
							twoStates.Push(twoNext);
							continue;
						}
						else
							//Errorstate
							continue;
					}
					if(this.one.InputAlphabet.Contains(input))
					{
						if(oneNext != one.ErrorState)
						{
							this.sp.addTransition(fromState,input,new DualState(oneNext,fromState.twoState));
							oneStates.Push(oneNext);
							twoStates.Push(fromState.twoState);
							continue;
						}
						else
							//ErrorState
							continue;
					}
					if(this.two.InputAlphabet.Contains(input))
					{
						if(twoNext !=two.ErrorState)
						{
							this.sp.addTransition(fromState,input,new DualState(fromState.oneState,twoNext));
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
			return this.sp;
		}			
	

		/// <summary>
		/// Generates the inputalphabet for the FiniteShuffleProductMaschine from the inputalphabets
		/// of the two given FiniteStateMaschines.
		/// </summary>
		/// <param name="one">The first FiniteStateMaschine </param>
		/// <param name="two">The second FiniteStateMaschine</param>
		/// <returns>The genrated Input stored in a Set</returns>
		protected Set GenerateSpInput(FiniteTabularMachine one, FiniteTabularMachine two)
		{
			GenerateCrossInput();
			Set spInput = new Set();
			Set oneInput = one.InputAlphabet;
			Set twoInput = two.InputAlphabet;
			foreach(Input i in oneInput)
				spInput.Add(i);
			foreach(Input i in twoInput)
				spInput.Add(i);
			return spInput;
		}


		/// <summary>
		/// Generates a Set which only contains the input elements which are in both FinateStatesmaschines
		/// (intersection of the input of the two given FiniteStatesMaschines)
		/// </summary>
		protected void GenerateCrossInput()
		{
			this.crossInput = new Set();
			foreach(Input i in one.InputAlphabet)
			{
				foreach(Input p in two.InputAlphabet)
					if(p.Equals(i))
					{
						this.crossInput.Add((Input) i);
					}
			}
		}
	}
}
