using ComponentNetworkSimulation.Structure;
using ComponentNetworkSimulation.Simulation;
using ComponentNetworkSimulation.Analysis;
using System.Collections;

namespace ComponentNetworkSimulation
{
	/// <summary>
	/// This is the abstract base class for all simulation environments. It holds references to the clock containing the scheduler, 
	/// to the componentnetwork and to the datapool used to log the simulation. Implementing classes have to create the instances 
	/// of these references.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.10  2004/06/19 15:59:03  joemal
	/// - now the interface for the component architecture is defined
	///
	/// Revision 1.9  2004/05/26 16:37:22  joemal
	/// add cvs log tag
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
		/// holds the instance of component architecture
		/// </summary>
		private IComponentArchitecture componentArchitecture = null;
		
		/// <summary>
		/// holds the datapool
		/// </summary>
		private IDataPool dataPool = null;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new SimulationEnvironment. This constructor call the method Inilize() to let
		/// the implementing classes inilizing the clock, the componentnetwork and the datapool.
		/// </summary>
		public AbstractSimulationEnvironment()
		{
			this.InternalInilize();
		}

		#endregion

		#region methods

		/// <summary>
		/// this method is called by the constructor. Required inilizations are done in this method.
		/// </summary>
		private void InternalInilize()
		{
			Clock.ClockLogEvent += new LogEventHandler(DataPool.OnLogEvent);
			Clock.ThreadScheduler.ThreadLogEvent += new LogEventHandler(DataPool.OnLogEvent);
			this.Inilize();
		}

		/// <summary>
		/// called by the constructor in order to let the implementing classes inilize the clock, the componentnetwork
		/// and the datapool. Refere to the components using the properties Clock, ComponentNetwork and DataPool.
		/// </summary>
		protected virtual void Inilize()
		{
		}

		/// <summary>
		/// call to start a whole simlution. The simulation ends, when maxsimulationtime is reached or no more thread is alive.
		/// Before starting the simulation, a reset is processed through the whole simulation environment and 
		/// PrepairSimulation() is called to inilize the startthreads.
		/// </summary>
		public virtual void Simulate()
		{
			this.ResetSimulation();
			this.PrepairSimulation();
			this.DoSimulate();
		}


		/// <summary>
		/// call let the simulation environment make one simulationstep.
		/// </summary>
		/// <returns>false is returned, if no more thread is alive or the maximum simulationtime is reached.</returns>
		public virtual bool SimulationStep()
		{
			return this.Clock.SimulationStep();
		}

		/// <summary>
		/// call to inilize all startthreads. By default, the method CreateSystemSimulationThreads() is called.
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
			this.DataPool.Reset();
		}

		/// <summary>
		/// called by Simulate to do a whole simulation. By default, the simulation ends, if no more threads are alive or
		/// the maximum simulation time is reached.
		/// </summary>
		protected virtual void DoSimulate()
		{
			while(Clock.SimulationStep());
		}

		#endregion

		#region properties

		/// <summary>
		/// return the clock of the environment. The first call to this properties creates a new instance by
		/// calling CreateClock().
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
		/// return the model of the componentarchitecture of the environment. The first call to this properties creates a new instance by
		/// calling CreateComponentArchitecture().
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
		/// return the datapool of the environment. The first call to this properties creates a new instance by
		/// calling CreateDataPool().
		/// </summary>
		public IDataPool DataPool 
		{
			get
			{ 
				if (this.dataPool == null) this.dataPool = CreateDataPool();
				return this.dataPool;
			}
		}

		#endregion

		#region abstract methods

		/// <summary>
		/// implement this method to inilize the SystemThreads of the simulation.
		/// </summary>
		protected abstract void CreateSystemSimulationThreads();
		
		/// <summary>
		/// implement this method to create a new ínstance of Clock. Do not any inilizations depending on other components, use
		/// Inilize() instead. This method must not return null.
		/// </summary>
		/// <returns>the new instance of Clock.</returns>
		protected abstract IClock CreateClock();

		/// <summary>
		/// implement this method to create a new ínstance of IComponentArchitecture. Do not any inilizations depending on 
		/// other components, use Inilize() instead. This method must not return null.
		/// </summary>
		/// <returns>the new instance of IComponentArchitecture.</returns>
		protected abstract IComponentArchitecture CreateComponentArchitecture();

		/// <summary>
		/// implement this method to create a new ínstance of IDataPool. Do not any inilizations depending on 
		/// other components, use Inilize() instead. This method must not return null.
		/// </summary>
		/// <returns>the new instance of IDataPool.</returns>
		protected abstract IDataPool CreateDataPool();

		#endregion
	}	
}
//EOF