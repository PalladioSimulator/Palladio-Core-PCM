using System;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.BuilderConstraints;
using Palladio.ComponentModel.ModelDataManagement;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// The default implementation of the builder manager.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/04/20 21:02:35  kelsaka
	/// - added first methods for constraints
	///
	/// Revision 1.1  2005/04/20 19:54:22  kelsaka
	/// - Example and CM-Environment are now using the IBuilderManager
	///
	/// </pre>
	/// </remarks>
	internal class BuilderManager : IBuilderManager
	{
		private IModelDataManager modelDataManager;
		private IRootTypeLevelBuilder rootBuilder;

		/// <summary>
		/// The default constructor.
		/// </summary>
		/// <param name="modelDataManager">Model data management.</param>
		public BuilderManager(IModelDataManager modelDataManager)
		{
			this.modelDataManager = modelDataManager;
			Init (modelDataManager);
		}

		/// <summary>
		/// Initialisation.
		/// </summary>
		/// <param name="modelDataManager">Data management.</param>
		private void Init (IModelDataManager modelDataManager)
		{
			this.rootBuilder = new DefaultRootTypeLevelBuilder(modelDataManager);
		}

		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		public void AddBuilderConstraint (IBuilderConstraint builderConstraint)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		public void RemoveBuilderConstraint (IBuilderConstraint builderConstraint)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		public void AddBuilderConstraint (IBasicComponentTypeLevelBuilder builderConstraint)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		public void RemoveBuilderConstraint (IBasicComponentTypeLevelBuilder builderConstraint)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// The root builder of the actual component model. Root builder for the type level.
		/// Use this builder to set up the static structure of the component model.
		/// </summary>
		public IRootTypeLevelBuilder RootBuilder
		{
			get
			{	
				return rootBuilder;
			}			
		}
	}
}
