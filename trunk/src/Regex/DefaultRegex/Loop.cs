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
using Palladio.Reliability.Regex;

namespace Palladio.Reliability.Regex.DefaultRegex
{
	/// <summary>
	/// </summary>
	internal class Loop : Regex, ILoop
	{
		private IRegex innerExpression;

		public Loop(IAttributeHash attributeHash, IRegex innerExpression) : base(attributeHash)
		{
			this.innerExpression = innerExpression;
		}

		public IRegex InnerExpression
		{
			get { return innerExpression; }
		}

		public override string ToString()
		{
			return GenerateSubString(innerExpression)+"*";
		}

		private string GenerateSubString(IRegex regex)
		{
			if ((regex is ISequence) || (regex is IAlternative))
				return "(" + regex.ToString() + ")";
			return regex.ToString();
		}

		public override bool Equals(object obj)
		{
			if (obj is ILoop)
			{
				ILoop loop = (ILoop)obj;
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
