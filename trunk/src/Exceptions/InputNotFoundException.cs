using System;

namespace Palladio.FiniteStateMachines.Exceptions
{

	public class InputNotFoundException : ApplicationException
	{
		public InputNotFoundException(IInput anInput) : base(anInput + " was not found!"){}
	}
}
