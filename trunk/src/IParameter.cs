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
		/// Parameter name.
		/// </summary>
		string Name { get; }

		/// <summary>
		/// Parameter Type.
		/// </summary>
		IType Type { get; }

		ParameterModifier Modifier { get; }

		#endregion
	}
}
