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
using Palladio.FiniteStateMachines;

namespace Palladio.RegularExpressions
{
	/// <summary>
	/// Regular expression of a single input symbol.
	/// </summary>
	public interface ISymbol : IRegEx
	{
		IInput InputSymbol { get; }
	}
}