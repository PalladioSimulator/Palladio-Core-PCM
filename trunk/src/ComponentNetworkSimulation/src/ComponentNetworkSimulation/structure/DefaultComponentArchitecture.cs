using System;
using ComponentNetworkSimulation.Structure.Visitor;
using ComponentNetworkSimulation.Structure.Builder;
using Palladio.ComponentModel;

namespace ComponentNetworkSimulation.Structure
{
	/// <summary>
	/// This class is the default component architecture.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/06/22 12:56:46  joemal
	/// inital class creation
	///
	/// 
	/// </pre>	
	/// </remarks>
	public class DefaultComponentArchitecture : AbstractComponentArchitecture
	{
		#region data

		/// <summary>
		/// holds the root component
		/// </summary>
		private IComponent rootComponent;

		#endregion

		/// <summary>
		/// called to construct a new DefaultComponentArchitecture.
		/// </summary>
		/// <param name="env">the simulation environment</param>
		public DefaultComponentArchitecture(ISimulationEnvironment env):base(env)
		{
		}

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
				if (this.IsRootComponentBasic)
					return this.BuilderFactory.CreateBuilder((IBasicComponent)this.ArchitectureRootComponent);
				else
					return this.BuilderFactory.CreateBuilder((ICompositeComponent)this.ArchitectureRootComponent);
			}
		}

		/// <summary>
		/// called by the simulationenvironment, to reset the architecture. The method can be used to reset dynamic parts of the 
		/// architecture.
		/// </summary>
		public override void reset()
		{
		}

		/// <summary>
		/// call to create the root component. This call creates a basic component as root.
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <returns>the builder for the component</returns>
		public override IBasicComponentBuilder CreateBasicRootComponent(String id)
		{
			IBasicComponent component = this.ElementFactory.CreateBasicComponent(id);
			this.rootComponent = component;
			return this.BuilderFactory.CreateBuilder(component);
		}

		/// <summary>
		/// call to create the root component. This call creates a composite component as root.
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <returns>the builder for the component</returns>
		public override ICompositeComponentBuilder CreateCompositeComponent(String id)
		{
			ICompositeComponent component = this.ElementFactory.CreateCompositeComponent(id);
			this.rootComponent = component;
			return this.BuilderFactory.CreateBuilder(component);
		}

		/// <summary>
		/// called by the methods CreateVisitorChain when a visitor for the given component should be created.
		/// The visitor has to start at the given starting point.
		/// </summary>
		/// <param name="component">the component</param>
		/// <param name="startingPoint">the starting point</param>
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
		/// <param name="innerComponentVisitor">the inner visitor</param>
		/// <returns>the created visitor</returns>
		protected override IComponentVisitor CreateVisitor(IComponent component, IThreadStartingPoint sp)
		{
			return this.VisitorFactory.CreateVisitor(component,sp.InterfaceID,sp.SignatureID);
		}
	}
}
//EOF
