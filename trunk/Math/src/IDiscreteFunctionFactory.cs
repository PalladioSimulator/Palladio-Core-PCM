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

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// Abstract Factory pattern.
	/// </summary>
	public interface IDiscreteFunctionFactory : IFunctionFactory
	{
		/// <summary>
		/// Precision for the created functions.
		/// </summary>
		double SamplingRate { get; set; }

		/// <summary>
		/// Default maximum for the greatest x value that has an associated function value.
		/// </summary>
		double XMax { get; set; }

		/// <summary>
		/// Default minimum for the smallest x value that has an associated function value.
		/// </summary>
		double XMin { get; set; }

		/// <summary>
		/// Creates a new function using a set of values. The sampling rate
		/// for those values must correspond to the sampling rate of the factory.
		/// Also the start value must be a multiple of the sampling rate.
		/// All values other than the given ones are set to zero.
		/// </summary>
		/// <param name="xStart">Position on the x axis for the first value in the value array.</param>
		/// <param name="values">Ordered set of values describing the function.</param>
		/// <returns></returns>
		IFunction DiscreteValueFunction(double xStart, double[] values);
	}
}