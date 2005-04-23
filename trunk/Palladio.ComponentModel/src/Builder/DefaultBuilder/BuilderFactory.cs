using System;
using System.Collections;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypedBuilderLists;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.BuilderConstraints;
using Palladio.ComponentModel.BuilderConstraints.DefaultConstraints.TypeLevelConstraints;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

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
	/// Revision 1.2  2005/04/23 17:42:08  kelsaka
	/// - added further methods for constraint-support
	///
	/// Revision 1.1  2005/04/23 14:56:44  kelsaka
	/// - enhanced constraints management
	///
	/// </pre>
	/// </remarks>
	internal class BuilderFactory : IBuilderFactory
	{
		#region data

		/// <summary>
		/// general modelDataManager
		/// </summary>
		IModelDataManager modelDataManager;

		// ArrayLists of Constraints
		RootTypeLevelBuilderList rootTypeLevelBuilderConstraints;
		//ArrayList basicComponentTypeLevelBuilderConstraints;
	
		#endregion

		#region constructors

		/// <summary>
		/// Default constructor. Initializes all builders without any constraints than
		/// default constraints and the the default builders.
		/// </summary>
		/// <param name="modelDataManager"></param>
		public BuilderFactory(IModelDataManager modelDataManager)
		{
			this.modelDataManager = modelDataManager;
			Init();
		}

		#endregion

		#region methods

		/// <summary>
		/// Adds builders and default constraints to the lists of constraints.
		/// </summary>
		private void Init()
		{
			this.rootTypeLevelBuilderConstraints = new RootTypeLevelBuilderList();
			this.rootTypeLevelBuilderConstraints.Add(new DefaultRootTypeLevelBuilder(modelDataManager, this));
			this.rootTypeLevelBuilderConstraints.Add(new RootTypeLevelConstraint());
		}
	
		#region IBuilderFactory members

		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		public void AddBuilderConstraint (IRootTypeLevelBuilder builderConstraint)
		{
			this.rootTypeLevelBuilderConstraints.Add(builderConstraint);
		}

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		public void RemoveBuilderConstraint (IRootTypeLevelBuilder builderConstraint)
		{
			this.rootTypeLevelBuilderConstraints.Remove(builderConstraint);
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
		/// Creates a new builder including all actually defined constraints for this builder.
		/// </summary>
		/// <param name="component">The component to build</param>
		/// <returns>Basic component builder for the type level.</returns>
		public IBasicComponentTypeLevelBuilder GetBasicComponentTypeLevelBuilder (IComponent component)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Creates a new builder including all actually defined constraints for this builder.
		/// </summary>
		/// <param name="component">The component to build</param>
		/// <returns>Composite component builder for the type level.</returns>
		public ICompositeComponentTypeLevelBuilder GetCompositeComponentTypeLevelBuilder (IComponent component)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Creates a new builder including all actually defined constraints for this builder.
		/// </summary>
		/// <param name="iInterface">The interface to build</param>
		/// <returns>interface builder for the type level.</returns>
		public IInterfaceTypeLevelBuilder GetInterfaceTypeLevelBuilder (IInterface iInterface)
		{
			throw new NotImplementedException ();
		}

		#endregion

		#endregion

		#region properties

		/// <summary>
		/// The root builder of the actual component model. Root builder for the type level.
		/// Use this builder to set up the static structure of the component model.
		/// </summary>
		public IRootTypeLevelBuilder RootBuilder
		{
			get
			{
				return this.rootTypeLevelBuilderConstraints.GetOuterBuilder();
			}
		}

		#endregion
	}
}
