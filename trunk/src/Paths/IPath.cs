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
using System;
using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.Paths
{
	/// <summary>
	/// A path is a set of connected transitions. Each state in a path has 
	/// exactly one predecessor and one successor. Exceptions are the entrance 
	/// state and exit state. Both have a predecessor and/or successor if the 
	/// path is a cycle, otherwise not.
	/// </summary>
	public interface IPath : ICloneable
	{
		/// <summary>
		/// Entry point of the path. Generally, it is the first state 
		/// of the connected transitions. For a cycle it can be any state.
		/// </summary>
		IState EntryState { get; set; }

		/// <summary>
		/// Exit point of the path. Generally, it is the last state 
		/// of the connected transitions. For a cycle is the same as 
		/// the entry state.
		/// </summary>
		IState ExitState { get; }

		/// <summary>
		/// True, if the path is a cycle.
		/// </summary>
		bool IsCycle { get; }

		/// <summary>
		/// Returns the next transition from aSourceState. If aSourceState
		/// is the exit state an exception is thrown.
		/// </summary>
		/// <param name="aSourceState"></param>
		/// <returns></returns>
		ITransition GetNextTransition(IState aSourceState);

		/// <summary>
		/// Returns the next state from aSourceState. If aSourceState
		/// is the exit state an exception is thrown.
		/// </summary>
		/// <param name="aSourceState"></param>
		/// <returns></returns>
		IState GetNextState(IState aSourceState);

		/// <summary>
		/// Returns the next input symbol from aSourceState. If aSourceState
		/// is the exit state an exception is thrown.
		/// </summary>
		/// <param name="aSourceState"></param>
		/// <returns></returns>
		IInput GetNextInput(IState aSourceState);

		/// <summary>
		/// Checks if the path contains aState.
		/// </summary>
		/// <param name="aState"></param>
		/// <returns></returns>
		bool Contains(IState aState);

		/// <summary>
		/// Checks if the path contains anInput.
		/// </summary>
		/// <param name="anInput"></param>
		/// <returns></returns>
		bool Contains(IInput anInput);

		/// <summary>
		/// Appends aTransition at the end of the path.
		/// Therefore: aTransition.SourceState == ExitState.
		/// The new ExitState is the destination of aTransition.
		/// </summary>
		/// <param name="aTransition"></param>
		void Append(ITransition aTransition);

		/// <summary>
		/// Checks if aState is the entry point of the path.
		/// </summary>
		/// <param name="aState"></param>
		/// <returns></returns>
		bool IsEntryState(IState aState);

		/// <summary>
		/// Checks if aState is the exit point of the path.
		/// </summary>
		/// <param name="aState"></param>
		/// <returns></returns>
		bool IsExitState(IState aState);

		/// <summary>
		/// Number of transitions of the path.
		/// </summary>
		int Length { get; }

		/// <summary>
		/// The states visited in on the path.
		/// </summary>
		IState[] States { get; }

		/// <summary>
		/// Two path overlap, if they have a common subset of states.
		/// </summary>
		/// <param name="path"></param>
		/// <returns></returns>
		bool Overlaps(IPath path);
	}
}