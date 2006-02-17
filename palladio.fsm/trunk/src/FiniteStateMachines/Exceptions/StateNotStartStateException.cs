using System;

namespace Palladio.FiniteStateMachines
{
	/// <summary>
	/// </summary>
	public class StateNotStartStateException : Exception
	{
		public StateNotStartStateException(IState aState) : 
			base(aState.ToString()+" is not a Start-State")
		{
		}
	}
}
