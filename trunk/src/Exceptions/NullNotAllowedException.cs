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
	/// Revision 1.1  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// Revision 1.1  2004/05/19 12:55:14  sbecker
	/// Implemented more tests and more Factory methods
	///
	///
	/// </pre>
	/// </remarks>
	public class NullNotAllowedException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that no interface is associated with a role as required.
		/// </summary>
		/// <param name="roleExpected">The role ID expected by a certain code piece</param>
		/// <param name="roleFound">The role ID found instead of the expected one</param>
		public NullNotAllowedException() : base( "Null pointer is not allowed here!")
		{
		}
	}
}