using System;
using Palladio.Identifier;
using ComponentNetworkSimulation.Structure.Elements;

namespace ComponentNetworkSimulation.Structure.Builder
{
	/// <summary>
	/// This interface defines a observer for compositecomponentbuilders. Implementing classes are notified, when a
	/// component, a binding or a mapping is added to the observing component.
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
	public interface ICompositeComponentObserver : IComponentObserver
	{
		/// <summary>
		/// called, when a basic component was added to the observing composite component.
		/// </summary>
		/// <param name="componentID">the id of the observing component.</param>
		/// <param name="innerComponentID">the id of the component that was added</param>
		void OnBasicComponentAdded(string componentID, string innerComponentID);

		/// <summary>
		/// called, when a composite component was added to the observing composite component.
		/// </summary>
		/// <param name="componentID">the id of the observing component.</param>
		/// <param name="innerComponentID">the id of the component that was added</param>
		void OnCompositeComponentAdded(string componentID, string innerComponentID);

		/// <summary>
		/// called, when a binding was added to the observing composite component.
		/// </summary>
		/// <param name="componentID">the id of the observing component</param>
		/// <param name="provCompID">the id of the providing component</param>
		/// <param name="reqCompID">the id of the requiring component</param>
		/// <param name="provIFaceID">the id of the provides interface</param>
		/// <param name="reqIFaceID">the id of the requires interface</param>
		/// <param name="parms">the parameters for the binding</param>
		void OnBindingAdded(string componentID, string provCompID,string reqCompID,IIdentifier provIFaceID,
			IIdentifier reqIFaceID,ISimulationBindingParams parms);

		/// <summary>
		/// called, when a requires mapping was added to the observing component.
		/// </summary>
		/// <param name="componentID">the id of the observing component</param>
		/// <param name="requiringComp">the inner component</param>
		/// <param name="compReqIFaceID">the interface of the inner component</param>
		/// <param name="thisCompReqIFaceID">the interface of this component</param>
		void OnRequiresMappingAdded(string componentID,string requiringComp, IIdentifier compReqIFaceID, 
			IIdentifier thisCompReqIFaceID); 

		/// <summary>
		/// called, when a provides mapping was added to the observing component.
		/// </summary>
		/// <param name="componentID">the id of the observing component</param>
		/// <param name="requiringComp">the inner component</param>
		/// <param name="compReqIFaceID">the interface of the inner component</param>
		/// <param name="thisCompReqIFaceID">the interface of this component</param>
		void OnProvidesMappingAdded(string componentID,string providingComp, IIdentifier compProvIFaceID, 
			IIdentifier thisCompProvIFaceID); 
	}
}
//EOF