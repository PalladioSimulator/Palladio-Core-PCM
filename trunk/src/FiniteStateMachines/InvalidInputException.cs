using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.FiniteStateMachines
{

	public class InvalidInputException : Exception
	{
		public InvalidInputException(){}

		public InvalidInputException(string msg) : base(msg) {}
	}
}
