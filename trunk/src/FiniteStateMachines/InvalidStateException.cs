using System;

namespace FiniteStateMachines
{

	public class InvalidStateException : ApplicationException
	{
		
		public InvalidStateException(){}

		public InvalidStateException(string message) : base(message){}
	}
}
