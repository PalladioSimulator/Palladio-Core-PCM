using System;
using Palladio.Identifier;
using ComponentNetworkSimulation.Structure.Elements;

namespace ComponentNetworkSimulation.Structure.Builder
{
	/// <summary>
	/// This interface defines a componentbuilder for composite components.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.2  2004/06/26 15:41:47  joemal
	/// - now implemented
	///
	/// Revision 1.1  2004/06/22 12:17:18  joemal
	/// inital class creation
	///
	///
	/// 
	/// </pre>	
	/// </remarks>
	public interface ICompositeComponentBuilder : IComponentBuilder
	{
		/// <summary>
		/// called to add a basic component with given id.
		/// </summary>
		/// <param name="componentID">the id of the new component.</param>
		/// <returns>the builder to fill this component</returns>
		IBasicComponentBuilder AddBasicComponent(string componentID);

		/// <summary>
		/// called to add a composite component with given id.
		/// </summary>
		/// <param name="componentID">the id of the new component.</param>
		/// <returns>the builder to fill this component</returns>
		ICompositeComponentBuilder AddCompositeComponent(string componentID);

		/// <summary>
		/// called to get the builder of the component with the given id. If the component doesn't exist, null
		/// is returned.
		/// </summary>
		/// <param name="componentID">the id of the component</param>
		/// <returns>the builder of the component</returns>
		IComponentBuilder getComponentBuilder(string componentID);

		/// <summary>
		/// called to add a binding to the composite component.
		/// </summary>
		/// <param name="provComp">the id of the providing component</param>
		/// <param name="reqComp">the id of the requiring component</param>
		/// <param name="provIFaceID">the id of the provides interface</param>
		/// <param name="reqIFaceID">the id of the requires interface</param>
		/// <param name="parms">the parameters for the binding</param>
		void AddBinding(string provComp,string reqComp,IIdentifier provIFaceID,IIdentifier reqIFaceID,
			ISimulationBindingParams parms);

		/// <summary>
		/// called to add a mapping between a requires interface of an inner component with a requires interface
		/// of this component.
		/// </summary>
		/// <param name="requiringComp">the inner component</param>
		/// <param name="compReqIFaceID">the interface of the inner component</param>
		/// <param name="thisCompReqIFaceID">the interface of this component</param>
		void AddRequiresMapping(string requiringComp, IIdentifier compReqIFaceID, IIdentifier thisCompReqIFaceID); 

		/// <summary>
		/// called to add a mapping between a provides interface of an inner component with a provides interface
		/// of this component.
		/// </summary>
		/// <param name="providingComp">the inner component</param>
		/// <param name="compProvIFaceID">the interface of the inner component</param>
		/// <param name="thisCompProvIFaceID">the interface of this component</param>
		void AddProvidesMapping(string providingComp, IIdentifier compProvIFaceID, IIdentifier thisCompProvIFaceID); 
	}
}
//EOF
