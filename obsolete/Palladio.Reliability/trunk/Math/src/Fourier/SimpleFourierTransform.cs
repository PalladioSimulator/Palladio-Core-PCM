using System;
using MathNet.Numerics;

namespace Palladio.Reliability.Math.Fourier
{
	/// <summary>
	/// Zusammenfassung für FourierTransform.
	/// </summary>
	internal class SimpleFourierTransform : IFourierTransform
	{

		public SimpleFourierTransform()
		{
		}

		public Complex[] Forward(Complex[] data)
		{
			// a negative exponent for the fourier transform 
			// indicates the forward direction
			return Transform(data, -1);
		}

		public Complex[] ForwardFromReal(double[] data)
		{
			Complex[] cdata = new Complex[data.Length];
			for (int i=0; i<data.Length; i++)
				cdata[i] = data[i];
			return Forward(cdata);
		}

		public Complex[] Backward(Complex[] data)
		{
			// a positive exponent for the fourier transform 
			// indicates the forward direction
			Complex[] cresult = Transform(data,1);

			// normalisation of the result after the backwar transformation.
			double f = 1/ (double) cresult.Length; // normalisation factor 
			for( int i=0; i<cresult.Length; i++)
				cresult[i] *= f;
			return cresult;
		}

		public double[] BackwardToReal(Complex[] data)
		{
			Complex[] cresult = Backward(data);
			double[] result = new double[cresult.Length];
			for (int i = 0; i < cresult.Length; i++)
			{
				result[i] = cresult[i].Real;
			}
			return result;
		}

		/// <summary>
		/// if direction is true -> forward
		/// if direction is false -> backward
		/// </summary>
		/// <param name="X"></param>
		/// <param name="direction"></param>
		/// <returns></returns>
		private static Complex[] Transform(Complex[] X, double direction)
		{
			Complex[] F = new Complex[X.Length];
			double n = X.Length;
			Complex w = (direction*(2*PI*I)/n).Exp();

			for (int j = 0; j < F.Length; j++)
			{
				F[j] = 0;
				for (int k = 0; k < X.Length; k++)
				{
					F[j] += X[k]*w.Pow(j*k);
				}
			}
			return F;
		}

		private static Complex PI = System.Math.PI;
		private static Complex I = Complex.I;
	}
}