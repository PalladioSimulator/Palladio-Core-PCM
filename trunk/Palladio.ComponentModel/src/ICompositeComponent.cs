using System;
using System.Collections;
using ReflectionBasedVisitor;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A ICompositeComponent consists of a set of internal components which 
	/// are wired using ComponentAssemblyConnectors and mapped to the outside world 
	/// using ComponentDelegationConnectors.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface ICompositeComponent : IComponent, IVisitable
	{
		/// <summary>
		/// List of IComponent objects assembled by the CompositComponent.
		/// </summary>
		IComponent[] Components 
		{ 
			get;
		}

		/// <summary>
		/// Get an array of IDs of the components in this composite component
		/// </summary>
		IIdentifier[] ComponentIDs
		{
			get;
		}

		/// <summary>
		/// List of CompAssemblyConnector objects, which represent 
		/// the wiring of the internal components.
		/// </summary>
		IAssemblyConnector[] AssemblyConnectors
		{ 
			get;
		}

		/// <summary>
		/// List of ICompProvDelegationConnectors mapping the ProvidesInterfaces
		/// of the internal components onto the ProvidesInterfaces of the
		/// CompositeComponent.
		/// </summary>
		IDelegationConnector[] ProvidesDelegationConnectors
		{ 
			get;
		}

		/// <summary>
		/// List of IReqCompDelegationConnectors mapping the RequireInterfaces
		/// of the internal components onto the RequiresInterface of the
		/// CompositeComponent.
		/// </summary>
		IDelegationConnector[] RequiresDelegationConnectors
		{ 
			get;
		}
		
		/// <summary>
		/// Add a set of components to the ICompositeComponent.
		/// </summary>
		/// <param name="aComponentArray">Set of components to be added.</param>
		void AddComponents(params IComponent[] aComponentArray);

		/// <summary>
		/// Remove a set of components from the ICompositeComponent.
		/// </summary>
		/// <param name="aCompIDArray">Set of components IDs to be removed.</param>
		void DeleteComponents(params IIdentifier[] aCompIDArray);
		
		/// <summary>
		/// Add a set of DelegationConnectors between the provides interfaces of ICompositeComponent
		/// and the internal components.
		/// </summary>
		/// <param name="aProvDelegationConnectorArray">Set of provides DelegationConnectors to be added.</param>
		void AddProvidesDelegationConnectors(params IDelegationConnector[] aProvDelegationConnectorArray );

		/// <summary>
		/// Remove a set of DelegationConnectors between the provides interfaces of ICompositeComponent
		/// and the internal components.
		/// </summary>
		/// <param name="aProvDelegationConnectorArray">Set of provides DelegationConnectors to be removed.</param>
		void DeleteProvidesDelegationConnectors(params IDelegationConnector[] aProvDelegationConnectorArray);

		/// <summary>
		/// Add a set of DelegationConnectors between the requires interfaces of ICompositeComponent
		/// and the internal components.
		/// </summary>
		/// <param name="aReqDelegationConnectorArray">Set of requires DelegationConnectors to be added.</param>
		void AddRequiresDelegationConnectors(params IDelegationConnector[] aReqDelegationConnectorArray);

		/// <summary>
		/// Remove a set of DelegationConnectors between the requires interfaces of ICompositeComponent
		/// and the internal components.
		/// </summary>
		/// <param name="aReqDelegationConnectorArray">Set of requires DelegationConnectors to be removed.</param>
		void DeleteRequiresDelegationConnectors(params IDelegationConnector[] aReqDelegationConnectorArray);

		/// <summary>
		/// Add a set of AssemblyConnectors between the internal components to ICompositeComponent.
		/// </summary>
		/// <param name="aAssemblyConnectorArray">Set of AssemblyConnectors to be added.</param>
		void AddAssemblyConnectors(params IAssemblyConnector[] aAssemblyConnectorArray);

		/// <summary>
		/// Remove a set of AssemblyConnectors between the internal components from ICompositeComponent.
		/// </summary>
		/// <param name="aAssemblyConnectorArray">Set of AssemblyConnectors to be deleted.</param>
		void DeleteAssemblyConnectors(params IAssemblyConnector[] aAssemblyConnectorArray);

		/// <summary>
		/// 
		/// </summary>
		/// <param name="aComponentID"></param>
		/// <returns></returns>
		IConnection[] GetProvidesConnections(IIdentifier aComponentID);
		
		/// <summary>
		/// 
		/// </summary>
		/// <param name="aComponentID"></param>
		/// <returns></returns>
		IConnection[] GetRequiresConnections(IIdentifier aComponentID);
		
		/// <summary>
		/// Get all AssemblyConnectors connected to the provides interfaces of aComponent.
		/// </summary>
		/// <param name="aComponentID">Internal component of ICompositeComponent.</param>
		/// <returns>An array of AssemblyConnectors which are connected to the provides interfaces of aComponent.</returns>
		IAssemblyConnector[] GetProvidesAssemblyConnectors(IIdentifier aComponentID);
		
		/// <summary>
		/// Get all AssemblyConnectors connected to the requires interfaces of aComponent.
		/// </summary>
		/// <param name="aComponentID">Internal component of ICompositeComponent.</param>
		/// <returns>An array of AssemblyConnectors which are connected to the requires interfaces of aComponent.</returns>
		IAssemblyConnector[] GetRequiresAssemblyConnectors(IIdentifier aComponentID);

		/// <summary>
		/// Get all DelegationConnectors connected to the provides interfaces of aComponent.
		/// </summary>
		/// <param name="aComponentID">Internal component of ICompositeComponent.</param>
		/// <returns>An array of DelegationConnectors which are connected to the provides interfaces of aComponent.</returns>
		IDelegationConnector[] GetProvidesDelegationConnectors(IIdentifier aComponentID);

		/// <summary>
		/// Get all DelegationConnectors connected to the requires interfaces of aComponent.
		/// </summary>
		/// <param name="aComponentID">Internal component of ICompositeComponent.</param>
		/// <returns>An array of DelegationConnectors which are connected to the requires interfaces of aComponent.</returns>
		IDelegationConnector[] GetRequiresDelegationConnectors(IIdentifier aComponentID);

		/// <summary>
		/// Get the DelegationConnector associated with the provides interface with the role aProvRoleID.
		/// </summary>
		/// <param name="aProvRoleID">Role of a provides interface of ICompositeComponent.</param>
		/// <returns>DelegationConnector associated with aProvRoleID.</returns>
		IDelegationConnector GetProvidesDelegationConnectorByOuter(IIdentifier aProvRoleID);
		
		/// <summary>
		/// Get the DelegationConnectors associated with the provides interface aProvInterface of an 
		/// internal component.
		/// </summary>
		/// <param name="aProvInterface">Provides interface attached to an internal component.</param>
		/// <returns>An array of IDelegationConnectors associated with aProvInterface.</returns>
		IDelegationConnector[] GetProvidesDelegationConnectorsByInner(IRole aProvInterface);

		/// <summary>
		/// Get the DelegationConnectors associated with the provides interface with the role aProvRole of the 
		/// internal component aProvComponent.
		/// </summary>
		/// <param name="aProvComponentID">Internal component of ICompositeComponent.</param>
		/// <param name="aProvRoleID">Role of a provides interface of aProvComponent.</param>
		/// <returns>An array of IDelegationConnectors associated with aProvInterface.</returns>
		IDelegationConnector[] GetProvidesDelegationConnectorsByInner(IIdentifier aProvComponentID, IIdentifier aProvRoleID);

		/// <summary>
		/// Get the AssemblyConnector connected to the given required role
		/// </summary>
		/// <param name="aReqInterface">The required attached role</param>
		/// <returns>The AssemblyConnector connected to the required role</returns>
		IAssemblyConnector GetAssemblyConnectorByRequires(IRole aReqInterface);

		/// <summary>
		/// Get the AssemblyConnector connected to the given required role
		/// </summary>
		/// <param name="aReqComponentID">The component where the role is attached to.</param>
		/// <param name="aReqRole">Role of the component.</param>
		/// <returns>The AssemblyConnector connected to the required role</returns>
		IAssemblyConnector GetAssemblyConnectorByRequires(IIdentifier aReqComponentID, IIdentifier aReqRole);

		/// <summary>
		/// Get all the AssemblyConnectors connected to the given providing role
		/// </summary>
		/// <param name="aProvInterface">The component and role providing the role</param>
		/// <returns>All AssemblyConnectors connected to the given role.</returns>
		IAssemblyConnector[] GetAssemblyConnectorsByProvides(IRole aProvInterface);

		/// <summary>
		/// Get all the AssemblyConnectors connected to the given providing role
		/// </summary>
		/// <param name="aProvComponentID">ID of the component providing the role</param>
		/// <param name="aProvRole">A provided role</param>
		/// <returns>All AssemblyConnectors connected to the given role.</returns>
		IAssemblyConnector[] GetAssemblyConnectorsByProvides(IIdentifier aProvComponentID, IIdentifier aProvRole);

		/// <summary>
		/// Get the requires DelegationConnector connected to the given inner role
		/// </summary>
		/// <param name="aReqInterface">The component and role requiring services</param>
		/// <returns>The DelegationConnector connected to the required role.</returns>
		IDelegationConnector GetRequiresDelegationConnectorByInner(IRole aReqInterface);

		/// <summary>
		/// Get the requires DelegationConnector connected to the given inner role
		/// </summary>
		/// <param name="aReqComponentID">ID of the component to which the role is attached.</param>
		/// <param name="aReqRoleID">ID of the Role requiring services</param>
		/// <returns>The DelegationConnector connected to the required role.</returns>
		IDelegationConnector GetRequiresDelegationConnectorByInner(IIdentifier aReqComponentID, IIdentifier aReqRoleID);

		/// <summary>
		/// Return all the DelegationConnector connected to an outer component role.
		/// </summary>
		/// <param name="aReqRoleID">The role of the outer component.</param>
		/// <returns>All DelegationConnectors connected to the given role.</returns>
		IDelegationConnector[] GetRequiresDelegationConnectorsByOuter(IIdentifier aReqRoleID);
		
		/// <summary>
		/// Query a certain component for incomming connections.
		/// </summary>
		/// <param name="aComponentID">The ID of the component.</param>
		/// <returns>true if the component has any incomming connections</returns>
		bool HasIncomingConnections(IIdentifier aComponentID);

		/// <summary>
		/// Query a component for outgoing connections
		/// </summary>
		/// <param name="aComponentID">The component ID</param>
		/// <returns>true if the component has any outgoing connections.</returns>
		bool HasOutgoingConnections(IIdentifier aComponentID);

		/// <summary>
		/// Query the composite component for a certain component
		/// </summary>
		/// <param name="aComponentID">ID of the component to search for</param>
		/// <returns>true if the component is part of the composite component</returns>
		bool ContainsComponent(IIdentifier aComponentID);

		/// <summary>
		/// Query the composite component for a certain basic component
		/// </summary>
		/// <param name="aComponentID">ID of the component to search for</param>
		/// <returns>The component with the given ID</returns>
		IComponent GetComponent(IIdentifier aComponentID);
	}
}
