using Palladio.Simulation.Model;
using Palladio.Simulation.Simulation;
using Palladio.Simulation.Analysis;
using System.Collections;

namespace Palladio.Simulation
{
	/// <summary>
	/// This is the abstract base class for all simulationenvironments. It holds references to the clock that contains the scheduler, 
	/// to the componentnetwork and to the datapools. Implementing classes have to create the instances of these references.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/07/22 20:28:18  joemal
	/// - changed some comments
	///
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	///
	/// </pre>
	/// </remarks>
	public abstract class AbstractSimulationEnvironment : ISimulationEnvironment
	{
		#region data

		/// <summary>
		/// holds the instance of the clock
		/// </summary>
		private IClock clock = null;
		
		/// <summary>
		/// holds the instance of the component architecture
		/// </summary>
		private IComponentArchitecture componentArchitecture = null;
		
		/// <summary>
		/// holds the list of the registered datapools
		/// </summary>
		private IList dataPools = new ArrayList();

		#endregion

		#region methods

		/// <summary>
		/// call to register the given datapool in the simulationenvironment. After calling the method, the datapool
		/// will receive log events from the simulationenvironment until it is unregistered. 
		/// </summary>
		/// <param name="datapool">the datapool to be registered</param>
		public void RegisterDataPool(Analysis.IDataPool datapool)
		{
			this.Clock.ClockLogEvent += new LogEventHandler(datapool.OnLogEvent);
			this.Clock.ThreadScheduler.ThreadLogEvent += new LogEventHandler(datapool.OnLogEvent);
		}

		/// <summary>
		/// call to unregister the given datapool from the simulationenvironment. After calling this method, the datapool
		/// won't receive logevents any longer.
		/// </summary>
		/// <param name="datapool">the datapool to be unregistered</param>
		public void UnRegisterDataPool(Analysis.IDataPool datapool)
		{
			this.Clock.ClockLogEvent -= new LogEventHandler(datapool.OnLogEvent);
			this.Clock.ThreadScheduler.ThreadLogEvent -= new LogEventHandler(datapool.OnLogEvent);
		}

		/// <summary>
		/// call to start a whole simlution. The simulation ends, when the maximum simulationtime is reached or no more 
		/// threads are alive. Before starting the simulation, a reset is processed through the whole simulationenvironment and 
		/// PrepairSimulation() is called to initiate the startthreads.
		/// </summary>
		public virtual void Simulate()
		{
			this.ResetSimulation();
			this.PrepairSimulation();
			this.DoSimulate();
		}

		/// <summary>
		/// call to let the simulationenvironment do one simulationstep.
		/// </summary>
		/// <returns>false is returned, if no more threads are alive or the maximum simulationtime is reached.</returns>
		public virtual bool SimulationStep()
		{
			return this.Clock.SimulationStep();
		}

		/// <summary>
		/// call to initiate all startthreads. By default, the method CreateSystemSimulationThreads() is called.
		/// </summary>
		public virtual void PrepairSimulation()
		{
			this.CreateSystemSimulationThreads();
		}

		/// <summary>
		/// call to reset the whole simulation environment.
		/// </summary>
		public virtual void ResetSimulation()
		{
			this.Clock.Reset();
			this.ComponentArchitecture.reset();
			foreach(IDataPool datapool in this.dataPools)
				datapool.Reset();
		}

		/// <summary>
		/// called by <code>Simulate()</code> to proceed a whole simulation. By default, the simulation ends, if no more threads 
		/// are alive or the maximum simulation time is reached.
		/// </summary>
		protected virtual void DoSimulate()
		{
			while(Clock.SimulationStep());
		}

		#endregion

		#region properties

		/// <summary>
		/// returns the clock of the environment. The first call to this property creates a new instance by
		/// calling <code>CreateClock()</code>.
		/// </summary>
		public IClock Clock
		{
			get	
			{
				if (this.clock == null) this.clock = CreateClock();
				return this.clock;
			}
		}

		/// <summary>
		/// returns the model of the componentarchitecture of the environment. The first call to this property creates a new 
		/// instance by calling <code>CreateComponentArchitecture()</code>.
		/// </summary>
		public IComponentArchitecture ComponentArchitecture
		{
			get
			{ 
				if (this.componentArchitecture == null) this.componentArchitecture = CreateComponentArchitecture();
				return this.componentArchitecture;
			}
		}

		/// <summary>
		/// returns the factory used to configure the whole framework.
		/// </summary>
		public abstract IEnvironmentFactory EnvironmentFactory
		{
			get;
		}

		#endregion

		#region abstract methods

		/// <summary>
		/// implement this method to initiate the SystemThreads of the simulation.
		/// </summary>
		protected abstract void CreateSystemSimulationThreads();
		
		/// <summary>
		/// implement this method to create a new ínstance of Clock. Don't do any initiations depending on other components, use
		/// <code>Inilize()</code> instead. This method must not return null.
		/// </summary>
		/// <returns>the new instance of IClock.</returns>
		protected abstract IClock CreateClock();

		/// <summary>
		/// implement this method to create a new ínstance of IComponentArchitecture. Don't do any initiations depending on 
		/// other components, use <code>Inilize()</code> instead. This method must not return null.
		/// </summary>
		/// <returns>the new instance of IComponentArchitecture.</returns>
		protected abstract IComponentArchitecture CreateComponentArchitecture();

		#endregion
	}	
}
//EOF