using System;
using System.Collections;

using Palladio.ComponentModel;
using Palladio.Identifier;

namespace Palladio.Simulation.Model.Elements
{
	/// <summary>
	/// This class is the default elementfactory.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultElementFactory : IElementFactory
	{
		/// <summary>
		/// the sets of states that are supported by the factory
		/// </summary>
		private IList stateSets = new ArrayList();

		/// <summary>
		/// the sets of bindings that are supported by the factory
		/// </summary>
		private IList bindingSets = new ArrayList();

		/// <summary>
		/// creates a new DefaultElementFactory and adds the frameworks default state- and bindingset.
		/// </summary>
		public DefaultElementFactory()
		{
			this.AddStateSet(new DefaultSimulationStateSet());
			this.AddBindingSet(new DefaultSimulationBindingSet());
		}

		/// <summary>
		/// call to create a state used in service effect FSMs
		/// </summary>
		/// <param name="stateParams">the parameters for the state</param>
		/// <returns>the state</returns>
		public ISimulationState CreateState(ISimulationStateParams stateParams)
		{
			foreach(ISimulationStateSet stateSet in this.stateSets)
			{
				if (stateSet.IsSupported(stateParams)) 
					return stateSet.CreateState(stateParams);
			}
			
			throw new NotSupportedException("The given parameters are not supported by the current sets of states.");
		}

		/// <summary>
		/// called to create an empty basic component
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <returns>the component</returns>
		public IBasicComponent CreateBasicComponent(IIdentifier id)
		{
			return ComponentFactory.CreateBasicComponent(id);
		}

		/// <summary>
		/// called to create an composite component
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <returns>the composite component</returns>
		public ICompositeComponent CreateCompositeComponent(IIdentifier id)
		{
			return ComponentFactory.CreateCompositeComponent(id);
		}

		/// <summary>
		/// called to create a binding to connect a requires interface of one component with the requires interface of another.
		/// </summary>
		/// <param name="reqComp">the requiring component</param>
		/// <param name="reqRole">the id of the requires interface</param>
		/// <param name="provComp">the providing component</param>
		/// <param name="provRole">the id of the requires interface</param>
		/// <param name="parameters">the parameters of the binding</param>
		/// <returns>the binding</returns>
		public ISimulationBinding CreateBinding(IComponent reqComp,IIdentifier reqRole,IComponent provComp, 
			IIdentifier provRole, ISimulationBindingParams parameters)
		{
			foreach(ISimulationBindingSet bindingSet in this.bindingSets)
			{
				if (bindingSet.IsSupported(parameters)) 
					return bindingSet.CreateBinding(reqComp,reqRole,provComp,provRole,parameters);
			}

			throw new NotSupportedException("The given parameters are not supported by this set of bindings.");
		}

		/// <summary>
		/// call to add a set of supported simulationstates. 
		/// </summary>
		/// <param name="stateSet">the set of simulationstate</param>
		public void AddStateSet(ISimulationStateSet stateSet)
		{
			this.stateSets.Add(stateSet);
		}

		/// <summary>
		/// called to add a set of supported simulationbindings.
		/// </summary>
		/// <param name="bindingSet">the set of simulationbindings</param>
		public void AddBindingSet(ISimulationBindingSet bindingSet)
		{
			this.bindingSets.Add(bindingSet);
		}
	}
}
//EOF