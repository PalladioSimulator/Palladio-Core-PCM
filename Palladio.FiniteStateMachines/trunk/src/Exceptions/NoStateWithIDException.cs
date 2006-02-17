using System;

namespace Palladio.FiniteStateMachines.Exceptions
{
	/// <summary>
	/// This exception is thrown, if a FSM has no state with the requested ID.
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
	public class NoStateWithIDException : ApplicationException
	{
		/// <summary>
		/// This exception is thrown, if a FSM has no state with the requested ID.
		/// </summary>
		/// <param name="aStateID">Requested ID.</param>
		public NoStateWithIDException(string aStateID) : base("No state with ID " + aStateID + " found!"){}
	}
}
