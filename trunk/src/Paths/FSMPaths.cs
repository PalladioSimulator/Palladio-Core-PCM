/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 */
using System.Collections;
using Palladio.FiniteStateMachines;
using Palladio.Utils.Collections;

namespace Palladio.Reliability.Paths
{
	/// <summary>
	/// Seperating a FSM into its paths.
	/// </summary>
	public class FSMPaths : IFSMPaths
	{
		private IPath[] cycles;
		private IPath[] finalPaths;
		private IFiniteStateMachine fsm;

		public IPath[] CyclicPaths
		{
			get { return cycles; }
		}

		public IPath[] FinalPaths
		{
			get { return finalPaths; }
		}

		public IFiniteStateMachine FSM
		{
			get { return fsm; }
		}

		public FSMPaths(IFiniteStateMachine fsm)
		{
			this.fsm = fsm;
			GetAllPaths(fsm, out finalPaths, out cycles);
		}

		/// <summary>
		/// Returns all paths from the start- to the final-state without 
		/// inner cycles and all cycles in the FSM.
		/// </summary>
		private static void GetAllPaths(IFiniteStateMachine aFSM, out IPath[] aFinalPathArray, out IPath[] aCyclicPathArray)
		{
			IPath initialPath = new Path(aFSM.StartState);
			Stack currentPaths = new Stack();
			currentPaths.Push(initialPath);

			Set cyclicPaths = new Set();
			Set finalPaths = new Set();
			if (aFSM.IsFinalState(initialPath.ExitState))
				finalPaths.Add(initialPath);

			while (currentPaths.Count > 0)
			{
				Stack nextPaths = new Stack();
				foreach (IPath path in currentPaths)
				{
					foreach (ITransition transition in aFSM.GetOutgoingTransitions(path.ExitState))
					{
						// transition is a loop
						if (transition.SourceState.Equals(transition.DestinationState))
						{
							IPath p = new Path(transition.SourceState);
							p.Append(transition);
							cyclicPaths.Add(p);
						}
							// path has a cycle
						else if (path.Contains(transition.DestinationState))
						{
							IPath newPath = (IPath) path.Clone();
							newPath.EntryState = transition.DestinationState;
							newPath.Append(transition);
							cyclicPaths.Add(newPath);
						}
							// usual path
						else
						{
							IPath newPath = (IPath) path.Clone();
							newPath.Append(transition);
							nextPaths.Push(newPath);
							if (aFSM.IsFinalState(newPath.ExitState))
								finalPaths.Add(newPath);
						}
					}
				}
				currentPaths = nextPaths;
			}
			aFinalPathArray = (IPath[]) finalPaths.ToArray(typeof (IPath));
			aCyclicPathArray = (IPath[]) cyclicPaths.ToArray(typeof (IPath));
		}
	}
}