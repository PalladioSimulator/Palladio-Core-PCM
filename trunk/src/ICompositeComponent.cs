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
		/// <param name="aCompArray">Set of components to be added.</param>
		void AddComponent(IIdentifier ID, IComponent aCompArray);

		/// <summary>
		/// Remove a set of components from the ICompositeComponent.
		/// </summary>
		/// <param name="aCompArray">Set of components to be removed.</param>
		void DeleteComponents(params IIdentifier[] componentIDs);
		
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
		/// <param name="aComponent">Internal component of ICompositeComponent.</param>
		/// <returns>An array of bindings which are connected to the provides interfaces of aComponent.</returns>
		IBinding[] GetProvidesBindings(string aComponentID);
		
		/// <summary>
		/// Get all bindings connected to the requires interfaces of aComponent.
		/// </summary>
		/// <param name="aComponent">Internal component of ICompositeComponent.</param>
		/// <returns>An array of bindings which are connected to the requires interfaces of aComponent.</returns>
		IBinding[] GetRequiresBindings(string aComponentID);

		/// <summary>
		/// Get all mappings connected to the provides interfaces of aComponent.
		/// </summary>
		/// <param name="aComponent">Internal component of ICompositeComponent.</param>
		/// <returns>An array of mappings which are connected to the provides interfaces of aComponent.</returns>
		IMapping[] GetProvidesMappings(string aComponentID);

		/// <summary>
		/// Get all mappings connected to the requires interfaces of aComponent.
		/// </summary>
		/// <param name="aComponent">Internal component of ICompositeComponent.</param>
		/// <returns>An array of mappings which are connected to the requires interfaces of aComponent.</returns>
		IMapping[] GetRequiresMappings(string aComponentID);

		/// <summary>
		/// Get the mapping associated with the provides interface with the role aProvRoleID.
		/// </summary>
		/// <param name="aProvRoleID">Role of a provides interface of ICompositeComponent.</param>
		/// <returns>Mapping associated with aProvRoleID.</returns>
		IMapping GetProvidesMappingByOuter(string aProvRoleID);
		
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
		/// <param name="aProvComponent">Internal component of ICompositeComponent.</param>
		/// <param name="aProvRole">Role of a provides interface of aProvComponent.</param>
		/// <returns>An array of IMappings associated with aProvInterface.</returns>
		IMapping[] GetProvidesMappingsByInner(string aProvComponentID, string aProvRole);

		IBinding GetBindingByRequires(IAttachedRole aReqInterface);
		IBinding GetBindingByRequires(string aReqComponentID, string aReqRole);
		IBinding[] GetBindingsByProvides(IAttachedRole aProvInterface);
		IBinding[] GetBindingsByProvides(string aProvComponentID, string aProvRole);

		IMapping GetRequiresMappingByInner(IAttachedRole aReqInterface);
		IMapping GetRequiresMappingByInner(string aReqComponentID, string aReqRole);
		IMapping[] GetRequiresMappingsByOuter(string aReqRoleID);


		
		bool HasIncomingConnections(string aComponentID);

		bool HasOutgoingConnections(string aComponentID);

		bool ContainsComponent(string aComponentID);

		
	}
}
