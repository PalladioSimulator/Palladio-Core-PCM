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
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
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
