using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// The AttachedInterface is invalid. This is the case, if a component does not contain
	/// the role of the AttachedInterface.
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
	public class InvalidAttachedInterfaceException : ComponentModelException
	{
		/// <summary>
		/// The AttachedInterface is invalid. This is the case, if a component does not contain
		/// the role of the AttachedInterface.
		/// </summary>
		public InvalidAttachedInterfaceException(AttachedInterface anInterface) : base( "AttachedInterface " + anInterface + "is invalid!")
		{
		}
	}
}