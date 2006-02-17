using System;
using System.Collections;
using Palladio.Utils.Collections;
using System.Reflection;
using Palladio.FiniteStateMachines;
using Palladio.Attributes;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Specifies the way how a parameter is passed to the method body.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/05/24 15:20:44  sliver
	/// added cvs log
	///
	/// </pre>
	/// </remarks>
	public enum ParameterModifierEnum
	{
		NONE, OUT, REF
	}
}
