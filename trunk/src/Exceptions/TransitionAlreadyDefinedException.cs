using System;

namespace Palladio.FiniteStateMachines.Exceptions {

	public class TransitionAlreadyDefinedException : ApplicationException {	

		public TransitionAlreadyDefinedException(ITransition aTrans) :
			base("A Transition " + aTrans + " is already defined.")
		{
		}
	}
}
