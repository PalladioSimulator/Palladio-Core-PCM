using System;
using System.Collections;
using Utils.Collections;
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
		string Name { set; get; }

		/// <summary>
		/// Parameter Type.
		/// </summary>
		IType Type { set; get; }

		#endregion
	}
}
