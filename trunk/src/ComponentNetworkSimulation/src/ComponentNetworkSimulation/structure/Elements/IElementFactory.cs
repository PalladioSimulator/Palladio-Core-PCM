using System;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure.Elements
{
	/// <summary>
	/// This interface defines the factory for all elements used to build the component architecture. The abstract factory pattern
	/// is used.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.3  2004/07/05 11:16:02  joemal
	/// - changes in the CM after code review
	///
	/// Revision 1.2  2004/06/26 15:42:52  joemal
	/// - add the simulation bindings
	///
	/// Revision 1.1  2004/06/22 12:19:55  joemal
	/// inital class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IElementFactory
	{
		#region elements for service effect FSMs

		/// <summary>
		/// call to create a state used in service effect FSMs
		/// </summary>
		/// <param name="stateParams">the parameters for the state</param>
		/// <returns>the state</returns>
		ISimulationState CreateState(ISimulationStateParams stateParams);

		#endregion

		#region components

		/// <summary>
		/// called to create an empty basic component
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <returns>the component</returns>
		IBasicComponent CreateBasicComponent(IIdentifier id);

		/// <summary>
		/// called to create an composite component
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <returns>the composite component</returns>
		ICompositeComponent CreateCompositeComponent(IIdentifier id);

		#endregion

		#region elements for composite components

		/// <summary>
		/// called to create a binding to connect a requires interface of one component with the requires interface of another.
		/// </summary>
		/// <param name="reqComp">the requiring component</param>
		/// <param name="reqRole">the id of the requires interface</param>
		/// <param name="provComp">the providing component</param>
		/// <param name="provRole">the id of the requires interface</param>
		/// <param name="parameters">the parameters of the binding</param>
		/// <returns>the binding</returns>
		ISimulationBinding CreateBinding(IComponent reqComp,IIdentifier reqRole,IComponent provComp, 
			IIdentifier provRole, ISimulationBindingParams parameters);

		#endregion
	}
}
//EOF
