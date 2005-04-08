using System;
using Palladio.ComponentModel.Builder.DeploymentLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;


namespace Palladio.ComponentModel.Builder.ImplementationLevelBuilder
{

	/// <summary>
	/// Builder interface for implementation-level specific methods of signatures.
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
	public interface ISignatureImplementationLevelBuilder : ISignatureBuilder
	{

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		ISignatureTypeLevelBuilder TypeLevelBuilder
		{
			get;
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		ISignatureDeploymentLevelBuilder DeploymentLevelBuilder
		{
			get;
		}



	}
}
