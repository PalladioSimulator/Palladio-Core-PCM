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

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// The elements F(i,j) of this matrix are the probability of reaching
	/// state j in an arbitrary number of steps starting in state i.
	/// If i=j, F(i,j) is the probability to ever return to state i.
	/// </summary>
	public interface IVisitProbabilityMatrix : IMarkovMatrix
	{
		IPotentialMatrix PotentialMatrix { get; }

		ITransitionMatrix TransitionMatrix { get; }

		/// <summary>
		/// Shrinks the matrix to the rows and columns with the selected indices. It is assumed
		/// that indices[0] is the start state index and indices[length-1] is the final state index.
		/// </summary>
		/// <param name="indices"></param>
		/// <returns></returns>
		IVisitProbabilityMatrix ShrinkTo(params int[] indices);
	}
}