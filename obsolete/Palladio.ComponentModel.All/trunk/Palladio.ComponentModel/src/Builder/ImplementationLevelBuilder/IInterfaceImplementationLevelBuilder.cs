using System;
using Palladio.ComponentModel.Builder.DeploymentLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;


namespace Palladio.ComponentModel.Builder.ImplementationLevelBuilder
{

	/// <summary>
	/// Builder interface for implementation-level specific methods of interfaces.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/04/08 15:40:06  kelsaka
	/// - added SignatureBuilder
	/// - fixed bug: some new entities were not added to component model
	///
	/// Revision 1.1  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// </pre>
	/// </remarks>
	public interface IInterfaceImplementationLevelBuilder : IInterfaceBuilder
	{

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		IInterfaceTypeLevelBuilder TypeLevelBuilder
		{
			get;
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		IInterfaceDeploymentLevelBuilder DeploymentLevelBuilder
		{
			get;
		}

	}
}
