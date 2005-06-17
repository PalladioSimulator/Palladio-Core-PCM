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
	/// Revision 1.5  2005/06/17 18:31:43  joemal
	/// changes in the connection tables
	///
	/// Revision 1.4  2005/06/05 10:39:23  joemal
	/// - components now can be added to more than one container
	///
	/// Revision 1.3  2005/03/19 18:35:41  joemal
	/// implement the rest of the lowlevelbuilder
	///
	/// Revision 1.2  2005/03/16 13:32:34  joemal
	/// implement lowlevelbuilder
	///
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
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		void CreateComponent(IComponent component);

		/// <summary>
		/// called to add an existing component to a composite component or to the static view. 
		/// </summary>
		/// <param name="componentID">the id of the component to be added</param>
		/// <param name="parentComponentID">the parent id or null if the component has 
		/// to be added to the static view.</param>
		/// <exception cref="ComponentNotFoundException">the component or the parent component doesn't exist in cm</exception>
		/// <exception cref="WrongComponentTypeException">the parent component is not a composite component.</exception>
		/// <exception cref="EntityAlreadyExistsException">the component is still a child of the parent component</exception>
		void AddComponent(IComponentIdentifier componentID, IComponentIdentifier parentComponentID);

		/// <summary>
		/// called to remove the component which belongs to the given id from the given parent component. 
		/// All connections to and from this components are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		/// <param name="parentComponentId">the id of the parent component of the one that
		/// has to be removed. Set null if the component has to be removed from the static view.</param>
		void RemoveComponentFromComponent(IComponentIdentifier componentId, IComponentIdentifier parentComponentId);

		/// <summary>
		/// called to remove the component which belongs to the given id from the model. All references of 
		/// this components and the connections to them are also removed. 
		/// If the entity could not be found in the componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		void RemoveComponent(IComponentIdentifier componentId);

		/// <summary>
		/// called to add an existing interface to a component. 
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		/// <param name="role">determ whether the interface is bound as requires or provides interface</param>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">the component could not be found in cm</exception>
		/// <exception cref="EntityAlreadyExistsException">the interface is still bound with the component 
		/// at given role</exception>
		void AddInterface(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier, 
			InterfaceRole role);

		/// <summary>
		/// called to add an interface to the model. 
		/// </summary>
		/// <param name="iface">the interface to be added</param>
		/// <exception cref="EntityAlreadyExistsException">an interface with given id already exists in cm</exception>
		void CreateInterface(IInterface iface);

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		void RemoveInterface(IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to remove an interface from a component. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
 		/// <param name="role">the role bound of the interface in the component</param>
		void RemoveInterfaceFromComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier,
			InterfaceRole role);

		/// <summary>
		/// called to add a delegationconnector from the provides interface of an component to the provides 
		/// interface of an inner component.
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="outerPoint">the connecting point of the outer component</param>
		/// <param name="innerPoint">the connecting point of the inner component</param>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="ComponentHierarchyException">the outer component is not the parent of the inner component</exception>
		/// <exception cref="NotAProvidesIFaceException">one of the given interfaces is not a provides
		/// interface of the component</exception>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		void AddProvidesDelegationConnector(IConnection connection, ConnectionPoint outerPoint,ConnectionPoint innerPoint);

		/// <summary>
		/// called to add a delegationconnector from the requires interface of an component to the requires 
		/// interface of its parent component
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="outerPoint">the connecting point of the outer component</param>
		/// <param name="innerPoint">the connecting point of the inner component</param>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="ComponentHierarchyException">the outer component is not the parent of the inner component</exception>
		/// <exception cref="NotARequiresIFaceException">one of the given interfaces is not a requires 
		/// interface of the component</exception>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		void AddRequiresDelegationConnector(IConnection connection, ConnectionPoint innerPoint,ConnectionPoint outerPoint);

		/// <summary>
		/// called to add an assemblyConnector from a requires interfaces of a component to a provides interface of 
		/// another component. Both components must have the same parent component or must be placed at the top level of the
		/// model.
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="parentCompID">the id of component that should contain the connection</param>
		/// <param name="requiresPoint">the point of the requiring component</param>
		/// <param name="providesPoint">the point of the providing component</param>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="ComponentHierarchyException">both components have not the same parent id</exception>
		/// <exception cref="NotARequiresIFaceException">one of the first given interface is not a requires</exception> 
		/// <exception cref="NotAProvidesIFaceException">one of the second given interface is not a provides </exception>
		void AddAssemblyConnector(IConnection connection, IComponentIdentifier parentCompID, 
			ConnectionPoint requiresPoint,ConnectionPoint providesPoint);

		/// <summary>
		/// called to remove the connection that belongs to the given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		void RemoveConnection(IConnectionIdentifier connectionID);

		/// <summary>
		/// called to add the given signature to the interfaces, specified by the given interface id.
		/// </summary>
		/// <param name="signature">the signature to be added</param>
		/// <param name="ifaceID">the id of the interface, to which the signature has to be added</param>
		/// <exception cref="EntityAlreadyExistsException">an signature with given id already exists in cm</exception>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		void AddSignature(ISignature signature, IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to remove the signature with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="signatureID">the id of the signature that has to be removed</param>
		void RemoveSignature(ISignatureIdentifier signatureID);

		/// <summary>
		/// called to add a protocol to the interfaces that is specified by the given interface id.
		/// </summary>
		/// <param name="protocol">the protocol to be added</param>
		/// <param name="ifaceID">the id of the interface, to which the protocol has to be added</param>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>		
		void AddProtocol(IProtocol protocol, IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to remove the protocol with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="protocolID">the id of the protocol that has to be removed</param>
		void RemoveProtocol(IProtocolIdentifier protocolID);
	}

	/// <summary>
	/// describes the start or end point of a connector
	/// </summary>
	public struct ConnectionPoint
	{
		/// <summary>
		/// called to create a new connection point only using the ifaceid and the componentid.
		/// </summary>
		/// <param name="ifaceId">the id of the interface</param>
		/// <param name="componentId">the id of the component</param>
		public ConnectionPoint(IInterfaceIdentifier ifaceId, IComponentIdentifier componentId)
		{
			ifaceID = ifaceId;
			componentID = componentId;
		}

		/// <summary>
		/// the id of the interface
		/// </summary>
		public IInterfaceIdentifier ifaceID;

		/// <summary>
		/// the id of the component
		/// </summary>
		public IComponentIdentifier componentID;

	}
}
