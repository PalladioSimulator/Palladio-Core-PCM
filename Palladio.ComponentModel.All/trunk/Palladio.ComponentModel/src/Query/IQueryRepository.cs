using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Query
{
	/// <summary>
	/// This interface defines several query methods to find the entities of the whole componentmodel
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.7  2005/09/20 08:55:12  kelsaka
	/// - added methods to get all assembly/delegation connectors
	///
	/// Revision 1.6  2005/08/30 13:42:34  kelsaka
	/// - FSMWrappers are returning new public interface
	/// - added query for all existing SEFFs in CM
	///
	/// Revision 1.5  2005/07/30 15:43:48  joemal
	/// add basiccomponent queries (for seffs)
	///
	/// Revision 1.4  2005/07/29 16:02:57  joemal
	/// now service effect specifications can be added ...
	///
	/// Revision 1.3  2005/06/25 16:54:44  joemal
	/// some more queries are need for the xml serlialization
	///
	/// Revision 1.2  2005/06/17 18:33:10  joemal
	/// changes in the connection tables
	///
	/// Revision 1.1  2005/06/12 17:06:18  joemal
	/// renamed from QueryEntityImpl
	///
	///
	/// </pre>
	/// </remarks>
	public interface IQueryRepository
	{
		/// <summary>
		/// called to return the entity with given id from the componentmodel
		/// </summary>
		/// <param name="entityID">the id of the entity</param>
		/// <returns>the entity or null if the entity could not be found in the model</returns>
		IIdentifiable GetEntity(IIdentifier entityID);

		/// <summary>
		/// returns true, if an entity with given id could be found in the model.
		/// </summary>
		/// <param name="entityID">the id of the entity</param>
		/// <returns>true if the model contains an entity with given id</returns>
		bool ContainsEntity(IIdentifier entityID);

		/// <summary>
		/// called to return the component with given id from the componentmodel
		/// </summary>
		/// <param name="compID">the id of the component</param>
		/// <returns>the component or null if the component could not be found in the model</returns>
		IComponent GetComponent(IComponentIdentifier compID);

		/// <summary>
		/// called to return the interface with given id from the componentmodel
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>the interface or null if the interface could not be found in the model</returns>
		IInterface GetInterface(IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to return the connection with given id from the componentmodel
		/// </summary>
		/// <param name="conID">the id of the connection</param>
		/// <returns>the connection or null if the connection could not be found in the model</returns>
		IConnection GetConnection(IConnectionIdentifier conID);

		/// <summary>
		/// called to return the signature with given id from the componentmodel
		/// </summary>
		/// <param name="sigID">the id of the signature</param>
		/// <returns>the signature or null if the signature could not be found in the model</returns>
		ISignature GetSignature(ISignatureIdentifier sigID);

		/// <summary>
		/// called to return the protocol with given id from the componentmodel
		/// </summary>
		/// <param name="protID">the id of the protocol</param>
		/// <returns>the protocol or null if the protocol could not be found in the model</returns>
		IProtocol GetProtocol(IProtocolIdentifier protID);

		/// <summary>
		/// called to return the service effect specification with given id from the componentmodel
		/// </summary>
		/// <param name="seffID">the id of the service effect specification</param>
		/// <returns>the seff or null if the seff could not be found in the model</returns>
		IServiceEffectSpecification GetServiceEffectSpecification(ISeffIdentifier seffID);

		/// <summary>
		/// called to return all components of the componentmodel
		/// </summary>
		/// <returns>an array with components</returns>
		IComponent[] GetComponents();

		/// <summary>
		/// called to return all interfaces of the componentmodel
		/// </summary>
		/// <returns>an array with interfaces</returns>
		IInterface[] GetInterfaces();

		/// <summary>
		/// called to return all connections of the componentmodel
		/// </summary>
		/// <returns>an array with connections</returns>
		IConnection[] GetConnections();

		/// <summary>
		/// Returns all delegation connection from the componentmodel
		/// </summary>
		/// <returns>an array of connections</returns>
		IConnection[] GetDelegationConnectors();

		/// <summary>
		/// Returns all assembly connection from the componentmodel
		/// </summary>
		/// <returns>an array of connections</returns>
		IConnection[] GetAssemblyConnectors();

		/// <summary>
		/// called to return all signatures of the componentmodel
		/// </summary>
		/// <returns>an array with signatures</returns>
		ISignature[] GetSignatures();

		/// <summary>
		/// called to return all protocols of the componentmodel
		/// </summary>
		/// <returns>an array with protocols</returns>
		IProtocol[] GetProtocols();

		/// <summary>
		/// calles to return all service effect specifications of the component model
		/// </summary>
		/// <returns>an array of SEFFs</returns>
		IServiceEffectSpecification[] GetServiceEffectSpecifications();
	}
}
