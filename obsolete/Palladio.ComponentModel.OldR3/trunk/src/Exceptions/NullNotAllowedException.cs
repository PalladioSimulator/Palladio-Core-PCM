using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Exception thrown, if a null pointer is found but an object is expected.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/05/23 19:00:07  sliver
	/// added comments
	///
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
		/// Exception thrown, if a null pointer is found but an object is expected.
		/// </summary>
		public NullNotAllowedException() : base( "Null pointer is not allowed here!")
		{
		}
	}
}