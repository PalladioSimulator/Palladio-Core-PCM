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
	/// Revision 1.2  2004/06/04 01:54:03  sliver
	/// rework of composite component
	///
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.2  2004/05/19 08:03:57  sbecker
	/// Changed Exceptions to ComponentModelExceptions
	/// Added CVS Logs
	///
	///
	/// </pre>
	/// </remarks>
	public class NoInterfaceForRoleException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that no interface is associated with a role as required.
		/// </summary>
		/// <param name="aRoleID">Role which couldn't be found.</param>
		public NoInterfaceForRoleException(Identifier.IIdentifier aRoleID) : base( "No interface for role " +  aRoleID.ToString() + " found!")
		{
		}
	}
}