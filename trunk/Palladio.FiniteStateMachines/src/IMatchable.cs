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
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
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
