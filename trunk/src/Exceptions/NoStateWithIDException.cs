using System;

namespace Palladio.FiniteStateMachines.Exceptions
{

	public class NoStateWithIDException : ApplicationException
	{
		public NoStateWithIDException(string aStateID) : base("No state with ID " + aStateID + " found!"){}
	}
}
