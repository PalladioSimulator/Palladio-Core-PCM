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
 * Revision 1.1  2004/11/04 08:52:14  sliver
 * added regular expressions
 *
 */
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace Palladio.RegularExpressions.DefaultRegEx
{
	/// <summary>
	/// </summary>
	internal class Symbol : AbstractRegEx, ISymbol
	{
		private IInput inputSymbol;

		public Symbol(AttributeHash attributeHash, IInput inputSymbol) : base(attributeHash)
		{
			this.inputSymbol = inputSymbol;
		}

		public IInput InputSymbol
		{
			get { return inputSymbol; }
		}

		public override string ToString()
		{
			return inputSymbol.ToString();
		}

		public override bool Equals(object obj)
		{
			if (obj is ISymbol)
			{
				ISymbol sym = (ISymbol) obj;
				return inputSymbol.Equals(sym.InputSymbol);
			}
			return false;
		}

		public override int GetHashCode()
		{
			return inputSymbol.GetHashCode();
		}
	}
}