using System;

namespace Palladio.FiniteStateMachines.Exceptions
{
	/// <summary>
	/// This Exception is thrown, if a transition is expected and cannot be found.
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
	public class TransitionNotFoundException : ApplicationException
	{
		/// <summary>
		/// This Exception is thrown, if a transition is expected and cannot be found.
		/// </summary>
		/// <param name="aTrans">Hidden transition.</param>
		public TransitionNotFoundException(ITransition aTrans) : base(aTrans + " was not found!"){}
	}
}
