using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// The AttachedInterface is invalid. This is the case, if a component does not contain
	/// the role of the AttachedInterface.
	/// </summary>
	public class InvalidAttachedInterfaceException : ApplicationException
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