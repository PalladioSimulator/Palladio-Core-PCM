/*
 * $Id$
 * 
 * $Log$
 * Revision 1.2  2004/11/04 08:52:13  sliver
 * added regular expressions
 *
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
	/// A Markov model is a FSM with probabilities added to
	/// its transitions.
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