/*
 * $Id$
 * 
 * $Log$
 * Revision 1.2  2005/04/14 12:54:01  sliver
 * Adjusted to the current version of the *unstable* tree of the component model
 *
 * Revision 1.1  2004/12/15 00:05:14  sliver
 * initial checkin after some major refactorings
 *
 * Revision 1.2  2004/11/08 03:50:06  sliver
 * *** empty log message ***
 *
 * Revision 1.1  2004/11/04 08:52:14  sliver
 * added regular expressions
 *
 */
using Palladio.Attributes;
using Palladio.FiniteStateMachines;
using Palladio.RegularExpressions.DefaultRegEx;
using Palladio.RegularExpressions.GNFA;

namespace Palladio.RegularExpressions
{
	/// <summary>
	/// Factory for creating regular expressions with attributes.
	/// </summary>
	public class RegexFactory
	{
		/// <summary>
		/// Returns a regular expression that accepts the same language as
		/// the FSM.
		/// </summary>
		/// <param name="fsm"></param>
		/// <returns></returns>
		public static IRegEx FSMToRegex(IFiniteStateMachine fsm)
		{
			return FSMToRegexConverter.Convert(fsm);
		}


		/// <summary>
		/// Creates a new alternative / union.
		/// </summary>
		/// <param name="regExOne"></param>
		/// <param name="regExTwo"></param>
		/// <returns></returns>
		public static IAlternative Alternative(IRegEx regExOne, IRegEx regExTwo)
		{
			return new Alternative(CreateAttributeHash(), regExOne, regExTwo);
		}

		/// <summary>
		/// Creates a new alternative / union.
		/// </summary>
		/// <param name="attributeHash"></param>
		/// <param name="regExOne"></param>
		/// <param name="regExTwo"></param>
		/// <returns></returns>
		public static IAlternative Alternative(AttributeHash attributeHash, IRegEx regExOne, IRegEx regExTwo)
		{
			return new Alternative(attributeHash, regExOne, regExTwo);
		}

		/// <summary>
		/// Creates a sequence  / concatenation.
		/// </summary>
		/// <param name="regExOne"></param>
		/// <param name="regExTwo"></param>
		/// <returns></returns>
		public static ISequence Sequence(IRegEx regExOne, IRegEx regExTwo)
		{
			return new Sequence(CreateAttributeHash(), regExOne, regExTwo);
		}

		/// <summary>
		/// Creates a sequence  / concatenation.
		/// </summary>
		/// <param name="attributeHash"></param>
		/// <param name="regExOne"></param>
		/// <param name="regExTwo"></param>
		/// <returns></returns>
		public static ISequence Sequence(AttributeHash attributeHash, IRegEx regExOne, IRegEx regExTwo)
		{
			return new Sequence(attributeHash, regExOne, regExTwo);
		}

		/// <summary>
		/// Creates a loop / Kleene star.
		/// </summary>
		/// <param name="regEx"></param>
		/// <returns></returns>
		public static ILoop Loop(IRegEx regEx)
		{
			return new Loop(CreateAttributeHash(), regEx);
		}

		/// <summary>
		/// Creates a loop / Kleene star.
		/// </summary>
		/// <param name="attributeHash"></param>
		/// <param name="regEx"></param>
		/// <returns></returns>
		public static ILoop Loop(AttributeHash attributeHash, IRegEx regEx)
		{
			return new Loop(attributeHash, regEx);
		}

		/// <summary>
		/// Creates a new symbol from an input symbol.
		/// </summary>
		/// <param name="inputSymbol"></param>
		/// <returns></returns>
		public static ISymbol Symbol(IInput inputSymbol)
		{
			return new Symbol(CreateAttributeHash(), inputSymbol);
		}

		/// <summary>
		/// Creates a new symbol from an input symbol and associated attributeHash to it.
		/// </summary>
		/// <param name="attributeHash"></param>
		/// <param name="inputSymbol"></param>
		/// <returns></returns>
		public static ISymbol Symbol(AttributeHash attributeHash, IInput inputSymbol)
		{
			return new Symbol(attributeHash, inputSymbol);
		}

		/// <summary>
		/// Creates an empty attribute hash.
		/// </summary>
		/// <returns></returns>
		private static AttributeHash CreateAttributeHash()
		{
			return AttributesFactory.Default.CreateAttributeHash();
		}
	}
}