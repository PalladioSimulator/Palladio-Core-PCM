/*
 * $Id$
 * 
 * $Log$
 * Revision 1.2  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 * Revision 1.1  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 */

using System;
using System.Collections;
using System.Diagnostics;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Exceptions;
using Palladio.Reliability.Attributes;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// </summary>
	public class MarkovModel : IMarkovModel
	{
		/// <summary>
		/// Finite state machine describing the Makrov model.
		/// </summary>
		public IFiniteStateMachine FSM
		{
			get { return fsm; }
		}

		/// <summary>
		/// Index of the start state.
		/// </summary>
		public int StartStateIndex
		{
			get { return GetStateIndex(fsm.StartState); }
		}

		/// <summary>
		/// Index of the artificial final state.
		/// </summary>
		public int FinalStateIndex
		{
			get { return finalStateIndex; }
		}

		/// <summary>
		/// Returns the index of a state.
		/// </summary>
		/// <param name="state"></param>
		/// <returns></returns>
		public int GetStateIndex(IState state)
		{
			object obj = state2intHash[state.ID];
			if (obj == null)
				throw new StateNotFoundException(state);
			return (int) obj;
		}

		public MarkovModel(IFiniteStateMachine aFSM)
		{
			fsm = aFSM;
			CheckPreconditions(fsm);
			state2intHash = CreateState2IntHash(fsm);
			finalStateIndex = fsm.States.Length;
		}

		/// <summary>
		/// Creates a Hashtable associating an unique integer number with each state
		/// of the FSM.
		/// </summary>
		private Hashtable CreateState2IntHash(IFiniteStateMachine fsm)
		{
			Hashtable state2intHash = new Hashtable();
			ArrayList stateList = new ArrayList();
			foreach (IState state in fsm.States)
			{
				stateList.Add(state.ID);
			}
			stateList.Sort();
			for (int i = 0; i < stateList.Count; i++)
			{
				state2intHash.Add(stateList[i], i);
			}
			return state2intHash;
		}

		/// <summary>
		/// Checks if all transitions of aMarkovModel contain a MarkovProbabilityAttribute.
		/// </summary>
		/// <returns>True, if all transitions contain a MarkovProbabilityAttribute, false otherwise.</returns>
		private void CheckPreconditions(IFiniteStateMachine markovModel)
		{
			foreach (ITransition transition in markovModel.Transitions)
				Trace.Assert(MarkovAttribute.GetAttribute(transition) != null, String.Format("Transition {0} has no MarkovAttribute!", transition));
		}


		private IFiniteStateMachine fsm;
		private int finalStateIndex;
		private Hashtable state2intHash;

	}
}