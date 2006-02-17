using System;


namespace FSM
{
	public class Input
	{
		//evt. noch ale Objekt deklarieren 
		protected string input;
		protected int hashcode;
		public Input()
		{
			this.hashcode = input.GetHashCode;
		}

		public int hashcode
		{
			get
			{
				return(this.hashcode);
			}
		}
		public string input
		{
			get
			{
				return(this.input);
			}
		}
		public string ToString()
		{
			return input;
		}

	}
	
}
