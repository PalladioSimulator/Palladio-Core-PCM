using System;
using System.Collections;
namespace Utils.Collections 
{
	/// <summary>
	///     A collection that contains no duplicate elements.
	///     To reach this, the Add Methods of a default ArrayList 
	///     are extended.
	/// </summary>
	public class Set : ArrayList 
	{

		/// <summary>
		///     Code indicating that an element was NOT 
		///     added to the set.
		/// </summary>
		public const int ERROR_CODE = -1;



		public Set() : base()
		{
		}

		public Set(ICollection c) : base(c) 
		{
		}

		public Set(int initialCapacity) : base(initialCapacity) 
		{
		}

		/// <summary>If value is not in this set it is added, otherwise not.</summary>
		/// 
		/// <param name="value"></param>
		/// 
		/// <returns></returns>
		/// <seealso cref="ArrayList.Add"></seealso>
		public override int Add(object value) 
		{
			if (!Contains(value)) 
			{
				return base.Add(value);
			}
			return ERROR_CODE;
		}

		/// <summary>If value is not in this set it is added, otherwise not.</summary>
		/// 
		/// <param name="index"></param>
		/// <param name="value"></param>
		/// 
		/// <seealso cref="ArrayList.Insert"></seealso>
		public override void Insert(int index, object value) 
		{
			if (!Contains(value)) 
			{
				base.Insert(index,value);
			}
		}

		/// <summary>Only every element which is not in this set is added.</summary>
		/// 
		/// <param name="index"></param>
		/// <param name="c"></param>
		/// 
		/// <seealso cref="ArrayList.InsertRange"></seealso>
		public override void InsertRange(int index, ICollection c) 
		{
			foreach(object obj in c)
			{
				if(!Contains(obj))
				{
					base.Insert(index,obj);
					index++;
				}
			}
		}

		/// <summary>Only every element which is not in this set is added.</summary>
		/// 
		/// <param name="c"></param>
		/// 
		/// <seealso cref="ArrayList.AddRange"></seealso>
		public override void AddRange(ICollection c) 
		{
			foreach(object obj in c)
			{
				if(!Contains(obj))
				{
					base.Add(obj);
				}
			}
		}


		public override object Clone()
		{
			return new Set(this);
		}

		// <summary>
		//   Compares this object to the specified object.
		//   Returns true if they are equal, false otherwise.
		// </summary>
		public override bool Equals(object obj)
		{
			if (obj is Set) 
			{
				Set other = (Set)obj;
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

	}
}
