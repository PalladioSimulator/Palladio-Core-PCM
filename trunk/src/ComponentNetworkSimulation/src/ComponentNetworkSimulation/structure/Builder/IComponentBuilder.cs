using System;

namespace ComponentNetworkSimulation.Structure.Builder
{
	/// <summary>
	/// This interface is the basic interface for all componentbuilders in the framework.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.2  2004/06/26 16:32:12  joemal
	/// - now propagate the reset through the architecture
	///
	/// Revision 1.1  2004/06/22 12:17:18  joemal
	/// inital class creation
	///
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
