using System;

namespace FSM
{
	/// <summary>
	/// Represents the input of a FSM.
	/// </summary>
	public class Input
	{	

		protected string input;
		//protected int Hashcode;
		/// <summary>
		/// The default constuctor.
		/// </summary>
		/// <param name="i">The input stirng.</param>
		public Input(string i)
		{
			this.input = i;
			//this.Hashcode = this.GetHashCode();
		}

		/// <summary>
		/// Returns the Input as a string.
		/// </summary>
		/// <returns>The Input as string.</returns>
		override public String ToString()
		{
			return this.input;
		}


	}
}
