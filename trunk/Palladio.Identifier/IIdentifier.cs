using System;
using System.Collections;

namespace Palladio.Identifier
{
	/// <summary>
	/// Interface for Identifier types. If you want to create a new ID type implement this
	/// interface and a factory for it.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 12:15:57  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IIdentifier : ICloneable
	{
		/// <summary>
		/// Return true if two IDs are equal
		/// </summary>
		/// <param name="aID">The ID to compare to</param>
		/// <returns>true if the IDs are equal</returns>
		bool Equals(object aID);

		/// <summary>
		/// Format the ID to a string representation (for display or debugging purposes)
		/// </summary>
		/// <returns>A string representation of the ID</returns>
		string ToString();

		/// <summary>
		/// Calculate a hash code for the ID
		/// </summary>
		/// <returns>The hashcode of this ID</returns>
		int GetHashCode();
	}
}
