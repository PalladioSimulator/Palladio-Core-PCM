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
	/// Revision 1.3  2004/06/28 10:51:47  joemal
	/// - add observer to the builders
	///
	/// Revision 1.2  2004/06/26 16:32:12  joemal
	/// - now propagate the reset through the architecture
	///
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

		/// <summary>
		/// holds the observer for this builders component
		/// </summary>
		protected IComponentObserver observer;

		#endregion

		#region properties

		/// <summary>
		/// called to extract the id of the builders component
		/// </summary>
		protected string CompID
		{
			get
			{
				return this.component.ID.ToString();
			}
		}

		#endregion

		#region constructor

		/// <summary>
		/// constructs a new AbstractComponentBuilder used to fill the given component
		/// </summary>
		/// <param name="comp">the component to be filled</param>
		/// <param name="elements">the factory, used to create the elements of the architecture</param>
 		/// <param name="builder">the factory, used to create the builder</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		public AbstractComponentBuilder(IComponent comp, IElementFactory elements, IBuilderFactory builder, 
			IComponentObserver observer)
		{
			this.component = comp;
			this.elementFactory = elements;
			this.builderFactory = builder;
			this.observer = observer;
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
			if (this.observer != null)
				observer.OnProvidesInterfaceAdded(CompID,ifaceID);
		}

		/// <summary>
		/// call to add a requires interface to the component.
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		public void AddRequiresInterface(Palladio.Identifier.IIdentifier ifaceID)
		{
			this.component.AddRequiresInterface(ifaceID,ComponentFactory.CreateInterfaceModel());
			if (this.observer != null)
				observer.OnRequiresInterfaceAdded(CompID,ifaceID);
		}

		/// <summary>
		/// this method is called, when the simulation wants to reset the architecture. Builders should reset all its
		/// containing timeconsumer.
		/// </summary>
		public abstract void Reset();

		#endregion
	}
}
//EOF