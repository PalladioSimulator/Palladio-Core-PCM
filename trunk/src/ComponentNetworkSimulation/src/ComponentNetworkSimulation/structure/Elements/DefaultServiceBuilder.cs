using System;
using Palladio.FiniteStateMachines;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// This class is the default implementation of the service builder in the framework.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/05/26 16:32:12  joemal
	/// add cvs log tag
	///
	/// </pre>
	/// </remarks>
	public class DefaultServiceBuilder : IServiceBuilder
	{
		#region constants
		
		/// <summary>
		/// the type that identifies the random strategy
		/// </summary>
		public const int STRATEGY_RANDOM = 0;

		#endregion

		#region data

		//the fsm of the service
		private IEditableFiniteStateMachine fsm = FSMFactory.GetEditableFSM(FSMFactory.CreateEmptyFSM());
		
		#endregion

		#region constructor

		/// <summary>
		/// creates a the default servicebuilder of this framework
		/// </summary>
		public DefaultServiceBuilder()
		{
		}

		#endregion

		#region methods

		/// <summary>
		/// call to build the service.
		/// </summary>
		/// <returns>the service</returns>
		//TODO: later IService not IFiniteStateMachine, may be some parameters of the service have to be added to this method
		public Palladio.FiniteStateMachines.IFiniteStateMachine BuildService()
		{
			return fsm;
		}

		/// <summary>
		/// call to add a state to the fsm of the service.
		/// </summary>
		/// <param name="stateParams">the parameters of the state</param>
		/// <exception cref="System.NotSupportedException">
		/// thrown, if no matching state to given parameterstructure can be found.
		/// </exception>
		public void AddState(ISimulationStateParams stateParams)
		{
			ISimulationState state = null;
			if (stateParams is StaticTimeStateParams)
				state = new DefaultStaticTimeState((StaticTimeStateParams)stateParams);
			else
				throw(new NotSupportedException("No matching state to the given parameterstructure was found."));

			fsm.AddStates(state);
		}

		/// <summary>
		/// call to set all final states in the fsm of the service.
		/// </summary>
		/// <param name="ids">the ids of the states</param>
		public void SetFinalStates(string[] ids)
		{
			IState[] finalStates = new IState[ids.Length];
			for(int a=0;a<ids.Length;a++)
				finalStates[a] = fsm.GetState(ids[a]);
			fsm.FinalStates = finalStates;
		}

		/// <summary>
		/// call to set the state with the given id as startstate in the fsm of the service
		/// </summary>
		/// <param name="id">the id of the state to be set as startstate</param>
		public void SetStartState(string id)
		{
			fsm.StartState = fsm.GetState(id);
		}

		/// <summary>
		/// call to add a transition connecting two of the states in the fsm of the service. The state are specified by 
		/// there ids. 
		/// </summary>
		/// <param name="sourceStateID">the id of the source state</param>
		/// <param name="externSignaturID"></param>
		/// <param name="destStateID">the id of the destination state</param>
		//TODO: may be the externSignatureID must be changed.
		public void AddTransition(string sourceStateID, string externSignaturID, string destStateID)
		{
			//TODO: change this later 
			IInput inp = FSMFactory.CreateDefaultInput(externSignaturID);
			fsm.AddInputSymbols(inp);
			//end this

			fsm.AddTransition(sourceStateID,inp.ID,destStateID);
		}

		/// <summary>
		/// return the controlflowstrategy from given type
		/// </summary>
		/// <param name="type">the type of the strategy to be returned</param>
		public IControlFlowStrategy GetControlFlowStrategy(int type)
		{
			//if (type == xxx)
			//	return XXX.getInstance();
			//else
			return DefaultRandomStrategy.getInstance();
		}

		#endregion
	}
}
//EOF