using System;

namespace Palladio.Identifier
{
	/// <summary>
	/// A Globally Unique Identifier (GUID)
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
	public class GloballyUniqueIdentifier : IIdentifier
	{
		/// <summary>
		/// The internal ID representation
		/// </summary>
		protected Guid guid;

		/// <summary>
		/// creates a new global unique identifier
		/// </summary>
		public GloballyUniqueIdentifier()
		{
			this.guid = Guid.NewGuid();
		}

		/// <summary>
		/// creates a new global unique identifier using given guid
		/// </summary>
		/// <param name="id">the guid to be used</param>
		public GloballyUniqueIdentifier(Guid id)
		{
			this.guid = id;
		}

		/// <summary>
		/// creates a new global unique identifier using given guid
		/// </summary>
		/// <param name="id">the guid to be used</param>
		public GloballyUniqueIdentifier(string id)
		{
			this.guid = new Guid(id);
		}

		/// <summary>
		/// Overridden equals method to compare two GUIDs
		/// </summary>
		/// <param name="aID">The ID to compare to</param>
		/// <returns>true if the IDs are equal</returns>
		public override bool Equals(object aID)
		{
			if (!(aID is GloballyUniqueIdentifier)) return false;
			if (aID == this) return true;
			if (aID.ToString().Equals(this.guid.ToString())) return true;
			return false;
		}

		/// <summary>
		/// Calculate a hash code for this ID
		/// </summary>
		/// <returns>The hash code of this ID</returns>
		public override int GetHashCode()
		{
			return this.guid.GetHashCode();
		}

		/// <summary>
		/// Get a string representation of this ID
		/// </summary>
		/// <returns>A string representation of this ID</returns>
		public override string ToString()
		{
			return this.guid.ToString();
		}

		/// <summary>
		/// Create a copy of this ID
		/// </summary>
		/// <returns>A clone of this ID</returns>
		public object Clone()
		{
			return new GloballyUniqueIdentifier(this.guid);
		}
	}
}
