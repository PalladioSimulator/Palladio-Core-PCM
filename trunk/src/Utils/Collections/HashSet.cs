// created on 22.04.2003 at 19:57
using System;
using System.Collections;
namespace FSM
{
	/// <summary>
	///  Another implentation of a set based on a Hashtable.
	/// </summary>
	public class HashSet : IEnumerable

	{
		private Hashtable data;
		/// <summary>
		/// class witch helps to iterate over the collection
		/// </summary>
		/// <returns>The IEnumerator for the collection.</returns>
		public virtual IEnumerator GetEnumerator()
		{
			return new HashSet.Enumerator(this);
		}
		/// <summary>
		/// initates a HashSet.
		/// </summary>
		public HashSet()
		{
			this.data = new Hashtable();
		}
		/// <summary>
		/// Adds an element to the collection.
		/// </summary>
		/// <param name="obj"></param>
		public void Add(object obj)
		{
			try
			{
				
				this.data.Add(obj,obj);
			}
			catch(ArgumentException)
			{
				
			}
			
		}
		/// <summary>
		/// Checks if an given object is part of the HashSet.
		/// </summary>
		/// <param name="obj">the object, witch should be checked.</param>
		/// <returns>bool true, if the object is part of the collection.</returns>
		public bool Contains(Object obj)
		{
			return(this.data.Contains(obj) );
			
		}
		/// <summary>
		/// </summary>
		/// <returns>Returns the object as a string representation.</returns>
		public override string ToString()
		{
			string s ="";
			IEnumerator t = this.GetEnumerator();
			while(t.MoveNext())
			{
				s+=t.Current.ToString();
				s+="\n";
			}
			
			return s;
		}
		/// <summary>
		/// An inner class, witch helps to iterate over the collection.
		/// </summary>
		private class Enumerator : IEnumerator
		{
			HashSet outer;
			IDictionaryEnumerator e;
			public Enumerator(HashSet r)
			{
				this.outer = r;
				this.e = this.outer.data.GetEnumerator();
			}
			/// <summary>
			/// returns the current object of the HashSet.
			/// </summary>
			public object Current
			{
				get
				{
					DictionaryEntry k = (DictionaryEntry) this.e.Current;
					return k.Value;
				}
			}
			/// <summary>
			/// Checks if the hashSet contains aother object.
			/// </summary>
			/// <returns> </returns>
			public bool MoveNext()
			{
		
				return this.e.MoveNext();
			}
			public void Reset()
			{
				this.e.Reset();
			}
		}
		/**public static void Main()
		{
			HashSet test = new HashSet();
			string a ="Hallo";
			string b = "Du";
			test.Add("Hallo");
			test.Add(b);
			test.Add(b);
	
			Console.WriteLine("foreach: ");
			foreach(string s in test)
				Console.WriteLine(s);
		
			Console.ReadLine();

		}
		*/
			
	}
}