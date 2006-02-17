using System;
using System.Collections;

namespace Palladio.Utils.Collections
{
	/// <summary>
	/// Vector overrides the Equals-Method of ArrayList using an 
	/// equals-by-elements instead of an reference-equals. Also
	/// the ToString-Method is replaced by a pretty listing of
	/// the vector elements.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/05/19 13:33:49  sliver
	/// GetHashCode depends on the content of the vector now
	///
	/// Revision 1.1  2004/05/12 13:45:41  sliver
	/// Initial Version
	///
	/// </pre>
	/// </remarks>
	public class Vector : ArrayList 
	{
		/// <summary>
		/// Creates an empty Vector.
		/// </summary>
		public Vector() : base()
		{
		}

		/// <summary>
		/// Creates a Vector containing all elements of the incoming collection.
		/// </summary>
		/// <param name="c">A collection of elements.</param>
		public Vector(ICollection c) : base(c) 
		{
		}

		/// <summary>
		/// Creates a Vector with an initial size of initialCapacity.
		/// </summary>
		/// <param name="initialCapacity">Initial size of the vector.</param>
		public Vector(int initialCapacity) : base(initialCapacity) 
		{
		}

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
			if (obj is Vector) 
			{
				Vector other = (Vector)obj;
				if(other.Count == Count)
				{
					foreach(object o in other)
					{
						if(!Contains(o))
						{
							return false;
						}
					}
					return true;
				}
			}
			return false;
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString() 
		{
			string result = "{ ";
			foreach (object obj in this) 
			{
				result+=obj+" ";
			}
			result+="}";
			return result;
		}

		/// <summary>
		/// The GetHashCode method serves as a hash function 
		/// for a particular type, suitable for use in hashing 
		/// algorithms and data structures like a hash table.
		/// </summary>
		/// <returns>A hash value for the current object.</returns>
		public override int GetHashCode() 
		{
			int result = Count.GetHashCode();
			foreach (object o in this)
			{
				result ^= o.GetHashCode();
			}
			return result;
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new Vector(this);
		}
	}
}
