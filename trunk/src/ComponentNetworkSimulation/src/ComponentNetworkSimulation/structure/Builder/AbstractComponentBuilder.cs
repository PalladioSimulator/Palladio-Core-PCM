using System;
using Palladio.ComponentModel;
using ComponentNetworkSimulation.Structure.Elements;

namespace ComponentNetworkSimulation.Structure.Builder
{
	/// <summary>
	/// This class is the abstract class for the builders used to fill components. It holds the component to be filled and
	/// implements the methods to add interfaces.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/06/22 12:17:19  joemal
	/// inital class creation
	///
	///
	/// 
	/// </pre>	
	/// </remarks>
	public abstract class AbstractComponentBuilder : IComponentBuilder
	{
		#region data

		/// <summary>
		/// the component to be filled
		/// </summary>
		protected IComponent component;

		/// <summary>
		/// the factory, used to create the elements of the architecture
		/// </summary>
		protected IElementFactory elementFactory;

		/// <summary>
		/// the factory, used to create the builders
		/// </summary>
		protected IBuilderFactory builderFactory;

		#endregion

		#region constructor

		/// <summary>
		/// constructs a new AbstractComponentBuilder used to fill the given component
		/// </summary>
		/// <param name="comp">the component to be filled</param>
		/// <param name="elements">the factory, used to create the elements of the architecture</param>
 		/// <param name="builder">the factory, used to create the builder</param>
		public AbstractComponentBuilder(IComponent comp, IElementFactory elements, IBuilderFactory builder)
		{
			this.component = comp;
			this.elementFactory = elements;
			this.builderFactory = builder;
		}

		#endregion

		#region method

		/// <summary>
		/// call to add a provides interface to the component.
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		public void AddProvidesInterface(Palladio.Identifier.IIdentifier ifaceID)
		{
			this.component.AddProvidesInterface(ifaceID,ComponentFactory.CreateInterfaceModel());
		}

		/// <summary>
		/// call to add a requires interface to the component.
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		public void AddRequiresInterface(Palladio.Identifier.IIdentifier ifaceID)
		{
			this.component.AddRequiresInterface(ifaceID,ComponentFactory.CreateInterfaceModel());
		}

		#endregion
	}
}
//EOF