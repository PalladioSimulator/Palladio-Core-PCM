using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that the provides interface is not a role of the IProvidesMapping.
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
	public class ProvidesInterfaceNotInMappingException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that the provides interface is not a role of the IProvidesMapping.
		/// </summary>
		/// <param name="aRoleID">Role which couldn't be found.</param>
		public ProvidesInterfaceNotInMappingException(string aRoleID, IProvidesMapping aMapping) : base( "Role " + aRoleID + " not found in " + aMapping + "!")
		{
		}
	}
}