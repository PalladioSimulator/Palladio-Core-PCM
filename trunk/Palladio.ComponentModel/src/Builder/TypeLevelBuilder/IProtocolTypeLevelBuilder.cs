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





	}
}
