using System;
using Palladio.ComponentModel;
using ComponentNetworkSimulation.Structure.Visitor;

namespace ComponentNetworkSimulation.Structure
{
	/// <summary>
	/// This abstract class is the a base class for component architectures. It provides a reference to the 
	/// simulation environment, several properties to the architecture factories and methods to build a visitorchain.
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
	public abstract class AbstractComponentArchitecture : IComponentArchitecture
	{
		#region data

		/// <summary>
		/// hold the instance of the simulationenvironment
		/// </summary>
		protected ISimulationEnvironment simulationEnvironment;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new AbstractComponentArchitecture.
		/// </summary>
		/// <param name="simulationEnvironment">the simulation environment</param>
		public AbstractComponentArchitecture(ISimulationEnvironment simulationEnvironment)
		{
			this.simulationEnvironment = simulationEnvironment;
		}

		#endregion

		#region properties

		/// <summary>
		/// the root component of the architecture
		/// </summary>
		public abstract IComponent ArchitectureRootComponent
		{
			get;
		}

		/// <summary>
		/// return true, if the root component is a composite component.
		/// </summary>
		public bool IsRootComponentComposite
		{
			get
			{
				return (ArchitectureRootComponent is ICompositeComponent);
			}
		}

		/// <summary>
		/// return true, if the root component is a basic component.
		/// </summary>
		public bool IsRootComponentBasic
		{
			get
			{
				return (ArchitectureRootComponent is IBasicComponent);
			}
		}

		/// <summary>
		/// return the builder interface of the root component. If still no component is created, null is returned.
		/// </summary>
		public abstract Builder.IComponentBuilder RootComponentBuilder
		{
			get;
		}

		/// <summary>
		/// return the used instance of IVisitorFactory
		/// </summary>
		protected Visitor.IVisitorFactory VisitorFactory
		{
			get
			{
				return this.simulationEnvironment.EnvironmentFactory.ArchitectureVisitorFactory;
			}
		}

		/// <summary>
		/// return the used instance of IBuilderFactory
		/// </summary>
		protected Builder.IBuilderFactory BuilderFactory
		{
			get
			{
				return this.simulationEnvironment.EnvironmentFactory.ArchitectureBuilderFactory;
			}
		}

		/// <summary>
		/// return the used instance of IBuilderFactory
		/// </summary>
		protected Elements.IElementFactory ElementFactory
		{
			get
			{
				return this.simulationEnvironment.EnvironmentFactory.ArchitectureElementFactory;
			}
		}

		#endregion

		#region methods

		/// <summary>
		/// called by the simulationenvironment, to reset the architecture. The method can be used to reset dynamic parts of the 
		/// architecture.
		/// </summary>
		public abstract void reset();

		/// <summary>
		/// call to create a visitors used for simulationthreads to enter at the point in the architecture
		/// described with given startingpoint.
		/// </summary>
		/// <param name="startingPoint">the point, from where the visitor has to start.</param>
		/// <returns>an instance of <code>IComponentVisitor</code></returns>
		/// <exception cref="Palladio.ComponentModel.ComponentNotFoundException">
		/// thrown, if the component with given id can't be found in architecture
		/// </exception>
		/// <exception cref="Palladio.ComponentModel.RoleIDNotFoundException">
		/// thrown, if the interface with given id can't be found in the component
		/// </exception>
		///	<exception cref="Palladio.ComponentModel.SignatureNotFoundException">
		/// thrown, if the signature with given id can't be found in interface
		/// </exception>
		public virtual IComponentVisitor CreateVisitor(IThreadStartingPoint startingPoint)
		{
			IComponentVisitor visitor = CreateVisitorChain(this.ArchitectureRootComponent,startingPoint);                        
			if (visitor == null)
				throw new Palladio.ComponentModel.Exceptions.ComponentNotFoundException(startingPoint.ComponentID);
			return visitor;
		}

		/// <summary>
		/// call to build a visitorchain. To given starting point
		/// </summary>
		/// <param name="component">the component current component</param>
		/// <param name="startingPoint">the starting point</param>
		/// <returns></returns>
		private IComponentVisitor CreateVisitorChain(IComponent component, IThreadStartingPoint startingPoint)
		{
			//found the component, return the visitor
			if (component.ID.Equals(startingPoint.ComponentID))	return CreateVisitor(component,startingPoint);

			//if its a basic component, it can't contain the searched one
			if (component is IBasicComponent) return null;

			//the component is a composite component, search for matching inner components
			ICompositeComponent cc = (ICompositeComponent)component;

			foreach(IComponent comp in cc.Components)
			{
				IComponentVisitor visitor = CreateVisitorChain(comp,startingPoint);
				//if found one, create a new Visitor for composite components using the found one as
				//inner visitor
				if (visitor != null) return CreateVisitor(cc,visitor);
			}

			return null;
		}

		/// <summary>
		/// called by the methods CreateVisitorChain when a visitor for the given component should be created.
		/// The visitor has to start at the given starting point.
		/// </summary>
		/// <param name="component">the component</param>
		/// <param name="startingPoint">the starting point</param>
		/// <returns>the created visitor</returns>
		protected abstract IComponentVisitor CreateVisitor(IComponent component, IThreadStartingPoint startingPoint);

		/// <summary>
		/// called by the method CreateVisitorChain, when a visitor for a composite component should be created.
		/// The given Visitor is used to visit one of the inner components of this one.
		/// </summary>
		/// <param name="component">the component</param>
		/// <param name="innerComponentVisitor">the inner visitor</param>
		/// <returns>the created visitor</returns>
		protected abstract IComponentVisitor CreateVisitor(ICompositeComponent component, 
			IComponentVisitor innerComponentVisitor);

		/// <summary>
		/// call to create the root component. This call creates a basic component as root.
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <returns>the builder for the component</returns>
		public abstract Builder.IBasicComponentBuilder CreateBasicRootComponent(String id);

		/// <summary>
		/// call to create the root component. This call creates a composite component as root.
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <returns>the builder for the component</returns>
		public abstract Builder.ICompositeComponentBuilder CreateCompositeComponent(String id);

		#endregion
	}
}
//EOF
