using System;
using Palladio.Identifier;

namespace Palladio.Simulation.Model.Builder
{
	/// <summary>
	/// This interface defines a componentbuilder for basic components.
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
