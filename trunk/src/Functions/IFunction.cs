/*
 * $Id$
 * 
 * $Log$
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

namespace Palladio.Reliability.Functions
{
	/// <summary>
	/// </summary>
	public interface IFunction : ICloneable
	{
		/// <summary>
		/// Returns the function value at position x. 
		/// So, it's f(x).
		/// </summary>
		double this[double x] { get; }

		/// <summary>
		/// Scales this function by a.
		/// </summary>
		/// <param name="a"></param>
		void Scale(double a);

		/// <summary>
		/// Returns this function scaled by a.
		/// </summary>
		/// <param name="a"></param>
		/// <returns></returns>
		IFunction GetScaled(double a);

		/// <summary>
		/// Creates the convolution of this function with
		/// aFunction.
		/// </summary>
		IFunction Convolution(IFunction g);

		/// <summary>
		/// Adds aFunction to this function.
		/// </summary>
		IFunction Sum(IFunction g);

		/// <summary>
		/// Returns f(x) + a * g(x)
		/// </summary>
		IFunction ScaledSum(double a, IFunction g);

		/// <summary>
		/// Returns the integral F of this function starting at 0.
		/// </summary>
		IFunction Integral();

		/// <summary>
		/// Returns the multiplication of this function by g.
		/// </summary>
		IFunction Multiply(IFunction g);

	}
}