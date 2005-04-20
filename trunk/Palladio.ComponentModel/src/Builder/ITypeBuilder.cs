using System;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{
	/// <summary>
	/// ITypeBuilder. Builds ITypes.
	/// Alternatively directly use the signatures methods for creating a new type.
	/// </summary>
	/// <remarks>
	/// <p>This builder interface contains all non model-level specifical methods of a signature.</p>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.2  2005/04/16 12:37:46  kelsaka
	/// - added first ideas using constraints with the builders
	///
	/// Revision 1.1  2005/04/13 09:27:17  kelsaka
	/// - added builders (including interfaces) for types and parameters of signatures.
	///
	/// </pre>
	/// </remarks>
	public interface ITypeBuilder
	{
		#region Methods


		#endregion

		#region Properties


		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		IType Type
		{
			get;
		}

		#endregion
	}
}
