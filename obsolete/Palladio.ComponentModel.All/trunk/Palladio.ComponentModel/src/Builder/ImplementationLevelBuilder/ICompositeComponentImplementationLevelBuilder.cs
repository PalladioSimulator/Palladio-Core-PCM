using System;
using Palladio.ComponentModel.Builder.DeploymentLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;


namespace Palladio.ComponentModel.Builder.ImplementationLevelBuilder
{

	/// <summary>
	/// Builder interface for implementation-level specific methods of composite components.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// </pre>
	/// </remarks>
	public interface ICompositeComponentImplementationLevelBuilder : ICompositeComponentBuilder
	{

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		ICompositeComponentTypeLevelBuilder TypeLevelBuilder
		{
			get;
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		ICompositeComponentDeploymentLevelBuilder DeploymentLevelBuilder
		{
			get;
		}

	}
}
