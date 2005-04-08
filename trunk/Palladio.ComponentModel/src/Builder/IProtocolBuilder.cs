using System;
using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Builder
{
	/// <summary>
	/// IProtocolBuilder.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/08 15:40:06  kelsaka
	/// - added SignatureBuilder
	/// - fixed bug: some new entities were not added to component model
	///
	/// </pre>
	/// </remarks>
	public interface IProtocolBuilder
	{
		/// <summary>
		/// Returns the <see cref="IProtocolIdentifier"/> of the actual protocol.
		/// </summary>
		IProtocolIdentifier ProtocolID
		{
			get;
		}
	}
}
