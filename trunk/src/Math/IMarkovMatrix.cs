/*
 * $Id$
 * 
 * $Log$
 * Revision 1.3  2004/11/04 08:52:13  sliver
 * added regular expressions
 *
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

using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// General matrix. Each row/column is associated with a state
	/// of a Markov model. The matrix knows the row/column of the start
	/// and final state.
	/// </summary>
	public interface IMarkovMatrix
	{
		#region Properties

		/// <summary>
		/// Index of the start state in the Markov Matrix.
		/// </summary>
		int StartStateIndex { get; }

		/// <summary>
		/// Index of the final state in the Markov Matrix.
		/// </summary>
		int FinalStateIndex { get; }

		/// <summary>
		/// The matrix.
		/// </summary>
		ScalarMatrix Matrix { get; }

		/// <summary>
		/// The rank of the matrix.
		/// </summary>
		int Rank { get; }

		/// <summary>
		/// Number of columns.
		/// </summary>
		int LengthX { get; }

		/// <summary>
		/// Number of rows.
		/// </summary>
		int LengthY { get; }

		#endregion
	}
}