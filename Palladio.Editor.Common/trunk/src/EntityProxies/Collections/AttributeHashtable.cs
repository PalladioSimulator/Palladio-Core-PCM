
using System;
using System.ComponentModel;
using System.Collections;
using Palladio.Editor.Common;

namespace Palladio.Editor.Common.EntityProxies.Collections 
{
	#region Interface IAbstractAttributeCollection

	/// <summary>
	/// Defines size, enumerators, and synchronization methods for strongly
	/// typed collections of <see cref="AbstractAttribute"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IAbstractAttributeCollection</b> provides an <see cref="ICollection"/>
	/// that is strongly typed for <see cref="AbstractAttribute"/> elements.
	/// </remarks>

	public interface IAbstractAttributeCollection 
	{
		#region Properties
		#region Count

		/// <summary>
		/// Gets the number of elements contained in the
		/// <see cref="IAbstractAttributeCollection"/>.
		/// </summary>
		/// <value>The number of elements contained in the
		/// <see cref="IAbstractAttributeCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.Count"/> for details.</remarks>

		int Count { get; }

		#endregion
		#region IsSynchronized

		/// <summary>
		/// Gets a value indicating whether access to the
		/// <see cref="IAbstractAttributeCollection"/> is synchronized (thread-safe).
		/// </summary>
		/// <value><c>true</c> if access to the <see cref="IAbstractAttributeCollection"/> is
		/// synchronized (thread-safe); otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="ICollection.IsSynchronized"/> for details.</remarks>

		bool IsSynchronized { get; }

		#endregion
		#region SyncRoot

		/// <summary>
		/// Gets an object that can be used to synchronize access
		/// to the <see cref="IAbstractAttributeCollection"/>.
		/// </summary>
		/// <value>An object that can be used to synchronize access
		/// to the <see cref="IAbstractAttributeCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.SyncRoot"/> for details.</remarks>

		object SyncRoot { get; }

		#endregion
		#endregion
		#region Methods
		#region CopyTo

		/// <summary>
		/// Copies the entire <see cref="IAbstractAttributeCollection"/> to a one-dimensional <see cref="Array"/>
		/// of <see cref="AbstractAttribute"/> elements, starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the destination of the
		/// <see cref="AbstractAttribute"/> elements copied from the <see cref="IAbstractAttributeCollection"/>.
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
		/// The number of elements in the source <see cref="IAbstractAttributeCollection"/> is greater
		/// than the available space from <paramref name="arrayIndex"/> to the end of the destination
		/// <paramref name="array"/>.</para></exception>
		/// <remarks>Please refer to <see cref="ICollection.CopyTo"/> for details.</remarks>

		void CopyTo(AbstractAttribute[] array, int arrayIndex);

		#endregion
		#region GetEnumerator

		/// <summary>
		/// Returns an <see cref="IAbstractAttributeEnumerator"/> that can
		/// iterate through the <see cref="IAbstractAttributeCollection"/>.
		/// </summary>
		/// <returns>An <see cref="IAbstractAttributeEnumerator"/>
		/// for the entire <see cref="IAbstractAttributeCollection"/>.</returns>
		/// <remarks>Please refer to <see cref="IEnumerable.GetEnumerator"/> for details.</remarks>

		IAbstractAttributeEnumerator GetEnumerator();

		#endregion
		#endregion
	}

	#endregion
	#region Interface IAbstractAttributeList

	/// <summary>
	/// Represents a strongly typed collection of <see cref="AbstractAttribute"/>
	/// objects that can be individually accessed by index.
	/// </summary>
	/// <remarks>
	/// <b>IAbstractAttributeList</b> provides an <see cref="IList"/>
	/// that is strongly typed for <see cref="AbstractAttribute"/> elements.
	/// </remarks>

	public interface
		IAbstractAttributeList: IAbstractAttributeCollection 
	{
		#region Properties
		#region IsFixedSize

		/// <summary>
		/// Gets a value indicating whether the <see cref="IAbstractAttributeList"/> has a fixed size.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IAbstractAttributeList"/> has a fixed size;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsFixedSize"/> for details.</remarks>

		bool IsFixedSize { get; }

		#endregion
		#region IsReadOnly

		/// <summary>
		/// Gets a value indicating whether the <see cref="IAbstractAttributeList"/> is read-only.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IAbstractAttributeList"/> is read-only;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsReadOnly"/> for details.</remarks>

		bool IsReadOnly { get; }

		#endregion
		#region Item

		/// <summary>
		/// Gets or sets the <see cref="AbstractAttribute"/> element at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index of the
		/// <see cref="AbstractAttribute"/> element to get or set.</param>
		/// <value>
		/// The <see cref="AbstractAttribute"/> element at the specified <paramref name="index"/>.
		/// </value>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IAbstractAttributeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// The property is set and the <see cref="IAbstractAttributeList"/> is read-only.</exception>
		/// <remarks>Please refer to <see cref="IList.this"/> for details.</remarks>

		AbstractAttribute this[int index] { get; set; }

		#endregion
		#endregion
		#region Methods
		#region Add

		/// <summary>
		/// Adds a <see cref="AbstractAttribute"/> to the end
		/// of the <see cref="IAbstractAttributeList"/>.
		/// </summary>
		/// <param name="value">The <see cref="AbstractAttribute"/> object
		/// to be added to the end of the <see cref="IAbstractAttributeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns>The <see cref="IAbstractAttributeList"/> index at which
		/// the <paramref name="value"/> has been added.</returns>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Add"/> for details.</remarks>

		int Add(AbstractAttribute value);

		#endregion
		#region Clear

		/// <summary>
		/// Removes all elements from the <see cref="IAbstractAttributeList"/>.
		/// </summary>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Clear"/> for details.</remarks>

		void Clear();

		#endregion
		#region Contains

		/// <summary>
		/// Determines whether the <see cref="IAbstractAttributeList"/>
		/// contains the specified <see cref="AbstractAttribute"/> element.
		/// </summary>
		/// <param name="value">The <see cref="AbstractAttribute"/> object
		/// to locate in the <see cref="IAbstractAttributeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns><c>true</c> if <paramref name="value"/> is found in the
		/// <see cref="IAbstractAttributeList"/>; otherwise, <c>false</c>.</returns>
		/// <remarks>Please refer to <see cref="IList.Contains"/> for details.</remarks>

		bool Contains(AbstractAttribute value);

		#endregion
		#region IndexOf

		/// <summary>
		/// Returns the zero-based index of the first occurrence of the specified
		/// <see cref="AbstractAttribute"/> in the <see cref="IAbstractAttributeList"/>.
		/// </summary>
		/// <param name="value">The <see cref="AbstractAttribute"/> object
		/// to locate in the <see cref="IAbstractAttributeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns>
		/// The zero-based index of the first occurrence of <paramref name="value"/>
		/// in the <see cref="IAbstractAttributeList"/>, if found; otherwise, -1.
		/// </returns>
		/// <remarks>Please refer to <see cref="IList.IndexOf"/> for details.</remarks>

		int IndexOf(AbstractAttribute value);

		#endregion
		#region Insert

		/// <summary>
		/// Inserts a <see cref="AbstractAttribute"/> element into the
		/// <see cref="IAbstractAttributeList"/> at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index at which
		/// <paramref name="value"/> should be inserted.</param>
		/// <param name="value">The <see cref="AbstractAttribute"/> object
		/// to insert into the <see cref="IAbstractAttributeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is greater than
		/// <see cref="IAbstractAttributeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Insert"/> for details.</remarks>

		void Insert(int index, AbstractAttribute value);

		#endregion
		#region Remove

		/// <summary>
		/// Removes the first occurrence of the specified <see cref="AbstractAttribute"/>
		/// from the <see cref="IAbstractAttributeList"/>.
		/// </summary>
		/// <param name="value">The <see cref="AbstractAttribute"/> object
		/// to remove from the <see cref="IAbstractAttributeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Remove"/> for details.</remarks>

		void Remove(AbstractAttribute value);

		#endregion
		#region RemoveAt

		/// <summary>
		/// Removes the element at the specified index of the
		/// <see cref="IAbstractAttributeList"/>.
		/// </summary>
		/// <param name="index">The zero-based index of the element to remove.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IAbstractAttributeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.RemoveAt"/> for details.</remarks>

		void RemoveAt(int index);

		#endregion
		#endregion
	}

	#endregion
	#region Interface IAbstractAttributeEnumerator

	/// <summary>
	/// Supports type-safe iteration over a collection that
	/// contains <see cref="AbstractAttribute"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IAbstractAttributeEnumerator</b> provides an <see cref="IEnumerator"/>
	/// that is strongly typed for <see cref="AbstractAttribute"/> elements.
	/// </remarks>

	public interface IAbstractAttributeEnumerator 
	{
		#region Properties
		#region Current

		/// <summary>
		/// Gets the current <see cref="AbstractAttribute"/> element in the collection.
		/// </summary>
		/// <value>The current <see cref="AbstractAttribute"/> element in the collection.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the collection or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The collection was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IEnumerator.Current"/> for details, but note
		/// that <b>Current</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		AbstractAttribute Current { get; }

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
	#region Interface IAbstractAttributeTypeCollection

	/// <summary>
	/// Defines size, enumerators, and synchronization methods for strongly
	/// typed collections of <see cref="AbstractAttributeType"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IAbstractAttributeTypeCollection</b> provides an <see cref="ICollection"/>
	/// that is strongly typed for <see cref="AbstractAttributeType"/> elements.
	/// </remarks>

	public interface IAbstractAttributeTypeCollection 
	{
		#region Properties
		#region Count

		/// <summary>
		/// Gets the number of elements contained in the
		/// <see cref="IAbstractAttributeTypeCollection"/>.
		/// </summary>
		/// <value>The number of elements contained in the
		/// <see cref="IAbstractAttributeTypeCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.Count"/> for details.</remarks>

		int Count { get; }

		#endregion
		#region IsSynchronized

		/// <summary>
		/// Gets a value indicating whether access to the
		/// <see cref="IAbstractAttributeTypeCollection"/> is synchronized (thread-safe).
		/// </summary>
		/// <value><c>true</c> if access to the <see cref="IAbstractAttributeTypeCollection"/> is
		/// synchronized (thread-safe); otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="ICollection.IsSynchronized"/> for details.</remarks>

		bool IsSynchronized { get; }

		#endregion
		#region SyncRoot

		/// <summary>
		/// Gets an object that can be used to synchronize access
		/// to the <see cref="IAbstractAttributeTypeCollection"/>.
		/// </summary>
		/// <value>An object that can be used to synchronize access
		/// to the <see cref="IAbstractAttributeTypeCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.SyncRoot"/> for details.</remarks>

		object SyncRoot { get; }

		#endregion
		#endregion
		#region Methods
		#region CopyTo

		/// <summary>
		/// Copies the entire <see cref="IAbstractAttributeTypeCollection"/> to a one-dimensional <see cref="Array"/>
		/// of <see cref="AbstractAttributeType"/> elements, starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the destination of the
		/// <see cref="AbstractAttributeType"/> elements copied from the <see cref="IAbstractAttributeTypeCollection"/>.
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
		/// The number of elements in the source <see cref="IAbstractAttributeTypeCollection"/> is greater
		/// than the available space from <paramref name="arrayIndex"/> to the end of the destination
		/// <paramref name="array"/>.</para></exception>
		/// <remarks>Please refer to <see cref="ICollection.CopyTo"/> for details.</remarks>

		void CopyTo(AbstractAttributeType[] array, int arrayIndex);

		#endregion
		#region GetEnumerator

		/// <summary>
		/// Returns an <see cref="IAbstractAttributeTypeEnumerator"/> that can
		/// iterate through the <see cref="IAbstractAttributeTypeCollection"/>.
		/// </summary>
		/// <returns>An <see cref="IAbstractAttributeTypeEnumerator"/>
		/// for the entire <see cref="IAbstractAttributeTypeCollection"/>.</returns>
		/// <remarks>Please refer to <see cref="IEnumerable.GetEnumerator"/> for details.</remarks>

		IAbstractAttributeTypeEnumerator GetEnumerator();

		#endregion
		#endregion
	}

	#endregion
	#region Interface IAbstractAttributeTypeList

	/// <summary>
	/// Represents a strongly typed collection of <see cref="AbstractAttributeType"/>
	/// objects that can be individually accessed by index.
	/// </summary>
	/// <remarks>
	/// <b>IAbstractAttributeTypeList</b> provides an <see cref="IList"/>
	/// that is strongly typed for <see cref="AbstractAttributeType"/> elements.
	/// </remarks>

	public interface
		IAbstractAttributeTypeList: IAbstractAttributeTypeCollection 
	{
		#region Properties
		#region IsFixedSize

		/// <summary>
		/// Gets a value indicating whether the <see cref="IAbstractAttributeTypeList"/> has a fixed size.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IAbstractAttributeTypeList"/> has a fixed size;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsFixedSize"/> for details.</remarks>

		bool IsFixedSize { get; }

		#endregion
		#region IsReadOnly

		/// <summary>
		/// Gets a value indicating whether the <see cref="IAbstractAttributeTypeList"/> is read-only.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IAbstractAttributeTypeList"/> is read-only;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsReadOnly"/> for details.</remarks>

		bool IsReadOnly { get; }

		#endregion
		#region Item

		/// <summary>
		/// Gets or sets the <see cref="AbstractAttributeType"/> element at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index of the
		/// <see cref="AbstractAttributeType"/> element to get or set.</param>
		/// <value>
		/// The <see cref="AbstractAttributeType"/> element at the specified <paramref name="index"/>.
		/// </value>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IAbstractAttributeTypeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// The property is set and the <see cref="IAbstractAttributeTypeList"/> is read-only.</exception>
		/// <remarks>Please refer to <see cref="IList.this"/> for details.</remarks>

		AbstractAttributeType this[int index] { get; set; }

		#endregion
		#endregion
		#region Methods
		#region Add

		/// <summary>
		/// Adds a <see cref="AbstractAttributeType"/> to the end
		/// of the <see cref="IAbstractAttributeTypeList"/>.
		/// </summary>
		/// <param name="value">The <see cref="AbstractAttributeType"/> object
		/// to be added to the end of the <see cref="IAbstractAttributeTypeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns>The <see cref="IAbstractAttributeTypeList"/> index at which
		/// the <paramref name="value"/> has been added.</returns>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Add"/> for details.</remarks>

		int Add(AbstractAttributeType value);

		#endregion
		#region Clear

		/// <summary>
		/// Removes all elements from the <see cref="IAbstractAttributeTypeList"/>.
		/// </summary>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Clear"/> for details.</remarks>

		void Clear();

		#endregion
		#region Contains

		/// <summary>
		/// Determines whether the <see cref="IAbstractAttributeTypeList"/>
		/// contains the specified <see cref="AbstractAttributeType"/> element.
		/// </summary>
		/// <param name="value">The <see cref="AbstractAttributeType"/> object
		/// to locate in the <see cref="IAbstractAttributeTypeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns><c>true</c> if <paramref name="value"/> is found in the
		/// <see cref="IAbstractAttributeTypeList"/>; otherwise, <c>false</c>.</returns>
		/// <remarks>Please refer to <see cref="IList.Contains"/> for details.</remarks>

		bool Contains(AbstractAttributeType value);

		#endregion
		#region IndexOf

		/// <summary>
		/// Returns the zero-based index of the first occurrence of the specified
		/// <see cref="AbstractAttributeType"/> in the <see cref="IAbstractAttributeTypeList"/>.
		/// </summary>
		/// <param name="value">The <see cref="AbstractAttributeType"/> object
		/// to locate in the <see cref="IAbstractAttributeTypeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns>
		/// The zero-based index of the first occurrence of <paramref name="value"/>
		/// in the <see cref="IAbstractAttributeTypeList"/>, if found; otherwise, -1.
		/// </returns>
		/// <remarks>Please refer to <see cref="IList.IndexOf"/> for details.</remarks>

		int IndexOf(AbstractAttributeType value);

		#endregion
		#region Insert

		/// <summary>
		/// Inserts a <see cref="AbstractAttributeType"/> element into the
		/// <see cref="IAbstractAttributeTypeList"/> at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index at which
		/// <paramref name="value"/> should be inserted.</param>
		/// <param name="value">The <see cref="AbstractAttributeType"/> object
		/// to insert into the <see cref="IAbstractAttributeTypeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is greater than
		/// <see cref="IAbstractAttributeTypeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Insert"/> for details.</remarks>

		void Insert(int index, AbstractAttributeType value);

		#endregion
		#region Remove

		/// <summary>
		/// Removes the first occurrence of the specified <see cref="AbstractAttributeType"/>
		/// from the <see cref="IAbstractAttributeTypeList"/>.
		/// </summary>
		/// <param name="value">The <see cref="AbstractAttributeType"/> object
		/// to remove from the <see cref="IAbstractAttributeTypeList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Remove"/> for details.</remarks>

		void Remove(AbstractAttributeType value);

		#endregion
		#region RemoveAt

		/// <summary>
		/// Removes the element at the specified index of the
		/// <see cref="IAbstractAttributeTypeList"/>.
		/// </summary>
		/// <param name="index">The zero-based index of the element to remove.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IAbstractAttributeTypeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.RemoveAt"/> for details.</remarks>

		void RemoveAt(int index);

		#endregion
		#endregion
	}

	#endregion
	#region Interface IAbstractAttributeTypeEnumerator

	/// <summary>
	/// Supports type-safe iteration over a collection that
	/// contains <see cref="AbstractAttributeType"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IAbstractAttributeTypeEnumerator</b> provides an <see cref="IEnumerator"/>
	/// that is strongly typed for <see cref="AbstractAttributeType"/> elements.
	/// </remarks>

	public interface IAbstractAttributeTypeEnumerator 
	{
		#region Properties
		#region Current

		/// <summary>
		/// Gets the current <see cref="AbstractAttributeType"/> element in the collection.
		/// </summary>
		/// <value>The current <see cref="AbstractAttributeType"/> element in the collection.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the collection or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The collection was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IEnumerator.Current"/> for details, but note
		/// that <b>Current</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		AbstractAttributeType Current { get; }

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
	#region Interface IAbstractAttributeTypeAbstractAttributeCollection

	/// <summary>
	/// Defines size, enumerators, and synchronization methods for strongly
	/// typed collections of <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IAbstractAttributeTypeAbstractAttributeCollection</b> provides an <see cref="ICollection"/>
	/// that is strongly typed for <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> elements.
	/// </remarks>

	public interface IAbstractAttributeTypeAbstractAttributeCollection 
	{
		#region Properties
		#region Count

		/// <summary>
		/// Gets the number of elements contained in the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeCollection"/>.
		/// </summary>
		/// <value>The number of elements contained in the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.Count"/> for details.</remarks>

		int Count { get; }

		#endregion
		#region IsSynchronized

		/// <summary>
		/// Gets a value indicating whether access to the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeCollection"/> is synchronized (thread-safe).
		/// </summary>
		/// <value><c>true</c> if access to the <see cref="IAbstractAttributeTypeAbstractAttributeCollection"/>
		/// is synchronized (thread-safe); otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="ICollection.IsSynchronized"/> for details.</remarks>

		bool IsSynchronized { get; }

		#endregion
		#region SyncRoot

		/// <summary>
		/// Gets an object that can be used to synchronize access
		/// to the <see cref="IAbstractAttributeTypeAbstractAttributeCollection"/>.
		/// </summary>
		/// <value>An object that can be used to synchronize access to the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.SyncRoot"/> for details.</remarks>

		object SyncRoot { get; }

		#endregion
		#endregion
		#region Methods
		#region CopyTo

		/// <summary>
		/// Copies the entire <see cref="IAbstractAttributeTypeAbstractAttributeCollection"/>
		/// to a one-dimensional <see cref="Array"/> of <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> elements,
		/// starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the
		/// destination of the <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> elements copied from the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeCollection"/>.
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
		/// The number of elements in the source <see cref="IAbstractAttributeTypeAbstractAttributeCollection"/>
		/// is greater than the available space from <paramref name="arrayIndex"/> to the end of the
		/// destination <paramref name="array"/>.</para></exception>
		/// <remarks>Please refer to <see cref="ICollection.CopyTo"/> for details.</remarks>

		void CopyTo(AbstractAttributeTypeAbstractAttributeEntry[] array, int arrayIndex);

		#endregion
		#region GetEnumerator

		/// <summary>
		/// Returns an <see cref="IAbstractAttributeTypeAbstractAttributeEnumerator"/> that can
		/// iterate through the <see cref="IAbstractAttributeTypeAbstractAttributeCollection"/>.
		/// </summary>
		/// <returns>An <see cref="IAbstractAttributeTypeAbstractAttributeEnumerator"/>
		/// for the entire <see cref="IAbstractAttributeTypeAbstractAttributeCollection"/>.</returns>
		/// <remarks>Please refer to <see cref="IEnumerable.GetEnumerator"/> for details.</remarks>

		IAbstractAttributeTypeAbstractAttributeEnumerator GetEnumerator();

		#endregion
		#endregion
	}

	#endregion
	#region Interface IAbstractAttributeTypeAbstractAttributeDictionary

	/// <summary>
	/// Represents a strongly typed collection of
	/// <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> key-and-value pairs.
	/// </summary>
	/// <remarks>
	/// <b>IAbstractAttributeTypeAbstractAttributeDictionary</b> provides an
	/// <see cref="IDictionary"/> that is strongly typed for
	/// <see cref="AbstractAttributeType"/> keys and <see cref="AbstractAttribute"/> values.
	/// </remarks>

	public interface
		IAbstractAttributeTypeAbstractAttributeDictionary: IAbstractAttributeTypeAbstractAttributeCollection 
	{
		#region Properties
		#region IsFixedSize

		/// <summary>
		/// Gets a value indicating whether the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/> has a fixed size.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>
		/// has a fixed size; otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IDictionary.IsFixedSize"/> for details.</remarks>

		bool IsFixedSize { get; }

		#endregion
		#region IsReadOnly

		/// <summary>
		/// Gets a value indicating whether the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/> is read-only.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>
		/// is read-only; otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IDictionary.IsReadOnly"/> for details.</remarks>

		bool IsReadOnly { get; }

		#endregion
		#region Item

		/// <summary>
		/// Gets or sets the <see cref="AbstractAttribute"/> value
		/// associated with the specified <see cref="AbstractAttributeType"/> key.
		/// </summary>
		/// <param name="key">The <see cref="AbstractAttributeType"/> key
		/// whose value to get or set.</param>
		/// <value>The <see cref="AbstractAttribute"/> value associated with the specified
		/// <paramref name="key"/>. If the specified <paramref name="key"/> is not found,
		/// attempting to get it returns
		/// a null reference,
		/// and attempting to set it creates a new element using the specified
		/// <paramref name="key"/>.</value>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The property is set and the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The property is set, <paramref name="key"/> does not exist in the collection,
		/// and the <b>IAbstractAttributeTypeAbstractAttributeDictionary</b> has a fixed size.</para>
		/// </exception>
		/// <remarks>Please refer to <see cref="IDictionary.this"/> for details.</remarks>

		AbstractAttribute this[AbstractAttributeType key] { get; set; }

		#endregion
		#region Keys

		/// <summary>
		/// Gets an <see cref="IAbstractAttributeTypeCollection"/> containing the keys
		/// in the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>.
		/// </summary>
		/// <value>An <see cref="IAbstractAttributeTypeCollection"/> containing the keys
		/// in the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>.</value>
		/// <remarks>Please refer to <see cref="IDictionary.Keys"/> for details.</remarks>

		IAbstractAttributeTypeCollection Keys { get; }

		#endregion
		#region Values

		/// <summary>
		/// Gets an <see cref="IAbstractAttributeCollection"/> containing the values
		/// in the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>.
		/// </summary>
		/// <value>An <see cref="IAbstractAttributeCollection"/> containing the values
		/// in the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>.</value>
		/// <remarks>Please refer to <see cref="IDictionary.Values"/> for details.</remarks>

		IAbstractAttributeCollection Values { get; }

		#endregion
		#endregion
		#region Methods
		#region Add

		/// <summary>
		/// Adds an element with the specified <see cref="AbstractAttributeType"/>
		/// key and <see cref="AbstractAttribute"/> value to the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>.
		/// </summary>
		/// <param name="key">The <see cref="AbstractAttributeType"/> key of the element
		/// to add to the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>.</param>
		/// <param name="value">The <see cref="AbstractAttribute"/> value of the element
		/// to add to the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentException">
		/// <para>An element with the specified <paramref name="key"/> already exists
		/// in the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeAbstractAttributeDictionary</b> is set to use the
		/// <see cref="IComparable"/> interface, and <paramref name="key"/> does not
		/// implement the <b>IComparable</b> interface.</para></exception>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidOperationException">
		/// The comparer throws an exception.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/> is read-only.
		/// </para><para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeAbstractAttributeDictionary</b> has a fixed size.
		/// </para></exception>
		/// <remarks>Please refer to <see cref="IDictionary.Add"/> for details.</remarks>

		void Add(AbstractAttributeType key, AbstractAttribute value);

		#endregion
		#region Clear

		/// <summary>
		/// Removes all elements from the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>.
		/// </summary>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/> is read-only.
		/// </para><para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeAbstractAttributeDictionary</b> has a fixed size.
		/// </para></exception>
		/// <remarks>Please refer to <see cref="IDictionary.Clear"/> for details.</remarks>

		void Clear();

		#endregion
		#region Contains

		/// <summary>
		/// Determines whether the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>
		/// contains the specified <see cref="AbstractAttributeType"/> key.
		/// </summary>
		/// <param name="key">The <see cref="AbstractAttributeType"/> key to locate
		/// in the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>.</param>
		/// <returns><c>true</c> if the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>
		/// contains an element with the specified <paramref name="key"/>; otherwise, <c>false</c>.
		/// </returns>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidOperationException">
		/// The comparer throws an exception.</exception>
		/// <remarks>Please refer to <see cref="IDictionary.Contains"/> for details.</remarks>

		bool Contains(AbstractAttributeType key);

		#endregion
		#region Remove

		/// <summary>
		/// Removes the element with the specified <see cref="AbstractAttributeType"/> key
		/// from the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>.
		/// </summary>
		/// <param name="key">The <see cref="AbstractAttributeType"/> key of the element to remove
		/// from the <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/>.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidOperationException">
		/// The comparer throws an exception.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeAbstractAttributeDictionary"/> is read-only.
		/// </para><para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeAbstractAttributeDictionary</b> has a fixed size.
		/// </para></exception>
		/// <remarks>Please refer to <see cref="IDictionary.Remove"/> for details.</remarks>

		void Remove(AbstractAttributeType key);

		#endregion
		#endregion
	}

	#endregion
	#region Interface IAbstractAttributeTypeAbstractAttributeList

	/// <summary>
	/// Represents a strongly typed collection of <see cref="AbstractAttributeTypeAbstractAttributeEntry"/>
	/// objects that can be individually accessed by index.
	/// </summary>
	/// <remarks>
	/// <b>IAbstractAttributeTypeAbstractAttributeList</b> provides an <see cref="IList"/>
	/// that is strongly typed for <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> elements.
	/// </remarks>

	public interface
		IAbstractAttributeTypeAbstractAttributeList: IAbstractAttributeTypeAbstractAttributeCollection 
	{
		#region Properties
		#region IsFixedSize

		/// <summary>
		/// Gets a value indicating whether the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeList"/> has a fixed size.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>
		/// has a fixed size; otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsFixedSize"/> for details.</remarks>

		bool IsFixedSize { get; }

		#endregion
		#region IsReadOnly

		/// <summary>
		/// Gets a value indicating whether the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeList"/> is read-only.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>
		/// is read-only; otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsReadOnly"/> for details.</remarks>

		bool IsReadOnly { get; }

		#endregion
		#region Item

		/// <summary>
		/// Gets or sets the <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> element at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index of the
		/// <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> element to get or set.</param>
		/// <value>
		/// The <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> element at the specified <paramref name="index"/>.
		/// </value>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IAbstractAttributeTypeAbstractAttributeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">The property is set and the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeList"/> is read-only.</exception>
		/// <remarks>Please refer to <see cref="IList.this"/> for details.</remarks>

		AbstractAttributeTypeAbstractAttributeEntry this[int index] { get; set; }

		#endregion
		#endregion
		#region Methods
		#region Add

		/// <summary>
		/// Adds a <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> to the end
		/// of the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>.
		/// </summary>
		/// <param name="entry">The <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> object
		/// to be added to the end of the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>.
		/// </param>
		/// <returns>The <see cref="IAbstractAttributeTypeAbstractAttributeList"/> index at which
		/// the <paramref name="entry"/> has been added.</returns>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeAbstractAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeAbstractAttributeList</b> has a fixed size.</para>
		/// </exception>
		/// <remarks>Please refer to <see cref="IList.Add"/> for details.</remarks>

		int Add(AbstractAttributeTypeAbstractAttributeEntry entry);

		#endregion
		#region Clear

		/// <summary>
		/// Removes all elements from the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>.
		/// </summary>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeAbstractAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeAbstractAttributeList</b> has a fixed size.</para>
		/// </exception>
		/// <remarks>Please refer to <see cref="IList.Clear"/> for details.</remarks>

		void Clear();

		#endregion
		#region Contains

		/// <summary>
		/// Determines whether the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>
		/// contains the specified <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> element.
		/// </summary>
		/// <param name="entry">The <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> object
		/// to locate in the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>.</param>
		/// <returns><c>true</c> if <paramref name="entry"/> is found in the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeList"/>; otherwise, <c>false</c>.</returns>
		/// <remarks>Please refer to <see cref="IList.Contains"/> for details.</remarks>

		bool Contains(AbstractAttributeTypeAbstractAttributeEntry entry);

		#endregion
		#region IndexOf

		/// <summary>
		/// Returns the zero-based index of the first occurrence of the specified
		/// <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> in the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>.
		/// </summary>
		/// <param name="entry">The <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> object
		/// to locate in the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>.</param>
		/// <returns>
		/// The zero-based index of the first occurrence of <paramref name="entry"/>
		/// in the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>, if found; otherwise, -1.
		/// </returns>
		/// <remarks>Please refer to <see cref="IList.IndexOf"/> for details.</remarks>

		int IndexOf(AbstractAttributeTypeAbstractAttributeEntry entry);

		#endregion
		#region Insert

		/// <summary>
		/// Inserts a <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> element into the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeList"/> at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index at which
		/// <paramref name="entry"/> should be inserted.</param>
		/// <param name="entry">The <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> object to insert
		/// into the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is greater than
		/// <see cref="IAbstractAttributeTypeAbstractAttributeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeAbstractAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeAbstractAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Insert"/> for details.</remarks>

		void Insert(int index, AbstractAttributeTypeAbstractAttributeEntry entry);

		#endregion
		#region Remove

		/// <summary>
		/// Removes the first occurrence of the specified <see cref="AbstractAttributeTypeAbstractAttributeEntry"/>
		/// from the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>.
		/// </summary>
		/// <param name="entry">The <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> object to remove
		/// from the <see cref="IAbstractAttributeTypeAbstractAttributeList"/>.</param>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeAbstractAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeAbstractAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Remove"/> for details.</remarks>

		void Remove(AbstractAttributeTypeAbstractAttributeEntry entry);

		#endregion
		#region RemoveAt

		/// <summary>
		/// Removes the element at the specified index of the
		/// <see cref="IAbstractAttributeTypeAbstractAttributeList"/>.
		/// </summary>
		/// <param name="index">The zero-based index of the element to remove.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IAbstractAttributeTypeAbstractAttributeCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IAbstractAttributeTypeAbstractAttributeList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IAbstractAttributeTypeAbstractAttributeList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.RemoveAt"/> for details.</remarks>

		void RemoveAt(int index);

		#endregion
		#endregion
	}

	#endregion
	#region Interface IAbstractAttributeTypeAbstractAttributeEnumerator

	/// <summary>
	/// Supports type-safe iteration over a dictionary that
	/// contains <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IAbstractAttributeTypeAbstractAttributeEnumerator</b> provides an
	/// <see cref="IDictionaryEnumerator"/> that is strongly typed for
	/// <see cref="AbstractAttributeType"/> keys and <see cref="AbstractAttribute"/> values.
	/// </remarks>

	public interface IAbstractAttributeTypeAbstractAttributeEnumerator 
	{
		#region Properties
		#region Current

		/// <summary>
		/// Gets the current <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> element in the collection.
		/// </summary>
		/// <value>The current <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> element in the collection.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the collection or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The collection was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IEnumerator.Current"/> for details, but note
		/// that <b>Current</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		AbstractAttributeTypeAbstractAttributeEntry Current { get; }

		#endregion
		#region Entry

		/// <summary>
		/// Gets a <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> containing both
		/// the key and the value of the current dictionary entry.
		/// </summary>
		/// <value>A <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> containing both
		/// the key and the value of the current dictionary entry.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the dictionary or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The dictionary was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IDictionaryEnumerator.Entry"/> for details, but
		/// note that <b>Entry</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		AbstractAttributeTypeAbstractAttributeEntry Entry { get; }

		#endregion
		#region Key

		/// <summary>
		/// Gets the <see cref="AbstractAttributeType"/> key of the current dictionary entry.
		/// </summary>
		/// <value>The <see cref="AbstractAttributeType"/> key
		/// of the current element of the enumeration.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the dictionary or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The dictionary was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IDictionaryEnumerator.Key"/> for details, but
		/// note that <b>Key</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		AbstractAttributeType Key { get; }

		#endregion
		#region Value

		/// <summary>
		/// Gets the <see cref="AbstractAttribute"/> value of the current dictionary entry.
		/// </summary>
		/// <value>The <see cref="AbstractAttribute"/> value
		/// of the current element of the enumeration.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the dictionary or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The dictionary was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IDictionaryEnumerator.Value"/> for details, but
		/// note that <b>Value</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		AbstractAttribute Value { get; }

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
	#region Struct AbstractAttributeTypeAbstractAttributeEntry

	/// <summary>
	/// Implements a strongly typed pair of one <see cref="AbstractAttributeType"/>
	/// key and one <see cref="AbstractAttribute"/> value.
	/// </summary>
	/// <remarks>
	/// <b>AbstractAttributeTypeAbstractAttributeEntry</b> provides a <see cref="DictionaryEntry"/> that is strongly
	/// typed for <see cref="AbstractAttributeType"/> keys and <see cref="AbstractAttribute"/> values.
	/// </remarks>

	[Serializable]
	public struct AbstractAttributeTypeAbstractAttributeEntry 
	{
		#region Private Fields

		private AbstractAttributeType _key;
		private AbstractAttribute _value;

		#endregion
		#region Public Constructors

		/// <summary>
		/// Initializes a new instance of the <see cref="AbstractAttributeTypeAbstractAttributeEntry"/>
		/// class with the specified key and value.
		/// </summary>
		/// <param name="key">
		/// The <see cref="AbstractAttributeType"/> key in the key-and-value pair.</param>
		/// <param name="value">
		/// The <see cref="AbstractAttribute"/> value in the key-and-value pair.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>

		public AbstractAttributeTypeAbstractAttributeEntry(AbstractAttributeType key, AbstractAttribute value) 
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
		/// Gets or sets the <see cref="AbstractAttributeType"/> key in the key-and-value pair.
		/// </summary>
		/// <value>
		/// The <see cref="AbstractAttributeType"/> key in the key-and-value pair.
		/// The default is a null reference.
		/// </value>
		/// <exception cref="ArgumentNullException">
		/// <b>Key</b> is set to a null reference.</exception>
		/// <remarks>
		/// <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> is a value type and therefore has an implicit default
		/// constructor that zeroes all data members. This means that the <b>Key</b> property of
		/// a default-constructed <b>AbstractAttributeTypeAbstractAttributeEntry</b> contains a null reference by default,
		/// even though it is not possible to explicitly set <b>Key</b> to a null reference.
		/// </remarks>

		public AbstractAttributeType Key 
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
		/// Gets or sets the <see cref="AbstractAttribute"/> value in the key-and-value pair.
		/// </summary>
		/// <value>
		/// The <see cref="AbstractAttribute"/> value in the key-and-value pair.
		/// This value can be a null reference, which is also the default.
		/// </value>

		public AbstractAttribute Value 
		{
			get { return this._value; }
			set { this._value = value; }
		}

		#endregion
		#endregion
		#region Public Operators
		#region AbstractAttributeTypeAbstractAttributeEntry(DictionaryEntry)

		/// <summary>
		/// Converts a <see cref="DictionaryEntry"/> to a <see cref="AbstractAttributeTypeAbstractAttributeEntry"/>.
		/// </summary>
		/// <param name="entry">A <see cref="DictionaryEntry"/> object to convert.</param>
		/// <returns>A <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> object that represents
		/// the converted <paramref name="entry"/>.</returns>
		/// <exception cref="InvalidCastException">
		/// <para><paramref name="entry"/> contains a key that is not compatible
		/// with <see cref="AbstractAttributeType"/>.</para>
		/// <para>-or-</para>
		/// <para><paramref name="entry"/> contains a value that is not compatible
		/// with <see cref="AbstractAttribute"/>.</para>
		/// </exception>

		public static implicit operator AbstractAttributeTypeAbstractAttributeEntry(DictionaryEntry entry) 
		{
			AbstractAttributeTypeAbstractAttributeEntry pair = new AbstractAttributeTypeAbstractAttributeEntry();
			if (entry.Key != null) pair.Key = (AbstractAttributeType) entry.Key;
			if (entry.Value != null) pair.Value = (AbstractAttribute) entry.Value;
			return pair;
		}

		#endregion
		#region DictionaryEntry(AbstractAttributeTypeAbstractAttributeEntry)

		/// <summary>
		/// Converts a <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> to a <see cref="DictionaryEntry"/>.
		/// </summary>
		/// <param name="pair">A <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> object to convert.</param>
		/// <returns>A <see cref="DictionaryEntry"/> object that
		/// represents the converted <paramref name="pair"/>.</returns>

		public static implicit operator DictionaryEntry(AbstractAttributeTypeAbstractAttributeEntry pair) 
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
	#region Class AttributeHashtable

	/// <summary>
	/// Implements a strongly typed collection of <see cref="AbstractAttributeTypeAbstractAttributeEntry"/>
	/// key-and-value pairs that are organized based on the hash code of the key.
	/// </summary>
	/// <remarks>
	/// <b>AttributeHashtable</b> provides a <see cref="Hashtable"/> that is strongly typed
	/// for <see cref="AbstractAttributeType"/> keys and <see cref="AbstractAttribute"/> values.
	/// </remarks>

	[Serializable]
	public class AttributeHashtable:
		IAbstractAttributeTypeAbstractAttributeDictionary, IDictionary, ICloneable, ICustomTypeDescriptor
	{
		#region Private Fields

		private Hashtable _innerHash;
		private KeyList _keyList;
		private ValueList _valueList;

		#endregion
		#region Private Constructors

		// helper type to identify private ctor
		private enum Tag { Default }

		private AttributeHashtable(Tag tag) { }

		#endregion
		#region Public Constructors
		#region AttributeHashtable()

		/// <overloads>
		/// Initializes a new instance of the <see cref="AttributeHashtable"/> class.
		/// </overloads>
		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHashtable"/> class
		/// that is empty and has the default initial capacity, the default load factor,
		/// the default hash code provider and the default comparer.
		/// </summary>
		/// <remarks>Please refer to <see cref="Hashtable()"/> for details.</remarks>

		public AttributeHashtable() 
		{
			this._innerHash = new Hashtable();
		}

		#endregion
		#region AttributeHashtable(IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHashtable"/> class
		/// that is empty and has the default initial capacity, the default load factor,
		/// the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="AttributeHashtable"/>.</para>
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

		public AttributeHashtable(IHashCodeProvider provider, IComparer comparer) 
		{
			this._innerHash = new Hashtable(provider, comparer);
		}

		#endregion
		#region AttributeHashtable(Int32)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHashtable"/> class
		/// that is empty and has the specified initial capacity, the default load factor,
		/// the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="capacity">The approximate number of elements that the new
		/// <see cref="AttributeHashtable"/> is initially capable of storing.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <paramref name="capacity"/> is less than zero.</exception>
		/// <remarks>Please refer to <see cref="Hashtable(Int32)"/> for details.</remarks>

		public AttributeHashtable(int capacity) 
		{
			this._innerHash = new Hashtable(capacity);
		}

		#endregion
		#region AttributeHashtable(Int32, IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHashtable"/> class
		/// that is empty and has the specified initial capacity, the default load factor,
		/// the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="capacity">The approximate number of elements that the new
		/// <see cref="AttributeHashtable"/> is initially capable of storing.</param>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="AttributeHashtable"/>.</para>
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

		public AttributeHashtable(int capacity,
			IHashCodeProvider provider, IComparer comparer) 
		{

			this._innerHash = new Hashtable(capacity, provider, comparer);
		}

		#endregion
		#region AttributeHashtable(Int32, Single)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHashtable"/> class
		/// that is empty and has the specified initial capacity, the specified load factor,
		/// the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="capacity">The approximate number of elements that the new
		/// <see cref="AttributeHashtable"/> is initially capable of storing.</param>
		/// <param name="loadFactor">A number in the range from 0.1 through 1.0
		/// indicating the maximum ratio of elements to buckets.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="capacity"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="loadFactor"/> is less than 0.1.</para>
		/// <para>-or-</para>
		/// <para><paramref name="loadFactor"/> is greater than 1.0.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable(Int32, Single)"/> for details.</remarks>

		public AttributeHashtable(int capacity, float loadFactor) 
		{
			this._innerHash = new Hashtable(capacity, loadFactor);
		}

		#endregion
		#region AttributeHashtable(Int32, Single, IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHashtable"/> class
		/// that is empty and has the specified initial capacity, the specified load factor,
		/// the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="capacity">The approximate number of elements that the new
		/// <see cref="AttributeHashtable"/> is initially capable of storing.</param>
		/// <param name="loadFactor">A number in the range from 0.1 through 1.0
		/// indicating the maximum ratio of elements to buckets.</param>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="AttributeHashtable"/>.</para>
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

		public AttributeHashtable(int capacity, float loadFactor,
			IHashCodeProvider provider, IComparer comparer) 
		{

			this._innerHash = new Hashtable(capacity, loadFactor, provider, comparer);
		}

		#endregion
		#region AttributeHashtable(AttributeHashtable)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHashtable"/> class
		/// that contains elements copied from the specified dictionary and
		/// that has the same initial capacity as the number of elements copied, the
		/// default load factor, the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="dictionary">The <see cref="AttributeHashtable"/>
		/// whose elements are copied to the new collection.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="dictionary"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Hashtable(IDictionary)"/> for details.</remarks>

		public AttributeHashtable(AttributeHashtable dictionary) 
		{
			if (dictionary == null)
				throw new ArgumentNullException("dictionary");

			this._innerHash = new Hashtable(dictionary._innerHash);
		}

		#endregion
		#region AttributeHashtable(IDictionary)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHashtable"/> class
		/// that contains elements copied from the specified <see cref="IDictionary"/>
		/// and that has the same initial capacity as the number of elements copied, the
		/// default load factor, the default hash code provider and the default comparer.
		/// </summary>
		/// <param name="dictionary">The <see cref="IDictionary"/>
		/// whose elements are copied to the new collection.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="dictionary"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Hashtable(IDictionary)"/> for details.</remarks>

		public AttributeHashtable(IDictionary dictionary) 
		{
			this._innerHash = new Hashtable(dictionary);
		}

		#endregion
		#region AttributeHashtable(IDictionary, IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHashtable"/> class
		/// that contains elements copied from the specified <see cref="IDictionary"/>
		/// and that has the same initial capacity as the number of elements copied, the
		/// default load factor, the specified hash code provider and the specified comparer.
		/// </summary>
		/// <param name="dictionary">The <see cref="IDictionary"/>
		/// whose elements are copied to the new collection.</param>
		/// <param name="provider">
		/// <para>The <see cref="IHashCodeProvider"/> that supplies the hash codes
		/// for all keys in the <see cref="AttributeHashtable"/>.</para>
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

		public AttributeHashtable(IDictionary dictionary,
			IHashCodeProvider provider, IComparer comparer) 
		{

			this._innerHash = new Hashtable(dictionary, provider, comparer);
		}

		#endregion
		#region AttributeHashtable(IDictionary, Single)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHashtable"/> class
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

		public AttributeHashtable(IDictionary dictionary, float loadFactor) 
		{
			this._innerHash = new Hashtable(dictionary, loadFactor);
		}

		#endregion
		#region AttributeHashtable(IDictionary, Single, IHashCodeProvider, IComparer)

		/// <summary>
		/// Initializes a new instance of the <see cref="AttributeHashtable"/> class
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
		/// for all keys in the <see cref="AttributeHashtable"/>.</para>
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

		public AttributeHashtable(IDictionary dictionary,
			float loadFactor, IHashCodeProvider provider, IComparer comparer) 
		{

			this._innerHash = new Hashtable(dictionary, loadFactor, provider, comparer);
		}

		#endregion
		#endregion
		#region Public Properties
		#region Count

		/// <summary>
		/// Gets the number of key-and-value pairs contained in the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <value>
		/// The number of key-and-value pairs contained in the <see cref="AttributeHashtable"/>.
		/// </value>
		/// <remarks>Please refer to <see cref="Hashtable.Count"/> for details.</remarks>

		public int Count 
		{
			get { return this._innerHash.Count; }
		}

		#endregion
		#region IsFixedSize

		/// <summary>
		/// Gets a value indicating whether the <see cref="AttributeHashtable"/> has a fixed size.
		/// </summary>
		/// <value><c>true</c> if the <see cref="AttributeHashtable"/> has a fixed size;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.IsFixedSize"/> for details.</remarks>

		public bool IsFixedSize 
		{
			get { return this._innerHash.IsFixedSize; }
		}

		#endregion
		#region IsReadOnly

		/// <summary>
		/// Gets a value indicating whether the <see cref="AttributeHashtable"/> is read-only.
		/// </summary>
		/// <value><c>true</c> if the <see cref="AttributeHashtable"/> is read-only;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.IsReadOnly"/> for details.</remarks>

		public bool IsReadOnly 
		{
			get { return this._innerHash.IsReadOnly; }
		}

		#endregion
		#region IsSynchronized

		/// <summary>
		/// Gets a value indicating whether access to the <see cref="AttributeHashtable"/>
		/// is synchronized (thread-safe).
		/// </summary>
		/// <value><c>true</c> if access to the <see cref="AttributeHashtable"/> is
		/// synchronized (thread-safe); otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.IsSynchronized"/> for details.</remarks>

		public bool IsSynchronized 
		{
			get { return this._innerHash.IsSynchronized; }
		}

		#endregion
		#region Item[AbstractAttributeType]: AbstractAttribute

		/// <summary>
		/// Gets or sets the <see cref="AbstractAttribute"/> value
		/// associated with the specified <see cref="AbstractAttributeType"/> key.
		/// </summary>
		/// <param name="key">The <see cref="AbstractAttributeType"/> key
		/// whose value to get or set.</param>
		/// <value>The <see cref="AbstractAttribute"/> value associated with the specified
		/// <paramref name="key"/>. If the specified <paramref name="key"/> is not found,
		/// attempting to get it returns
		/// a null reference,
		/// and attempting to set it creates a new element using the specified
		/// <paramref name="key"/>.</value>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The property is set and the <see cref="AttributeHashtable"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The property is set, <paramref name="key"/> does not exist in the collection,
		/// and the <b>AttributeHashtable</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.this"/> for details.</remarks>

		public AbstractAttribute this[AbstractAttributeType key] 
		{
			get 
			{
				return (AbstractAttribute) this._innerHash[key];
			}
			set { this._innerHash[key] = value; }
		}

		public AbstractAttribute this[System.Type key]
		{
			get
			{
				foreach (AbstractAttributeType attrType in this._innerHash.Keys)
					if (attrType.GetType() == key)
						return this[attrType];
				return null;
			}
		}

		#endregion
		#region IDictionary.Item[Object]: Object

		/// <summary>
		/// Gets or sets the value associated with the specified key.
		/// </summary>
		/// <param name="key">The key whose value to get or set.
		/// This argument must be compatible with <see cref="AbstractAttributeType"/>.</param>
		/// <value>
		/// The value associated with the specified <paramref name="key"/>. If the specified
		/// <paramref name="key"/> is not found, attempting to get it returns
		/// a null reference,
		/// and attempting to set it creates a new element using the specified <paramref name="key"/>.
		/// When set, this value must be compatible with <see cref="AbstractAttribute"/>.
		/// </value>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidCastException">
		/// <para><paramref name="key"/> is not compatible with <see cref="AbstractAttributeType"/>.</para>
		/// <para>-or-</para>
		/// <para>The property is set to a value that is not compatible with
		/// <see cref="AbstractAttribute"/>.</para></exception>
		/// <exception cref="NotSupportedException">
		/// <para>The property is set and the <see cref="AttributeHashtable"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The property is set, <paramref name="key"/> does not exist in the collection,
		/// and the <b>AttributeHashtable</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.this"/> for details.</remarks>

		object IDictionary.this[object key] 
		{
			get { return this[(AbstractAttributeType) key]; }
			set { this[(AbstractAttributeType) key] = (AbstractAttribute) value; }
		}

		#endregion
		#region Keys: IAbstractAttributeTypeCollection

		/// <summary>
		/// Gets an <see cref="IAbstractAttributeTypeCollection"/> containing
		/// the keys in the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <value>An <see cref="IAbstractAttributeTypeCollection"/> containing
		/// the keys in the <see cref="AttributeHashtable"/>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.Keys"/> for details.</remarks>

		public IAbstractAttributeTypeCollection Keys 
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
		/// the keys in the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <value>An <see cref="ICollection"/> containing
		/// the keys in the <see cref="AttributeHashtable"/>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.Keys"/> for details.</remarks>

		ICollection IDictionary.Keys 
		{
			get { return (ICollection) Keys; }
		}

		#endregion
		#region SyncRoot

		/// <summary>
		/// Gets an object that can be used to synchronize
		/// access to the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <value>An object that can be used to synchronize
		/// access to the <see cref="AttributeHashtable"/>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.SyncRoot"/> for details.</remarks>

		public object SyncRoot 
		{
			get { return this._innerHash.SyncRoot; }
		}

		#endregion
		#region Values: IAbstractAttributeCollection

		/// <summary>
		/// Gets an <see cref="IAbstractAttributeCollection"/> containing
		/// the values in the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <value>An <see cref="IAbstractAttributeCollection"/> containing
		/// the values in the <see cref="AttributeHashtable"/>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.Values"/> for details.</remarks>

		public virtual IAbstractAttributeCollection Values 
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
		/// the values in the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <value>An <see cref="ICollection"/> containing
		/// the values in the <see cref="AttributeHashtable"/>.</value>
		/// <remarks>Please refer to <see cref="Hashtable.Values"/> for details.</remarks>

		ICollection IDictionary.Values 
		{
			get { return (ICollection) Values; }
		}

		#endregion
		#endregion
		#region Public Methods
		#region Add(AbstractAttributeType, AbstractAttribute)

		/// <summary>
		/// Adds an element with the specified <see cref="AbstractAttributeType"/> key and
		/// <see cref="AbstractAttribute"/> value to the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <param name="key">The <see cref="AbstractAttributeType"/> key of the element
		/// to add to the <see cref="AttributeHashtable"/>.</param>
		/// <param name="value">The <see cref="AbstractAttribute"/> value of the element
		/// to add to the <see cref="AttributeHashtable"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentException">
		/// An element with the specified <paramref name="key"/>
		/// already exists in the <see cref="AttributeHashtable"/>.</exception>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="AttributeHashtable"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>AttributeHashtable</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.Add"/> for details.</remarks>

		public void Add(AbstractAttributeType key, AbstractAttribute value) 
		{
			this._innerHash.Add(key, value);
		}

		#endregion
		#region IDictionary.Add(Object, Object)

		/// <summary>
		/// Adds an element with the specified key and value
		/// to the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <param name="key">The key of the element to add to the <see cref="AttributeHashtable"/>.
		/// This argument must be compatible with <see cref="AbstractAttributeType"/>.</param>
		/// <param name="value">The value of the element to add to the <see cref="AttributeHashtable"/>.
		/// This argument must be compatible with <see cref="AbstractAttribute"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentException">
		/// An element with the specified <paramref name="key"/>
		/// already exists in the <see cref="AttributeHashtable"/>.</exception>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidCastException">
		/// <para><paramref name="key"/> is not compatible with <see cref="AbstractAttributeType"/>.</para>
		/// <para>-or-</para>
		/// <para><paramref name="value"/> is not compatible with <see cref="AbstractAttribute"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="AttributeHashtable"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>AttributeHashtable</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.Add"/> for details.</remarks>

		void IDictionary.Add(object key, object value) 
		{
			Add((AbstractAttributeType) key, (AbstractAttribute) value);
		}

		#endregion
		#region Clear

		/// <summary>
		/// Removes all elements from the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="AttributeHashtable"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>AttributeHashtable</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.Clear"/> for details.</remarks>

		public void Clear() 
		{
			this._innerHash.Clear();
		}

		#endregion
		#region Clone

		/// <summary>
		/// Creates a shallow copy of the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <returns>A shallow copy of the <see cref="AttributeHashtable"/>.</returns>
		/// <remarks>Please refer to <see cref="Hashtable.Clone"/> for details.</remarks>

		public object Clone() 
		{
			AttributeHashtable dictionary = new AttributeHashtable(Tag.Default);
			dictionary._innerHash = (Hashtable) this._innerHash.Clone();
			return dictionary;
		}

		#endregion
		#region Contains(AbstractAttributeType)

		/// <summary>
		/// Determines whether the <see cref="AttributeHashtable"/>
		/// contains the specified <see cref="AbstractAttributeType"/> key.
		/// </summary>
		/// <param name="key">The <see cref="AbstractAttributeType"/> key
		/// to locate in the <see cref="AttributeHashtable"/>.</param>
		/// <returns><c>true</c> if the <see cref="AttributeHashtable"/> contains an element
		/// with the specified <paramref name="key"/>; otherwise, <c>false</c>.</returns>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Hashtable.Contains"/> for details.</remarks>

		public bool Contains(AbstractAttributeType key) 
		{
			return this._innerHash.Contains(key);
		}

		#endregion
		#region IDictionary.Contains(Object)

		/// <summary>
		/// Determines whether the <see cref="AttributeHashtable"/> contains the specified key.
		/// </summary>
		/// <param name="key">The key to locate in the <see cref="AttributeHashtable"/>.
		/// This argument must be compatible with <see cref="AbstractAttributeType"/>.</param>
		/// <returns><c>true</c> if the <see cref="AttributeHashtable"/> contains an element
		/// with the specified <paramref name="key"/>; otherwise, <c>false</c>.</returns>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidCastException"><paramref name="key"/>
		/// is not compatible with <see cref="AbstractAttributeType"/>.</exception>
		/// <remarks>Please refer to <see cref="Hashtable.Contains"/> for details.</remarks>

		bool IDictionary.Contains(object key) 
		{
			return Contains((AbstractAttributeType) key);
		}

		#endregion
		#region ContainsKey

		/// <summary>
		/// Determines whether the <see cref="AttributeHashtable"/>
		/// contains the specified <see cref="AbstractAttributeType"/> key.
		/// </summary>
		/// <param name="key">The <see cref="AbstractAttributeType"/> key
		/// to locate in the <see cref="AttributeHashtable"/>.</param>
		/// <returns><c>true</c> if the <see cref="AttributeHashtable"/> contains an element
		/// with the specified <paramref name="key"/>; otherwise, <c>false</c>.</returns>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Hashtable.ContainsKey"/> for details.</remarks>

		public bool ContainsKey(AbstractAttributeType key) 
		{
			return this._innerHash.ContainsKey(key);
		}

		#endregion
		#region ContainsValue

		/// <summary>
		/// Determines whether the <see cref="AttributeHashtable"/>
		/// contains the specified <see cref="AbstractAttribute"/> value.
		/// </summary>
		/// <param name="value">The <see cref="AbstractAttribute"/> value
		/// to locate in the <see cref="AttributeHashtable"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns><c>true</c> if the <see cref="AttributeHashtable"/> contains an element
		/// with the specified <paramref name="value"/>; otherwise, <c>false</c>.</returns>
		/// <remarks>Please refer to <see cref="Hashtable.ContainsValue"/> for details.</remarks>

		public bool ContainsValue(AbstractAttribute value) 
		{
			return this._innerHash.ContainsValue(value);
		}

		#endregion
		#region CopyTo(AbstractAttributeTypeAbstractAttributeEntry[], Int32)

		/// <summary>
		/// Copies the entire <see cref="AttributeHashtable"/> to a one-dimensional <see cref="Array"/> of
		/// <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> elements, starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the destination of the
		/// <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> elements copied from the <see cref="AttributeHashtable"/>.
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
		/// The number of elements in the source <see cref="AttributeHashtable"/> is greater than
		/// the available space from <paramref name="arrayIndex"/> to the end of the destination
		/// <paramref name="array"/>.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.CopyTo"/> for details.</remarks>

		public void CopyTo(AbstractAttributeTypeAbstractAttributeEntry[] array, int arrayIndex) 
		{
			this._innerHash.CopyTo(array, arrayIndex);
		}

		#endregion
		#region ICollection.CopyTo(Array, Int32)

		/// <summary>
		/// Copies the entire <see cref="AttributeHashtable"/> to a one-dimensional <see cref="Array"/>,
		/// starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the destination of the
		/// <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> elements copied from the <see cref="AttributeHashtable"/>.
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
		/// The number of elements in the source <see cref="AttributeHashtable"/> is greater than
		/// the available space from <paramref name="arrayIndex"/> to the end of the destination
		/// <paramref name="array"/>.</para></exception>
		/// <exception cref="InvalidCastException">
		/// The <see cref="AbstractAttributeTypeAbstractAttributeEntry"/> type cannot be cast automatically
		/// to the type of the destination <paramref name="array"/>.</exception>
		/// <remarks>Please refer to <see cref="Hashtable.CopyTo"/> for details.</remarks>

		void ICollection.CopyTo(Array array, int arrayIndex) 
		{
			CheckTargetArray(array, arrayIndex);
			CopyTo((AbstractAttributeTypeAbstractAttributeEntry[]) array, arrayIndex);
		}

		#endregion
		#region GetEnumerator: IAbstractAttributeTypeAbstractAttributeEnumerator

		/// <summary>
		/// Returns an <see cref="IAbstractAttributeTypeAbstractAttributeEnumerator"/>
		/// that can iterate through the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <returns>An <see cref="IAbstractAttributeTypeAbstractAttributeEnumerator"/>
		/// for the entire <see cref="AttributeHashtable"/>.</returns>
		/// <remarks>Please refer to <see cref="Hashtable.GetEnumerator"/> for details.</remarks>

		public IAbstractAttributeTypeAbstractAttributeEnumerator GetEnumerator() 
		{
			return new Enumerator(this);
		}

		#endregion
		#region IDictionary.GetEnumerator: IDictionaryEnumerator

		/// <summary>
		/// Returns an <see cref="IDictionaryEnumerator"/> that can
		/// iterate through the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <returns>An <see cref="IDictionaryEnumerator"/>
		/// for the entire <see cref="AttributeHashtable"/>.</returns>
		/// <remarks>Please refer to <see cref="Hashtable.GetEnumerator"/> for details.</remarks>

		IDictionaryEnumerator IDictionary.GetEnumerator() 
		{
			return (IDictionaryEnumerator) GetEnumerator();
		}

		#endregion
		#region IEnumerable.GetEnumerator: IEnumerator

		/// <summary>
		/// Returns an <see cref="IEnumerator"/> that can
		/// iterate through the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <returns>An <see cref="IEnumerator"/>
		/// for the entire <see cref="AttributeHashtable"/>.</returns>
		/// <remarks>Please refer to <see cref="Hashtable.GetEnumerator"/> for details.</remarks>

		IEnumerator IEnumerable.GetEnumerator() 
		{
			return (IEnumerator) GetEnumerator();
		}

		#endregion
		#region Remove(AbstractAttributeType)

		/// <summary>
		/// Removes the element with the specified <see cref="AbstractAttributeType"/> key
		/// from the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <param name="key">The <see cref="AbstractAttributeType"/> key of the element
		/// to remove from the <see cref="AttributeHashtable"/>.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="AttributeHashtable"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>AttributeHashtable</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.Remove"/> for details.</remarks>

		public void Remove(AbstractAttributeType key) 
		{
			this._innerHash.Remove(key);
		}

		#endregion
		#region IDictionary.Remove(Object)

		/// <summary>
		/// Removes the element with the specified key
		/// from the <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <param name="key">The key of the element to remove from the <see cref="AttributeHashtable"/>.
		/// This argument must be compatible with <see cref="AbstractAttributeType"/>.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="key"/> is a null reference.</exception>
		/// <exception cref="InvalidCastException"><paramref name="key"/>
		/// is not compatible with <see cref="AbstractAttributeType"/>.</exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="AttributeHashtable"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>AttributeHashtable</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="Hashtable.Remove"/> for details.</remarks>

		void IDictionary.Remove(object key) 
		{
			Remove((AbstractAttributeType) key);
		}

		#endregion
		#region Synchronized

		/// <summary>
		/// Returns a synchronized (thread-safe) wrapper
		/// for the specified <see cref="AttributeHashtable"/>.
		/// </summary>
		/// <param name="dictionary">The <see cref="AttributeHashtable"/> to synchronize.</param>
		/// <returns>A synchronized (thread-safe) wrapper around <paramref name="dictionary"/>.</returns>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="dictionary"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Hashtable.Synchronized"/> for details.</remarks>

		public static AttributeHashtable Synchronized(AttributeHashtable dictionary) 
		{
			if (dictionary == null)
				throw new ArgumentNullException("dictionary");

			AttributeHashtable sync = new AttributeHashtable(Tag.Default);
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
			IAbstractAttributeTypeAbstractAttributeEnumerator, IDictionaryEnumerator 
		{
			#region Private Fields

			private readonly IDictionaryEnumerator _innerEnumerator;

			#endregion
			#region Internal Constructors

			internal Enumerator(AttributeHashtable dictionary) 
			{
				this._innerEnumerator = dictionary._innerHash.GetEnumerator();
			}

			#endregion
			#region Public Properties

			public AbstractAttributeTypeAbstractAttributeEntry Current 
			{
				get { return new AbstractAttributeTypeAbstractAttributeEntry(Key, Value); }
			}

			object IEnumerator.Current 
			{
				get { return this._innerEnumerator.Current; }
			}

			public AbstractAttributeTypeAbstractAttributeEntry Entry 
			{
				get { return new AbstractAttributeTypeAbstractAttributeEntry(Key, Value); }
			}

			DictionaryEntry IDictionaryEnumerator.Entry 
			{
				get { return this._innerEnumerator.Entry; }
			}

			public AbstractAttributeType Key 
			{
				get { return (AbstractAttributeType) this._innerEnumerator.Key; }
			}

			object IDictionaryEnumerator.Key 
			{
				get { return this._innerEnumerator.Key; }
			}

			public AbstractAttribute Value 
			{
				get { return (AbstractAttribute) this._innerEnumerator.Value; }
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
			IAbstractAttributeTypeCollection, ICollection 
		{
			#region Private Fields

			private AttributeHashtable _dictionary;

			#endregion
			#region Internal Constructors

			internal KeyList(AttributeHashtable dictionary) 
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

			public void CopyTo(AbstractAttributeType[] array, int arrayIndex) 
			{
				this._dictionary.CheckTargetArray(array, arrayIndex);
				foreach (AbstractAttributeTypeAbstractAttributeEntry pair in this._dictionary)
					array[arrayIndex++] = pair.Key;
			}

			void ICollection.CopyTo(Array array, int arrayIndex) 
			{
				this._dictionary.CheckTargetArray(array, arrayIndex);
				CopyTo((AbstractAttributeType[]) array, arrayIndex);
			}

			public IAbstractAttributeTypeEnumerator GetEnumerator() 
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
			IAbstractAttributeTypeEnumerator, IEnumerator 
		{
			#region Private Fields

			private readonly IEnumerator _innerEnumerator;

			#endregion
			#region Internal Constructors

			internal KeyEnumerator(AttributeHashtable dictionary) 
			{
				this._innerEnumerator = dictionary._innerHash.Keys.GetEnumerator();
			}

			#endregion
			#region Public Properties

			public AbstractAttributeType Current 
			{
				get { return (AbstractAttributeType) this._innerEnumerator.Current; }
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
			IAbstractAttributeCollection, ICollection 
		{
			#region Private Fields

			private AttributeHashtable _dictionary;

			#endregion
			#region Internal Constructors

			internal ValueList(AttributeHashtable dictionary) 
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

			public void CopyTo(AbstractAttribute[] array, int arrayIndex) 
			{
				this._dictionary.CheckTargetArray(array, arrayIndex);
				foreach (AbstractAttributeTypeAbstractAttributeEntry pair in this._dictionary)
					array[arrayIndex++] = pair.Value;
			}

			void ICollection.CopyTo(Array array, int arrayIndex) 
			{
				this._dictionary.CheckTargetArray(array, arrayIndex);
				CopyTo((AbstractAttribute[]) array, arrayIndex);
			}

			public IAbstractAttributeEnumerator GetEnumerator() 
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
			IAbstractAttributeEnumerator, IEnumerator 
		{
			#region Private Fields

			private readonly IEnumerator _innerEnumerator;

			#endregion
			#region Internal Constructors

			internal ValueEnumerator(AttributeHashtable dictionary) 
			{
				this._innerEnumerator = dictionary._innerHash.Values.GetEnumerator();
			}

			#endregion
			#region Public Properties

			public AbstractAttribute Current 
			{
				get { return (AbstractAttribute) this._innerEnumerator.Current; }
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

		#region ICustomTypeDescriptor Member

		public String GetClassName()
		{
			return TypeDescriptor.GetClassName(this,true);
		}

		public AttributeCollection GetAttributes()
		{
			return TypeDescriptor.GetAttributes(this,true);
		}

		public String GetComponentName()
		{
			return TypeDescriptor.GetComponentName(this, true);
		}

		public TypeConverter GetConverter()
		{
			return TypeDescriptor.GetConverter(this, true);
		}

		public EventDescriptor GetDefaultEvent() 
		{
			return TypeDescriptor.GetDefaultEvent(this, true);
		}

		public PropertyDescriptor GetDefaultProperty() 
		{
			return TypeDescriptor.GetDefaultProperty(this, true);
		}

		public object GetEditor(Type editorBaseType) 
		{
			return TypeDescriptor.GetEditor(this, editorBaseType, true);
		}

		public EventDescriptorCollection GetEvents(Attribute[] attributes) 
		{
			return TypeDescriptor.GetEvents(this, attributes, true);
		}

		public EventDescriptorCollection GetEvents()
		{
			return TypeDescriptor.GetEvents(this, true);
		}

		public object GetPropertyOwner(PropertyDescriptor pd) 
		{
			return this;
		}


		/// <summary>
		/// Called to get the properties of this type. Returns properties with certain
		/// attributes. this restriction is not implemented here.
		/// </summary>
		/// <param name="attributes"></param>
		/// <returns></returns>
		public PropertyDescriptorCollection GetProperties(Attribute[] attributes)
		{
			return GetProperties();
		}

		/// <summary>
		/// Called to get the properties of this type.
		/// </summary>
		/// <returns></returns>
		public PropertyDescriptorCollection GetProperties()
		{
			// Create a collection object to hold property descriptors
			PropertyDescriptorCollection pds = new PropertyDescriptorCollection(null);

			// Iterate the list of employees
			foreach(AbstractAttributeType attrType in this.Keys)
			{
				// Create a property descriptor for the employee item and add to the property descriptor collection
				AbstractAttributeTypeDescriptor pd = attrType.CreateTypeDescriptor(this[attrType]);
				//AbstractAttributeTypeDescriptor pd = new AbstractAttributeTypeDescriptor(this,attrType);
				pds.Add(pd);
			}
			// return the property descriptor collection
			return pds;
		}
		#endregion
	}

	#endregion
}
