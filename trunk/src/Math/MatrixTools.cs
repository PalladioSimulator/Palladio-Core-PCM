/*
 * $Id$
 * 
 * $Log$
 * Revision 1.3  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 */

using System;
using System.Diagnostics;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// Provides some useful functions for dealing with matrices.
	/// </summary>
	/// <remarks>
	/// 	created by - sliver
	/// 	created on - 09.07.2004 13:55:49
	/// </remarks>
	public class MatrixTools
	{
		/// <summary>
		/// Inverts aMatrix. To be invertable the aMatrix must be (n x n). This function simply
		/// assumes that a given (n x n) aMatrix is invertable even if the row or column vectors 
		/// of the aMatrix are not linear independent.
		/// </summary>
		/// <param name="aMatrix">A (n x n) aMatrix.</param>
		/// <returns>The inverted aMatrix or the pseudo-inverted aMatrix, if inverting is not possible.</returns>
		public static ScalarMatrix Invert(IMatrixExpression aMatrix)
		{
			Trace.Assert(aMatrix.LengthX == aMatrix.LengthY);

			ScalarMatrix sm = (ScalarMatrix) aMatrix.Expand().Clone();
			MatrixIdentity id = new MatrixIdentity(aMatrix.Context, new ScalarExpressionValue(aMatrix.Context, aMatrix.LengthX));
			ScalarMatrix inv = (ScalarMatrix) id.Expand().Clone();

			for (int n = 0; n < sm.LengthY; n++) // (n,n) : current position in aMatrix
			{
				// find Pivot Element
				int pivotRow = -1;

				for (int row = n; row < sm.LengthY; row++)
				{
					if (!sm[n, row].IsConstant || sm[n, row].Calculate() != 0)
					{
						pivotRow = row;
						break;
					}
				}

				// the whole row is 0 - just ignore it 
				if (pivotRow == -1)
					continue;

				// put the pivot in the right place
				if (pivotRow != n)
				{
					ExchangeRows(ref sm, pivotRow, n);
					ExchangeRows(ref inv, pivotRow, n);
				}

				// make pivot 1
				IVectorExpression vecSm = new VectorScalarDivision(aMatrix.Context, sm.GetRowVector(n), sm[n, n]).Simplify();
				IVectorExpression vecInv = new VectorScalarDivision(aMatrix.Context, inv.GetRowVector(n), sm[n, n]).Simplify();
				sm.SetRowVector(n, vecSm);
				inv.SetRowVector(n, vecInv);

				for (int row = 0; row < sm.LengthY; row++)
				{
					if (row != n)
					{
						IScalarExpression scalar = sm [n, row];
						IVectorExpression scaledPivotRow, resultRow;

						scaledPivotRow = new VectorScalarMultiplication(aMatrix.Context, scalar, sm.GetRowVector(n)).Simplify();
						resultRow = new VectorVectorSubtraction(aMatrix.Context, sm.GetRowVector(row), scaledPivotRow);
						sm.SetRowVector(row, resultRow);

						scaledPivotRow = new VectorScalarMultiplication(aMatrix.Context, scalar, inv.GetRowVector(n)).Simplify();
						resultRow = new VectorVectorSubtraction(aMatrix.Context, inv.GetRowVector(row), scaledPivotRow);

						inv.SetRowVector(row, resultRow);
					}
				}
			}
			return inv;
		}

		/// <summary> 
		/// Exchanges rowA and rowB of aMatrix.
		/// </summary>
		/// <param name="aMatrix">Matrix whichs rows should be exchanged.</param>
		/// <param name="rowA">Source row.</param>
		/// <param name="rowB">Destination row.</param>
		public static void ExchangeRows(ref ScalarMatrix aMatrix, int rowA, int rowB)
		{
			IVectorExpression tempRow = aMatrix.GetRowVector(rowA);
			aMatrix.SetRowVector(rowA, aMatrix.GetRowVector(rowB));
			aMatrix.SetRowVector(rowB, tempRow);
		}

		public static string MatrixToString(ValueMatrix matrix)
		{
			string result = "     ";
			for (int j = 0; j < matrix.LengthY; j++)
			{
				result += String.Format("{0,-6}", (j + 1));
			}
			result += "\n";
			for (int i = 0; i < matrix.LengthX; i++)
			{
				result += String.Format(" {0,2}  ", (i + 1));
				for (int j = 0; j < matrix.LengthY; j++)
				{
					double val = matrix[i, j];
					val *= 1000;
					val = System.Math.Round(val)/1000.0;
					result += String.Format("{0,-6}", val);
				}
				result += "\n";
			}
			return result;
		}

		public static string MatrixToString(double[,] matrix)
		{
			return MatrixToString(new ValueMatrix(matrix));
		}

		public static string MatrixToString(IMatrixExpression matrix)
		{
			return MatrixToString(matrix.Expand().Calculate());
		}
	}
}