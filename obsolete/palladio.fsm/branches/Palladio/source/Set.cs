using System;
using System.Collections;
namespace FSM
{
	/// <summary>
	/// stellt eine Menge dar
	/// </summary>
	/// 
	public class Set : ArrayList
	{	
		public ArrayList contens;
		public Set()
		{
			this.contens = new ArrayList();
		}

		public void AddE(Object obj)
		{
			if( ! isAlreadyIn(obj))
				this.contens.Add(obj);
			else return;
		}
		
		public bool isAlreadyIn(Object obj)
		{
			if(this.contens.Contains(obj))
				return true;
			else
				return false;
		}
		public void gibAus()
		{
			foreach(Input i in this.contens)
				Console.Write(i.ToString()+", ");
			Console.WriteLine();
		}
	}
}
