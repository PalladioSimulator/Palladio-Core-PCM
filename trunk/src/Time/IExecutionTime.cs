/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/10/25 07:07:22  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 */
using Palladio.Reliability.Functions;

namespace Palladio.Reliability.Time
{
	/// <summary>
	/// </summary>
	public interface IExecutionTime
	{
		/// <summary>
		/// Random variable describing the execution time.
		/// </summary>
		IFunction Function { get; }

		/// <summary>
		/// Do I need this or can I hide it??
		/// </summary>
		double Probability { get; }
	}
}