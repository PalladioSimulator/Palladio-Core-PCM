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
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
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