using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;


namespace Palladio.ComponentModel.Builder.DeploymentLevelBuilder
{

	/// <summary>
	/// Builder interface for deployment-level specific methods of protocols.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.1  2005/04/08 16:50:31  kelsaka
	/// - added interface builder implementation
	///
	/// Revision 1.1  2005/04/08 15:40:06  kelsaka
	/// - added SignatureBuilder
	/// - fixed bug: some new entities were not added to component model
	///
	/// </pre>
	/// </remarks>
	public interface IProtocolDeploymentLevelBuilder : IProtocolBuilder
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
