using System;
using System.Collections;
using Palladio.Attributes;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A Component is a set of Provides- and RequiresInterfaces.
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

		bool HasProvidesInterface(string aRoleID);

		bool HasRequiresInterface(string aRoleID);

	}
}
