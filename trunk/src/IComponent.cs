using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.Identifier;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A Component is a set of Provides- and RequiresInterface.
	/// </summary>
	public interface IComponent : ICloneable, IAttributable, IVisitable, IIdentifiable
	{
		/// <summary>
		/// Interfaces provided by the component to its environment.
		/// </summary>
		IIdentifier[] ProvidedRoles { get; }

		/// <summary>
		/// Interfaces required by the component from its environment.
		/// </summary>
		IIdentifier[] RequiredRoles { get; }

		/// <summary>
		/// Get the ProvidesInterface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">A provided role of the component.</param>
		/// <returns>The ProvidesInterface with the role aRoleID. 
		/// If no interface with aRoleID can be found, a RoleNotFoundException is thrown.</returns>
		IInterfaceModel GetProvidesInterface(IIdentifier aRoleID);
		
		/// <summary>
		/// Get the RequiresInterface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">A provided role of the component.</param>
		/// <returns>The RequiresInterface with the role aRoleID. 
		/// If no interface with aRoleID can be found, a RoleNotFoundException is thrown.</returns>
		IInterfaceModel GetRequiresInterface(IIdentifier aRoleID);

		/// <summary>
		/// Checks, if the component contains a provides interface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">Requested role.</param>
		/// <returns>True, if a provides interface with the role aRoleID was found, false otherwise.</returns>
		bool HasProvidesInterface(IIdentifier aRoleID);

		/// <summary>
		/// Checks, if the component contains a requires interface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">Requested role.</param>
		/// <returns>True, if a requires interface with the role aRoleID was found, false otherwise.</returns>
		bool HasRequiresInterface(IIdentifier aRoleID);

		/// <summary>
		/// Adds a provides interface to the component. For each service of the interface a 
		/// a service effect specification is required. It is given by a service effect mapping.
		/// </summary>
		/// <param name="aProvInterface">Provides interface to be added</param>
		/// <param name="aServEffSpecArray">Service effect specifications of all signatures of the provides interface.</param>
		void AddProvidesInterface(IIdentifier roleID,IInterfaceModel aProvInterface);

		/// <summary>
		/// Remove all provides interfaces with the roles given by aProvRoleArray 
		/// from the component.
		/// </summary>
		/// <param name="aProvRoleArray">Roles of the interfaces to be removed.</param>
		void DeleteProvidesInterfaces(params IIdentifier[] aProvRoleArray);
			
		/// <summary>
		/// Add all requires interfaces given by aReqArray to the component.
		/// </summary>
		/// <param name="aReqArray">Requires interfaces to be added.</param>
		void AddRequiresInterface(IIdentifier roleID, IInterfaceModel aReqArray);

		/// <summary>
		/// Remove all requires interfaces with the roles given by aReqRoleArray.
		/// </summary>
		/// <param name="aReqRoleArray">Roles of the requires interfaces to be deleted.</param>
		void DeleteRequiresInterfaces(params IIdentifier[] aReqRoleArray);

		bool HasRole(IIdentifier roleID);

		IRole GetRole(IIdentifier roleID);
	}
}
