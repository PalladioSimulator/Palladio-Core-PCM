using System;
using Palladio.Identifier;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

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
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface ISignature : IMatchable, IAttributable, IIdentifiable, ICloneable
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

		#endregion

	}
}
