using System;

namespace Palladio.FiniteStateMachines.Exceptions 
{

	/// <summary>
	/// This exception is thrown if an input symbol cannot be deleted. This
	/// is the case, if it is used in a transition.
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
	public class InputDeletionNotAllowedException : ApplicationException 
	{	

		/// <summary>
		/// anInput cannot be deleted.
		/// </summary>
		/// <param name="anInput">An input symbole of a FSM.</param>
		public InputDeletionNotAllowedException(IInput anInput) :
			base("Deletion of " + anInput + " is not allowed!")
		{
		}
	}
}
