using System;
using System.Collections;
using System.Xml;
using System.Xml.XPath;
using Utils.Collections;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Exceptions;

namespace Palladio.FiniteStateMachines.DefaultFSM 
{
	internal class TabularFSM : AbstractFSM, IEditableFiniteStateMachine
	{
		#region Properties

		public override IInput[] InputAlphabet 
		{
			get 
			{
				return (IInput[]) inputAlphabet.ToArray(typeof(IInput));
			}
			set
			{
				inputAlphabet = new Set(value);
			}
		}

		public override IState StartState 
		{
			get 
			{
				if (startState != null) 
				{
					return startState; 
				} 
				else 
				{
					throw new NoStartStateException();
				}
			}
			set
			{
				if ( states.Contains(value) )
					startState = value;
				else
					throw new StateNotFoundException(value);
			}
		}

		public override IState[] FinalStates 
		{
			get 
			{
				if (finalStates.Count != 0) 
				{
					return (IState[])finalStates.ToArray(typeof(IState));
				} 
				else 
				{
					throw new ApplicationException("No final states defined");
				}
			}
			set
			{
				finalStates = new Set();
				foreach (IState state in value)
				{
					if ( states.Contains(state) )
						finalStates.Add(state);
					else
						throw new StateNotFoundException(state);
				}
			}
		}

		public override IState[] States
		{
			get
			{
				return (IState[]) states.ToArray(typeof(IState));
			}
		}

		#endregion

		#region Methods

		public override ITransition[] GetNextTransitions(IState aSourceState, IInput anInput) 
		{
			if((!states.Contains(aSourceState)) && (!aSourceState.IsErrorState)) 
				throw new InvalidStateException(aSourceState);
			if (!inputAlphabet.Contains(anInput)) 
				throw new InvalidInputException(anInput);

			Vector transList = new Vector();
			transList.Add(new DefaultTransition(aSourceState,anInput,ERROR_STATE));

			if (transitionTable.Contains(aSourceState)) 
			{
				Hashtable inputTable = (Hashtable) transitionTable[aSourceState];
				if (inputTable.Contains(anInput) && (((IList)inputTable[anInput])).Count != 0)
				{
					transList = (Vector)inputTable[anInput];
				}
			}
			return (ITransition[])transList.ToArray(typeof(ITransition));
		}

		public override ITransition GetNextTransition(IState aSourceState, IInput anInput)
		{
			ITransition[] transArray = GetNextTransitions(aSourceState,anInput);
			if (transArray.Length == 1)
			{
				return transArray[0];
			}
			else
			{
				throw new FsmNotDeterministicException(aSourceState,anInput);
			}
		}

		public override ITransition[] GetOutgoingTransitions(IState state) 
		{
			Vector transList = new Vector();
			Hashtable outgoing = (Hashtable)transitionTable[state];
			if (outgoing != null) 
			{
				foreach (DictionaryEntry entry in outgoing) 
				{
					transList.AddRange((IList)entry.Value);
				}
			}
			return (ITransition[])transList.ToArray(typeof(ITransition));
		}

		public override bool IsFinalState(IState aState)
		{
			return finalStates.Contains(aState);
		}

		public void AddTransitions(params ITransition[] aTransitionArray)
		{
			AddTransitionList(aTransitionArray);
		}

		public void AddTransitionList(IEnumerable aTransitionList)
		{
			foreach (ITransition trans in aTransitionList)
			{
				if (!states.Contains(trans.SourceState))
					throw new InvalidStateException( trans.SourceState);
				if (!states.Contains(trans.DestinationState))
					throw new InvalidStateException( trans.DestinationState);
				if (!inputAlphabet.Contains(trans.InputSymbol))
					throw new InvalidInputException( trans.InputSymbol);
				AddToTransTable(trans);
				AddToRevTransTable(trans);
			}
		}

		public void DeleteTransitions(params ITransition[] aTranstionArray)
		{
			foreach( ITransition trans in aTranstionArray)
			{
				if (DeleteFromTransTable(trans))
				{
					DeleteFromRevTransTable(trans);
				}
				else
				{
					throw new TransitionNotFoundException(trans);
				}
			}
		}

		public void AddStates(params IState[] aStateArray)
		{
			AddStateList(aStateArray);
		}

		public void AddStateList(IEnumerable aStateList)
		{
			foreach( IState state in aStateList )
			{
				states.Add(state);
			}
		}

		public void DeleteStates(params IState[] aStateArray)
		{
			foreach (IState state in aStateArray)
			{
				if (states.Contains(state))
				{
					finalStates.Remove(state);
					states.Remove(state);
					if (StartState.Equals(state))
					{
						startState = null;
					}
				}
				else
				{
					throw new StateNotFoundException(state);
				}
			}
		}

		public void AddInputSymbols(params IInput[] anInputSymbolList)
		{
			inputAlphabet.AddRange(anInputSymbolList);
		}

		public void DeleteInputSymbols(params IInput[] anInputSymbolList)
		{
			foreach (IInput i in anInputSymbolList)
			{
				if (inputAlphabet.Contains(i))
					inputAlphabet.Remove(i);
				else
					throw new InputNotFoundException(i);
			}
		}

		public override object Clone()
		{
			return new TabularFSM(this);
		}

		private void AddToTransTable(ITransition aTrans)
		{
			Hashtable inputTable = (Hashtable)transitionTable[aTrans.SourceState];
			if (inputTable == null)
			{
				inputTable = new Hashtable();
				transitionTable[aTrans.SourceState] = inputTable;
			}
			IList transList = (IList)inputTable[aTrans.InputSymbol];
			if (transList == null)
			{
				transList = new Vector();
				inputTable[aTrans.InputSymbol] = transList;
			}
			transList.Add(aTrans);
		}

		private void AddToRevTransTable(ITransition aTrans)
		{
			IList transList = (IList)reverseTransTable[aTrans.DestinationState];
			if ( transList == null )
			{
				transList = new Vector();
				reverseTransTable[aTrans.DestinationState] = transList;
			}
			transList.Add(aTrans);
		}

		private bool DeleteFromTransTable(ITransition aTrans)
		{
			Hashtable inputTable = (Hashtable)transitionTable[aTrans.SourceState];
			bool failed = true;
			if ( inputTable != null )
			{
				IList transList = (IList)inputTable[aTrans.InputSymbol];
				if ( transList != null )
				{
					if (transList.Contains(aTrans))
					{
						transList.Remove(aTrans);
						failed = false;
					}
				}
			}
			return !failed;
		}

		private void DeleteFromRevTransTable(ITransition aTrans)
		{
			IList transList = (IList)reverseTransTable[aTrans.DestinationState];
			if (transList != null) 
				transList.Remove(aTrans);
		}
			

		#endregion

		#region Constructurs

		public TabularFSM() 
		{
			this.inputAlphabet = new Set();
			this.transitionTable = new Hashtable();
			this.finalStates = new Set();
			this.states = new Set();
			this.reverseTransTable = new Hashtable();
		}

		public TabularFSM(TabularFSM aTabFSM)
		{
			AddStates(aTabFSM.States);
			FinalStates = aTabFSM.FinalStates;
			StartState = aTabFSM.StartState;
			AddTransitions( aTabFSM.Transitions );
		}
		#endregion

		#region Data
		
		/// <summary>
		/// key: IState
		/// value: Hashtable
		///		key: IInput
		///		value: IList of ITransitions
		///		
		///	Stores all outgoing transitions for a state orderd by its 
		///	input symbols.
		/// </summary>
		private Hashtable transitionTable;

		/// <summary>
		/// key: IState
		/// value: IList of ITransitions
		/// Stores all ingoing transitions for a state. 
		/// </summary>
		private Hashtable reverseTransTable;
		private Set inputAlphabet;
		private IState startState;
		private Set finalStates;
		private Set states;
		#endregion
	}
}
