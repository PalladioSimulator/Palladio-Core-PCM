using System;
using Palladio.ComponentModel;
using Palladio.Simulation.Model.Elements;

namespace Palladio.Simulation.Model.Builder
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
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>	
	/// </remarks>
	internal class DefaultBuilderFactory : IBuilderFactory
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
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder used to fill the component</returns>
		public ICompositeComponentBuilder CreateBuilder(ICompositeComponent component, ICompositeComponentObserver observer)
		{
			return new DefaultCompositeComponentBuilder(component,elementFactory,this,observer);
		}

		/// <summary>
		/// called to create a builder used to fill the given basic component. 
		/// </summary>
		/// <param name="component">the component to be filled</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder used to fill the component</returns>
		public IBasicComponentBuilder CreateBuilder(IBasicComponent component,IBasicComponentObserver observer)
		{
			return new DefaultBasicComponentBuilder(component,elementFactory,this,observer);
		}

		/// <summary>
		/// called to create a builder used to fill a fsm of a service in a basic component.
		/// </summary>
		/// <param name="component">the component which contains the service to be filled</param>
		/// <param name="seff">the service effect specification</param>
		/// <param name="observer">
		/// The observer for the service. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder used to fill the FSM</returns>
		public IServiceBuilder CreateBuilder(IBasicComponent component, IServiceEffectSpecification seff, 
			IServiceObserver observer)
		{
			return new DefaultServiceBuilder(component,seff,elementFactory,observer);
		}
	}
}
//EOF