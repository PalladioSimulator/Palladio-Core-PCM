using System;
using System.Collections;
namespace Utils.Collections {
	/// <summary>
	/// A collection that contains no duplicate elements. 
	/// RR use HashTable instead object[] because then you get methods contains and add for free.
	/// </summary>
	/// 
	public class Set: IEnumerable {
		private Hashtable data;
		private IDictionaryEnumerator enumerator;
		public virtual IEnumerator GetEnumerator() {
			return new Set.Enumerator(this);
		}
		/// <summary>
		/// class which helps to iterate over the collection
		/// </summary>
		private class Enumerator : IEnumerator {
			Set outer;
			IDictionaryEnumerator enu;
			internal Enumerator(Set outer) {
				this.outer = outer;
				this.enu = this.outer.data.GetEnumerator();
				
			}
			/// <summary>
			/// Returns the current element of the collection. 
			/// </summary>
			public object Current {
				get {
					DictionaryEntry k = (DictionaryEntry) this.enu.Current;
					return k.Value;
				}
			}
			/// <summary>
			/// Advances the enumerator to the next element of the collection. 
			/// </summary>
			/// <returns>true if the enumerator was successfully advanced to the next element; 
			/// false if the enumerator has passed the end of the collection. 
			///</returns>
			public bool MoveNext() {

				return this.enu.MoveNext();

			}
			/// <summary>
			/// Sets the enumerator to its initial position, which is before the first element 
			/// in the collection. 
			/// </summary>
			public void Reset() {
				this.enu.Reset();
			}
		}


		public Set() {
			
			this.data = new Hashtable();
			this.enumerator = this.data.GetEnumerator();
		}

		/// <summary>
		/// Adds a element to the collection.
		/// </summary>
		/// <param name="obj">The object which should be added into the Collection.</param>
		public void Add(object obj) {
			try {
				this.data.Add(obj, obj);
			}
			catch(ArgumentException) {
				//				just see if its works
				//				Console.WriteLine("Already added!!! " + obj.ToString());
			}

		}


		/// <summary>
		/// Adds all elements of another set to this set.
		/// </summary>
		public void Join(Set anotherSet){
			for (IEnumerator e = anotherSet.GetEnumerator(); e.MoveNext();){
				Add(e);
			}
		}

		/// <summary>
		/// Determines whether the Hashtable contains a specific object. 
		/// </summary>
		/// <param name="obj">the object which should be checked</param>
		/// <returns>true if the Collection constains the object, false if not</returns>
		public bool Contains(Object obj) {
			return this.data.Contains(obj);
		}
		override public string ToString() {
			string s ="";
			foreach(DictionaryEntry so in this.data) {
				s +=so.Value.ToString();
				s +=", ";
			}
			
			return s;
		}

		public override bool Equals(object obj) {
			if (obj is Set) {
				Set other = (Set)obj;
				if (other.Count==this.Count) {
					foreach (object entry in other) {
						if (!this.Contains(entry)){
							return false;
						}
					}
					return true;
				}
			}
			return false;
		}


		public object Clone() {
			Set result = new Set();
			result.data = (Hashtable)data.Clone();
			result.enumerator = result.data.GetEnumerator();
			return result;
		}

		public int Count {
			get{ return data.Count; }
		}
	}
}
