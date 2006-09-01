using System;

namespace ComponentNetworkSimulation
{
	/// <summary>
	/// This Interface defines all methods and properties provided by the simulationenvironment.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.6  2004/07/06 12:27:17  joemal
	/// - now more datapools at the same simulation are supported
	///
	/// Revision 1.5  2004/06/22 12:01:56  joemal
	/// add factory to configure the framework
	///
	/// Revision 1.4  2004/06/19 15:59:03  joemal
	/// - now the interface for the component architecture is defined
	///
	/// Revision 1.3  2004/05/26 16:37:22  joemal
	/// add cvs log tag
	///
	/// </pre>
	/// </remarks>
	public interface ISimulationEnvironment
	{
		#region methods

		/// <summary>
		/// call to register the given datapool in the simulationenvironment. After calling the method, the datapool
		/// will receive log events from the simulationenvironment until it is unregistered. 
		/// </summary>
		/// <param name="datapool">the datapool to be registered</param>
		void RegisterDataPool(Analysis.IDataPool datapool);

		/// <summary>
		/// call to unregister the given datapool from the simulationenvironment. After calling this method, the datapool
		/// won't receive logevents any longer.
		/// </summary>
		/// <param name="datapool">the datapool to be unregistered</param>
		void UnRegisterDataPool(Analysis.IDataPool datapool);

		/// <summary>
		/// call to start a whole simlution. 
		/// </summary>
		void Simulate();
		
		/// <summary>
		/// call let the simulation environment make one simulationstep.
		/// </summary>
		/// <returns>false is returned, if no more steps are possible</returns>
		bool SimulationStep();

		/// <summary>
		/// call to inilize all startthreads.
		/// </summary>
		void PrepairSimulation();

		/// <summary>
		/// call to reset the whole simulation environment.
		/// </summary>
		void ResetSimulation();

		#endregion

		#region properties

		/// <summary>
		/// return the clock of the environment. 
		/// </summary>
		ComponentNetworkSimulation.Simulation.IClock Clock
		{
			get;
		}

		/// <summary>
		/// return the model of the component architecture of the environment. 
		/// </summary>
		ComponentNetworkSimulation.Structure.IComponentArchitecture ComponentArchitecture
		{
			get;			
		}

		/// <summary>
		/// returns the factory, used to configure the whole framework.
		/// </summary>
		IEnvironmentFactory EnvironmentFactory
		{
			get;
		}

		#endregion
	}
}
//EOF
