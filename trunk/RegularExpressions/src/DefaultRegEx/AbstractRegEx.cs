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
using System;
using System.Text.RegularExpressions;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace Palladio.RegularExpressions.DefaultRegEx
{
	/// <summary>
	/// </summary>
	internal abstract class AbstractRegEx : IRegEx
	{
		public AbstractRegEx(AttributeHash attributeHash)
		{
			this.attributeHash = attributeHash;
		}

		/// <summary>
		/// A match is a more specialised comparison of two objects.
		/// </summary>
		/// <param name="other">Another object which should be matched.</param>
		/// <returns>True, if this object an the other object match, false otherwise.</returns>
		public bool Match(IMatchable other)
		{
			return this.Equals(other);
		}

		/// <summary>
		/// A list of attributes attached an object. 
		/// </summary>
		public AttributeHash Attributes
		{
			get { return attributeHash; }
		}

		public IMatchable ID
		{
			get { return this; }
		}

		private AttributeHash attributeHash;

		/// <summary>
		/// Added for further development. 
		/// </summary>
		public Regex Expression
		{
			get { throw new NotImplementedException(); }
		}

		/// <summary>
		/// Added for further development. 
		/// </summary>
		public void Simplify()
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// Added for further development. 
		/// </summary>
		public bool Accept(params IInput[] word)
		{
			throw new NotImplementedException();
		}
	}
}