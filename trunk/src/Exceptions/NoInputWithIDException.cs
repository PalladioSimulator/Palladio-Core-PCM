using System;

namespace Palladio.FiniteStateMachines.Exceptions
{

	public class NoInputWithIDException : ApplicationException
	{
		public NoInputWithIDException(string anInputID) : base("No input with ID " + anInputID + " found!"){}
	}
}
