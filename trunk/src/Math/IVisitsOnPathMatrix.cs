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

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// Each element S(i,j) of the matrix contains the expected number
	/// of visits of state i on an abritary path (including intermediate 
	/// visits to j) to state j starting in the start state of the Markov model.
	/// </summary>
	public interface IVisitsOnPathMatrix : IMarkovMatrix
	{
		IPotentialMatrix PotentialMatrix { get; }

		ITransitionMatrix TransitionMatrix { get; }

		IVisitProbabilityMatrix VisitProbabilityMatrix { get; }

		/// <summary>
		/// Shrinks the matrix to the rows and columns with the selected indices. It is assumed
		/// that indices[0] is the start state index and indices[length-1] is the final state index.
		/// </summary>
		/// <param name="indices"></param>
		/// <returns></returns>
		IVisitsOnPathMatrix ShrinkTo(params int[] indices);
	}
}