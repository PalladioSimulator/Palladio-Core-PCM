using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.FiniteStateMachines.Exceptions
{

	public class InvalidInputException : Exception
	{
		public InvalidInputException(IInput anInput) : base(anInput + " is not allowed here!") {}
	}
}
