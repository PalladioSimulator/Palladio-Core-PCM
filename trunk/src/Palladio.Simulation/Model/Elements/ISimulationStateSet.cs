using System;

namespace Palladio.Simulation.Model.Elements
{
	/// <summary>
	/// This interface contains the factory method to create states with the supported parameters. The method
	/// <c>IsSupported()</c> decides, whether a parameterstructure is supported by this set of states.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/07/29 15:13:48  joemal
	/// - changes from the review
	///
	/// Revision 1.1  2004/07/20 11:46:42  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface ISimulationStateSet
	{
		/// <summary>
		/// this is the factory method to create a state that supports the given parameter structure.
		/// </summary>
		/// <param name="parms">the parameters for the state</param>
		/// <returns>th state</returns>
		ISimulationState CreateState(ISimulationStateParams parms);

		/// <summary>
		/// this method has to return false, if the given parameterstructure is not supported by this set of states.
		/// If this method returns true, the set can create a state with this parameters.
		/// </summary>
		/// <param name="parms">the parameter that have to be checked</param>
		/// <returns>true, if this set can create a state using this parameters</returns>
		bool IsSupported(ISimulationStateParams parms);
	}
}
//EOF