using System;

namespace Palladio.FiniteStateMachines.Exceptions {

	public class FsmNotDeterministicException : ApplicationException {	

		public FsmNotDeterministicException(IState aState, IInput anInput) :
			base("Multiple Transitions possible from state " + aState + " whith the input symbol " + anInput + ".")
		{
		}
	}
}
