using System;
using System.Collections;

namespace Palladio.Utils.Collections
{
	/// <summary>
	/// Hashmap.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/05/24 09:18:49  sliver
	/// added Hashmap
	///
	/// </pre>
	/// </remarks>
	public class Hashmap : Hashtable, ICloneable 	
	{

		/// <summary>
		/// The Equals method determines whether the specified 
		/// System.Object is equal to the current System.Object.
		/// </summary>
		/// <param name="obj">Contains the Object to compare with 
		/// the current object.</param>
		/// <returns>Returns true if the specified object is equal 
		/// to the current objector or false if the obejcts 
		/// are not equal.</returns>
		public override bool Equals(object obj)
		{
			if (!(obj is Hashmap)) return false;
			if (obj == (object)this) return true;
			Hashmap hm = (Hashmap)obj;
			if (this.Count != hm.Count) return false;
			foreach (DictionaryEntry e in this)
			{
				if ((hm[e.Key] == null) || (!hm[e.Key].Equals(e.Value)))
					return false;
			}
			return true;
		}

		/// <summary>
		/// The GetHashCode method serves as a hash function 
		/// for a particular type, suitable for use in hashing 
		/// algorithms and data structures like a hash table.
		/// </summary>
		/// <returns>A hash value for the current object.</returns>
		public override int GetHashCode()
		{
			int result = 0;
			foreach(object key in this.Keys)
			{
				result ^= key.GetHashCode(); 
			}
			return result;
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		object System.ICloneable.Clone()
		{
			return this.Clone();
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public Hashmap Clone()
		{
			Hashmap result = new Hashmap();
			foreach (DictionaryEntry e in this)
			{
				result.Add( ((ICloneable)e.Key).Clone(), ((ICloneable)e.Value).Clone() );
			}
			return result;
		}
		}
}
