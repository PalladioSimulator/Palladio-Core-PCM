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
using Palladio.Reliability.Paths;

namespace Palladio.Reliability.Time
{
	/// <summary>
	/// </summary>
	public interface IPathExecutionTime : IExecutionTime
	{
		/// <summary>
		/// Path associated with the execution time.
		/// </summary>
		IPath Path { get; }
	}
}