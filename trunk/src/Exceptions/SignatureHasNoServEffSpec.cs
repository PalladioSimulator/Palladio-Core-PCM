using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a signature has no service effect specification as required.
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
	public class SignatureHasNoServEffSpec : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a signature has no service effect specification as required.
		/// </summary>
		/// <param name="aSig">Signature without service effect specification.</param>
		public SignatureHasNoServEffSpec(ISignature aSig) : base( "Signature " + aSig + " has no service effect specification!")
		{
		}
	}
}