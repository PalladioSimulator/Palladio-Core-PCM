using System;
using System.Diagnostics;
using MathNet.Numerics;
using Palladio.Reliability.Math;
/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/12/15 00:05:13  sliver
 * initial checkin after some major refactorings
 *
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

namespace Palladio.Reliability.Math.Functions
{
	/// <summary>
	/// </summary>
	internal class DiscreteFunction : IDiscreteFunction
	{
		private const double MINIMAL_INTEGRAL_PRECISION = 0.001;

		#region Data

		/// <summary>
		/// Array of function values.
		/// </summary>
		private double[] data;

		/// <summary>
		/// Distance between two function values.
		/// </summary>
		private double samplingRate;

		/// <summary>
		/// Minimal x value for which a value is listed in the value array.
		/// </summary>
		private double xmin;

		/// <summary>
		/// Positiv limit of the function. If x > XMax this value is returned.
		/// </summary>
		private double posLimit;

		/// <summary>
		/// Negative limit of the function. If x < XMin this value is returned.
		/// </summary>
		private double negLimit;

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
			get { return XMin + data.Length*SamplingRate; }
		}

		/// <summary>
		/// Array of discrete function values.
		/// </summary>
		public double[] Data
		{
			get { return data; }
		}

		public int Count
		{
			get { return data.Length; }
		}

		/// <summary>
		/// Distance (x-axis) between two entries in the value array.
		/// </summary>
		public double SamplingRate
		{
			get { return samplingRate; }
		}
		#endregion

		#region Methods

		/// <summary>
		/// Expands the domain of the function to the new value of xMax.
		/// All new values are set to zero.
		/// </summary>
		/// <param name="xMax"></param>
		public void ExpandDomain(double xMax)
		{
			if(xMax < XMax)
				throw new ApplicationException("New value for xMax must be greater than "+XMax+"!");
			long length = (long)((xMax - XMin) / samplingRate);
			double[] newData = new double[length];
			data.CopyTo(newData,0);
			for (int i=data.Length; i<newData.Length; i++)
			{
				newData[i] = 0;
			}
			data = newData;
		}
		#endregion

		
		#region Constructors

		/// <summary>
		/// Creates new function.
		/// </summary>
		/// <param name="values">Array of function values.</param>
		/// <param name="samplingRate">x distance of the values in the array.</param>
		/// <param name="xmin">x value for the first entry in the value array.</param>
		/// <param name="xPosLimit">Function value for x > XMax.</param>
		/// <param name="xNegLimit">Function value for x < XMin.</param>
		internal DiscreteFunction(double[] values, double samplingRate, double xmin, double xPosLimit, double xNegLimit)
		{
			this.data = values;
			this.samplingRate = samplingRate;
			this.xmin = xmin;
			this.posLimit = xPosLimit;
			this.negLimit = xNegLimit;
		}

		/// <summary>
		/// Copy Constructor.
		/// </summary>
		/// <param name="df"></param>
		internal DiscreteFunction(DiscreteFunction df)
		{
			this.samplingRate = df.samplingRate;
			this.xmin = df.xmin;
			this.posLimit = df.posLimit;
			this.negLimit = df.negLimit;
			samplingRate = df.samplingRate;
			data = new double[df.data.Length];
			df.data.CopyTo(data, 0);
		}
		#endregion



		#region IFunction

		public void Scale(double factor)
		{
			negLimit *= factor;
			posLimit *= factor;
			for (int i = 0; i < data.Length; i++)
				data[i] *= factor;
		}

		public IFunction GetScaled(double a)
		{
			DiscreteFunction df = new DiscreteFunction(this);
			df.Scale(a);
			return df;
		}

		/// <summary>
		/// Convolution for discrete functions.
		/// </summary>
		public IFunction Convolution(IRealFunction g)
		{
			IDiscreteFunction dg;
			if (g is IDiscreteFunction)
				dg = g as IDiscreteFunction;
			else
				throw new ApplicationException("Convolution is only implemented for discrete Functions!");

			// both functions must have the same sampling rate.
			if(this.SamplingRate != dg.SamplingRate)
				throw new ApplicationException("Both functions must have the same sampling rate!");

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
				// value array. in the analogous world convolution is an integral 
				convolutionValues[i] = convValue*SamplingRate;
			}
			return new DiscreteFunction(convolutionValues, SamplingRate, XMin + dg.XMin, 0, 0);
		}

		public void Add(IRealFunction g)
		{
			double x = this.XMin;
			for (int i=0; i<data.Length; i++)
			{
				data[i] += g.ValueOf(x);
				x+= samplingRate;
			}
			posLimit += g.ValueOf(XMax+1);
			negLimit += g.ValueOf(XMin-1);
		}

		public void AddScaled(double a, IRealFunction g)
		{
			double x = this.XMin;
			for (int i=0; i<data.Length; i++)
			{
				data[i] += a * g.ValueOf(x);
				x+= samplingRate;
			}
			posLimit += a * g.ValueOf(XMax+1);
			negLimit += a * g.ValueOf(XMin-1);
		}

		public IFunction Integral()
		{
			double precision = System.Math.Min(samplingRate, MINIMAL_INTEGRAL_PRECISION);
			double[] integral = new double[(int)(XMax * 1/precision)];
			integral[0] = this.ValueOf(0)*precision;
			double x = precision;
			for (int i = 1; i < integral.Length; i++)
			{
				integral[i] = integral[i - 1] + this.ValueOf(x)*precision;
				x += precision;
			}
			return new DiscreteFunction(integral, precision, 0, integral[integral.Length - 1], 0);
		}

		public void Multiply(IRealFunction g)
		{
			double x = this.XMin;
			for (int i=0; i<data.Length; i++)
			{
				data[i] *= g.ValueOf(x);
				x+= samplingRate;
			}
			posLimit *= g.ValueOf(XMax+1);
			negLimit *= g.ValueOf(XMin-1);
		}

		public object Clone()
		{
			return new DiscreteFunction(this);
		}

		/// <summary>
		/// Returns the function value of x, that is f(x). For x values 
		/// between two discrete values the result is the linear interpolation of
		/// both values.
		/// </summary>
		public double ValueOf(double input)
		{
			double pos = System.Math.Round(1/SamplingRate*(input - XMin), 2);
			if (pos >= data.Length)
				return posLimit;
			if (pos < 0)
				return negLimit;
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
		#endregion
	}
}