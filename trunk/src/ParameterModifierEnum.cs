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
	public enum ParameterModifierEnum
	{
		NONE, OUT, REF
	}
}
