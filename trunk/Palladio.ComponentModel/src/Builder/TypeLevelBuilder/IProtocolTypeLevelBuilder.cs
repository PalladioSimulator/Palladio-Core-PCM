using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;


namespace Palladio.ComponentModel.Builder.TypeLevelBuilder
{

	/// <summary>
	/// Builder interface for type-level specific methods of protocols.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/04/20 21:02:35  kelsaka
	/// - added first methods for constraints
	///
	/// Revision 1.2  2005/04/12 12:32:39  kelsaka
	/// - removed property to access typed IDs directly from the builders
	/// - renamed the property from 'SignaturID' to 'SignatureID' in ISignature
	///
	/// Revision 1.1  2005/04/08 16:50:31  kelsaka
	/// - added interface builder implementation
	///
	/// </pre>
	/// </remarks>
	public interface IProtocolTypeLevelBuilder : IProtocolBuilder
	{

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		IProtocolImplementationLevelBuilder ImplementationLevelBuilder
		{
			get;
		}

		/// <summary>
		/// The child builder to call for each method defined in the builder interface.
		/// </summary>
		IProtocolTypeLevelBuilder ChildBuilder
		{
			get;
			set;
		}


	}
}
