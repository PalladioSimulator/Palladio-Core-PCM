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
	public interface IDiscreteFunction : IFunction
	{
		/// <summary>
		/// Values defining the function.
		/// </summary>
		double[] Data {get;}

		/// <summary>
		/// Number of discrete function values.
		/// </summary>
		int Count { get; }

		/// <summary>
		/// Precision of the approximation of the disctrete
		/// function x[n] to the continuous function f(t). That is,
		/// x[n] = f(a*n), where a is the sampling rate. Distance between
		/// two descrete values on the x-axis.
		/// </summary>
		double SamplingRate {get;}

		/// <summary>
		/// First x value for which this function is defined.
		/// </summary>
		double XMin {get;}

		/// <summary>
		/// Last x value for which this function is defined.
		/// </summary>
		double XMax {get;}

		/// <summary>
		/// Expands the domain of the function to the new value of xMax.
		/// All new values are set to zero.
		/// </summary>
		/// <param name="xMax"></param>
		void ExpandDomain(double xMax);
	}
}