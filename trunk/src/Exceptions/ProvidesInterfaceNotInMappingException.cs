using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that the provides interface is not a role of the IProvidesMapping.
	/// </summary>
	public class ProvidesInterfaceNotInMappingException : ApplicationException
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