using System.Collections;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.BuilderConstraints;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Interface to support adding and removing constraints to / from builders and accessing
	/// the root builder for the static structure.
	/// Facade: Reduces the usable interface for external users of the builder. Limits the use
	/// to removing / adding constraints and accessing the root builder.
	/// </summary>
	/// <remarks>
	/// <p>NOTE: Constraints have to be added before building the static structure. If constraints are
	/// added after building a component model entity they are disregarded.</p>
	/// <p>In the same way constraints, that are removed afterwards, do not affect the further building
	/// process of existing entities.
	/// </p>
	/// <p>Constraints are always applied to a certain level of the builder interface. This means that
	/// one builder can only be applied to e. g. the type level but not to the implementation level. If
	/// constraints shall build a hierarchie this is task of the constraints.
	/// </p>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.7  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// Revision 1.6  2005/04/23 17:42:08  kelsaka
	/// - added further methods for constraint-support
	///
	/// Revision 1.5  2005/04/23 14:56:44  kelsaka
	/// - enhanced constraints management
	///
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
		void AddBuilderConstraint(IRootTypeLevelBuilder builderConstraint);

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		void RemoveBuilderConstraint(IRootTypeLevelBuilder builderConstraint);

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

		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		void AddBuilderConstraint(ICompositeComponentTypeLevelBuilder builderConstraint);

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		void RemoveBuilderConstraint(ICompositeComponentTypeLevelBuilder builderConstraint);

		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		void AddBuilderConstraint(IInterfaceTypeLevelBuilder builderConstraint);

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		void RemoveBuilderConstraint(IInterfaceTypeLevelBuilder builderConstraint);

		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		void AddBuilderConstraint(ISignatureTypeLevelBuilder builderConstraint);

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		void RemoveBuilderConstraint(ISignatureTypeLevelBuilder builderConstraint);

		#endregion

		#region properties

		/// <summary>
		/// The root builder of the actual component model. Root builder for the type level.
		/// Use this builder to set up the static structure of the component model.
		/// </summary>
		/// <remarks>Only the root builder is directly accessible. All other builders
		/// are available after creating new structures.</remarks>
		IRootTypeLevelBuilder RootBuilder
		{
			get;
		}

		#endregion		
	}
}
