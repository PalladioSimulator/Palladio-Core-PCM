using System;

namespace Palladio.Simulation
{
	/// <summary>
	/// This interface defines the factory ussed to configure the whole framework. It only contains properties which 
	/// returns several other factories.
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
	public interface IEnvironmentFactory
	{
		/// <summary>
		/// returns the factory which creates the elements used in the componentarchitecture
		/// </summary>
		Model.Elements.IElementFactory ArchitectureElementFactory
		{
			get;
		}

		/// <summary>
		/// returns the factory which creates the builders used to build the componentarchitecture
		/// </summary>
		Model.Builder.IBuilderFactory ArchitectureBuilderFactory
		{
			get;
		}

		/// <summary>
		/// returns the factory which creates the visitors used to visit components in the componentarchitecture
		/// </summary>
		Model.Visitor.IVisitorFactory ArchitectureVisitorFactory
		{
			get;
		}

		/// <summary>
		/// creates a threadscheduler used by the simulation to schedule the threads
		/// </summary>
		Simulation.IThreadScheduler CreateSimulationThreadScheduler(ISimulationEnvironment env);
	}
}
//EOF