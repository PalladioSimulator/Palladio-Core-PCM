using System;

namespace FiniteStateMachines
{
	public class StackStateException : ApplicationException
	{
		public StackStateException(){}

		public StackStateException(string aMessage) : base(aMessage) {}
	}
}
