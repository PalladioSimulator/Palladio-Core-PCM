using System;

namespace FiniteStateMachines {
	/// <summary>
	/// Represents the input of a FSM.
	/// </summary>
	public class Input {	

		/// <summary>
		/// Input instance indicating the end of a service effect specification.
		/// </summary>
		public static Input RETURN = new Input("return");

		/// <summary>
		/// String represinting the input.
		/// </summary>
		private string inputSymbol;


		//protected int Hashcode;
		/// <summary>
		/// The default constuctor.
		/// </summary>
		/// <param name="i">The input stirng.</param>
		public Input(string anInputSymbol) {
			this.inputSymbol = anInputSymbol;
			//this.Hashcode = this.GetHashCode();
		}

		/// <summary>
		/// Returns the Input as a string.
		/// </summary>
		/// <returns>The Input as string.</returns>
		override public String ToString() {
			return this.inputSymbol;
		}


		/// <summary>
		/// Compares this input to another object.
		/// </summary>
		/// <returns>true if both inputs are equal, false otherwise</returns>
		public override bool Equals(object obj) {
			if (obj is Input) {
				Input anInput = (Input)obj;
				return (anInput.inputSymbol == inputSymbol);
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
			try {
				return one.Equals(two);
			} catch( NullReferenceException  ) {//e1
				try {
					return two.Equals(one);
				} catch( NullReferenceException ) {//e2
					return true;
				}
			}
		}

		/// <summary>
		/// Operator uses the implementation of Equals.
		/// </summary>
		/// <param name="input1"></param>
		/// <param name="input2"></param>
		/// <returns></returns>
		public static bool operator != (Input one, Input two){
			try {
				return !one.Equals(two);
			} catch( NullReferenceException  ) {//e1
				try {
					return !two.Equals(one);
				} catch( NullReferenceException ) {//e2
					return false;
				}
			}
		}

		/// <summary>
		/// Refers to the GetHashCode of the input string.
		/// </summary>
		/// <returns></returns>
		public override int GetHashCode() {
			return inputSymbol.GetHashCode();
		}

	}
}
