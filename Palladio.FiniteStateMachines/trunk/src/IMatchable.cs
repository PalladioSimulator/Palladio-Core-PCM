using System;

namespace Palladio.FiniteStateMachines 
{
	/// <summary>
	/// A common interface for all object which need a more specified matching than 
	/// provided by the default equals method.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/05/13 15:03:46  sliver
	/// IMatchable Interface added
	///
	/// </pre>
	/// </remarks>
	public interface IMatchable 
	{
		/// <summary>
		/// A match is a more specialised comparison of two objects.
		/// </summary>
		/// <param name="other">Another object which should be matched.</param>
		/// <returns>True, if this object an the other object match, false otherwise.</returns>
		bool Match(IMatchable other);
	}
}
