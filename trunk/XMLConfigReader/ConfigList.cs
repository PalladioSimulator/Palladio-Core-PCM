using System;
using System.Collections;

namespace Palladio.XMLConfigReader
{
	/// <summary>
	/// Deutsch: Erstellt eine Liste von Key Value Paaren. Besonders ist, dass es sich bei
	/// diesern Liste um einen Unterkonten der XML Congig Datei handelt. 
	/// Zum besseren Verständnis ein Beispiel:
	/// <code>
	/// <meineConfigDatei>
	///		<andererEinfacherKram>ein Einzelwert</andererEinfacherKram>
	///		<meineListe>
	///			<item>
	///				<schluessel>erster Sclüssel</schluessel>
	///				<wert>erster Wert</wert>
	///			</item>
	///				<schluessel>zweiter Schluessel</schluessel>
	///				<wert>zweiter Wert</wert>
	///			<item>
	///			</item>
	///		</meineListe>
	/// </meineConfigDatei>
	/// </code>
	/// Diese Metode würde als TagValue meine Liste erhalten. Und würde dann eine
	/// ConfigList mit folgenden Werten zurückgeben:
	/// erster Schluessel	erster Wert
	/// zweiter Schliessel	zweiter Wert
	/// </summary>
	public class ConfigList : ICollection, IEnumerable
	{

		protected Hashtable list;
		protected string name;

		public ConfigList() 
		{
			this.list = new Hashtable();
		}

		/// <summary>
		/// The name of the list. Its equal to the root Element.
		/// </summary>
		public string Name
		{
			get{return this.name;}
			set{this.name = value;}
		}

		#region ICollection implemention
		
		public void CopyTo(System.Array array, int i)
		{
			this.list.CopyTo(array,i);
		}

		public int Count
		{
			get{return this.list.Count;}
		}
		

		public bool IsSynchronized
		{
			get{return this.list.IsSynchronized;}
		}

		public object SyncRoot
		{
			get{return this.list.SyncRoot;}		
		}

		#endregion


		public void Add(object o)
		{
			 this.list.Add(o,o);
		}

		public void AddPair(object key, object obj)
		{
			this.list.Add(key,obj);
		}

		public void Clear()
		{
			this.list.Clear();
		}

		public bool Contains(object o)
		{
			return this.list.Contains(o);
//			foreach(DictionaryEntry d in this.list)
//			{
//				if(d.Value.ToString() == o.ToString())
//					return true;
//			}
//			return false;
		}


		public bool IsReadOnly
		{
			get{return false;}		
		}

		public object this[object o]
		{
			get{return this.list[o];}
		}

		public void Remove(object o)
		{
			this.list.Remove(o);
		}	

		#region IEnumerable implementation
			IEnumerator IEnumerable.GetEnumerator()
		{
			return this.list.GetEnumerator();
		}
		#endregion

		public IEnumerator GetKeyEnumerator()
		{
			return this.list.Keys.GetEnumerator();
		}

		public IEnumerator GetValueEnumerator()
		{
			return this.list.Values.GetEnumerator();
		}
	}
}
