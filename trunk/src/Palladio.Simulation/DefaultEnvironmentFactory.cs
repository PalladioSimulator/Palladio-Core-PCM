using System;
using Palladio.Simulation.Model;
using Palladio.Simulation.Model.Elements;
using Palladio.Simulation.Model.Builder;
using Palladio.Simulation.Model.Visitor;
using Palladio.Simulation.Simulation;
using Palladio.Simulation.Analysis;

namespace Palladio.Simulation
{
	/// <summary>
	/// This is the default environmentfactory of the framework. All returned instances are created from the default classes of the
	/// framework. To replace some of the factories, override the properties and return the new onces. This is the only factory,
	/// that can be extended.
	///  
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.4  2004/07/29 15:13:47  joemal
	/// - changes from the review
	///
	/// Revision 1.3  2004/07/28 15:34:46  sbecker
	/// Review comments added
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
	public class DefaultEnvironmentFactory : IEnvironmentFactory
	{
		#region data

		/// <summary>
		/// holds the instance of IElementFactory
		/// </summary>
		private IElementFactory elementFactory;

		/// <summary>
		/// holds the instance of IBuilderFactory
		/// </summary>
		private IBuilderFactory builderFactory;

		/// <summary>
		/// holds the instance of IVisitorFactory
		/// </summary>
		private IVisitorFactory visitorFactory;

		#endregion

		#region constructors
        
		/// <summary>
		/// called to create the environment factory. The default factories of the framework are used.
		/// </summary>
		public DefaultEnvironmentFactory() 
		{
		}

		/// <summary>
		/// called to create the environment factory. The factory uses the given instances of factories, if they are not null.
		/// In case of null, the default factory of the framework is used. 
		/// </summary>
		/// <param name="elementFactory">the factory, that is used to create the elements of the architecture</param>
		/// <param name="builderFactory">the factory, that creates the builder for the architecture</param>
		/// <param name="visitorFactory">the factory, that creates the visitors, used to navigate through 
		/// the components and services of the architecture.</param>
		public DefaultEnvironmentFactory(IElementFactory elementFactory, IBuilderFactory builderFactory, 
			IVisitorFactory visitorFactory)
		{
			this.elementFactory = elementFactory;
			this.builderFactory = builderFactory;
			this.visitorFactory = visitorFactory;
		}

		#endregion

		#region create methods

		/// <summary>
		/// return the used instance of IElementFactory. By default, this is the default one of the framework.
		/// </summary>
		public virtual IElementFactory ArchitectureElementFactory
		{
			get
			{
				if (elementFactory == null) elementFactory = CreateDefaultElementFactory();
				return elementFactory;
			}
		}

		/// <summary>
		/// return the used instance of IBuilderFactory. By default, this is the default one of the framework.
		/// </summary>
		public virtual IBuilderFactory ArchitectureBuilderFactory
		{
			get
			{
				if (builderFactory == null) builderFactory = CreateDefaultBuilderFactory(this.ArchitectureElementFactory);
				return builderFactory;
			}
		}

		/// <summary>
		/// return the used instance of IVisitorFactory. By default, this is the default one of the framework.
		/// </summary>
		public virtual IVisitorFactory ArchitectureVisitorFactory
		{
			get
			{
				if (visitorFactory == null) visitorFactory = CreateDefaultVisitorFactory();
				return visitorFactory;
			}
		}

		/// <summary>
		/// creates a threadscheduler used by the simulation to schedule the threads
		/// </summary>
		public virtual Simulation.IThreadScheduler CreateSimulationThreadScheduler(ISimulationEnvironment env)
		{
			return new DefaultThreadScheduler(env);
		}

		#endregion

		#region static create methods

		/// <summary>
		/// called to create the default elementfactory of the framework
		/// </summary>
		/// <returns>the default elementfactory of the framework</returns>
		public static IElementFactory CreateDefaultElementFactory()
		{
			return new DefaultElementFactory();
		}
		
		/// <summary>
		/// called to create the default visitorfactory of the framework
		/// </summary>
		/// <returns>the default visitorfactory of the framework</returns>
		public static IVisitorFactory CreateDefaultVisitorFactory()
		{
			return new DefaultVisitorFactory();
		}

		/// <summary>
		/// called to create the default builderfactory of the framework
		/// </summary>
		/// <param name="elements">the elementfactory used by the builders to create the elements of the architecture</param>
		/// <returns>the default builderfactory of the framework</returns>
		public static IBuilderFactory CreateDefaultBuilderFactory(IElementFactory elements)
		{
			return new DefaultBuilderFactory(elements);
		}

		/// <summary>
		/// called to create the default component architecture of the framework
		/// </summary>
		/// <param name="simulationEnvironment">the simulation environment</param>
		/// <returns>the default component architecture</returns>
		public static IComponentArchitecture CreateDefaultComponentArchitecture(ISimulationEnvironment simulationEnvironment)
		{
			return new DefaultComponentArchitecture(simulationEnvironment);
		}

		/// <summary>
		/// called to create the default clock of the framework
		/// </summary>
		/// <param name="simulationEnvironment">the simulation environment</param>
		/// <returns>the default clock</returns>
		public static IClock CreateDefaultClock(ISimulationEnvironment simulationEnvironment)
		{
			return new DefaultClock(simulationEnvironment);
		}

		/// <summary>
		/// called to create the default datapool of the framework
		/// </summary>
		/// <param name="simulationEnvironment">the simulation environment</param>
		/// <returns>the default datapool</returns>
		public static IDataPool CreateDefaultDataPool(ISimulationEnvironment simulationEnvironment)
		{
			return DataPoolFactory.CreateConsoleWriterDataPool(simulationEnvironment);
		}

		#endregion
	}
}
//EOF