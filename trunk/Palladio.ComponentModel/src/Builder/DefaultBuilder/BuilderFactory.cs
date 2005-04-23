using System;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.BuilderConstraints;
using Palladio.ComponentModel.ModelDataManagement;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// The default implementation of the builder factory.
	/// Manages the wrappers/decorators for the builders which are used for the constraints.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/23 14:56:44  kelsaka
	/// - enhanced constraints management
	///
	/// </pre>
	/// </remarks>
	internal class BuilderFactory : IBuilderFactory
	{
		IRootTypeLevelBuilder rootTypeLevelBuilder;	
		IModelDataManager modelDataManager;

		public BuilderFactory(IModelDataManager modelDataManager)
		{
			this.modelDataManager = modelDataManager;
			Init();
		}

		private void Init()
		{
			this.rootTypeLevelBuilder = new DefaultRootTypeLevelBuilder(modelDataManager, this);
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
			get { throw new NotImplementedException (); }
		}

		public IBasicComponentTypeLevelBuilder BasicComponentBuilder
		{
			get { throw new NotImplementedException (); }
		}
	}
}
