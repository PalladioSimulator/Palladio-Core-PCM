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
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
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