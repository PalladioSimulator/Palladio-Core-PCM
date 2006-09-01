using System;

namespace FSM
{
		
	public class Input
	{	

		protected string input;
		protected int Hashcode;
		public Input(string i)
		{
			this.input = i;
			this.Hashcode = this.GetHashCode();
		}

		override public String ToString()
		{
			return this.input;
		}
		public int hashcode
		{
			get
			{
				return(this.Hashcode);
			}
		}

	}
}
