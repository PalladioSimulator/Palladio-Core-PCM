using System;

namespace Palladio.Simulation.Model.Elements
{
	/// <summary>
	/// This interface defines the states in the fsm of the services in this framework.
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
	public interface ISimulationState : Palladio.FiniteStateMachines.IState, ITimeConsumer
	{
		/// <summary>
		/// returns an instance of IControlFlowStrategy, used to find the path through the fsm.
		/// </summary>
		IControlFlowStrategy ControlFlowStrategy
		{
			get;
		}
	}
}
//EOF