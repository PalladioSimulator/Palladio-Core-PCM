using System;

namespace Palladio.FiniteStateMachines.Exceptions {

	public class InputDeletionNotAllowedException : ApplicationException {	

		public InputDeletionNotAllowedException(IInput anInput) :
			base("Deletion of " + anInput + " is not allowed!")
		{
		}
	}
}
