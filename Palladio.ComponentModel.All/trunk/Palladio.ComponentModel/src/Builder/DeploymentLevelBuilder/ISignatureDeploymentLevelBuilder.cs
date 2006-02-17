using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;


namespace Palladio.ComponentModel.Builder.DeploymentLevelBuilder
{

	/// <summary>
	/// Builder interface for deployment-level specific methods of signatures.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.1  2005/04/08 15:40:06  kelsaka
	/// - added SignatureBuilder
	/// - fixed bug: some new entities were not added to component model
	///
	/// </pre>
	/// </remarks>
	public interface ISignatureDeploymentLevelBuilder : ISignatureBuilder
	{

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		ISignatureImplementationLevelBuilder ImplementationLevelBuilder
		{
			get;
		}


	}
}
