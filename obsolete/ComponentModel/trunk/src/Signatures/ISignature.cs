using System;
using System.Collections;
using Utils.Collections;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A Signature describes the structure of a method, function or
	/// procedure.
	/// </summary>
	public interface ISignature : ICloneable 
	{
		#region Properties

		/// <summary>
		/// The name of the signature without any additional
		/// information like the return type or parameters.
		/// </summary>
		string Name { set; get; }

		/// <summary>
		/// Type of the return value. If no return type is
		/// given, 'void' is returned.
		/// </summary>
		IType ReturnType { set; get; }

		/// <summary>
		/// Parameters required by this signature. If
		/// no parameters are needed Parameters is set to 'null'.
		/// </summary>
		IParameter[] Parameters { set; get; }

		#endregion

	}
}
