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
using Palladio.Reliability.Functions.Discrete;

namespace Palladio.Reliability.Functions
{
	/// <summary>
	/// </summary>
	public class DefaultFactory
	{
		public static IFunctionFactory Default
		{
			get { return defFactory; }
		}

		private static IFunctionFactory defFactory = new DiscreteFactory(0.1, 20, 0);
	}
}