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
		public override Matrix Matrix
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
			matrix = CreateVisitsOnPathMatrix(((IMarkovMatrix) vMx.PotentialMatrix).Matrix, ((IMarkovMatrix) vMx).Matrix);
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

		private Matrix CreateVisitsOnPathMatrix(Matrix potentialMx, Matrix visitProbabilityMx)
		{
			Trace.Assert(potentialMx.ColumnDimension == potentialMx.RowDimension, "potentialMx.ColumnDimension == potentialMx.RowDimension");
			Trace.Assert(visitProbabilityMx.ColumnDimension == visitProbabilityMx.RowDimension, "visitProbabilityMx.ColumnDimension == visitProbabilityMx.RowDimension");
			int rank = potentialMx.ColumnDimension;
			double[,] visitsExprs = new double[rank,rank];

			for (int i = 0; i < potentialMx.ColumnDimension; i++)
				for (int j = 0; j < potentialMx.RowDimension; j++)
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
						visitsExprs[i, j] = potentialMx[StartStateIndex, i] * visitProbabilityMx[i, j];
					}
				}
			return new Matrix(visitsExprs);
		}

		private Matrix matrix;
		private IVisitProbabilityMatrix visitProbabilityMatrix;

		#endregion
	}
}