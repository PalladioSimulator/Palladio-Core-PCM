using System;
using Palladio.ComponentModel;

namespace ComponentNetworkSimulation.Structure.Builder
{
	/// <summary>
	/// this interface defines the factory used to create the builders for the component architecture.
	/// This interface is part of the abstract factory pattern (GOF).
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.3  2004/06/28 10:51:47  joemal
	/// - add observer to the builders
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
	public interface IBuilderFactory
	{
		/// <summary>
		/// called to create a builder used to fill the given composite component. 
		/// </summary>
		/// <param name="component">the component to be filled</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder used to fill the component</returns>
		ICompositeComponentBuilder CreateBuilder(ICompositeComponent component, ICompositeComponentObserver observer);

		/// <summary>
		/// called to create a builder used to fill the given basic component. 
		/// </summary>
		/// <param name="component">the component to be filled</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder used to fill the component</returns>
		IBasicComponentBuilder CreateBuilder(IBasicComponent component, IBasicComponentObserver observer);

		/// <summary>
		/// called to create a builder used to fill a fsm of a service in a basic component.
		/// </summary>
		/// <param name="component">the component which contains the service to be filled</param>
		/// <param name="seff">the service effect specification</param>
		/// <param name="observer">
		/// The observer for the service. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder used to fill the FSM</returns>
		IServiceBuilder CreateBuilder(IBasicComponent component, IServiceEffectSpecification seff, IServiceObserver observer);
	}
}
//EOF
