/*
 * $Id$
 * 
 * $Log$
 * Revision 1.2  2004/11/18 06:53:17  sliver
 * *** empty log message ***
 *
 * Revision 1.1  2004/11/04 08:52:14  sliver
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

using System.Diagnostics;
using MathNet.Numerics.LinearAlgebra;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// Limit of the series \sum_(k=0)^(\infty) P^k </br>
	/// The elements R(i,j) of this matrix are the expected number
	/// of visits to state j starting in state i.
	/// </summary>
	public class PotentialMatrix : AbstractMarkovMatrix, IPotentialMatrix
	{
		public PotentialMatrix(ITransitionMatrix transMatrix)
		{
			Trace.Assert(transMatrix.Matrix.RowDimension == transMatrix.Matrix.ColumnDimension, "transMatrix.Matrix.ColumnDimension == transMatrix.Matrix.RowDimension");
			transitionMatrix = transMatrix;
			matrix = CreatePotentialMatrix(transitionMatrix.Matrix);
		}

		public PotentialMatrix(IMarkovModel markovModel) : this(new TransitionMatrix(markovModel))
		{
		}

		/// <summary>
		/// Index of the start state in the Markov Matrix.
		/// </summary>
		public override int StartStateIndex
		{
			get { return transitionMatrix.StartStateIndex; }
		}

		/// <summary>
		/// Index of the final state in the Markov Matrix.
		/// </summary>
		public override int FinalStateIndex
		{
			get { return transitionMatrix.FinalStateIndex; }
		}

		/// <summary>
		/// The matrix.
		/// </summary>
		public override Matrix Matrix
		{
			get { return matrix; }
		}

		public ITransitionMatrix TransitionMatrix
		{
			get { return transitionMatrix; }
		}

		/// <summary>
		/// Shrinks the matrix to the rows and columns with the selected indices. It is assumed
		/// that indices[0] is the start state index and indices[length-1] is the final state index.
		/// </summary>
		/// <param name="indices"></param>
		/// <returns></returns>
		public IPotentialMatrix ShrinkTo(params int[] indices)
		{
			ITransitionMatrix tMx = transitionMatrix.ShrinkTo(indices);
			return new PotentialMatrix(tMx);
		}

		private Matrix CreatePotentialMatrix(Matrix transitionMx)
		{
			int rank = transitionMx.ColumnDimension;
			Matrix idMx = Matrix.Identity(rank,rank);
			Matrix idMinusProbMx = idMx - transitionMx;
			return idMinusProbMx.Inverse();
		}

		private Matrix matrix;
		private ITransitionMatrix transitionMatrix;
	}
}