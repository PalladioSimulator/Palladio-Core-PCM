using System;

namespace Palladio.FiniteStateMachines.Exceptions
{

	public class InvalidStateException : ApplicationException
	{
		public InvalidStateException(IState aState) : base(aState + " is not allowed here!"){}
	}
}
