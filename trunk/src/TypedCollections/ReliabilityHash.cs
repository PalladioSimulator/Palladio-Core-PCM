/*
 * $Id$
 * 
 * $Log$
 * Revision 1.3  2004/09/09 04:07:53  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.2  2004/07/19 04:37:48  sliver
 * extracted attributes
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 *
 * Revision 1.1  2004/07/06 00:30:44  sliver
 * + added Markov Probability for transitions
 * + CCVisitor propagates the reliability now
 * 
 */

using System;
using System.Collections;
using Palladio.ComponentModel;
using Palladio.Reliability.Math;

namespace Palladio.Reliability.TypedCollections
{
	public class ReliabilityHash : IDictionary, ICollection, IEnumerable, ICloneable
	{
		protected Hashtable innerHash;

		#region "Constructors"

		public ReliabilityHash()
		{
			innerHash = new Hashtable();
		}

		public ReliabilityHash(ReliabilityHash original)
		{
			innerHash = new Hashtable(original.innerHash);
		}

		public ReliabilityHash(IDictionary dictionary)
		{
			innerHash = new Hashtable(dictionary);
		}

		public ReliabilityHash(int capacity)
		{
			innerHash = new Hashtable(capacity);
		}

		public ReliabilityHash(IDictionary dictionary, float loadFactor)
		{
			innerHash = new Hashtable(dictionary, loadFactor);
		}

		public ReliabilityHash(IHashCodeProvider codeProvider, IComparer comparer)
		{
			innerHash = new Hashtable(codeProvider, comparer);
		}

		public ReliabilityHash(int capacity, int loadFactor)
		{
			innerHash = new Hashtable(capacity, loadFactor);
		}

		public ReliabilityHash(IDictionary dictionary, IHashCodeProvider codeProvider, IComparer comparer)
		{
			innerHash = new Hashtable(dictionary, codeProvider, comparer);
		}

		public ReliabilityHash(int capacity, IHashCodeProvider codeProvider, IComparer comparer)
		{
			innerHash = new Hashtable(capacity, codeProvider, comparer);
		}

		public ReliabilityHash(IDictionary dictionary, float loadFactor, IHashCodeProvider codeProvider, IComparer comparer)
		{
			innerHash = new Hashtable(dictionary, loadFactor, codeProvider, comparer);
		}

		public ReliabilityHash(int capacity, float loadFactor, IHashCodeProvider codeProvider, IComparer comparer)
		{
			innerHash = new Hashtable(capacity, loadFactor, codeProvider, comparer);
		}

		#endregion

		#region Implementation of IDictionary

		public ReliabilityHashEnumerator GetEnumerator()
		{
			return new ReliabilityHashEnumerator(this);
		}

		IDictionaryEnumerator IDictionary.GetEnumerator()
		{
			return new ReliabilityHashEnumerator(this);
		}

		IEnumerator IEnumerable.GetEnumerator()
		{
			return GetEnumerator();
		}

		public void Remove(IExternalSignature key)
		{
			innerHash.Remove(key);
		}

		void IDictionary.Remove(object key)
		{
			Remove((IExternalSignature) key);
		}

		public bool Contains(IExternalSignature key)
		{
			return innerHash.Contains(key);
		}

		bool IDictionary.Contains(object key)
		{
			return Contains((IExternalSignature) key);
		}

		public void Clear()
		{
			innerHash.Clear();
		}

		public void Add(IExternalSignature key, IVariableExpression value)
		{
			innerHash.Add(key, value);
		}

		void IDictionary.Add(object key, object value)
		{
			Add((IExternalSignature) key, (IVariableExpression) value);
		}

		public bool IsReadOnly
		{
			get { return innerHash.IsReadOnly; }
		}

		public IVariableExpression this[IExternalSignature key]
		{
			get { return (IVariableExpression) innerHash[key]; }
			set { innerHash[key] = value; }
		}

		object IDictionary.this[object key]
		{
			get { return this[(IExternalSignature) key]; }
			set { this[(IExternalSignature) key] = (IVariableExpression) value; }
		}

		public ICollection Values
		{
			get { return innerHash.Values; }
		}

		public ICollection Keys
		{
			get { return innerHash.Keys; }
		}

		public bool IsFixedSize
		{
			get { return innerHash.IsFixedSize; }
		}

		#endregion

		#region Implementation of ICollection

		public void CopyTo(Array array, int index)
		{
			innerHash.CopyTo(array, index);
		}

		public bool IsSynchronized
		{
			get { return innerHash.IsSynchronized; }
		}

		public int Count
		{
			get { return innerHash.Count; }
		}

		public object SyncRoot
		{
			get { return innerHash.SyncRoot; }
		}

		#endregion

		#region Implementation of ICloneable

		public ReliabilityHash Clone()
		{
			ReliabilityHash clone = new ReliabilityHash();
			clone.innerHash = (Hashtable) innerHash.Clone();
			return clone;
		}

		object ICloneable.Clone()
		{
			return Clone();
		}

		#endregion

		#region "HashTable Methods"

		public bool ContainsKey(IExternalSignature key)
		{
			return innerHash.ContainsKey(key);
		}

		public bool ContainsValue(IVariableExpression value)
		{
			return innerHash.ContainsValue(value);
		}

		public static ReliabilityHash Synchronized(ReliabilityHash nonSync)
		{
			ReliabilityHash sync = new ReliabilityHash();
			sync.innerHash = Hashtable.Synchronized(nonSync.innerHash);
			return sync;
		}

		#endregion

		internal Hashtable InnerHash
		{
			get { return innerHash; }
		}
	}

	public class ReliabilityHashEnumerator : IDictionaryEnumerator
	{
		private IDictionaryEnumerator innerEnumerator;

		internal ReliabilityHashEnumerator(ReliabilityHash enumerable)
		{
			innerEnumerator = enumerable.InnerHash.GetEnumerator();
		}

		#region Implementation of IDictionaryEnumerator

		public IExternalSignature Key
		{
			get { return (IExternalSignature) innerEnumerator.Key; }
		}

		object IDictionaryEnumerator.Key
		{
			get { return Key; }
		}

		public IVariableExpression Value
		{
			get { return (IVariableExpression) innerEnumerator.Value; }
		}

		object IDictionaryEnumerator.Value
		{
			get { return Value; }
		}

		public DictionaryEntry Entry
		{
			get { return innerEnumerator.Entry; }
		}

		#endregion

		#region Implementation of IEnumerator

		public void Reset()
		{
			innerEnumerator.Reset();
		}

		public bool MoveNext()
		{
			return innerEnumerator.MoveNext();
		}

		public object Current
		{
			get { return innerEnumerator.Current; }
		}

		#endregion
	}
}