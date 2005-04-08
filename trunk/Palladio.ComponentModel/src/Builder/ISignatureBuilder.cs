using System;
using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Builder
{
	/// <summary>
	/// ISignatureBuilder.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
		/// <summary>
		/// Returns the <see cref="ISignatureIdentifier"/> of the actual interface.
		/// </summary>
		ISignatureIdentifier SignatureID
		{
			get;
		}
	}
}
