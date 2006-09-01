using System;
using System.Collections;
using Palladio.Utils.Collections;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// IParameter contains the information describing a parameter
	/// of a signature. It consists of a name, a type and a modifier.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2004/05/24 15:20:44  sliver
	/// added cvs log
	///
	/// </pre>
	/// </remarks>
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
