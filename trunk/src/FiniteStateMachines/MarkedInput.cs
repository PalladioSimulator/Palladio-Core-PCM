using System;

namespace FiniteStateMachines
{
	public class MarkedInput : Input {

		public MarkedInput(string aName) : base(aName) {}
		public MarkedInput(Input anUnmarkedInput) : base (anUnmarkedInput.InputSymbol) {}

		public override string InputSymbol {
			get { return "__"+base.InputSymbol+"__"; }
		}

		public Input GetUnMarkedInput() {
			return new Input(base.InputSymbol);
		}
	}
}
