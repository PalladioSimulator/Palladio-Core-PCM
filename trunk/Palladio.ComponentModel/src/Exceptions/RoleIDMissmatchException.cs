using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// This Exception occures if a signature is added to an interface container with 
	/// a different role as the signature
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
	public class RoleIDMissmatchException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that no interface is associated with a role as required.
		/// </summary>
		/// <param name="roleExpected">The role ID expected by a certain code piece</param>
		/// <param name="roleFound">The role ID found instead of the expected one</param>
		public RoleIDMissmatchException(string roleFound, string roleExpected) : base( "Entered roles missmatch. The role expected was: "+ roleExpected + ". The role found was: "+roleFound)
		{
		}
	}
}