using System;
using FiniteStateMachines;

namespace ParameterisedContracts {
	/// <summary>
	/// Input symbol used to handle the terminal recursion.
	/// 
	/// author: JH
	/// </summary>
	public class RecursionInput : Input {

		/// <summary>
		///		Input symbol identifing the service which calls the
		///		recursive service.
		/// </summary>
		private Input callingServiceName;

		/// <summary>
		///		Input symbol identifing the recursive service.
		/// </summary>
		private Input recursiveServiceName;

		/// <summary>
		///		The destination of the recursive Transition in 
		///		the calling service.
		/// </summary>
		private AbstractState targetState;

		public RecursionInput(Input aCallingServiceName, Input aRecursiveServiceName, AbstractState aState) : 
			base("("+aRecursiveServiceName+"; "+aCallingServiceName+"; "+aState+")"){

			callingServiceName = aCallingServiceName;
			recursiveServiceName = aRecursiveServiceName;
			targetState = aState;
		}

		/// <summary>
		///		Input symbol identifing the service which calls the
		///		recursive service.
		/// </summary>
		public Input CallingServiceName {
			get { return callingServiceName; }
		}

		/// <summary>
		///		Input symbol identifing the recursive service.
		/// </summary>
		public Input RecursiveServiceName {
			get { return recursiveServiceName; }
		}


		/// <summary>
		///		The destination of the recursive Transition in 
		///		the calling service.
		/// </summary>
		public AbstractState TargetState {
			get {return targetState; }
		}

		public override bool Equals(object obj) {
			if (obj is RecursionInput) {
				RecursionInput recInput = (RecursionInput)obj;
				return ((base.Equals(obj)) && 
					(CallingServiceName == recInput.CallingServiceName) &&
					(RecursiveServiceName == recInput.RecursiveServiceName) && 
					(TargetState == recInput.TargetState));
			}
			return false;
		}

		public override int GetHashCode() {
			return base.GetHashCode();
		}


	}
}
