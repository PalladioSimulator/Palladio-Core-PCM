using System;
using Palladio.Simulation.Analysis;


namespace Palladio.Simulation
{
	/// <summary>
	/// This is the default simulationenvironment. This environment can be used with the default environment factory
	/// of the framework or with a modified one.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.3  2004/07/29 15:13:47  joemal
	/// - changes from the review
	///
	/// Revision 1.2  2004/07/22 20:28:18  joemal
	/// - changed some comments
	///
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
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
		/// constructs a new <c>DefaultSimulationEnvironment</c>. It uses the default environment factory of
		/// the framework.
		/// </summary>
		public DefaultSimulationEnvironment()
		{
			factory = new DefaultEnvironmentFactory();
			Inilize();
		}

		/// <summary>
		/// constructs a new <c>DefaultSimulationEnvironment</c>. It uses the given factory to
		/// configure the framework.
		/// </summary>
		/// <param name="factory">the factory that is used to configure the framework</param>
		public DefaultSimulationEnvironment(IEnvironmentFactory factory)
		{
			this.factory = factory;
			Inilize();
		}

		#endregion

		#region methods

		/// <summary>
		/// called by the constructor in order to let the implementing classes initiate the clock, the componentnetwork
		/// and the datapools. Refere to the components using the properties Clock and ComponentNetwork.
		/// </summary>
		protected virtual void Inilize()
		{
		}


		/// <summary>
		/// returns the clock, created by the factory.
		/// </summary>
		/// <returns>the instance of IClock, created by the factory</returns>
		protected override Palladio.Simulation.Simulation.IClock CreateClock()
		{
			return DefaultEnvironmentFactory.CreateDefaultClock(this);
		}

		/// <summary>
		/// returns the component architecture, created by the factory.
		/// </summary>
		/// <returns>the instance of IComponentArchitecture, created by the factory</returns>
		protected override Palladio.Simulation.Model.IComponentArchitecture CreateComponentArchitecture()
		{
			return DefaultEnvironmentFactory.CreateDefaultComponentArchitecture(this);
		}

		/// <summary>
		/// This method is left empty. In this implementation, the threads must be created by using external methods.
		/// </summary>
		protected override void CreateSystemSimulationThreads()
		{			
		}

		#endregion
	}
}
//EOF