using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that the given role was specified already.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.2  2004/05/23 19:00:07  sliver
	/// added comments
	///
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
	public class RoleIDAlreadySpecifiedException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that the given role was specified already.
		/// </summary>
		/// <param name="aRoleID">RoleID which was already specified.</param>
		public RoleIDAlreadySpecifiedException(string aRoleID) : base( "An interface with the roleID \"" + aRoleID + "\" exists already!")
		{
		}
	}
}