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
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
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
