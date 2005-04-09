using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{
	/// <summary>
	/// ISignatureBuilder. Builds ISignatures.
	/// </summary>
	/// <remarks>
	/// Currently the signatures can not be created using a builder.
	/// 
	/// <p>This builder interface contains all non model-level specifical methods of a signature.</p>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.3  2005/04/08 16:50:31  kelsaka
	/// - added interface builder implementation
	///
	/// Revision 1.2  2005/04/08 15:40:06  kelsaka
	/// - added SignatureBuilder
	/// - fixed bug: some new entities were not added to component model
	///
	/// Revision 1.1  2005/04/06 19:06:59  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// </pre>
	/// </remarks>
	public interface ISignatureBuilder
	{
		#region Properties

		/// <summary>
		/// Returns the <see cref="ISignatureIdentifier"/> of the actual interface.
		/// </summary>
		ISignatureIdentifier SignatureID
		{
			get;
		}

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		ISignature Signature
		{
			get;
		}

		#endregion
	}
}
