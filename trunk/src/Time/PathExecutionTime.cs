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
using Palladio.Reliability.Paths;

namespace Palladio.Reliability.Time
{
	/// <summary>
	/// </summary>
	internal class PathExecutionTime : ExecutionTime, IPathExecutionTime
	{
		private IPath path;

		/// <summary>
		/// Path associated with the execution time.
		/// </summary>
		public IPath Path
		{
			get { return path; }
		}

		public PathExecutionTime(IFunction function, double probability, IPath path) : base(function, probability)
		{
			this.path = path;
		}
	}
}