using System;
using Palladio.Simulation.Model.Visitor;
using Palladio.Simulation.Model.Builder;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace Palladio.Simulation.Model
{
	/// <summary>
	/// This class is the default component architecture.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.2  2004/07/29 15:13:47  joemal
	/// - changes from the review
	///
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>	
	/// </remarks>
	internal class DefaultComponentArchitecture : AbstractComponentArchitecture
	{
		#region data

		/// <summary>
		/// holds the root component
		/// </summary>
		private IComponent rootComponent;

		/// <summary>
		/// holds the builder for the root component
		/// </summary>
		private IComponentBuilder componentBuilder;

		#endregion

		/// <summary>
		/// called to construct a new DefaultComponentArchitecture.
		/// </summary>
		/// <param name="env">the simulation environment</param>
		public DefaultComponentArchitecture(ISimulationEnvironment env):base(env)
		{
		}

		#region properties

		/// <summary>
		/// return the current set root component. Returns null, if no component is still set
		/// </summary>
		public override IComponent ArchitectureRootComponent
		{
			get
			{
				return this.rootComponent;
			}
		}

		/// <summary>
		/// returns the builder for the root component
		/// </summary>
		public override IComponentBuilder RootComponentBuilder
		{
			get
			{
				return this.componentBuilder;
			}
		}

		#endregion

		#region methods 

		/// <summary>
		/// called by the simulationenvironment, to reset the architecture. The method can be used to reset dynamic parts of the 
		/// architecture.
		/// </summary>
		public override void reset()
		{
			if (this.RootComponentBuilder != null)	this.RootComponentBuilder.Reset();
		}

		/// <summary>
		/// call to create the root component. This call creates a basic component as root.
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder for the component</returns>
		public override IBasicComponentBuilder CreateBasicRootComponent(IIdentifier id, IBasicComponentObserver observer)
		{
			IBasicComponent component = this.ElementFactory.CreateBasicComponent(id);
			this.rootComponent = component;

			this.componentBuilder = this.BuilderFactory.CreateBuilder(component,observer);
			return (IBasicComponentBuilder)this.componentBuilder;
		}

		/// <summary>
		/// call to create the root component. This call creates a composite component as root.
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder for the component</returns>
		public override ICompositeComponentBuilder CreateCompositeRootComponent(IIdentifier id,ICompositeComponentObserver observer)
		{
			ICompositeComponent component = this.ElementFactory.CreateCompositeComponent(id);
			this.rootComponent = component;

			this.componentBuilder = this.BuilderFactory.CreateBuilder(component,observer);
			return (ICompositeComponentBuilder)this.componentBuilder;
		}

		/// <summary>
		/// called by the methods CreateVisitorChain when a visitor for the given component should be created.
		/// The visitor has to start at the given starting point.
		/// </summary>
		/// <param name="component">the component</param>
		/// <param name="innerComponentVisitor">the visitor of an inner component of this visitors component</param>
		/// <returns>the created visitor</returns>
		protected override IComponentVisitor CreateVisitor(ICompositeComponent component, IComponentVisitor innerComponentVisitor)
		{
			return this.VisitorFactory.CreateVisitor(component,innerComponentVisitor);
		}

		/// <summary>
		/// called by the method CreateVisitorChain, when a visitor for a composite component should be created.
		/// The given Visitor is used to visit one of the inner components of this one.
		/// </summary>
		/// <param name="component">the component</param>
		/// <param name="sp">the point in the architecture, where the thread has to start</param>
		/// <returns>the created visitor</returns>
		protected override IComponentVisitor CreateVisitor(IComponent component, ThreadStartingPoint sp)
		{
			return this.VisitorFactory.CreateVisitor(component,sp.InterfaceID,sp.SignatureID);
		}

		#endregion
	}
}
//EOF
