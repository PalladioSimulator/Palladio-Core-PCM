using System;
using Palladio.FiniteStateMachines;

namespace Palladio.Simulation.Model.Elements
{
	/// <summary>
	/// Implementing classes provide the functionality to resolve the indeterminism in FSM with states who have more than
	/// one outgoing transition or who are final states and have outgoing transitions.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IControlFlowStrategy
	{
		/// <summary>
		/// This methods returns the outgoing transition of the state, which was selected by the resolving algorithm.
		/// If state is a final state, null can be returned to indicate, that the path in the fsm reached its end.
		/// To decide which transition is the next, the recursive depth of the state is given.
		/// </summary>
		/// <param name="state">the state, from which the next outgoing transition has to be found</param>
		/// <param name="fsm">the fsm to this state</param>
		/// <returns></returns>
		ITransition GetNextTransition(IState state, IFiniteStateMachine fsm);
	}
}
//EOF
