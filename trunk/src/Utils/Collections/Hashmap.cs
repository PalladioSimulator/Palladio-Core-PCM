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
	/// Revision 1.2  2004/06/02 14:53:08  sbecker
	/// Added Constructors
	///
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

		#region Hashmap()
		/// <overloads>
		/// Initializes a new instance of the <see cref="Hashmap"/> class.
		/// </overloads>
		/// <summary>
		/// Initializes a new instance of the <see cref="Hashmap"/> class
		/// that is empty and has the default initial capacity, the default load factor,
		/// the default hash code provider and the default comparer.
		/// </summary>
		/// <remarks>Please refer to <see cref="Hashmap()"/> for details.</remarks>

		public Hashmap() : base() {}

		#endregion
		#region Hashmap(IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="Hashmap"/> class
		/// that is empty and has the default initial capacity, the default load factor,
		/// the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="Hashmap"/>.</para>
		/// <para>-or-</para>
		/// <para>A null reference to use the default hash code provider, which is each key's
		/// implementation of <see cref="Object.GetHashCode"/>.</para></param>
		/// <param name="comparer">
		/// <para>The <see cref="IComparer"/> to use to determine whether two keys are equal.</para>
		/// <para>-or-</para>
		/// <para>A null reference to use the default comparer, which is each key's
		/// implementation of <see cref="Object.Equals"/>.</para></param>
		/// <remarks>
		/// Please refer to <see cref="Hashmap(IHashCodeProvider, IComparer)"/> for details.
		/// </remarks>

		public Hashmap(IHashCodeProvider provider, IComparer comparer) : base (provider,comparer){}

		#endregion
		#region Hashmap(Int32)

		/// <summary>
		/// Initializes a new instance of the <see cref="Hashmap"/> class
		/// that is empty and has the specified initial capacity, the default load factor,
		/// the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="capacity">The approximate number of elements that the new
		/// <see cref="Hashmap"/> is initially capable of storing.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <paramref name="capacity"/> is less than zero.</exception>
		/// <remarks>Please refer to <see cref="Hashmap(Int32)"/> for details.</remarks>

		public Hashmap(int capacity) : base (capacity) {}

		#endregion
		#region Hashmap(Int32, IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="Hashmap"/> class
		/// that is empty and has the specified initial capacity, the default load factor,
		/// the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="capacity">The approximate number of elements that the new
		/// <see cref="Hashmap"/> is initially capable of storing.</param>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="Hashmap"/>.</para>
		/// <para>-or-</para>
		/// <para>A null reference to use the default hash code provider, which is each key's
		/// implementation of <see cref="Object.GetHashCode"/>.</para></param>
		/// <param name="comparer">
		/// <para>The <see cref="IComparer"/> to use to determine whether two keys are equal.</para>
		/// <para>-or-</para>
		/// <para>A null reference to use the default comparer, which is each key's
		/// implementation of <see cref="Object.Equals"/>.</para></param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <paramref name="capacity"/> is less than zero.</exception>
		/// <remarks>
		/// Please refer to <see cref="Hashmap(Int32, IHashCodeProvider, IComparer)"/> for details.
		/// </remarks>

		public Hashmap(int capacity,
			IHashCodeProvider provider, IComparer comparer) : base (capacity,provider,comparer){}

		#endregion
		#region Hashmap(Int32, Single)

		/// <summary>
		/// Initializes a new instance of the <see cref="Hashmap"/> class
		/// that is empty and has the specified initial capacity, the specified load factor,
		/// the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="capacity">The approximate number of elements that the new
		/// <see cref="Hashmap"/> is initially capable of storing.</param>
		/// <param name="loadFactor">A number in the range from 0.1 through 1.0
		/// indicating the maximum ratio of elements to buckets.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="capacity"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="loadFactor"/> is less than 0.1.</para>
		/// <para>-or-</para>
		/// <para><paramref name="loadFactor"/> is greater than 1.0.</para></exception>
		/// <remarks>Please refer to <see cref="Hashmap(Int32, Single)"/> for details.</remarks>
		public Hashmap(int capacity, float loadFactor) : base (capacity,loadFactor) {}

		#endregion
		#region Hashmap(Int32, Single, IHashCodeProvider, IComparer)
		/// <summary>
		/// Initializes a new instance of the <see cref="Hashmap"/> class
		/// that is empty and has the specified initial capacity, the specified load factor,
		/// the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="capacity">The approximate number of elements that the new
		/// <see cref="Hashmap"/> is initially capable of storing.</param>
		/// <param name="loadFactor">A number in the range from 0.1 through 1.0
		/// indicating the maximum ratio of elements to buckets.</param>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="Hashmap"/>.</para>
		/// <para>-or-</para>
		/// <para>A null reference to use the default hash code provider, which is each key's
		/// implementation of <see cref="Object.GetHashCode"/>.</para></param>
		/// <param name="comparer">
		/// <para>The <see cref="IComparer"/> to use to determine whether two keys are equal.</para>
		/// <para>-or-</para>
		/// <para>A null reference to use the default comparer, which is each key's
		/// implementation of <see cref="Object.Equals"/>.</para></param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="capacity"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="loadFactor"/> is less than 0.1.</para>
		/// <para>-or-</para>
		/// <para><paramref name="loadFactor"/> is greater than 1.0.</para></exception>
		/// <remarks>
		/// Please refer to <see cref="Hashmap(Int32, Single, IHashCodeProvider, IComparer)"/>
		/// for details.</remarks>
		public Hashmap(int capacity, float loadFactor,
			IHashCodeProvider provider, IComparer comparer) : base (capacity,loadFactor,provider,comparer){}

		#endregion
		#region Hashmap(Hashmap)

		/// <summary>
		/// Initializes a new instance of the <see cref="Hashmap"/> class
		/// that contains elements copied from the specified dictionary and
		/// that has the same initial capacity as the number of elements copied, the
		/// default load factor, the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="dictionary">The <see cref="Hashmap"/>
		/// whose elements are copied to the new collection.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="dictionary"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Hashmap(IDictionary)"/> for details.</remarks>

		public Hashmap(Hashmap dictionary) : base(dictionary) {}

		#endregion
		#region Hashmap(IDictionary)

		/// <summary>
		/// Initializes a new instance of the <see cref="Hashmap"/> class
		/// that contains elements copied from the specified <see cref="IDictionary"/>
		/// and that has the same initial capacity as the number of elements copied, the
		/// default load factor, the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="dictionary">The <see cref="IDictionary"/>
		/// whose elements are copied to the new collection.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="dictionary"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Hashmap(IDictionary)"/> for details.</remarks>

		public Hashmap(IDictionary dictionary) : base (dictionary){}

		#endregion
		#region Hashmap(IDictionary, IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="Hashmap"/> class
		/// that contains elements copied from the specified <see cref="IDictionary"/>
		/// and that has the same initial capacity as the number of elements copied, the
		/// default load factor, the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="dictionary">The <see cref="IDictionary"/>
		/// whose elements are copied to the new collection.</param>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="Hashmap"/>.</para>
		/// <para>-or-</para>
		/// <para>A null reference to use the default hash code provider, which is each key's
		/// implementation of <see cref="Object.GetHashCode"/>.</para></param>
		/// <param name="comparer">
		/// <para>The <see cref="IComparer"/> to use to determine whether two keys are equal.</para>
		/// <para>-or-</para>
		/// <para>A null reference to use the default comparer, which is each key's
		/// implementation of <see cref="Object.Equals"/>.</para></param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="dictionary"/> is a null reference.</exception>
		/// <remarks>
		/// Please refer to <see cref="Hashmap(IDictionary, IHashCodeProvider, IComparer)"/>
		/// for details.</remarks>

		public Hashmap(IDictionary dictionary,
			IHashCodeProvider provider, IComparer comparer) : base (dictionary,provider,comparer){}

		#endregion
		#region Hashmap(IDictionary, Single)

		/// <summary>
		/// Initializes a new instance of the <see cref="Hashmap"/> class
		/// that contains elements copied from the specified <see cref="IDictionary"/>
		/// and that has the same initial capacity as the number of elements copied, the
		/// specified load factor, the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="dictionary">The <see cref="IDictionary"/>
		/// whose elements are copied to the new collection.</param>
		/// <param name="loadFactor">A number in the range from 0.1 through 1.0
		/// indicating the maximum ratio of elements to buckets.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="dictionary"/> is a null reference.</exception>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="loadFactor"/> is less than 0.1.</para>
		/// <para>-or-</para>
		/// <para><paramref name="loadFactor"/> is greater than 1.0.</para></exception>
		/// <remarks>
		/// Please refer to <see cref="Hashmap(IDictionary, Single)"/> for details.
		/// </remarks>
		public Hashmap(IDictionary dictionary, float loadFactor) : base (dictionary,loadFactor){}

		#endregion
		#region Hashmap(IDictionary, Single, IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="Hashmap"/> class
		/// that contains elements copied from the specified <see cref="IDictionary"/>
		/// and that has the same initial capacity as the number of elements copied, the
		/// specified load factor, the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="dictionary">The <see cref="IDictionary"/>
		/// whose elements are copied to the new collection.</param>
		/// <param name="loadFactor">A number in the range from 0.1 through 1.0
		/// indicating the maximum ratio of elements to buckets.</param>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="Hashmap"/>.</para>
		/// <para>-or-</para>
		/// <para>A null reference to use the default hash code provider, which is each key's
		/// implementation of <see cref="Object.GetHashCode"/>.</para></param>
		/// <param name="comparer">
		/// <para>The <see cref="IComparer"/> to use to determine whether two keys are equal.</para>
		/// <para>-or-</para>
		/// <para>A null reference to use the default comparer, which is each key's
		/// implementation of <see cref="Object.Equals"/>.</para></param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="dictionary"/> is a null reference.</exception>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="loadFactor"/> is less than 0.1.</para>
		/// <para>-or-</para>
		/// <para><paramref name="loadFactor"/> is greater than 1.0.</para></exception>
		/// <remarks>
		/// Please refer to <see cref="Hashmap(IDictionary, Single, IHashCodeProvider, IComparer)"/>
		/// for details.</remarks>
		public Hashmap(IDictionary dictionary,
			float loadFactor, IHashCodeProvider provider, IComparer comparer) : base(dictionary,loadFactor,provider,comparer){}

		#endregion
	}
}
