/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/11/04 08:52:14  sliver
 * added regular expressions
 *
 */
using System;
using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.Regex
{
	/// <summary>
	/// </summary>
	public interface ISymbol : IRegex
	{
		IInput InputSymbol {get;}
	}
}
