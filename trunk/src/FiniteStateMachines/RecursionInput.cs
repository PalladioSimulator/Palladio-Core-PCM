using System;

namespace FiniteStateMachines {
	/// <summary>
	/// 
	/// </summary>
	public class RecursionInput : Input {
		private Input callingServiceName;
		private Input recursiveServiceName;
		private AbstractState state;

		public RecursionInput(Input aCallingServiceName, Input aRecursiveServiceName, AbstractState aState) : 
			base("("+aRecursiveServiceName+"; "+aCallingServiceName+"; "+aState+")"){

			callingServiceName = aCallingServiceName;
			recursiveServiceName = aRecursiveServiceName;
			state = aState;
		}

		public Input CallingServiceName {
			get { return callingServiceName; }
		}

		public Input RecursiveServiceName {
			get { return recursiveServiceName; }
		}


		public AbstractState TargetStateOfCallingService {
			get {return state; }
		}

		public override bool Equals(object obj) {
			if (obj is RecursionInput) {
				RecursionInput recInput = (RecursionInput)obj;
				return ((base.Equals(obj)) && 
					(CallingServiceName == recInput.CallingServiceName) &&
					(RecursiveServiceName == recInput.RecursiveServiceName) && 
					(TargetStateOfCallingService == recInput.TargetStateOfCallingService));
			}
			return false;
		}

		public override int GetHashCode() {
			return base.GetHashCode();
		}


	}
}
