using System;

namespace Palladio.FiniteStateMachines.Exceptions
{

	public class StateNotFoundException : ApplicationException
	{
		public StateNotFoundException(IState aState) : base(aState + " was not found!"){}
	}
}
