// 
// Palladio Interface
// $Id$
//
using System;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// An attached role is a combination consisting of a component and a role. It is
	/// used to describe a role attached to a component from an external point of view, e.g.
	/// for usage in a connection specification.
	/// </summary>
	/// <remarks><pre>
	/// $Log$
	/// Revision 1.3  2004/06/09 12:36:30  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
	/// Revision 1.2  2004/06/02 19:41:31  sbecker
	/// Fixed docu
	///
	/// Revision 1.1  2004/06/02 14:50:24  sbecker
	/// Initial Import after a major rework
	///
	///
	/// </pre></remarks>
	public interface IAttachedRole
	{
		/// <summary>
		/// ID of the role attached
		/// </summary>
		IIdentifier RoleID
		{
			get;
		}

		/// <summary>
		/// ID of the component to which the role is attached to
		/// </summary>
		IIdentifier ComponentID
		{
			get;
		}

		/// <summary>
		/// Component to which the role is attached to
		/// </summary>
		IComponent Component
		{
			get;
		}

		/// <summary>
		/// The attached role
		/// </summary>
		IRole Role
		{
			get;
		}
	}
}
