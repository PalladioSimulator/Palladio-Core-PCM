using System;

namespace Palladio.Identifier
{
	/// <summary>
	/// A string ID
	/// </summary>
	public class StringIdentifier : IIdentifier
	{
		/// <summary>
		/// The internal ID representation
		/// </summary>
		protected string s;

		/// <summary>
		/// Default constructor
		/// </summary>
		/// <param name="aID">The string to be converted to an ID</param>
		public StringIdentifier(string aID)
		{
			this.s = aID;
		}
		
		/// <summary>
		/// An conversion operator to convert basic string to StringIDs
		/// </summary>
		/// <param name="s">The string to be converted</param>
		/// <returns>A string ID</returns>
		public static implicit operator StringIdentifier (string s)
		{
			return new StringIdentifier(s);
		}

		/// <summary>
		/// Overridden equals method to compare two string IDs
		/// </summary>
		/// <param name="aID">The ID to compare to</param>
		/// <returns>true if the IDs are equal</returns>
		public override bool Equals(object aID)
		{
			if (!(aID is StringIdentifier)) return false;
			if (aID == this) return true;
			if (aID.ToString().Equals(s)) return true;
			return false;
		}

		/// <summary>
		/// Calculate a hash code for this ID
		/// </summary>
		/// <returns>The hash code of this ID</returns>
		public override int GetHashCode()
		{
			return s.GetHashCode();
		}

		/// <summary>
		/// Get a string representation of this ID
		/// </summary>
		/// <returns>A string representation of this ID</returns>
		public override string ToString()
		{
			return s.ToString();
		}

		/// <summary>
		/// Create a copy of this ID
		/// </summary>
		/// <returns>A clone of this ID</returns>
		public object Clone()
		{
			return new StringIdentifier(s);
		}
	}
}
