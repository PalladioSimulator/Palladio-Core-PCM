using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a role could not be found.
	/// </summary>
	public class RoleIDNotFoundException : ApplicationException
	{
		/// <summary>
		/// Error indicating, that a role could not be found.
		/// </summary>
		/// <param name="aRoleID">Role which couldn't be found.</param>
		public RoleIDNotFoundException(string aRoleID) : base( "Role " + aRoleID + " not found!")
		{
		}
	}
}