using System;
using System.Collections;
using Palladio.Identifier;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A Signature describes the calling conventions of a service.
	/// </summary>
	public interface ISignature : ICloneable, IMatchable, IAttributable, IIdentifiable, ISerializable
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
