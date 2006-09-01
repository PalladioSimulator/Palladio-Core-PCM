using System;

namespace Palladio.FiniteStateMachines
{

	public class InvalidStateException : ApplicationException
	{
		
		public InvalidStateException(){}

		public InvalidStateException(string message) : base(message){}
	}
}
