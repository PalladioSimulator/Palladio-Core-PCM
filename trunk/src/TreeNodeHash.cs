/*
 * Created by SharpDevelop.
 * User: sliver
 * Date: 02.07.2004
 * Time: 10:36
 * 
 */

using System;
using System.Collections;
using Palladio.Identifier;

namespace Palladio.Reliability
{
	public class TreeNodeHash : IDictionary, ICollection, IEnumerable, ICloneable
	{
		protected Hashtable innerHash;
		
		#region "Constructors"
		public  TreeNodeHash()
		{
			innerHash = new Hashtable();
		}
		
		public TreeNodeHash(TreeNodeHash original)
		{
			innerHash = new Hashtable(original.innerHash);
		}
		
		public TreeNodeHash(IDictionary dictionary)
		{
			innerHash = new Hashtable(dictionary);
		}
		
		public TreeNodeHash(int capacity)
		{
			innerHash = new Hashtable(capacity);
		}
		
		public TreeNodeHash(IDictionary dictionary, float loadFactor)
		{
			innerHash = new Hashtable(dictionary, loadFactor);
		}
		
		public TreeNodeHash(IHashCodeProvider codeProvider, IComparer comparer)
		{
			innerHash = new Hashtable(codeProvider, comparer);
		}
		
		public TreeNodeHash(int capacity, int loadFactor)
		{
			innerHash = new Hashtable(capacity, loadFactor);
		}
		
		public TreeNodeHash(IDictionary dictionary, IHashCodeProvider codeProvider, IComparer comparer)
		{
			innerHash = new Hashtable(dictionary, codeProvider, comparer);
		}
		
		public TreeNodeHash(int capacity, IHashCodeProvider codeProvider, IComparer comparer)
		{
			innerHash = new Hashtable(capacity, codeProvider, comparer);
		}
		
		public TreeNodeHash(IDictionary dictionary, float loadFactor, IHashCodeProvider codeProvider, IComparer comparer)
		{
			innerHash = new Hashtable(dictionary, loadFactor, codeProvider, comparer);
		}
		
		public TreeNodeHash(int capacity, float loadFactor, IHashCodeProvider codeProvider, IComparer comparer)
		{
			innerHash = new Hashtable(capacity, loadFactor, codeProvider, comparer);
		}
		#endregion

		#region Implementation of IDictionary
		public TreeNodeHashEnumerator GetEnumerator()
		{
			return new TreeNodeHashEnumerator(this);
		}
		
		System.Collections.IDictionaryEnumerator IDictionary.GetEnumerator()
		{
			return new TreeNodeHashEnumerator(this);
		}
		
		IEnumerator IEnumerable.GetEnumerator()
		{
			return GetEnumerator();
		}
		
		public void Remove(IIdentifier key)
		{
			innerHash.Remove(key);
		}
		
		void IDictionary.Remove(object key)
		{
			Remove ((IIdentifier)key);
		}
		
		public bool Contains(IIdentifier key)
		{
			return innerHash.Contains(key);
		}
		
		bool IDictionary.Contains(object key)
		{
			return Contains((IIdentifier)key);
		}
		
		public void Clear()
		{
			innerHash.Clear();		
		}
		
		public void Add(IIdentifier key, TreeNode value)
		{
			innerHash.Add(key, value);
		}
		
		void IDictionary.Add(object key, object value)
		{
			Add ((IIdentifier)key, (TreeNode)value);
		}
		
		public bool IsReadOnly {
			get {
				return innerHash.IsReadOnly;
			}
		}
		
		public TreeNode this[IIdentifier key] {
			get {
				return (TreeNode) innerHash[key];
			}
			set {
				innerHash[key] = value;
			}
		}
		
		object IDictionary.this[object key] {
			get {
				return this[(IIdentifier)key];
			}
			set {
				this[(IIdentifier)key] = (TreeNode)value;
			}
		}
		
		public System.Collections.ICollection Values {
			get {
				return innerHash.Values;
			}
		}
		
		public System.Collections.ICollection Keys {
			get {
				return innerHash.Keys;
			}
		}
		
		public bool IsFixedSize {
			get {
				return innerHash.IsFixedSize;
			}
		}
		#endregion
		
		#region Implementation of ICollection
		public void CopyTo(System.Array array, int index)
		{
			innerHash.CopyTo (array, index);
		}
		
		public bool IsSynchronized {
			get {
				return innerHash.IsSynchronized;
			}
		}
		
		public int Count {
			get {
				return innerHash.Count;
			}
		}
		
		public object SyncRoot {
			get {
				return innerHash.SyncRoot;
			}
		}
		#endregion
		
		#region Implementation of ICloneable
		public TreeNodeHash Clone()
		{
			TreeNodeHash clone = new TreeNodeHash();
			clone.innerHash = (Hashtable) innerHash.Clone();
			return clone;
		}
		
		object ICloneable.Clone()
		{
			return Clone();
		}
		#endregion
		
		#region "HashTable Methods"
		public bool ContainsKey(IIdentifier key)
		{
			return innerHash.ContainsKey(key);
		}
		
		public bool ContainsValue(TreeNode value)
		{
			return innerHash.ContainsValue(value);
		}
		
		public static TreeNodeHash Synchronized(TreeNodeHash nonSync)
		{
			TreeNodeHash sync = new TreeNodeHash();
			sync.innerHash = Hashtable.Synchronized(nonSync.innerHash);
			return sync;
		}
		#endregion

		internal Hashtable InnerHash {
			get {
				return innerHash;
			}
		}
	}
	
	public class TreeNodeHashEnumerator : IDictionaryEnumerator
	{
		private IDictionaryEnumerator innerEnumerator;
		
		internal TreeNodeHashEnumerator(TreeNodeHash enumerable)
		{
			innerEnumerator = enumerable.InnerHash.GetEnumerator();
		}
		
		#region Implementation of IDictionaryEnumerator
		public IIdentifier Key {
			get {
				return (IIdentifier)innerEnumerator.Key;
			}
		}
		
		object IDictionaryEnumerator.Key {
			get {
				return Key;
			}
		}
		
		public TreeNode Value {
			get {
				return (TreeNode)innerEnumerator.Value;
			}
		}
		
		object IDictionaryEnumerator.Value {
			get {
				return Value;
			}
		}
		
		public System.Collections.DictionaryEntry Entry {
			get {
				return innerEnumerator.Entry;
			}
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
		
		public object Current {
			get {
				return innerEnumerator.Current;
			}
		}
		#endregion
	}
}
