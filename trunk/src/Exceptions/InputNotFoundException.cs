using System;

namespace Palladio.FiniteStateMachines.Exceptions
{

	/// <summary>
	/// This exception is thrown, if anInput is required in an FSM, but it cannot
	/// be found. 
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
	public class InputNotFoundException : ApplicationException
	{
		/// <summary>
		/// anInput cannot be found in a FSM.
		/// </summary>
		/// <param name="anInput">An input symbol of a FSM.</param>
		public InputNotFoundException(IInput anInput) : base(anInput + " was not found!"){}
	}
}
