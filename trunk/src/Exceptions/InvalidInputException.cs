using System;
using System.Collections;
using Palladio.Utils.Collections;

namespace Palladio.FiniteStateMachines.Exceptions
{
	/// <summary>
	/// This exception is thrown, if the input symbol is not allowed.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/05/12 13:33:45  sliver
	/// Comments for the exceptions added
	///
	/// Revision 1.2  2004/05/12 12:54:33  sliver
	/// Comments for the exceptions added
	///
	/// </pre>
	/// </remarks>
	public class InvalidInputException : Exception
	{
		/// <summary>
		/// anInput is not allowed here.
		/// </summary>
		/// <param name="anInput">An input symbole of a FSM.</param>
		public InvalidInputException(IInput anInput) : base(anInput + " is not allowed here!") {}
	}
}
