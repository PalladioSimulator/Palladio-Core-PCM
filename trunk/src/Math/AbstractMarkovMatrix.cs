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


using System;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;

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
		public abstract ScalarMatrix Matrix { get; }

		public int Rank
		{
			get { return Matrix.LengthX; }
		}

		public int LengthX
		{
			get { return Matrix.LengthX; }
		}

		public int LengthY
		{
			get { return Matrix.LengthY; }
		}

		#region Public Methods

		public override string ToString()
		{
			ValueMatrix matrix = Matrix.Calculate();
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

		#endregion
	}
}