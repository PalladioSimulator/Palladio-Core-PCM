using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that an signature could not be found, e. g. not found in an interface.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.5  2005/05/27 11:20:20  kelsaka
	/// - added methods for accessing builders of implementation and deployment level to BuilderManager.
	///
	/// Revision 1.4  2005/05/21 17:12:17  kelsaka
	/// - added new exception for use with signatures
	/// - finished adding constraints for the type level
	///
	/// </pre>
	/// </remarks>
	public class SignatureNotFoundException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that an signature could not be found, e. g. not found in an interface.
		/// </summary>
		/// <param name="aSignatureID">The id of the signature that could not be found.</param>
		public SignatureNotFoundException(ISignatureIdentifier aSignatureID) : 
			base( "Interface " + (aSignatureID != null ? aSignatureID.ToString() : "<NULL>" )+ " could not be found!")
		{
		}

		/// <summary>
		/// Error indicating, that an signature could not be found, e. g. not found in an interface.
		/// </summary>
		/// <param name="aSignatureID">The id of the signature that could not be found.</param>
		/// <param name="message">The error message.</param>
		public SignatureNotFoundException(ISignatureIdentifier aSignatureID, string message) : 
			base( "Signature " + (aSignatureID != null ? aSignatureID.ToString() : "<NULL>" )+ " could not be found! Error message: " + message)
		{
		}

		/// <summary>
		/// Error indicating, that an signature could not be found, e. g. not found in an interface.
		/// </summary>
		/// <param name="aSignatureID">The id of the signature that could not be found.</param>
		/// <param name="iFaceID">The indentifier of the interface whos signature cound not be found.</param>
		/// <param name="message">The error message.</param>
		public SignatureNotFoundException(ISignatureIdentifier aSignatureID, IInterfaceIdentifier iFaceID, string message) : 
			base( "Signature" + aSignatureID.ToString() + " could not be found in " + iFaceID.ToString() + "! Error message: " + message)
		{
		}
	}
}