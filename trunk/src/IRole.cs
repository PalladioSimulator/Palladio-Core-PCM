// 
// Palladio Interface
// $Id$
//
using System;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A role is the logical construct which identifies a single component interface uniquely.
	/// This is needed as a signature alone is not sufficient as two component interfaces
	/// can contain the same signature... <br />
	/// Example: A component provides interfaces P1 and P2 and each of these contains a signature
	/// void A(void). Then only P1.A or P2.A is a unique specification of the signatures. In this case
	/// P1 and P2 are called roles.
	/// 
	/// </summary>
	/// <remarks><pre>
	/// $Log$
	/// Revision 1.2  2004/06/02 19:41:31  sbecker
	/// Fixed docu
	///
	/// Revision 1.1  2004/06/02 14:50:24  sbecker
	/// Initial Import after a major rework
	///
	///
	/// </pre></remarks>
	public interface IRole : IIdentifiable, ICloneable
	{
		/// <summary>
		/// The interface attached to a component
		/// </summary>
		IInterfaceModel Interface
		{
			get;
		}
	}
}
