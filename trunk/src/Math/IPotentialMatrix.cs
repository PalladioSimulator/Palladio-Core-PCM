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
	/// Limit of the series \sum_(k=0)^(\infty) P^k </br>
	/// The elements R(i,j) of this matrix are the expected number
	/// of visits to state j starting in state i.
	/// </summary>
	public interface IPotentialMatrix : IMarkovMatrix
	{
		ITransitionMatrix TransitionMatrix { get; }

		/// <summary>
		/// Shrinks the matrix to the rows and columns with the selected indices. It is assumed
		/// that indices[0] is the start state index and indices[length-1] is the final state index.
		/// </summary>
		/// <param name="indices"></param>
		/// <returns></returns>
		IPotentialMatrix ShrinkTo(params int[] indices);
	}
}