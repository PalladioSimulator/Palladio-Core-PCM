/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 */

using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// </summary>
	public interface IMarkovModel
	{
		/// <summary>
		/// Finite state machine describing the Makrov model.
		/// </summary>
		IFiniteStateMachine FSM { get; }

		/// <summary>
		/// Index of the start state.
		/// </summary>
		int StartStateIndex { get; }

		/// <summary>
		/// Index of the artificial final state.
		/// </summary>
		int FinalStateIndex { get; }

		/// <summary>
		/// Returns the index of a state.
		/// </summary>
		/// <param name="state"></param>
		/// <returns></returns>
		int GetStateIndex(IState state);
	}
}