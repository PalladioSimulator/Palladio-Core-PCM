using System;
using System.Collections;

namespace XMLConfigReader
{
	/// <summary>
	/// A ConfigTable contains config items in a key-value representation. It is based on a Hashtable.
	/// Deutsch: Auch hier zum besseren Verständis ein Beispiel:
	/// <settings>
	///		<item1>value of item one</item1>
	///		<item2>value of item two</item2>
	///		....
	/// </settings>
	/// A ConfigTable, which root element is setting will contain the following values
	/// item1	value of item 1
	/// item2	value of item 2
	/// </summary>
	public class ConfigTable : IDictionary, IEnumerable
	{
		/// <summary>
		/// As you can imagine this collection is based on a <c>Hashtable</c>
		/// </summary>
		protected Hashtable baseTable;

		/// <summary>
		/// The name of the Config Table. It is equal to the root element of the part of the
		/// based XML Document.
		/// </summary>
		protected string name;

		/// <summary>
		/// Inits a ConfigTable
		/// </summary>
		public ConfigTable()
		{
			this.baseTable = new Hashtable();
		}

		
		public string Name
		{
			get{return this.name;}
			set{this.name = value;}
		}



		/// <summary>
		/// Returns the Content of the ContentTable as string.
		/// </summary>
		/// <returns>a string</returns>
		public override string ToString()
		{
			string result= "";
			foreach(DictionaryEntry de in this.baseTable)
			{
				result += "Key: "+de.Key+" Value: "+de.Value+"\n";
			}
			return result;
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

		public override bool Equals(object obj)
		{
			if(obj is ConfigTable)
			{
				if(this.Name.Equals(((ConfigTable) obj).Name))
				{
					if(this.Equals((ConfigTable) obj))
					{
						return true;
					}
				}
			}
			return false;
		}


	
	}
}
