using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a role could not be found.
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
	public class RoleIDNotFoundException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a role could not be found.
		/// </summary>
		/// <param name="aRoleID">Role which couldn't be found.</param>
		public RoleIDNotFoundException(Identifier.IIdentifier aRoleID) : base( "Role " + aRoleID.ToString() + " not found!")
		{
		}
	}
}