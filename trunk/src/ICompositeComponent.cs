using System;
using System.Collections;
using ReflectionBasedVisitor;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A ICompositeComponent consists of a set of internal components which 
	/// are wired using ComponentBindings and mapped to the outside world 
	/// using ComponentMappings.
	/// </summary>
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
		/// List of CompBinding objects, which represent 
		/// the wiring of the internal components.
		/// </summary>
		IBinding[] Bindings
		{ 
			get;
		}

		/// <summary>
		/// List of ICompProvMappings mapping the ProvidesInterfaces
		/// of the internal components onto the ProvidesInterfaces of the
		/// CompositeComponent.
		/// </summary>
		IMapping[] ProvidesMappings
		{ 
			get;
		}

		/// <summary>
		/// List of IReqCompMappings mapping the RequireInterfaces
		/// of the internal components onto the RequiresInterface of the
		/// CompositeComponent.
		/// </summary>
		IMapping[] RequiresMappings
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
		/// Add a set of mappings between the provides interfaces of ICompositeComponent
		/// and the internal components.
		/// </summary>
		/// <param name="aProvMappingArray">Set of provides mappings to be added.</param>
		void AddProvidesMappings(params IMapping[] aProvMappingArray );

		/// <summary>
		/// Remove a set of mappings between the provides interfaces of ICompositeComponent
		/// and the internal components.
		/// </summary>
		/// <param name="aProvMappingArray">Set of provides mappings to be removed.</param>
		void DeleteProvidesMappings(params IMapping[] aProvMappingArray);

		/// <summary>
		/// Add a set of mappings between the requires interfaces of ICompositeComponent
		/// and the internal components.
		/// </summary>
		/// <param name="aReqMappingArray">Set of requires mappings to be added.</param>
		void AddRequiresMappings(params IMapping[] aReqMappingArray);

		/// <summary>
		/// Remove a set of mappings between the requires interfaces of ICompositeComponent
		/// and the internal components.
		/// </summary>
		/// <param name="aReqMappingArray">Set of requires mappings to be removed.</param>
		void DeleteRequiresMappings(params IMapping[] aReqMappingArray);

		/// <summary>
		/// Add a set of bindings between the internal components to ICompositeComponent.
		/// </summary>
		/// <param name="aBindingArray">Set of bindings to be added.</param>
		void AddBindings(params IBinding[] aBindingArray);

		/// <summary>
		/// Remove a set of bindings between the internal components from ICompositeComponent.
		/// </summary>
		/// <param name="aBindingArray">Set of bindings to be deleted.</param>
		void DeleteBindings(params IBinding[] aBindingArray);

		/// <summary>
		/// Get all bindings connected to the provides interfaces of aComponent.
		/// </summary>
		/// <param name="aComponentID">Internal component of ICompositeComponent.</param>
		/// <returns>An array of bindings which are connected to the provides interfaces of aComponent.</returns>
		IBinding[] GetProvidesBindings(IIdentifier aComponentID);
		
		/// <summary>
		/// Get all bindings connected to the requires interfaces of aComponent.
		/// </summary>
		/// <param name="aComponentID">Internal component of ICompositeComponent.</param>
		/// <returns>An array of bindings which are connected to the requires interfaces of aComponent.</returns>
		IBinding[] GetRequiresBindings(IIdentifier aComponentID);

		/// <summary>
		/// Get all mappings connected to the provides interfaces of aComponent.
		/// </summary>
		/// <param name="aComponentID">Internal component of ICompositeComponent.</param>
		/// <returns>An array of mappings which are connected to the provides interfaces of aComponent.</returns>
		IMapping[] GetProvidesMappings(IIdentifier aComponentID);

		/// <summary>
		/// Get all mappings connected to the requires interfaces of aComponent.
		/// </summary>
		/// <param name="aComponentID">Internal component of ICompositeComponent.</param>
		/// <returns>An array of mappings which are connected to the requires interfaces of aComponent.</returns>
		IMapping[] GetRequiresMappings(IIdentifier aComponentID);

		/// <summary>
		/// Get the mapping associated with the provides interface with the role aProvRoleID.
		/// </summary>
		/// <param name="aProvRoleID">Role of a provides interface of ICompositeComponent.</param>
		/// <returns>Mapping associated with aProvRoleID.</returns>
		IMapping GetProvidesMappingByOuter(IIdentifier aProvRoleID);
		
		/// <summary>
		/// Get the mappings associated with the provides interface aProvInterface of an 
		/// internal component.
		/// </summary>
		/// <param name="aProvInterface">Provides interface attached to an internal component.</param>
		/// <returns>An array of IMappings associated with aProvInterface.</returns>
		IMapping[] GetProvidesMappingsByInner(IAttachedRole aProvInterface);

		/// <summary>
		/// Get the mappings associated with the provides interface with the role aProvRole of the 
		/// internal component aProvComponent.
		/// </summary>
		/// <param name="aProvComponentID">Internal component of ICompositeComponent.</param>
		/// <param name="aProvRoleID">Role of a provides interface of aProvComponent.</param>
		/// <returns>An array of IMappings associated with aProvInterface.</returns>
		IMapping[] GetProvidesMappingsByInner(IIdentifier aProvComponentID, IIdentifier aProvRoleID);

		/// <summary>
		/// Get the binding connected to the given required role
		/// </summary>
		/// <param name="aReqInterface">The required attached role</param>
		/// <returns>The binding connected to the required role</returns>
		IBinding GetBindingByRequires(IAttachedRole aReqInterface);

		/// <summary>
		/// Get the binding connected to the given required role
		/// </summary>
		/// <param name="aReqComponentID">The component where the role is attached to.</param>
		/// <param name="aReqRole">Role of the component.</param>
		/// <returns>The binding connected to the required role</returns>
		IBinding GetBindingByRequires(IIdentifier aReqComponentID, IIdentifier aReqRole);

		/// <summary>
		/// Get all the bindings connected to the given providing role
		/// </summary>
		/// <param name="aProvInterface">The component and role providing the role</param>
		/// <returns>All bindings connected to the given role.</returns>
		IBinding[] GetBindingsByProvides(IAttachedRole aProvInterface);

		/// <summary>
		/// Get all the bindings connected to the given providing role
		/// </summary>
		/// <param name="aProvComponentID">ID of the component providing the role</param>
		/// <param name="aProvRole">A provided role</param>
		/// <returns>All bindings connected to the given role.</returns>
		IBinding[] GetBindingsByProvides(IIdentifier aProvComponentID, IIdentifier aProvRole);

		/// <summary>
		/// Get the requires mapping connected to the given inner role
		/// </summary>
		/// <param name="aReqInterface">The component and role requiring services</param>
		/// <returns>The mapping connected to the required role.</returns>
		IMapping GetRequiresMappingByInner(IAttachedRole aReqInterface);

		/// <summary>
		/// Get the requires mapping connected to the given inner role
		/// </summary>
		/// <param name="aReqComponentID">ID of the component to which the role is attached.</param>
		/// <param name="aReqRoleID">ID of the Role requiring services</param>
		/// <returns>The mapping connected to the required role.</returns>
		IMapping GetRequiresMappingByInner(IIdentifier aReqComponentID, IIdentifier aReqRoleID);

		/// <summary>
		/// Return all the mapping connected to an outer component role.
		/// </summary>
		/// <param name="aReqRoleID">The role of the outer component.</param>
		/// <returns>All mappings connected to the given role.</returns>
		IMapping[] GetRequiresMappingsByOuter(IIdentifier aReqRoleID);
		
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
		/// Query the composite component for a certain basic component
		/// </summary>
		/// <param name="aComponentID">ID of the component to search for</param>
		/// <returns>true if the component is part of the composite component</returns>
		bool ContainsComponent(IIdentifier aComponentID);
	}
}
