using System;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure.Elements
{
	/// <summary>
	/// This class is the default elementfactory.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/06/26 15:42:52  joemal
	/// - add the simulation bindings
	///
	/// Revision 1.1  2004/06/22 12:19:55  joemal
	/// inital class creation
	///
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DefaultElementFactory : IElementFactory
	{
		/// <summary>
		/// call to create a state used in service effect FSMs
		/// </summary>
		/// <param name="stateParams">the parameters for the state</param>
		/// <returns>the state</returns>
		public ISimulationState CreateState(ISimulationStateParams stateParams)
		{
			if (stateParams is StaticTimeStateParams)
				return new DefaultStaticTimeState((StaticTimeStateParams)stateParams);
			else
                return null;
		}

		/// <summary>
		/// called to create an empty basic component
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <returns>the component</returns>
		public IBasicComponent CreateBasicComponent(string id)
		{
			return ComponentFactory.CreateBasicComponent(id);
		}

		/// <summary>
		/// called to create an composite component
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <returns>the composite component</returns>
		public ICompositeComponent CreateCompositeComponent(string id)
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
			if (parameters is StaticTimeBindingParams)
				return new DefaultStaticTimeBinding(reqComp,reqRole,provComp,provRole,(StaticTimeBindingParams)parameters);
			else 
				return null;
		}
	}
}
//EOF