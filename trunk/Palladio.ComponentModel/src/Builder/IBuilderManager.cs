using System.Collections;
using Palladio.ComponentModel.BuilderConstraints;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Interface for support adding constraints to builders.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
