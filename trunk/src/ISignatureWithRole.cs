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
	/// An external signature specification consists of a role ID and a signature.
	/// </summary>
	/// <remarks><pre>
	/// $Log$
	/// Revision 1.4  2004/06/09 12:36:30  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
	/// Revision 1.3  2004/06/03 14:37:28  sbecker
	/// Added the possibility to attach auxiliary specifications to a basic component
	///
	/// Revision 1.2  2004/06/02 19:41:31  sbecker
	/// Fixed docu
	///
	/// Revision 1.1  2004/06/02 14:50:24  sbecker
	/// Initial Import after a major rework
	///
	///
	/// </pre></remarks>
	public interface IExternalSignature : ICloneable, IMatchable
	{
		/// <summary>
		/// The signature
		/// </summary>
		ISignature Signature
		{
			get;
		}

		/// <summary>
		/// The external role used to identify the signature uniquely
		/// </summary>
		IIdentifier RoleID
		{
			get;
		}
	}
}
