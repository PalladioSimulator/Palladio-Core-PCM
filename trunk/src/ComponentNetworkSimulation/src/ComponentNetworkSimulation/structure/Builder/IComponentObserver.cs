using System;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure.Builder
{
	/// <summary>
	/// This interface defines a observer for componentbuilders. Implementing classes are notified, when a provides or
	/// requires interface is added to the observing component.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/06/28 10:50:51  joemal
	/// initial class creation
	///
	/// 
	/// </pre>	
	/// </remarks>
	public interface IComponentObserver
	{
		/// <summary>
		/// called by the componentbuilder, when a requires interface was added to the observing component.
		/// </summary>
		/// <param name="componentId">the id of the observing component</param>
		/// <param name="iFaceID">the id of the new interface</param>
		void OnRequiresInterfaceAdded(string componentId, IIdentifier iFaceID);

		/// <summary>
		/// called by the componentbuilder, when a provides interface was added to the observing component.
		/// </summary>
		/// <param name="componentId">the id of the observing component</param>
		/// <param name="iFaceID">the id of the new interface</param>
		void OnProvidesInterfaceAdded(string componentId, IIdentifier iFaceID);
	}
}
//EOF