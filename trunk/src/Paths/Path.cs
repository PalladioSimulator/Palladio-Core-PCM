/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/10/25 07:07:22  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 */
using System;
using System.Collections;
using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.Paths
{
	/// <summary>
	/// Default implementation of IPath.
	/// </summary>
	internal class Path : IPath
	{
		private IState entryState;
		private IState exitState;

		private Hashtable transitionTable;

		public Path(IState theEntryState)
		{
			entryState = theEntryState;
			exitState = theEntryState;
			transitionTable = new Hashtable();
		}

		public Path(IState theEntryState, IState theExitState, Hashtable theTransTable)
		{
			entryState = theEntryState;
			exitState = theExitState;
			transitionTable = (Hashtable) theTransTable.Clone();
		}

		public IState EntryState
		{
			get { return entryState; }
			set
			{
				if (!Contains(value))
					throw new ApplicationException(String.Format("State {0} is not in this path!", value));
				if (IsCycle)
				{
					entryState = value;
					exitState = value;
				}
				else
				{
					while (!IsEntryState(value))
						RemoveFirst();
				}
			}
		}

		public IState ExitState
		{
			get { return exitState; }
		}

		public bool IsCycle
		{
			get
			{
				if (transitionTable.Count == 0)
					return false;
				return EntryState.Equals(ExitState);
			}
		}

		public ITransition GetNextTransition(IState aSourceState)
		{
			ITransition transition = (ITransition) transitionTable[aSourceState];
			if (transition == null)
				throw new ApplicationException(String.Format("State {0} has no successor!", aSourceState));
			return transition;
		}

		public IState GetNextState(IState aSourceState)
		{
			return GetNextTransition(aSourceState).DestinationState;
		}

		public IInput GetNextInput(IState aSourceState)
		{
			return GetNextTransition(aSourceState).InputSymbol;
		}

		public bool Contains(IState aState)
		{
			return transitionTable.ContainsKey(aState);
		}

		public bool Contains(IInput anInput)
		{
			foreach (ITransition transition in transitionTable.Values)
			{
				if (transition.InputSymbol.Equals(anInput))
					return true;
			}
			return false;
		}

		public void Append(ITransition aTransition)
		{
			if (IsCycle)
				throw new ApplicationException("This path is a cycle. No transitions can be appended!");
			if (Contains(aTransition.SourceState))
				throw new ApplicationException(String.Format("State {0} is already in this path!", aTransition.SourceState));
			if (!aTransition.SourceState.Equals(ExitState))
				throw new ApplicationException(String.Format("State {0} must be the source state of the next transition!", ExitState));
			transitionTable.Add(aTransition.SourceState, aTransition);
			exitState = aTransition.DestinationState;
		}

		private void RemoveFirst()
		{
			ITransition transition = GetNextTransition(entryState);
			transitionTable.Remove(transition.SourceState);
			entryState = transition.DestinationState;
		}

		public bool IsEntryState(IState aState)
		{
			return entryState.Equals(aState);
		}

		public bool IsExitState(IState aState)
		{
			return exitState.Equals(aState);
		}

		public int Length
		{
			get { return transitionTable.Count; }
		}

		public IState[] States
		{
			get
			{
				IState[] states;
				if (IsCycle)
				{
					states = new IState[transitionTable.Count];
					transitionTable.Keys.CopyTo(states, 0);
				}
				else
				{
					states = new IState[transitionTable.Count + 1];
					transitionTable.Keys.CopyTo(states, 0);
					states[states.Length - 1] = ExitState;
				}
				return states;
			}
		}

		public bool Overlaps(IPath path)
		{
			IState[] pathStates = path.States;
			foreach (IState state in States)
			{
				if (Array.IndexOf(pathStates, state) > -1)
					return true;
			}
			return false;
		}

		public object Clone()
		{
			return new Path(entryState, exitState, transitionTable);
		}

		/// <summary>
		/// Two paths are equal, if they contain the same set of transitions.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public override bool Equals(object obj)
		{
			if (obj is Path)
			{
				Path path = (Path) obj;
				if (path.Length != this.Length)
					return false;
				foreach (ITransition transition in transitionTable.Values)
				{
					if (!path.transitionTable.ContainsValue(transition))
						return false;
				}
				return true;
			}
			return false;
		}
	}
}