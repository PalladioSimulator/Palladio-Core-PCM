using System;

namespace FiniteStateMachines
{
	/// <summary>
	///		Used to mark an input symbol without changing 
	///		its content.
	/// 
	///		author: JH
	/// </summary>
	public class MarkedInput : Input {

		/// <summary>
		///		Creates a comletly new marked input.
		/// </summary>
		public MarkedInput(string aName) : base(aName) {}

		/// <summary>
		///  Creates a new marked input out of an existing one.
		/// </summary>
		public MarkedInput(Input anUnmarkedInput) : base (anUnmarkedInput.InputSymbol) {}

		/// <summary>
		///		Returns the marked name of the
		///		input symbol.
		/// </summary>
		public override string InputSymbol {
			get { return "__"+base.InputSymbol+"__"; }
		}

		/// <summary>
		///		Returns the original input symbol.
		/// </summary>
		public Input GetUnMarkedInput() {
			return new Input(base.InputSymbol);
		}
	}
}
