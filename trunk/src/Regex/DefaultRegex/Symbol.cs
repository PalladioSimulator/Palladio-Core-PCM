/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/11/04 08:52:14  sliver
 * added regular expressions
 *
 */
using System;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;
using Palladio.Reliability.Regex;

namespace Palladio.Reliability.Regex.DefaultRegex
{
	/// <summary>
	/// </summary>
	internal class Symbol	: Regex, ISymbol
	{
		private IInput inputSymbol;

		public Symbol(IAttributeHash attributeHash, IInput inputSymbol) : base(attributeHash)
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
				ISymbol sym = (ISymbol)obj;
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
