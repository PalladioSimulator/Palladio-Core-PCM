using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that the role of an interface is missing.
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
	public class MissingRoleIDException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that an interface has no role identifier.
		/// </summary>
		public MissingRoleIDException() : base( "No RoleID specified for interface!")
		{
		}
	}
}