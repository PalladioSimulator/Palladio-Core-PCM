using System;
using Palladio.ComponentModel.Builder.DeploymentLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;


namespace Palladio.ComponentModel.Builder.ImplementationLevelBuilder
{

	/// <summary>
	/// Builder interface for implementation-level specific methods of types.
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
	public interface ITypeImplementationLevelBuilder : ITypeBuilder
	{

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		ITypeTypeLevelBuilder TypeLevelBuilder
		{
			get;
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		ITypeDeploymentLevelBuilder DeploymentLevelBuilder
		{
			get;
		}



	}
}
