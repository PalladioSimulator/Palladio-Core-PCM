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
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public class ConnectionNotFoundException : ComponentModelException
	{
		/// <summary>
		/// Thrown, if a requested connection could not be found.
		/// </summary>
		/// <param name="aRole">Considered role.</param>
		public ConnectionNotFoundException(IRole aRole) : base( "Connection for '" + aRole.ToString() + "' could not be found!")
		{
		}

		/// <summary>
		/// Thrown, if a requested connection could not be found.
		/// </summary>
		/// <param name="aComponentID">Considered component.</param>
		/// <param name="aRoleID">The attached role.</param>
		public ConnectionNotFoundException(Identifier.IIdentifier aComponentID, Identifier.IIdentifier aRoleID) : base( "Connection for '<" + aComponentID.ToString()+", "+ aRoleID.ToString() + ">' could not be found!")
		{
		}
	}
}