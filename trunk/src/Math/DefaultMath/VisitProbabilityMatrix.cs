/*
 * $Id$
 * 
 * $Log$
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
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// The elements F(i,j) of this matrix are the probability of reaching
	/// state j in an arbitrary number of steps starting in state i.
	/// For i=j, F(i,j) is the probability to ever return to state i.
	/// </summary>
	public class VisitProbabilityMatrix : AbstractMarkovMatrix, IVisitProbabilityMatrix
	{
		#region Properties

		/// <summary>
		/// Index of the start state in the Markov Matrix.
		/// </summary>
		public override int StartStateIndex
		{
			get { return potentialMatrix.StartStateIndex; }
		}

		/// <summary>
		/// Index of the final state in the Markov Matrix.
		/// </summary>
		public override int FinalStateIndex
		{
			get { return potentialMatrix.FinalStateIndex; }
		}

		/// <summary>
		/// The matrix.
		/// </summary>
		public override ScalarMatrix Matrix
		{
			get { return matrix; }
		}

		public IPotentialMatrix PotentialMatrix
		{
			get { return potentialMatrix; }
		}

		public ITransitionMatrix TransitionMatrix
		{
			get { return potentialMatrix.TransitionMatrix; }
		}

		#endregion

		#region Public Methods

		/// <summary>
		/// Shrinks the matrix to the rows and columns with the selected indices. It is assumed
		/// that indices[0] is the start state index and indices[length-1] is the final state index.
		/// </summary>
		/// <param name="indices"></param>
		/// <returns></returns>
		public IVisitProbabilityMatrix ShrinkTo(params int[] indices)
		{
			IPotentialMatrix pMx = potentialMatrix.ShrinkTo(indices);
			return new VisitProbabilityMatrix(pMx);
		}

		#endregion

		#region Constructors

		public VisitProbabilityMatrix(IPotentialMatrix aPotentialMatrix)
		{
			potentialMatrix = aPotentialMatrix;
			matrix = CreateVisitProbabilityMatrix(potentialMatrix.Matrix);
		}

		public VisitProbabilityMatrix(ITransitionMatrix transitionMatrix) : this(new PotentialMatrix(transitionMatrix))
		{
		}

		public VisitProbabilityMatrix(IMarkovModel markovModel) : this(new PotentialMatrix(markovModel))
		{
		}

		#endregion

		#region Private

		private ScalarMatrix CreateVisitProbabilityMatrix(IMatrixExpression potentialMx)
		{
			Trace.Assert(potentialMx.LengthX == potentialMx.LengthY, "potentialMx.LengthX == potentialMx.LengthY");
			Context cx = new Context();
			int rank = potentialMx.LengthX;
			IScalarExpression one = new ScalarExpressionValue(cx, 1.0);
			ScalarMatrix pMx = potentialMx.Expand();
			IScalarExpression[,] fExprs = new IScalarExpression[rank,rank];
			for (int i = 0; i < pMx.LengthX; i++)
			{
				for (int j = 0; j < pMx.LengthY; j++)
				{
					if (i == j)
					{
						// F(i,j) = 1 - 1 / R(i,j) for i==j
						fExprs[i, j] = new ScalarSubtraction(cx, one, new ScalarDivision(cx, one, pMx[i, j])).Expand();
					}
					else
					{
						// F(i,j) = R(i,j)/R(j,j) for i!=j
						fExprs[i, j] = new ScalarDivision(cx, pMx[i, j], pMx[j, j]).Expand();
					}
				}
			}
			return new ScalarMatrix(cx, fExprs);
		}

		private IPotentialMatrix potentialMatrix;
		private ScalarMatrix matrix;

		#endregion
	}
}