/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 */
namespace Palladio.Reliability.Functions.Discrete
{
	/// <summary>
	/// Creates Functions.
	/// </summary>
	internal class DiscreteFactory : IFunctionFactory
	{
		private double precision;
		private double xmax;
		private double xmin;
		private double width;
		private int length;


		public DiscreteFactory(double precision, double xmax, double xmin)
		{
			this.precision = precision;
			this.xmax = xmax;
			this.xmin = xmin;
			this.width = xmax - xmin;
			this.length = (int) (width/precision);
		}

		public IFunction CreateExponentialDistribution(double rate)
		{
			double[] values = new double[length];
			double x = xmin;
			double lambda = 1/rate;
			for (int i = 0; i < length; i++)
			{
				values[i] = lambda*System.Math.Exp(-x*lambda);
				x += precision;
			}
			return new DiscreteFunction(values, precision, 0, 0, 0);
		}

		public IFunction CreateConstantFunction(double c)
		{
			double[] values = new double[1];
			values[0] = c;
			return new DiscreteFunction(values, precision, 0, c, c);
		}

		public IFunction CreateDiracFunction()
		{
			double[] values = new double[1];
			values[0] = 1.0/precision;
			return new DiscreteFunction(values, precision, 0, 0, 0);
		}

		public IFunction Copy(IFunction f)
		{
			double[] values = new double[length];
			double x = xmin;
			for (int i = 0; i < length; i++)
			{
				values[i] = f[x];
				x += precision;
			}
			return new DiscreteFunction(values, precision, xmin, f[xmax + 1], f[xmin - 1]);
		}

		/// <summary>
		/// Returns a discrete version of the function, 
		/// suitable for this factory.
		/// </summary>
		/// <param name="f"></param>
		/// <returns></returns>
		private DiscreteFunction MakeDiscrete(IFunction f)
		{
			if (f is DiscreteFunction)
			{
				DiscreteFunction df = (DiscreteFunction) f;
				if (df.Distance == precision)
					return df;
			}
			return (DiscreteFunction) Copy(f);
		}

		private double GetXMin(IFunction f)
		{
			if (f is DiscreteFunction)
				return ((DiscreteFunction) f).XMin;
			else return xmin;
		}

		private double GetXMax(IFunction f)
		{
			if (f is DiscreteFunction)
				return ((DiscreteFunction) f).XMax;
			else return xmax;
		}


		/// <summary>
		/// Convolution, optimised for discrete functions.
		/// <code>
		/// conv[n] += df.Values[m] * dh.Values[n - m];
		/// </code>
		/// This line is the actual convolution. The rest of the code 
		/// is optimisation.
		/// </summary>
		/// <param name="f"></param>
		/// <param name="g"></param>
		/// <returns></returns>
		public IFunction Convolution(IFunction f, IFunction g)
		{
			DiscreteFunction df, dg;
			df = MakeDiscrete(f);
			dg = MakeDiscrete(g);

			double[] conv = new double[df.Values.Length + dg.Values.Length];
			int s = - dg.Values.Length;

			for (int n = 0; n < conv.Length; n++)
			{
				double c = 0;
				s++;
				for (int m = s > 0 ? s : 0; (m <= n) && (m < df.Values.Length); m++)
				{
					c += df.Values[m]*dg.Values[n - m];
				}
				conv[n] = c*precision;
			}
			return new DiscreteFunction(conv, precision, df.XMin + dg.XMin, 0, 0);
		}

		public IFunction Sum(IFunction f, IFunction g)
		{
			return ScaledSum(f, g, 1.0);
		}

		public IFunction ScaledSum(IFunction f, IFunction g, double a)
		{
			double tXMin = System.Math.Min(GetXMin(f), GetXMin(g));
			double tXMax = System.Math.Max(GetXMax(f), GetXMax(g));
			double tWidth = tXMax - tXMin;
			int tLength = (int) (tWidth*1/precision);

			double[] sum = new double[tLength];
			double x = tXMin;
			for (int i = 0; i < sum.Length; i++)
			{
				sum[i] = f[x] + a*g[x];
				x += precision;
			}
			// use the values next to the borders as limits
			double tPosLimit = f[tXMax + 1] + a*g[tXMax + 1];
			double tNegLimit = f[tXMin - 1] + a*g[tXMin - 1];
			return new DiscreteFunction(sum, precision, tXMin, tPosLimit, tNegLimit);
		}
	}
}