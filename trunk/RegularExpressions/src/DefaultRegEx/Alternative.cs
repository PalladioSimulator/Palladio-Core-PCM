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

namespace Palladio.RegularExpressions.DefaultRegEx
{
	/// <summary>
	/// </summary>
	internal class Alternative : AbstractRegEx, IAlternative
	{
		private IRegEx alternativeOne;
		private IRegEx alternativeTwo;

		public Alternative(AttributeHash attributeHash, IRegEx alternativeOne, IRegEx alternativeTwo) : base(attributeHash)
		{
			this.alternativeOne = alternativeOne;
			this.alternativeTwo = alternativeTwo;
		}

		public IRegEx AlternativeOne
		{
			get { return alternativeOne; }
		}

		public IRegEx AlternativeTwo
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
				IAlternative alt = (IAlternative) obj;
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