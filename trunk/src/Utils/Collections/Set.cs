using System;
using System.Collections;

namespace Palladio.Utils.Collections 
{
	/// <summary>
	///     A collection that contains no duplicate elements.
	///     To reach this, the Add Methods of a default Vector 
	///     are extended.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/05/12 14:39:59  sliver
	/// ndoc project added
	///
	/// Revision 1.1  2004/05/12 13:45:41  sliver
	/// Initial Version
	///
	/// </pre>
	/// </remarks>
	public class Set : Vector 
	{

		/// <summary>
		///     Code indicating that an element was NOT 
		///     added to the set.
		/// </summary>
		public const int ERROR_CODE = -1;

		/// <summary>
		/// Creates an empty Set.
		/// </summary>
		public Set() : base()
		{
		}

		/// <summary>
		/// Creates a Set containing all elements of the incoming collection
		/// without any duplicates.
		/// </summary>
		/// <param name="c">Any kind of collection.</param>
		public Set(ICollection c) : base() 
		{
			this.AddRange(c);
		}

		/// <summary>
		/// Creates a Set with a size given by initialCapacity.
		/// </summary>
		/// <param name="initialCapacity">Initial size of the Set.</param>
		public Set(int initialCapacity) : base(initialCapacity) 
		{
		}

		/// <summary>
		/// If the value is not already contained by the set, it is added to it,
		/// otherwise an ERROR_CODE is returned.
		/// </summary>
		/// <param name="value">Object which should be added.</param>
		/// <returns>The index of the value in the Set or ERROR_CODE, if it is already
		/// in the Set.</returns>
		public override int Add(object value) 
		{
			if (!Contains(value)) 
			{
				return base.Add(value);
			}
			return ERROR_CODE;
		}

		/// <summary>
		/// If value is not in this set it is added, otherwise nothing happens.
		/// </summary>
		/// <param name="index">Index, where the object should be added.</param>
		/// <param name="value">Object which should be added.</param>
		public override void Insert(int index, object value) 
		{
			if (!Contains(value)) 
			{
				base.Insert(index,value);
			}
		}

		/// <summary>
		/// Adds each element of the collection, if it is not already contained in the Set.
		/// </summary>
		/// <param name="index">Zero based index, where the elements should be added.</param>
		/// <param name="c">Collection which should be added.</param>
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

		/// <summary>
		/// Adds each element of the collection, if it is not already contained in the Set.
		/// </summary>
		/// <param name="c">Collection which should be added.</param>
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


		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new Set(this);
		}
	}
}
