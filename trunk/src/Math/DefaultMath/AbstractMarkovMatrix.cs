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


using System;
using MathNet.Numerics.LinearAlgebra;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// Zusammenfassung für AbstractMarkovMatrix.
	/// </summary>
	public abstract class AbstractMarkovMatrix : IMarkovMatrix
	{
		/// <summary>
		/// Index of the start state in the Markov Matrix.
		/// </summary>
		public abstract int StartStateIndex { get; }

		/// <summary>
		/// Index of the final state in the Markov Matrix.
		/// </summary>
		public abstract int FinalStateIndex { get; }

		/// <summary>
		/// The matrix.
		/// </summary>
		public abstract Matrix Matrix { get; }

		public int Rank
		{
			get { return Matrix.ColumnDimension; }
		}

		public int ColumnDimension
		{
			get { return Matrix.ColumnDimension; }
		}

		public int RowDimension
		{
			get { return Matrix.RowDimension; }
		}

		#region Public Methods

		public override string ToString()
		{
			string result = "     ";
			for (int j = 0; j < Matrix.ColumnDimension; j++)
			{
				result += String.Format("{0,-6}", (j + 1));
			}
			result += "\n";
			for (int i = 0; i < Matrix.ColumnDimension; i++)
			{
				result += String.Format(" {0,2}  ", (i + 1));
				for (int j = 0; j < Matrix.RowDimension; j++)
				{
					double val = System.Math.Round(Matrix[i, j],4);
					result += String.Format("{0,-6}", val);
				}
				result += "\n";
			}
			return result;
		}

		#endregion
	}
}