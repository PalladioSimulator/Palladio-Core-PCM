using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that no interface is associated with a role as required.
	/// </summary>
	public class RoleIDNotInterfaceRoleIDException : ApplicationException
	{
		/// <summary>
		/// Error indicating, that no interface is associated with a role as required.
		/// </summary>
		/// <param name="aRoleID">Role which couldn't be found.</param>
		public RoleIDNotInterfaceRoleIDException(string aRoleID, IInterfaceModel anInterface) : base( "The role " +  aRoleID + " is not " + anInterface.RoleID + " as expected!")
		{
		}
	}
}