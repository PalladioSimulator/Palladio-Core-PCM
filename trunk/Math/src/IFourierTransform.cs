using System;
using MathNet.Numerics;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// </summary>
	public interface IFourierTransform
	{
		/// <summary>
		/// Transforms a set of complex values from the time space into
		/// the frequency space.
		/// </summary>
		/// <param name="data"></param>
		/// <returns></returns>
		Complex[] Forward(Complex[] data);

		/// <summary>
		/// Transforms a set of real values from the time space into 
		/// the (complex) frequency space.
		/// </summary>
		/// <param name="data"></param>
		/// <returns></returns>
		Complex[] ForwardFromReal(double[] data);

		/// <summary>
		/// Transforms a set of complex values from the frequency 
		/// space to the time space.
		/// </summary>
		/// <param name="data"></param>
		/// <returns></returns>
		Complex[] Backward(Complex[] data);

		/// <summary>
		/// Transforms a set of complex values from the frequency 
		/// space to the time space and converts the result to real
		/// values by neglecting the imaginary part.
		/// </summary>
		/// <param name="data"></param>
		/// <returns></returns>
		double[] BackwardToReal(Complex[] data);
	}
}
