using System;

namespace Palladio.FiniteStateMachines.Exceptions 
{
	/// <summary>
	/// This exception is thrown, if a deterministic behaviour is expected from a
	/// FSM and an indeterminism is detected.
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
	public class FsmNotDeterministicException : ApplicationException 
	{	
		/// <summary>
		/// The FSM is not deterministic for aState and anInput.
		/// </summary>
		/// <param name="aState">A state of a FSM.</param>
		/// <param name="anInput">An input symbol of a FSM.</param>
		public FsmNotDeterministicException(IState aState, IInput anInput) :
			base("Multiple Transitions possible from state " + aState + " whith the input symbol " + anInput + ".")
		{
		}
	}
}
