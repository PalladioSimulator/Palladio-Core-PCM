using Palladio.Identifier;

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
	/// Revision 1.2  2005/02/24 20:13:05  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
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

		/// <summary>
		/// Error indicating, that a signature could not be found.
		/// </summary>
		/// <param name="aSig">Signature which couldn't be found.</param>
		public SignatureNotFoundException(IIdentifier aSig) : base( "Signature with ID " + aSig.ToString() + " not found!")
		{
		}
	}
}