using System;

namespace ComponentNetworkSimulation
{
	/// <summary>
	/// This Interface defines all methods and properties provided by the simulationenvironment.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.3  2004/05/26 16:37:22  joemal
	/// add cvs log tag
	///
	/// </pre>
	/// </remarks>
	public interface ISimulationEnvironment
	{
		#region methods

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
		/// return the ComponentNetwork of the environment. 
		/// </summary>
		ComponentNetworkSimulation.Structure.AbstractComponentNetwork TheComponentNetwork 
		{
			get;			
		}

		/// <summary>
		/// return the datapool of the environment. 
		/// </summary>
		ComponentNetworkSimulation.Analysis.IDataPool DataPool
		{
			get;
		}

		#endregion
	}
}
//EOF
