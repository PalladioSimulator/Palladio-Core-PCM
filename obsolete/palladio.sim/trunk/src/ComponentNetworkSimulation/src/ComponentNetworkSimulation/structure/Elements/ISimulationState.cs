using System;

namespace ComponentNetworkSimulation.Structure.Elements
{
	/// <summary>
	/// This interface defines the states in the fsm of the services in this framework.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/06/17 12:07:35  joemal
	/// change namespace from service to elements
	///
	/// Revision 1.1  2004/05/18 16:27:22  joemal
	/// initial creation
	///
	/// Revision 1.1  2004/05/18 15:42:06  joemal
	/// initial creation
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