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
	/// Zusammenfassung für ExecutionTime.
	/// </summary>
	public interface IExecutionTime
	{
		IVariableExpression Total { get; }

		IVariableExpression[] PathToState { get; }

		MarkovModelInfo ModelInfo { get; }

		IFiniteStateMachine MarkovModel { get; }

		int GetStateIndex(IState state);
	}
}