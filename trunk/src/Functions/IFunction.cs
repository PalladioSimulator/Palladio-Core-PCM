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
		/// Scales this function by aFactor.
		/// </summary>
		/// <param name="aFactor"></param>
		void Scale(double aFactor);

		/// <summary>
		/// Unfortunately, a function must know its factory. 
		/// This is required since other methods using this 
		/// function might need a factory to create new functions. 
		/// We don't want to make any assuptions about the type 
		/// of the function (i.e. discrete). So, the method must use
		/// the same Factory as used for the creation of this function.
		/// </summary>
		// IFunctionFactory Factory { get; }
	}
}