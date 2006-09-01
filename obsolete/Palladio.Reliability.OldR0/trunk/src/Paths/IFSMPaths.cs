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
using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.Paths
{
	/// <summary>
	/// Segmentation of a FSM in its direct paths to the 
	/// final state and cycles.
	/// </summary>
	public interface IFSMPaths
	{
		/// <summary>
		/// Cycles contained in the FSM. 
		/// </summary>
		IPath[] CyclicPaths { get; }

		/// <summary>
		/// Direct Paths to the final state.
		/// </summary>
		IPath[] FinalPaths { get; }

		/// <summary>
		/// Considered FSM.
		/// </summary>
		IFiniteStateMachine FSM { get; }

	}
}