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
using System.Text.RegularExpressions;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace Palladio.RegularExpressions
{
	/// <summary>
	/// Syntax tree of a regular expression. Follows the composite pattern.
	/// </summary>
	public interface IRegEx : IInput, IMatchable, IAttributable
	{
		/// <summary>
		/// The actual regular expression encoded in the syntax tree.
		/// </summary>
		Regex Expression { get; }

		/// <summary>
		/// Simplifies the regular expression.
		/// </summary>
		void Simplify();

		/// <summary>
		/// True, if this expression accepts <c>word</c>,
		/// false otherwise.
		/// </summary>
		bool Accept(params IInput[] word);
	}
}