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
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
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