using MathNet.Numerics;

namespace Palladio.Reliability.Fourier
{
	/// <summary>
	/// Zusammenfassung für FourierTransform.
	/// </summary>
	public class FourierTransform
	{
		/// <summary>
		/// if direction is true -> direct
		/// if direction is false -> inverse.
		/// </summary>
		/// <param name="X"></param>
		/// <param name="direction"></param>
		/// <returns></returns>
		public static Complex[] DiscreteFourierTransform(Complex[] X, bool direction)
		{
			Complex[] F = new Complex[X.Length];
			double n = X.Length;
			double f = 1/n; // normalisation factor for unity transform
			Complex d = direction ? -1 : 1; // -1 = direct, 1 = inverse
			Complex w = (d*(2*PI*I)/n).Exp();

			for (int j = 0; j < F.Length; j++)
			{
				F[j] = 0;
				for (int k = 0; k < X.Length; k++)
				{
					F[j] += X[k]*w.Pow(j*k);
				}
				if (!direction)
					F[j].Real *= f;
			}
			return F;
		}


		private FourierTransform()
		{
		}

		private static Complex PI = System.Math.PI;
		private static Complex I = Complex.I;
	}
}