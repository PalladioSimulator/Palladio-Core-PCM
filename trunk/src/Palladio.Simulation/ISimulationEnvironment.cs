using System;

namespace Palladio.Simulation
{
	/// <summary>
	/// This Interface defines all methods and properties provided by the simulationenvironment.
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
		Palladio.Simulation.Simulation.IClock Clock
		{
			get;
		}

		/// <summary>
		/// return the model of the component architecture of the environment. 
		/// </summary>
		Palladio.Simulation.Model.IComponentArchitecture ComponentArchitecture
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
