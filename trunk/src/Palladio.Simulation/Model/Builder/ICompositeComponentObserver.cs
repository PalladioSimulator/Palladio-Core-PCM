using System;
using Palladio.Identifier;
using Palladio.Simulation.Model.Elements;

namespace Palladio.Simulation.Model.Builder
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
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
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
		void OnBasicComponentAdded(IIdentifier componentID, IIdentifier innerComponentID);

		/// <summary>
		/// called, when a composite component was added to the observing composite component.
		/// </summary>
		/// <param name="componentID">the id of the observing component.</param>
		/// <param name="innerComponentID">the id of the component that was added</param>
		void OnCompositeComponentAdded(IIdentifier componentID, IIdentifier innerComponentID);

		/// <summary>
		/// called, when a binding was added to the observing composite component.
		/// </summary>
		/// <param name="componentID">the id of the observing component</param>
		/// <param name="provCompID">the id of the providing component</param>
		/// <param name="reqCompID">the id of the requiring component</param>
		/// <param name="provIFaceID">the id of the provides interface</param>
		/// <param name="reqIFaceID">the id of the requires interface</param>
		/// <param name="parms">the parameters for the binding</param>
		void OnBindingAdded(IIdentifier componentID, IIdentifier provCompID,IIdentifier reqCompID,IIdentifier provIFaceID,
			IIdentifier reqIFaceID,ISimulationBindingParams parms);

		/// <summary>
		/// called, when a requires mapping was added to the observing component.
		/// </summary>
		/// <param name="componentID">the id of the observing component</param>
		/// <param name="requiringComp">the inner component</param>
		/// <param name="compReqIFaceID">the interface of the inner component</param>
		/// <param name="thisCompReqIFaceID">the interface of this component</param>
		void OnRequiresMappingAdded(IIdentifier componentID,IIdentifier requiringComp, IIdentifier compReqIFaceID, 
			IIdentifier thisCompReqIFaceID); 

		/// <summary>
		/// called, when a provides mapping was added to the observing component.
		/// </summary>
		/// <param name="componentID">the id of the observing component</param>
		/// <param name="providingComp">the inner component</param>
		/// <param name="compProvIFaceID">the interface of the inner component</param>
		/// <param name="thisCompProvIFaceID">the interface of this component</param>
		void OnProvidesMappingAdded(IIdentifier componentID,IIdentifier providingComp, IIdentifier compProvIFaceID, 
			IIdentifier thisCompProvIFaceID); 
	}
}
//EOF