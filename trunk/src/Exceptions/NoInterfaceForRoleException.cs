using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that no interface is associated with a role as required.
	/// </summary>
	public class NoInterfaceForRoleException : ApplicationException
	{
		/// <summary>
		/// Error indicating, that no interface is associated with a role as required.
		/// </summary>
		/// <param name="aRoleID">Role which couldn't be found.</param>
		public NoInterfaceForRoleException(string aRoleID) : base( "No interface for role " +  aRoleID + " found!")
		{
		}
	}
}