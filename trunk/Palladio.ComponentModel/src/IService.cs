// 
// Palladio Interface
// $Id$
//
using System;
using Palladio.Identifier;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// IService represents a service. It is used to describe a service that is required by 
	/// a service effect specification. It holds the signature of the service and the interface 
	/// it belongs to.
	/// </summary>
	/// <remarks><pre>
	/// $Log$
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre></remarks>
	public interface IService : ICloneable, IMatchable, ISerializable, IIdentifiable
	{
		/// <summary>
		/// The signature
		/// </summary>
		ISignature Signature
		{
			get;
		}

		/// <summary>
		/// The interface
		/// </summary>
		IInterfaceModel Interface
		{
			get;
		}
	}
}
