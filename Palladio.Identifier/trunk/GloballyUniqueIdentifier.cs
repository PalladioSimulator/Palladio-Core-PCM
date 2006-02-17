using System;

namespace Palladio.Identifier
{
	/// <summary>
	/// A Globally Unique Identifier (GUID)
	/// </summary>
	public class GloballyUniqueIdentifier : IIdentifier
	{
		/// <summary>
		/// The internal ID representation
		/// </summary>
		protected Guid guid;

		public GloballyUniqueIdentifier()
		{
			this.guid = Guid.NewGuid();
		}

		public GloballyUniqueIdentifier(Guid id)
		{
			this.guid = id;
		}

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
