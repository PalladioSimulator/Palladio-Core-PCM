using System;

namespace Palladio.FiniteStateMachines.Exceptions
{

	/// <summary>
	/// This Exception is thrown, if a state is required for an operation and
	/// it couldn't be found in the corresponding FSM.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public class StateNotFoundException : ApplicationException
	{
		/// <summary>
		/// This Exception is thrown, if a state is required for an operation and
		/// it couldn't be found in the corresponding FSM.
		/// </summary>
		/// <param name="aState">State which couldn't be found.</param>
		public StateNotFoundException(IState aState) : base(aState + " was not found!"){}
	}
}
