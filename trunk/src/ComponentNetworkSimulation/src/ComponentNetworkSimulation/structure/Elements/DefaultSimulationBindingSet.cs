using System;

using Palladio.ComponentModel;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure.Elements
{
	/// <summary>
	/// This is the default set for simulationbindings, that are supported by the framework.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/06 12:25:40  joemal
	/// initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultSimulationBindingSet : ISimulationBindingSet
	{
		/// <summary>
		/// this is the factory method to create a binding that supports the given parameter structure.
		/// </summary>
		/// <param name="reqComp">the requiring component</param>
		/// <param name="reqRole">the id of the requires interface</param>
		/// <param name="provComp">the providing component</param>
		/// <param name="provRole">the id of the requires interface</param>
		/// <param name="parms">the parameters for the binding</param>
		/// <returns>the binding</returns>
		public ISimulationBinding CreateBinding(IComponent reqComp,IIdentifier reqRole,IComponent provComp, 
			IIdentifier provRole, ISimulationBindingParams parms)
		{
			if (parms is StaticTimeBindingParams)
				return new DefaultStaticTimeBinding(reqComp,reqRole,provComp,provRole,(StaticTimeBindingParams)parms);

			throw new NotSupportedException("The given parameters are not supported by this set of bindings.");
		}

		/// <summary>
		/// this method has to return false, if the given parameterstructure is not supported by this set of bindings.
		/// If this method returns true, the set can create a binding with this parameters.
		/// </summary>
		/// <param name="parms">the parameters that have to be checked</param>
		/// <returns>true, if this set can create a binding using this parameters</returns>
		public bool IsSupported(ISimulationBindingParams parms)
		{
			return parms is StaticTimeBindingParams;
		}
		}
}
//EOF
