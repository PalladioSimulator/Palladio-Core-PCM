using System;

namespace ParameterisedContracts
{
	public class StackStateException : ApplicationException
	{
		public StackStateException(){}

		public StackStateException(string aMessage) : base(aMessage) {}
	}
}
