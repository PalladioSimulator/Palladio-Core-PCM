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
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
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
