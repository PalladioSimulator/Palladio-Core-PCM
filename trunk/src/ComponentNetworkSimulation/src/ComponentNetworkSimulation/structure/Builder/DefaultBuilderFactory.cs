using System;
using Palladio.ComponentModel;
using ComponentNetworkSimulation.Structure.Elements;

namespace ComponentNetworkSimulation.Structure.Builder
{
	/// <summary>
	/// this class is the default factory used to create the builders for the component architecture.
	/// This class is part of the abstract factory pattern (GOF).
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.3  2004/06/26 15:42:23  joemal
	/// - add the default builder for composite components
	///
	/// Revision 1.2  2004/06/22 17:08:29  joemal
	/// - change method signature in service builder
	///
	/// Revision 1.1  2004/06/22 12:17:19  joemal
	/// inital class creation
	///
	///
	/// 
	/// </pre>	
	/// </remarks>
	public class DefaultBuilderFactory : IBuilderFactory
	{
		/// <summary>
		/// the factory used to create the elements of the architecture
		/// </summary>
		private IElementFactory elementFactory;

		/// <summary>
		/// called to create a new DefaultBuilderFactory
		/// </summary>
		/// <param name="elementFactory">the elementfactory used to create the elements of the architecture</param>
		public DefaultBuilderFactory(IElementFactory elementFactory)
		{
			this.elementFactory = elementFactory;
		}

		/// <summary>
		/// called to create a builder used to fill the given composite component. 
		/// </summary>
		/// <param name="component">the component to be filled</param>
		/// <returns>the builder used to fill the component</returns>
		public ICompositeComponentBuilder CreateBuilder(ICompositeComponent component)
		{
			return new DefaultCompositeComponentBuilder(component,elementFactory,this);
		}

		/// <summary>
		/// called to create a builder used to fill the given basic component. 
		/// </summary>
		/// <param name="component">the component to be filled</param>
		/// <returns>the builder used to fill the component</returns>
		public IBasicComponentBuilder CreateBuilder(IBasicComponent component)
		{
			return new DefaultBasicComponentBuilder(component,elementFactory,this);
		}

		/// <summary>
		/// called to create a builder used to fill a fsm of a service in a basic component.
		/// </summary>
		/// <param name="component">the component which contains the service to be filled</param>
		/// <param name="seff">the service effect specification</param>
		/// <returns>the builder used to fill the FSM</returns>
		public IServiceBuilder CreateBuilder(IBasicComponent component, IServiceEffectSpecification seff)
		{
			return new DefaultServiceBuilder(component,seff,elementFactory);
		}
	}
}
//EOF