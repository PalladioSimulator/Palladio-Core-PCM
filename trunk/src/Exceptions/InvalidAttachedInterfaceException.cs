using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// The AttachedInterface is invalid. This is the case, if the component associated 
	/// with the AttachedInterface is not contained in the surrounding CompositeComponent or
	/// if it does not provide the required role.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/05/23 19:00:07  sliver
	/// added comments
	///
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
		/// The AttachedInterface is invalid. This is the case, if the component associated 
		/// with the AttachedInterface is not contained in the surrounding CompositeComponent or
		/// if it does not provide the required role.
		/// </summary>
		public InvalidAttachedInterfaceException(AttachedInterface anInterface) : base( "AttachedInterface " + anInterface + "is invalid!")
		{
		}
	}
}