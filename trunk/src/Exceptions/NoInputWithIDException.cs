using System;

namespace Palladio.FiniteStateMachines.Exceptions
{
	/// <summary>
	/// No input symbol with the anInputID exists in the FSM.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/05/13 15:03:46  sliver
	/// IMatchable Interface added
	///
	/// Revision 1.2  2004/05/12 12:54:33  sliver
	/// Comments for the exceptions added
	///
	/// </pre>
	/// </remarks>
	public class NoInputWithIDException : ApplicationException
	{
		/// <summary>
		/// No input symbol with the anInputID exists in the FSM.
		/// </summary>
		/// <param name="anInputID">Requested ID.</param>
		public NoInputWithIDException(IMatchable anInputID) : base("No input with ID " + anInputID + " found!"){}
	}
}
