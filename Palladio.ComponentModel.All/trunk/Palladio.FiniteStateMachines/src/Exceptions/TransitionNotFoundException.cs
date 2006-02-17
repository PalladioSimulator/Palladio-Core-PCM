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
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
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
