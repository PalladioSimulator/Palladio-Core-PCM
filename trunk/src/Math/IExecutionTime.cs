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

	}
}