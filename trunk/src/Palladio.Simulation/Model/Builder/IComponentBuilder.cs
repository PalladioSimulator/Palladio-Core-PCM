using System;

namespace Palladio.Simulation.Model.Builder
{
	/// <summary>
	/// This interface is the basic interface for all componentbuilders in the framework.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>	
	/// </remarks>
	public interface IComponentBuilder
	{
		/// <summary>
		/// call to add a provides interface to the component.
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		void AddProvidesInterface(Palladio.Identifier.IIdentifier ifaceID);

		/// <summary>
		/// call to add a requires interface to the component.
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		void AddRequiresInterface(Palladio.Identifier.IIdentifier ifaceID);
        
		/// <summary>
		/// this method is called, when the simulation wants to reset the architecture. The implementing builder
		/// should reset its component.
		/// </summary>
		void Reset();
	}
}
//EOF
