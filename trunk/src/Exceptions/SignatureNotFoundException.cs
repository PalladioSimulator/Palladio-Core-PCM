using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a signature could not be found.
	/// </summary>
	public class SignatureNotFoundException : ApplicationException
	{
		/// <summary>
		/// Error indicating, that a signature could not be found.
		/// </summary>
		/// <param name="aSig">Signature which couldn't be found.</param>
		public SignatureNotFoundException(ISignature aSig) : base( "Signature " + aSig + " not found!")
		{
		}
	}
}