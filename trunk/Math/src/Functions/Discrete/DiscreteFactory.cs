using System;
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
	/// Creates discrete functions.
	/// </summary>
	internal class DiscreteFactory : IDiscreteFunctionFactory
	{
		#region Data

		private double samplingRate;
		private double xmax;
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

		/// <summary>
		/// Precision for the created functions.
		/// </summary>
		public double SamplingRate
		{
			get { return samplingRate; }
			set
			{
				samplingRate = value;
				SetValues();
			}
		}


		/// <summary>
		/// Default maximum for the greatest x value that has an associated function value.
		/// </summary>
		public double XMax
		{
			get { return xmax; }
			set
			{
				xmax = value;
				SetValues();
			}
		}

		/// <summary>
		/// Default minimum for the smallest x value that has an associated function value.
		/// </summary>
		public double XMin
		{
			get { return xmin; }
			set
			{
				xmin = value;
				SetValues();
			}
		}

		/// <summary>
		/// Creates a new function using a set of values. The sampling rate
		/// for those values must correspond to the sampling rate of the factory.
		/// Also the start value must be a multiple of the sampling rate.
		/// All values other than the given ones are set to zero.
		/// </summary>
		/// <param name="xStart">Position on the x axis for the first value in the value array.</param>
		/// <param name="values">Ordered set of values describing the function.</param>
		/// <returns></returns>
		public IFunction DiscreteValueFunction(double xStart, double[] values)
		{
			return new DiscreteFunction(values, samplingRate, xStart, 0, 0);
		}

		#region Constructor

		/// <summary>
		/// Creates discrete function factory. 
		/// </summary>
		public DiscreteFactory()
		{
			this.samplingRate = 0.1;
			this.xmax = 10;
			this.xmin = 0;
			SetValues();
		}



		#endregion

		#region IFunctionFactory

		public IFunction ExponentialDistribution(double rate)
		{
			double[] values = new double[length];
			double x = xmin;
			double lambda = 1/rate;
			for (int i = 0; i < length; i++)
			{
				values[i] = lambda*System.Math.Exp(-x*lambda);
				x += samplingRate;
			}
			return new DiscreteFunction(values, samplingRate, 0, 0, 0);
		}

		public IFunction ConstantFunction(double c)
		{
			double[] values = new double[1];
			values[0] = c;
			return new DiscreteFunction(values, samplingRate, 0, c, c);
		}

		public IFunction DiracDeltaFunction()
		{
			double[] values = new double[1];
			values[0] = 1.0/samplingRate;
			return new DiscreteFunction(values, samplingRate, 0, 0, 0);
		}

		public IFunction Copy(IRealFunction f)
		{
			double[] values = new double[length];
			double x = xmin;
			for (int i = 0; i < length; i++)
			{
				values[i] = f.ValueOf(x);
				x += samplingRate;
			}
			return new DiscreteFunction(values, samplingRate, xmin, f.ValueOf(xmax + 1), f.ValueOf(xmin - 1));
		}

		public object Clone()
		{
			DiscreteFactory copy = new DiscreteFactory();
			copy.XMax = this.XMax;
			copy.XMin = this.XMin;
			copy.SamplingRate = this.SamplingRate;
			return copy;
		}
		#endregion

		#region Helper

		private void SetValues()
		{
			this.width = xmax - xmin;
			this.length = (int) (width/samplingRate);
		}

		#endregion
	}
}