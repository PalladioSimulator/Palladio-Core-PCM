 /*
 * $Id$
 * 
 * $Log$
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

namespace Palladio.Reliability.Functions
{
	/// <summary>
	/// Abstract Factory pattern.
	/// </summary>
	public interface IFunctionFactory
	{
		/// <summary>
		/// Returns the exponential distribution with a rate.
		/// This is: f(x) = (1 / rate) * exp(- x (1 / rate)).
		/// </summary>
		/// <param name="rate"></param>
		/// <returns></returns>
		IRealFunction CreateExponentialDistribution(double rate);

		/// <summary>
		/// Returns the constant zero function.
		/// This is: f(x) = c.
		/// </summary>
		/// <returns></returns>
		IRealFunction CreateConstantFunction(double c);

		/// <summary>
		/// Returns the dirac function which is the neutral element
		/// of the convolution. This is:
		/// f(0) = infty and f(x) = 0 for x != 0.
		/// </summary>
		/// <returns></returns>
		IRealFunction CreateDiracFunction();

		/// <summary>
		/// Creates a copy of f with the parameters given by the factory.
		/// </summary>
		/// <param name="f"></param>
		/// <returns></returns>
		IRealFunction Copy(IRealFunction f);
	}
}