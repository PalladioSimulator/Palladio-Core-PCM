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
	/// Revision 1.1  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// Revision 1.2  2004/05/19 08:03:57  sbecker
	/// Changed Exceptions to ComponentModelExceptions
	/// Added CVS Logs
	///
	///
	/// </pre>
	/// </remarks>
	public class MissingRoleIDException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a role could not be found.
		/// </summary>
		/// <param name="aRoleID">Role which couldn't be found.</param>
		public MissingRoleIDException() : base( "No RoleID specified for interface!")
		{
		}
	}
}