/*
 * $Id$
 * 
 * $Log$
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

namespace Palladio.RegularExpressions.DefaultRegEx
{
	/// <summary>
	/// </summary>
	internal class Sequence : AbstractRegEx, ISequence
	{
		private IRegEx predecessor;
		private IRegEx successor;

		public Sequence(IAttributeHash attributeHash, IRegEx predecessor, IRegEx successor) : base(attributeHash)
		{
			this.predecessor = predecessor;
			this.successor = successor;
		}

		public IRegEx Predecessor
		{
			get { return predecessor; }
		}

		public IRegEx Successor
		{
			get { return successor; }
		}

		public override string ToString()
		{
			return GenerateSubString(predecessor) + GenerateSubString(successor);
		}

		private string GenerateSubString(IRegEx expr)
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
				ISequence seq = (ISequence) obj;
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