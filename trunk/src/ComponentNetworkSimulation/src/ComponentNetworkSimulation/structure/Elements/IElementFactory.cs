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
		IBasicComponent CreateBasicComponent(string id);

		/// <summary>
		/// called to create an composite component
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <returns>the composite component</returns>
		ICompositeComponent CreateCompositeComponent(string id);

		#endregion

		#region elements for composite components

		/// <summary>
		/// called to create a binding to connect a requires interface of one component with the requires interface of another.
		/// </summary>
		/// <returns>the binding</returns>
		//todo: add parameters
		ISimulationBinding CreateBinding();

		#endregion
	}
}
//EOF
