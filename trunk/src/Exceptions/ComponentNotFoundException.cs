using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a component is missing.
	/// </summary>
	public class ComponentNotFoundException : ApplicationException
	{
		/// <summary>
		/// Error indicating, that a component is missing.
		/// </summary>
		/// <param name="aRoleID">Role which couldn't be found.</param>
		public ComponentNotFoundException(IComponent aComponent) : base( "Component " + aComponent + " could not be found!")
		{
		}
	}
}