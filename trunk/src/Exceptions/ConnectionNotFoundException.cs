using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Thrown, if a requested connection could not be found.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/06/04 01:54:04  sliver
	/// rework of composite component
	///
	/// </pre>
	/// </remarks>
	public class ConnectionNotFoundException : ComponentModelException
	{
		/// <summary>
		/// Thrown, if a requested connection could not be found.
		/// </summary>
		/// <param name="aComponent">Considered component.</param>
		public ConnectionNotFoundException(IAttachedRole aRole) : base( "Connection for '" + aRole.ToString() + "' could not be found!")
		{
		}

		/// <summary>
		/// Thrown, if a requested connection could not be found.
		/// </summary>
		/// <param name="aComponent">Considered component.</param>
		public ConnectionNotFoundException(Identifier.IIdentifier aComponentID, Identifier.IIdentifier aRoleID) : base( "Connection for '<" + aComponentID.ToString()+", "+ aRoleID.ToString() + ">' could not be found!")
		{
		}
	}
}