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
	/// Transition matrix P of the Markov model. It contains the probabilities to 
	/// successfully reach another state from a source state with one transition.
	/// </br>
	/// To handle multiple final states, it contains a new, superior finalstate and
	/// transitions  with probabilities of 1.0 - (sum of outgoing transitions) form the
	/// final states of the FSM to the new final state.
	/// </summary>
	public interface ITransitionMatrix : IMarkovMatrix
	{
		/// <summary>
		/// Shrinks the matrix to the rows and columns with the selected indices. It is assumed
		/// that indices[0] is the start state index and indices[length-1] is the final state index.
		/// </summary>
		/// <param name="indices"></param>
		/// <returns></returns>
		ITransitionMatrix ShrinkTo(params int[] indices);
	}
}