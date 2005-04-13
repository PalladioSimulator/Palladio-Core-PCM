using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;


namespace Palladio.ComponentModel.Builder.TypeLevelBuilder
{

	/// <summary>
	/// Builder interface for type-level specific methods of parameters.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/13 09:27:17  kelsaka
	/// - added builders (including interfaces) for types and parameters of signatures.
	///
	/// </pre>
	/// </remarks>
	public interface IParameterTypeLevelBuilder : IParameterBuilder
	{

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		IParameterImplementationLevelBuilder ImplementationLevelBuilder
		{
			get;
		}

	}
}
