using System;
using Palladio.Identifier;

namespace Palladio.Simulation.Model.Builder
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
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
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
		void OnRequiresInterfaceAdded(IIdentifier componentId, IIdentifier iFaceID);

		/// <summary>
		/// called by the componentbuilder, when a provides interface was added to the observing component.
		/// </summary>
		/// <param name="componentId">the id of the observing component</param>
		/// <param name="iFaceID">the id of the new interface</param>
		void OnProvidesInterfaceAdded(IIdentifier componentId, IIdentifier iFaceID);
	}
}
//EOF