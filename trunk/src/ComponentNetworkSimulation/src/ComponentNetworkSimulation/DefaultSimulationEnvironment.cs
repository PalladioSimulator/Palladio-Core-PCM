using System;

namespace ComponentNetworkSimulation
{
	/// <summary>
	/// This is the default simulation environments. This environment can be used with the default environment factory
	/// of the framework or by a modified one.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/06/22 17:04:37  joemal
	/// inital class creation
	///
	///
	/// </pre>
	/// </remarks>
	public class DefaultSimulationEnvironment : AbstractSimulationEnvironment
	{
		#region data
		
		/// <summary>
		/// holds the environment factory
		/// </summary>
		private IEnvironmentFactory factory;

		#endregion

		#region properties

		/// <summary>
		/// returns the factory, used to configure the whole framework.
		/// </summary>
		public override IEnvironmentFactory EnvironmentFactory
		{
			get
			{
				return factory;
			}
		}

		#endregion

		#region constructor

		/// <summary>
		/// constructs a new DefaultSimulationEnvironment which is using the default environment factory of
		/// the framework.
		/// </summary>
		public DefaultSimulationEnvironment() : base()
		{
			factory = new DefaultEnvironmentFactory();
		}

		/// <summary>
		/// constructs a new DefaultSimulationEnvironment which is using the given environment factory.
		/// </summary>
		/// <param name="factory">the factory that should be used to configure the framework</param>
		public DefaultSimulationEnvironment(IEnvironmentFactory factory)
		{
			this.factory = factory;
		}

		#endregion

		#region methods

		/// <summary>
		/// return the default clock.
		/// </summary>
		/// <returns>the default clock</returns>
		protected override ComponentNetworkSimulation.Simulation.IClock CreateClock()
		{
			return DefaultEnvironmentFactory.CreateDefaultClock(this);
		}

		/// <summary>
		/// return the default component architecture.
		/// </summary>
		/// <returns>the default component artchitecture</returns>
		protected override ComponentNetworkSimulation.Structure.IComponentArchitecture CreateComponentArchitecture()
		{
			return DefaultEnvironmentFactory.CreateDefaultComponentArchitecture(this);
		}

		/// <summary>
		/// return the default datapool
		/// </summary>
		/// <returns>the default datapool</returns>
		protected override ComponentNetworkSimulation.Analysis.IDataPool CreateDataPool()
		{
			return DefaultEnvironmentFactory.CreateDefaultDataPool(this);
		}

		/// <summary>
		/// The method is left empty. In this implementation, the threads must be created by external methods
		/// </summary>
		protected override void CreateSystemSimulationThreads()
		{			
		}

		#endregion
	}
}
//EOF