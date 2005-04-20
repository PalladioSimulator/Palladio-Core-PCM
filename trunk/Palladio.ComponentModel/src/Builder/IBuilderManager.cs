using System.Collections;
using Palladio.ComponentModel.BuilderConstraints;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Interface to support adding and removing constraints to / from builders.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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

		#endregion

		#region properties

		#endregion		
	}
}
