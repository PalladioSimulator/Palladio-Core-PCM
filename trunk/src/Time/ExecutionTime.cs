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
	internal class ExecutionTime : IExecutionTime
	{
		private IFunction function;
		private double probability;

		public ExecutionTime(IFunction function, double probability)
		{
			this.function = function;
			this.probability = probability;
		}

		/// <summary>
		/// Random variable describing the execution time.
		/// </summary>
		public IFunction Function
		{
			get { return function; }
		}

		/// <summary>
		/// Do I need this or can I hide it??
		/// </summary>
		public double Probability
		{
			get { return probability; }
		}
	}
}