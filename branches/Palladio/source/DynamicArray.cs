using System;

namespace FSM
{
	/// <summary>
	/// dynamisches wachsendes Array
	/// </summary>
	public class DynamicArray 
	{
		public Object[] array;
		public DynamicArray(int i)
		{
			this.array = new Object[i];
		}
		public void AddE(Object o, int index)
		{
			if(index == this.array.Length)
			{
				this.array = trim();
				this.array.SetValue(o,index);
			}
			else
				this.array.SetValue(o,index);
		}
		protected Object[] trim()
		{
			Object[] feld = new Object[this.array.Length +1];
			for(int i =0; i< this.array.Length; i++)
				feld[i]= this.array[i];
			return feld;
		}

	}
}
