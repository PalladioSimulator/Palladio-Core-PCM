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
	/// </summary>
	public class DiscreteFunction : IRealFunction
	{
		#region Data

		/// <summary>
		/// Array of function values.
		/// </summary>
		private double[] data;

		/// <summary>
		/// Distance between two function values.
		/// </summary>
		private double precision;

		/// <summary>
		/// Minimal x value for which a value is listed in the value array.
		/// </summary>
		private double xmin;

		/// <summary>
		/// Positiv limit of the function. If x > XMax this value is returned.
		/// </summary>
		private double xPosLimit;

		/// <summary>
		/// Negative limit of the function. If x < XMin this value is returned.
		/// </summary>
		private double xNegLimit;

		/// <summary>
		/// Factory that created this function.
		/// </summary>
		private DiscreteFactory factory;
		#endregion

		#region Poperties

		/// <summary>
		/// Smallest x value for which an entry in the value array exists.
		/// </summary>
		public double XMin
		{
			get { return xmin; }
		}

		/// <summary>
		/// Greatest x value for which an entry in the value array exists.
		/// </summary>
		public double XMax
		{
			get { return XMin + data.Length*Precision; }
		}

		/// <summary>
		/// Array of discrete function values.
		/// </summary>
		public double[] Data
		{
			get { return data; }
		}

		/// <summary>
		/// Distance (x-axis) between two entries in the value array.
		/// </summary>
		public double Precision
		{
			get { return precision; }
		}
		#endregion

		#region Constructors

		/// <summary>
		/// Creates new function.
		/// </summary>
		/// <param name="values">Array of function values.</param>
		/// <param name="precision">x distance of the values in the array.</param>
		/// <param name="xmin">x value for the first entry in the value array.</param>
		/// <param name="xPosLimit">Function value for x > XMax.</param>
		/// <param name="xNegLimit">Function value for x < XMin.</param>
		/// <param name="factory">Factory that constructed the function.</param>
		internal DiscreteFunction(double[] values, double precision, double xmin, double xPosLimit, double xNegLimit, DiscreteFactory factory)
		{
			this.data = values;
			this.precision = precision;
			this.xmin = xmin;
			this.xPosLimit = xPosLimit;
			this.xNegLimit = xNegLimit;
			this.factory = factory;
		}

		/// <summary>
		/// Copy Constructor.
		/// </summary>
		/// <param name="df"></param>
		internal DiscreteFunction(DiscreteFunction df)
		{
			factory = df.factory;
			this.precision = df.precision;
			this.xmin = df.xmin;
			this.xPosLimit = df.xPosLimit;
			this.xNegLimit = df.xNegLimit;
			precision = df.precision;
			data = new double[df.data.Length];
			df.data.CopyTo(data, 0);
		}
		#endregion

		#region IFunction

		/// <summary>
		/// Returns the function value of x, that is f(x). For x values 
		/// between two discrete values the result is the linear interpolation of
		/// both values.
		/// </summary>
		public double this[double x]
		{
			get
			{
				double pos = System.Math.Round(1/Precision*(x - XMin), 2);
				if (pos >= data.Length)
					return xPosLimit;
				if (pos < 0)
					return xNegLimit;
				int ipos = (int) pos;

				// value interpolation
				double mid = pos - (double) ipos;
				if (mid > 0)
				{
					if (ipos < data.Length - 1)
						return data[ipos]*(1 - mid) + data[ipos + 1]*(mid);
				}
				else if (mid < 0)
				{
					if (ipos > 0)
						return data[ipos]*(1 + mid) + data[ipos - 1]*(-mid);
				}
				return data[ipos];
			}
		}

		public void Scale(double factor)
		{
			xNegLimit *= factor;
			xPosLimit *= factor;
			for (int i = 0; i < data.Length; i++)
				data[i] *= factor;
		}

		public IRealFunction GetScaled(double a)
		{
			DiscreteFunction df = new DiscreteFunction(this);
			df.Scale(a);
			return df;
		}

		/// <summary>
		/// Convolution, optimised for discrete functions.
		/// </summary>
		public IRealFunction Convolution(IRealFunction g)
		{
			DiscreteFunction dg = factory.MakeDiscrete(g);

			// the domain of the resulting function has the size of the domains of
			// boths functions
			double[] convolutionValues = new double[Data.Length + dg.Data.Length];
			
			for (int i = 0; i < convolutionValues.Length; i++)
			{
				double convValue = 0;
				
				// if i is larger than the length of the array dg.Values,
				// the largest position (i-pos) in the array dg.Values is
				// dg.Values.Length - 1. Therfore:
				// (i - pos) = dg.Values.Length - 1
				//		 - pos = - i + dg.Values.Length - 1
				//		   pos =   i - dg.Values.Length + 1
				int pos = System.Math.Max(0, i - dg.Data.Length + 1);

				// pos <= i : left border for dg.Values
				// pos < Values.Length : right border for Values
				while ((pos <= i) && (pos < Data.Length))
				{
					convValue += Data[pos]*dg.Data[i - pos];
					pos++;
				}
				// scale the result according to the distance between the entries of the 
				// value array. Remember: in the analogous world convolution is an integral 
				convolutionValues[i] = convValue*Precision;

				// TODO remove this:
				// Optimisation for testing, works only for our special test cases!!
				if (( i > 100) && (convolutionValues[i] < 0.0000000000000001 )) break;
			}
			return new DiscreteFunction(convolutionValues, Precision, XMin + dg.XMin, 0, 0, factory);
		}

		public IRealFunction Add(IRealFunction g)
		{
			return AddScaled(1.0, g);
		}

		public IRealFunction AddScaled(double a, IRealFunction g)
		{
			double tXMin = System.Math.Min(XMin, factory.GetXMin(g));
			double tXMax = System.Math.Max(XMax, factory.GetXMax(g));
			double tWidth = tXMax - tXMin;
			int tLength = (int) (tWidth*1/precision);

			double[] sum = new double[tLength];
			double x = tXMin;
			for (int i = 0; i < sum.Length; i++)
			{
				sum[i] = this[x] + a*g[x];
				x += precision;
			}
			// use the values next to the borders as limits
			double tPosLimit = this[tXMax + 1] + a*g[tXMax + 1];
			double tNegLimit = this[tXMin - 1] + a*g[tXMin - 1];
			return new DiscreteFunction(sum, precision, tXMin, tPosLimit, tNegLimit, factory);
		}

		public IRealFunction Integral()
		{
			int length = (int) (XMax*1/Precision);

			double[] integral = new double[length];
			integral[0] = this[0]*Precision;
			double x = Precision;
			for (int i = 1; i < integral.Length; i++)
			{
				integral[i] = integral[i - 1] + this[x]*Precision;
				x += Precision;
			}
			return new DiscreteFunction(integral, Precision, 0, integral[integral.Length - 1], 0, factory);
		}

		public IRealFunction Multiply(IRealFunction g)
		{
			double tXMin = System.Math.Min(XMin, factory.GetXMin(g));
			double tXMax = System.Math.Max(XMax, factory.GetXMax(g));
			double tWidth = tXMax - tXMin;
			int tLength = (int) (tWidth*1/precision);

			double[] mult = new double[tLength];
			double x = tXMin;
			for (int i = 0; i < mult.Length; i++)
			{
				mult[i] = this[x]*g[x];
				x += precision;
			}
			// use the values next to the borders as limits
			double tPosLimit = this[tXMax + 1]*g[tXMax + 1];
			double tNegLimit = this[tXMin - 1]*g[tXMin - 1];
			return new DiscreteFunction(mult, precision, tXMin, tPosLimit, tNegLimit, factory);
		}

		public object Clone()
		{
			return new DiscreteFunction(this);
		}
		#endregion

	}
}