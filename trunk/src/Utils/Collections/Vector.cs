using System;
using System.Collections;

namespace Utils.Collections
{
	/// <summary>
	/// Vector with an useful Equals-Method.
	/// </summary>
	public class Vector : ArrayList 
	{
		public Vector() : base()
		{
		}

		public Vector(ICollection c) : base(c) 
		{
		}

		public Vector(int initialCapacity) : base(initialCapacity) 
		{
		}

		// <summary>
		//   Compares this object to the specified object.
		//   Returns true if they are equal, false otherwise.
		// </summary>
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

		// <summary>
		//   Returns a stringified representation of the object.
		//   This is not supposed to be used for user presentation,
		//   use Format() for that and IFormattable.
		//
		//   ToString is mostly used for debugging purposes.
		// </summary>
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

		public override int GetHashCode() 
		{
			return base.GetHashCode ();
		}

		public override object Clone()
		{
			return new Vector(this);
		}

	}
}
