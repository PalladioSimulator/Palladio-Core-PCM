using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a component is missing.
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
	public class ComponentNotFoundException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a component is missing.
		/// </summary>
		/// <param name="aRoleID">Role which couldn't be found.</param>
		public ComponentNotFoundException(IComponent aComponent) : base( "Component " + aComponent + " could not be found!")
		{
		}
	}
}