using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{
	/// <summary>
	/// IProtocolBuilder. Builder for protocols.
	/// </summary>
	/// <remarks>
	/// Currently the protocols can not be created using a builder.
	/// 
	/// <p>This builder interface contains all non model-level specifical methods of a protocol.</p>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// Revision 1.4  2005/04/12 12:32:39  kelsaka
	/// - removed property to access typed IDs directly from the builders
	/// - renamed the property from 'SignaturID' to 'SignatureID' in ISignature
	///
	/// Revision 1.3  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.2  2005/04/08 16:50:31  kelsaka
	/// - added interface builder implementation
	///
	/// Revision 1.1  2005/04/08 15:40:06  kelsaka
	/// - added SignatureBuilder
	/// - fixed bug: some new entities were not added to component model
	///
	/// </pre>
	/// </remarks>
	public interface IProtocolBuilder : IEntityBuilder
	{
		#region Properties

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		IProtocol Protocol
		{
			get;
		}

		#endregion
	}
}
