using System;
using System.Collections;
using Palladio.Utils.Collections;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// IParameter contains the information describing a parameter
	/// of a signature. It consits of a parameter name and a parameter type.
	/// </summary>
	public interface IParameter : ICloneable 
	{
		#region Properties
		/// <summary>
		/// Name of the parameter.
		/// </summary>
		string Name { get; }

		/// <summary>
		/// Type of the parameter.
		/// </summary>
		IType Type { get; }

		/// <summary>
		/// Modifier of the parameter. A modifier specifices the way of passing the
		/// parameter to the method body.
		/// </summary>
		ParameterModifierEnum Modifier { get; }

		#endregion
	}
}
