using System;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace Palladio.Simulation.Model.Elements
{
	/// <summary>
	/// This interface contains the factory method to create bindings with the supported parameters. The method
	/// <code>IsSupported()</code> decides, whether a parameterstructure is supported by this set of binding.
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
	public interface ISimulationBindingSet
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
		ISimulationBinding CreateBinding(IComponent reqComp,IIdentifier reqRole,IComponent provComp, 
			IIdentifier provRole, ISimulationBindingParams parms);

		/// <summary>
		/// this method has to return false, if the given parameterstructure is not supported by this set of bindings.
		/// If this method returns true, the set can create a binding with this parameters.
		/// </summary>
		/// <param name="parms">the parameters that have to be checked</param>
		/// <returns>true, if this set can create a binding using this parameters</returns>
		bool IsSupported(ISimulationBindingParams parms);
	}
}
//EOF