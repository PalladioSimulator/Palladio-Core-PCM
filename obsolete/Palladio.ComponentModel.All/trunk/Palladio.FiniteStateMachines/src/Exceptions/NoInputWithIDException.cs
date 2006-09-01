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
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
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
