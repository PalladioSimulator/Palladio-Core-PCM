/*
 * $Id$
 * 
 * $Log$
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
using NUnit.Framework;

using Palladio.Reliability.Math;

using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Parsing;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Tools;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;

using log4net;
using log4net.Config;

namespace Palladio.Reliability.Tests
{
	[TestFixture]
	public class MathMatrixToolsTest
	{
		[Test]
		public void Invert()
		{
			ScalarMatrix inv = MatrixTools.Invert(matrix);
			IMatrixExpression mult = new MatrixMatrixMultiplication( matrix.Context, matrix, inv );
			ValueMatrix result = mult.Calculate();
			for (int i = 0; i < mult.LengthX; i++)
				for(int j = 0; j < mult.LengthY; j++)
					if ( i == j)
						Assert.AreEqual(1.0, result[i,j], 0.000001);
					else
						Assert.AreEqual(0.0, result[i,j], 0.000001);
		}
		
		[Test]
		public void TestMethod()
		{
			Parser p = new Parser();
			p.Provider = new InfixTokenizer();
			IMatrixExpression orgMat = p.Parse("[[7/10,0,0],[3/10,2/10,0],[0,8/10,0]]") as IMatrixExpression;
			MatrixIdentity identity = new MatrixIdentity(orgMat.Context, new ScalarExpressionValue( orgMat.Context, orgMat.LengthX ));
			orgMat = new MatrixMatrixSubtraction( orgMat.Context, identity.Expand(), orgMat );
			ScalarMatrix invers = MatrixTools.Invert(orgMat);
			Console.WriteLine(invers.Calculate());
		}

		[TestFixtureSetUp]
		public void Init()
		{
			Parser p = new Parser();
			p.Provider = new InfixTokenizer();
			matrix = p.Parse("[[4,2,3],[4,5,6],[7,8,9]]") as IMatrixExpression;
		}
		
		IMatrixExpression matrix;
	}
}
#endif
