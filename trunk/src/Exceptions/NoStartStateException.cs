using System;

namespace Palladio.FiniteStateMachines.Exceptions
{
	/// <summary>
	/// This exception is thrown, if a FSM has no start state and the start state
	/// is required.
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
	public class NoStartStateException : ApplicationException
	{
		/// <summary>
		/// This exception is thrown, if a FSM has no start state and the start state
		/// is required.
		/// </summary>
		public NoStartStateException() : base("No start state defined"){}
	}
}
