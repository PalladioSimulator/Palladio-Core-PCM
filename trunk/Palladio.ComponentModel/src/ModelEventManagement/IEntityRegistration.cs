using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This interface defines the set of methods used to register the entities of the component model in the event
	/// manager.  
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/04/04 16:27:28  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.1  2005/03/29 13:05:37  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal interface IEntityRegistration
	{
		/// <summary>
		/// called to register a component.
		/// </summary>
		/// <param name="component">the component which has to be registerted</param>
		/// <param name="parentComponent">the parent component</param>
		void RegisterComponent(IComponent component,IComponentIdentifier parentComponent);

		/// <summary>
		/// called to unregister the given component from the event manager 
		/// </summary>
		/// <param name="component">the component</param>
		/// <param name="parentComponentID">the parent component or null, if the component is placed 
		/// in the top level of the model</param>
		/// <exception cref="EntityNotFoundException">the parent component could not be found in cm.</exception>
		void UnregisterComponent(IComponent component, IComponentIdentifier parentComponentID);

		/// <summary>
		/// called to register an interface.
		/// </summary>
		/// <param name="iface">the interface to be registered</param>
		void RegisterInterface(IInterface iface);

		/// <summary>
		/// called to unregister the interface from the componentmodel
		/// </summary>
		/// <param name="iface"></param>
		void UnregisterInterface(IInterface iface);

		/// <summary>
		/// called after an interface has bound to a component to notify the components eventlistener.
		/// </summary>
		/// <param name="componentIdentifier">the id of the component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		/// <param name="role">the role of the interface in the component</param>
		void RegisterInterfaceToComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier, 
			InterfaceRole role);

		/// <summary>
		/// called to unregister an interface from a component.
		/// </summary>
		/// <param name="compID">the id of the component</param>
		/// <param name="ifaceID">the id of the interface</param>
		void UnregisterInterfaceFromComponent(IComponentIdentifier compID, IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to register a signature.
		/// </summary>
		/// <param name="signature">the signature which has to be registered</param>
		/// <param name="ifaceID">the interface, to which the signature belongs</param>
		void RegisterSignature(ISignature signature,IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to unregister the signature
		/// </summary>
		/// <param name="signature">the signature</param>
		/// <param name="ifaceID">the iface, to which the signature belongs</param>
		void UnregisterSignature(ISignature signature, IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to register a protocol.
		/// </summary>
		/// <param name="protocol">the protocol to be registered</param>
		/// <param name="ifaceID">the interface, to which the protocol belongs</param>
		void RegisterProtocol(IProtocol protocol,IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to unregister a protocol.
		/// </summary>
		/// <param name="protocol">the protocol to be registered</param>
		/// <param name="ifaceID">the interface, to which the protocol belongs</param>
		void UnregisterProtocol(IProtocol protocol,IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to register a reguires delegation connector.
		/// </summary>
		/// <param name="connection">the connector</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the interface of the inner component</param>
		/// <param name="outerCompID">the id of the outer component</param>
		/// <param name="outerIFaceID">the id of the interface of the outer component</param>
		void RegisterRequiresDelegation(IConnection connection,IComponentIdentifier innerCompID, 
			IInterfaceIdentifier innerIFaceID,IComponentIdentifier outerCompID,IInterfaceIdentifier outerIFaceID);

		/// <summary>
		/// called to register a provides delegation connector.
		/// </summary>
		/// <param name="connection">the connector</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the interface of the inner component</param>
		/// <param name="outerCompID">the id of the outer component</param>
		/// <param name="outerIFaceID">the id of the interface of the outer component</param>
		void RegisterProvidesDelegation(IConnection connection, IComponentIdentifier outerCompID, 
			IInterfaceIdentifier outerIFaceID,IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID);

		/// <summary>
		/// called to register a new assembly connector.
		/// </summary>
		/// <param name="connection">the connector</param>
		/// <param name="reqCompID">the id of the requiring component</param>
		/// <param name="reqIFaceID">the id of the requiring components interface</param>
		/// <param name="provCompID">the id of the providing component</param>
		/// <param name="provIFaceID">the id of the providing components interface</param>
		void RegisterAssemblyConnection(IConnection connection, IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID,
			IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID);

		/// <summary>
		/// called to unregister a connection.
		/// </summary>
		/// <param name="connection">the connection</param>
		/// <param name="compositeCompID">the composite component, in which this connection is placed or null,
		/// if this connection belongs to the top level of the model.</param>
		void UnregisterConnection(IConnection connection, IComponentIdentifier compositeCompID);
	}
}