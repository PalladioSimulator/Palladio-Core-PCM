/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/12/15 00:05:14  sliver
 * initial checkin after some major refactorings
 *
 * Revision 1.1  2004/11/04 08:52:14  sliver
 * added regular expressions
 *
 */
namespace Palladio.RegularExpressions
{
	/// <summary>
	/// Sequence / concatenation of two regular expressions R1 and R2: <c>R1R2</c>.
	/// </summary>
	public interface ISequence : IRegEx
	{
		/// <summary>
		/// Expression R1 in sequence R1R2.
		/// </summary>
		IRegEx Predecessor { get; }

		/// <summary>
		/// Expression R2 in sequence R1R2.
		/// </summary>
		IRegEx Successor { get; }
	}
}