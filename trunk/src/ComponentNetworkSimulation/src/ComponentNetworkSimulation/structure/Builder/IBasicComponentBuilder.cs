using System;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure.Builder
{
	/// <summary>
	/// This interface defines a componentbuilder for basic components.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.3  2004/06/28 10:51:47  joemal
	/// - add observer to the builders
	///
	/// Revision 1.2  2004/06/23 16:33:51  joemal
	/// - add methods to hold the builders of the elements
	///
	/// Revision 1.1  2004/06/22 12:17:19  joemal
	/// inital class creation
	///
	///
	/// 
	/// </pre>	
	/// </remarks>
	public interface IBasicComponentBuilder : IComponentBuilder
	{
		/// <summary>
		/// called to add a service to the basic component
		/// </summary>
		/// <param name="provIfaceID">the id of the provides interface to which the signature of the service has to be added</param>
		/// <param name="signatureID">the id of the signature</param>
		/// <param name="observer">
		/// The observer for the service. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder to fill the service</returns>
        IServiceBuilder AddService(IIdentifier provIfaceID,IIdentifier signatureID, IServiceObserver observer);		

		/// <summary>
		/// call to get the builder for an existing service.
		/// </summary>
		/// <param name="provIfaceID">the id of the provides interface where the signature of the service can be found</param>
		/// <param name="signatureID">the id of the signature of the service</param>
		/// <returns>the builder</returns>
		IServiceBuilder GetServiceBuilder(IIdentifier provIfaceID, IIdentifier signatureID);
	}
}
//EOF
