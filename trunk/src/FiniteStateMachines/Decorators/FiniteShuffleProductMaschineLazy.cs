using System;
using System.Collections;
using Utils.Collections;

namespace FiniteStateMachines.Decorators
{
	/// <summary>
	/// Represents a FiniteShuffleProductMaschine. But when creating a new FiniteShuffleProductMaschineLazy
	/// not all States has to be explored. 
	/// </summary>
	public class FiniteShuffleProductMaschineLazy : IFiniteStateMachine
	{
		protected bool inputGenerated;
		public Set inputAl;
		public Set crossInput;
		protected Set visitedStates;
		protected FiniteTabularMachine aFSM;
		protected FiniteTabularMachine anotherFSM;
		/// <summary>
		/// Creates a FiniteShuffleProductMaschineLazy
		/// </summary>
		/// <param name="one">A <code>FiniteTabularMaschine</code></param>
		/// <param name="two">Another <code>FiniteTabularMaschine</code></param>
		public FiniteShuffleProductMaschineLazy(FiniteTabularMachine aFSM, FiniteTabularMachine anotherFSM)
		{
			this.aFSM = aFSM;
			this.anotherFSM = anotherFSM;
			
		}
		
		//		old
		//		public Set getInputAl()
		//		{
		//			if(!this.inputGenerated)
		//				GenerateInput();
		//			return this.inputAl;
		//		}
		/// <summary>
		/// Returns the InputAlphabet of the FiniteShuffleProductMaschineLazy in a <code>Set</code>
		/// </summary>
		public Set InputAlphabet
		{
			get
			{
				if(!this.inputGenerated)
					GenerateInput();
				return this.inputAl;
			}
		}
		/// <summary>
		/// Generates a Set which only contains the input elements which are in both <code>FiniteTabularMaschine</code>
		/// (intersection of the input of the two given FiniteStatesMaschines)
		/// </summary>
		protected void GenerateCrossInput()
		{
			this.crossInput = new Set();
			foreach(Input i in aFSM.InputAlphabet)
			{
				foreach(Input p in anotherFSM.InputAlphabet)
					if(p.Equals(i))
					{
						this.crossInput.Add((Input) i);
					}
			}
		}
		/// <summary>
		/// Generates the inputalphabet for the FiniteShuffleProductMaschine from the inputalphabets
		/// of the two given FiniteStateMaschines.
		/// </summary>
		protected void GenerateInput()
		{
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
		/// Represents the ErrorState of the FiniteShuffleProductMaschine
		/// </summary>
		public AbstractState ErrorState
		{
			get { return new DualState(this.aFSM.ErrorState,anotherFSM.ErrorState);}
		}
		//		/// <summary>
		//		/// old:
		//		/// Represents the FinalStates of a FiniteShuffleProductMaschineLazy in a <code>Set</code>
		//		/// </summary>
		//		/// <returns>A <code>Set</code> with final States</returns>
		//		public Set getFinalStates()
		//		{
		//			Set finalStates = new Set();
		//			foreach(State oneFinal in this.aFSM.FinalStates)
		//			{
		//				foreach(State twoFinal in this.anotherFSM.FinalStates)
		//				{
		//					if(oneFinal.IsFinalState &&  twoFinal.IsFinalState)
		//						finalStates.Add(new DualState(oneFinal,twoFinal));
		//				}
		//			}
		//			return finalStates;
		//		}
		/// <summary>
		/// Represents the FinalStates of a FiniteShuffleProductMaschineLazy in a <code>Set</code>
		/// </summary>
		public Set FinalStates
		{
			
			get
			{
				Set finalStates = new Set();
				foreach(State oneFinal in this.aFSM.FinalStates)
				{
					foreach(State twoFinal in this.anotherFSM.FinalStates)
					{
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
		public AbstractState GetNextState(AbstractState aState, Input input)
		{
			if(aState is DualState == false)
				throw new InvalidStateException();
			DualState cpState = (DualState) aState;
			State oneNext = (State)this.aFSM.GetNextState(cpState.oneState,input);
			State twoNext = (State)this.anotherFSM.GetNextState(cpState.twoState,input);

			if(this.crossInput.Contains(input))
			{
				if(oneNext!=ErrorState && twoNext != anotherFSM.ErrorState)
					return new DualState(oneNext,twoNext);
				else return this.ErrorState;
			}
			//is in one
			if(this.aFSM.InputAlphabet.Contains(input))
			{
				if(oneNext!= this.aFSM.ErrorState)
					return new DualState(oneNext,cpState.twoState);
				else return this.ErrorState;
			}
			//is in two
			if(this.anotherFSM.InputAlphabet.Contains(input))
			{
				if(twoNext != this.anotherFSM.ErrorState)
					return new DualState(cpState.oneState,twoNext);
				else return this.ErrorState;
			}
			return this.ErrorState;
		}
		//		old:
		//		public AbstractState getStartState()
		//		{
		//			return new DualState(this.aFSM.StartState,this.anotherFSM.StartState);
		//		}
		/// <summary>
		/// The Startstate of the FiniteShuffleProductMaschineLazy
		/// </summary>
		public AbstractState StartState
		{
			get
			{
				return new DualState(this.aFSM.StartState,this.anotherFSM.StartState);
			}
		}
		/// <summary>
		/// Delivers the next reachable <code>Transition</code> with the given parameters
		/// </summary>
		/// <param name="state">The sourceState for the new <code>Transition</code></param>
		/// <param name="input">The<code>Input</code>for the <code>Transition</code></param>
		/// <returns>The <code>Transition</code> which is reachable</returns>
		public Transition GetNextTransition(AbstractState aState, Input input)
		{
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
		public IList GetOutgoingTransitions(AbstractState aState)
		{
			if(aState is DualState == false)
				throw new InvalidStateException();
			IList transitionList = new ArrayList();
			DualState cpState = (DualState) aState;
			foreach(Input input in this.inputAl)
			{
				if(this.GetNextState(cpState,input)!=this.ErrorState)
				{
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
		public Transition[] GetTransitions()
		{
			Hashtable transitions = new Hashtable();

			this.visitedStates = new Set();
			//stachs to iterate
			Stack oneStates = new Stack();
			Stack twoStates = new Stack();

			Set spInput = this.inputAl;

			DualState startState = new DualState(aFSM.StartState,anotherFSM.StartState);

			oneStates.Push(aFSM.StartState);
			twoStates.Push(anotherFSM.StartState);
			bool iterated = false;
			while(oneStates.Count!= 0 && twoStates.Count!=0)
			{
				State oneBefore = (State) oneStates.Pop();
				State twoBefore = (State) twoStates.Pop();
				
				DualState fromState = new DualState(oneBefore,twoBefore);
				
				foreach(DualState s in this.visitedStates)
				{
					//if(s.getName() == fromState.getName())
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
				this.GenerateInput();
				foreach(Input input in this.inputAl)
				{
					this.visitedStates.Add(fromState);
					State oneNext = (State)this.aFSM.GetNextState(oneBefore,input);
					State twoNext = (State)this.anotherFSM.GetNextState(twoBefore,input);
					if(this.crossInput.Contains(input))
						//act like FCP
					{
						if(oneNext != this.aFSM.ErrorState && twoNext!= anotherFSM.ErrorState)
						{
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
					if(this.aFSM.InputAlphabet.Contains(input))
					{
						if(oneNext != aFSM.ErrorState)
						{

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
					if(this.anotherFSM.InputAlphabet.Contains(input))
					{
						if(twoNext != anotherFSM.ErrorState)
						{
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
			//init []
			Transition[] allTransitions = new Transition[transitions.Count];
			int indexer = 0;
			foreach(DictionaryEntry dic in transitions)
			{
				allTransitions[indexer] = (Transition) dic.Key;
				indexer++;
			}
			return allTransitions;
		}

	}
}
