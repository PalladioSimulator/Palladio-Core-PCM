/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/11/04 08:52:14  sliver
 * added regular expressions
 *
 */
using System;

namespace Palladio.Reliability.Regex
{
	/// <summary>
	/// </summary>
	public interface ISequence : IRegex
	{
		IRegex Predecessor {get;}
		IRegex Successor {get;}
	}
}
