using System;

namespace FSM
{
	/// <summary>
	/// Represents the input of a FSM.
	/// </summary>
	public class Input
	{	

		/// <summary>
		/// Input instance indicating the end of a service effect specification.
		/// </summary>
		public static Input INPUT_RETURN = new Input("return");

		/// <summary>
		/// Input instance indicating a recursion.
		/// 
		/// Maybe own Inputclass (see implementation rr)
		/// </summary>
		public static Input INPUT_RECURSION = new Input("recursion");

		/// <summary>
		/// String represinting the input.
		/// </summary>
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


		/// <summary>
		/// Compares this input to another object.
		/// </summary>
		/// <returns>true if both inputs are equal, false otherwise</returns>
		public override bool Equals(object obj) {
			if (obj is Input) {
				Input anInput = (Input)obj;
				return (anInput.input == input);
			}
			return false;
		}
		
		/// <summary>
		/// Operator uses the implementation of Equals.
		/// </summary>
		/// <param name="input1"></param>
		/// <param name="input2"></param>
		/// <returns></returns>
		public static bool operator == (Input one, Input two){
			return one.Equals(two);
		}

		/// <summary>
		/// Operator uses the implementation of Equals.
		/// </summary>
		/// <param name="input1"></param>
		/// <param name="input2"></param>
		/// <returns></returns>
		public static bool operator != (Input one, Input two){
			return !one.Equals(two);
		}

		/// <summary>
		/// Refers to the GetHashCode of the input string.
		/// </summary>
		/// <returns></returns>
		public override int GetHashCode() {
			return input.GetHashCode();
		}

	}
}
