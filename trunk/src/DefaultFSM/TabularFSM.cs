using System;
using System.Collections;
using System.Xml;
using System.Xml.XPath;
using Palladio.Utils.Collections;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Exceptions;

namespace Palladio.FiniteStateMachines.DefaultFSM 
{
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.13  2004/05/12 14:11:39  sbecker
	/// Added CVS log
	///
	///
	/// </pre>
	/// </remarks>
	internal class TabularFSM : AbstractFSM, IEditableFiniteStateMachine
	{
		#region Properties

		public override IInput[] InputAlphabet 
		{
			get 
			{
				IInput[] result = new IInput[inputAlphabet.Values.Count];
				inputAlphabet.Values.CopyTo(result,0);
				return result;
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
				if ( HasState(value) )
					startState = value;
				else
					throw new StateNotFoundException(value);
			}
		}

		public override IState[] FinalStates 
		{
			get 
			{
					return (IState[])finalStates.ToArray(typeof(IState));
			}
			set
			{
				finalStates = new Set();
				foreach (IState state in value)
				{
					if ( HasState(state) )
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
				IState[] result = new IState[states.Values.Count];
				states.Values.CopyTo(result,0);
				return result;
			}
		}

		public override ITransition[] Transitions
		{
			get
			{
				Vector transList = new Vector();
				foreach (DictionaryEntry e in transitionTable)
				{
					if (e.Value != null)
					{
						foreach (DictionaryEntry f in ((Hashtable)e.Value))
						{
							if (f.Value != null)
							{
								transList.AddRange((IList)f.Value);
							}
						}
					}
				}
				return (ITransition[])transList.ToArray(typeof(ITransition));
			}
		}


		#endregion

		#region Methods

		public override ITransition[] GetNextTransitions(IState aSourceState, IInput anInput) 
		{
			if((!HasState(aSourceState)) && (!aSourceState.IsErrorState)) 
				throw new InvalidStateException(aSourceState);
			if (!HasInput(anInput)) 
				throw new InvalidInputException(anInput);

			Set transList = new Set();
			transList.Add(new DefaultTransition(aSourceState,anInput,ERROR_STATE));

			if (transitionTable.Contains(aSourceState)) 
			{
				Hashtable inputTable = (Hashtable) transitionTable[aSourceState];
				if (inputTable.Contains(anInput) && (((IList)inputTable[anInput])).Count != 0)
				{
					transList = (Set)inputTable[anInput];
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
			if (!HasState(state))
				throw new InvalidStateException(state);

			Set transList = new Set();
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
				if (!HasState(trans.SourceState))
					throw new InvalidStateException( trans.SourceState);
				if (!HasState(trans.DestinationState))
					throw new InvalidStateException( trans.DestinationState);
				if (!HasInput(trans.InputSymbol))
					throw new InvalidInputException( trans.InputSymbol);
				AddToTransTable(trans);
				AddToRevTransTable(trans);
			}
		}

		public void AddTransition(string aSourceID, string anInputID, string aDestinationID)
		{
			ITransition trans = new DefaultTransition( GetState(aSourceID), GetInput(anInputID), GetState(aDestinationID) );
			AddTransitions(trans);
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
				if (!HasState(state))
					states.Add(state.ID, state);
			}
		}

		public void DeleteStates(params IState[] aStateArray)
		{
			foreach (IState state in aStateArray)
			{
				if (HasState(state))
				{
					if (StateDeletionAllowed(state))
					{
						finalStates.Remove(state);
						states.Remove(state.ID);
						if (StartState.Equals(state))
						{
							startState = null;
						}
					}
					else
					{
						throw new StateDeletionNotAllowed(state);
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
			foreach (IInput i in anInputSymbolList)
			{
				if (!HasInput(i))
					inputAlphabet.Add(i.ID,i);
			}
		}

		public void DeleteInputSymbols(params IInput[] anInputSymbolList)
		{
			foreach (IInput i in anInputSymbolList)
			{
				if (HasInput(i))
					if (InputDeletionAllowed(i))
						inputAlphabet.Remove(i.ID);
					else
						throw new InputDeletionNotAllowedException(i);
				else
					throw new InputNotFoundException(i);
			}
		}

		public IState GetState(string aStateID)
		{
			if (states.Contains(aStateID))
				return (IState)states[aStateID];
			throw new NoStateWithIDException(aStateID);
		}

		public IInput GetInput(string anInputID)
		{
			if (inputAlphabet.Contains(anInputID))
				return (IInput)inputAlphabet[anInputID];
			throw new NoInputWithIDException(anInputID);
		}

		public void Clean()
		{
			ITransition[] reachableTransitions = GetReachableTransitions(StartState);
			foreach (ITransition t in Transitions)
			{
				if (Array.IndexOf(reachableTransitions,t) < 0)
					DeleteTransitions(t);
			}
			IState[] reachableStates = GetReachableStates(StartState);
			foreach (IState s in States)
			{
				if (Array.IndexOf(reachableStates,s) < 0)
					DeleteStates(s);
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
				transList = new Set();
				inputTable[aTrans.InputSymbol] = transList;
			}
				transList.Add(aTrans);
		}

		private void AddToRevTransTable(ITransition aTrans)
		{
			IList transList = (IList)reverseTransTable[aTrans.DestinationState];
			if ( transList == null )
			{
				transList = new Set();
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

		private bool StateDeletionAllowed(IState aState)
		{
			// check outgoing transitions
			Hashtable inputTable = (Hashtable)transitionTable[aState];
			if (inputTable != null)
			{
				foreach ( DictionaryEntry e in inputTable )
				{
					IList transList = (IList)e.Value;
					if ((transList != null) && (transList.Count > 0))
					{
						return false;
					}
				}
			}
			// check incoming transitions
			IList tList = (IList) reverseTransTable[aState];
			if ((tList != null) && (tList.Count > 0))
			{
				return false;
			}
			return true;
		}
			
		private bool InputDeletionAllowed(IInput anInput)
		{
			foreach (DictionaryEntry e in transitionTable)
			{
				Hashtable inputTable = (Hashtable)e.Value;
				IList transList = (IList)inputTable[anInput];
				if ((transList != null) && (transList.Count > 0))
				{
					return false;
				}
			}
			return true;
		}

		private bool HasState(IState aState)
		{
			if (aState != null)
				return states.Contains(aState.ID);
			return false;
		}

		private bool HasInput(IInput anInput)
		{
			if (anInput != null)
				return inputAlphabet.Contains(anInput.ID);
			return false;
		}
		#endregion

		#region Constructurs

		public TabularFSM() 
		{
			this.inputAlphabet = new Hashtable();
			this.transitionTable = new Hashtable();
			this.finalStates = new Set();
			this.states = new Hashtable();
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
		private Hashtable inputAlphabet;
		private IState startState;
		private Set finalStates;
		private Hashtable states;
		#endregion
	}
}
