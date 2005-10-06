using System.Collections;
using Palladio.QoSAdaptor.Pattern;

namespace Palladio.QoSAdaptor.Interfaces
{
	/// <summary>
	/// Represents a mismatch between two interface model descriptions. 
	/// 
	/// TODO: Find similarities between the interface model mismatches.
	/// </summary>
	public interface IMismatch
	{
		/// <summary>
		/// String representation of the mismatch needed in the GUI.
		/// </summary>
		/// <returns></returns>
		string ToString();

		/// <summary>
		/// A list of PatternDescriptions of patterns that are able to correct 
		/// this mismatch.
		/// </summary>
		IList Patterns{get;}

		/// <summary>
		/// Returns the name of the mismatched attribute belonging to this 
		/// Mismatch
		/// </summary>
		string MismatchAttribute{get;}

		/// <summary>
		/// Returns the name of the mismatched subattribute belonging to this 
		/// Mismatch
		/// </summary>
		string MismatchSubAttribute{get;}

		/// <summary>
		/// Adds the PatternDescription of a pattern that is able to correct 
		/// this mismatch.
		/// </summary>
		/// <param name="pattern"></param>
		void AddPattern (PatternDescription pattern);
	}
}
