using System;
using System.Collections;

namespace FSM
{
	/// <summary>
	/// dynamisches wachsendes Array
	/// </summary>
	public class DynamicArray : IEnumerable
	{
		IEnumerator e;
		public Object[] array;
		public virtual IEnumerator GetEnumerator()
		{
			return new DynamicArray.Enumerator(this);
		}
		private class Enumerator : IEnumerator
		{
			DynamicArray outer;
			int currentIndex = -1;
			internal Enumerator(DynamicArray outer)
			{
				this.outer = outer;
			}
			/// <summary>
			/// Gets the current element in the collection. 
			/// </summary>
			public object Current
			{
				get
				{
					if (currentIndex > outer.array.Length)
						throw new InvalidOperationException();
					return outer.array[currentIndex];
				}
			}
			/// <summary>
			/// Advances the enumerator to the next element of the collection. 
			/// </summary>
			/// <returns>true if the enumerator was successfully advanced to the next element; 
			/// false if the enumerator has passed the end of the collection. 
			///</returns>
			public bool MoveNext()
			{
				if (currentIndex > outer.array.Length)
					throw new InvalidOperationException();
				return++currentIndex < outer.array.Length;
			}
			/// <summary>
			/// Sets the enumerator to its initial position, which is before the first element 
			/// in the collection. 
			/// </summary>
			public void Reset()
			{
				currentIndex = -1;
			}
		}

		public DynamicArray(int i)
		{
			this.array = new Object[i];
		}
		public void AddE(Object o, int index)
		{
			if (index == this.array.Length)
			{
				this.array = trim();
				this.array.SetValue(o, index);
			}
			else
				this.array.SetValue(o, index);
		}
		protected Object[] trim()
		{
			Object[] feld = new Object[this.array.Length + 1];
			for (int i = 0; i < this.array.Length; i++)
				feld[i] = this.array[i];
			return feld;
		}
		//sort
		//search

	}
}
