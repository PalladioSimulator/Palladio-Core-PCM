using System;
using System.Collections;
using Palladio.Attributes;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A Component is a set of Provides- and RequiresInterface.
	/// </summary>
	public interface IComponent : ICloneable, IAttributable
	{
		
		/// <summary>
		/// Interfaces provided by the component to its environment.
		/// </summary>
		ISignatureList[] ProvidesInterfaces { get; }

		/// <summary>
		/// Interfaces required by the component from its environment.
		/// </summary>
		ISignatureList[] RequiresInterfaces { get; }

		/// <summary>
		/// Get the ProvidesInterface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">A provided role of the component.</param>
		/// <returns>The ProvidesInterface with the role aRoleID. 
		/// If no interface with aRoleID can be found, a RoleNotFoundException is thrown.</returns>
		ISignatureList GetProvidesInterface(string aRoleID);
		
		/// <summary>
		/// Get the RequiresInterface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">A provided role of the component.</param>
		/// <returns>The RequiresInterface with the role aRoleID. 
		/// If no interface with aRoleID can be found, a RoleNotFoundException is thrown.</returns>
		ISignatureList GetRequiresInterface(string aRoleID);

		/// <summary>
		/// Checks, if the component contains a provides interface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">Requested role.</param>
		/// <returns>True, if a provides interface with the role aRoleID was found, false otherwise.</returns>
		bool HasProvidesInterface(string aRoleID);

		/// <summary>
		/// Checks, if the component contains a requires interface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">Requested role.</param>
		/// <returns>True, if a requires interface with the role aRoleID was found, false otherwise.</returns>
		bool HasRequiresInterface(string aRoleID);

	}
}
