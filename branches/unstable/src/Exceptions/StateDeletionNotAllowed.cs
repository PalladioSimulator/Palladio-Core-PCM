using System;

namespace Palladio.FiniteStateMachines.Exceptions {
	/// <summary>
	/// This Exception is thrown, if the deletion of a state is not allowed.
	/// Incoming or outgoing transitions of the state are usually the reason for that.
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
	public class StateDeletionNotAllowed : ApplicationException 
	{	
		/// <summary>
		/// This Exception is thrown, if the deletion of a state is not allowed.
		/// Incoming or outgoing transitions of the state are usually the reason for that.
		/// </summary>
		/// <param name="aState">State that couldn't be deleted.</param>
		public StateDeletionNotAllowed(IState aState) :
			base("Deletion of " + aState + " is not allowed!")
		{
		}
	}
}
