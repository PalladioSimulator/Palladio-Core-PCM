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

namespace Palladio.Reliability.Functions.Discrete
{
	/// <summary>
	/// Creates discrete functions.
	/// </summary>
	public class DiscreteFactory : IFunctionFactory
	{
		#region Data

		/// <summary>
		/// Precision for the created functions.
		/// </summary>
		private double precision;

		/// <summary>
		/// Default maximum for the greatest x value that has an associated function value.
		/// </summary>
		private double xmax;

		/// <summary>
		/// Default minimum for the smallest x value that has an associated function value.
		/// </summary>
		private double xmin;

		/// <summary>
		/// xmax - xmin.
		/// </summary>
		private double width;

		/// <summary>
		/// Default length of the value array: width / precision
		/// </summary>
		private int length;
		#endregion

		#region Constructor

		/// <summary>
		/// Creates discrete function factory. 
		/// </summary>
		/// <param name="precision">Precision of all functions created.</param>
		/// <param name="xmin">Default minimum for the smallest x value that has an associated function value.</param>
		/// <param name="xmax">Default maximum for the greatest x value that has an associated function value.</param>
		public DiscreteFactory(double precision, double xmin, double xmax)
		{
			this.precision = precision;
			this.xmax = xmax;
			this.xmin = xmin;
			this.width = xmax - xmin;
			this.length = (int) (width/precision);
		}
		#endregion

		#region IFunctionFactory

		public IRealFunction CreateExponentialDistribution(double rate)
		{
			double[] values = new double[length];
			double x = xmin;
			double lambda = 1/rate;
			for (int i = 0; i < length; i++)
			{
				values[i] = lambda*System.Math.Exp(-x*lambda);
				x += precision;
			}
			return new DiscreteFunction(values, precision, 0, 0, 0, this);
		}

		public IRealFunction CreateConstantFunction(double c)
		{
			double[] values = new double[1];
			values[0] = c;
			return new DiscreteFunction(values, precision, 0, c, c, this);
		}

		public IRealFunction CreateDiracFunction()
		{
			double[] values = new double[1];
			values[0] = 1.0/precision;
			return new DiscreteFunction(values, precision, 0, 0, 0, this);
		}

		public IRealFunction Copy(IRealFunction f)
		{
			double[] values = new double[length];
			double x = xmin;
			for (int i = 0; i < length; i++)
			{
				values[i] = f[x];
				x += precision;
			}
			return new DiscreteFunction(values, precision, xmin, f[xmax + 1], f[xmin - 1], this);
		}
		#endregion

		#region Helper Methods

		/// <summary>
		/// Returns a discrete version of the function that is 
		/// suitable for this factory.
		/// </summary>
		/// <param name="f"></param>
		/// <returns></returns>
		internal DiscreteFunction MakeDiscrete(IRealFunction f)
		{
			if (f is DiscreteFunction)
			{
				DiscreteFunction df = (DiscreteFunction) f;
				if (df.Precision == precision)
					return df;
			}
			return (DiscreteFunction) Copy(f);
		}

		/// <summary>
		/// Returns the first x value of f for which an entry
		/// in the value array exists, if f is discrete. Otherwise,
		/// the default minimum x value is returned.
		/// </summary>
		/// <param name="f"></param>
		/// <returns></returns>
		internal double GetXMin(IRealFunction f)
		{
			if (f is DiscreteFunction)
				return ((DiscreteFunction) f).XMin;
			else return xmin;
		}

		/// <summary>
		/// Returns the last x value of f for which an entry
		/// in the value array exists, if f is discrete. Otherwise,
		/// the default maximum x value is returned.
		/// </summary>
		/// <param name="f"></param>
		/// <returns></returns>
		internal double GetXMax(IRealFunction f)
		{
			if (f is DiscreteFunction)
				return ((DiscreteFunction) f).XMax;
			else return xmax;
		}
		#endregion
	}
}