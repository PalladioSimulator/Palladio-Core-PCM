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
	internal class Alternative : Regex, IAlternative
	{
		private IRegex alternativeOne;
		private IRegex alternativeTwo;

		public Alternative(IAttributeHash attributeHash, IRegex alternativeOne, IRegex alternativeTwo) : base(attributeHash)
		{
			this.alternativeOne = alternativeOne;
			this.alternativeTwo = alternativeTwo;
		}

		public IRegex AlternativeOne
		{
			get { return alternativeOne; }
		}

		public IRegex AlternativeTwo
		{
			get { return alternativeTwo; }
		}

		public override string ToString()
		{
			return alternativeOne.ToString() + "|" + alternativeTwo.ToString();
		}

		public override bool Equals(object obj)
		{
			if (obj is IAlternative)
			{
				IAlternative alt = (IAlternative)obj;
				return AlternativeOne.Equals(alt.AlternativeOne) && AlternativeTwo.Equals(alt.AlternativeTwo);
			}
			return false;
		}

		public override int GetHashCode()
		{
			return AlternativeOne.GetHashCode() ^ "|".GetHashCode() ^ AlternativeTwo.GetHashCode();
		}
	}
}
