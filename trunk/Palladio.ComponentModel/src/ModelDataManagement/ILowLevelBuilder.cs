using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.ModelDataManagement
{
	/// <summary>
	/// This interface defines a set of basic methods that have to be used to manipulate
	/// the datasets and there hashtables.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/15 12:31:02  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public interface ILowLevelBuilder
	{
		/// <summary>
		/// call to remove all entities and there relations from the model
		/// </summary>
		void ClearAll();

		/// <summary>
		/// call to add a component to the dataset.
		/// </summary>
		/// <param name="component">the component which has to be added</param>
		/// <param name="parentComponentID">the id of the parent component of this one. 
		/// Set this value to null if the component belongs to the top level of the static view.</param>
		/// <exception cref="ComponentNotFoundException">the parent component could not be found in the model.</exception>
		/// <exception cref="WrongComponentTypeException">the parent component is not a composite component.</exception>
		void AddComponent(IComponent component, IComponentIdentifier parentComponentID);

		/// <summary>
		/// called to remove the component which belongs to the given id. All contained components and
		/// all connections to and from this components are also removed.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		void RemoveComponent(IComponentIdentifier componentId);

		/// <summary>
		/// called to add an existing interface as an provides interface to a component.
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		void AddProvidesInterfaceToComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier);

		/// <summary>
		/// called to add an existing interface as an requires interface to a component.
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		void AddRequiresInterfaceToComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier);

		/// <summary>
		/// called to remove an interface from a component.
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		void RemoveInterfaceFromComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier);

		/// <summary>
		/// called to add a connection from one component to another component. Therefore the interfaces and the two components
		/// have to be specified. Both components must have the same parent component or must be placed at the top level of the
		/// model.
		/// </summary>
		/// <param name="connection"></param>
		/// <param name="incomingCompID"></param>
		/// <param name="incomingIFaceID"></param>
		/// <param name="outgoingCompID"></param>
		/// <param name="outgoingIFaceID"></param>
		void AddConnection(IConnection connection, IComponentIdentifier incomingCompID, IInterfaceIdentifier incomingIFaceID,
			IComponentIdentifier outgoingCompID, IInterfaceIdentifier outgoingIFaceID);

		/// <summary>
		/// called to remove the connection that belongs to the given id.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		void RemoveConnection(IConnectionIdentifier connectionID);

		/// <summary>
		/// called to add an interface to the model. 
		/// </summary>
		/// <param name="iface">the interface to be added</param>
		void AddInterface(IInterface iface);

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed.
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		void RemoveInterface(IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to add the given signature to the interfaces, specified by the given interface id.
		/// </summary>
		/// <param name="signature">the signature to be added</param>
		/// <param name="ifaceID">the id of the interface, to which the signature has to be added</param>
		void AddSignature(ISignature signature, IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to remove the signature with given id.
		/// </summary>
		/// <param name="signatureID">the id of the signature that has to be removed</param>
		void RemoveSignature(ISignatureIdentifier signatureID);

		/// <summary>
		/// called to add a protocol to the interfaces that is specified by the given interface id.
		/// </summary>
		/// <param name="protocol">the protocol to be added</param>
		/// <param name="ifaceID">the id of the interface, to which the protocol has to be added</param>
		void AddProtocol(IProtocol protocol, IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to remove the protocol with given id. 
		/// </summary>
		/// <param name="protocolID">the id of the protocol that has to be removed</param>
		void RemoveProtocol(IProtocolIdentifier protocolID);
	}
}
