using System;
using System.Collections;

namespace XMLConfigReader
{
	/// <summary>
	/// Zusammenfassung für ConfigTable.
	/// </summary>
	public class ConfigTable : IDictionary, IEnumerable
	{
		protected Hashtable baseTable;
		protected string name;

		public ConfigTable()
		{
			this.baseTable = new Hashtable();
		}

		
		public string Name
		{
			get{return this.name;}
			set{this.name = value;}
		}

		#region IDictionary implementation

		public void CopyTo(System.Array t, int i)
		{
			this.baseTable.CopyTo(t,i);
		}

		public int Count
		{
			get{return this.baseTable.Count;}
		}

		public bool IsSynchronized
		{
			get{return this.baseTable.IsSynchronized;}
		}

		public void Add(object key,object v)
		{
			this.baseTable.Add(key,v);
		}

		public void Clear()
		{
			this.baseTable.Clear();
		}

		public bool ContainsKey(object o)
		{
			 return this.baseTable.ContainsKey(o);
		}

		public bool Contains(object o)
		{
			return this.baseTable.Contains(o);
		}

		public IDictionaryEnumerator GetEnumerator()
		{
			return this.baseTable.GetEnumerator();
		}    

		public bool IsReadOnly
		{
			get{return this.baseTable.IsReadOnly;}
		}

		public object SyncRoot
		{
			get{return this.baseTable.SyncRoot;}
		}


		public ICollection Keys
		{
			get{return this.baseTable.Keys;}
		}

		public void Remove(object objectKey)
		{
			this.baseTable.Remove(objectKey);
		}

		public ICollection Values
		{
			get{return this.baseTable.Keys;}
		}

		public bool IsFixedSize
		{
			get{return this.baseTable.IsFixedSize;}
		}

		public object this[object oKey]
		{
			get{return this.baseTable[oKey];}
			set{this.baseTable[oKey] = value;}
		}
         #endregion 



		#region IEnumerable implementation
		IEnumerator IEnumerable.GetEnumerator()
		{
			return this.baseTable.GetEnumerator();
		}
		#endregion


		

	
	}
}
