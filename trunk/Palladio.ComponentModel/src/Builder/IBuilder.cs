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
	/// Revision 1.1  2005/04/16 12:37:46  kelsaka
	/// - added first ideas using constraints with the builders
	///
	/// </pre>
	/// </remarks>
	public interface IBuilder
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

		/// <summary>
		/// The list of actually attached constraints.
		/// </summary>
		IDictionary Constraints
		{
			get;
		}

		#endregion		
	}
}
