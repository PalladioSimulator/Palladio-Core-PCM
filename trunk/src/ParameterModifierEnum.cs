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
		/// <summary>
		/// Parameter is unmodified
		/// </summary>
		NONE, 
		/// <summary>
		/// Parameter can be modified by the service
		/// </summary>
		OUT, 
		/// <summary>
		/// A value type is passed as reference instead of being passed by value
		/// </summary>
		REF
	}
}
