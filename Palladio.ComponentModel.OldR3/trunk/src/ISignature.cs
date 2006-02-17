using System;
using System.Collections;
using Palladio.Utils.Collections;
using System.Reflection;
using Palladio.FiniteStateMachines;
using Palladio.Attributes;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A Signature describes the calling conventions of a service.
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
	public interface ISignature : ICloneable, IMatchable, IAttributable
	{
		#region Properties

		/// <summary>
		/// The plain name of the signature.
		/// </summary>
		string Name { get; }

		/// <summary>
		/// Type of the return value. 
		/// </summary>
		IType ReturnType { get; }

		/// <summary>
		/// Parameters required by this signature. 
		/// </summary>
		IParameter[] Parameters { get; }

		/// <summary>
		/// An unordered set of exceptions thrown by the methods implementing this signature.
		/// </summary>
		IType[] Exceptions { get; }

		/// <summary>
		/// The role this signature belongs to.
		/// </summary>
		string RoleID { get; }

		#endregion

	}
}
