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
		IFunction CreateExponentialDistribution(double rate);

		/// <summary>
		/// Returns the constant zero function.
		/// This is: f(x) = c.
		/// </summary>
		/// <returns></returns>
		IFunction CreateConstantFunction(double c);

		/// <summary>
		/// Returns the dirac function which is the neutral element
		/// of the convolution. This is:
		/// f(0) = infty and f(x) = 0 for x != 0.
		/// </summary>
		/// <returns></returns>
		IFunction CreateDiracFunction();

		/// <summary>
		/// Creates the convolution of this function with
		/// aFunction.
		/// </summary>
		/// <param name="f"></param>
		/// <returns></returns>
		IFunction Convolution(IFunction f, IFunction g);

		/// <summary>
		/// Adds aFunction to this function.
		/// </summary>
		/// <param name="f"></param>
		/// <returns></returns>
		IFunction Sum(IFunction f, IFunction g);

		/// <summary>
		/// Returns f(x) + a * g(x)
		/// </summary>
		/// <param name="f"></param>
		/// <param name="g"></param>
		/// <param name="a"></param>
		/// <returns></returns>
		IFunction ScaledSum(IFunction f, IFunction g, double a);

		/// <summary>
		/// Creates a copy of f with the parameters given by the factory.
		/// </summary>
		/// <param name="f"></param>
		/// <returns></returns>
		IFunction Copy(IFunction f);

	}
}