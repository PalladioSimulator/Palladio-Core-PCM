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
	internal abstract class Regex : IRegex
	{
		public Regex(IAttributeHash attributeHash)
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
		public IAttributeHash Attributes
		{
			get { return attributeHash; }
		}

		public IMatchable ID
		{
			get { return this; }
		}
		
		private IAttributeHash attributeHash;
	}
}
