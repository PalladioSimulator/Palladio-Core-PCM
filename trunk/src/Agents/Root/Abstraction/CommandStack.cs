#region Universität Oldenburg
//////////////////////////////////////////////////////////////////////////
//	Universität Oldenburg
//	Department für Informatik, Software Engineering
//	-----------------------------------------------------------------
//	Master-Arbeit "Entwicklung eines Editors für die modellgetriebene
//	Konstruktion komponentenbasierter Software-Architekturen"
//	Autor: Matthias Uflacker, 2004
//	eMail: matthias.uflacker@informatik.uni-oldenburg.de
//////////////////////////////////////////////////////////////////////////
#endregion

using System;
using System.Collections;

using Palladio.Editor.Common.Commands;

namespace Palladio.Editor.Core.Agents.Root.Abstraction
{
	#region Interface IICommandCollection

	/// <summary>
	/// Defines size, enumerators, and synchronization methods for strongly
	/// typed collections of <see cref="ICommand"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IICommandCollection</b> provides an <see cref="ICollection"/>
	/// that is strongly typed for <see cref="ICommand"/> elements.
	/// </remarks>

	internal interface IICommandCollection 
	{
		#region Properties
		#region Count

		/// <summary>
		/// Gets the number of elements contained in the
		/// <see cref="IICommandCollection"/>.
		/// </summary>
		/// <value>The number of elements contained in the
		/// <see cref="IICommandCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.Count"/> for details.</remarks>

		int Count { get; }

		#endregion
		#region IsSynchronized

		/// <summary>
		/// Gets a value indicating whether access to the
		/// <see cref="IICommandCollection"/> is synchronized (thread-safe).
		/// </summary>
		/// <value><c>true</c> if access to the <see cref="IICommandCollection"/> is
		/// synchronized (thread-safe); otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="ICollection.IsSynchronized"/> for details.</remarks>

		bool IsSynchronized { get; }

		#endregion
		#region SyncRoot

		/// <summary>
		/// Gets an object that can be used to synchronize access
		/// to the <see cref="IICommandCollection"/>.
		/// </summary>
		/// <value>An object that can be used to synchronize access
		/// to the <see cref="IICommandCollection"/>.</value>
		/// <remarks>Please refer to <see cref="ICollection.SyncRoot"/> for details.</remarks>

		object SyncRoot { get; }

		#endregion
		#endregion
		#region Methods
		#region CopyTo

		/// <summary>
		/// Copies the entire <see cref="IICommandCollection"/> to a one-dimensional <see cref="Array"/>
		/// of <see cref="ICommand"/> elements, starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the destination of the
		/// <see cref="ICommand"/> elements copied from the <see cref="IICommandCollection"/>.
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
		/// The number of elements in the source <see cref="IICommandCollection"/> is greater
		/// than the available space from <paramref name="arrayIndex"/> to the end of the destination
		/// <paramref name="array"/>.</para></exception>
		/// <remarks>Please refer to <see cref="ICollection.CopyTo"/> for details.</remarks>

		void CopyTo(ICommand[] array, int arrayIndex);

		#endregion
		#region GetEnumerator

		/// <summary>
		/// Returns an <see cref="IICommandEnumerator"/> that can
		/// iterate through the <see cref="IICommandCollection"/>.
		/// </summary>
		/// <returns>An <see cref="IICommandEnumerator"/>
		/// for the entire <see cref="IICommandCollection"/>.</returns>
		/// <remarks>Please refer to <see cref="IEnumerable.GetEnumerator"/> for details.</remarks>

		IICommandEnumerator GetEnumerator();

		#endregion
		#endregion
	}

	#endregion
	#region Interface IICommandList

	/// <summary>
	/// Represents a strongly typed collection of <see cref="ICommand"/>
	/// objects that can be individually accessed by index.
	/// </summary>
	/// <remarks>
	/// <b>IICommandList</b> provides an <see cref="IList"/>
	/// that is strongly typed for <see cref="ICommand"/> elements.
	/// </remarks>

	internal interface
		IICommandList: IICommandCollection 
	{
		#region Properties
		#region IsFixedSize

		/// <summary>
		/// Gets a value indicating whether the <see cref="IICommandList"/> has a fixed size.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IICommandList"/> has a fixed size;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsFixedSize"/> for details.</remarks>

		bool IsFixedSize { get; }

		#endregion
		#region IsReadOnly

		/// <summary>
		/// Gets a value indicating whether the <see cref="IICommandList"/> is read-only.
		/// </summary>
		/// <value><c>true</c> if the <see cref="IICommandList"/> is read-only;
		/// otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="IList.IsReadOnly"/> for details.</remarks>

		bool IsReadOnly { get; }

		#endregion
		#region Item

		/// <summary>
		/// Gets or sets the <see cref="ICommand"/> element at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index of the
		/// <see cref="ICommand"/> element to get or set.</param>
		/// <value>
		/// The <see cref="ICommand"/> element at the specified <paramref name="index"/>.
		/// </value>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IICommandCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// The property is set and the <see cref="IICommandList"/> is read-only.</exception>
		/// <remarks>Please refer to <see cref="IList.this"/> for details.</remarks>

		ICommand this[int index] { get; set; }

		#endregion
		#endregion
		#region Methods
		#region Add

		/// <summary>
		/// Adds a <see cref="ICommand"/> to the end
		/// of the <see cref="IICommandList"/>.
		/// </summary>
		/// <param name="value">The <see cref="ICommand"/> object
		/// to be added to the end of the <see cref="IICommandList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns>The <see cref="IICommandList"/> index at which
		/// the <paramref name="value"/> has been added.</returns>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IICommandList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IICommandList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Add"/> for details.</remarks>

		int Add(ICommand value);

		#endregion
		#region Clear

		/// <summary>
		/// Removes all elements from the <see cref="IICommandList"/>.
		/// </summary>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IICommandList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IICommandList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Clear"/> for details.</remarks>

		void Clear();

		#endregion
		#region Contains

		/// <summary>
		/// Determines whether the <see cref="IICommandList"/>
		/// contains the specified <see cref="ICommand"/> element.
		/// </summary>
		/// <param name="value">The <see cref="ICommand"/> object
		/// to locate in the <see cref="IICommandList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns><c>true</c> if <paramref name="value"/> is found in the
		/// <see cref="IICommandList"/>; otherwise, <c>false</c>.</returns>
		/// <remarks>Please refer to <see cref="IList.Contains"/> for details.</remarks>

		bool Contains(ICommand value);

		#endregion
		#region IndexOf

		/// <summary>
		/// Returns the zero-based index of the first occurrence of the specified
		/// <see cref="ICommand"/> in the <see cref="IICommandList"/>.
		/// </summary>
		/// <param name="value">The <see cref="ICommand"/> object
		/// to locate in the <see cref="IICommandList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns>
		/// The zero-based index of the first occurrence of <paramref name="value"/>
		/// in the <see cref="IICommandList"/>, if found; otherwise, -1.
		/// </returns>
		/// <remarks>Please refer to <see cref="IList.IndexOf"/> for details.</remarks>

		int IndexOf(ICommand value);

		#endregion
		#region Insert

		/// <summary>
		/// Inserts a <see cref="ICommand"/> element into the
		/// <see cref="IICommandList"/> at the specified index.
		/// </summary>
		/// <param name="index">The zero-based index at which
		/// <paramref name="value"/> should be inserted.</param>
		/// <param name="value">The <see cref="ICommand"/> object
		/// to insert into the <see cref="IICommandList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is greater than
		/// <see cref="IICommandCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IICommandList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IICommandList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Insert"/> for details.</remarks>

		void Insert(int index, ICommand value);

		#endregion
		#region Remove

		/// <summary>
		/// Removes the first occurrence of the specified <see cref="ICommand"/>
		/// from the <see cref="IICommandList"/>.
		/// </summary>
		/// <param name="value">The <see cref="ICommand"/> object
		/// to remove from the <see cref="IICommandList"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IICommandList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IICommandList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.Remove"/> for details.</remarks>

		void Remove(ICommand value);

		#endregion
		#region RemoveAt

		/// <summary>
		/// Removes the element at the specified index of the
		/// <see cref="IICommandList"/>.
		/// </summary>
		/// <param name="index">The zero-based index of the element to remove.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <para><paramref name="index"/> is less than zero.</para>
		/// <para>-or-</para>
		/// <para><paramref name="index"/> is equal to or greater than
		/// <see cref="IICommandCollection.Count"/>.</para>
		/// </exception>
		/// <exception cref="NotSupportedException">
		/// <para>The <see cref="IICommandList"/> is read-only.</para>
		/// <para>-or-</para>
		/// <para>The <b>IICommandList</b> has a fixed size.</para></exception>
		/// <remarks>Please refer to <see cref="IList.RemoveAt"/> for details.</remarks>

		void RemoveAt(int index);

		#endregion
		#endregion
	}

	#endregion
	#region Interface IICommandEnumerator

	/// <summary>
	/// Supports type-safe iteration over a collection that
	/// contains <see cref="ICommand"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>IICommandEnumerator</b> provides an <see cref="IEnumerator"/>
	/// that is strongly typed for <see cref="ICommand"/> elements.
	/// </remarks>

	internal interface IICommandEnumerator 
	{
		#region Properties
		#region Current

		/// <summary>
		/// Gets the current <see cref="ICommand"/> element in the collection.
		/// </summary>
		/// <value>The current <see cref="ICommand"/> element in the collection.</value>
		/// <exception cref="InvalidOperationException"><para>The enumerator is positioned
		/// before the first element of the collection or after the last element.</para>
		/// <para>-or-</para>
		/// <para>The collection was modified after the enumerator was created.</para></exception>
		/// <remarks>Please refer to <see cref="IEnumerator.Current"/> for details, but note
		/// that <b>Current</b> fails if the collection was modified since the last successful
		/// call to <see cref="MoveNext"/> or <see cref="Reset"/>.</remarks>

		ICommand Current { get; }

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
	#region Class CommandStack

	/// <summary>
	/// Implements a strongly typed stack of <see cref="ICommand"/> elements.
	/// </summary>
	/// <remarks>
	/// <b>CommandStack</b> provides a <see cref="Stack"/>
	/// that is strongly typed for <see cref="ICommand"/> elements.
	/// </remarks>

	[Serializable]
	internal class CommandStack:
		IICommandCollection, ICollection, ICloneable 
	{
		#region Private Fields

		private const int _defaultCapacity = 10;

		private ICommand[] _array = null;
		private int _count = 0;

		[NonSerialized]
		private int _version = 0;

		#endregion
		#region Private Constructors

		// helper type to identify private ctor
		private enum Tag { Default }

		private CommandStack(Tag tag) { }

		#endregion
		#region Public Constructors
		#region CommandStack()

		/// <overloads>
		/// Initializes a new instance of the <see cref="CommandStack"/> class.
		/// </overloads>
		/// <summary>
		/// Initializes a new instance of the <see cref="CommandStack"/> class
		/// that is empty and has the default initial capacity.
		/// </summary>
		/// <remarks>Please refer to <see cref="Stack()"/> for details.</remarks>

		public CommandStack() 
		{
			this._array = new ICommand[_defaultCapacity];
		}

		#endregion
		#region CommandStack(Int32)

		/// <summary>
		/// Initializes a new instance of the <see cref="CommandStack"/> class
		/// that is empty and has the specified initial capacity or the default initial
		/// capacity, whichever is greater..
		/// </summary>
		/// <param name="capacity">The number of elements that the new
		/// <see cref="CommandStack"/> is initially capable of storing.</param>
		/// <exception cref="ArgumentOutOfRangeException">
		/// <paramref name="capacity"/> is less than zero.</exception>
		/// <remarks>Please refer to <see cref="Stack(Int32)"/> for details.</remarks>

		public CommandStack(int capacity) 
		{
			if (capacity < 0)
				throw new ArgumentOutOfRangeException("capacity",
					capacity, "Argument cannot be negative.");

			if (capacity < _defaultCapacity)
				capacity = _defaultCapacity;

			this._array = new ICommand[capacity];
		}

		#endregion
		#region CommandStack(IICommandCollection)

		/// <summary>
		/// Initializes a new instance of the <see cref="CommandStack"/> class
		/// that contains elements copied from the specified collection and
		/// that has the same initial capacity as the number of elements copied.
		/// </summary>
		/// <param name="collection">The <see cref="IICommandCollection"/>
		/// whose elements are copied to the new collection.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="collection"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Stack(ICollection)"/> for details.</remarks>

		public CommandStack(IICommandCollection collection) 
		{
			if (collection == null)
				throw new ArgumentNullException("collection");

			this._array = new ICommand[collection.Count];
			foreach (ICommand item in collection)
				Push(item);
		}

		#endregion
		#region CommandStack(ICommand[])

		/// <summary>
		/// Initializes a new instance of the <see cref="CommandStack"/> class
		/// that contains elements copied from the specified <see cref="ICommand"/>
		/// array and that has the same initial capacity as the number of elements copied.
		/// </summary>
		/// <param name="array">An <see cref="Array"/> of <see cref="ICommand"/>
		/// elements that are copied to the new collection.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="array"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Stack(ICollection)"/> for details.</remarks>

		public CommandStack(ICommand[] array) 
		{
			if (array == null)
				throw new ArgumentNullException("array");

			this._array = new ICommand[array.Length];
			foreach (ICommand item in array)
				Push(item);
		}

		#endregion
		#endregion
		#region Public Properties
		#region Count

		/// <summary>
		/// Gets the number of elements contained in the <see cref="CommandStack"/>.
		/// </summary>
		/// <value>
		/// The number of elements contained in the <see cref="CommandStack"/>.
		/// </value>
		/// <remarks>Please refer to <see cref="Stack.Count"/> for details.</remarks>

		public virtual int Count 
		{
			get { return this._count; }
		}

		#endregion
		#region IsSynchronized

		/// <summary>
		/// Gets a value indicating whether access to the <see cref="CommandStack"/>
		/// is synchronized (thread-safe).
		/// </summary>
		/// <value><c>true</c> if access to the <see cref="CommandStack"/> is
		/// synchronized (thread-safe); otherwise, <c>false</c>. The default is <c>false</c>.</value>
		/// <remarks>Please refer to <see cref="Stack.IsSynchronized"/> for details.</remarks>

		public virtual bool IsSynchronized 
		{
			get { return false; }
		}

		#endregion
		#region SyncRoot

		/// <summary>
		/// Gets an object that can be used to synchronize
		/// access to the <see cref="CommandStack"/>.
		/// </summary>
		/// <value>An object that can be used to synchronize
		/// access to the <see cref="CommandStack"/>.
		/// </value>
		/// <remarks>Please refer to <see cref="Stack.SyncRoot"/> for details.</remarks>

		public virtual object SyncRoot 
		{
			get { return this; }
		}

		#endregion
		#endregion
		#region Public Methods
		#region Clear

		/// <summary>
		/// Removes all elements from the <see cref="CommandStack"/>.
		/// </summary>
		/// <remarks>Please refer to <see cref="Stack.Clear"/> for details.</remarks>

		public virtual void Clear() 
		{
			if (this._count == 0) return;

			++this._version;
			Array.Clear(this._array, 0, this._count);
			this._count = 0;
		}

		#endregion
		#region Clone

		/// <summary>
		/// Creates a shallow copy of the <see cref="CommandStack"/>.
		/// </summary>
		/// <returns>A shallow copy of the <see cref="CommandStack"/>.</returns>
		/// <remarks>Please refer to <see cref="Stack.Clone"/> for details.</remarks>

		public virtual object Clone() 
		{
			CommandStack collection = new CommandStack(this._count);

			Array.Copy(this._array, 0, collection._array, 0, this._count);
			collection._count = this._count;
			collection._version = this._version;

			return collection;
		}

		#endregion
		#region Contains

		/// <summary>
		/// Determines whether the <see cref="CommandStack"/>
		/// contains the specified <see cref="ICommand"/> element.
		/// </summary>
		/// <param name="value">The <see cref="ICommand"/> object
		/// to locate in the <see cref="CommandStack"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <returns><c>true</c> if <paramref name="value"/> is found in the
		/// <see cref="CommandStack"/>; otherwise, <c>false</c>.</returns>
		/// <remarks>Please refer to <see cref="Stack.Contains"/> for details.</remarks>

		public virtual bool Contains(ICommand value) 
		{
			return (Array.IndexOf(this._array, value, 0, this._count) >= 0);
		}

		#endregion
		#region CopyTo(ICommand[])

		/// <overloads>
		/// Copies the <see cref="CommandStack"/> or a portion of it to a one-dimensional array.
		/// </overloads>
		/// <summary>
		/// Copies the entire <see cref="CommandStack"/> to a one-dimensional <see cref="Array"/>
		/// of <see cref="ICommand"/> elements, starting at the beginning of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the destination of the
		/// <see cref="ICommand"/> elements copied from the <see cref="CommandStack"/>.
		/// The <b>Array</b> must have zero-based indexing.</param>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="array"/> is a null reference.</exception>
		/// <exception cref="ArgumentException">
		/// The number of elements in the source <see cref="CommandStack"/> is greater
		/// than the available space in the destination <paramref name="array"/>.</exception>
		/// <remarks>Please refer to <see cref="Stack.CopyTo"/> for details.</remarks>

		public virtual void CopyTo(ICommand[] array) 
		{
			CheckTargetArray(array, 0);
			Array.Copy(this._array, array, this._count);
			Array.Reverse(array, 0, this._count);
		}

		#endregion
		#region CopyTo(ICommand[], Int32)

		/// <summary>
		/// Copies the entire <see cref="CommandStack"/> to a one-dimensional <see cref="Array"/>
		/// of <see cref="ICommand"/> elements, starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the destination of the
		/// <see cref="ICommand"/> elements copied from the <see cref="CommandStack"/>.
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
		/// The number of elements in the source <see cref="CommandStack"/> is greater than the
		/// available space from <paramref name="arrayIndex"/> to the end of the destination
		/// <paramref name="array"/>.</para></exception>
		/// <remarks>Please refer to <see cref="Stack.CopyTo"/> for details.</remarks>

		public virtual void CopyTo(ICommand[] array, int arrayIndex) 
		{
			CheckTargetArray(array, arrayIndex);
			Array.Copy(this._array, 0, array, arrayIndex, this._count);
			Array.Reverse(array, arrayIndex, this._count);
		}

		#endregion
		#region ICollection.CopyTo(Array, Int32)

		/// <summary>
		/// Copies the entire <see cref="CommandStack"/> to a one-dimensional <see cref="Array"/>,
		/// starting at the specified index of the target array.
		/// </summary>
		/// <param name="array">The one-dimensional <see cref="Array"/> that is the destination of the
		/// <see cref="ICommand"/> elements copied from the <see cref="CommandStack"/>.
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
		/// The number of elements in the source <see cref="CommandStack"/> is greater than the
		/// available space from <paramref name="arrayIndex"/> to the end of the destination
		/// <paramref name="array"/>.</para></exception>
		/// <exception cref="InvalidCastException">
		/// The <see cref="ICommand"/> type cannot be cast automatically
		/// to the type of the destination <paramref name="array"/>.</exception>
		/// <remarks>Please refer to <see cref="Stack.CopyTo"/> for details.</remarks>

		void ICollection.CopyTo(Array array, int arrayIndex) 
		{
			CopyTo((ICommand[]) array, arrayIndex);
		}

		#endregion
		#region GetEnumerator: IICommandEnumerator

		/// <summary>
		/// Returns an <see cref="IICommandEnumerator"/> that can
		/// iterate through the <see cref="CommandStack"/>.
		/// </summary>
		/// <returns>An <see cref="IICommandEnumerator"/>
		/// for the entire <see cref="CommandStack"/>.</returns>
		/// <remarks>Please refer to <see cref="Stack.GetEnumerator"/> for details.</remarks>

		public virtual IICommandEnumerator GetEnumerator() 
		{
			return new Enumerator(this);
		}

		#endregion
		#region IEnumerable.GetEnumerator: IEnumerator

		/// <summary>
		/// Returns an <see cref="IEnumerator"/> that can
		/// iterate through the <see cref="CommandStack"/>.
		/// </summary>
		/// <returns>An <see cref="IEnumerator"/>
		/// for the entire <see cref="CommandStack"/>.</returns>
		/// <remarks>Please refer to <see cref="Stack.GetEnumerator"/> for details.</remarks>

		IEnumerator IEnumerable.GetEnumerator() 
		{
			return (IEnumerator) GetEnumerator();
		}

		#endregion
		#region Peek

		/// <summary>
		/// Returns the <see cref="ICommand"/> element at the top
		/// of the <see cref="CommandStack"/> without removing it.
		/// </summary>
		/// <returns>The <see cref="ICommand"/> object
		/// at the top of the <see cref="CommandStack"/>.</returns>
		/// <exception cref="InvalidOperationException">
		/// The <see cref="CommandStack"/> is empty.</exception>
		/// <remarks>Please refer to <see cref="Stack.Peek"/> for details.</remarks>

		public virtual ICommand Peek() 
		{
			if (this._count == 0)
				throw new InvalidOperationException("Collection is empty.");

			return this._array[this._count - 1];
		}

		#endregion
		#region Pop

		/// <summary>
		/// Removes and returns the <see cref="ICommand"/> element
		/// at the top of the <see cref="CommandStack"/>.
		/// </summary>
		/// <returns>The <see cref="ICommand"/> object removed
		/// from the top of the <see cref="CommandStack"/>.</returns>
		/// <exception cref="InvalidOperationException">
		/// The <see cref="CommandStack"/> is empty.</exception>
		/// <remarks>Please refer to <see cref="Stack.Pop"/> for details.</remarks>

		public virtual ICommand Pop() 
		{
			if (this._count == 0)
				throw new InvalidOperationException("Collection is empty.");

			++this._version;
			return this._array[--this._count];
		}

		#endregion
		#region Push

		/// <summary>
		/// Inserts a <see cref="ICommand"/> at the top of the <see cref="CommandStack"/>.
		/// </summary>
		/// <param name="value">The <see cref="ICommand"/> object
		/// to push onto the <see cref="CommandStack"/>.
		/// This argument can be a null reference.
		/// </param>
		/// <remarks>Please refer to <see cref="Stack.Push"/> for details.</remarks>

		public virtual void Push(ICommand value) 
		{

			if (this._count == this._array.Length) 
			{
				ICommand[] newArray = new ICommand[2 * this._array.Length];
				Array.Copy(this._array, newArray, this._count);
				this._array = newArray;
			}

			++this._version;
			this._array[this._count++] = value;
		}

		#endregion
		#region Synchronized

		/// <summary>
		/// Returns a synchronized (thread-safe) wrapper
		/// for the specified <see cref="CommandStack"/>.
		/// </summary>
		/// <param name="collection">The <see cref="CommandStack"/> to synchronize.</param>
		/// <returns>
		/// A synchronized (thread-safe) wrapper around <paramref name="collection"/>.
		/// </returns>
		/// <exception cref="ArgumentNullException">
		/// <paramref name="collection"/> is a null reference.</exception>
		/// <remarks>Please refer to <see cref="Stack.Synchronized"/> for details.</remarks>

		public static CommandStack Synchronized(CommandStack collection) 
		{
			if (collection == null)
				throw new ArgumentNullException("collection");

			return new SyncStack(collection);
		}

		#endregion
		#region ToArray

		/// <summary>
		/// Copies the elements of the <see cref="CommandStack"/> to a new
		/// <see cref="Array"/> of <see cref="ICommand"/> elements.
		/// </summary>
		/// <returns>A one-dimensional <see cref="Array"/> of <see cref="ICommand"/>
		/// elements containing copies of the elements of the <see cref="CommandStack"/>.</returns>
		/// <remarks>Please refer to <see cref="Stack.ToArray"/> for details.</remarks>

		public virtual ICommand[] ToArray() 
		{
			ICommand[] array = new ICommand[this._count];
			Array.Copy(this._array, array, this._count);
			Array.Reverse(array);
			return array;
		}

		#endregion
		#endregion
		#region Private Methods
		#region CheckEnumIndex

		private void CheckEnumIndex(int index) 
		{
			if (index < 0 || index >= this._count)
				throw new InvalidOperationException(
					"Enumerator is not on a collection element.");
		}

		#endregion
		#region CheckEnumVersion

		private void CheckEnumVersion(int version) 
		{
			if (version != this._version)
				throw new InvalidOperationException(
					"Enumerator invalidated by modification to collection.");
		}

		#endregion
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

			if (this._count > array.Length - arrayIndex)
				throw new ArgumentException(
					"Argument section must be large enough for collection.", "array");
		}

		#endregion
		#endregion
		#region Class Enumerator

		[Serializable]
			private sealed class Enumerator:
			IICommandEnumerator, IEnumerator 
		{
			#region Private Fields

			private readonly CommandStack _collection;
			private readonly int _version;
			private int _index;

			#endregion
			#region Internal Constructors

			internal Enumerator(CommandStack collection) 
			{
				this._collection = collection;
				this._version = collection._version;
				this._index = collection.Count;
			}

			#endregion
			#region Public Properties

			public ICommand Current 
			{
				get 
				{
					this._collection.CheckEnumIndex(this._index);
					this._collection.CheckEnumVersion(this._version);
					return this._collection._array[this._index];
				}
			}

			object IEnumerator.Current 
			{
				get { return Current; }
			}

			#endregion
			#region Public Methods

			public bool MoveNext() 
			{
				this._collection.CheckEnumVersion(this._version);
				return (--this._index >= 0);
			}

			public void Reset() 
			{
				this._collection.CheckEnumVersion(this._version);
				this._index = this._collection.Count;
			}

			#endregion
		}

		#endregion
		#region Class SyncStack

		[Serializable]
			private sealed class SyncStack: CommandStack 
		{
			#region Private Fields

			private CommandStack _collection;
			private object _root;

			#endregion
			#region Internal Constructors

			internal SyncStack(CommandStack collection):
				base(Tag.Default) 
			{

				this._root = collection.SyncRoot;
				this._collection = collection;
			}

			#endregion
			#region Public Properties

			public override int Count 
			{
				get { lock (this._root) return this._collection.Count; }
			}

			public override bool IsSynchronized 
			{
				get { return true; }
			}

			public override object SyncRoot 
			{
				get { return this._root; }
			}

			#endregion
			#region Public Methods

			public override void Clear() 
			{
				lock (this._root) this._collection.Clear();
			}

			public override object Clone() 
			{
				lock (this._root)
					return new SyncStack((CommandStack) this._collection.Clone());
			}

			public override bool Contains(ICommand value) 
			{
				lock (this._root) return this._collection.Contains(value);
			}

			public override void CopyTo(ICommand[] array) 
			{
				lock (this._root) this._collection.CopyTo(array);
			}

			public override void CopyTo(ICommand[] array, int arrayIndex) 
			{
				lock (this._root) this._collection.CopyTo(array, arrayIndex);
			}

			public override IICommandEnumerator GetEnumerator() 
			{
				lock (this._root) return this._collection.GetEnumerator();
			}

			public override ICommand Peek() 
			{
				lock (this._root) return this._collection.Peek();
			}

			public override ICommand Pop() 
			{
				lock (this._root) return this._collection.Pop();
			}

			public override void Push(ICommand value) 
			{
				lock (this._root) this._collection.Push(value);
			}

			public override ICommand[] ToArray() 
			{
				lock (this._root) return this._collection.ToArray();
			}

			#endregion
		}

		#endregion
	}

	#endregion
}
