using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that no interface is associated with a role as required.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/05/19 08:03:57  sbecker
	/// Changed Exceptions to ComponentModelExceptions
	/// Added CVS Logs
	///
	///
	/// </pre>
	/// </remarks>
	public class RoleIDNotInterfaceRoleIDException : ComponentModelException
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