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

using System.Diagnostics;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// Each element S(i,j) of the matrix contains the expected number
	/// of visits of state i on an abritary path (including intermediate 
	/// visits to j) to state j starting in the start state of the Markov model.
	/// </summary>
	public class VisitsOnPathMatrix : AbstractMarkovMatrix, IVisitsOnPathMatrix
	{
		#region Properties

		/// <summary>
		/// Index of the start state in the Markov Matrix.
		/// </summary>
		public override int StartStateIndex
		{
			get { return visitProbabilityMatrix.StartStateIndex; }
		}

		/// <summary>
		/// Index of the final state in the Markov Matrix.
		/// </summary>
		public override int FinalStateIndex
		{
			get { return visitProbabilityMatrix.FinalStateIndex; }
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
			get { return visitProbabilityMatrix.PotentialMatrix; }
		}

		public ITransitionMatrix TransitionMatrix
		{
			get { return visitProbabilityMatrix.TransitionMatrix; }
		}

		public IVisitProbabilityMatrix VisitProbabilityMatrix
		{
			get { return visitProbabilityMatrix; }
		}

		#endregion

		#region Public Methods

		/// <summary>
		/// Shrinks the matrix to the rows and columns with the selected indices. It is assumed
		/// that indices[0] is the start state index and indices[length-1] is the final state index.
		/// </summary>
		/// <param name="indices"></param>
		/// <returns></returns>
		public IVisitsOnPathMatrix ShrinkTo(params int[] indices)
		{
			IVisitProbabilityMatrix vMx = visitProbabilityMatrix.ShrinkTo(indices);
			return new VisitsOnPathMatrix(vMx);
		}

		#endregion

		#region Constructors

		public VisitsOnPathMatrix(IVisitProbabilityMatrix vMx)
		{
			visitProbabilityMatrix = vMx;
			matrix = CreateVisitsOnPathMatrix(vMx.PotentialMatrix.Matrix, vMx.Matrix);
		}

		public VisitsOnPathMatrix(IPotentialMatrix pMx) : this(new VisitProbabilityMatrix(pMx))
		{
		}

		public VisitsOnPathMatrix(ITransitionMatrix tMx) : this(new VisitProbabilityMatrix(tMx))
		{
		}

		public VisitsOnPathMatrix(IMarkovModel mm) : this(new VisitProbabilityMatrix(mm))
		{
		}

		#endregion

		#region Private

		private ScalarMatrix CreateVisitsOnPathMatrix(ScalarMatrix potentialMx, ScalarMatrix visitProbabilityMx)
		{
			Trace.Assert(potentialMx.LengthX == potentialMx.LengthY, "potentialMx.LengthX == potentialMx.LengthY");
			Trace.Assert(visitProbabilityMx.LengthX == visitProbabilityMx.LengthY, "visitProbabilityMx.LengthX == visitProbabilityMx.LengthY");
			int rank = potentialMx.LengthX;
			Context cx = potentialMx.Context;
			IScalarExpression[,] visitsExprs = new IScalarExpression[rank,rank];

			for (int i = 0; i < potentialMx.LengthX; i++)
				for (int j = 0; j < potentialMx.LengthY; j++)
				{
					if (i == j)
					{
						// for i == j the expected number of visits of i on an arbitrary path from 
						// the start state to j(=i) equals the expected number of visits to i
						visitsExprs[i, j] = potentialMx[StartStateIndex, i];
					}
					else
					{
						// for i != j the expected number of visits of i on an arbitrary path from 
						// the start state to j is P(s,i)*F(i,j), the expected number of visits to
						// state i starting in s (=start state) multiplied by the probability of ever
						// reaching state j from state i.
						visitsExprs[i, j] = new ScalarMultiplication(cx, potentialMx[StartStateIndex, i], visitProbabilityMx[i, j]).Expand();
					}
				}
			return new ScalarMatrix(cx, visitsExprs);
		}

		private ScalarMatrix matrix;
		private IVisitProbabilityMatrix visitProbabilityMatrix;

		#endregion
	}
}