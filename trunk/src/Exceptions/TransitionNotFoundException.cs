using System;

namespace Palladio.FiniteStateMachines.Exceptions
{

	public class TransitionNotFoundException : ApplicationException
	{
		public TransitionNotFoundException(ITransition aTrans) : base(aTrans + " was not found!"){}
	}
}
