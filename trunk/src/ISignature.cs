using System;
using System.Collections;
using Palladio.Utils.Collections;
using System.Reflection;
using Palladio.FiniteStateMachines;
using Palladio.Attributes;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A Signature describes the structure of a method, function or
	/// procedure.
	/// </summary>
	public interface ISignature : ICloneable, IMatchable
	{
		#region Properties

		/// <summary>
		/// The name of the signature without any additional
		/// information like the return type or parameters.
		/// </summary>
		string Name { get; }

		/// <summary>
		/// Type of the return value. If no return type is
		/// given, 'void' is returned.
		/// </summary>
		IType ReturnType { get; }

		/// <summary>
		/// Parameters required by this signature. If
		/// no parameters are needed Parameters is set to 'null'.
		/// </summary>
		IParameter[] Parameters { get; }

		IType[] Exceptions { get; }

		string RoleID { get; }

		IAttributeHash Attributes { get; }

		#endregion

	}
}
