using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a signature has no service effect specification as required.
	/// </summary>
	public class SignatureHasNoServEffSpec : ApplicationException
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