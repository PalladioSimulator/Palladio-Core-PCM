using System;

namespace Palladio.FiniteStateMachines.Exceptions
{

	public class NoStartStateException : ApplicationException
	{
		public NoStartStateException() : base("No start state defined"){}
	}
}
