//------------------------------------------------------------------------------
//
// Copyright (c) 2002-2004 Eric J. Smith.  All rights reserved.
// 
// The terms of use for this software are contained in the file
// named sourcelicense.txt, which can be found in the root of this distribution.
// By using this software in any fashion, you are agreeing to be bound by the
// terms of this license.
// 
// You must not remove this notice, or any other, from this software.
//
//------------------------------------------------------------------------------

using System;
using System.Collections;
using System.ComponentModel;
using System.Text;

namespace CodeSmith.CustomProperties
{
	[TypeConverter(typeof(StringCollectionTypeConverter))]
	[Serializable]
	[Editor(typeof(CodeSmith.CustomProperties.StringCollectionEditor), typeof(System.Drawing.Design.UITypeEditor))]
	public class StringCollection : ICollection, IList, IEnumerable, ICloneable
	{
		#region Interfaces
		/// <summary>
		///		Supports type-safe iteration over a <see cref="StringCollection"/>.
		/// </summary>
		public interface IStringCollectionEnumerator
		{
			string Current {get;}

			bool MoveNext();

			void Reset();
		}
		#endregion
		
		private const int DEFAULT_CAPACITY = 16;
		
		#region Implementation (data)
		private string[] m_array;
		private int m_count = 0;
		[NonSerialized]
		private int m_version = 0;
		#endregion
		
		#region Static Wrappers
		public static StringCollection Synchronized(StringCollection list)
		{
			if(list==null)
				throw new ArgumentNullException("list");
			return new SyncStringCollection(list);
		}
        
		public static StringCollection ReadOnly(StringCollection list)
		{
			if(list==null)
				throw new ArgumentNullException("list");
			return new ReadOnlyStringCollection(list);
		}
		#endregion
		
		#region Construction
		public StringCollection()
		{
			m_array = new string[DEFAULT_CAPACITY];
		}
		
		public StringCollection(int capacity)
		{
			m_array = new string[capacity];
		}

		public StringCollection(StringCollection c)
		{
			m_array = new string[c.Count];
			AddRange(c);
		}

		public StringCollection(string[] a)
		{
			m_array = new string[a.Length];
			AddRange(a);
		}
		
		protected enum Tag 
		{
			Default
		}

		protected StringCollection(Tag t)
		{
			m_array = null;
		}
		#endregion
		
		#region Operations (type-safe ICollection)
		public virtual int Count
		{
			get { return m_count; }
		}

		public virtual void CopyTo(string[] array)
		{
			this.CopyTo(array, 0);
		}

		public virtual void CopyTo(string[] array, int start)
		{
			if (m_count > array.GetUpperBound(0) + 1 - start)
				throw new System.ArgumentException("Destination array was not long enough.");
			
			Array.Copy(m_array, 0, array, start, m_count); 
		}

		public virtual bool IsSynchronized
		{
			get { return m_array.IsSynchronized; }
		}

		public virtual object SyncRoot
		{
			get { return m_array.SyncRoot; }
		}
		#endregion
		
		#region Operations (type-safe IList)
		public virtual string this[int index]
		{
			get
			{
				ValidateIndex(index); // throws
				return m_array[index]; 
			}
			set
			{
				ValidateIndex(index); // throws
				++m_version; 
				m_array[index] = value; 
			}
		}

		public virtual int Add(string item)
		{
			if (m_count == m_array.Length)
				EnsureCapacity(m_count + 1);

			m_array[m_count] = item;
			m_version++;

			return m_count++;
		}
		
		public virtual void Clear()
		{
			++m_version;
			m_array = new string[DEFAULT_CAPACITY];
			m_count = 0;
		}
		
		public virtual object Clone()
		{
			StringCollection newColl = new StringCollection(m_count);
			Array.Copy(m_array, 0, newColl.m_array, 0, m_count);
			newColl.m_count = m_count;
			newColl.m_version = m_version;

			return newColl;
		}

		public virtual bool Contains(string item)
		{
			for (int i=0; i != m_count; ++i)
				if (m_array[i].Equals(item))
					return true;
			return false;
		}

		public virtual int IndexOf(string item)
		{
			for (int i=0; i != m_count; ++i)
				if (m_array[i].Equals(item))
					return i;
			return -1;
		}

		public virtual void Insert(int index, string item)
		{
			ValidateIndex(index, true); // throws
			
			if (m_count == m_array.Length)
				EnsureCapacity(m_count + 1);

			if (index < m_count)
			{
				Array.Copy(m_array, index, m_array, index + 1, m_count - index);
			}

			m_array[index] = item;
			m_count++;
			m_version++;
		}

		public virtual void Remove(string item)
		{		   
			int i = IndexOf(item);
			if (i < 0)
				throw new System.ArgumentException("Cannot remove the specified item because it was not found in the specified Collection.");
			
			++m_version;
			RemoveAt(i);
		}

		public virtual void RemoveAt(int index)
		{
			ValidateIndex(index); // throws
			
			m_count--;

			if (index < m_count)
			{
				Array.Copy(m_array, index + 1, m_array, index, m_count - index);
			}
			
			// We can't set the deleted entry equal to null, because it might be a value type.
			// Instead, we'll create an empty single-element array of the right type and copy it 
			// over the entry we want to erase.
			string[] temp = new string[1];
			Array.Copy(temp, 0, m_array, m_count, 1);
			m_version++;
		}

		public virtual bool IsFixedSize
		{
			get { return false; }
		}

		public virtual bool IsReadOnly
		{
			get { return false; }
		}
		#endregion
		
		#region Operations (type-safe IEnumerable)
		
		public virtual IStringCollectionEnumerator GetEnumerator()
		{
			return new Enumerator(this);
		}
		#endregion
		
		#region Public helpers (just to mimic some nice features of ArrayList)
		
		public virtual int Capacity
		{
			get { return m_array.Length; }
			
			set
			{
				if (value < m_count)
					value = m_count;

				if (value != m_array.Length)
				{
					if (value > 0)
					{
						string[] temp = new string[value];
						Array.Copy(m_array, temp, m_count);
						m_array = temp;
					}
					else
					{
						m_array = new string[DEFAULT_CAPACITY];
					}
				}
			}
		}

		public virtual int AddRange(StringCollection x)
		{
			if (m_count + x.Count >= m_array.Length)
				EnsureCapacity(m_count + x.Count);
			
			Array.Copy(x.m_array, 0, m_array, m_count, x.Count);
			m_count += x.Count;
			m_version++;

			return m_count;
		}

		public virtual int AddRange(string[] x)
		{
			if (m_count + x.Length >= m_array.Length)
				EnsureCapacity(m_count + x.Length);

			Array.Copy(x, 0, m_array, m_count, x.Length);
			m_count += x.Length;
			m_version++;

			return m_count;
		}
		
		public virtual void TrimToSize()
		{
			this.Capacity = m_count;
		}
		
		public string[] ToArray()
		{
			string[] strings = new string[this.Count];
			
			for (int i = 0; i < this.Count; i++)
			{
				strings[i] = this[i];
			}
			
			return strings;
		}
		
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < this.Count; i++)
			{
				if (this[i].IndexOf(',') >= 0)
				{
					sb.AppendFormat("\"{0}\"", this[i].Replace("\"", "\"\""));
				}
				else
				{
					sb.Append(this[i]);
				}
				if (i < this.Count - 1) sb.Append(",");
			}
			
			return sb.ToString();
		}
		#endregion
		
		#region Implementation (helpers)

		private void ValidateIndex(int i)
		{
			ValidateIndex(i, false);
		}

		private void ValidateIndex(int i, bool allowEqualEnd)
		{
			int max = (allowEqualEnd)?(m_count):(m_count-1);
			if (i < 0 || i > max)
				throw new System.ArgumentOutOfRangeException("Index was out of range.  Must be non-negative and less than the size of the collection.", (object)i, "Specified argument was out of the range of valid values.");
		}

		private void EnsureCapacity(int min)
		{
			int newCapacity = ((m_array.Length == 0) ? DEFAULT_CAPACITY : m_array.Length * 2);
			if (newCapacity < min)
				newCapacity = min;

			this.Capacity = newCapacity;
		}

		#endregion
		
		#region Implementation (ICollection)

		void ICollection.CopyTo(Array array, int start)
		{
			Array.Copy(m_array, 0, array, start, m_count);
		}

		#endregion
		
		#region Implementation (IList)

		object IList.this[int i]
		{
			get { return (object)this[i]; }
			set { this[i] = (string)value; }
		}

		int IList.Add(object x)
		{
			return this.Add((string)x);
		}

		bool IList.Contains(object x)
		{
			return this.Contains((string)x);
		}

		int IList.IndexOf(object x)
		{
			return this.IndexOf((string)x);
		}

		void IList.Insert(int pos, object x)
		{
			this.Insert(pos, (string)x);
		}

		void IList.Remove(object x)
		{
			this.Remove((string)x);
		}

		void IList.RemoveAt(int pos)
		{
			this.RemoveAt(pos);
		}

		#endregion
		
		#region Implementation (IEnumerable)

		IEnumerator IEnumerable.GetEnumerator()
		{
			return (IEnumerator)(this.GetEnumerator());
		}

		#endregion
		
		#region Nested enumerator class
		private class Enumerator : IEnumerator, IStringCollectionEnumerator
		{
			#region Implementation (data)
			
			private StringCollection m_collection;
			private int m_index;
			private int m_version;
			
			#endregion
		
			#region Construction
			
			internal Enumerator(StringCollection tc)
			{
				m_collection = tc;
				m_index = -1;
				m_version = tc.m_version;
			}
			
			#endregion
	
			#region Operations (type-safe IEnumerator)
			
			public string Current
			{
				get { return m_collection[m_index]; }
			}

			public bool MoveNext()
			{
				if (m_version != m_collection.m_version)
					throw new System.InvalidOperationException("Collection was modified; enumeration operation may not execute.");

				++m_index;
				return (m_index < m_collection.Count) ? true : false;
			}

			public void Reset()
			{
				m_index = -1;
			}
			#endregion
	
			#region Implementation (IEnumerator)
			
			object IEnumerator.Current
			{
				get { return (object)(this.Current); }
			}
			
			#endregion
		}
		#endregion
		
		#region Nested Syncronized Wrapper class
		private class SyncStringCollection : StringCollection
		{
			#region Implementation (data)
			private StringCollection m_collection;
			private object m_root;
			#endregion

			#region Construction
			internal SyncStringCollection(StringCollection list) : base(Tag.Default)
			{
				m_root = list.SyncRoot;
				m_collection = list;
			}
			#endregion
            
			#region Type-safe ICollection
			public override void CopyTo(string[] array)
			{
				lock(this.m_root)
					m_collection.CopyTo(array);
			}

			public override void CopyTo(string[] array, int start)
			{
				lock(this.m_root)
					m_collection.CopyTo(array,start);
			}
			public override int Count
			{
				get
				{ 
					lock(this.m_root)
						return m_collection.Count;
				}
			}

			public override bool IsSynchronized
			{
				get { return true; }
			}

			public override object SyncRoot
			{
				get { return this.m_root; }
			}
			#endregion
            
			#region Type-safe IList
			public override string this[int i]
			{
				get
				{
					lock(this.m_root)
						return m_collection[i];
				}
				set
				{
					lock(this.m_root)
						m_collection[i] = value; 
				}
			}

			public override int Add(string x)
			{
				lock(this.m_root)
					return m_collection.Add(x);
			}
            
			public override void Clear()
			{
				lock(this.m_root)
					m_collection.Clear();
			}

			public override bool Contains(string x)
			{
				lock(this.m_root)
					return m_collection.Contains(x);
			}

			public override int IndexOf(string x)
			{
				lock(this.m_root)
					return m_collection.IndexOf(x);
			}

			public override void Insert(int pos, string x)
			{
				lock(this.m_root)
					m_collection.Insert(pos,x);
			}

			public override void Remove(string x)
			{           
				lock(this.m_root)
					m_collection.Remove(x);
			}

			public override void RemoveAt(int pos)
			{
				lock(this.m_root)
					m_collection.RemoveAt(pos);
			}
            
			public override bool IsFixedSize
			{
				get {return m_collection.IsFixedSize;}
			}

			public override bool IsReadOnly
			{
				get {return m_collection.IsReadOnly;}
			}
			#endregion

			#region Type-safe IEnumerable
			public override IStringCollectionEnumerator GetEnumerator()
			{
				lock(m_root)
					return m_collection.GetEnumerator();
			}
			#endregion

			#region Public Helpers
			// (just to mimic some nice features of ArrayList)
			public override int Capacity
			{
				get
				{
					lock(this.m_root)
						return m_collection.Capacity;
				}
                
				set
				{
					lock(this.m_root)
						m_collection.Capacity = value;
				}
			}

			public override int AddRange(StringCollection x)
			{
				lock(this.m_root)
					return m_collection.AddRange(x);
			}

			public override int AddRange(string[] x)
			{
				lock(this.m_root)
					return m_collection.AddRange(x);
			}
			#endregion
		}
		#endregion
		
		#region Nested Read Only Wrapper class
		private class ReadOnlyStringCollection : StringCollection
		{
			#region Implementation (data)
			private StringCollection m_collection;
			#endregion

			#region Construction
			internal ReadOnlyStringCollection(StringCollection list) : base(Tag.Default)
			{
				m_collection = list;
			}
			#endregion
            
			#region Type-safe ICollection
			public override void CopyTo(string[] array)
			{
				m_collection.CopyTo(array);
			}

			public override void CopyTo(string[] array, int start)
			{
				m_collection.CopyTo(array,start);
			}
			public override int Count
			{
				get {return m_collection.Count;}
			}

			public override bool IsSynchronized
			{
				get { return m_collection.IsSynchronized; }
			}

			public override object SyncRoot
			{
				get { return this.m_collection.SyncRoot; }
			}
			#endregion
            
			#region Type-safe IList
			public override string this[int i]
			{
				get { return m_collection[i]; }
				set { throw new NotSupportedException("This is a Read Only Collection and can not be modified"); }
			}

			public override int Add(string x)
			{
				throw new NotSupportedException("This is a Read Only Collection and can not be modified");
			}
            
			public override void Clear()
			{
				throw new NotSupportedException("This is a Read Only Collection and can not be modified");
			}

			public override bool Contains(string x)
			{
				return m_collection.Contains(x);
			}

			public override int IndexOf(string x)
			{
				return m_collection.IndexOf(x);
			}

			public override void Insert(int pos, string x)
			{
				throw new NotSupportedException("This is a Read Only Collection and can not be modified");
			}

			public override void Remove(string x)
			{           
				throw new NotSupportedException("This is a Read Only Collection and can not be modified");
			}

			public override void RemoveAt(int pos)
			{
				throw new NotSupportedException("This is a Read Only Collection and can not be modified");
			}
            
			public override bool IsFixedSize
			{
				get {return true;}
			}

			public override bool IsReadOnly
			{
				get {return true;}
			}
			#endregion

			#region Type-safe IEnumerable
			public override IStringCollectionEnumerator GetEnumerator()
			{
				return m_collection.GetEnumerator();
			}
			#endregion

			#region Public Helpers
			// (just to mimic some nice features of ArrayList)
			public override int Capacity
			{
				get { return m_collection.Capacity; }
                
				set { throw new NotSupportedException("This is a Read Only Collection and can not be modified"); }
			}

			public override int AddRange(StringCollection x)
			{
				throw new NotSupportedException("This is a Read Only Collection and can not be modified");
			}

			public override int AddRange(string[] x)
			{
				throw new NotSupportedException("This is a Read Only Collection and can not be modified");
			}
			#endregion
		}
		#endregion
	}
}
