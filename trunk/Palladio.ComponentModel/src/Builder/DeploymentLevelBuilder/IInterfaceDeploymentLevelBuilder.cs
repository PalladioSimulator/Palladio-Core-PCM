using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;


namespace Palladio.ComponentModel.Builder.DeploymentLevelBuilder
{

	/// <summary>
	/// Builder interface for deployment-level specific methods of interfaces.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/07 17:49:31  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// </pre>
	/// </remarks>
	public interface IInterfaceDeploymentLevelBuilder : IInterfaceBuilder
	{


		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		IInterfaceImplementationLevelBuilder ImplementationLevelBuilder
		{
			get;
		}


	}
}
