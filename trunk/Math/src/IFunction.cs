/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/12/15 00:05:13  sliver
 * initial checkin after some major refactorings
 *
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

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// 
	/// </summary>
	public interface IFunction : IRealFunction, ICloneable
	{
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
		IFunction Convolution(IRealFunction g);

		/// <summary>
		/// Adds aFunction to this function.
		/// </summary>
		void Add(IRealFunction g);

		/// <summary>
		/// Adds a * g(x) to this function.
		/// </summary>
		void AddScaled(double a, IRealFunction g);

		/// <summary>
		/// Returns the integral F of this function starting at 0.
		/// </summary>
		IFunction Integral();

		/// <summary>
		/// Returns the multiplication of this function by g.
		/// </summary>
		void Multiply(IRealFunction g);
	}
}