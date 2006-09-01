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
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
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
