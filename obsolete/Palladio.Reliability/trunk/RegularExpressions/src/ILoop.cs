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
	/// Loop / Kleene star of a regular expression R: <c>R*</c>.
	/// </summary>
	public interface ILoop : IRegEx
	{
		/// <summary>
		/// Expression that is looped.
		/// </summary>
		IRegEx InnerExpression { get; }
	}
}