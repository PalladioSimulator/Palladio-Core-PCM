using System;

namespace Palladio.FiniteStateMachines.Exceptions
{	
	
	/// <summary>
	/// This Exception is thrown if a transition is added to a
	/// finite state machine twice or more.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/09/26 09:21:37  sliver
	/// The addition of a duplicate transition to a finite state machine now
	/// causes an TransitionAlreadyExistsException.
	///
	///
	/// </pre>
	/// </remarks>
	public class TransitionAlreadyExistsException : ApplicationException
	{
		/// <summary>
		/// This Exception is thrown if a transition wich already exists is added to the
		/// finite state machine.
		/// </summary>
		/// <param name="transition">Duplicate transition.</param>
		public TransitionAlreadyExistsException(ITransition transition) : base ("Transition " + transition.ToString() + " already exists!")
		{
			
		}
	}
}
