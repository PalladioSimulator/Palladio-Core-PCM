using System;
using Palladio.Attributes;
using Palladio.Identifier;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A Component is a set of Provides- and RequiresInterface.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IComponent : IAttributable, IIdentifiable, ICloneable
	{
		/// <summary>
		/// set or get the name of the component
		/// </summary>
		string Name { get; set; }

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

		IRole GetProvidesRoleByInterfaceID(IIdentifier interfaceID);
		IRole GetRequiresRoleByInterfaceID(IIdentifier interfaceID);

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
		/// <param name="roleID">The ID that the conection of interface and component should get.</param>
		void AddProvidesInterface(IInterfaceModel aProvInterface);

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
		/// <param name="roleID">The ID that the conection of interface and component should get.</param>
		void AddRequiresInterface(IInterfaceModel aReqArray);

		/// <summary>
		/// Remove all requires interfaces with the roles given by aReqRoleArray.
		/// </summary>
		/// <param name="aReqRoleArray">Roles of the requires interfaces to be deleted.</param>
		void DeleteRequiresInterfaces(params IIdentifier[] aReqRoleArray);

		/// <summary>
		/// Query the components provides and requires interfaces for a certain role
		/// </summary>
		/// <param name="roleID">The role ID to be queried</param>
		/// <returns>True if the component has the given role</returns>
		bool HasRole(IIdentifier roleID);

		/// <summary>
		/// Retrieve the <see cref="IRole"/> by its ID from the component
		/// </summary>
		/// <param name="roleID">The ID of the role to retrieve</param>
		/// <returns>The role queried</returns>
		IRole GetRole(IIdentifier roleID);

	}
}
