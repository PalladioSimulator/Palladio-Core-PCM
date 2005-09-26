using System;

namespace Palladio.FiniteStateMachines.Exceptions
{

	/// <summary>
	/// This exception is thrown, if anInput is required in an FSM, but it cannot
	/// be found. 
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
	public class InputNotFoundException : ApplicationException
	{
		/// <summary>
		/// anInput cannot be found in a FSM.
		/// </summary>
		/// <param name="anInput">An input symbol of a FSM.</param>
		public InputNotFoundException(IInput anInput) : base(anInput + " was not found!"){}
		
		/// <summary>
		/// anInput cannot be found in a FSM.
		/// </summary>
		/// <param name="anInput">Name of an input symbol of a FSM.</param>
		public InputNotFoundException(string anInput) : base(anInput + " was not found!"){}
	}
}
