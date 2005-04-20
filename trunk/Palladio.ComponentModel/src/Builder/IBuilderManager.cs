using System.Collections;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.BuilderConstraints;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Interface to support adding and removing constraints to / from builders.
	/// Manages the wrappers/decorators for the builders which are used for the constraints.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/04/20 21:02:35  kelsaka
	/// - added first methods for constraints
	///
	/// Revision 1.3  2005/04/20 19:53:20  kelsaka
	/// - Example and CM-Environment are now using the IBuilderManger
	///
	/// Revision 1.2  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.1  2005/04/20 13:08:31  kelsaka
	/// - introduced IModelDataManagement
	/// - integrated use of the new interface
	///
	/// </pre>
	/// </remarks>
	public interface IBuilderManager
	{
		#region methods
		
		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		void AddBuilderConstraint(IBuilderConstraint builderConstraint);

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		void RemoveBuilderConstraint(IBuilderConstraint builderConstraint);

		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		void AddBuilderConstraint(IBasicComponentTypeLevelBuilder builderConstraint);

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		void RemoveBuilderConstraint(IBasicComponentTypeLevelBuilder builderConstraint);

		#endregion

		#region properties

		/// <summary>
		/// The root builder of the actual component model. Root builder for the type level.
		/// Use this builder to set up the static structure of the component model.
		/// </summary>
		IRootTypeLevelBuilder RootBuilder
		{
			get;
		}

		#endregion		
	}
}
