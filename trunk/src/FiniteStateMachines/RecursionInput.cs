using System;

namespace FiniteStateMachines {
	/// <summary>
	/// 
	/// </summary>
	public class RecursionInput : Input {
		private Input service;
		private AbstractState state;

		public RecursionInput(Input aService, AbstractState aState) : base("("+aService+"; "+aState+")"){
			service = aService;
			state = aState;
		}

		public Input Service {
			get { return service; }
		}

		public AbstractState State {
			get {return state; }
		}

		/// <summary>
		/// Compares this input to another object.
		/// </summary>
		/// <returns>true if both inputs are equal, false otherwise</returns>
		public override bool Equals(object obj) {
			if (obj is RecursionInput) {
				RecursionInput recInput = (RecursionInput)obj;
				return ((base.Equals(obj)) && (Service == recInput.Service) && (State == recInput.State));
			}
			return false;
		}

	}
}
