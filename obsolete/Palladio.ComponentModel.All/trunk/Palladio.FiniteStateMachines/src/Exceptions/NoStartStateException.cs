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
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
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
