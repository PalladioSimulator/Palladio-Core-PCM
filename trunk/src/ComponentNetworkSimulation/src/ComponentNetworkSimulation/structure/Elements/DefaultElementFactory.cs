using System;

namespace ComponentNetworkSimulation.Structure.Elements
{
	/// <summary>
	/// This class is the default elementfactory.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
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
		public Palladio.ComponentModel.IBasicComponent CreateBasicComponent(string id)
		{
			return Palladio.ComponentModel.ComponentFactory.CreateBasicComponent(id);
		}

		/// <summary>
		/// called to create an composite component
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <returns>the composite component</returns>
		public Palladio.ComponentModel.ICompositeComponent CreateCompositeComponent(string id)
		{
			return Palladio.ComponentModel.ComponentFactory.CreateCompositeComponent(id);
		}

		/// <summary>
		/// called to create a binding to connect a requires interface of one component with the requires interface of another.
		/// </summary>
		/// <returns>the binding</returns>
		public ISimulationBinding CreateBinding()
		{
			//todo: implement
			return null;
		}
	}
}
//EOF