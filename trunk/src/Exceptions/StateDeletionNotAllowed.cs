using System;

namespace Palladio.FiniteStateMachines.Exceptions {

	public class StateDeletionNotAllowed : ApplicationException {	

		public StateDeletionNotAllowed(IState aState) :
			base("Deletion of " + aState + " is not allowed!")
		{
		}
	}
}
