using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a signature has already a service effect specification and an other one is added.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	///
	/// </pre>
	/// </remarks>
	public class ServiceEffectAlreadySpecifiedException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a signature has no service effect specification as required.
		/// </summary>
		/// <param name="aSig">Signature without service effect specification.</param>
		public ServiceEffectAlreadySpecifiedException(ISignature aSig) : base( "Signature " + aSig + " has already a service effect specification!")
		{
		}
	}
}