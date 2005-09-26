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
	/// Revision 1.2  2005/09/26 09:20:53  sliver
	/// The addition of a duplicate transition to a finite state machine now
	/// causes an TransitionAlreadyExistsException.
	///
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
		
		/// <summary>
		/// This Exception is thrown, if a state is required for an operation and
		/// it couldn't be found in the corresponding FSM.
		/// </summary>
		/// <param name="aStateName">Name of the state which couldn't be found.</param>
		public StateNotFoundException(string aStateName) : base(aStateName + " was not found!"){}
	}
}
