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

using System.Diagnostics;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;

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
			Trace.Assert(transMatrix.Matrix.LengthX == transMatrix.Matrix.LengthY, "transMatrix.Matrix.LengthX == transMatrix.Matrix.LengthY");
			transitionMatrix = transMatrix;
			matrix = CreatePotentialMatrix(transitionMatrix.Matrix);
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
		public override ScalarMatrix Matrix
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

		private ScalarMatrix CreatePotentialMatrix(IMatrixExpression transitionMx)
		{
			Context context = transitionMx.Context;
			int rank = transitionMx.LengthX;
			IScalarExpression rankExpr = new ScalarExpressionValue(context, rank);
			IMatrixExpression idMx = new MatrixIdentity(transitionMx.Context, rankExpr).Expand();
			IMatrixExpression idMinusProbMx = new MatrixMatrixSubtraction(context, idMx, transitionMx).Expand();
			return MatrixTools.Invert(idMinusProbMx).Expand();
		}

		private ScalarMatrix matrix;
		private ITransitionMatrix transitionMatrix;
	}
}