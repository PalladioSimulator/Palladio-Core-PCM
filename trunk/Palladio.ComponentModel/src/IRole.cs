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
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre></remarks>
	public interface IRole : IIdentifiable,ICloneable
	{
		/// <summary>
		/// A name which describes the role
		/// </summary>
		string Name
		{
			get;
			set;
		}

		/// <summary>
		/// The interface attached to a role
		/// </summary>
		IInterfaceModel Interface
		{
			get;
		}

		/// <summary>
		/// The component to which the role is attached to
		/// </summary>
		IComponent Component
		{
			get;
		}
	}
}
