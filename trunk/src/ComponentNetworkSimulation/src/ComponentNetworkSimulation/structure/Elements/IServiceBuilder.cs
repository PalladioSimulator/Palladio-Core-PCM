using System;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// This interface defines a builder for services of components. It contains methods to add states and transitions, specify 
	/// start and final states and build the service.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/05/20 14:12:22  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IServiceBuilder
	{
		/// <summary>
		/// call to build the service.
		/// </summary>
		/// <returns>the service</returns>
		//TODO: later IService not IFiniteStateMachine, may be some parameters of the service have to be added to this method
		Palladio.FiniteStateMachines.IFiniteStateMachine BuildService();

		/// <summary>
		/// call to add a state to the fsm of the service.
		/// </summary>
		/// <param name="stateParams">the parameters of the state</param>
		/// <exception cref="System.NotSupportedException">
		/// thrown, if no matching state to given parameterstructure can be found.
		/// </exception>
		void AddState(ISimulationStateParams stateParams);

		/// <summary>
		/// call to set all final states in the fsm of the service.
		/// </summary>
		/// <param name="ids">the ids of the states</param>
		void SetFinalStates(string[] ids);

		/// <summary>
		/// call to set the state with the given id as startstate in the fsm of the service
		/// </summary>
		/// <param name="id">the id of the state to be set as startstate</param>
		void SetStartState(string id);

		/// <summary>
		/// return the controlflowstrategy from given type
		/// </summary>
		/// <param name="type">the type of the strategy to be returned</param>
		IControlFlowStrategy GetControlFlowStrategy(int type);

		/// <summary>
		/// call to add a transition connecting two of the states in the fsm of the service. The state are specified by 
		/// there ids. 
		/// </summary>
		/// <param name="sourceStateID">the id of the source state</param>
		/// <param name="externSignaturID"></param>
		/// <param name="destStateID">the id of the destination state</param>
		//TODO: may be the externSignatureID must be changed.
		void AddTransition(string sourceStateID, string externSignaturID, string destStateID);
	}
}
//EOF