/*
 * $Id$
 * 
 * $Log$
 * Revision 1.2  2004/11/08 03:50:06  sliver
 * *** empty log message ***
 *
 * Revision 1.1  2004/11/04 08:52:14  sliver
 * added regular expressions
 *
 */
using System;
using Palladio.Attributes;
using Palladio.Reliability.Regex;

namespace Palladio.Reliability.Regex.DefaultRegex
{
	/// <summary>
	/// </summary>
	internal class Sequence : Regex, ISequence
	{
		private IRegex predecessor;
		private IRegex successor;

		public Sequence(IAttributeHash attributeHash, IRegex predecessor, IRegex successor) : base(attributeHash)
		{
			this.predecessor = predecessor;
			this.successor = successor;
		}

		public IRegex Predecessor
		{
			get { return predecessor; }
		}

		public IRegex Successor
		{
			get { return successor; }
		}

		public override string ToString()
		{
			return GenerateSubString(predecessor) + GenerateSubString(successor);
		}

		private string GenerateSubString(IRegex expr)
		{
			if (expr is IAlternative)
				return "(" + expr.ToString() + ")";
			else 
				return expr.ToString();
		}

		public override bool Equals(object obj)
		{
			if (obj is ISequence)
			{
				ISequence seq = (ISequence)obj;
				return Predecessor.Equals(seq.Predecessor) && Successor.Equals(seq.Successor);
			}
			return false;
		}

		public override int GetHashCode()
		{
			return Predecessor.GetHashCode() ^ Successor.GetHashCode();
		}

	}
}
