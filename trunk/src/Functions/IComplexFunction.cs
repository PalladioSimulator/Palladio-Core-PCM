/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/11/08 03:50:06  sliver
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
using System;
using MathNet.Numerics;

namespace Palladio.Reliability.Functions
{
	/// <summary>
	/// </summary>
	public interface IComplexFunction
	{
		/// <summary>
		/// Returns the function value at position x. 
		/// So, it's f(x).
		/// </summary>
		Complex this[double x] { get; }

		/// <summary>
		/// Scales this function by a.
		/// </summary>
		/// <param name="a"></param>
		void Scale(Complex a);

		/// <summary>
		/// Returns this function scaled by a.
		/// </summary>
		/// <param name="a"></param>
		/// <returns></returns>
		IComplexFunction GetScaled(Complex a);

		/// <summary>
		/// Creates the convolution of this function with
		/// g.
		/// </summary>
		IComplexFunction Convolution(IComplexFunction g);

		/// <summary>
		/// Adds aFunction to this function.
		/// </summary>
		IComplexFunction Sum(IComplexFunction g);

		/// <summary>
		/// Returns f(x) + a * g(x)
		/// </summary>
		IComplexFunction ScaledSum(Complex a, IComplexFunction g);

		/// <summary>
		/// Returns the integral F of this function starting at 0.
		/// </summary>
		IComplexFunction Integral();

		/// <summary>
		/// Returns the multiplication of this function by g.
		/// </summary>
		IComplexFunction Multiply(IComplexFunction g);

		/// <summary>
		/// Computes the fourier transform of this function.
		/// </summary>
		IComplexFunction FourierTransform();
		
		/// <summary>
		/// Computes the inverse fourier transform of this function.
		/// </summary>
		/// <returns></returns>
		IComplexFunction InverseFourierTransform();
	}
}