using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;


namespace Palladio.ComponentModel.Builder.DeploymentLevelBuilder
{

	/// <summary>
	/// Builder interface for deployment-level specific methods of types.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.1  2005/04/13 09:27:17  kelsaka
	/// - added builders (including interfaces) for types and parameters of signatures.
	///
	/// </pre>
	/// </remarks>
	public interface ITypeDeploymentLevelBuilder : ITypeBuilder
	{

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		ITypeImplementationLevelBuilder ImplementationLevelBuilder
		{
			get;
		}


	}
}
