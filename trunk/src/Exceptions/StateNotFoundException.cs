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
	/// Revision 1.2  2004/05/12 12:54:33  sliver
	/// Comments for the exceptions added
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
