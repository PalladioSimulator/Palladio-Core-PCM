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

namespace Palladio.RegularExpressions.DefaultRegEx
{
	/// <summary>
	/// </summary>
	internal class Loop : AbstractRegEx, ILoop
	{
		private IRegEx innerExpression;

		public Loop(AttributeHash attributeHash, IRegEx innerExpression) : base(attributeHash)
		{
			this.innerExpression = innerExpression;
		}

		public IRegEx InnerExpression
		{
			get { return innerExpression; }
		}

		public override string ToString()
		{
			return GenerateSubString(innerExpression) + "*";
		}

		private string GenerateSubString(IRegEx regEx)
		{
			if ((regEx is ISequence) || (regEx is IAlternative))
				return "(" + regEx.ToString() + ")";
			return regEx.ToString();
		}

		public override bool Equals(object obj)
		{
			if (obj is ILoop)
			{
				ILoop loop = (ILoop) obj;
				return InnerExpression.Equals(loop.InnerExpression);
			}
			return false;
		}

		public override int GetHashCode()
		{
			return innerExpression.GetHashCode() + "*".GetHashCode();
		}
	}
}