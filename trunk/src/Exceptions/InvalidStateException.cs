using System;

namespace Palladio.FiniteStateMachines.Exceptions
{

	/// <summary>
	/// This exception is throw, if a state is not allowed for a FSM.
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
	public class InvalidStateException : ApplicationException
	{
		/// <summary>
		/// aState is not allowed for a FSM.
		/// </summary>
		/// <param name="aState">A state of a FSM.</param>
		public InvalidStateException(IState aState) : base(aState + " is not allowed here!"){}
	}
}
