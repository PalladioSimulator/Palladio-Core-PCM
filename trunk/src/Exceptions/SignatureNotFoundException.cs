using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a signature could not be found.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.2  2004/05/19 08:03:57  sbecker
	/// Changed Exceptions to ComponentModelExceptions
	/// Added CVS Logs
	///
	///
	/// </pre>
	/// </remarks>
	public class SignatureNotFoundException : ComponentModelException
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