using System;
using System.Collections;
using Palladio.Attributes;

namespace Palladio.Attributes 
{
	#region Interface IIAttributeCollection

	/// <summary>
	/// Defines size, enumerators, and synchronization methods for strongly
	/// typed collections of <see cref="IAttribute"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IIAttributeCollection</b> provides an <see cref="ICollection"/>
	/// that is strongly typed for <see cref="IAttribute"/> elements.
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2.2.1  2004/12/02 23:37:38  uffi
	/// major changes in Palladio.Attributes,
	/// IAttribute added for implementations of attribute values,
	/// AttributeHash is now a typed Hashtable,
	/// IAttributeHash and Factories are currently obsolete, still in repository though.
	///
	/// Revision 1.2  2004/05/18 13:19:58  sliver
	/// Added Clone method for AttributeHash
	///
	/// Revision 1.1  2004/05/13 15:17:31  sbecker
	/// Initial import
	///
	///
	/// </pre>
	/// </remarks>

	public interface IIAttributeCollection 
	{
		#region Properties
		#region Count

		/// <summary>
		/// Gets the number of elements contained in the
		/// <see cref="IIAttributeCollection"/>.
		/// </summary>
		/// <value>The number of elements contained in the
		/// <see cref="IIAttributeCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.Count"/> for details.</remarks>

		int Count { get; }

		#endregion
		#region IsSynchronized

		/// <summary>
		/// Gets a value indicating whether access to the
		/// <see cref="IIAttributeCollection"/> is synchronized (thread-safe).
		/// </summary>
		/// <value><c>true</c> if access to the <see cref="IIAttributeCollection"/> is
		/// synchronized (thread-safe); otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="ICollection.IsSynchronized"/> for details.</remarks>

		bool IsSynchronized { get; }

		#endregion
		#region SyncRoot

		/// <summary>
		/// Gets an object that can be used to synchronize access
		/// to the <see cref="IIAttributeCollection"/>.
		/// </summary>
		/// <value>An object that can be used to synchronize access
		/// to the <see cref="IIAttributeCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.SyncRoot"/> for details.</remarks>

		object SyncRoot { get; }

		#endregion
		#endregion
		#region Methods
		#region CopyTo

		/// <summary>
		/// Copies the entire <see cref="IIAttributeCollection"/> to a one-dimensional <see cref="Array"/>
		/// of <see cref="IAttribute"/> elements, starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the destination of the
		/// <see cref="IAttribute"/> elements copied from the <see cref="IIAttributeCollection"/>.
		/// The <b>Array</b> must have zero-based indexing.</param>
		/// <param name="arrayIndex">The zero-based index in <paramref name="array"/>
		/// at which copying begins.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="array"/> is a null reference.</exception>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <paramref name="arrayIndex"/> is less than zero.</exception>
		/// <exception cref="ArgumentException"><para>
		/// <paramref name="arrayIndex"/> is equal to or greater than the length of <paramref name="array"/>.
		/// </para><para>-or-</para><para>
		/// The number of elements in the source <see cref="IIAttributeCollection"/> is greater
		/// than the available space from <paramref name="arrayIndex"/> to the end of the destination
		/// <paramref name="array"/>.</para></exception>
		/// <remarks>Please refer to <see cref="ICollection.CopyTo"/> for details.</remarks>

		void CopyTo(IAttribute[] array, int arrayIndex);

		#endregion
		#region GetEnumerator

		/// <summary>
		/// Returns an <see cref="IIAttributeEnumerator"/> that can
		/// iterate through the <see cref="IIAttributeCollection"/>.
		/// </summary>
		/// <returns>An <see cref="IIAttributeEnumerator"/>
		/// for the entire <see cref="IIAttributeCollection"/>.</returns>
		/// <remarks>Please refer to <see cref="IEnumerable.GetEnumerator"/> for details.</remarks>

		IIAttributeEnumerator GetEnumerator();

		#endregion
		#endregion
	}

	#endregion
	#region Interface IIAttributeList

	/// <summary>
	/// Represents a strongly typed collection of <see cref="IAttribute"/>
	/// objects that can be individually accessed by index.
	/// </summary>
	/// <remarks>
	/// <b>IIAttributeList</b> provides an <see cref="IList"/>
	/// that is strongly typed for <see cref="IAttribute"/> elements.
	/// </remarks>

	public interface
		IIAttributeList: IIAttributeCollection 
	{
		#region Properties
		#region IsFixedSize

		/// <summary>
		/// Gets a value indicating whether the <see cref="IIAttributeList"/> has a fixed size.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IIAttributeList"/> has a fixed size;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsFixedSize"/> for details.</remarks>

		bool IsFixedSize { get; }

		#endregion
		#region IsReadOnly

		/// <summary>
		/// Gets a value indicating whether the <see cref="IIAttributeList"/> is read-only.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IIAttributeList"/> is read-only;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsReadOnly"/> for details.</remarks>

		bool IsReadOnly { get; }

		#endregion
		#region Item

		/// <summary>
		/// Gets or sets the <see cref="IAttribute"/> element at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index of the
		/// <see cref="IAttribute"/> element to get or set.</param>
		/// <value>
		/// The <see cref="IAttribute"/> element at the specified <paramref name="index"/>.
		/// </value>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IIAttributeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// The property is set and the <see cref="IIAttributeList"/> is read-only.</exception>
		/// <remarks>Please refer to <see cref="IList.this"/> for details.</remarks>

		IAttribute this[int index] { get; set; }

		#endregion
		#endregion
		#region Methods
		#region Add

		/// <summary>
		/// Adds a <see cref="IAttribute"/> to the end
		/// of the <see cref="IIAttributeList"/>.
		/// </summary>
		/// <param name="value">The <see cref="IAttribute"/> object
		/// to be added to the end of the <see cref="IIAttributeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns>The <see cref="IIAttributeList"/> index at which
		/// the <paramref name="value"/> has been added.</returns>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Add"/> for details.</remarks>

		int Add(IAttribute value);

		#endregion
		#region Clear

		/// <summary>
		/// Removes all elements from the <see cref="IIAttributeList"/>.
		/// </summary>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Clear"/> for details.</remarks>

		void Clear();

		#endregion
		#region Contains

		/// <summary>
		/// Determines whether the <see cref="IIAttributeList"/>
		/// contains the specified <see cref="IAttribute"/> element.
		/// </summary>
		/// <param name="value">The <see cref="IAttribute"/> object
		/// to locate in the <see cref="IIAttributeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns><c>true</c> if <paramref name="value"/> is found in the
		/// <see cref="IIAttributeList"/>; otherwise, <c>false</c>.</returns>
		/// <remarks>Please refer to <see cref="IList.Contains"/> for details.</remarks>

		bool Contains(IAttribute value);

		#endregion
		#region IndexOf

		/// <summary>
		/// Returns the zero-based index of the first occurrence of the specified
		/// <see cref="IAttribute"/> in the <see cref="IIAttributeList"/>.
		/// </summary>
		/// <param name="value">The <see cref="IAttribute"/> object
		/// to locate in the <see cref="IIAttributeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns>
		/// The zero-based index of the first occurrence of <paramref name="value"/>
		/// in the <see cref="IIAttributeList"/>, if found; otherwise, -1.
		/// </returns>
		/// <remarks>Please refer to <see cref="IList.IndexOf"/> for details.</remarks>

		int IndexOf(IAttribute value);

		#endregion
		#region Insert

		/// <summary>
		/// Inserts a <see cref="IAttribute"/> element into the
		/// <see cref="IIAttributeList"/> at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index at which
		/// <paramref name="value"/> should be inserted.</param>
		/// <param name="value">The <see cref="IAttribute"/> object
		/// to insert into the <see cref="IIAttributeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is greater than
		/// <see cref="IIAttributeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Insert"/> for details.</remarks>

		void Insert(int index, IAttribute value);

		#endregion
		#region Remove

		/// <summary>
		/// Removes the first occurrence of the specified <see cref="IAttribute"/>
		/// from the <see cref="IIAttributeList"/>.
		/// </summary>
		/// <param name="value">The <see cref="IAttribute"/> object
		/// to remove from the <see cref="IIAttributeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Remove"/> for details.</remarks>

		void Remove(IAttribute value);

		#endregion
		#region RemoveAt

		/// <summary>
		/// Removes the element at the specified index of the
		/// <see cref="IIAttributeList"/>.
		/// </summary>
		/// <param name="index">The zero-based index of the element to remove.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IIAttributeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.RemoveAt"/> for details.</remarks>

		void RemoveAt(int index);

		#endregion
		#endregion
	}

	#endregion
	#region Interface IIAttributeEnumerator

	/// <summary>
	/// Supports type-safe iteration over a collection that
	/// contains <see cref="IAttribute"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IIAttributeEnumerator</b> provides an <see cref="IEnumerator"/>
	/// that is strongly typed for <see cref="IAttribute"/> elements.
	/// </remarks>

	public interface IIAttributeEnumerator 
	{
		#region Properties
		#region Current

		/// <summary>
		/// Gets the current <see cref="IAttribute"/> element in the collection.
		/// </summary>
		/// <value>The current <see cref="IAttribute"/> element in the collection.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the collection or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The collection was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IEnumerator.Current"/> for details, but note
		/// that <b>Current</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		IAttribute Current { get; }

		#endregion
		#endregion
		#region Methods
		#region MoveNext

		/// <summary>
		/// Advances the enumerator to the next element of the collection.
		/// </summary>
		/// <returns><c>true</c> if the enumerator was successfully advanced to the next element;
		/// <c>false</c> if the enumerator has passed the end of the collection.</returns>
		/// <exception cref="InvalidOperationException">
		/// The collection was modified after the enumerator was created.</exception>
		/// <remarks>Please refer to <see cref="IEnumerator.MoveNext"/> for details.</remarks>

		bool MoveNext();

		#endregion
		#region Reset

		/// <summary>
		/// Sets the enumerator to its initial position,
		/// which is before the first element in the collection.
		/// </summary>
		/// <exception cref="InvalidOperationException">
		/// The collection was modified after the enumerator was created.</exception>
		/// <remarks>Please refer to <see cref="IEnumerator.Reset"/> for details.</remarks>

		void Reset();

		#endregion
		#endregion
	}

	#endregion
	#region Interface IIAttributeTypeCollection

	/// <summary>
	/// Defines size, enumerators, and synchronization methods for strongly
	/// typed collections of <see cref="IAttributeType"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IIAttributeTypeCollection</b> provides an <see cref="ICollection"/>
	/// that is strongly typed for <see cref="IAttributeType"/> elements.
	/// </remarks>

	public interface IIAttributeTypeCollection 
	{
		#region Properties
		#region Count

		/// <summary>
		/// Gets the number of elements contained in the
		/// <see cref="IIAttributeTypeCollection"/>.
		/// </summary>
		/// <value>The number of elements contained in the
		/// <see cref="IIAttributeTypeCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.Count"/> for details.</remarks>

		int Count { get; }

		#endregion
		#region IsSynchronized

		/// <summary>
		/// Gets a value indicating whether access to the
		/// <see cref="IIAttributeTypeCollection"/> is synchronized (thread-safe).
		/// </summary>
		/// <value><c>true</c> if access to the <see cref="IIAttributeTypeCollection"/> is
		/// synchronized (thread-safe); otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="ICollection.IsSynchronized"/> for details.</remarks>

		bool IsSynchronized { get; }

		#endregion
		#region SyncRoot

		/// <summary>
		/// Gets an object that can be used to synchronize access
		/// to the <see cref="IIAttributeTypeCollection"/>.
		/// </summary>
		/// <value>An object that can be used to synchronize access
		/// to the <see cref="IIAttributeTypeCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.SyncRoot"/> for details.</remarks>

		object SyncRoot { get; }

		#endregion
		#endregion
		#region Methods
		#region CopyTo

		/// <summary>
		/// Copies the entire <see cref="IIAttributeTypeCollection"/> to a one-dimensional <see cref="Array"/>
		/// of <see cref="IAttributeType"/> elements, starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the destination of the
		/// <see cref="IAttributeType"/> elements copied from the <see cref="IIAttributeTypeCollection"/>.
		/// The <b>Array</b> must have zero-based indexing.</param>
		/// <param name="arrayIndex">The zero-based index in <paramref name="array"/>
		/// at which copying begins.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="array"/> is a null reference.</exception>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <paramref name="arrayIndex"/> is less than zero.</exception>
		/// <exception cref="ArgumentException"><para>
		/// <paramref name="arrayIndex"/> is equal to or greater than the length of <paramref name="array"/>.
		/// </para><para>-or-</para><para>
		/// The number of elements in the source <see cref="IIAttributeTypeCollection"/> is greater
		/// than the available space from <paramref name="arrayIndex"/> to the end of the destination
		/// <paramref name="array"/>.</para></exception>
		/// <remarks>Please refer to <see cref="ICollection.CopyTo"/> for details.</remarks>

		void CopyTo(IAttributeType[] array, int arrayIndex);

		#endregion
		#region GetEnumerator

		/// <summary>
		/// Returns an <see cref="IIAttributeTypeEnumerator"/> that can
		/// iterate through the <see cref="IIAttributeTypeCollection"/>.
		/// </summary>
		/// <returns>An <see cref="IIAttributeTypeEnumerator"/>
		/// for the entire <see cref="IIAttributeTypeCollection"/>.</returns>
		/// <remarks>Please refer to <see cref="IEnumerable.GetEnumerator"/> for details.</remarks>

		IIAttributeTypeEnumerator GetEnumerator();

		#endregion
		#endregion
	}

	#endregion
	#region Interface IIAttributeTypeList

	/// <summary>
	/// Represents a strongly typed collection of <see cref="IAttributeType"/>
	/// objects that can be individually accessed by index.
	/// </summary>
	/// <remarks>
	/// <b>IIAttributeTypeList</b> provides an <see cref="IList"/>
	/// that is strongly typed for <see cref="IAttributeType"/> elements.
	/// </remarks>

	public interface
		IIAttributeTypeList: IIAttributeTypeCollection 
	{
		#region Properties
		#region IsFixedSize

		/// <summary>
		/// Gets a value indicating whether the <see cref="IIAttributeTypeList"/> has a fixed size.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IIAttributeTypeList"/> has a fixed size;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsFixedSize"/> for details.</remarks>

		bool IsFixedSize { get; }

		#endregion
		#region IsReadOnly

		/// <summary>
		/// Gets a value indicating whether the <see cref="IIAttributeTypeList"/> is read-only.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IIAttributeTypeList"/> is read-only;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsReadOnly"/> for details.</remarks>

		bool IsReadOnly { get; }

		#endregion
		#region Item

		/// <summary>
		/// Gets or sets the <see cref="IAttributeType"/> element at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index of the
		/// <see cref="IAttributeType"/> element to get or set.</param>
		/// <value>
		/// The <see cref="IAttributeType"/> element at the specified <paramref name="index"/>.
		/// </value>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IIAttributeTypeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// The property is set and the <see cref="IIAttributeTypeList"/> is read-only.</exception>
		/// <remarks>Please refer to <see cref="IList.this"/> for details.</remarks>

		IAttributeType this[int index] { get; set; }

		#endregion
		#endregion
		#region Methods
		#region Add

		/// <summary>
		/// Adds a <see cref="IAttributeType"/> to the end
		/// of the <see cref="IIAttributeTypeList"/>.
		/// </summary>
		/// <param name="value">The <see cref="IAttributeType"/> object
		/// to be added to the end of the <see cref="IIAttributeTypeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns>The <see cref="IIAttributeTypeList"/> index at which
		/// the <paramref name="value"/> has been added.</returns>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeTypeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Add"/> for details.</remarks>

		int Add(IAttributeType value);

		#endregion
		#region Clear

		/// <summary>
		/// Removes all elements from the <see cref="IIAttributeTypeList"/>.
		/// </summary>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeTypeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Clear"/> for details.</remarks>

		void Clear();

		#endregion
		#region Contains

		/// <summary>
		/// Determines whether the <see cref="IIAttributeTypeList"/>
		/// contains the specified <see cref="IAttributeType"/> element.
		/// </summary>
		/// <param name="value">The <see cref="IAttributeType"/> object
		/// to locate in the <see cref="IIAttributeTypeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns><c>true</c> if <paramref name="value"/> is found in the
		/// <see cref="IIAttributeTypeList"/>; otherwise, <c>false</c>.</returns>
		/// <remarks>Please refer to <see cref="IList.Contains"/> for details.</remarks>

		bool Contains(IAttributeType value);

		#endregion
		#region IndexOf

		/// <summary>
		/// Returns the zero-based index of the first occurrence of the specified
		/// <see cref="IAttributeType"/> in the <see cref="IIAttributeTypeList"/>.
		/// </summary>
		/// <param name="value">The <see cref="IAttributeType"/> object
		/// to locate in the <see cref="IIAttributeTypeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns>
		/// The zero-based index of the first occurrence of <paramref name="value"/>
		/// in the <see cref="IIAttributeTypeList"/>, if found; otherwise, -1.
		/// </returns>
		/// <remarks>Please refer to <see cref="IList.IndexOf"/> for details.</remarks>

		int IndexOf(IAttributeType value);

		#endregion
		#region Insert

		/// <summary>
		/// Inserts a <see cref="IAttributeType"/> element into the
		/// <see cref="IIAttributeTypeList"/> at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index at which
		/// <paramref name="value"/> should be inserted.</param>
		/// <param name="value">The <see cref="IAttributeType"/> object
		/// to insert into the <see cref="IIAttributeTypeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is greater than
		/// <see cref="IIAttributeTypeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeTypeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Insert"/> for details.</remarks>

		void Insert(int index, IAttributeType value);

		#endregion
		#region Remove

		/// <summary>
		/// Removes the first occurrence of the specified <see cref="IAttributeType"/>
		/// from the <see cref="IIAttributeTypeList"/>.
		/// </summary>
		/// <param name="value">The <see cref="IAttributeType"/> object
		/// to remove from the <see cref="IIAttributeTypeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeTypeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Remove"/> for details.</remarks>

		void Remove(IAttributeType value);

		#endregion
		#region RemoveAt

		/// <summary>
		/// Removes the element at the specified index of the
		/// <see cref="IIAttributeTypeList"/>.
		/// </summary>
		/// <param name="index">The zero-based index of the element to remove.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IIAttributeTypeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeTypeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.RemoveAt"/> for details.</remarks>

		void RemoveAt(int index);

		#endregion
		#endregion
	}

	#endregion
	#region Interface IIAttributeTypeEnumerator

	/// <summary>
	/// Supports type-safe iteration over a collection that
	/// contains <see cref="IAttributeType"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IIAttributeTypeEnumerator</b> provides an <see cref="IEnumerator"/>
	/// that is strongly typed for <see cref="IAttributeType"/> elements.
	/// </remarks>

	public interface IIAttributeTypeEnumerator 
	{
		#region Properties
		#region Current

		/// <summary>
		/// Gets the current <see cref="IAttributeType"/> element in the collection.
		/// </summary>
		/// <value>The current <see cref="IAttributeType"/> element in the collection.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the collection or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The collection was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IEnumerator.Current"/> for details, but note
		/// that <b>Current</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		IAttributeType Current { get; }

		#endregion
		#endregion
		#region Methods
		#region MoveNext

		/// <summary>
		/// Advances the enumerator to the next element of the collection.
		/// </summary>
		/// <returns><c>true</c> if the enumerator was successfully advanced to the next element;
		/// <c>false</c> if the enumerator has passed the end of the collection.</returns>
		/// <exception cref="InvalidOperationException">
		/// The collection was modified after the enumerator was created.</exception>
		/// <remarks>Please refer to <see cref="IEnumerator.MoveNext"/> for details.</remarks>

		bool MoveNext();

		#endregion
		#region Reset

		/// <summary>
		/// Sets the enumerator to its initial position,
		/// which is before the first element in the collection.
		/// </summary>
		/// <exception cref="InvalidOperationException">
		/// The collection was modified after the enumerator was created.</exception>
		/// <remarks>Please refer to <see cref="IEnumerator.Reset"/> for details.</remarks>

		void Reset();

		#endregion
		#endregion
	}

	#endregion
	#region Interface IIAttributeTypeIAttributeCollection

	/// <summary>
	/// Defines size, enumerators, and synchronization methods for strongly
	/// typed collections of <see cref="IAttributeTypeIAttributeEntry"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IIAttributeTypeIAttributeCollection</b> provides an <see cref="ICollection"/>
	/// that is strongly typed for <see cref="IAttributeTypeIAttributeEntry"/> elements.
	/// </remarks>

	public interface IIAttributeTypeIAttributeCollection 
	{
		#region Properties
		#region Count

		/// <summary>
		/// Gets the number of elements contained in the
		/// <see cref="IIAttributeTypeIAttributeCollection"/>.
		/// </summary>
		/// <value>The number of elements contained in the
		/// <see cref="IIAttributeTypeIAttributeCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.Count"/> for details.</remarks>

		int Count { get; }

		#endregion
		#region IsSynchronized

		/// <summary>
		/// Gets a value indicating whether access to the
		/// <see cref="IIAttributeTypeIAttributeCollection"/> is synchronized (thread-safe).
		/// </summary>
		/// <value><c>true</c> if access to the <see cref="IIAttributeTypeIAttributeCollection"/>
		/// is synchronized (thread-safe); otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="ICollection.IsSynchronized"/> for details.</remarks>

		bool IsSynchronized { get; }

		#endregion
		#region SyncRoot

		/// <summary>
		/// Gets an object that can be used to synchronize access
		/// to the <see cref="IIAttributeTypeIAttributeCollection"/>.
		/// </summary>
		/// <value>An object that can be used to synchronize access to the
		/// <see cref="IIAttributeTypeIAttributeCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.SyncRoot"/> for details.</remarks>

		object SyncRoot { get; }

		#endregion
		#endregion
		#region Methods
		#region CopyTo

		/// <summary>
		/// Copies the entire <see cref="IIAttributeTypeIAttributeCollection"/>
		/// to a one-dimensional <see cref="Array"/> of <see cref="IAttributeTypeIAttributeEntry"/> elements,
		/// starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the
		/// destination of the <see cref="IAttributeTypeIAttributeEntry"/> elements copied from the
		/// <see cref="IIAttributeTypeIAttributeCollection"/>.
		/// The <b>Array</b> must have zero-based indexing.</param>
		/// <param name="arrayIndex">The zero-based index in <paramref name="array"/>
		/// at which copying begins.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="array"/> is a null reference.</exception>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <paramref name="arrayIndex"/> is less than zero.</exception>
		/// <exception cref="ArgumentException"><para>
		/// <paramref name="arrayIndex"/> is equal to or greater than the length of <paramref name="array"/>.
		/// </para><para>-or-</para><para>
		/// The number of elements in the source <see cref="IIAttributeTypeIAttributeCollection"/>
		/// is greater than the available space from <paramref name="arrayIndex"/> to the end of the
		/// destination <paramref name="array"/>.</para></exception>
		/// <remarks>Please refer to <see cref="ICollection.CopyTo"/> for details.</remarks>

		void CopyTo(IAttributeTypeIAttributeEntry[] array, int arrayIndex);

		#endregion
		#region GetEnumerator

		/// <summary>
		/// Returns an <see cref="IIAttributeTypeIAttributeEnumerator"/> that can
		/// iterate through the <see cref="IIAttributeTypeIAttributeCollection"/>.
		/// </summary>
		/// <returns>An <see cref="IIAttributeTypeIAttributeEnumerator"/>
		/// for the entire <see cref="IIAttributeTypeIAttributeCollection"/>.</returns>
		/// <remarks>Please refer to <see cref="IEnumerable.GetEnumerator"/> for details.</remarks>

		IIAttributeTypeIAttributeEnumerator GetEnumerator();

		#endregion
		#endregion
	}

	#endregion
	#region Interface IIAttributeTypeIAttributeDictionary

	/// <summary>
	/// Represents a strongly typed collection of
	/// <see cref="IAttributeTypeIAttributeEntry"/> key-and-value pairs.
	/// </summary>
	/// <remarks>
	/// <b>IIAttributeTypeIAttributeDictionary</b> provides an
	/// <see cref="IDictionary"/> that is strongly typed for
	/// <see cref="IAttributeType"/> keys and <see cref="IAttribute"/> values.
	/// </remarks>

	public interface
		IIAttributeTypeIAttributeDictionary: IIAttributeTypeIAttributeCollection 
	{
		#region Properties
		#region IsFixedSize

		/// <summary>
		/// Gets a value indicating whether the
		/// <see cref="IIAttributeTypeIAttributeDictionary"/> has a fixed size.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IIAttributeTypeIAttributeDictionary"/>
		/// has a fixed size; otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IDictionary.IsFixedSize"/> for details.</remarks>

		bool IsFixedSize { get; }

		#endregion
		#region IsReadOnly

		/// <summary>
		/// Gets a value indicating whether the
		/// <see cref="IIAttributeTypeIAttributeDictionary"/> is read-only.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IIAttributeTypeIAttributeDictionary"/>
		/// is read-only; otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IDictionary.IsReadOnly"/> for details.</remarks>

		bool IsReadOnly { get; }

		#endregion
		#region Item

		/// <summary>
		/// Gets or sets the <see cref="IAttribute"/> value
		/// associated with the specified <see cref="IAttributeType"/> key.
		/// </summary>
		/// <param name="key">The <see cref="IAttributeType"/> key
		/// whose value to get or set.</param>
		/// <value>The <see cref="IAttribute"/> value associated with the specified
		/// <paramref name="key"/>. If the specified <paramref name="key"/> is not found,
		/// attempting to get it returns
		/// a null reference,
		/// and attempting to set it creates a new element using the specified
		/// <paramref name="key"/>.</value>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The property is set and the
		/// <see cref="IIAttributeTypeIAttributeDictionary"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The property is set, <paramref name="key"/> does not exist in the collection,
		/// and the <b>IIAttributeTypeIAttributeDictionary</b> has a fixed size.</para>
		/// </exception>
		/// <remarks>Please refer to <see cref="IDictionary.this"/> for details.</remarks>

		IAttribute this[IAttributeType key] { get; set; }

		#endregion
		#region Keys

		/// <summary>
		/// Gets an <see cref="IIAttributeTypeCollection"/> containing the keys
		/// in the <see cref="IIAttributeTypeIAttributeDictionary"/>.
		/// </summary>
		/// <value>An <see cref="IIAttributeTypeCollection"/> containing the keys
		/// in the <see cref="IIAttributeTypeIAttributeDictionary"/>.</value>
		/// <remarks>Please refer to <see cref="IDictionary.Keys"/> for details.</remarks>

		IIAttributeTypeCollection Keys { get; }

		#endregion
		#region Values

		/// <summary>
		/// Gets an <see cref="IIAttributeCollection"/> containing the values
		/// in the <see cref="IIAttributeTypeIAttributeDictionary"/>.
		/// </summary>
		/// <value>An <see cref="IIAttributeCollection"/> containing the values
		/// in the <see cref="IIAttributeTypeIAttributeDictionary"/>.</value>
		/// <remarks>Please refer to <see cref="IDictionary.Values"/> for details.</remarks>

		IIAttributeCollection Values { get; }

		#endregion
		#endregion
		#region Methods
		#region Add

		/// <summary>
		/// Adds an element with the specified <see cref="IAttributeType"/>
		/// key and <see cref="IAttribute"/> value to the
		/// <see cref="IIAttributeTypeIAttributeDictionary"/>.
		/// </summary>
		/// <param name="key">The <see cref="IAttributeType"/> key of the element
		/// to add to the <see cref="IIAttributeTypeIAttributeDictionary"/>.</param>
		/// <param name="value">The <see cref="IAttribute"/> value of the element
		/// to add to the <see cref="IIAttributeTypeIAttributeDictionary"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentException">
		/// <para>An element with the specified <paramref name="key"/> already exists
		/// in the <see cref="IIAttributeTypeIAttributeDictionary"/>.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeTypeIAttributeDictionary</b> is set to use the
		/// <see cref="IComparable"/> interface, and <paramref name="key"/> does not
		/// implement the <b>IComparable</b> interface.</para></exception>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidOperationException">
		/// The comparer throws an exception.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeIAttributeDictionary"/> is read-only.
		/// </para><para>-or-</para>
		/// <para>The <b>IIAttributeTypeIAttributeDictionary</b> has a fixed size.
		/// </para></exception>
		/// <remarks>Please refer to <see cref="IDictionary.Add"/> for details.</remarks>

		void Add(IAttributeType key, IAttribute value);

		#endregion
		#region Clear

		/// <summary>
		/// Removes all elements from the <see cref="IIAttributeTypeIAttributeDictionary"/>.
		/// </summary>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeIAttributeDictionary"/> is read-only.
		/// </para><para>-or-</para>
		/// <para>The <b>IIAttributeTypeIAttributeDictionary</b> has a fixed size.
		/// </para></exception>
		/// <remarks>Please refer to <see cref="IDictionary.Clear"/> for details.</remarks>

		void Clear();

		#endregion
		#region Contains

		/// <summary>
		/// Determines whether the <see cref="IIAttributeTypeIAttributeDictionary"/>
		/// contains the specified <see cref="IAttributeType"/> key.
		/// </summary>
		/// <param name="key">The <see cref="IAttributeType"/> key to locate
		/// in the <see cref="IIAttributeTypeIAttributeDictionary"/>.</param>
		/// <returns><c>true</c> if the <see cref="IIAttributeTypeIAttributeDictionary"/>
		/// contains an element with the specified <paramref name="key"/>; otherwise, <c>false</c>.
		/// </returns>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidOperationException">
		/// The comparer throws an exception.</exception>
		/// <remarks>Please refer to <see cref="IDictionary.Contains"/> for details.</remarks>

		bool Contains(IAttributeType key);

		#endregion
		#region Remove

		/// <summary>
		/// Removes the element with the specified <see cref="IAttributeType"/> key
		/// from the <see cref="IIAttributeTypeIAttributeDictionary"/>.
		/// </summary>
		/// <param name="key">The <see cref="IAttributeType"/> key of the element to remove
		/// from the <see cref="IIAttributeTypeIAttributeDictionary"/>.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidOperationException">
		/// The comparer throws an exception.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeIAttributeDictionary"/> is read-only.
		/// </para><para>-or-</para>
		/// <para>The <b>IIAttributeTypeIAttributeDictionary</b> has a fixed size.
		/// </para></exception>
		/// <remarks>Please refer to <see cref="IDictionary.Remove"/> for details.</remarks>

		void Remove(IAttributeType key);

		#endregion
		#endregion
	}

	#endregion
	#region Interface IIAttributeTypeIAttributeList

	/// <summary>
	/// Represents a strongly typed collection of <see cref="IAttributeTypeIAttributeEntry"/>
	/// objects that can be individually accessed by index.
	/// </summary>
	/// <remarks>
	/// <b>IIAttributeTypeIAttributeList</b> provides an <see cref="IList"/>
	/// that is strongly typed for <see cref="IAttributeTypeIAttributeEntry"/> elements.
	/// </remarks>

	public interface
		IIAttributeTypeIAttributeList: IIAttributeTypeIAttributeCollection 
	{
		#region Properties
		#region IsFixedSize

		/// <summary>
		/// Gets a value indicating whether the
		/// <see cref="IIAttributeTypeIAttributeList"/> has a fixed size.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IIAttributeTypeIAttributeList"/>
		/// has a fixed size; otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsFixedSize"/> for details.</remarks>

		bool IsFixedSize { get; }

		#endregion
		#region IsReadOnly

		/// <summary>
		/// Gets a value indicating whether the
		/// <see cref="IIAttributeTypeIAttributeList"/> is read-only.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IIAttributeTypeIAttributeList"/>
		/// is read-only; otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsReadOnly"/> for details.</remarks>

		bool IsReadOnly { get; }

		#endregion
		#region Item

		/// <summary>
		/// Gets or sets the <see cref="IAttributeTypeIAttributeEntry"/> element at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index of the
		/// <see cref="IAttributeTypeIAttributeEntry"/> element to get or set.</param>
		/// <value>
		/// The <see cref="IAttributeTypeIAttributeEntry"/> element at the specified <paramref name="index"/>.
		/// </value>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IIAttributeTypeIAttributeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">The property is set and the
		/// <see cref="IIAttributeTypeIAttributeList"/> is read-only.</exception>
		/// <remarks>Please refer to <see cref="IList.this"/> for details.</remarks>

		IAttributeTypeIAttributeEntry this[int index] { get; set; }

		#endregion
		#endregion
		#region Methods
		#region Add

		/// <summary>
		/// Adds a <see cref="IAttributeTypeIAttributeEntry"/> to the end
		/// of the <see cref="IIAttributeTypeIAttributeList"/>.
		/// </summary>
		/// <param name="entry">The <see cref="IAttributeTypeIAttributeEntry"/> object
		/// to be added to the end of the <see cref="IIAttributeTypeIAttributeList"/>.
		/// </param>
		/// <returns>The <see cref="IIAttributeTypeIAttributeList"/> index at which
		/// the <paramref name="entry"/> has been added.</returns>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeIAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeTypeIAttributeList</b> has a fixed size.</para>
		/// </exception>
		/// <remarks>Please refer to <see cref="IList.Add"/> for details.</remarks>

		int Add(IAttributeTypeIAttributeEntry entry);

		#endregion
		#region Clear

		/// <summary>
		/// Removes all elements from the <see cref="IIAttributeTypeIAttributeList"/>.
		/// </summary>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeIAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeTypeIAttributeList</b> has a fixed size.</para>
		/// </exception>
		/// <remarks>Please refer to <see cref="IList.Clear"/> for details.</remarks>

		void Clear();

		#endregion
		#region Contains

		/// <summary>
		/// Determines whether the <see cref="IIAttributeTypeIAttributeList"/>
		/// contains the specified <see cref="IAttributeTypeIAttributeEntry"/> element.
		/// </summary>
		/// <param name="entry">The <see cref="IAttributeTypeIAttributeEntry"/> object
		/// to locate in the <see cref="IIAttributeTypeIAttributeList"/>.</param>
		/// <returns><c>true</c> if <paramref name="entry"/> is found in the
		/// <see cref="IIAttributeTypeIAttributeList"/>; otherwise, <c>false</c>.</returns>
		/// <remarks>Please refer to <see cref="IList.Contains"/> for details.</remarks>

		bool Contains(IAttributeTypeIAttributeEntry entry);

		#endregion
		#region IndexOf

		/// <summary>
		/// Returns the zero-based index of the first occurrence of the specified
		/// <see cref="IAttributeTypeIAttributeEntry"/> in the <see cref="IIAttributeTypeIAttributeList"/>.
		/// </summary>
		/// <param name="entry">The <see cref="IAttributeTypeIAttributeEntry"/> object
		/// to locate in the <see cref="IIAttributeTypeIAttributeList"/>.</param>
		/// <returns>
		/// The zero-based index of the first occurrence of <paramref name="entry"/>
		/// in the <see cref="IIAttributeTypeIAttributeList"/>, if found; otherwise, -1.
		/// </returns>
		/// <remarks>Please refer to <see cref="IList.IndexOf"/> for details.</remarks>

		int IndexOf(IAttributeTypeIAttributeEntry entry);

		#endregion
		#region Insert

		/// <summary>
		/// Inserts a <see cref="IAttributeTypeIAttributeEntry"/> element into the
		/// <see cref="IIAttributeTypeIAttributeList"/> at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index at which
		/// <paramref name="entry"/> should be inserted.</param>
		/// <param name="entry">The <see cref="IAttributeTypeIAttributeEntry"/> object to insert
		/// into the <see cref="IIAttributeTypeIAttributeList"/>.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is greater than
		/// <see cref="IIAttributeTypeIAttributeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeIAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeTypeIAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Insert"/> for details.</remarks>

		void Insert(int index, IAttributeTypeIAttributeEntry entry);

		#endregion
		#region Remove

		/// <summary>
		/// Removes the first occurrence of the specified <see cref="IAttributeTypeIAttributeEntry"/>
		/// from the <see cref="IIAttributeTypeIAttributeList"/>.
		/// </summary>
		/// <param name="entry">The <see cref="IAttributeTypeIAttributeEntry"/> object to remove
		/// from the <see cref="IIAttributeTypeIAttributeList"/>.</param>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeIAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeTypeIAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Remove"/> for details.</remarks>

		void Remove(IAttributeTypeIAttributeEntry entry);

		#endregion
		#region RemoveAt

		/// <summary>
		/// Removes the element at the specified index of the
		/// <see cref="IIAttributeTypeIAttributeList"/>.
		/// </summary>
		/// <param name="index">The zero-based index of the element to remove.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IIAttributeTypeIAttributeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IIAttributeTypeIAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IIAttributeTypeIAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.RemoveAt"/> for details.</remarks>

		void RemoveAt(int index);

		#endregion
		#endregion
	}

	#endregion
	#region Interface IIAttributeTypeIAttributeEnumerator

	/// <summary>
	/// Supports type-safe iteration over a dictionary that
	/// contains <see cref="IAttributeTypeIAttributeEntry"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IIAttributeTypeIAttributeEnumerator</b> provides an
	/// <see cref="IDictionaryEnumerator"/> that is strongly typed for
	/// <see cref="IAttributeType"/> keys and <see cref="IAttribute"/> values.
	/// </remarks>

	public interface IIAttributeTypeIAttributeEnumerator 
	{
		#region Properties
		#region Current

		/// <summary>
		/// Gets the current <see cref="IAttributeTypeIAttributeEntry"/> element in the collection.
		/// </summary>
		/// <value>The current <see cref="IAttributeTypeIAttributeEntry"/> element in the collection.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the collection or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The collection was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IEnumerator.Current"/> for details, but note
		/// that <b>Current</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		IAttributeTypeIAttributeEntry Current { get; }

		#endregion
		#region Entry

		/// <summary>
		/// Gets a <see cref="IAttributeTypeIAttributeEntry"/> containing both
		/// the key and the value of the current dictionary entry.
		/// </summary>
		/// <value>A <see cref="IAttributeTypeIAttributeEntry"/> containing both
		/// the key and the value of the current dictionary entry.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the dictionary or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The dictionary was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IDictionaryEnumerator.Entry"/> for details, but
		/// note that <b>Entry</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		IAttributeTypeIAttributeEntry Entry { get; }

		#endregion
		#region Key

		/// <summary>
		/// Gets the <see cref="IAttributeType"/> key of the current dictionary entry.
		/// </summary>
		/// <value>The <see cref="IAttributeType"/> key
		/// of the current element of the enumeration.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the dictionary or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The dictionary was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IDictionaryEnumerator.Key"/> for details, but
		/// note that <b>Key</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		IAttributeType Key { get; }

		#endregion
		#region Value

		/// <summary>
		/// Gets the <see cref="IAttribute"/> value of the current dictionary entry.
		/// </summary>
		/// <value>The <see cref="IAttribute"/> value
		/// of the current element of the enumeration.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the dictionary or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The dictionary was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IDictionaryEnumerator.Value"/> for details, but
		/// note that <b>Value</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		IAttribute Value { get; }

		#endregion
		#endregion
		#region Methods
		#region MoveNext

		/// <summary>
		/// Advances the enumerator to the next element of the collection.
		/// </summary>
		/// <returns><c>true</c> if the enumerator was successfully advanced to the next element;
		/// <c>false</c> if the enumerator has passed the end of the collection.</returns>
		/// <exception cref="InvalidOperationException">
		/// The collection was modified after the enumerator was created.</exception>
		/// <remarks>Please refer to <see cref="IEnumerator.MoveNext"/> for details.</remarks>

		bool MoveNext();

		#endregion
		#region Reset

		/// <summary>
		/// Sets the enumerator to its initial position,
		/// which is before the first element in the collection.
		/// </summary>
		/// <exception cref="InvalidOperationException">
		/// The collection was modified after the enumerator was created.</exception>
		/// <remarks>Please refer to <see cref="IEnumerator.Reset"/> for details.</remarks>

		void Reset();

		#endregion
		#endregion
	}

	#endregion
	#region Struct IAttributeTypeIAttributeEntry

	/// <summary>
	/// Implements a strongly typed pair of one <see cref="IAttributeType"/>
	/// key and one <see cref="IAttribute"/> value.
	/// </summary>
	/// <remarks>
	/// <b>IAttributeTypeIAttributeEntry</b> provides a <see cref="DictionaryEntry"/> that is strongly
	/// typed for <see cref="IAttributeType"/> keys and <see cref="IAttribute"/> values.
	/// </remarks>

	[Serializable]
	public struct IAttributeTypeIAttributeEntry 
	{
		#region Private Fields

		private IAttributeType _key;
		private IAttribute _value;

		#endregion
		#region Public Constructors

		/// <summary>
		/// Initializes a new instance of the <see cref="IAttributeTypeIAttributeEntry"/>
		/// class with the specified key and value.
		/// </summary>
		/// <param name="key">
		/// The <see cref="IAttributeType"/> key in the key-and-value pair.</param>
		/// <param name="value">
		/// The <see cref="IAttribute"/> value in the key-and-value pair.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>

		public IAttributeTypeIAttributeEntry(IAttributeType key, IAttribute value) 
		{
			if ((object) key == null)
				throw new ArgumentNullException("key");

			this._key = key;
			this._value = value;
		}

		#endregion
		#region Public Properties
		#region Key

		/// <summary>
		/// Gets or sets the <see cref="IAttributeType"/> key in the key-and-value pair.
		/// </summary>
		/// <value>
		/// The <see cref="IAttributeType"/> key in the key-and-value pair.
		/// The default is a null reference.
		/// </value>
		/// <exception cref="ArgumentNullException">
		/// <b>Key</b> is set to a null reference.</exception>
		/// <remarks>
		/// <see cref="IAttributeTypeIAttributeEntry"/> is a value type and therefore has an implicit default
		/// constructor that zeroes all data members. This means that the <b>Key</b> property of
		/// a default-constructed <b>IAttributeTypeIAttributeEntry</b> contains a null reference by default,
		/// even though it is not possible to explicitly set <b>Key</b> to a null reference.
		/// </remarks>

		public IAttributeType Key 
		{
			get { return this._key; }
			set 
			{
				if ((object) value == null)
					throw new ArgumentNullException("value");
				this._key = value;
			}
		}

		#endregion
		#region Value

		/// <summary>
		/// Gets or sets the <see cref="IAttribute"/> value in the key-and-value pair.
		/// </summary>
		/// <value>
		/// The <see cref="IAttribute"/> value in the key-and-value pair.
		/// This value can be a null reference, which is also the default.
		/// </value>

		public IAttribute Value 
		{
			get { return this._value; }
			set { this._value = value; }
		}

		#endregion
		#endregion
		#region Public Operators
		#region IAttributeTypeIAttributeEntry(DictionaryEntry)

		/// <summary>
		/// Converts a <see cref="DictionaryEntry"/> to a <see cref="IAttributeTypeIAttributeEntry"/>.
		/// </summary>
		/// <param name="entry">A <see cref="DictionaryEntry"/> object to convert.</param>
		/// <returns>A <see cref="IAttributeTypeIAttributeEntry"/> object that represents
		/// the converted <paramref name="entry"/>.</returns>
		/// <exception cref="InvalidCastException">
		/// <para><paramref name="entry"/> contains a key that is not compatible
		/// with <see cref="IAttributeType"/>.</para>
		/// <para>-or-</para>
		/// <para><paramref name="entry"/> contains a value that is not compatible
		/// with <see cref="IAttribute"/>.</para>
		/// </exception>

		public static implicit operator IAttributeTypeIAttributeEntry(DictionaryEntry entry) 
		{
			IAttributeTypeIAttributeEntry pair = new IAttributeTypeIAttributeEntry();
			if (entry.Key != null) pair.Key = (IAttributeType) entry.Key;
			if (entry.Value != null) pair.Value = (IAttribute) entry.Value;
			return pair;
		}

		#endregion
		#region DictionaryEntry(IAttributeTypeIAttributeEntry)

		/// <summary>
		/// Converts a <see cref="IAttributeTypeIAttributeEntry"/> to a <see cref="DictionaryEntry"/>.
		/// </summary>
		/// <param name="pair">A <see cref="IAttributeTypeIAttributeEntry"/> object to convert.</param>
		/// <returns>A <see cref="DictionaryEntry"/> object that
		/// represents the converted <paramref name="pair"/>.</returns>

		public static implicit operator DictionaryEntry(IAttributeTypeIAttributeEntry pair) 
		{
			DictionaryEntry entry = new DictionaryEntry();
			if (pair.Key != null) entry.Key = pair.Key;
			entry.Value = pair.Value;
			return entry;
		}

		#endregion
		#endregion
	}

	#endregion
	#region Class AttributeHash

	/// <summary>
	/// Implements a strongly typed collection of <see cref="IAttributeTypeIAttributeEntry"/>
	/// key-and-value pairs that are organized based on the hash code of the key.
	/// </summary>
	/// <remarks>
	/// <b>AttributeHash</b> provides a <see cref="Hashtable"/> that is strongly typed
	/// for <see cref="IAttributeType"/> keys and <see cref="IAttribute"/> values.
	/// </remarks>

	[Serializable]
	public class AttributeHash:
		IIAttributeTypeIAttributeDictionary, IDictionary, ICloneable
	{
		#region Private Fields

		private Hashtable _innerHash;
		private KeyList _keyList;
		private ValueList _valueList;

		#endregion
		#region Private Constructors

		// helper type to identify private ctor
		private enum Tag { Default }

		private AttributeHash(Tag tag) { }

		#endregion
		#region Public Constructors
		#region AttributeHash()

		/// <overloads>
		/// Initializes a new instance of the <see cref="AttributeHash"/> class.
		/// </overloads>
		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHash"/> class
		/// that is empty and has the default initial capacity, the default load factor,
		/// the default hash code provider and the default comparer.
		/// </summary>
		/// <remarks>Please refer to <see cref="Hashtable()"/> for details.</remarks>

		public AttributeHash() 
		{
			this._innerHash = new Hashtable();
		}

		#endregion
		#region AttributeHash(IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHash"/> class
		/// that is empty and has the default initial capacity, the default load factor,
		/// the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="AttributeHash"/>.</para>
		/// <para>-or-</para>
		/// <para>A null reference to use the default hash code provider, which is each key's
		/// implementation of <see cref="Object.GetHashCode"/>.</para></param>
		/// <param name="comparer">
		/// <para>The <see cref="IComparer"/> to use to determine whether two keys are equal.</para>
		/// <para>-or-</para>
		/// <para>A null reference to use the default comparer, which is each key's
		/// implementation of <see cref="Object.Equals"/>.</para></param>
		/// <remarks>
		/// Please refer to <see cref="Hashtable(IHashCodeProvider, IComparer)"/> for details.
		/// </remarks>

		public AttributeHash(IHashCodeProvider provider, IComparer comparer) 
		{
			this._innerHash = new Hashtable(provider, comparer);
		}

		#endregion
		#region AttributeHash(Int32)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHash"/> class
		/// that is empty and has the specified initial capacity, the default load factor,
		/// the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="capacity">The approximate number of elements that the new
		/// <see cref="AttributeHash"/> is initially capable of storing.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <paramref name="capacity"/> is less than zero.</exception>
		/// <remarks>Please refer to <see cref="Hashtable(Int32)"/> for details.</remarks>

		public AttributeHash(int capacity) 
		{
			this._innerHash = new Hashtable(capacity);
		}

		#endregion
		#region AttributeHash(Int32, IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHash"/> class
		/// that is empty and has the specified initial capacity, the default load factor,
		/// the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="capacity">The approximate number of elements that the new
		/// <see cref="AttributeHash"/> is initially capable of storing.</param>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="AttributeHash"/>.</para>
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
		/// Please refer to <see cref="Hashtable(Int32, IHashCodeProvider, IComparer)"/> for details.
		/// </remarks>

		public AttributeHash(int capacity,
			IHashCodeProvider provider, IComparer comparer) 
		{

			this._innerHash = new Hashtable(capacity, provider, comparer);
		}

		#endregion
		#region AttributeHash(Int32, Single)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHash"/> class
		/// that is empty and has the specified initial capacity, the specified load factor,
		/// the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="capacity">The approximate number of elements that the new
		/// <see cref="AttributeHash"/> is initially capable of storing.</param>
		/// <param name="loadFactor">A number in the range from 0.1 through 1.0
		/// indicating the maximum ratio of elements to buckets.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="capacity"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="loadFactor"/> is less than 0.1.</para>
		/// <para>-or-</para>
		/// <para><paramref name="loadFactor"/> is greater than 1.0.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable(Int32, Single)"/> for details.</remarks>

		public AttributeHash(int capacity, float loadFactor) 
		{
			this._innerHash = new Hashtable(capacity, loadFactor);
		}

		#endregion
		#region AttributeHash(Int32, Single, IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHash"/> class
		/// that is empty and has the specified initial capacity, the specified load factor,
		/// the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="capacity">The approximate number of elements that the new
		/// <see cref="AttributeHash"/> is initially capable of storing.</param>
		/// <param name="loadFactor">A number in the range from 0.1 through 1.0
		/// indicating the maximum ratio of elements to buckets.</param>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="AttributeHash"/>.</para>
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
		/// Please refer to <see cref="Hashtable(Int32, Single, IHashCodeProvider, IComparer)"/>
		/// for details.</remarks>

		public AttributeHash(int capacity, float loadFactor,
			IHashCodeProvider provider, IComparer comparer) 
		{

			this._innerHash = new Hashtable(capacity, loadFactor, provider, comparer);
		}

		#endregion
		#region AttributeHash(AttributeHash)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHash"/> class
		/// that contains elements copied from the specified dictionary and
		/// that has the same initial capacity as the number of elements copied, the
		/// default load factor, the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="dictionary">The <see cref="AttributeHash"/>
		/// whose elements are copied to the new collection.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="dictionary"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Hashtable(IDictionary)"/> for details.</remarks>

		public AttributeHash(AttributeHash dictionary) 
		{
			if (dictionary == null)
				throw new ArgumentNullException("dictionary");

			this._innerHash = new Hashtable(dictionary._innerHash);
		}

		#endregion
		#region AttributeHash(IDictionary)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHash"/> class
		/// that contains elements copied from the specified <see cref="IDictionary"/>
		/// and that has the same initial capacity as the number of elements copied, the
		/// default load factor, the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="dictionary">The <see cref="IDictionary"/>
		/// whose elements are copied to the new collection.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="dictionary"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Hashtable(IDictionary)"/> for details.</remarks>

		public AttributeHash(IDictionary dictionary) 
		{
			this._innerHash = new Hashtable(dictionary);
		}

		#endregion
		#region AttributeHash(IDictionary, IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHash"/> class
		/// that contains elements copied from the specified <see cref="IDictionary"/>
		/// and that has the same initial capacity as the number of elements copied, the
		/// default load factor, the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="dictionary">The <see cref="IDictionary"/>
		/// whose elements are copied to the new collection.</param>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="AttributeHash"/>.</para>
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
		/// Please refer to <see cref="Hashtable(IDictionary, IHashCodeProvider, IComparer)"/>
		/// for details.</remarks>

		public AttributeHash(IDictionary dictionary,
			IHashCodeProvider provider, IComparer comparer) 
		{

			this._innerHash = new Hashtable(dictionary, provider, comparer);
		}

		#endregion
		#region AttributeHash(IDictionary, Single)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHash"/> class
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
		/// Please refer to <see cref="Hashtable(IDictionary, Single)"/> for details.
		/// </remarks>

		public AttributeHash(IDictionary dictionary, float loadFactor) 
		{
			this._innerHash = new Hashtable(dictionary, loadFactor);
		}

		#endregion
		#region AttributeHash(IDictionary, Single, IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHash"/> class
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
		/// for all keys in the <see cref="AttributeHash"/>.</para>
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
		/// Please refer to <see cref="Hashtable(IDictionary, Single, IHashCodeProvider, IComparer)"/>
		/// for details.</remarks>

		public AttributeHash(IDictionary dictionary,
			float loadFactor, IHashCodeProvider provider, IComparer comparer) 
		{

			this._innerHash = new Hashtable(dictionary, loadFactor, provider, comparer);
		}

		#endregion
		#endregion
		#region Public Properties
		#region Count

		/// <summary>
		/// Gets the number of key-and-value pairs contained in the <see cref="AttributeHash"/>.
		/// </summary>
		/// <value>
		/// The number of key-and-value pairs contained in the <see cref="AttributeHash"/>.
		/// </value>
		/// <remarks>Please refer to <see cref="Hashtable.Count"/> for details.</remarks>

		public int Count 
		{
			get { return this._innerHash.Count; }
		}

		#endregion
		#region IsFixedSize

		/// <summary>
		/// Gets a value indicating whether the <see cref="AttributeHash"/> has a fixed size.
		/// </summary>
		/// <value><c>true</c> if the <see cref="AttributeHash"/> has a fixed size;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.IsFixedSize"/> for details.</remarks>

		public bool IsFixedSize 
		{
			get { return this._innerHash.IsFixedSize; }
		}

		#endregion
		#region IsReadOnly

		/// <summary>
		/// Gets a value indicating whether the <see cref="AttributeHash"/> is read-only.
		/// </summary>
		/// <value><c>true</c> if the <see cref="AttributeHash"/> is read-only;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.IsReadOnly"/> for details.</remarks>

		public bool IsReadOnly 
		{
			get { return this._innerHash.IsReadOnly; }
		}

		#endregion
		#region IsSynchronized

		/// <summary>
		/// Gets a value indicating whether access to the <see cref="AttributeHash"/>
		/// is synchronized (thread-safe).
		/// </summary>
		/// <value><c>true</c> if access to the <see cref="AttributeHash"/> is
		/// synchronized (thread-safe); otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.IsSynchronized"/> for details.</remarks>

		public bool IsSynchronized 
		{
			get { return this._innerHash.IsSynchronized; }
		}

		#endregion
		#region Item[IAttributeType]: IAttribute

		/// <summary>
		/// Gets or sets the <see cref="IAttribute"/> value
		/// associated with the specified <see cref="IAttributeType"/> key.
		/// </summary>
		/// <param name="key">The <see cref="IAttributeType"/> key
		/// whose value to get or set.</param>
		/// <value>The <see cref="IAttribute"/> value associated with the specified
		/// <paramref name="key"/>. If the specified <paramref name="key"/> is not found,
		/// attempting to get it returns
		/// a null reference,
		/// and attempting to set it creates a new element using the specified
		/// <paramref name="key"/>.</value>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The property is set and the <see cref="AttributeHash"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The property is set, <paramref name="key"/> does not exist in the collection,
		/// and the <b>AttributeHash</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.this"/> for details.</remarks>

		public IAttribute this[IAttributeType key] 
		{
			get 
			{
				return (IAttribute) this._innerHash[key];
			}
			set { this._innerHash[key] = value; }
		}

		#endregion
		#region IDictionary.Item[Object]: Object

		/// <summary>
		/// Gets or sets the value associated with the specified key.
		/// </summary>
		/// <param name="key">The key whose value to get or set.
		/// This argument must be compatible with <see cref="IAttributeType"/>.</param>
		/// <value>
		/// The value associated with the specified <paramref name="key"/>. If the specified
		/// <paramref name="key"/> is not found, attempting to get it returns
		/// a null reference,
		/// and attempting to set it creates a new element using the specified <paramref name="key"/>.
		/// When set, this value must be compatible with <see cref="IAttribute"/>.
		/// </value>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidCastException">
		/// <para><paramref name="key"/> is not compatible with <see cref="IAttributeType"/>.</para>
		/// <para>-or-</para>
		/// <para>The property is set to a value that is not compatible with
		/// <see cref="IAttribute"/>.</para></exception>
		/// <exception cref="NotSupportedException">
		/// <para>The property is set and the <see cref="AttributeHash"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The property is set, <paramref name="key"/> does not exist in the collection,
		/// and the <b>AttributeHash</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.this"/> for details.</remarks>

		object IDictionary.this[object key] 
		{
			get { return this[(IAttributeType) key]; }
			set { this[(IAttributeType) key] = (IAttribute) value; }
		}

		#endregion
		#region Keys: IIAttributeTypeCollection

		/// <summary>
		/// Gets an <see cref="IIAttributeTypeCollection"/> containing
		/// the keys in the <see cref="AttributeHash"/>.
		/// </summary>
		/// <value>An <see cref="IIAttributeTypeCollection"/> containing
		/// the keys in the <see cref="AttributeHash"/>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.Keys"/> for details.</remarks>

		public IIAttributeTypeCollection Keys 
		{
			get 
			{
				if (this._keyList == null)
					this._keyList = new KeyList(this);
				return this._keyList;
			}
		}

		#endregion
		#region IDictionary.Keys: ICollection

		/// <summary>
		/// Gets an <see cref="ICollection"/> containing
		/// the keys in the <see cref="AttributeHash"/>.
		/// </summary>
		/// <value>An <see cref="ICollection"/> containing
		/// the keys in the <see cref="AttributeHash"/>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.Keys"/> for details.</remarks>

		ICollection IDictionary.Keys 
		{
			get { return (ICollection) Keys; }
		}

		#endregion
		#region SyncRoot

		/// <summary>
		/// Gets an object that can be used to synchronize
		/// access to the <see cref="AttributeHash"/>.
		/// </summary>
		/// <value>An object that can be used to synchronize
		/// access to the <see cref="AttributeHash"/>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.SyncRoot"/> for details.</remarks>

		public object SyncRoot 
		{
			get { return this._innerHash.SyncRoot; }
		}

		#endregion
		#region Values: IIAttributeCollection

		/// <summary>
		/// Gets an <see cref="IIAttributeCollection"/> containing
		/// the values in the <see cref="AttributeHash"/>.
		/// </summary>
		/// <value>An <see cref="IIAttributeCollection"/> containing
		/// the values in the <see cref="AttributeHash"/>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.Values"/> for details.</remarks>

		public virtual IIAttributeCollection Values 
		{
			get 
			{
				if (this._valueList == null)
					this._valueList = new ValueList(this);
				return this._valueList;
			}
		}

		#endregion
		#region IDictionary.Values: ICollection

		/// <summary>
		/// Gets an <see cref="ICollection"/> containing
		/// the values in the <see cref="AttributeHash"/>.
		/// </summary>
		/// <value>An <see cref="ICollection"/> containing
		/// the values in the <see cref="AttributeHash"/>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.Values"/> for details.</remarks>

		ICollection IDictionary.Values 
		{
			get { return (ICollection) Values; }
		}

		#endregion
		#endregion
		#region Public Methods
		#region Add(IAttributeType, IAttribute)

		/// <summary>
		/// Adds an element with the specified <see cref="IAttributeType"/> key and
		/// <see cref="IAttribute"/> value to the <see cref="AttributeHash"/>.
		/// </summary>
		/// <param name="key">The <see cref="IAttributeType"/> key of the element
		/// to add to the <see cref="AttributeHash"/>.</param>
		/// <param name="value">The <see cref="IAttribute"/> value of the element
		/// to add to the <see cref="AttributeHash"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentException">
		/// An element with the specified <paramref name="key"/>
		/// already exists in the <see cref="AttributeHash"/>.</exception>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="AttributeHash"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>AttributeHash</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.Add"/> for details.</remarks>

		public void Add(IAttributeType key, IAttribute value) 
		{
			this._innerHash.Add(key, value);
		}

		#endregion
		#region IDictionary.Add(Object, Object)

		/// <summary>
		/// Adds an element with the specified key and value
		/// to the <see cref="AttributeHash"/>.
		/// </summary>
		/// <param name="key">The key of the element to add to the <see cref="AttributeHash"/>.
		/// This argument must be compatible with <see cref="IAttributeType"/>.</param>
		/// <param name="value">The value of the element to add to the <see cref="AttributeHash"/>.
		/// This argument must be compatible with <see cref="IAttribute"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentException">
		/// An element with the specified <paramref name="key"/>
		/// already exists in the <see cref="AttributeHash"/>.</exception>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidCastException">
		/// <para><paramref name="key"/> is not compatible with <see cref="IAttributeType"/>.</para>
		/// <para>-or-</para>
		/// <para><paramref name="value"/> is not compatible with <see cref="IAttribute"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="AttributeHash"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>AttributeHash</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.Add"/> for details.</remarks>

		void IDictionary.Add(object key, object value) 
		{
			Add((IAttributeType) key, (IAttribute) value);
		}

		#endregion
		#region Clear

		/// <summary>
		/// Removes all elements from the <see cref="AttributeHash"/>.
		/// </summary>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="AttributeHash"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>AttributeHash</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.Clear"/> for details.</remarks>

		public void Clear() 
		{
			this._innerHash.Clear();
		}

		#endregion
		#region Clone

		/// <summary>
		/// Creates a shallow copy of the <see cref="AttributeHash"/>.
		/// </summary>
		/// <returns>A shallow copy of the <see cref="AttributeHash"/>.</returns>
		/// <remarks>Please refer to <see cref="Hashtable.Clone"/> for details.</remarks>

		public object Clone() 
		{
			AttributeHash dictionary = new AttributeHash(Tag.Default);
			dictionary._innerHash = (Hashtable) this._innerHash.Clone();
			return dictionary;
		}

		#endregion
		#region Contains(IAttributeType)

		/// <summary>
		/// Determines whether the <see cref="AttributeHash"/>
		/// contains the specified <see cref="IAttributeType"/> key.
		/// </summary>
		/// <param name="key">The <see cref="IAttributeType"/> key
		/// to locate in the <see cref="AttributeHash"/>.</param>
		/// <returns><c>true</c> if the <see cref="AttributeHash"/> contains an element
		/// with the specified <paramref name="key"/>; otherwise, <c>false</c>.</returns>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Hashtable.Contains"/> for details.</remarks>

		public bool Contains(IAttributeType key) 
		{
			return this._innerHash.Contains(key);
		}

		#endregion
		#region IDictionary.Contains(Object)

		/// <summary>
		/// Determines whether the <see cref="AttributeHash"/> contains the specified key.
		/// </summary>
		/// <param name="key">The key to locate in the <see cref="AttributeHash"/>.
		/// This argument must be compatible with <see cref="IAttributeType"/>.</param>
		/// <returns><c>true</c> if the <see cref="AttributeHash"/> contains an element
		/// with the specified <paramref name="key"/>; otherwise, <c>false</c>.</returns>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidCastException"><paramref name="key"/>
		/// is not compatible with <see cref="IAttributeType"/>.</exception>
		/// <remarks>Please refer to <see cref="Hashtable.Contains"/> for details.</remarks>

		bool IDictionary.Contains(object key) 
		{
			return Contains((IAttributeType) key);
		}

		#endregion
		#region ContainsKey

		/// <summary>
		/// Determines whether the <see cref="AttributeHash"/>
		/// contains the specified <see cref="IAttributeType"/> key.
		/// </summary>
		/// <param name="key">The <see cref="IAttributeType"/> key
		/// to locate in the <see cref="AttributeHash"/>.</param>
		/// <returns><c>true</c> if the <see cref="AttributeHash"/> contains an element
		/// with the specified <paramref name="key"/>; otherwise, <c>false</c>.</returns>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Hashtable.ContainsKey"/> for details.</remarks>

		public bool ContainsKey(IAttributeType key) 
		{
			return this._innerHash.ContainsKey(key);
		}

		#endregion
		#region ContainsValue

		/// <summary>
		/// Determines whether the <see cref="AttributeHash"/>
		/// contains the specified <see cref="IAttribute"/> value.
		/// </summary>
		/// <param name="value">The <see cref="IAttribute"/> value
		/// to locate in the <see cref="AttributeHash"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns><c>true</c> if the <see cref="AttributeHash"/> contains an element
		/// with the specified <paramref name="value"/>; otherwise, <c>false</c>.</returns>
		/// <remarks>Please refer to <see cref="Hashtable.ContainsValue"/> for details.</remarks>

		public bool ContainsValue(IAttribute value) 
		{
			return this._innerHash.ContainsValue(value);
		}

		#endregion
		#region CopyTo(IAttributeTypeIAttributeEntry[], Int32)

		/// <summary>
		/// Copies the entire <see cref="AttributeHash"/> to a one-dimensional <see cref="Array"/> of
		/// <see cref="IAttributeTypeIAttributeEntry"/> elements, starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the destination of the
		/// <see cref="IAttributeTypeIAttributeEntry"/> elements copied from the <see cref="AttributeHash"/>.
		/// The <b>Array</b> must have zero-based indexing.</param>
		/// <param name="arrayIndex">The zero-based index in <paramref name="array"/>
		/// at which copying begins.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="array"/> is a null reference.</exception>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <paramref name="arrayIndex"/> is less than zero.</exception>
		/// <exception cref="ArgumentException"><para>
		/// <paramref name="arrayIndex"/> is equal to or greater than the length of <paramref name="array"/>.
		/// </para><para>-or-</para><para>
		/// The number of elements in the source <see cref="AttributeHash"/> is greater than
		/// the available space from <paramref name="arrayIndex"/> to the end of the destination
		/// <paramref name="array"/>.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.CopyTo"/> for details.</remarks>

		public void CopyTo(IAttributeTypeIAttributeEntry[] array, int arrayIndex) 
		{
			this._innerHash.CopyTo(array, arrayIndex);
		}

		#endregion
		#region ICollection.CopyTo(Array, Int32)

		/// <summary>
		/// Copies the entire <see cref="AttributeHash"/> to a one-dimensional <see cref="Array"/>,
		/// starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the destination of the
		/// <see cref="IAttributeTypeIAttributeEntry"/> elements copied from the <see cref="AttributeHash"/>.
		/// The <b>Array</b> must have zero-based indexing.</param>
		/// <param name="arrayIndex">The zero-based index in <paramref name="array"/>
		/// at which copying begins.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="array"/> is a null reference.</exception>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <paramref name="arrayIndex"/> is less than zero.</exception>
		/// <exception cref="ArgumentException"><para>
		/// <paramref name="array"/> is multidimensional.
		/// </para><para>-or-</para><para>
		/// <paramref name="arrayIndex"/> is equal to or greater than the length of <paramref name="array"/>.
		/// </para><para>-or-</para><para>
		/// The number of elements in the source <see cref="AttributeHash"/> is greater than
		/// the available space from <paramref name="arrayIndex"/> to the end of the destination
		/// <paramref name="array"/>.</para></exception>
		/// <exception cref="InvalidCastException">
		/// The <see cref="IAttributeTypeIAttributeEntry"/> type cannot be cast automatically
		/// to the type of the destination <paramref name="array"/>.</exception>
		/// <remarks>Please refer to <see cref="Hashtable.CopyTo"/> for details.</remarks>

		void ICollection.CopyTo(Array array, int arrayIndex) 
		{
			CheckTargetArray(array, arrayIndex);
			CopyTo((IAttributeTypeIAttributeEntry[]) array, arrayIndex);
		}

		#endregion
		#region GetEnumerator: IIAttributeTypeIAttributeEnumerator

		/// <summary>
		/// Returns an <see cref="IIAttributeTypeIAttributeEnumerator"/>
		/// that can iterate through the <see cref="AttributeHash"/>.
		/// </summary>
		/// <returns>An <see cref="IIAttributeTypeIAttributeEnumerator"/>
		/// for the entire <see cref="AttributeHash"/>.</returns>
		/// <remarks>Please refer to <see cref="Hashtable.GetEnumerator"/> for details.</remarks>

		public IIAttributeTypeIAttributeEnumerator GetEnumerator() 
		{
			return new Enumerator(this);
		}

		#endregion
		#region IDictionary.GetEnumerator: IDictionaryEnumerator

		/// <summary>
		/// Returns an <see cref="IDictionaryEnumerator"/> that can
		/// iterate through the <see cref="AttributeHash"/>.
		/// </summary>
		/// <returns>An <see cref="IDictionaryEnumerator"/>
		/// for the entire <see cref="AttributeHash"/>.</returns>
		/// <remarks>Please refer to <see cref="Hashtable.GetEnumerator"/> for details.</remarks>

		IDictionaryEnumerator IDictionary.GetEnumerator() 
		{
			return (IDictionaryEnumerator) GetEnumerator();
		}

		#endregion
		#region IEnumerable.GetEnumerator: IEnumerator

		/// <summary>
		/// Returns an <see cref="IEnumerator"/> that can
		/// iterate through the <see cref="AttributeHash"/>.
		/// </summary>
		/// <returns>An <see cref="IEnumerator"/>
		/// for the entire <see cref="AttributeHash"/>.</returns>
		/// <remarks>Please refer to <see cref="Hashtable.GetEnumerator"/> for details.</remarks>

		IEnumerator IEnumerable.GetEnumerator() 
		{
			return (IEnumerator) GetEnumerator();
		}

		#endregion
		#region Remove(IAttributeType)

		/// <summary>
		/// Removes the element with the specified <see cref="IAttributeType"/> key
		/// from the <see cref="AttributeHash"/>.
		/// </summary>
		/// <param name="key">The <see cref="IAttributeType"/> key of the element
		/// to remove from the <see cref="AttributeHash"/>.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="AttributeHash"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>AttributeHash</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.Remove"/> for details.</remarks>

		public void Remove(IAttributeType key) 
		{
			this._innerHash.Remove(key);
		}

		#endregion
		#region IDictionary.Remove(Object)

		/// <summary>
		/// Removes the element with the specified key
		/// from the <see cref="AttributeHash"/>.
		/// </summary>
		/// <param name="key">The key of the element to remove from the <see cref="AttributeHash"/>.
		/// This argument must be compatible with <see cref="IAttributeType"/>.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidCastException"><paramref name="key"/>
		/// is not compatible with <see cref="IAttributeType"/>.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="AttributeHash"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>AttributeHash</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.Remove"/> for details.</remarks>

		void IDictionary.Remove(object key) 
		{
			Remove((IAttributeType) key);
		}

		#endregion
		#region Synchronized

		/// <summary>
		/// Returns a synchronized (thread-safe) wrapper
		/// for the specified <see cref="AttributeHash"/>.
		/// </summary>
		/// <param name="dictionary">The <see cref="AttributeHash"/> to synchronize.</param>
		/// <returns>A synchronized (thread-safe) wrapper around <paramref name="dictionary"/>.</returns>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="dictionary"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Hashtable.Synchronized"/> for details.</remarks>

		public static AttributeHash Synchronized(AttributeHash dictionary) 
		{
			if (dictionary == null)
				throw new ArgumentNullException("dictionary");

			AttributeHash sync = new AttributeHash(Tag.Default);
			sync._innerHash = Hashtable.Synchronized(dictionary._innerHash);
			return sync;
		}

		#endregion
		#endregion
		#region Private Methods
		#region CheckTargetArray

		private void CheckTargetArray(Array array, int arrayIndex) 
		{
			if (array == null)
				throw new ArgumentNullException("array");
			if (array.Rank > 1)
				throw new ArgumentException(
					"Argument cannot be multidimensional.", "array");

			if (arrayIndex < 0)
				throw new ArgumentOutOfRangeException("arrayIndex",
					arrayIndex, "Argument cannot be negative.");
			if (arrayIndex >= array.Length)
				throw new ArgumentException(
					"Argument must be less than array length.", "arrayIndex");

			if (this._innerHash.Count > array.Length - arrayIndex)
				throw new ArgumentException(
					"Argument section must be large enough for collection.", "array");
		}

		#endregion
		#endregion
		#region Class Enumerator

		private sealed class Enumerator:
			IIAttributeTypeIAttributeEnumerator, IDictionaryEnumerator 
		{
			#region Private Fields

			private readonly IDictionaryEnumerator _innerEnumerator;

			#endregion
			#region Internal Constructors

			internal Enumerator(AttributeHash dictionary) 
			{
				this._innerEnumerator = dictionary._innerHash.GetEnumerator();
			}

			#endregion
			#region Public Properties

			public IAttributeTypeIAttributeEntry Current 
			{
				get { return new IAttributeTypeIAttributeEntry(Key, Value); }
			}

			object IEnumerator.Current 
			{
				get { return this._innerEnumerator.Current; }
			}

			public IAttributeTypeIAttributeEntry Entry 
			{
				get { return new IAttributeTypeIAttributeEntry(Key, Value); }
			}

			DictionaryEntry IDictionaryEnumerator.Entry 
			{
				get { return this._innerEnumerator.Entry; }
			}

			public IAttributeType Key 
			{
				get { return (IAttributeType) this._innerEnumerator.Key; }
			}

			object IDictionaryEnumerator.Key 
			{
				get { return this._innerEnumerator.Key; }
			}

			public IAttribute Value 
			{
				get { return (IAttribute) this._innerEnumerator.Value; }
			}

			object IDictionaryEnumerator.Value 
			{
				get { return this._innerEnumerator.Value; }
			}

			#endregion
			#region Public Methods

			public bool MoveNext() 
			{
				return this._innerEnumerator.MoveNext();
			}

			public void Reset() 
			{
				this._innerEnumerator.Reset();
			}

			#endregion
		}

		#endregion
		#region Class KeyList

		[Serializable]
			private sealed class KeyList:
			IIAttributeTypeCollection, ICollection 
		{
			#region Private Fields

			private AttributeHash _dictionary;

			#endregion
			#region Internal Constructors

			internal KeyList(AttributeHash dictionary) 
			{
				this._dictionary = dictionary;
			}

			#endregion
			#region Public Properties

			public int Count 
			{
				get { return this._dictionary.Count; }
			}

			public bool IsSynchronized 
			{
				get { return this._dictionary.IsSynchronized; }
			}

			public object SyncRoot 
			{
				get { return this._dictionary.SyncRoot; }
			}

			#endregion
			#region Public Methods

			public void CopyTo(IAttributeType[] array, int arrayIndex) 
			{
				this._dictionary.CheckTargetArray(array, arrayIndex);
				foreach (IAttributeTypeIAttributeEntry pair in this._dictionary)
					array[arrayIndex++] = pair.Key;
			}

			void ICollection.CopyTo(Array array, int arrayIndex) 
			{
				this._dictionary.CheckTargetArray(array, arrayIndex);
				CopyTo((IAttributeType[]) array, arrayIndex);
			}

			public IIAttributeTypeEnumerator GetEnumerator() 
			{
				return new KeyEnumerator(this._dictionary);
			}

			IEnumerator IEnumerable.GetEnumerator() 
			{
				return (IEnumerator) GetEnumerator();
			}

			#endregion
		}

		#endregion
		#region Class KeyEnumerator

		[Serializable]
			private sealed class KeyEnumerator:
			IIAttributeTypeEnumerator, IEnumerator 
		{
			#region Private Fields

			private readonly IEnumerator _innerEnumerator;

			#endregion
			#region Internal Constructors

			internal KeyEnumerator(AttributeHash dictionary) 
			{
				this._innerEnumerator = dictionary._innerHash.Keys.GetEnumerator();
			}

			#endregion
			#region Public Properties

			public IAttributeType Current 
			{
				get { return (IAttributeType) this._innerEnumerator.Current; }
			}

			object IEnumerator.Current 
			{
				get { return this._innerEnumerator.Current; }
			}

			#endregion
			#region Public Methods

			public bool MoveNext() 
			{
				return this._innerEnumerator.MoveNext();
			}

			public void Reset() 
			{
				this._innerEnumerator.Reset();
			}

			#endregion
		}

		#endregion
		#region Class ValueList

		[Serializable]
			private sealed class ValueList:
			IIAttributeCollection, ICollection 
		{
			#region Private Fields

			private AttributeHash _dictionary;

			#endregion
			#region Internal Constructors

			internal ValueList(AttributeHash dictionary) 
			{
				this._dictionary = dictionary;
			}

			#endregion
			#region Public Properties

			public int Count 
			{
				get { return this._dictionary.Count; }
			}

			public bool IsSynchronized 
			{
				get { return this._dictionary.IsSynchronized; }
			}

			public object SyncRoot 
			{
				get { return this._dictionary.SyncRoot; }
			}

			#endregion
			#region Public Methods

			public void CopyTo(IAttribute[] array, int arrayIndex) 
			{
				this._dictionary.CheckTargetArray(array, arrayIndex);
				foreach (IAttributeTypeIAttributeEntry pair in this._dictionary)
					array[arrayIndex++] = pair.Value;
			}

			void ICollection.CopyTo(Array array, int arrayIndex) 
			{
				this._dictionary.CheckTargetArray(array, arrayIndex);
				CopyTo((IAttribute[]) array, arrayIndex);
			}

			public IIAttributeEnumerator GetEnumerator() 
			{
				return new ValueEnumerator(this._dictionary);
			}

			IEnumerator IEnumerable.GetEnumerator() 
			{
				return (IEnumerator) GetEnumerator();
			}

			#endregion
		}

		#endregion
		#region Class ValueEnumerator

		[Serializable]
			private sealed class ValueEnumerator:
			IIAttributeEnumerator, IEnumerator 
		{
			#region Private Fields

			private readonly IEnumerator _innerEnumerator;

			#endregion
			#region Internal Constructors

			internal ValueEnumerator(AttributeHash dictionary) 
			{
				this._innerEnumerator = dictionary._innerHash.Values.GetEnumerator();
			}

			#endregion
			#region Public Properties

			public IAttribute Current 
			{
				get { return (IAttribute) this._innerEnumerator.Current; }
			}

			object IEnumerator.Current 
			{
				get { return this._innerEnumerator.Current; }
			}

			#endregion
			#region Public Methods

			public bool MoveNext() 
			{
				return this._innerEnumerator.MoveNext();
			}

			public void Reset() 
			{
				this._innerEnumerator.Reset();
			}

			#endregion
		}

		#endregion
	}

	#endregion
}
