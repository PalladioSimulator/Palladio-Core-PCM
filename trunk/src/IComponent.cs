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
		/// <returns>
		/// A list of ProvidesInterface objects.
		/// </returns>
		ISignatureList[] ProvidesInterfaces { get; }

		/// <summary>
		/// Interfaces required by the component from its environment.
		/// </summary>
		/// <returns>
		/// A list of RequiresInterface objects.
		/// </returns>
		ISignatureList[] RequiresInterfaces { get; }

		ISignatureList GetProvidesInterface(string aRoleID);
		
		ISignatureList GetRequiresInterface(string aRoleID);
	}
}
