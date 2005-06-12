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
		IComponentModelEntity GetEntity(IIdentifier entityID);

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
		/// called to return the assembly connector between to components 
		/// </summary>
		/// <param name="reqCompID"></param>
		/// <param name="reqIfaceID"></param>
		/// <param name="provCompID"></param>
		/// <param name="provIfaceID"></param>
		/// <returns></returns>
		IConnection GetAssemblyConnector(IComponentIdentifier reqCompID, IInterfaceIdentifier reqIfaceID,
			IComponentIdentifier provCompID, IInterfaceIdentifier provIfaceID);
	}
}
