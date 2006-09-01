using System;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace Palladio.Simulation.Model.Elements
{
	/// <summary>
	/// This interface defines the factory for all elements used to build the component architecture. The abstract factory pattern
	/// is used.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IElementFactory
	{
		#region methods to add sets of states and bindings
        
		/// <summary>
		/// call to add a set of supported simulationstates. 
		/// </summary>
		/// <param name="stateSet">the set of simulationstate</param>
		void AddStateSet(ISimulationStateSet stateSet);

		/// <summary>
		/// called to add a set of supported simulationbindings.
		/// </summary>
		/// <param name="bindingSet">the set of simulationbindings</param>
		void AddBindingSet(ISimulationBindingSet bindingSet);

		#endregion
		
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
