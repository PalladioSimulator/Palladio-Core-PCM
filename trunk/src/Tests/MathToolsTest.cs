/*
 * $Id$
 * 
 * $Log$
 * Revision 1.5  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 * Revision 1.4  2004/09/09 04:07:53  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.3  2004/07/30 01:25:51  sliver
 * Some changes...
 *
 * Revision 1.2  2004/07/13 02:14:52  sliver
 * Added comments
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 * 
 */

#if TEST

using System;
using cdrnet.Lib.MathLib.Parsing;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;
using NUnit.Framework;
using Palladio.Reliability.Math;

namespace Palladio.Reliability.Tests
{
	[TestFixture]
	public class MathMatrixToolsTest
	{
		[Test]
		public void Invert()
		{
			ScalarMatrix inv = MatrixTools.Invert(matrix);
			IMatrixExpression mult = new MatrixMatrixMultiplication(matrix.Context, matrix, inv);
			ValueMatrix result = mult.Calculate();
			for (int i = 0; i < mult.LengthX; i++)
				for (int j = 0; j < mult.LengthY; j++)
					if (i == j)
						Assert.AreEqual(1.0, result[i, j], 0.000001);
					else
						Assert.AreEqual(0.0, result[i, j], 0.000001);
		}

		[Test]
		public void TestMethod()
		{
			double val = 0.7872;
			IVariableExpression e = new VariableExpression(val);
			Console.WriteLine(e.Expression);
			Assert.AreEqual(val, e.Expression.Calculate());
//			Parser p = new Parser();
//			p.Provider = new InfixTokenizer();
//			IMatrixExpression orgMat = p.Parse("[[7/10,0,0],[3/10,2/10,0],[0,8/10,0]]") as IMatrixExpression;
//			MatrixIdentity identity = new MatrixIdentity(orgMat.Context, new ScalarExpressionValue(orgMat.Context, orgMat.LengthX));
//			orgMat = new MatrixMatrixSubtraction(orgMat.Context, identity.Expand(), orgMat);
//			ScalarMatrix invers = MatrixTools.Invert(orgMat);
//			Console.WriteLine(invers.Calculate());
		}


		[TestFixtureSetUp]
		public void Init()
		{
			Parser p = new Parser();
			p.Provider = new InfixTokenizer();
			matrix = p.Parse("[ [7/10,-4/10,0,0,-3/10,0,0]," +
				"  [-4/10, 9/10, -2/10, -3/10, 0, 0, 0]," +
				"  [0, 0, 1/10, 0, 0, 0, 1/10]," +
				"  [0, 0, 0, 1, -1/10, 0, -9/10]," +
				"  [0, 0, 0, -5/10, 1, -5/10, 0]," +
				"  [0, 0, 0, 0, 0, 9/10, -9/10]," +
				"  [0, 0, 0, 0, 0, 0, 1]]") as IMatrixExpression;
		}

		private IMatrixExpression matrix;
	}
}

#endif