using System;

namespace FSM
{

	public class InvalidStateException : Exception
	{
		
		public InvalidStateException(){}

		public InvalidStateException(string message) : base(message){}
	}
}
