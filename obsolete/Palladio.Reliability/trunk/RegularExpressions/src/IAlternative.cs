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
	/// Alternative / union of two regular expressions: <c>R1 | R2</c>.
	/// </summary>
	public interface IAlternative : IRegEx
	{
		IRegEx AlternativeOne { get; }
		IRegEx AlternativeTwo { get; }
	}
}