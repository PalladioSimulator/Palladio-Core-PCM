/*
 * $Id$
 * 
 * $Log$
 * Revision 1.3  2004/11/08 03:50:06  sliver
 * *** empty log message ***
 *
 * Revision 1.2  2004/11/04 08:52:13  sliver
 * added regular expressions
 *
 * Revision 1.1  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 */
using NUnit.Framework;
using Palladio.Reliability.Functions.Discrete;

namespace Palladio.Reliability.Functions.Tests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class FunctionFactoryTest
	{
		[Test]
		public void ExpDistribution()
		{
			IRealFunction df = ff.CreateExponentialDistribution(1);
			Assert.AreEqual(System.Math.Exp(-0.5), df[0.5]);
			Assert.AreEqual(System.Math.Exp(-1.55), df[1.55], 0.00000001);
		}

		[Test]
		public void Convolution()
		{
			IRealFunction df1 = ff.CreateExponentialDistribution(1);
			IRealFunction conv = df1.Convolution(df1);
			Assert.AreEqual(0.3682475, conv[1.0], 0.000001);
		}

		[Test]
		public void ScaledSum()
		{
			IRealFunction f = ff.CreateExponentialDistribution(2);
			IRealFunction g = ff.CreateExponentialDistribution(5);
			IRealFunction h = f.AddScaled(3, g);
			double lf = 1.0/2.0;
			double lg = 1.0/5.0;

			double step = 0.0007998933;
			double x = 0;

			while (x < 51)
			{
				Assert.AreEqual(ExpDist(x, lf) + 3*ExpDist(x, lg), h[x], 0.001);
				x += step;
			}
		}

		private double ExpDist(double x, double lambda)
		{
			return lambda*System.Math.Exp(- x*lambda);
		}

		private static DiscreteFactory ff = new DiscreteFactory(0.001, 0.0, 40.0);
	}
}