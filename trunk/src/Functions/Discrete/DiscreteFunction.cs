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
	/// </summary>
	internal class DiscreteFunction : IFunction
	{
		private double[] values;
		private double distance;
		private double xmin;
		private double xPosLimit;
		private double xNegLimit;

		public double XMin
		{
			get { return xmin; }
		}

		public double[] Values
		{
			get { return values; }
		}

		public double Distance
		{
			get { return distance; }
		}

		public double this[double x]
		{
			get
			{
				double pos = System.Math.Round(1/distance*(x - XMin), 2);
				if (pos >= values.Length)
					return xPosLimit;
				if (pos < 0)
					return xNegLimit;
				int ipos = (int) pos;

				// value interpolation
				double mid = pos - (double) ipos;
				if (mid > 0)
				{
					if (ipos < values.Length - 1)
						return values[ipos]*(1 - mid) + values[ipos + 1]*(mid);
				}
				else if (mid < 0)
				{
					if (ipos > 0)
						return values[ipos]*(1 + mid) + values[ipos - 1]*(-mid);
				}
				return values[ipos];
			}
		}

		public DiscreteFunction(double[] values, double distance, double origin, double xPosLimit, double xNegLimit)
		{
			this.values = values;
			this.distance = distance;
			this.xmin = origin;
			this.xPosLimit = xPosLimit;
			this.xNegLimit = xNegLimit;
		}

		public DiscreteFunction(DiscreteFunction df)
		{
			this.distance = df.distance;
			this.xmin = df.xmin;
			this.xPosLimit = df.xPosLimit;
			this.xNegLimit = df.xNegLimit;
			distance = df.distance;
			values = new double[df.values.Length];
			df.values.CopyTo(values, 0);
		}

		public void Scale(double factor)
		{
			xNegLimit *= factor;
			xPosLimit *= factor;
			for (int i = 0; i < values.Length; i++)
				values[i] *= factor;
		}

		public object Clone()
		{
			return new DiscreteFunction(this);
		}

		public double XMax
		{
			get { return XMin + values.Length*distance; }
		}
	}
}